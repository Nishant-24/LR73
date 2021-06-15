package com.argus.oth.cases.management.upgrade.v3_0_3;

import com.argus.oth.cases.management.model.impl.AuthorizationImpl;
import com.argus.oth.cases.management.model.impl.StagingAuthorizationImpl;
import com.argus.oth.common.upgrade.BaseUpgradeProcess;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

import org.osgi.service.component.annotations.Component;

/**
 * @author Jaclyn Ong
 */
@Component(immediate = true, service = UpgradeProcess.class)
public class RecreateTableUpgradeProcess extends BaseUpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		_dropRecreateAuthorization();
		_dropRecreateStagingAuthorization();
	}

	private void _dropRecreateAuthorization() throws Exception {
		if (hasTable(AuthorizationImpl.TABLE_NAME)) {
			runSQL(AuthorizationImpl.TABLE_SQL_DROP);
		}

		runSQL(AuthorizationImpl.TABLE_SQL_CREATE);
	}

	private void _dropRecreateStagingAuthorization() throws Exception {
		if (hasTable(StagingAuthorizationImpl.TABLE_NAME)) {
			runSQL(StagingAuthorizationImpl.TABLE_SQL_DROP);
		}

		runSQL(StagingAuthorizationImpl.TABLE_SQL_CREATE);
	}

}