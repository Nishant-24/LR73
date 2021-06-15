package com.argus.oth.claim.search;

import com.argus.oth.cases.management.model.Member;
import com.argus.oth.cases.management.service.MemberLocalService;
import com.argus.oth.claim.model.ClaimAnalytics;
import com.argus.oth.claim.service.ClaimAnalyticsLocalService;
import com.argus.oth.common.OTHConstants;
import com.argus.oth.common.OTHSearchHelper;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.search.BaseIndexer;
import com.liferay.portal.kernel.search.BooleanQuery;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.IndexWriterHelper;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.Summary;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jaclyn Ong
 */
@Component(immediate = true, service = Indexer.class)
public class ClaimAnalyticsSearchIndexer extends BaseIndexer<ClaimAnalytics> {

	public ClaimAnalyticsSearchIndexer() {
		setFilterSearch(true);
	}

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
	public void postProcessSearchQuery(
			BooleanQuery searchQuery, BooleanFilter fullQueryBooleanFilter, SearchContext searchContext)
		throws Exception {

		String claimStatus = GetterUtil.getString(searchContext.getAttribute(OTHConstants.FIELD_CLAIM_STATUS));

		if (!Validator.isBlank(claimStatus)) {
			searchQuery.addRequiredTerm(OTHConstants.FIELD_CLAIM_STATUS, claimStatus);
		}

		super.postProcessSearchQuery(searchQuery, fullQueryBooleanFilter, searchContext);
	}

	@Override
	protected void doDelete(ClaimAnalytics claimAnalytics) throws Exception {
		deleteDocument(claimAnalytics.getCompanyId(), claimAnalytics.getClaimAnalyticsId());
	}

	@Override
	protected Document doGetDocument(ClaimAnalytics claimAnalytics) {
		Document document = getBaseModelDocument(_CLASS_NAME, claimAnalytics);

		document.addNumber(OTHConstants.FIELD_COMPANY_ID, claimAnalytics.getCompanyId());
		document.addNumber(OTHConstants.FIELD_GROUP_ID, claimAnalytics.getGroupId());
		document.addNumber(OTHConstants.FIELD_EXTERNAL_CLIENT_ID, claimAnalytics.getExternalClientId());
		document.addText(OTHConstants.FIELD_CLIENT_NAME, claimAnalytics.getClientName());
		document.addText(OTHConstants.FIELD_CLAIM_NUMBER, claimAnalytics.getClaimNumber());
		document.addNumber(OTHConstants.FIELD_EXTERNAL_CASE_ID, claimAnalytics.getExternalCaseId());
		document.addText(OTHConstants.FIELD_CLAIM_STATUS, claimAnalytics.getClaimStatus());
		document.addDate(OTHConstants.FIELD_RECEIVED_DATE, claimAnalytics.getReceivedDate());
		document.addDate(OTHConstants.FIELD_SERVICE_DATE, claimAnalytics.getServiceDate());
		document.addDate(OTHConstants.FIELD_PAID_DATE, claimAnalytics.getPaidDate());
		document.addNumber(OTHConstants.FIELD_EXTERNAL_MEMBER_ID, claimAnalytics.getExternalMemberId());
		document.addText(OTHConstants.FIELD_MEMBER_NAME, claimAnalytics.getMemberName());
		document.addText(OTHConstants.FIELD_PROVIDER_NAME, claimAnalytics.getProviderName());
		document.addText(OTHConstants.FIELD_BILL_TYPE, claimAnalytics.getBillType());
		document.addText(OTHConstants.FIELD_PRIMARY_DIAGNOSIS, claimAnalytics.getPrimaryDiagnosis());
		document.addNumber(OTHConstants.FIELD_CHARGED_AMOUNT, claimAnalytics.getChargedAmount());
		document.addNumber(OTHConstants.FIELD_PAID_AMOUNT, claimAnalytics.getPaidAmount());
		document.addNumber(OTHConstants.FIELD_REPRICED_AMOUNT, claimAnalytics.getRepricedAmount());
		document.addNumber(OTHConstants.FIELD_SAVINGS_AMOUNT, claimAnalytics.getSavingsAmount());
		document.addNumber(OTHConstants.FIELD_CHARGED_PERCENT, claimAnalytics.getChargedPercent());
		document.addNumber(OTHConstants.FIELD_REPRICED_PERCENT, claimAnalytics.getRepricedPercent());
		document.addText(OTHConstants.FIELD_CHARGED_RANGE, claimAnalytics.getChargedRange());
		document.addText(OTHConstants.FIELD_PAID_RANGE, claimAnalytics.getPaidRange());
		document.addText(OTHConstants.FIELD_REPRICED_RANGE, claimAnalytics.getRepricedRange());
		document.addText(OTHConstants.FIELD_SAVINGS_RANGE, claimAnalytics.getSavingsRange());
		document.addNumber(OTHConstants.FIELD_CLAIM_AGING, claimAnalytics.getClaimAging());
		document.addText(OTHConstants.FIELD_PROCEDURE_CODES, claimAnalytics.getProcedureCodes());
		document.addText(OTHConstants.FIELD_RESULT_CODES, claimAnalytics.getResultCodes());
		document.addText(OTHConstants.FIELD_DIAGNOSIS_CODES, claimAnalytics.getDiagnosisCodes());
		document.addText(OTHConstants.FIELD_COUNTRY, claimAnalytics.getCountry());
		document.addText(OTHConstants.FIELD_STATE, claimAnalytics.getState());
		document.addNumber(OTHConstants.FIELD_FINANCIAL_EXPOSURE, claimAnalytics.getFinancialExposure());
		document.addText(OTHConstants.FIELD_REPRICED_NETWORK, claimAnalytics.getRepricedNetwork());
		document.addText(OTHConstants.FIELD_CLIENT_GROUP_NAME, claimAnalytics.getClientGroupName());

		document.addNumber(
			OTHConstants.FIELD_FINANCIAL_EXPOSURE,
			OTHSearchHelper.getCalcFieldValue(claimAnalytics.getFinancialExposure()));

		document.addNumber(
			OTHConstants.FIELD_SAVINGS_AMOUNT, OTHSearchHelper.getCalcFieldValue(claimAnalytics.getSavingsAmount()));

		document.addNumber(
			OTHConstants.FIELD_CHARGED_AMOUNT, OTHSearchHelper.getCalcFieldValue(claimAnalytics.getChargedAmount()));

		document.addNumber(
			OTHConstants.FIELD_REPRICED_AMOUNT, OTHSearchHelper.getCalcFieldValue(claimAnalytics.getRepricedAmount()));

		document.addNumber(
			OTHConstants.FIELD_PAID_AMOUNT, OTHSearchHelper.getCalcFieldValue(claimAnalytics.getPaidAmount()));

		document.addNumber(
			OTHConstants.FIELD_SAVINGS_PERCENT, OTHSearchHelper.getCalcFieldValue(claimAnalytics.getSavingsPercent()));

		document.addKeyword(
			OTHSearchHelper.getAggregationFieldName(OTHConstants.FIELD_CLAIM_AGING), claimAnalytics.getClaimAging());

		document.addKeyword(
			OTHSearchHelper.getAggregationFieldName(OTHConstants.FIELD_CLAIM_STATUS), claimAnalytics.getClaimStatus());

		document.addKeyword(
			OTHSearchHelper.getAggregationFieldName(OTHConstants.FIELD_CHARGED_RANGE),
			claimAnalytics.getChargedRange());

		document.addKeyword(
			OTHSearchHelper.getAggregationFieldName(OTHConstants.FIELD_REPRICED_RANGE),
			claimAnalytics.getRepricedRange());

		document.addKeyword(
			OTHSearchHelper.getAggregationFieldName(OTHConstants.FIELD_PAID_RANGE), claimAnalytics.getPaidRange());

		document.addKeyword(
			OTHSearchHelper.getAggregationFieldName(OTHConstants.FIELD_PROVIDER_NAME),
			claimAnalytics.getProviderName());

		document.addKeyword(
			OTHSearchHelper.getAggregationFieldName(OTHConstants.FIELD_SAVINGS_PERCENT),
			OTHSearchHelper.getCalcFieldValue(claimAnalytics.getSavingsPercent()));

		Member member = _memberLocalService.fetchByExternalMemberId(claimAnalytics.getExternalMemberId());

		String memberNumber = StringPool.BLANK;

		if (Objects.nonNull(member)) {
			memberNumber = member.getMemberNumber();
		}

		document.addText(OTHConstants.FIELD_MEMBER_NUMBER, memberNumber);

		return document;
	}

