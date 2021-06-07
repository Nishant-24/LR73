package com.argus.oth.integration.mulesoft.background.task;

import com.argus.oth.cases.management.model.Cases;
import com.argus.oth.cases.management.model.Client;
import com.argus.oth.cases.management.service.CasesLocalService;
import com.argus.oth.cases.management.service.ClientLocalService;
import com.argus.oth.cases.management.service.DataRequestLocalService;
import com.argus.oth.cases.management.service.MemberLocalService;
import com.argus.oth.common.enums.DataRequestType;
import com.argus.oth.common.helper.OTHCommonHelper;
import com.argus.oth.common.invoker.ThresholdInvoker;
import com.argus.oth.integration.mulesoft.CasesMuleSoftIntegration;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskConstants;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskResult;
import com.liferay.portal.kernel.backgroundtask.BaseBackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.display.BackgroundTaskDisplay;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PwdGenerator;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import io.swagger.client.model.Items;
import io.swagger.client.model.ModelCase;
import io.swagger.client.model.Type2;
import io.swagger.client.model.Type3;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jaclyn Ong
 */
@Component(
	immediate = true,
	property = "background.task.executor.class.name=com.argus.oth.integration.mulesoft.background.task.GetCasesTask",
	service = BackgroundTaskExecutor.class
)
public class GetCasesTask extends BaseBackgroundTaskExecutor {

	public static final String CLIENT_ID = "clientId";

	@Override
	public BackgroundTaskExecutor clone() {
		GetCasesTask getCasesTask = new GetCasesTask();

		getCasesTask.setCasesMuleSoftIntegration(_casesMuleSoftIntegration);
		getCasesTask.setCasesLocalService(_casesLocalService);
		getCasesTask.setClientLocalService(_clientLocalService);
		getCasesTask.setDataRequestLocalService(_dataRequestLocalService);
		getCasesTask.setMemberLocalService(_memberLocalService);
		getCasesTask.setOTHCommonHelper(_othCommonHelper);
		getCasesTask.setThresholdInvoker(_thresholdInvoker);

		return getCasesTask;
	}

	@Override
	public BackgroundTaskResult execute(BackgroundTask backgroundTask) {
		try {
			Map<String, Serializable> contextMap = backgroundTask.getTaskContextMap();

			long clientId = GetterUtil.getLong(contextMap.get(CLIENT_ID));

			_thresholdInvoker.invokeByClient(
				clientId, DataRequestType.CASES, _getIntegrationFunction(clientId), this::_processCasesUpdates);
		}
		catch (Exception e) {
			if (_log.isErrorEnabled()) {
				_log.error("Failed to get cases", e);
			}

			return new BackgroundTaskResult(BackgroundTaskConstants.STATUS_FAILED);
		}

		return BackgroundTaskResult.SUCCESS;
	}

	@Override
	public BackgroundTaskDisplay getBackgroundTaskDisplay(BackgroundTask backgroundTask) {
		return new GetCasesBackgroundTaskDisplay(backgroundTask);
	}

	@Reference(unbind = "-")
	protected void setCasesLocalService(CasesLocalService casesLocalService) {
		_casesLocalService = casesLocalService;
	}

	@Reference(unbind = "-")
	protected void setCasesMuleSoftIntegration(CasesMuleSoftIntegration casesMuleSoftIntegration) {
		_casesMuleSoftIntegration = casesMuleSoftIntegration;
	}

	@Reference(unbind = "-")
	protected void setClientLocalService(ClientLocalService clientLocalService) {
		_clientLocalService = clientLocalService;
	}

	@Reference(unbind = "-")
	protected void setDataRequestLocalService(DataRequestLocalService dataRequestLocalService) {
		_dataRequestLocalService = dataRequestLocalService;
	}

	@Reference(unbind = "-")
	protected void setMemberLocalService(MemberLocalService memberLocalService) {
		_memberLocalService = memberLocalService;
	}

	@Reference(unbind = "-")
	protected void setOTHCommonHelper(OTHCommonHelper othCommonHelper) {
		_othCommonHelper = othCommonHelper;
	}

	@Reference(unbind = "-")
	protected void setThresholdInvoker(ThresholdInvoker<ModelCase> thresholdInvoker) {
		_thresholdInvoker = thresholdInvoker;
	}

	private Function<String, List<ModelCase>> _getIntegrationFunction(long clientId) {
		return lastUpdatedDateString -> {
			try {
				return _casesMuleSoftIntegration.getCases(
					PortalUUIDUtil.generate(), String.valueOf(clientId), lastUpdatedDateString);
			}
			catch (Exception e) {
				if (_log.isErrorEnabled()) {
					_log.error("Failed to get cases from MuleSoft", e);
				}

				return new ArrayList<>();
			}
		};
	}

	private Items _getPrimaryProcedureCode(List<Items> procedureCodes) {
		if (Objects.isNull(procedureCodes)) {
			return null;
		}

		for (Items procedureCode : procedureCodes) {
			if (procedureCode.isPrimaryFlag()) {
				return procedureCode;
			}
		}

		return null;
	}

