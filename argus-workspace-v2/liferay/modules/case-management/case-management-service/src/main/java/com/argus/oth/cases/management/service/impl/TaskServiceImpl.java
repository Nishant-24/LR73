/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.argus.oth.cases.management.service.impl;

import com.argus.oth.cases.management.model.Cases;
import com.argus.oth.cases.management.model.ReferenceTypeCode;
import com.argus.oth.cases.management.model.Task;
import com.argus.oth.cases.management.service.CasesLocalService;
import com.argus.oth.cases.management.service.DataRequestLocalService;
import com.argus.oth.cases.management.service.ProcessStatusType;
import com.argus.oth.cases.management.service.ReferenceTypeCodeLocalService;
import com.argus.oth.cases.management.service.base.TaskServiceBaseImpl;
import com.argus.oth.common.DateFormatter;
import com.argus.oth.common.OTHConstants;
import com.argus.oth.common.enums.DataRequestType;
import com.argus.oth.common.helper.OTHCommonHelper;
import com.argus.oth.common.invoker.ThresholdInvoker;
import com.argus.oth.integration.mulesoft.CaseTaskMuleSoftIntegration;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.json.JSONUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.auth.PrincipalException;
import com.liferay.portal.kernel.security.permission.ActionKeys;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PwdGenerator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import io.swagger.client.model.CaseTasks;
import io.swagger.client.model.Type3;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.TimeZone;
import java.util.function.Function;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The implementation of the task remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.argus.oth.cases.management.service.TaskService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskServiceBaseImpl
 */
@Component(
	property = {"json.web.service.context.name=oth", "json.web.service.context.path=Task"}, service = AopService.class
)
public class TaskServiceImpl extends TaskServiceBaseImpl {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>com.argus.oth.cases.management.service.TaskServiceUtil</code> to access the task remote service.
	 */
	public JSONObject addTask(
			String uuid, long groupId, long caseId, String descriptionKey, String startDateString, Date endDate,
			Date dueDate, long externalTaskId, String priorityKey, String status, String processStatus,
			String failureDescription, long createdUserId)
		throws Exception {

		PermissionChecker permissionChecker = getPermissionChecker();

		if (!permissionChecker.hasPermission(
				null, Task.class.getCanonicalName(), PortalUtil.getDefaultCompanyId(), OTHConstants.ADD_TASK)) {

			throw new PrincipalException.MustHavePermission(
				permissionChecker, Task.class.getName(), 0, OTHConstants.ADD_TASK);
		}

		ReferenceTypeCode taskTypeReferenceTypeCode = _referenceTypeCodeLocalService.fetchByKey(descriptionKey);
		ReferenceTypeCode taskPriorityReferenceTypeCode = _referenceTypeCodeLocalService.fetchByKey(priorityKey);

		Date startDate = _othCommonHelper.parseDate(startDateString, OTHConstants.DATE_PATTERN_YYYY_DD_MM);

		TimeZone timeZone = _getTimeZone(createdUserId);

		String validationError = _validateStartDate(startDate, timeZone);

		if (!Validator.isBlank(validationError)) {
			JSONObject errorObj = JSONUtil.put("error", validationError);

			throw new Exception(errorObj.toString());
		}

		Date conversionStartDate = _getConversionStartDate(startDate);

		taskLocalService.addTask(
			uuid, groupId, caseId, taskTypeReferenceTypeCode.getDescription(), conversionStartDate, endDate, dueDate,
			externalTaskId, taskPriorityReferenceTypeCode.getDescription(), status, processStatus, failureDescription,
			createdUserId, PwdGenerator.getPassword(8));

		// Mulesoft integration call

		Cases cases = _casesLocalService.getCases(caseId);

		long externalCaseId = cases.getExternalCaseId();

		JSONObject taskResponse = _caseTaskMuleSoftIntegration.postCaseTasks(
			PortalUUIDUtil.generate(), uuid, externalCaseId, priorityKey,
			_othCommonHelper.formatDate_yyyyMMddHHmmssZ(conversionStartDate), descriptionKey);

		_dataRequestLocalService.setDataRequestLastUpdatedDate(
			cases.getClientId(), caseId, externalCaseId, DataRequestType.TASK.name());

		return taskResponse;
	}

	public List<Task> getTasksByCaseId(long caseId, int start, int end) throws Exception {
		PermissionChecker permissionChecker = getPermissionChecker();

		if (!permissionChecker.hasPermission(
				null, Task.class.getCanonicalName(), PortalUtil.getDefaultCompanyId(), ActionKeys.VIEW)) {

			throw new PrincipalException.MustHavePermission(
				permissionChecker, Task.class.getName(), 0, ActionKeys.VIEW);
		}

		long externalCaseId = _getExternalCaseId(caseId);

		if (externalCaseId == 0) {
			throw new Exception("Cases with caseId " + caseId + " not found");
		}

		_thresholdInvoker.invokeByCase(
			caseId, DataRequestType.TASK, _getIntegrationFunction(externalCaseId),
			response -> _processTaskUpdates(caseId, response));

		return taskLocalService.getTasksByC_NotP(caseId, ProcessStatusType.FAILURE.name(), start, end);
	}

