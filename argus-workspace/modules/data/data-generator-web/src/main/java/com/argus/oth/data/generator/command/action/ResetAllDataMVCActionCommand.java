package com.argus.oth.data.generator.command.action;

import com.argus.oth.data.generator.DataGenerator;
import com.argus.oth.data.generator.constants.SampleDataGeneratorCommandNames;
import com.argus.oth.data.generator.constants.SampleDataGeneratorPortletKeys;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.PortalUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Davy Duran
 */
@Component(
	immediate = true,
	property = {
		"javax.portlet.name=" + SampleDataGeneratorPortletKeys.SAMPLE_DATA_GENERATOR_PORTLET,
		"mvc.command.name=" + SampleDataGeneratorCommandNames.ACTION_RESET_ALL_DATA
	},
	service = MVCActionCommand.class
)
public class ResetAllDataMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException {

		try {
			long companyId = PortalUtil.getCompanyId(actionRequest);

			_dataGenerator.deleteAllData(companyId);

			_dataGenerator.addSampleData();
		}
		catch (Exception e) {
			_log.error(e, e);

			SessionErrors.add(actionRequest, e.getClass());
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(
		ResetAllDataMVCActionCommand.class);

	@Reference
	private DataGenerator _dataGenerator;

}