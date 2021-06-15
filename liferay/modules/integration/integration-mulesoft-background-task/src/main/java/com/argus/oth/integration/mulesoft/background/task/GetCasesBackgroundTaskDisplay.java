package com.argus.oth.integration.mulesoft.background.task;

import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.backgroundtask.display.BaseBackgroundTaskDisplay;
import com.liferay.portal.kernel.template.TemplateResource;

import java.util.Map;

/**
 * @author Jaclyn Ong
 */
public class GetCasesBackgroundTaskDisplay extends BaseBackgroundTaskDisplay {

	public GetCasesBackgroundTaskDisplay(BackgroundTask backgroundTask) {
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