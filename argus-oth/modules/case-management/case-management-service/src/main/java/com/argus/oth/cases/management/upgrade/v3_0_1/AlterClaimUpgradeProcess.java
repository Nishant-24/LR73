package com.argus.oth.cases.management.upgrade.v3_0_1;

import com.argus.oth.cases.management.model.impl.ClaimImpl;
import com.argus.oth.cases.management.model.impl.StagingClaimImpl;
import com.argus.oth.common.upgrade.BaseUpgradeProcess;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

import org.osgi.service.component.annotations.Component;

/**
 * @author Jaclyn Ong
 */
@Component(immediate = true, service = UpgradeProcess.class)
public class AlterClaimUpgradeProcess extends BaseUpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		boolean tableCreated = false;

		if (!hasTable(ClaimImpl.TABLE_NAME)) {
			runSQL(ClaimImpl.TABLE_SQL_CREATE);

			tableCreated = true;
		}

		if (!hasTable(StagingClaimImpl.TABLE_NAME)) {
			runSQL(StagingClaimImpl.TABLE_SQL_CREATE);

			tableCreated = true;
		}

		if (tableCreated) {
			return;
		}

		addColumn(ClaimImpl.class, ClaimImpl.TABLE_NAME, "claimStatus", "VARCHAR(75)");
		addColumn(StagingClaimImpl.class, StagingClaimImpl.TABLE_NAME, "claimStatus", "VARCHAR(75)");
	}

}