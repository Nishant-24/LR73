package com.argus.oth.account.management.upgrade.common;

import com.argus.oth.account.management.model.impl.AMAnalyticsDBModelImpl;
import com.argus.oth.account.management.model.impl.StagingAMAnalyticsDBModelImpl;
import com.argus.oth.common.upgrade.BaseUpgradeProcess;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eric Chin
 */
@Component(immediate = true, service = UpgradeProcess.class)
public class UpgradeAMAnalyticsDBTable extends BaseUpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		_upgradeAMAnalyticsDBTables();
	}

	private void _upgradeAMAnalyticsDBTables() throws Exception {
		if (hasTable(AMAnalyticsDBModelImpl.TABLE_NAME)) {
			runSQL(AMAnalyticsDBModelImpl.TABLE_SQL_DROP);
		}

		runSQL(AMAnalyticsDBModelImpl.TABLE_SQL_CREATE);

		if (hasTable(StagingAMAnalyticsDBModelImpl.TABLE_NAME)) {
			runSQL(StagingAMAnalyticsDBModelImpl.TABLE_SQL_DROP);
		}

		runSQL(StagingAMAnalyticsDBModelImpl.TABLE_SQL_CREATE);
	}

}