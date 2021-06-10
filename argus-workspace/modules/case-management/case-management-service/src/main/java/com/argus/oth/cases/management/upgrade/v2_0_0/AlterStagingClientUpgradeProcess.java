package com.argus.oth.cases.management.upgrade.v2_0_0;

import com.argus.oth.cases.management.model.impl.StagingClientImpl;
import com.argus.oth.common.upgrade.BaseUpgradeProcess;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

import org.osgi.service.component.annotations.Component;

/**
 * @author Jaclyn Ong
 */
@Component(immediate = true, service = UpgradeProcess.class)
public class AlterStagingClientUpgradeProcess extends BaseUpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		if (!hasTable(StagingClientImpl.TABLE_NAME)) {
			runSQL(StagingClientImpl.TABLE_SQL_CREATE);

			return;
		}

		renameColumn(StagingClientImpl.class, StagingClientImpl.TABLE_NAME, "clientId", "stagingClientId");

		renameColumn(StagingClientImpl.class, StagingClientImpl.TABLE_NAME, "externalClientId", "externalClientPk");

		addColumn(StagingClientImpl.class, StagingClientImpl.TABLE_NAME, "clientId", "VARCHAR(75)");
	}

}