	private void _processCasesUpdates(List<ModelCase> modelCases) {
		for (ModelCase modelCase : modelCases) {
			BigDecimal caseId = modelCase.getCaseId();

			long externalCaseId = caseId.longValue();

			Date startDate = _othCommonHelper.parseDate_yyyyMMddHHmmsss(modelCase.getStartDate());

			Date endDate = _othCommonHelper.parseDate_yyyyMMddHHmmsss(modelCase.getEndDate());

			Date estimateEntryDate = _othCommonHelper.parseDate_yyyyMMddHHmmsss(modelCase.getEstimateEntryDate());

			Date externalCreateDate = _othCommonHelper.parseDate_yyyyMMddHHmmsss(modelCase.getCreatedDateTime());

			Date lastUpdated = _othCommonHelper.parseDate_yyyyMMddHHmmsss(modelCase.getModifiedDateTime());

			Date consentReceivedDate = _othCommonHelper.parseDate_yyyyMMddHHmmsss(modelCase.getConsentReceivedDate());

			Cases existingCases = _casesLocalService.fetchCaseByExternalCaseId(externalCaseId);

			long groupId = _othCommonHelper.getOTHPortalGroupId();

			if (Objects.nonNull(existingCases) && (groupId != existingCases.getGroupId())) {
				groupId = existingCases.getGroupId();
			}

			Type3 caseStatus = modelCase.getCaseStatus();

			String caseStatusDescription = StringPool.BLANK;

			if (Objects.nonNull(caseStatus)) {
				caseStatusDescription = caseStatus.getDescription();
			}

			String clientName = StringPool.BLANK;

			long clientId = GetterUtil.getLong(modelCase.getClientId());

			if (!Validator.isBlank(modelCase.getClientId())) {
				Client client = _clientLocalService.fetchClientByExternalClientId(clientId);

				if (Objects.nonNull(client)) {
					clientName = client.getClientName();
				}
			}

			long clientGroupId = 0;

			if (Objects.nonNull(existingCases)) {
				clientGroupId = existingCases.getClientGroupId();
			}

			Type2 member = modelCase.getCaseMember();

			BigDecimal externalMemberId = new BigDecimal(0);

			if (Objects.nonNull(member)) {
				_memberLocalService.upsertMember(groupId, clientId, clientGroupId, member);

				externalMemberId = member.getMemberId();
			}

			String primaryDiagCode = StringPool.BLANK;
			String primaryCode = StringPool.BLANK;

			Items primaryProcedureCode = _getPrimaryProcedureCode(modelCase.getDiagnosisCodes());

			if (Objects.nonNull(primaryProcedureCode)) {
				primaryDiagCode = primaryProcedureCode.getDescription();

				primaryCode = primaryProcedureCode.getCode();
			}

			BigDecimal chargedAmount = modelCase.getChargedAmount();
			BigDecimal paidAmount = modelCase.getPaidAmount();
			BigDecimal repricedAmount = modelCase.getRepricedAmount();
			BigDecimal savingsAmount = modelCase.getSavingsAmount();

			Cases updatedCases;

			if (Objects.isNull(existingCases)) {
				updatedCases = _casesLocalService.addCase(
					groupId, externalCaseId, clientId, clientName, clientGroupId, modelCase.getCaseNumber(), startDate,
					endDate, externalMemberId.longValue(), primaryDiagCode, primaryCode, caseStatusDescription,
					estimateEntryDate, modelCase.getCaseManager(), consentReceivedDate, modelCase.getMedicalPlan(),
					modelCase.getCostEstimate(), lastUpdated, externalCreateDate, chargedAmount.longValue(),
					paidAmount.longValue(), repricedAmount.longValue(), savingsAmount.longValue(), 0,
					modelCase.getTreatingPhysician(), modelCase.getFacility(), PwdGenerator.getPassword(8));
			}
			else {
				updatedCases = _casesLocalService.updateCases(
					existingCases.getCaseId(), clientId, clientName, clientGroupId, modelCase.getCaseNumber(),
					startDate, endDate, externalMemberId.longValue(), primaryDiagCode, primaryCode,
					caseStatusDescription, estimateEntryDate, modelCase.getCaseManager(), consentReceivedDate,
					modelCase.getMedicalPlan(), modelCase.getCostEstimate(), lastUpdated, externalCreateDate,
					chargedAmount.longValue(), paidAmount.longValue(), repricedAmount.longValue(),
					savingsAmount.longValue(), existingCases.getSavingsPercent(), modelCase.getTreatingPhysician(),
					modelCase.getFacility());
			}

			_dataRequestLocalService.setDataRequestLastUpdatedDate(
				clientId, updatedCases.getCaseId(), externalCaseId, DataRequestType.CASE.name());
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(GetCasesTask.class);

	private CasesLocalService _casesLocalService;
	private CasesMuleSoftIntegration _casesMuleSoftIntegration;
	private ClientLocalService _clientLocalService;
	private DataRequestLocalService _dataRequestLocalService;
	private MemberLocalService _memberLocalService;
	private OTHCommonHelper _othCommonHelper;
	private ThresholdInvoker<ModelCase> _thresholdInvoker;

}