package com.argus.oth.account.management.search;

import com.argus.oth.account.management.model.AMAnalyticsTelephony;
import com.argus.oth.account.management.service.AMAnalyticsTelephonyLocalService;
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
public class AMAnalyticsTelephonySearchIndexer extends BaseIndexer<AMAnalyticsTelephony> {

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
	protected void doDelete(AMAnalyticsTelephony amAnalyticsTelephony) throws Exception {
		deleteDocument(amAnalyticsTelephony.getCompanyId(), amAnalyticsTelephony.getAmAnalyticsTelephonyId());
	}

	@Override
	protected Document doGetDocument(AMAnalyticsTelephony amAnalyticsTelephony) {
		Document document = getBaseModelDocument(_CLASS_NAME, amAnalyticsTelephony);

		document.addNumber(OTHConstants.FIELD_GROUP_ID, amAnalyticsTelephony.getGroupId());
		document.addNumber(OTHConstants.FIELD_SCOPE_GROUP_ID, amAnalyticsTelephony.getGroupId());
		document.addNumber(OTHConstants.FIELD_CLIENT_ID, amAnalyticsTelephony.getClientId());
		document.addDate(
			OTHConstants.FIELD_AM_ANALYTICS_TELEPHONY_DATE, amAnalyticsTelephony.getAmAnalyticsTelephonyDate());
		document.addNumber(OTHConstants.FIELD_AVG_DOWN_TIME, amAnalyticsTelephony.getAvgDownTime());
		document.addNumber(OTHConstants.FIELD_AVG_SPEED_OF_ANSWER, amAnalyticsTelephony.getAvgSpeedOfAnswer());
		document.addNumber(OTHConstants.FIELD_ABANDONMENT_RATE, amAnalyticsTelephony.getAbandonmentRate());
		document.addNumber(OTHConstants.FIELD_DOWN_TIME_GOAL, amAnalyticsTelephony.getDownTimeGoal());
		document.addNumber(OTHConstants.FIELD_SPEED_ANSWER_GOAL, amAnalyticsTelephony.getSpeedAnswerGoal());
		document.addNumber(OTHConstants.FIELD_ABANDONMENT_RATE_GOAL, amAnalyticsTelephony.getAbandonmentRateGoal());
		document.addNumber(OTHConstants.FIELD_OVERALL_AVG_DOWNTIME, amAnalyticsTelephony.getOverallAvgDownTime());
		document.addNumber(
			OTHConstants.FIELD_OVERALL_AVG_SPEED_OF_ANSWER, amAnalyticsTelephony.getOverallAvgSpeedOfAnswer());
		document.addNumber(
			OTHConstants.FIELD_OVERALL_AVG_ABANDONMENT_RATE, amAnalyticsTelephony.getOverallAvgAbandonmentRate());

		return document;
	}

	@Override
	protected Summary doGetSummary(
		Document document, Locale locale, String snippet, PortletRequest portletRequest,
		PortletResponse portletResponse) {

		return null;
	}

	@Override
	protected void doReindex(AMAnalyticsTelephony amAnalyticsTelephony) throws Exception {
		indexWriterHelper.updateDocument(
			getSearchEngineId(), amAnalyticsTelephony.getCompanyId(), getDocument(amAnalyticsTelephony),
			isCommitImmediately());
	}

	@Override
	protected void doReindex(String className, long classPK) throws Exception {
		doReindex(amAnalyticsTelephonyLocalService.getAMAnalyticsTelephony(classPK));
	}

	@Override
	protected void doReindex(String[] ids) throws Exception {
		long companyId = GetterUtil.getLong(ids[0]);

		_reindexAll(companyId);
	}

	protected void reindexAMAnalyticsTelephonys(long companyId, int start, int end) throws Exception {
		List<AMAnalyticsTelephony> amAnalyticsTelephonyList =
			amAnalyticsTelephonyLocalService.getAMAnalyticsTelephonies(start, end);

		if (amAnalyticsTelephonyList.isEmpty()) {
			return;
		}

		List<Document> documents = new ArrayList<>();

		for (AMAnalyticsTelephony amAnalyticsTelephony : amAnalyticsTelephonyList) {
			documents.add(getDocument(amAnalyticsTelephony));
		}

		indexWriterHelper.updateDocuments(getSearchEngineId(), companyId, documents, isCommitImmediately());
	}

	@Reference
	protected AMAnalyticsTelephonyLocalService amAnalyticsTelephonyLocalService;

	@Reference
	protected IndexWriterHelper indexWriterHelper;

	private void _reindexAll(long companyId) throws Exception {
		int count = amAnalyticsTelephonyLocalService.getAMAnalyticsTelephoniesCount();

		int pages = count / Indexer.DEFAULT_INTERVAL;

		for (int i = 0; i <= pages; i++) {
			int start = i * Indexer.DEFAULT_INTERVAL;

			int end = start + Indexer.DEFAULT_INTERVAL;

			reindexAMAnalyticsTelephonys(companyId, start, end);
		}
	}

	private static final String _CLASS_NAME = AMAnalyticsTelephony.class.getName();

}