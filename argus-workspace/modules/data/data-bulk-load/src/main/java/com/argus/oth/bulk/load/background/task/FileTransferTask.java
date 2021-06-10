package com.argus.oth.bulk.load.background.task;

import com.argus.oth.email.EmailService;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskResult;
import com.liferay.portal.kernel.util.FileUtil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Davy Duran
 */
@Component(
	immediate = true,
	property = "background.task.executor.class.name=com.argus.oth.bulk.load.background.task.FileTransferTask",
	service = BackgroundTaskExecutor.class
)
public class FileTransferTask extends BaseBackgroundTask {

	@Override
	public BackgroundTaskExecutor clone() {
		FileTransferTask fileTransferTask = new FileTransferTask();

		fileTransferTask.setEmailService(_emailService);

		return fileTransferTask;
	}

	@Override
	public BackgroundTaskResult execute(BackgroundTask backgroundTask) throws Exception {
		Map<String, Serializable> contextMap = backgroundTask.getTaskContextMap();

		File remoteFile = _transferFile(contextMap);

		if (Objects.isNull(remoteFile)) {
			return fail(contextMap, "Failed to transfer zip file", _emailService);
		}

		_unzipRemoteFile(remoteFile, contextMap);

		Map<String, Serializable> newContextMap = new HashMap<>(contextMap);

		newContextMap.put("randomString", String.valueOf(System.currentTimeMillis()));

		triggerNextTask(newContextMap, FileLoadTask.class);

		return BackgroundTaskResult.SUCCESS;
	}

	@Reference(unbind = "-")
	protected void setEmailService(EmailService emailService) {
		_emailService = emailService;
	}

	private FileOutputStream _getFileOutputStream(File f) throws FileNotFoundException {
		File parentFile = f.getParentFile();

		if (!parentFile.exists()) {
			parentFile.mkdirs();
		}

		logInfo("Transferring file to: " + f.getAbsolutePath());

		return new FileOutputStream(f);
	}

	private ChannelSftp _setupJSCH(String remoteHost, String username, String password, Integer portNumber)
		throws JSchException {

		JSch jsch = new JSch();

		Session jschSession = jsch.getSession(username, remoteHost, portNumber);

		jschSession.setConfig("StrictHostKeyChecking", "no");
		jschSession.setPassword(password);
		jschSession.connect();

		return (ChannelSftp)jschSession.openChannel(_SFTP);
	}

	private File _transferFile(Map<String, Serializable> contextMap) {
		String remoteHost = StringPool.BLANK;
		String sourceZipFilePath = StringPool.BLANK;
		String destinationZipFilePath = StringPool.BLANK;

		try {
			logInfo("Transferring file");

			remoteHost = (String)contextMap.get(BaseBackgroundTask.CONTEXT_KEY_TARGET_URL);

			destinationZipFilePath = getBulkLoadZipFilePath(contextMap);

			sourceZipFilePath = "./" + destinationZipFilePath;

			ChannelSftp channel = _setupJSCH(
				remoteHost, (String)contextMap.get(BaseBackgroundTask.CONTEXT_KEY_FTP_USER),
				(String)contextMap.get(BaseBackgroundTask.CONTEXT_KEY_PASSWORD),
				(Integer)contextMap.get(BaseBackgroundTask.CONTEXT_KEY_PORT_NUMBER));

			channel.connect();

			File remoteFile = new File(sourceZipFilePath);

			try (FileOutputStream fos = _getFileOutputStream(remoteFile)) {
				channel.get(destinationZipFilePath, fos);

				channel.exit();
			}

			logInfo("File transferred");

			return remoteFile;
		}
		catch (Exception ex) {
			log.error(
				String.format(
					"Error while transferring the sftp file from %s (%s) to %s.", remoteHost, sourceZipFilePath,
					destinationZipFilePath),
				ex);

			return null;
		}
	}

	private void _unzipRemoteFile(File file, Map<String, Serializable> contextMap) {
		File destination = new File(getBulkLoadFilesPath(contextMap));

		FileUtil.unzip(file, destination);

		logInfo("File unzipped");
	}

	private static final String _SFTP = "sftp";

	private EmailService _emailService;

}