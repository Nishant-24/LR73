package com.argus.oth.bulk.load.background.task.service.impl;

import com.argus.oth.bulk.load.background.task.service.BaseLoadService;
import com.argus.oth.bulk.load.background.task.service.LoadService;
import com.argus.oth.cases.management.model.Cases;
import com.argus.oth.cases.management.model.StagingCases;
import com.argus.oth.cases.management.model.StagingTask;
import com.argus.oth.cases.management.model.Task;
import com.argus.oth.cases.management.service.CasesLocalService;
import com.argus.oth.cases.management.service.ProcessStatusType;
import com.argus.oth.cases.management.service.StagingCasesLocalService;
import com.argus.oth.cases.management.service.StagingTaskLocalService;
import com.argus.oth.cases.management.service.TaskLocalService;
import com.argus.oth.common.enums.DataRequestType;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Davy Duran
 */
@Component(
	immediate = true,
	property = {
		"model.name=com.argus.oth.cases.management.model.Task",
		"staging.model.name=com.argus.oth.cases.management.model.StagingTask"
	},
	service = AopService.class
)
public class TaskLoadServiceImpl extends BaseLoadService implements AopService, LoadService<StagingTask> {

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean load(String randomString) {
		List<StagingTask> stagingList = _stagingTaskLocalService.getStagingTasks(-1, -1);

		for (StagingTask stagingTask : stagingList) {
			_upsert(stagingTask, randomString);
		}

		_updateFailedTasks();

		return true;
	}

	@Override
	public boolean validate(StagingTask stagingTask) {
		long externalCaseId = stagingTask.getExternalCaseId();

		long taskId = stagingTask.getTaskId();

		StagingCases cases = _stagingCasesLocalService.getStagingCasesByExternalCaseId(String.valueOf(externalCaseId));

		if (cases == null) {
			logError("Missing required field for Task ID " + taskId + ", skipping upsert");

			return false;
		}

		Date startDate = parseDate_yyyyMMddHHmmsss(stagingTask.getStartDate());
		Date endDate = parseDate_yyyyMMddHHmmsss(stagingTask.getEndDate());
		Date dueDate = parseDate_yyyyMMddHHmmsss(stagingTask.getDueDate());

		if (dateParseFailed(startDate) || dateParseFailed(endDate) || dateParseFailed(dueDate)) {
			logError("Error parsing date, Task ID " + taskId + ", skipping upsert");

			return false;
		}

		return true;
	}

	@Override
	protected String getEntityName() {
		return "Task";
	}

	private void _updateFailedTasks() {
		List<Task> pendingTasks = _taskLocalService.getTasksByE_P(0L, ProcessStatusType.PENDING.toString());

		for (Task task : pendingTasks) {
			task.setProcessStatus(ProcessStatusType.FAILURE.toString());

			_taskLocalService.updateTask(task);
		}
	}

	private void _upsert(
		long externalTaskId, long caseId, String description, Date startDate, Date endDate, Date dueDate,
		String priority, String status, String randomString) {

		Task task = _taskLocalService.fetchTaskByExternalTaskId(externalTaskId);

		long groupId = getGroupId();

		if (task == null) {
			_taskLocalService.addTask(
				groupId, caseId, description, startDate, endDate, dueDate, externalTaskId, priority, status,
				randomString);
		}
		else {
			task.setGroupId(groupId);
			task.setCaseId(caseId);
			task.setModifiedDate(new Date());
			task.setDescription(description);
			task.setStartDate(startDate);
			task.setEndDate(endDate);
			task.setDueDate(dueDate);
			task.setExternalTaskId(externalTaskId);
			task.setPriority(priority);
			task.setTaskStatus(status);
			task.setProcessStatus(ProcessStatusType.SUCCESS.toString());
			task.setFailureDescription(StringPool.BLANK);
			task.setRowProcessed(randomString);

			_taskLocalService.updateTask(task);
		}
	}

	private void _upsert(StagingTask stagingTask, String randomString) {
		long externalId = stagingTask.getExternalTaskId();

		long externalCaseId = stagingTask.getExternalCaseId();

		logDebug("Upserting task (ID: " + externalId + "; external case ID: " + externalCaseId + ")");

		Date startDate = parseDate_yyyyMMddHHmmsss(stagingTask.getStartDate());
		Date endDate = parseDate_yyyyMMddHHmmsss(stagingTask.getEndDate());
		Date dueDate = parseDate_yyyyMMddHHmmsss(stagingTask.getDueDate());

		if (!validate(stagingTask)) {
			logError("Task " + externalId + " invalid, skipping upsert");

			return;
		}

		Cases cases = _casesLocalService.fetchCaseByExternalCaseId(externalCaseId);

		_upsert(
			externalId, cases.getCaseId(), stagingTask.getDescription(), startDate, endDate, dueDate,
			stagingTask.getPriority(), stagingTask.getTaskStatus(), randomString);

		setDataRequestLastUpdatedDate(
			cases.getClientId(), cases.getCaseId(), cases.getExternalCaseId(), DataRequestType.TASK);
	}

	@Reference
	private CasesLocalService _casesLocalService;

	@Reference
	private StagingCasesLocalService _stagingCasesLocalService;

	@Reference
	private StagingTaskLocalService _stagingTaskLocalService;

	@Reference
	private TaskLocalService _taskLocalService;

}