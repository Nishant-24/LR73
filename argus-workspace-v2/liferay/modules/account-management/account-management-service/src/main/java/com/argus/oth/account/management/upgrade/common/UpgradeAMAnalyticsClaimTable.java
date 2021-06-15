package com.argus.oth.account.management.upgrade.common;

import com.argus.oth.account.management.model.impl.AMAnalyticsClaimModelImpl;
import com.argus.oth.account.management.model.impl.StagingAMAnalyticsClaimModelImpl;
import com.argus.oth.common.upgrade.BaseUpgradeProcess;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eric Chin
 */
@Component(immediate = true, service = UpgradeProcess.class)
public class UpgradeAMAnalyticsClaimTable extends BaseUpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		_upgradeAMAnalyticsClaimTables();
	}

	private void _upgradeAMAnalyticsClaimTables() throws Exception {
		if (hasTable(AMAnalyticsClaimModelImpl.TABLE_NAME)) {
			runSQL(AMAnalyticsClaimModelImpl.TABLE_SQL_DROP);
		}

		runSQL(AMAnalyticsClaimModelImpl.TABLE_SQL_CREATE);

		if (hasTable(StagingAMAnalyticsClaimModelImpl.TABLE_NAME)) {
			runSQL(StagingAMAnalyticsClaimModelImpl.TABLE_SQL_DROP);
		}

		runSQL(StagingAMAnalyticsClaimModelImpl.TABLE_SQL_CREATE);
	}

}