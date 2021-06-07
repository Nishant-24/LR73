package com.argus.oth.cases.management.upgrade.v3_0_6;

import com.argus.oth.cases.management.model.impl.CasesGroupItemImpl;
import com.argus.oth.common.upgrade.BaseUpgradeProcess;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

import org.osgi.service.component.annotations.Component;

/**
 * @author Jaclyn Ong
 */
@Component(immediate = true, service = UpgradeProcess.class)
public class CreateTableUpgradeProcess extends BaseUpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		_createCasesGroupItemTable();
	}

	private void _createCasesGroupItemTable() throws Exception {
		if (hasTable(CasesGroupItemImpl.TABLE_NAME)) {
			runSQL(CasesGroupItemImpl.TABLE_SQL_DROP);
		}

		runSQL(CasesGroupItemImpl.TABLE_SQL_CREATE);
	}

}