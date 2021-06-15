package com.argus.oth.data.export.background.task;

import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.backgroundtask.display.BaseBackgroundTaskDisplay;
import com.liferay.portal.kernel.template.TemplateResource;

import java.util.Map;

/**
 * @author Eric Chin
 */
public class DataExportBackgroundTaskDisplay extends BaseBackgroundTaskDisplay {

	public DataExportBackgroundTaskDisplay(BackgroundTask backgroundTask) {
		super(backgroundTask);
	}

	@Override
	public int getPercentage() {
		if (backgroundTask.isCompleted()) {
			return 100;
		}

		return 0;
	}

	@Override
	protected TemplateResource getTemplateResource() {
		return null;
	}

	@Override
	protected Map<String, Object> getTemplateVars() {
		return null;
	}

}