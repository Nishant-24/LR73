package com.argus.oth.bulk.load.background.task.service;

import com.argus.oth.cases.management.service.DataRequestLocalService;
import com.argus.oth.common.OTHConstants;
import com.argus.oth.common.enums.DataRequestType;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.search.IndexWriterHelper;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistry;
import com.liferay.portal.kernel.search.SearchException;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.util.DateFormatFactoryUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.text.DateFormat;
import java.text.ParseException;

import java.util.Date;

import org.osgi.service.component.annotations.Reference;

/**
 * @author Jaclyn Ong
 */
public abstract class BaseLoadService {

	public void loadData(String randomString) throws Exception {
		_logStart();

		_cleanIndex();

		logInfo("Loading prod table");

		clearCache();

		if (!load(randomString)) {
			//todo: remove
			_logFailure();

			return;
		}

		logInfo("Loading completed");

		_logEnd();
	}

	protected boolean blankNullOrNullString(String string) {
		return Validator.isBlank(string) || (string.compareToIgnoreCase(_NULL) == 0) || string.matches(_ZEROS_REGEX);
	}

	protected void clearCache() {
		EntityCacheUtil.clearCache();
		FinderCacheUtil.clearCache();

		logInfo("Cache cleared");
	}

	protected boolean dateParseFailed(Date date) {
		return (date != null) && (minDate.compareTo(date) == 0);
	}

	protected String getEntityClassName() {
		throw new UnsupportedOperationException("Class name not found");
	}

	protected abstract String getEntityName();

	protected Long getGroupId() {
		long companyId = PortalUtil.getDefaultCompanyId();

		Group group = groupLocalService.fetchGroup(companyId, OTHConstants.OTH_PORTAL_GROUP_NAME);

		if (group == null) {
			logError(
				"Group with name \"" + OTHConstants.OTH_PORTAL_GROUP_NAME + "\" under company ID " + companyId +
					" is not found");

			return null;
		}

		return group.getGroupId();
	}

	protected String getSearchEngineId() {
		Indexer<Object> indexer = indexerRegistry.getIndexer(getEntityClassName());

		return indexer.getSearchEngineId();
	}

	protected abstract boolean load(String randomString) throws Exception;

	protected void logDebug(String message) {
		if (_log.isDebugEnabled()) {
			_log.debug(message);
		}
	}

	protected void logError(String message) {
		if (_log.isErrorEnabled()) {
			_log.error(message);
		}
	}

	protected void logError(String message, Exception e) {
		if (_log.isErrorEnabled()) {
			_log.error(message, e);
		}
	}

	protected void logInfo(String message) {
		if (_log.isInfoEnabled()) {
			_log.info(message);
		}
	}

	protected void logWarn(String message, Exception e) {
		if (_log.isWarnEnabled()) {
			_log.warn(message, e);
		}
	}

	protected Date parseDate_yyyyMMddHHmmsss(String string) {
		return _parseDate(string, "yyyy-MM-dd'T'HH:mm:sss");
	}

	protected Double parseDouble(String string) {
		if (blankNullOrNullString(string)) {
			return 0D;
		}

		string = string.replace(StringPool.DOLLAR, StringPool.BLANK);
		string = string.replace(StringPool.COMMA, StringPool.BLANK);

		try {
			return Double.parseDouble(string);
		}
		catch (NumberFormatException nfe) {
			logError("Failed to parse " + string + " to double");

			return null;
		}
	}

	protected Long parseLong(String string) {
		if (blankNullOrNullString(string)) {
			return 0L;
		}

		try {
			return Long.parseLong(string);
		}
		catch (NumberFormatException nfe) {
			logError("Failed to parse " + string + " to long");

			return null;
		}
	}

	protected String processText(String string) {
		String processedText = HtmlUtil.escape(string);

		processedText = StringUtil.replace(processedText, OTHConstants.CHARACTER_BROKEN_VERTICAL_BAR, StringPool.PIPE);
		processedText = StringUtil.replace(processedText, OTHConstants.CHARACTER_TAB, "&nbsp;&nbsp;&nbsp;&nbsp;");
		processedText = StringUtil.replace(processedText, OTHConstants.CHARACTER_NEW_LINE, "<br/>");

		return processedText;
	}

	protected boolean reIndexOnLoad() {
		return false;
	}

	protected void setDataRequestLastUpdatedDate(
		long clientId, long caseId, long externalCaseId, DataRequestType dataRequestType) {

		dataRequestLocalService.setDataRequestLastUpdatedDate(clientId, caseId, externalCaseId, dataRequestType.name());
	}

	@Reference
	protected DataRequestLocalService dataRequestLocalService;

	@Reference
	protected GroupLocalService groupLocalService;

	@Reference
	protected IndexerRegistry indexerRegistry;

	@Reference
	protected IndexWriterHelper indexWriterHelper;

	protected Date minDate = new Date(0);

	private void _cleanIndex() {
		if (reIndexOnLoad()) {
			logInfo("Cleaning index for " + getEntityName());

			long companyId = PortalUtil.getDefaultCompanyId();

			try {
				indexWriterHelper.deleteEntityDocuments(getSearchEngineId(), companyId, getEntityClassName(), true);
				logInfo("Cleaning complete");
			}
			catch (SearchException e) {
				logWarn("Unable to delete documents", e);
			}
		}
	}

	private void _logEnd() {
		logInfo("Completed loading " + getEntityName() + " data");
	}

	private void _logFailure() {
		logError("Failed loading " + getEntityName() + " data");
	}

	private void _logStart() {
		logInfo("Loading " + getEntityName() + " data");
	}

	private Date _parseDate(String string, String datePattern) {
		if (blankNullOrNullString(string)) {
			return null;
		}

		try {
			DateFormat dateFormat = DateFormatFactoryUtil.getSimpleDateFormat(datePattern);

			return dateFormat.parse(string);
		}
		catch (ParseException pe) {
			logError("Failed to parse " + string + " to Date");

			return minDate;
		}
	}

	private static final String _NULL = "NULL";

	private static final String _ZEROS_REGEX = "0+";

	protected static final int _LOCAL_BATCH_SIZE = 200;

	private static final Log _log = LogFactoryUtil.getLog(BaseLoadService.class);

}