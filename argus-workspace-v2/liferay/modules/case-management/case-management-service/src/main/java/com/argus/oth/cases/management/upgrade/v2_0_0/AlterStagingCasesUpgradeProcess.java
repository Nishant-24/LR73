package com.argus.oth.cases.management.upgrade.v2_0_0;

import com.argus.oth.cases.management.model.impl.StagingCasesImpl;
import com.argus.oth.common.upgrade.BaseUpgradeProcess;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

import org.osgi.service.component.annotations.Component;

/**
 * @author Jaclyn Ong
 */
@Component(immediate = true, service = UpgradeProcess.class)
public class AlterStagingCasesUpgradeProcess extends BaseUpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		if (!hasTable(StagingCasesImpl.TABLE_NAME)) {
			runSQL(StagingCasesImpl.TABLE_SQL_CREATE);

			return;
		}

		renameColumn(StagingCasesImpl.class, StagingCasesImpl.TABLE_NAME, "caseId", "stagingCaseId");

		renameColumn(StagingCasesImpl.class, StagingCasesImpl.TABLE_NAME, "clientId", "externalClientPk");
	}

}