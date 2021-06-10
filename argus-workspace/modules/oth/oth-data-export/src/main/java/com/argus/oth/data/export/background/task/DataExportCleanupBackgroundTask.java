package com.argus.oth.data.export.background.task;

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
import com.liferay.portal.kernel.util.Validator;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import java.util.Map;

import org.apache.commons.io.FileUtils;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eric Chin
 */
@Component(
	immediate = true,
	property = "background.task.executor.class.name=com.argus.oth.data.export.background.task.DataExportCleanupBackgroundTask",
	service = BackgroundTaskExecutor.class
)
public class DataExportCleanupBackgroundTask extends BaseBackgroundTaskExecutor {

	public static final String EXPORT_OUTPUT_TMP_DIR = "EXPORT_OUTPUT_TMP_DIR";

	@Override
	public BackgroundTaskExecutor clone() {
		return new DataExportCleanupBackgroundTask();
	}

	@Override
	public BackgroundTaskResult execute(BackgroundTask backgroundTask) throws Exception {
		Map<String, Serializable> taskContextMap = backgroundTask.getTaskContextMap();

		String tmpDir = GetterUtil.getString(taskContextMap.get(EXPORT_OUTPUT_TMP_DIR));

		String errorMessage = StringPool.BLANK;

		if (Validator.isNull(tmpDir)) {
			errorMessage = "Output directory " + tmpDir + " is missing";
		}

		try {
			FileUtils.deleteDirectory(new File(tmpDir));
		}
		catch (IOException ioe) {
			_log.error("Failed to delete folder", ioe);

			errorMessage = "Failed to delete folder " + tmpDir;
		}

		if (Validator.isNotNull(errorMessage)) {
			return new BackgroundTaskResult(BackgroundTaskConstants.STATUS_FAILED, errorMessage);
		}

		_log.info("Deleted folder " + tmpDir);

		return BackgroundTaskResult.SUCCESS;
	}

	@Override
	public BackgroundTaskDisplay getBackgroundTaskDisplay(BackgroundTask backgroundTask) {
		return new DataExportBackgroundTaskDisplay(backgroundTask);
	}

	private static final Log _log = LogFactoryUtil.getLog(DataExportCleanupBackgroundTask.class);

}