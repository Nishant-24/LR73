package com.argus.oth.bulk.load.background.task.service;

import com.argus.oth.bulk.load.background.task.ValidationException;
import com.argus.oth.bulk.load.background.task.service.util.FixedBatchSpliteratorWrapper;
import com.argus.oth.common.OTHConstants;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import java.nio.charset.Charset;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

import org.osgi.service.component.annotations.Reference;

/**
 * @author Jaclyn Ong
 */
public abstract class BaseFileLoadStagingService<T> {

	public abstract void cleanup();

	public abstract String getEntityName();

	public void process(String fullFilePath, final boolean validateLines, int batchSize) throws Exception {
		File file = loadFile(fullFilePath);

		String entityName = getEntityName();

		logInfo("Validating and loading " + entityName + " into staging table");

		try (BufferedReader bufferedReader = new BufferedReader(
				new InputStreamReader(new FileInputStream(file), Charset.forName(OTHConstants.CHARSET_WINDOWS_1252)))) {

			int fileFieldLength = getMaxFieldArrayLength();

			HashMap<Integer, String> headers = getHeaders();

			AtomicLong count = new AtomicLong(0);

			_validateFirstLine(bufferedReader.readLine(), fileFieldLength, entityName, headers);

			Stream<String> lines = FixedBatchSpliteratorWrapper.toFixedBatchStream(bufferedReader.lines(), batchSize);

			lines.forEach(
				line -> {
					try {
						_processLine(line, fileFieldLength, entityName, count, validateLines);
					}
					catch (Exception e) {
						throw new IllegalStateException(e);
					}
				});
		}

		logInfo("Completed validation and loading " + entityName + " into staging table");

		_clearCache();
	}

	private void _clearCache() {
		logInfo("Cleaning cache all caches");
		EntityCacheUtil.clearCache();
		FinderCacheUtil.clearCache();
		logInfo("Cache clean");
	}

	protected String getFileMissingMessage(String entityName) {
		return String.format(_FILE_MISSING_FAILURE_FORMAT_STRING, entityName);
	}

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

	protected abstract HashMap<Integer, String> getHeaders();

	protected abstract int getMaxFieldArrayLength();

	protected int getMaxFieldArrayPosition() {
		return getMaxFieldArrayLength() - 1;
	}

	protected abstract T getStagingModel(String[] fields);

	protected abstract String getStagingModelClassName();

	protected abstract void insert(T stagingModel) throws Exception;

	protected void insertStagingRecord(T stagingModel) throws Exception {
		try {
			insert(stagingModel);
		}
		catch (Exception e) {
			logError(
				String.format(
					"Failed to insert staging record for %s: %s%s", getEntityName(), StringPool.NEW_LINE,
					stagingModel.toString()));

			throw e;
		}
	}

	protected File loadFile(String fullFilePath) throws ValidationException {
		if (Validator.isBlank(fullFilePath)) {
			String errorMessage = "Local file path and file name are not configured";

			if (_log.isErrorEnabled()) {
				_log.error(errorMessage);
			}

			throw new ValidationException(errorMessage);
		}

		File file = new File(fullFilePath);

		if (!file.exists() || (file.length() == 0)) {
			if (_log.isErrorEnabled()) {
				_log.error("File " + fullFilePath + " does not exist or is empty");
			}

			throw new ValidationException(getFileMissingMessage(file.getName()));
		}

		return file;
	}

	protected void logDebug(String message) {
		if (_log.isDebugEnabled()) {
			_log.debug(message);
		}
	}

	protected void logError(String msg) {
		if (_log.isErrorEnabled()) {
			_log.error(msg);
		}
	}

	protected void logInfo(String message) {
		if (_log.isInfoEnabled()) {
			_log.info(message);
		}
	}

	protected void validate(T stagingModel) throws ValidationException {
		LoadService<T> loadService = LoadServiceFactory.getLoadServiceByStagingModel(getStagingModelClassName());

		if (!loadService.validate(stagingModel)) {
			throw new ValidationException(
				"Validation failed for " + getEntityName() + "; full data: " + stagingModel.toString());
		}
	}

	@Reference
	protected GroupLocalService groupLocalService;

	private void _processLine(
			String line, int fileFieldLength, String entityName, AtomicLong count, boolean validateLines)
		throws Exception {

		String[] fields = line.split(StringPool.TAB, -1);

		_validateFieldsLength(line, fileFieldLength, entityName, fields);

		T stagingModel = getStagingModel(fields);

		if (validateLines) {
			validate(stagingModel);
		}

		insert(stagingModel);

		long c = count.incrementAndGet();

		if ((c % 10000) == 0) {
			logInfo(count + " lines processed");

			if ((c % 250000) == 0) {
				_clearCache();
			}
		}
	}

	private void _validateFieldsLength(String line, int fileFieldLength, String entityName, String[] fields)
		throws ValidationException {

		if (fields.length < fileFieldLength) {
			String errorMessage = "Line in " + entityName + " file is missing one or more fields, skipping: " + line;

			logError(errorMessage);

			throw new ValidationException(errorMessage);
		}
	}

	private void _validateFirstLine(
			String line, int fileFieldLength, String entityName, HashMap<Integer, String> headers)
		throws ValidationException {

		String[] fields = line.split(StringPool.TAB, -1);

		_validateFieldsLength(line, fileFieldLength, entityName, fields);

		for (Map.Entry<Integer, String> header : headers.entrySet()) {
			Integer headerPosition = header.getKey();

			String headerName = header.getValue();

			if (!headerName.equalsIgnoreCase(fields[headerPosition])) {
				String errorMessage = "Missing header " + headerName + " for " + entityName;

				logError(errorMessage);

				throw new ValidationException(errorMessage);
			}
		}
	}

	private static final String _FILE_MISSING_FAILURE_FORMAT_STRING = "%s file does not exist in zip file";

	private static final Log _log = LogFactoryUtil.getLog(BaseFileLoadStagingService.class);

}