package com.argus.oth.cases.management.upgrade.v4_0_1;

import com.argus.oth.cases.management.model.impl.AuthorizationImpl;
import com.argus.oth.cases.management.model.impl.StagingAuthorizationImpl;
import com.argus.oth.common.upgrade.BaseUpgradeProcess;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eric Chin
 */
@Component(immediate = true, service = UpgradeProcess.class)
public class RecreateAuthorizationTableUpgradeProcess extends BaseUpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		_upgradeNoteTable();
	}

	private void _upgradeNoteTable() throws Exception {
		if (hasTable(AuthorizationImpl.TABLE_NAME)) {
			runSQL(AuthorizationImpl.TABLE_SQL_DROP);
		}

		runSQL(AuthorizationImpl.TABLE_SQL_CREATE);

		if (hasTable(StagingAuthorizationImpl.TABLE_NAME)) {
			runSQL(StagingAuthorizationImpl.TABLE_SQL_DROP);
		}

		runSQL(StagingAuthorizationImpl.TABLE_SQL_CREATE);
	}

}