	private Date _getConversionStartDate(Date startDate) {
		Calendar calendar = CalendarFactoryUtil.getCalendar(startDate.getTime());

		calendar.set(Calendar.HOUR_OF_DAY, 12);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);

		return calendar.getTime();
	}

	private long _getExternalCaseId(long caseId) {
		Cases cases = _casesLocalService.fetchCases(caseId);

		if (Objects.isNull(cases)) {
			return 0;
		}

		return cases.getExternalCaseId();
	}

	private Function<String, List<CaseTasks>> _getIntegrationFunction(long externalCaseId) {
		return lastUpdatedDateString -> {
			try {
				return _caseTaskMuleSoftIntegration.getCaseTasks(
					PortalUUIDUtil.generate(), externalCaseId, lastUpdatedDateString);
			}
			catch (Exception exception) {
				if (_log.isErrorEnabled()) {
					_log.error("Failed to get tasks from MuleSoft", exception);
				}

				return new ArrayList<>();
			}
		};
	}

	private Date _getStartOfDay(Date date) {
		Calendar calendar = CalendarFactoryUtil.getCalendar(date.getTime());

		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTime();
	}

	private TimeZone _getTimeZone(long userId) {
		User user = _userLocalService.fetchUser(userId);

		if (Objects.isNull(user)) {
			return null;
		}

		return user.getTimeZone();
	}

	private void _processTaskUpdates(long caseId, List<CaseTasks> caseTasks) {
		for (CaseTasks caseTask : caseTasks) {
			BigDecimal taskIdBigDecimal = caseTask.getTaskId();

			long externalTaskId = taskIdBigDecimal.longValue();

			Task task = taskLocalService.fetchTaskByExternalTaskId(externalTaskId);

			Date startDate = _othCommonHelper.parseDate_yyyyMMddHHmmsss(caseTask.getStartDate());
			Date endDate = _othCommonHelper.parseDate_yyyyMMddHHmmsss(caseTask.getCompletedDate());
			Date dueDate = _othCommonHelper.parseDate_yyyyMMddHHmmsss(caseTask.getDueDate());

			Type3 taskType = caseTask.getTaskType();
			Type3 taskPriority = caseTask.getTaskPriority();
			Type3 taskStatus = caseTask.getTaskStatus();

			String description = StringPool.BLANK;
			String status = StringPool.BLANK;
			String priority = StringPool.BLANK;

			if (Objects.nonNull(taskType)) {
				description = taskType.getDescription();
			}

			if (Objects.nonNull(taskStatus)) {
				status = taskStatus.getDescription();
			}

			if (Objects.nonNull(taskPriority)) {
				priority = taskPriority.getDescription();
			}

			String processStatus = ProcessStatusType.SUCCESS.name();

			if (Objects.isNull(task)) {
				taskLocalService.addTask(
					StringPool.BLANK, _othCommonHelper.getOTHPortalGroupId(), caseId, description, startDate, endDate,
					dueDate, externalTaskId, priority, status, processStatus, StringPool.BLANK, 0,
					PwdGenerator.getPassword(8));

				continue;
			}

			taskLocalService.updateTask(
				task.getTaskId(), description, startDate, endDate, dueDate, priority, status, processStatus);
		}
	}

	private String _validateStartDate(Date startDate, TimeZone timeZone) {
		if (Objects.isNull(startDate)) {
			return "Start date must not be null.";
		}

		if (Objects.isNull(timeZone)) {
			return "Time zone must be selected.";
		}

		Date startDateBeginningOfDay = _getStartOfDay(startDate);

		Date todayInUserTimeZone = _dateFormatter.convertToTimeZone(DateUtil.newDate(), timeZone);

		Date beginningOfToday = _getStartOfDay(todayInUserTimeZone);

		if (DateUtil.compareTo(startDateBeginningOfDay, beginningOfToday) < 0) {
			return "Start date must not be in the past.";
		}

		return StringPool.BLANK;
	}

	private static final Log _log = LogFactoryUtil.getLog(TaskServiceImpl.class);

	@Reference
	private CasesLocalService _casesLocalService;

	@Reference
	private CaseTaskMuleSoftIntegration _caseTaskMuleSoftIntegration;

	@Reference
	private DataRequestLocalService _dataRequestLocalService;

	@Reference
	private DateFormatter _dateFormatter;

	@Reference
	private OTHCommonHelper _othCommonHelper;

	@Reference
	private ReferenceTypeCodeLocalService _referenceTypeCodeLocalService;

	@Reference
	private ThresholdInvoker<CaseTasks> _thresholdInvoker;

	@Reference
	private UserLocalService _userLocalService;

}