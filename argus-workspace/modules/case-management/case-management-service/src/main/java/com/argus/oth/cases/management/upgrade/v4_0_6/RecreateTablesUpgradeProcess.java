package com.argus.oth.cases.management.upgrade.v4_0_6;

import com.argus.oth.cases.management.model.impl.AuthorizationImpl;
import com.argus.oth.cases.management.model.impl.CasesImpl;
import com.argus.oth.cases.management.model.impl.ClaimDetailImpl;
import com.argus.oth.cases.management.model.impl.ClaimImpl;
import com.argus.oth.cases.management.model.impl.ClientGroupImpl;
import com.argus.oth.cases.management.model.impl.ClientImpl;
import com.argus.oth.cases.management.model.impl.MemberImpl;
import com.argus.oth.cases.management.model.impl.NoteImpl;
import com.argus.oth.cases.management.model.impl.ReferenceTypeCodeImpl;
import com.argus.oth.cases.management.model.impl.TaskImpl;
import com.argus.oth.common.upgrade.BaseUpgradeProcess;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

import org.osgi.service.component.annotations.Component;

/**
 * @author Jaclyn Ong
 */
@Component(immediate = true, service = UpgradeProcess.class)
public class RecreateTablesUpgradeProcess extends BaseUpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		_upgradeAuthorizationTable();

		_upgradeCasesTable();

		_upgradeClaimDetailTable();

		_upgradeClaimTable();

		_upgradeClientGroupTable();

		_upgradeClientTable();

		_upgradeMemberTable();

		_upgradeNoteTable();

		_upgradeReferenceTypeCodeTable();

		_upgradeTaskTable();
	}

	private void _upgradeAuthorizationTable() throws Exception {
		if (hasTable(AuthorizationImpl.TABLE_NAME)) {
			runSQL(AuthorizationImpl.TABLE_SQL_DROP);
		}

		runSQL(AuthorizationImpl.TABLE_SQL_CREATE);
	}

	private void _upgradeCasesTable() throws Exception {
		if (hasTable(CasesImpl.TABLE_NAME)) {
			runSQL(CasesImpl.TABLE_SQL_DROP);
		}

		runSQL(CasesImpl.TABLE_SQL_CREATE);
	}

	private void _upgradeClaimDetailTable() throws Exception {
		if (hasTable(ClaimDetailImpl.TABLE_NAME)) {
			runSQL(ClaimDetailImpl.TABLE_SQL_DROP);
		}

		runSQL(ClaimDetailImpl.TABLE_SQL_CREATE);
	}

	private void _upgradeClaimTable() throws Exception {
		if (hasTable(ClaimImpl.TABLE_NAME)) {
			runSQL(ClaimImpl.TABLE_SQL_DROP);
		}

		runSQL(ClaimImpl.TABLE_SQL_CREATE);
	}

	private void _upgradeClientGroupTable() throws Exception {
		if (hasTable(ClientGroupImpl.TABLE_NAME)) {
			runSQL(ClientGroupImpl.TABLE_SQL_DROP);
		}

		runSQL(ClientGroupImpl.TABLE_SQL_CREATE);
	}

	private void _upgradeClientTable() throws Exception {
		if (hasTable(ClientImpl.TABLE_NAME)) {
			runSQL(ClientImpl.TABLE_SQL_DROP);
		}

		runSQL(ClientImpl.TABLE_SQL_CREATE);
	}

	private void _upgradeMemberTable() throws Exception {
		if (hasTable(MemberImpl.TABLE_NAME)) {
			runSQL(MemberImpl.TABLE_SQL_DROP);
		}

		runSQL(MemberImpl.TABLE_SQL_CREATE);
	}

	private void _upgradeNoteTable() throws Exception {
		if (hasTable(NoteImpl.TABLE_NAME)) {
			runSQL(NoteImpl.TABLE_SQL_DROP);
		}

		runSQL(NoteImpl.TABLE_SQL_CREATE);
	}

	private void _upgradeReferenceTypeCodeTable() throws Exception {
		if (hasTable(ReferenceTypeCodeImpl.TABLE_NAME)) {
			runSQL(ReferenceTypeCodeImpl.TABLE_SQL_DROP);
		}

		runSQL(ReferenceTypeCodeImpl.TABLE_SQL_CREATE);
	}

	private void _upgradeTaskTable() throws Exception {
		if (hasTable(TaskImpl.TABLE_NAME)) {
			runSQL(TaskImpl.TABLE_SQL_DROP);
		}

		runSQL(TaskImpl.TABLE_SQL_CREATE);
	}

}