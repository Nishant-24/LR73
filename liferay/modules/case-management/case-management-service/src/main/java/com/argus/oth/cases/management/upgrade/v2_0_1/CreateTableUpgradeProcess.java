package com.argus.oth.cases.management.upgrade.v2_0_1;

import com.argus.oth.cases.management.model.impl.ReferenceTypeCodeImpl;
import com.argus.oth.cases.management.model.impl.StagingReferenceTypeCodeImpl;
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
		if (!hasTable(StagingReferenceTypeCodeImpl.TABLE_NAME)) {
			runSQL(StagingReferenceTypeCodeImpl.TABLE_SQL_CREATE);

			runSQL("create index IX_38814F59 on OTH_StagingReferenceTypeCode (externalReferenceTypeCodeId)");

			runSQL("create index IX_A7AAA5AD on OTH_StagingReferenceTypeCode (key_[$COLUMN_LENGTH:75$])");
		}

		if (!hasTable(ReferenceTypeCodeImpl.TABLE_NAME)) {
			runSQL(ReferenceTypeCodeImpl.TABLE_SQL_CREATE);

			runSQL("create index IX_5D929836 on OTH_ReferenceTypeCode (externalReferenceTypeCodeId)");

			runSQL("create index IX_1108D170 on OTH_ReferenceTypeCode (key_[$COLUMN_LENGTH:75$])");

			runSQL("create index IX_DCF0DB9 on OTH_ReferenceTypeCode (type_[$COLUMN_LENGTH:75$])");
		}
	}

}