	@Override
	protected Summary doGetSummary(
		Document document, Locale locale, String snippet, PortletRequest portletRequest,
		PortletResponse portletResponse) {

		return null;
	}

	@Override
	protected void doReindex(ClaimAnalytics claimAnalytics) throws Exception {
		indexWriterHelper.updateDocument(
			getSearchEngineId(), claimAnalytics.getCompanyId(), getDocument(claimAnalytics), isCommitImmediately());
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		doReindex(claimAnalyticsLocalService.getClaimAnalytics(classPK));
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);

		_reindexAll(companyId);
	}

	protected void reindexClaimAnalytics(long companyId, int start, int end) throws Exception {
		List<ClaimAnalytics> claimAnalyticsList = claimAnalyticsLocalService.getClaimAnalyticses(start, end);

		if (claimAnalyticsList.isEmpty()) {
			return;
		}

		List<Document> documents = new ArrayList<>();

		for (ClaimAnalytics claimAnalytics : claimAnalyticsList) {
			documents.add(getDocument(claimAnalytics));
		}

		indexWriterHelper.updateDocuments(getSearchEngineId(), companyId, documents, isCommitImmediately());
	}

	@Reference
	protected ClaimAnalyticsLocalService claimAnalyticsLocalService;

	@Reference
	protected IndexWriterHelper indexWriterHelper;

	/**
	 * Reindexes all ClaimAnalytics in given company.
	 *
	 * @param companyId
	 * @throws Exception
	 */
	private void _reindexAll(long companyId) throws Exception {
		int count = claimAnalyticsLocalService.getClaimAnalyticsesCount();

		int pages = count / Indexer.DEFAULT_INTERVAL;

		for (int i = 0; i <= pages; i++) {
			int start = i * Indexer.DEFAULT_INTERVAL;

			int end = start + Indexer.DEFAULT_INTERVAL;

			reindexClaimAnalytics(companyId, start, end);
		}
	}

	private static final String _CLASS_NAME = ClaimAnalytics.class.getName();

	@Reference
	private MemberLocalService _memberLocalService;

}