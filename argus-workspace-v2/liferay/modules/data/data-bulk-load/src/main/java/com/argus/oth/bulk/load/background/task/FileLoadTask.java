package com.argus.oth.bulk.load.background.task;

import com.argus.oth.account.management.model.AMAnalyticsClaim;
import com.argus.oth.account.management.model.AMAnalyticsDB;
import com.argus.oth.account.management.model.AMAnalyticsTelephony;
import com.argus.oth.bulk.load.background.task.service.AMAClaimFileLoadStagingService;
import com.argus.oth.bulk.load.background.task.service.AMADbFileLoadStagingService;
import com.argus.oth.bulk.load.background.task.service.AMATelephonyFileLoadStagingService;
import com.argus.oth.bulk.load.background.task.service.AuthProcedureFileLoadStagingService;
import com.argus.oth.bulk.load.background.task.service.AuthorizationFileLoadStagingService;
import com.argus.oth.bulk.load.background.task.service.CasesFileLoadStagingService;
import com.argus.oth.bulk.load.background.task.service.ClaimAnalyticsFileLoadStagingService;
import com.argus.oth.bulk.load.background.task.service.ClaimDetailFileLoadStagingService;
import com.argus.oth.bulk.load.background.task.service.ClaimFileLoadStagingService;
import com.argus.oth.bulk.load.background.task.service.ClientFileLoadStagingService;
import com.argus.oth.bulk.load.background.task.service.ClientGroupFileLoadStagingService;
import com.argus.oth.bulk.load.background.task.service.LoadService;
import com.argus.oth.bulk.load.background.task.service.LoadServiceFactory;
import com.argus.oth.bulk.load.background.task.service.MemberFileLoadStagingService;
import com.argus.oth.bulk.load.background.task.service.NoteFileLoadStagingService;
import com.argus.oth.bulk.load.background.task.service.ReferenceTypeCodeFileLoadStagingService;
import com.argus.oth.bulk.load.background.task.service.TaskFileLoadStagingService;
import com.argus.oth.cases.management.model.AuthProcedure;
import com.argus.oth.cases.management.model.Authorization;
import com.argus.oth.cases.management.model.Cases;
import com.argus.oth.cases.management.model.Claim;
import com.argus.oth.cases.management.model.ClaimDetail;
import com.argus.oth.cases.management.model.Client;
import com.argus.oth.cases.management.model.ClientGroup;
import com.argus.oth.cases.management.model.Member;
import com.argus.oth.cases.management.model.Note;
import com.argus.oth.cases.management.model.ReferenceTypeCode;
import com.argus.oth.cases.management.model.Task;
import com.argus.oth.claim.model.ClaimAnalytics;
import com.argus.oth.email.EmailService;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskResult;
import com.liferay.portal.kernel.util.GetterUtil;

import java.io.Serializable;

import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Davy Duran
 */
@Component(
	immediate = true,
	property = "background.task.executor.class.name=com.argus.oth.bulk.load.background.task.FileLoadTask",
	service = BackgroundTaskExecutor.class
)
public class FileLoadTask extends BaseBackgroundTask {

	@Override
	public BackgroundTaskExecutor clone() {
		FileLoadTask fileLoadTask = new FileLoadTask();

		fileLoadTask.setAMAClaimFileLoadStagingService(_amaClaimFileLoadStagingService);
		fileLoadTask.setAMADbFileLoadStagingService(_amaDbFileLoadStagingService);
		fileLoadTask.setAMATelephonyFileLoadStagingService(_amaTelephonyFileLoadStagingService);
		fileLoadTask.setAuthorizationFileLoadStagingService(_authorizationFileLoadStagingService);
		fileLoadTask.setAuthProcedureFileLoadStagingService(_authProcedureFileLoadStagingService);
		fileLoadTask.setCasesFileLoadStagingService(_casesFileLoadStagingService);
		fileLoadTask.setClaimAnalyticsFileLoadStagingService(_claimAnalyticsFileLoadStagingService);
		fileLoadTask.setClaimDetailFileLoadStagingService(_claimDetailFileLoadStagingService);
		fileLoadTask.setClaimFileLoadStagingService(_claimFileLoadStagingService);
		fileLoadTask.setClientGroupFileLoadStagingService(_clientGroupFileLoadStagingService);
		fileLoadTask.setClientFileLoadStagingService(_clientFileLoadStagingService);
		fileLoadTask.setEmailService(_emailService);
		fileLoadTask.setMemberFileLoadStagingService(_memberFileLoadStagingService);
		fileLoadTask.setNoteFileLoadStagingService(_noteFileLoadStagingService);
		fileLoadTask.setReferenceTypeCodeFileLoadStagingService(_referenceTypeCodeFileLoadStagingService);
		fileLoadTask.setTaskFileLoadStagingService(_taskFileLoadStagingService);

		return fileLoadTask;
	}

