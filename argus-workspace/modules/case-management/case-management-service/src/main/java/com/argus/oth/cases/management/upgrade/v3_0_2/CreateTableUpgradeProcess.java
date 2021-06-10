package com.argus.oth.cases.management.upgrade.v3_0_2;

import com.argus.oth.cases.management.model.impl.NoteImpl;
import com.argus.oth.cases.management.model.impl.StagingNoteImpl;
import com.argus.oth.common.upgrade.BaseUpgradeProcess;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

import org.osgi.service.component.annotations.Component;

@Component(immediate = true, service = UpgradeProcess.class)
public class CreateTableUpgradeProcess extends BaseUpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		_upgradeNoteTable();
	}

	private void _upgradeNoteTable() throws Exception {
		if (hasTable(NoteImpl.TABLE_NAME)) {
			runSQL(NoteImpl.TABLE_SQL_DROP);
		}

		runSQL(NoteImpl.TABLE_SQL_CREATE);

		if (hasTable(StagingNoteImpl.TABLE_NAME)) {
			runSQL(StagingNoteImpl.TABLE_SQL_DROP);
		}

		runSQL(StagingNoteImpl.TABLE_SQL_CREATE);
	}

}