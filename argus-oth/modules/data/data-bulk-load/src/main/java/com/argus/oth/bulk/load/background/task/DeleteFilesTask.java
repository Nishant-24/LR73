package com.argus.oth.bulk.load.background.task;

import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskResult;
import com.liferay.portal.kernel.util.FileUtil;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import java.util.Map;

import org.apache.commons.io.FileUtils;

import org.osgi.service.component.annotations.Component;

/**
 * @author Jaclyn Ong
 */
@Component(
	immediate = true,
	property = "background.task.executor.class.name=com.argus.oth.bulk.load.background.task.DeleteFilesTask",
	service = BackgroundTaskExecutor.class
)
public class DeleteFilesTask extends BaseBackgroundTask {

	@Override
	public BackgroundTaskExecutor clone() {
		return new DeleteFilesTask();
	}

	@Override
	public BackgroundTaskResult execute(BackgroundTask backgroundTask) {
		Map<String, Serializable> contextMap = backgroundTask.getTaskContextMap();

		_deleteBulkLoadFiles(contextMap);

		_deleteBulkLoadZipFile(contextMap);

		return BackgroundTaskResult.SUCCESS;
	}

	private void _deleteBulkLoadFiles(Map<String, Serializable> contextMap) {
		String bulkLoadFilesPath = getBulkLoadFilesPath(contextMap);

		logInfo("Deleting folder " + bulkLoadFilesPath);

		try {
			FileUtils.deleteDirectory(new File(bulkLoadFilesPath));
		}
		catch (IOException ioe) {
			logError("Failed to delete folder", ioe);

			return;
		}

		logInfo("Deleted folder");
	}

	private void _deleteBulkLoadZipFile(Map<String, Serializable> contextMap) {
		String bulkLoadZipFilePath = getBulkLoadZipFilePath(contextMap);

		String fileToDelete = "." + bulkLoadZipFilePath;

		logInfo("Deleting zip file " + fileToDelete);

		FileUtil.delete(fileToDelete);

		logInfo("Deleted zip file");
	}

}