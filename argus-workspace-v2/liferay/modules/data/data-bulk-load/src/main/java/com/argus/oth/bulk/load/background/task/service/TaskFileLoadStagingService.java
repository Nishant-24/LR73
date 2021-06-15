package com.argus.oth.bulk.load.background.task.service;

import com.argus.oth.cases.management.model.StagingTask;
import com.argus.oth.cases.management.service.StagingTaskLocalService;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;

import java.util.HashMap;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Davy Duran
 */
@Component(immediate = true, service = TaskFileLoadStagingService.class)
public class TaskFileLoadStagingService extends BaseFileLoadStagingService<StagingTask> {

	@Override
	public void cleanup() {
		_stagingTaskLocalService.deleteAllStagingTasks();
	}

	@Override
	public String getEntityName() {
		return "Task";
	}

	@Override
	protected HashMap<Integer, String> getHeaders() {
		return HashMapBuilder.put(
			0, "CaseID"
		).put(
			1, "Priority"
		).put(
			2, "StartDate"
		).put(
			3, "EndDate"
		).put(
			4, "DueDate"
		).put(
			5, "TaskStatus"
		).put(
			6, "Description"
		).put(
			7, "CompletedFlag"
		).put(
			8, "ModifiedDate"
		).put(
			9, "CreatedDate"
		).put(
			getMaxFieldArrayPosition(), "TaskID"
		).build();
	}

	@Override
	protected int getMaxFieldArrayLength() {
		return 13;
	}

	@Override
	protected StagingTask getStagingModel(String[] fields) {
		StagingTask stagingTask = _stagingTaskLocalService.createStagingTask(0);

		stagingTask.setExternalCaseId(GetterUtil.getLong(fields[0]));
		stagingTask.setCompletedFlag(fields[7]);
		stagingTask.setDescription(fields[6]);
		stagingTask.setStartDate(fields[2]);
		stagingTask.setEndDate(fields[3]);
		stagingTask.setDueDate(fields[4]);
		stagingTask.setExternalCreateDate(fields[9]);
		stagingTask.setExternalModifiedDate(fields[8]);
		stagingTask.setExternalTaskId(GetterUtil.getLong(fields[12]));
		stagingTask.setPriority(fields[1]);
		stagingTask.setTaskStatus(fields[5]);

		return stagingTask;
	}

	@Override
	protected String getStagingModelClassName() {
		return StagingTask.class.getName();
	}

	@Override
	protected void insert(StagingTask stagingTask) {
		_stagingTaskLocalService.addStagingTask(
			stagingTask.getExternalCaseId(), stagingTask.getCompletedFlag(), stagingTask.getDescription(),
			stagingTask.getStartDate(), stagingTask.getEndDate(), stagingTask.getDueDate(),
			stagingTask.getExternalCreateDate(), stagingTask.getExternalModifiedDate(), stagingTask.getExternalTaskId(),
			stagingTask.getPriority(), stagingTask.getTaskStatus());
	}

	@Reference
	private StagingTaskLocalService _stagingTaskLocalService;

}