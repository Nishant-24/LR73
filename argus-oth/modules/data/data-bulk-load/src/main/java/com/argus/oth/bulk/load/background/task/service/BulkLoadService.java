package com.argus.oth.bulk.load.background.task.service;

import com.argus.oth.bulk.load.background.task.BaseBackgroundTask;
import com.argus.oth.bulk.load.background.task.FileTransferTask;
import com.argus.oth.bulk.load.background.task.configuration.BulkLoadConfigurator;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.background.task.service.BackgroundTaskLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Davy Duran
 */
@Component(immediate = true, service = BulkLoadService.class)
public class BulkLoadService {

	public void startBulkLoadPipeLine() throws PortalException {
		User user = _getExecutionUser();

		_backgroundTaskLocalService.addBackgroundTask(
			user.getUserId(), user.getGroupId(), StringPool.BLANK, FileTransferTask.class.getName(),
			_getTaskContextMap(), new ServiceContext());
	}

	private User _getExecutionUser() {
		return _userLocalService.fetchUserByEmailAddress(
			PortalUtil.getDefaultCompanyId(), _bulkLoadConfigurator.executionUser());
	}

	private Map<String, Serializable> _getTaskContextMap() {
		Map<String, Serializable> taskContext = new HashMap<>();

		User user = _getExecutionUser();

		taskContext.put(
			BaseBackgroundTask.CONTEXT_KEY_AMA_CLAIM_FILE_NAME, _bulkLoadConfigurator.amAnalyticsClaimFileName());
		taskContext.put(BaseBackgroundTask.CONTEXT_KEY_AMA_DB_FILE_NAME, _bulkLoadConfigurator.amAnalyticsDbFileName());
		taskContext.put(
			BaseBackgroundTask.CONTEXT_KEY_AMA_TELEPHONY_FILE_NAME,
			_bulkLoadConfigurator.amAnalyticsTelephonyFileName());
		taskContext.put(
			BaseBackgroundTask.CONTEXT_KEY_AUTH_PROCEDURES_FILE_NAME, _bulkLoadConfigurator.authProceduresFileName());
		taskContext.put(
			BaseBackgroundTask.CONTEXT_KEY_AUTHORIZATIONS_FILE_NAME, _bulkLoadConfigurator.authorizationsFileName());
		taskContext.put(BaseBackgroundTask.CONTEXT_KEY_BATCH_SIZE, _bulkLoadConfigurator.batchSize());
		taskContext.put(BaseBackgroundTask.CONTEXT_KEY_CASES_FILE_NAME, _bulkLoadConfigurator.casesFileName());
		taskContext.put(
			BaseBackgroundTask.CONTEXT_KEY_CLAIM_ANALYTICS_FILE_NAME, _bulkLoadConfigurator.claimAnalyticsFileName());
		taskContext.put(
			BaseBackgroundTask.CONTEXT_KEY_CLAIM_DETAIL_FILE_NAME, _bulkLoadConfigurator.claimDetailFileName());
		taskContext.put(BaseBackgroundTask.CONTEXT_KEY_CLAIM_FILE_NAME, _bulkLoadConfigurator.claimFileName());
		taskContext.put(
			BaseBackgroundTask.CONTEXT_KEY_CLIENT_GROUP_FILE_NAME, _bulkLoadConfigurator.clientGroupFileName());
		taskContext.put(BaseBackgroundTask.CONTEXT_KEY_CLIENTS_FILE_NAME, _bulkLoadConfigurator.clientsFileName());
		taskContext.put(BaseBackgroundTask.CONTEXT_KEY_EXECUTION_GROUP_ID, user.getGroupId());
		taskContext.put(BaseBackgroundTask.CONTEXT_KEY_EXECUTION_USER, _bulkLoadConfigurator.executionUser());
		taskContext.put(BaseBackgroundTask.CONTEXT_KEY_EXECUTION_USER_ID, user.getUserId());
		taskContext.put(BaseBackgroundTask.CONTEXT_KEY_FTP_USER, _bulkLoadConfigurator.ftpUser());
		taskContext.put(BaseBackgroundTask.CONTEXT_KEY_LOCAL_PATH, _bulkLoadConfigurator.localPath());
		taskContext.put(BaseBackgroundTask.CONTEXT_KEY_MEMBER_FILE_NAME, _bulkLoadConfigurator.memberFileName());
		taskContext.put(BaseBackgroundTask.CONTEXT_KEY_NOTES_FILE_NAME, _bulkLoadConfigurator.notesFileName());
		taskContext.put(BaseBackgroundTask.CONTEXT_KEY_PASSWORD, _bulkLoadConfigurator.password());
		taskContext.put(BaseBackgroundTask.CONTEXT_KEY_PORT_NUMBER, _bulkLoadConfigurator.portNumber());
		taskContext.put(
			BaseBackgroundTask.CONTEXT_KEY_REFERENCE_TYPE_CODE_FILE_NAME,
			_bulkLoadConfigurator.referenceTypeCodeFileName());
		taskContext.put(BaseBackgroundTask.CONTEXT_KEY_REMOTE_FILE, _bulkLoadConfigurator.remoteFile());
		taskContext.put(
			BaseBackgroundTask.CONTEXT_KEY_REMOTE_FILE_FOLDER_NAME, _bulkLoadConfigurator.remoteFileFolderName());
		taskContext.put(
			BaseBackgroundTask.CONTEXT_KEY_REMOTE_FILE_UNZIP_PATH, _bulkLoadConfigurator.remoteFileUnzipPath());
		taskContext.put(BaseBackgroundTask.CONTEXT_KEY_TARGET_URL, _bulkLoadConfigurator.targetUrl());
		taskContext.put(BaseBackgroundTask.CONTEXT_KEY_TASKS_FILE_NAME, _bulkLoadConfigurator.tasksFileName());
		taskContext.put(BaseBackgroundTask.CONTEXT_KEY_VALIDATE_LINES, _bulkLoadConfigurator.validateLines());

		return taskContext;
	}

	@Reference
	private BackgroundTaskLocalService _backgroundTaskLocalService;

	@Reference
	private BulkLoadConfigurator _bulkLoadConfigurator;

	@Reference
	private UserLocalService _userLocalService;

}