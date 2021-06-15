package com.argus.oth.data.generator.upgrade;

import com.argus.oth.data.generator.upgrade.v1_0_0.AddDataUpgradeProcess;

import com.liferay.portal.kernel.upgrade.UpgradeException;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PropsUtil;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Ricky Pan
 */
@Component(immediate = true, service = DataGeneratorUpgradeSteps.class)
public class DataGeneratorUpgradeSteps extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws UpgradeException {
		boolean addSampleData = GetterUtil.getBoolean(PropsUtil.get(AUTOCREATE_SAMPLE_DATA), false);

		if (addSampleData) {
			upgrade(_addDataUpgradeProcess);
		}
	}

	private static final String AUTOCREATE_SAMPLE_DATA = "autocreate.sample.data";

	@Reference
	private AddDataUpgradeProcess _addDataUpgradeProcess;

}