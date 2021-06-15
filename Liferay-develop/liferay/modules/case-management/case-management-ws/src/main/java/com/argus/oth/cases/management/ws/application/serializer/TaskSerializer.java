package com.argus.oth.cases.management.ws.application.serializer;

import com.argus.oth.cases.management.model.Task;
import com.argus.oth.common.DateFormatter;
import com.argus.oth.common.ws.base.BaseSerializer;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;

import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Ricky Pan
 */
@Component(immediate = true, service = TaskSerializer.class)
public class TaskSerializer extends BaseSerializer {

	public JSONArray serialize(List<Task> tasks) {
		JSONArray result = _jsonFactory.createJSONArray();

		for (Task task : tasks) {
			JSONObject obj = serialize(task);

			result.put(obj);
		}

		return result;
	}

	public JSONObject serialize(Task task) {
		JSONObject jsonObject = _jsonFactory.createJSONObject();

		jsonObject.put("caseId", task.getCaseId());
		jsonObject.put("description", task.getDescription());
		jsonObject.put("dueDate", _dateFormatter.getISODateString(task.getDueDate()));
		jsonObject.put("endDate", _dateFormatter.getISODateString(task.getEndDate()));
		jsonObject.put("externalTaskId", task.getExternalTaskId());
		jsonObject.put("failureDescription", task.getFailureDescription());
		jsonObject.put("groupId", task.getGroupId());
		jsonObject.put("priority", task.getPriority());
		jsonObject.put("processStatus", task.getProcessStatus());
		jsonObject.put("startDate", _dateFormatter.getISODateString(task.getStartDate()));
		jsonObject.put("taskId", task.getTaskId());
		jsonObject.put("taskStatus", task.getTaskStatus());

		return jsonObject;
	}

	@Reference
	private DateFormatter _dateFormatter;

	@Reference
	private JSONFactory _jsonFactory;

}