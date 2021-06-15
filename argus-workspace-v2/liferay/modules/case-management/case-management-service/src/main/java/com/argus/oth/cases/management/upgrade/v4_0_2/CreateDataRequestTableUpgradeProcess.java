package com.argus.oth.cases.management.upgrade.v4_0_2;

import com.argus.oth.cases.management.model.impl.DataRequestImpl;
import com.argus.oth.common.upgrade.BaseUpgradeProcess;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eric Chin
 */
@Component(immediate = true, service = UpgradeProcess.class)
public class CreateDataRequestTableUpgradeProcess extends BaseUpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		_createDataRequestTable();
	}

	private void _createDataRequestTable() throws Exception {
		if (hasTable(DataRequestImpl.TABLE_NAME)) {
			runSQL(DataRequestImpl.TABLE_SQL_DROP);
		}

		runSQL(DataRequestImpl.TABLE_SQL_CREATE);
	}

}