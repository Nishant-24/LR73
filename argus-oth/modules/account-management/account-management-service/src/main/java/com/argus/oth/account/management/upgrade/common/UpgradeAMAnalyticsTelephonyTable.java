package com.argus.oth.account.management.upgrade.common;

import com.argus.oth.account.management.model.impl.AMAnalyticsTelephonyModelImpl;
import com.argus.oth.account.management.model.impl.StagingAMATelephonyModelImpl;
import com.argus.oth.common.upgrade.BaseUpgradeProcess;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eric Chin
 */
@Component(immediate = true, service = UpgradeProcess.class)
public class UpgradeAMAnalyticsTelephonyTable extends BaseUpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		_upgradeAMAAnalyticsTelephonyTables();
	}

	private void _upgradeAMAAnalyticsTelephonyTables() throws Exception {
		if (hasTable(AMAnalyticsTelephonyModelImpl.TABLE_NAME)) {
			runSQL(AMAnalyticsTelephonyModelImpl.TABLE_SQL_DROP);
		}

		runSQL(AMAnalyticsTelephonyModelImpl.TABLE_SQL_CREATE);

		if (hasTable(StagingAMATelephonyModelImpl.TABLE_NAME)) {
			runSQL(StagingAMATelephonyModelImpl.TABLE_SQL_DROP);
		}

		runSQL(StagingAMATelephonyModelImpl.TABLE_SQL_CREATE);
	}

}