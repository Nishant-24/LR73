package com.argus.oth.cases.management.upgrade.v2_0_0;

import com.argus.oth.cases.management.model.impl.CasesImpl;
import com.argus.oth.cases.management.model.impl.NoteImpl;
import com.argus.oth.cases.management.model.impl.StagingNoteImpl;
import com.argus.oth.cases.management.model.impl.StagingTaskImpl;
import com.argus.oth.cases.management.model.impl.TaskImpl;
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
		if (!hasTable(CasesImpl.TABLE_NAME)) {
			runSQL(CasesImpl.TABLE_SQL_CREATE);
		}

		if (!hasTable(NoteImpl.TABLE_NAME)) {
			runSQL(NoteImpl.TABLE_SQL_CREATE);
		}

		if (!hasTable(StagingNoteImpl.TABLE_NAME)) {
			runSQL(StagingNoteImpl.TABLE_SQL_CREATE);
		}

		if (!hasTable(TaskImpl.TABLE_NAME)) {
			runSQL(TaskImpl.TABLE_SQL_CREATE);
		}

		if (!hasTable(StagingTaskImpl.TABLE_NAME)) {
			runSQL(StagingTaskImpl.TABLE_SQL_CREATE);
		}
	}

}