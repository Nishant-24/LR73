package com.argus.oth.cases.management.upgrade.v3_0_0;

import com.argus.oth.cases.management.model.impl.AuthProcedureImpl;
import com.argus.oth.cases.management.model.impl.AuthorizationImpl;
import com.argus.oth.cases.management.model.impl.ClaimDetailImpl;
import com.argus.oth.cases.management.model.impl.ClaimImpl;
import com.argus.oth.cases.management.model.impl.StagingAuthProcedureImpl;
import com.argus.oth.cases.management.model.impl.StagingAuthorizationImpl;
import com.argus.oth.cases.management.model.impl.StagingClaimDetailImpl;
import com.argus.oth.cases.management.model.impl.StagingClaimImpl;
import com.argus.oth.common.upgrade.BaseUpgradeProcess;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eric Chin
 */
@Component(immediate = true, service = UpgradeProcess.class)
public class CreateTableUpgradeProcess extends BaseUpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		if (!hasTable(AuthorizationImpl.TABLE_NAME)) {
			runSQL(AuthorizationImpl.TABLE_SQL_CREATE);
		}

		if (!hasTable(StagingAuthorizationImpl.TABLE_NAME)) {
			runSQL(StagingAuthorizationImpl.TABLE_SQL_CREATE);
		}

		if (!hasTable(AuthProcedureImpl.TABLE_NAME)) {
			runSQL(AuthProcedureImpl.TABLE_SQL_CREATE);
		}

		if (!hasTable(StagingAuthProcedureImpl.TABLE_NAME)) {
			runSQL(StagingAuthProcedureImpl.TABLE_SQL_CREATE);
		}

		_upgradeClaimTable();
		_upgradeClaimDetailTable();
	}

	private void _upgradeClaimDetailTable() throws Exception {
		if (hasTable(ClaimDetailImpl.TABLE_NAME)) {
			runSQL(ClaimDetailImpl.TABLE_SQL_DROP);
		}

		runSQL(ClaimDetailImpl.TABLE_SQL_CREATE);

		if (hasTable(StagingClaimDetailImpl.TABLE_NAME)) {
			runSQL(StagingClaimDetailImpl.TABLE_SQL_DROP);
		}

		runSQL(StagingClaimDetailImpl.TABLE_SQL_CREATE);
	}

	private void _upgradeClaimTable() throws Exception {
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