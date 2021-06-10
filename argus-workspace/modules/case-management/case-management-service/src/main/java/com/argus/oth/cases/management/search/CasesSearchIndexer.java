package com.argus.oth.cases.management.search;

import com.argus.oth.cases.management.model.Cases;
import com.argus.oth.cases.management.service.CasesLocalService;
import com.argus.oth.common.DateFormatter;
import com.argus.oth.common.OTHConstants;

import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.IndexWriterHelper;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.util.GetterUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jaclyn Ong
 */
@Component(immediate = true, service = Indexer.class)
public class CasesSearchIndexer extends BaseIndexer<Cases> {

	@Override
	public String getClassName() {
		return _CLASS_NAME;
	}

	@Override
	public boolean isFilterSearch() {
		return true;
	}

	@Override
	public boolean isPermissionAware() {
		return false;
	}

	@Override
	protected void doDelete(Cases cases) throws Exception {
		deleteDocument(cases.getCompanyId(), cases.getCaseId());
	}

	@Override
	protected Document doGetDocument(Cases cases) {
		Document document = getBaseModelDocument(_CLASS_NAME, cases);

		document.addNumber(OTHConstants.FIELD_CASE_ID, cases.getCaseId());
		document.addNumber(OTHConstants.FIELD_GROUP_ID, cases.getGroupId());
		document.addNumber(OTHConstants.FIELD_SCOPE_GROUP_ID, cases.getGroupId());
		document.addNumber(OTHConstants.FIELD_COMPANY_ID, cases.getCompanyId());
		document.addNumber(OTHConstants.FIELD_EXTERNAL_CASE_ID, cases.getExternalCaseId());
		document.addNumber(OTHConstants.FIELD_CLIENT_ID, cases.getClientId());
		document.addText(OTHConstants.FIELD_CLIENT_NAME, cases.getClientName());
		document.addNumber(OTHConstants.FIELD_CLIENT_GROUP_ID, cases.getClientGroupId());
		document.addText(OTHConstants.FIELD_CASE_NUMBER, cases.getCaseNumber());
		document.addDate(OTHConstants.FIELD_CASE_START_DATE, cases.getCaseStartDate());
		document.addDate(OTHConstants.FIELD_CASE_END_DATE, cases.getCaseEndDate());
		document.addNumber(OTHConstants.FIELD_MEMBER_ID, cases.getMemberId());
		document.addText(OTHConstants.FIELD_PRIMARY_DIAG_CODE, cases.getPrimaryDiagCode());
		document.addText(OTHConstants.FIELD_PRIMARY_CODE, cases.getPrimaryCode());
		document.addText(OTHConstants.FIELD_STATUS, cases.getStatus());
		document.addDate(OTHConstants.FIELD_ESTIMATE_ENTRY_DATE, cases.getEstimateEntryDate());
		document.addText(OTHConstants.FIELD_CASE_MANAGER, cases.getCaseManager());
		document.addDate(OTHConstants.FIELD_CONSENT_RECEIVED_DATE, cases.getConsentReceivedDate());
		document.addText(OTHConstants.FIELD_MEDICAL_PLAN, cases.getMedicalPlan());
		document.addText(OTHConstants.FIELD_COST_ESTIMATE, cases.getCostEstimate());
		document.addDate(OTHConstants.FIELD_LAST_UPDATED, cases.getLastUpdated());
		document.addDate(OTHConstants.FIELD_EXTERNAL_CREATED_DATE, cases.getExternalCreatedDate());
		document.addNumber(OTHConstants.FIELD_CHARGED_AMOUNT, cases.getChargedAmount());
		document.addNumber(OTHConstants.FIELD_PAID_AMOUNT, cases.getPaidAmount());
		document.addNumber(OTHConstants.FIELD_REPRICED_AMOUNT, cases.getRepricedAmount());
		document.addNumber(OTHConstants.FIELD_SAVINGS_AMOUNT, cases.getSavingsAmount());
		document.addNumber(OTHConstants.FIELD_SAVINGS_PERCENT, cases.getSavingsPercent());
		document.addText(OTHConstants.FIELD_TREATING_PHYSICIAN, cases.getTreatingPhysician());
		document.addText(OTHConstants.FIELD_PRIMARY_FACILITY, cases.getPrimaryFacility());

		return document;
	}

	@Override
	protected Summary doGetSummary(
		Document document, Locale locale, String snippet, PortletRequest portletRequest,
		PortletResponse portletResponse) {

		return null;
	}

	@Override
	protected void doReindex(Cases cases) throws Exception {
		indexWriterHelper.updateDocument(
			getSearchEngineId(), cases.getCompanyId(), getDocument(cases), isCommitImmediately());
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		doReindex(casesLocalService.getCases(classPK));
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);

		_reindexAll(companyId);
	}

	protected void reindexCaseses(long companyId, int start, int end) throws Exception {
		List<Cases> casesList = casesLocalService.getCaseses(start, end);

		if (casesList.isEmpty()) {
			return;
		}

		List<Document> documents = new ArrayList<>();

		for (Cases cases : casesList) {
			documents.add(getDocument(cases));
		}

		indexWriterHelper.updateDocuments(getSearchEngineId(), companyId, documents, isCommitImmediately());
	}

	@Reference
	protected CasesLocalService casesLocalService;

	@Reference
	protected IndexWriterHelper indexWriterHelper;

	private void _reindexAll(long companyId) throws Exception {
		int count = casesLocalService.getCasesesCount();

		int pages = count / Indexer.DEFAULT_INTERVAL;

		for (int i = 0; i <= pages; i++) {
			int start = i * Indexer.DEFAULT_INTERVAL;

			int end = start + Indexer.DEFAULT_INTERVAL;

			reindexCaseses(companyId, start, end);
		}
	}

	private static final String _CLASS_NAME = Cases.class.getName();

	@Reference
	private DateFormatter _dateFormatter;

}