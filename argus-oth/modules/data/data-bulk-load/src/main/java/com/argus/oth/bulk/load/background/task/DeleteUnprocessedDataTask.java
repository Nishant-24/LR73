package com.argus.oth.bulk.load.background.task;

import com.argus.oth.cases.management.service.AuthorizationLocalService;
import com.argus.oth.cases.management.service.CasesLocalService;
import com.argus.oth.cases.management.service.ClaimDetailLocalService;
import com.argus.oth.cases.management.service.ClaimLocalService;
import com.argus.oth.cases.management.service.ClientGroupLocalService;
import com.argus.oth.cases.management.service.ClientLocalService;
import com.argus.oth.cases.management.service.MemberLocalService;
import com.argus.oth.cases.management.service.NoteLocalService;
import com.argus.oth.cases.management.service.ReferenceTypeCodeLocalService;
import com.argus.oth.cases.management.service.TaskLocalService;

import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskResult;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.Serializable;

import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jaclyn Ong
 */
@Component(
	immediate = true,
	property = "background.task.executor.class.name=com.argus.oth.bulk.load.background.task.DeleteUnprocessedDataTask",
	service = BackgroundTaskExecutor.class
)
public class DeleteUnprocessedDataTask extends BaseBackgroundTask {

	@Override
	public BackgroundTaskExecutor clone() {
		DeleteUnprocessedDataTask deleteUnprocessedDataTask = new DeleteUnprocessedDataTask();

		deleteUnprocessedDataTask.setAuthorizationLocalService(_authorizationLocalService);
		deleteUnprocessedDataTask.setCasesLocalService(_casesLocalService);
		deleteUnprocessedDataTask.setClaimDetailLocalService(_claimDetailLocalService);
		deleteUnprocessedDataTask.setClaimLocalService(_claimLocalService);
		deleteUnprocessedDataTask.setClientGroupLocalService(_clientGroupLocalService);
		deleteUnprocessedDataTask.setClientLocalService(_clientLocalService);
		deleteUnprocessedDataTask.setMemberLocalService(_memberLocalService);
		deleteUnprocessedDataTask.setNoteLocalService(_noteLocalService);
		deleteUnprocessedDataTask.setReferenceTypeCodeLocalService(_referenceTypeCodeLocalService);
		deleteUnprocessedDataTask.setTaskLocalService(_taskLocalService);

		return deleteUnprocessedDataTask;
	}

	@Override
	public BackgroundTaskResult execute(BackgroundTask backgroundTask) throws PortalException {
		Map<String, Serializable> contextMap = backgroundTask.getTaskContextMap();

		String randomString = GetterUtil.getString(contextMap.get("randomString"));

		if (Validator.isNotNull(randomString)) {
			_deleteUnprocessedData(randomString);
		}

		triggerNextTask(contextMap, DeleteFilesTask.class);

		return BackgroundTaskResult.SUCCESS;
	}

	@Reference(unbind = "-")
	protected void setAuthorizationLocalService(AuthorizationLocalService authorizationLocalService) {
		_authorizationLocalService = authorizationLocalService;
	}

	@Reference(unbind = "-")
	protected void setCasesLocalService(CasesLocalService casesLocalService) {
		_casesLocalService = casesLocalService;
	}

	@Reference(unbind = "-")
	protected void setClaimDetailLocalService(ClaimDetailLocalService claimDetailLocalService) {
		_claimDetailLocalService = claimDetailLocalService;
	}

	@Reference(unbind = "-")
	protected void setClaimLocalService(ClaimLocalService claimLocalService) {
		_claimLocalService = claimLocalService;
	}

	@Reference(unbind = "-")
	protected void setClientGroupLocalService(ClientGroupLocalService clientGroupLocalService) {
		_clientGroupLocalService = clientGroupLocalService;
	}

	@Reference(unbind = "-")
	protected void setClientLocalService(ClientLocalService clientLocalService) {
		_clientLocalService = clientLocalService;
	}

	@Reference(unbind = "-")
	protected void setMemberLocalService(MemberLocalService memberLocalService) {
		_memberLocalService = memberLocalService;
	}

	@Reference(unbind = "-")
	protected void setNoteLocalService(NoteLocalService noteLocalService) {
		_noteLocalService = noteLocalService;
	}

	@Reference(unbind = "-")
	protected void setReferenceTypeCodeLocalService(ReferenceTypeCodeLocalService referenceTypeCodeLocalService) {
		_referenceTypeCodeLocalService = referenceTypeCodeLocalService;
	}

	@Reference(unbind = "-")
	protected void setTaskLocalService(TaskLocalService taskLocalService) {
		_taskLocalService = taskLocalService;
	}

	private void _deleteUnprocessedData(String randomString) {
		logInfo("Deleting unprocessed data");

		_authorizationLocalService.deleteUnprocessed(randomString);

		_casesLocalService.deleteUnprocessed(randomString);

		_claimDetailLocalService.deleteUnprocessed(randomString);

		_claimLocalService.deleteUnprocessed(randomString);

		_clientGroupLocalService.deleteUnprocessed(randomString);

		_clientLocalService.deleteUnprocessed(randomString);

		_memberLocalService.deleteUnprocessed(randomString);

		_noteLocalService.deleteUnprocessed(randomString);

		_referenceTypeCodeLocalService.deleteUnprocessed(randomString);

		_taskLocalService.deleteUnprocessed(randomString);

		logInfo("Completed deleting unprocessed data");
	}

	private AuthorizationLocalService _authorizationLocalService;
	private CasesLocalService _casesLocalService;
	private ClaimDetailLocalService _claimDetailLocalService;
	private ClaimLocalService _claimLocalService;
	private ClientGroupLocalService _clientGroupLocalService;
	private ClientLocalService _clientLocalService;
	private MemberLocalService _memberLocalService;
	private NoteLocalService _noteLocalService;
	private ReferenceTypeCodeLocalService _referenceTypeCodeLocalService;
	private TaskLocalService _taskLocalService;

}