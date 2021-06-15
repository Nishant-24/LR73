package com.argus.oth.claim.upgrade.common;

import com.argus.oth.claim.model.impl.ClaimAnalyticsModelImpl;
import com.argus.oth.claim.model.impl.StagingClaimAnalyticsModelImpl;
import com.argus.oth.common.upgrade.BaseUpgradeProcess;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eric Chin
 */
@Component(immediate = true, service = UpgradeProcess.class)
public class RecreateClaimAnalyticsTableUpgradeProcess extends BaseUpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		_upgradeClaimAnalyticsTable();
	}

	private void _upgradeClaimAnalyticsTable() throws Exception {
		if (hasTable(ClaimAnalyticsModelImpl.TABLE_NAME)) {
			runSQL(ClaimAnalyticsModelImpl.TABLE_SQL_DROP);
		}

		runSQL(ClaimAnalyticsModelImpl.TABLE_SQL_CREATE);

		if (hasTable(StagingClaimAnalyticsModelImpl.TABLE_NAME)) {
			runSQL(StagingClaimAnalyticsModelImpl.TABLE_SQL_DROP);
		}

		runSQL(StagingClaimAnalyticsModelImpl.TABLE_SQL_CREATE);
	}

}