	@Override
	public BackgroundTaskResult execute(BackgroundTask backgroundTask) throws Exception {
		Map<String, Serializable> contextMap = backgroundTask.getTaskContextMap();

		String randomString = GetterUtil.getString(contextMap.get("randomString"));

		boolean validateLines = GetterUtil.get(contextMap.get(BaseBackgroundTask.CONTEXT_KEY_VALIDATE_LINES), false);
		int batchSize = GetterUtil.get(
			contextMap.get(BaseBackgroundTask.CONTEXT_KEY_BATCH_SIZE), BaseBackgroundTask.DEFAULT_BATCH_SIZE);

		try {
			_loadFiles(contextMap, validateLines, batchSize);

			_loadData(randomString);
		}
		catch (Exception e) {
			logError(e.getMessage(), e);

			return fail(contextMap, e.getMessage(), _emailService);
		}
		finally {
			_cleanup();
		}

		triggerNextTask(contextMap, DeleteUnprocessedDataTask.class);

		return BackgroundTaskResult.SUCCESS;
	}

	private void _loadFiles(Map<String, Serializable> contextMap, boolean validateLines, int batchSize) throws Exception {
		_casesFileLoadStagingService.process(
			_getFileFullPath(contextMap, BaseBackgroundTask.CONTEXT_KEY_CASES_FILE_NAME), validateLines, batchSize);

		_clientFileLoadStagingService.process(
			_getFileFullPath(contextMap, BaseBackgroundTask.CONTEXT_KEY_CLIENTS_FILE_NAME), validateLines,
			batchSize);

		_noteFileLoadStagingService.process(
			_getFileFullPath(contextMap, BaseBackgroundTask.CONTEXT_KEY_NOTES_FILE_NAME), validateLines, batchSize);

		_taskFileLoadStagingService.process(
			_getFileFullPath(contextMap, BaseBackgroundTask.CONTEXT_KEY_TASKS_FILE_NAME), validateLines, batchSize);

		_memberFileLoadStagingService.process(
			_getFileFullPath(contextMap, BaseBackgroundTask.CONTEXT_KEY_MEMBER_FILE_NAME), validateLines,
			batchSize);

		_clientGroupFileLoadStagingService.process(
			_getFileFullPath(contextMap, BaseBackgroundTask.CONTEXT_KEY_CLIENT_GROUP_FILE_NAME), validateLines,
			batchSize);

		_referenceTypeCodeFileLoadStagingService.process(
			_getFileFullPath(contextMap, BaseBackgroundTask.CONTEXT_KEY_REFERENCE_TYPE_CODE_FILE_NAME),
			validateLines, batchSize);

		_authorizationFileLoadStagingService.process(
			_getFileFullPath(contextMap, BaseBackgroundTask.CONTEXT_KEY_AUTHORIZATIONS_FILE_NAME), validateLines,
			batchSize);

		_authProcedureFileLoadStagingService.process(
			_getFileFullPath(contextMap, BaseBackgroundTask.CONTEXT_KEY_AUTH_PROCEDURES_FILE_NAME), validateLines,
			batchSize);

		_claimFileLoadStagingService.process(
			_getFileFullPath(contextMap, BaseBackgroundTask.CONTEXT_KEY_CLAIM_FILE_NAME), validateLines, batchSize);

		_claimDetailFileLoadStagingService.process(
			_getFileFullPath(contextMap, BaseBackgroundTask.CONTEXT_KEY_CLAIM_DETAIL_FILE_NAME), validateLines,
			batchSize);

		_claimAnalyticsFileLoadStagingService.process(
			_getFileFullPath(contextMap, BaseBackgroundTask.CONTEXT_KEY_CLAIM_ANALYTICS_FILE_NAME), validateLines,
			batchSize);

		_amaClaimFileLoadStagingService.process(
			_getFileFullPath(contextMap, BaseBackgroundTask.CONTEXT_KEY_AMA_CLAIM_FILE_NAME), validateLines,
			batchSize);

		_amaDbFileLoadStagingService.process(
			_getFileFullPath(contextMap, BaseBackgroundTask.CONTEXT_KEY_AMA_DB_FILE_NAME), validateLines,
			batchSize);

		_amaTelephonyFileLoadStagingService.process(
			_getFileFullPath(contextMap, BaseBackgroundTask.CONTEXT_KEY_AMA_TELEPHONY_FILE_NAME), validateLines,
			batchSize);
	}

