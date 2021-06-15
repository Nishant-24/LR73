package com.argus.oth.data.generator.upgrade.v1_0_0;

import com.argus.oth.data.generator.DataGenerator;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Ricky Pan
 */
@Component(immediate = true, service = AddDataUpgradeProcess.class)
public class AddDataUpgradeProcess extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		_dataGenerator.addSampleData();
	}

	@Reference
	private DataGenerator _dataGenerator;

}