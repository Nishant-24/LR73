package com.argus.oth.account.management.search;

import com.argus.oth.account.management.model.AMAnalyticsClaim;
import com.argus.oth.account.management.service.AMAnalyticsClaimLocalService;
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
public class AMAnalyticsClaimSearchIndexer extends BaseIndexer<AMAnalyticsClaim> {

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
	protected void doDelete(AMAnalyticsClaim amAnalyticsClaim) throws Exception {
		deleteDocument(amAnalyticsClaim.getCompanyId(), amAnalyticsClaim.getAmAnalyticsClaimId());
	}

	@Override
	protected Document doGetDocument(AMAnalyticsClaim amAnalyticsClaim) {
		Document document = getBaseModelDocument(_CLASS_NAME, amAnalyticsClaim);

		document.addNumber(OTHConstants.FIELD_GROUP_ID, amAnalyticsClaim.getGroupId());
		document.addNumber(OTHConstants.FIELD_SCOPE_GROUP_ID, amAnalyticsClaim.getGroupId());
		document.addNumber(OTHConstants.FIELD_CLIENT_ID, amAnalyticsClaim.getClientId());
		document.addDate(OTHConstants.FIELD_AM_ANALYTICS_CLAIM_DATE, amAnalyticsClaim.getAmAnalyticsClaimDate());
		document.addNumber(OTHConstants.FIELD_AVG_CLAIM_TURNAROUND, amAnalyticsClaim.getAvgClaimTurnAround());
		document.addNumber(OTHConstants.FIELD_MIN_CLAIM_TURNAROUND, amAnalyticsClaim.getMinClaimTurnAround());
		document.addNumber(OTHConstants.FIELD_MAX_CLAIM_TURNAROUND, amAnalyticsClaim.getMaxClaimTurnAround());
		document.addNumber(OTHConstants.FIELD_CLAIM_TURN_AROUND_GOAL, amAnalyticsClaim.getClaimTurnAroundGoal());
		document.addNumber(
			OTHConstants.FIELD_OVERALL_AVG_CLAIM_TURNAROUND, amAnalyticsClaim.getOverallAvgClaimTurnAround());

		return document;
	}

	@Override
	protected Summary doGetSummary(
		Document document, Locale locale, String snippet, PortletRequest portletRequest,
		PortletResponse portletResponse) {

		return null;
	}

	@Override
	protected void doReindex(AMAnalyticsClaim amAnalyticsClaim) throws Exception {
		indexWriterHelper.updateDocument(
			getSearchEngineId(), amAnalyticsClaim.getCompanyId(), getDocument(amAnalyticsClaim), isCommitImmediately());
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		doReindex(amAnalyticsClaimLocalService.getAMAnalyticsClaim(classPK));
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);

		_reindexAll(companyId);
	}

	protected void reindexAMAnalyticsClaims(long companyId, int start, int end) throws Exception {
		List<AMAnalyticsClaim> amAnalyticsClaimList = amAnalyticsClaimLocalService.getAMAnalyticsClaims(start, end);

		if (amAnalyticsClaimList.isEmpty()) {
			return;
		}

		List<Document> documents = new ArrayList<>();

		for (AMAnalyticsClaim amAnalyticsClaim : amAnalyticsClaimList) {
			documents.add(getDocument(amAnalyticsClaim));
		}

		indexWriterHelper.updateDocuments(getSearchEngineId(), companyId, documents, isCommitImmediately());
	}

	@Reference
	protected AMAnalyticsClaimLocalService amAnalyticsClaimLocalService;

	@Reference
	protected IndexWriterHelper indexWriterHelper;

	private void _reindexAll(long companyId) throws Exception {
		int count = amAnalyticsClaimLocalService.getAMAnalyticsClaimsCount();

		int pages = count / Indexer.DEFAULT_INTERVAL;

		for (int i = 0; i <= pages; i++) {
			int start = i * Indexer.DEFAULT_INTERVAL;

			int end = start + Indexer.DEFAULT_INTERVAL;

			reindexAMAnalyticsClaims(companyId, start, end);
		}
	}

	private static final String _CLASS_NAME = AMAnalyticsClaim.class.getName();

}