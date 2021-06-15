package com.argus.oth.data.generator.command.action;

import com.argus.oth.bulk.load.background.task.service.BulkLoadService;
import com.argus.oth.data.generator.constants.SampleDataGeneratorCommandNames;
import com.argus.oth.data.generator.constants.SampleDataGeneratorPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

/**
 * @author Davy Duran
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + SampleDataGeneratorPortletKeys.SAMPLE_DATA_GENERATOR_PORTLET,
		"mvc.command.name=" + SampleDataGeneratorCommandNames.ACTION_EXECUTE_BULK_LOAD
	},
	service = MVCActionCommand.class
)
public class ExecuteBulkLoadMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException {

		try {
			_bulkLoadService.startBulkLoadPipeLine();
		}
		catch (Exception e) {
			_log.error(e, e);

			SessionErrors.add(actionRequest, e.getClass());
		}
	}

	@Reference
	private BulkLoadService _bulkLoadService;

	private static final Log _log = LogFactoryUtil.getLog(
		ExecuteBulkLoadMVCActionCommand.class);

}