	@Reference(unbind = "-")
	protected void setAMAClaimFileLoadStagingService(AMAClaimFileLoadStagingService amaClaimFileLoadStagingService) {
		_amaClaimFileLoadStagingService = amaClaimFileLoadStagingService;
	}

	@Reference(unbind = "-")
	protected void setAMADbFileLoadStagingService(AMADbFileLoadStagingService amaDbFileLoadStagingService) {
		_amaDbFileLoadStagingService = amaDbFileLoadStagingService;
	}

	@Reference(unbind = "-")
	protected void setAMATelephonyFileLoadStagingService(
		AMATelephonyFileLoadStagingService amaTelephonyFileLoadStagingService) {

		_amaTelephonyFileLoadStagingService = amaTelephonyFileLoadStagingService;
	}

	@Reference(unbind = "-")
	protected void setAuthorizationFileLoadStagingService(
		AuthorizationFileLoadStagingService authorizationFileLoadStagingService) {

		_authorizationFileLoadStagingService = authorizationFileLoadStagingService;
	}

	@Reference(unbind = "-")
	protected void setAuthProcedureFileLoadStagingService(
		AuthProcedureFileLoadStagingService authProcedureFileLoadStagingService) {

		_authProcedureFileLoadStagingService = authProcedureFileLoadStagingService;
	}

	@Reference(unbind = "-")
	protected void setCasesFileLoadStagingService(CasesFileLoadStagingService casesFileLoadStagingService) {
		_casesFileLoadStagingService = casesFileLoadStagingService;
	}

	@Reference(unbind = "-")
	protected void setClaimAnalyticsFileLoadStagingService(
		ClaimAnalyticsFileLoadStagingService claimAnalyticsFileLoadStagingService) {

		_claimAnalyticsFileLoadStagingService = claimAnalyticsFileLoadStagingService;
	}

	@Reference(unbind = "-")
	protected void setClaimDetailFileLoadStagingService(
		ClaimDetailFileLoadStagingService claimDetailFileLoadStagingService) {

		_claimDetailFileLoadStagingService = claimDetailFileLoadStagingService;
	}

	@Reference(unbind = "-")
	protected void setClaimFileLoadStagingService(ClaimFileLoadStagingService claimFileLoadStagingService) {
		_claimFileLoadStagingService = claimFileLoadStagingService;
	}

	@Reference(unbind = "-")
	protected void setClientFileLoadStagingService(ClientFileLoadStagingService clientFileLoadStagingService) {
		_clientFileLoadStagingService = clientFileLoadStagingService;
	}

	@Reference(unbind = "-")
	protected void setClientGroupFileLoadStagingService(
		ClientGroupFileLoadStagingService clientGroupFileLoadStagingService) {

		_clientGroupFileLoadStagingService = clientGroupFileLoadStagingService;
	}

	@Reference(unbind = "-")
	protected void setEmailService(EmailService emailService) {
		_emailService = emailService;
	}

	@Reference(unbind = "-")
	protected void setMemberFileLoadStagingService(MemberFileLoadStagingService memberFileLoadStagingService) {
		_memberFileLoadStagingService = memberFileLoadStagingService;
	}

	@Reference(unbind = "-")
	protected void setNoteFileLoadStagingService(NoteFileLoadStagingService noteFileLoadStagingService) {
		_noteFileLoadStagingService = noteFileLoadStagingService;
	}

	@Reference(unbind = "-")
	protected void setReferenceTypeCodeFileLoadStagingService(
		ReferenceTypeCodeFileLoadStagingService referenceTypeCodeFileLoadStagingService) {

		_referenceTypeCodeFileLoadStagingService = referenceTypeCodeFileLoadStagingService;
	}

	@Reference(unbind = "-")
	protected void setTaskFileLoadStagingService(TaskFileLoadStagingService taskFileLoadStagingService) {
		_taskFileLoadStagingService = taskFileLoadStagingService;
	}

	private void _cleanup() {
		_casesFileLoadStagingService.cleanup();
		_clientFileLoadStagingService.cleanup();
		_noteFileLoadStagingService.cleanup();
		_taskFileLoadStagingService.cleanup();
		_memberFileLoadStagingService.cleanup();
		_clientGroupFileLoadStagingService.cleanup();
		_referenceTypeCodeFileLoadStagingService.cleanup();
		_authorizationFileLoadStagingService.cleanup();
		_authProcedureFileLoadStagingService.cleanup();
		_claimFileLoadStagingService.cleanup();
		_claimDetailFileLoadStagingService.cleanup();
		_claimAnalyticsFileLoadStagingService.cleanup();
		_amaClaimFileLoadStagingService.cleanup();
		_amaDbFileLoadStagingService.cleanup();
		_amaTelephonyFileLoadStagingService.cleanup();
	}

