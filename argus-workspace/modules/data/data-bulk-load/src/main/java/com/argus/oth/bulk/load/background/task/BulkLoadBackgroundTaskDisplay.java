package com.argus.oth.bulk.load.background.task;

import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.backgroundtask.display.BaseBackgroundTaskDisplay;
import com.liferay.portal.kernel.template.TemplateResource;

import java.util.Map;

/**
 * @author Davy Duran
 */
public class BulkLoadBackgroundTaskDisplay extends BaseBackgroundTaskDisplay {

	public BulkLoadBackgroundTaskDisplay(BackgroundTask backgroundTask) {
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