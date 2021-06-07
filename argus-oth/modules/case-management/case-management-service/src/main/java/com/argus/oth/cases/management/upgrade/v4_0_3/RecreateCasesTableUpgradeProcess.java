package com.argus.oth.cases.management.upgrade.v4_0_3;

import com.argus.oth.cases.management.model.impl.CasesImpl;
import com.argus.oth.cases.management.model.impl.StagingCasesImpl;
import com.argus.oth.common.upgrade.BaseUpgradeProcess;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eric Chin
 */
@Component(immediate = true, service = UpgradeProcess.class)
public class RecreateCasesTableUpgradeProcess extends BaseUpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		_upgradeCasesTable();
	}

	private void _upgradeCasesTable() throws Exception {
		if (hasTable(CasesImpl.TABLE_NAME)) {
			runSQL(CasesImpl.TABLE_SQL_DROP);
		}

		runSQL(CasesImpl.TABLE_SQL_CREATE);

		if (hasTable(StagingCasesImpl.TABLE_NAME)) {
			runSQL(StagingCasesImpl.TABLE_SQL_DROP);
		}

		runSQL(StagingCasesImpl.TABLE_SQL_CREATE);
	}

}