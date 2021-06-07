package com.argus.oth.bulk.load.background.task;

import com.argus.oth.email.EmailService;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.background.task.service.BackgroundTaskLocalServiceUtil;
import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskConstants;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskResult;
import com.liferay.portal.kernel.backgroundtask.BaseBackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.display.BackgroundTaskDisplay;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;

import java.io.Serializable;

import java.util.Map;

/**
 * @author Davy Duran
 */
public abstract class BaseBackgroundTask extends BaseBackgroundTaskExecutor {

	public static final String CONTEXT_KEY_AMA_CLAIM_FILE_NAME = "amAnalyticsClaimFileName";

	public static final String CONTEXT_KEY_AMA_DB_FILE_NAME = "amAnalyticsDbFileName";

	public static final String CONTEXT_KEY_AMA_TELEPHONY_FILE_NAME = "amAnalyticsTelephonyFileName";

	public static final String CONTEXT_KEY_AUTH_PROCEDURES_FILE_NAME = "authProceduresFileName";

	public static final String CONTEXT_KEY_AUTHORIZATIONS_FILE_NAME = "authorizationsFileName";

	public static final String CONTEXT_KEY_BATCH_SIZE = "batchSize";

	public static final String CONTEXT_KEY_CASES_FILE_NAME = "casesFileName";

	public static final String CONTEXT_KEY_CLAIM_ANALYTICS_FILE_NAME = "claimAnalyticsFileName";

	public static final String CONTEXT_KEY_CLAIM_DETAIL_FILE_NAME = "claimDetailFileName";

	public static final String CONTEXT_KEY_CLAIM_FILE_NAME = "claimFileName";

	public static final String CONTEXT_KEY_CLIENT_GROUP_FILE_NAME = "clientGroupFileName";

	public static final String CONTEXT_KEY_CLIENTS_FILE_NAME = "clientsFileName";

	public static final String CONTEXT_KEY_EXECUTION_GROUP_ID = "executionGroupId";

	public static final String CONTEXT_KEY_EXECUTION_USER = "executionUser";

	public static final String CONTEXT_KEY_EXECUTION_USER_ID = "executionUserId";

	public static final String CONTEXT_KEY_FTP_USER = "ftpUser";

	public static final String CONTEXT_KEY_LOCAL_PATH = "localPath";

	public static final String CONTEXT_KEY_MEMBER_FILE_NAME = "memberFileName";

	public static final String CONTEXT_KEY_NOTES_FILE_NAME = "notesFileName";

	public static final String CONTEXT_KEY_PASSWORD = "password";

	public static final String CONTEXT_KEY_PORT_NUMBER = "portNumber";

	public static final String CONTEXT_KEY_REFERENCE_TYPE_CODE_FILE_NAME = "referenceTypeCodeFileName";

	public static final String CONTEXT_KEY_REMOTE_FILE = "remoteFile";

	public static final String CONTEXT_KEY_REMOTE_FILE_FOLDER_NAME = "remoteFileFolderName";

	public static final String CONTEXT_KEY_REMOTE_FILE_UNZIP_PATH = "remoteFileUnzipPath";

	public static final String CONTEXT_KEY_TARGET_URL = "targetUrl";

	public static final String CONTEXT_KEY_TASKS_FILE_NAME = "tasksFileName";

	public static final String CONTEXT_KEY_VALIDATE_LINES = "validateLines";

	public static final int DEFAULT_BATCH_SIZE = 50;

	@Override
	public BackgroundTaskDisplay getBackgroundTaskDisplay(BackgroundTask backgroundTask) {
		return new BulkLoadBackgroundTaskDisplay(backgroundTask);
	}

	@Override
	public boolean isSerial() {
		return true;
	}

	protected BackgroundTaskResult createFailedResult(String message) {
		return createResult(BackgroundTaskConstants.STATUS_FAILED, message);
	}

	protected BackgroundTaskResult createResult(int status, String message) {
		BackgroundTaskResult result = new BackgroundTaskResult();

		result.setStatusMessage(message);
		result.setStatus(status);

		return result;
	}

	protected BackgroundTaskResult fail(Map<String, Serializable> contextMap, String message, EmailService emailService)
		throws PortalException {

		triggerNextTask(contextMap, DeleteFilesTask.class);

		_sendFailureEmail(emailService, message);

		return createFailedResult(message);
	}

	protected String getBulkLoadFilesPath(Map<String, Serializable> contextMap) {
		String remoteFileUnzipPath = GetterUtil.getString(
			contextMap.get(BaseBackgroundTask.CONTEXT_KEY_REMOTE_FILE_UNZIP_PATH));

		String remoteFileFolderName = GetterUtil.getString(
			contextMap.get(BaseBackgroundTask.CONTEXT_KEY_REMOTE_FILE_FOLDER_NAME));

		return remoteFileUnzipPath + remoteFileFolderName;
	}

	protected String getBulkLoadZipFilePath(Map<String, Serializable> contextMap) {
		String localFilePath = (String)contextMap.get(BaseBackgroundTask.CONTEXT_KEY_LOCAL_PATH);

		String remoteFileName = (String)contextMap.get(BaseBackgroundTask.CONTEXT_KEY_REMOTE_FILE);

		return localFilePath + remoteFileName;
	}

	protected void logError(String message) {
		if (log.isErrorEnabled()) {
			log.error(message);
		}
	}

	protected void logError(String message, Exception e) {
		if (log.isErrorEnabled()) {
			log.error(message, e);
		}
	}

	protected void logInfo(String message) {
		if (log.isInfoEnabled()) {
			log.info(message);
		}
	}

	protected void triggerNextTask(Map<String, Serializable> contextMap, Class<? extends BaseBackgroundTask> clazz)
		throws PortalException {

		long userId = GetterUtil.getLong(contextMap.get(BaseBackgroundTask.CONTEXT_KEY_EXECUTION_USER_ID));
		long groupId = GetterUtil.getLong(contextMap.get(BaseBackgroundTask.CONTEXT_KEY_EXECUTION_GROUP_ID));

		BackgroundTaskLocalServiceUtil.addBackgroundTask(
			userId, groupId, StringPool.BLANK, clazz.getName(), contextMap, new ServiceContext());
	}

	protected static final Log log = LogFactoryUtil.getLog(BaseBackgroundTask.class);

	private void _sendFailureEmail(EmailService emailService, String message) {
		try {
			emailService.sendEmail(
				"Bulk Load Failure", String.format("Bulk load failed. Reason: %s. See Liferay logs.", message));

			logInfo("Bulk load failure email sent");
		}
		catch (Exception e) {
			logError("Failed to send email alert", e);
		}
	}

}