	private String _getFileFullPath(Map<String, Serializable> contextMap, String fileKey) {
		return getBulkLoadFilesPath(contextMap) + StringPool.SLASH + contextMap.get(fileKey);
	}

	private void _loadData(String randomString) throws Exception {
		LoadService<Client> clientLoadService = LoadServiceFactory.getLoadServiceByModelClass(Client.class.getName());
		LoadService<Cases> casesLoadService = LoadServiceFactory.getLoadServiceByModelClass(Cases.class.getName());
		LoadService<Note> noteLoadService = LoadServiceFactory.getLoadServiceByModelClass(Note.class.getName());
		LoadService<Task> taskLoadService = LoadServiceFactory.getLoadServiceByModelClass(Task.class.getName());
		LoadService<Member> memberLoadService = LoadServiceFactory.getLoadServiceByModelClass(Member.class.getName());
		LoadService<ClientGroup> clientGroupLoadService = LoadServiceFactory.getLoadServiceByModelClass(
			ClientGroup.class.getName());
		LoadService<ReferenceTypeCode> referenceTypeCodeLoadService = LoadServiceFactory.getLoadServiceByModelClass(
			ReferenceTypeCode.class.getName());
		LoadService<Authorization> authorizationLoadService = LoadServiceFactory.getLoadServiceByModelClass(
			Authorization.class.getName());
		LoadService<AuthProcedure> authProcedureLoadService = LoadServiceFactory.getLoadServiceByModelClass(
			AuthProcedure.class.getName());
		LoadService<Claim> claimLoadService = LoadServiceFactory.getLoadServiceByModelClass(Claim.class.getName());
		LoadService<ClaimDetail> claimDetailLoadService = LoadServiceFactory.getLoadServiceByModelClass(
			ClaimDetail.class.getName());
		LoadService<ClaimAnalytics> claimAnalyticsLoadService = LoadServiceFactory.getLoadServiceByModelClass(
			ClaimAnalytics.class.getName());
		LoadService<AMAnalyticsClaim> amAnalyticsClaimLoadService = LoadServiceFactory.getLoadServiceByModelClass(
			AMAnalyticsClaim.class.getName());
		LoadService<AMAnalyticsDB> amAnalyticsDBLoadService = LoadServiceFactory.getLoadServiceByModelClass(
			AMAnalyticsDB.class.getName());
		LoadService<AMAnalyticsTelephony> amAnalyticsTelephonyLoadService =
			LoadServiceFactory.getLoadServiceByModelClass(AMAnalyticsTelephony.class.getName());

		clientLoadService.loadData(randomString);
		casesLoadService.loadData(randomString);
		noteLoadService.loadData(randomString);
		taskLoadService.loadData(randomString);
		memberLoadService.loadData(randomString);
		clientGroupLoadService.loadData(randomString);
		referenceTypeCodeLoadService.loadData(randomString);
		authorizationLoadService.loadData(randomString);
		authProcedureLoadService.loadData(randomString);
		claimLoadService.loadData(randomString);
		claimDetailLoadService.loadData(randomString);
		claimAnalyticsLoadService.loadData(randomString);
		amAnalyticsClaimLoadService.loadData(randomString);
		amAnalyticsDBLoadService.loadData(randomString);
		amAnalyticsTelephonyLoadService.loadData(randomString);
	}

	private AMAClaimFileLoadStagingService _amaClaimFileLoadStagingService;
	private AMADbFileLoadStagingService _amaDbFileLoadStagingService;
	private AMATelephonyFileLoadStagingService _amaTelephonyFileLoadStagingService;
	private AuthorizationFileLoadStagingService _authorizationFileLoadStagingService;
	private AuthProcedureFileLoadStagingService _authProcedureFileLoadStagingService;
	private CasesFileLoadStagingService _casesFileLoadStagingService;
	private ClaimAnalyticsFileLoadStagingService _claimAnalyticsFileLoadStagingService;
	private ClaimDetailFileLoadStagingService _claimDetailFileLoadStagingService;
	private ClaimFileLoadStagingService _claimFileLoadStagingService;
	private ClientFileLoadStagingService _clientFileLoadStagingService;
	private ClientGroupFileLoadStagingService _clientGroupFileLoadStagingService;
	private EmailService _emailService;
	private MemberFileLoadStagingService _memberFileLoadStagingService;
	private NoteFileLoadStagingService _noteFileLoadStagingService;
	private ReferenceTypeCodeFileLoadStagingService _referenceTypeCodeFileLoadStagingService;
	private TaskFileLoadStagingService _taskFileLoadStagingService;

}