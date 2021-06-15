package com.argus.oth.cases.management.upgrade.v4_0_7;

import com.argus.oth.cases.management.model.impl.CasesImpl;
import com.argus.oth.cases.management.model.impl.DataRequestImpl;
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
		_upgradeDataRequestTable();
	}

	private void _upgradeCasesTable() throws Exception {
		if (hasTable(CasesImpl.TABLE_NAME)) {
			runSQL(CasesImpl.TABLE_SQL_DROP);
		}

		runSQL(CasesImpl.TABLE_SQL_CREATE);
	}

	private void _upgradeDataRequestTable() throws Exception {
		if (hasTable(DataRequestImpl.TABLE_NAME)) {
			runSQL(DataRequestImpl.TABLE_SQL_DROP);
		}

		runSQL(DataRequestImpl.TABLE_SQL_CREATE);
	}

}