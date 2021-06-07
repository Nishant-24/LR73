package com.argus.oth.cases.management.upgrade.v2_0_0;

import com.argus.oth.cases.management.model.impl.ClientImpl;
import com.argus.oth.common.upgrade.BaseUpgradeProcess;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

import org.osgi.service.component.annotations.Component;

/**
 * @author Jaclyn Ong
 */
@Component(immediate = true, service = UpgradeProcess.class)
public class AlterClientUpgradeProcess extends BaseUpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		if (!hasTable(ClientImpl.TABLE_NAME)) {
			runSQL(ClientImpl.TABLE_SQL_CREATE);

			return;
		}

		addColumn(ClientImpl.class, ClientImpl.TABLE_NAME, "externalClientPk", "LONG");
	}

}