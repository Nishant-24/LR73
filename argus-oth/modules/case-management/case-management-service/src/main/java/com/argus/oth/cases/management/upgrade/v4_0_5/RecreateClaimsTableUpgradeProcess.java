package com.argus.oth.cases.management.upgrade.v4_0_5;

import com.argus.oth.cases.management.model.impl.ClaimImpl;
import com.argus.oth.cases.management.model.impl.StagingClaimImpl;
import com.argus.oth.common.upgrade.BaseUpgradeProcess;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eric Chin
 */
@Component(immediate = true, service = UpgradeProcess.class)
public class RecreateClaimsTableUpgradeProcess extends BaseUpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		_upgradeClaimsTable();
	}

	private void _upgradeClaimsTable() throws Exception {
		if (hasTable(ClaimImpl.TABLE_NAME)) {
			runSQL(ClaimImpl.TABLE_SQL_DROP);
		}

		runSQL(ClaimImpl.TABLE_SQL_CREATE);

		if (hasTable(StagingClaimImpl.TABLE_NAME)) {
			runSQL(StagingClaimImpl.TABLE_SQL_DROP);
		}

		runSQL(StagingClaimImpl.TABLE_SQL_CREATE);
	}

}