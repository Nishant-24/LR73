package com.argus.oth.cases.management.upgrade.common;

import com.argus.oth.cases.management.model.impl.AuthorizationImpl;
import com.argus.oth.cases.management.model.impl.CasesImpl;
import com.argus.oth.cases.management.model.impl.ClaimDetailImpl;
import com.argus.oth.cases.management.model.impl.ClaimImpl;
import com.argus.oth.cases.management.model.impl.ClientGroupImpl;
import com.argus.oth.cases.management.model.impl.ClientImpl;
import com.argus.oth.cases.management.model.impl.MemberImpl;
import com.argus.oth.cases.management.model.impl.NoteImpl;
import com.argus.oth.cases.management.model.impl.ReferenceTypeCodeImpl;
import com.argus.oth.cases.management.model.impl.StagingAuthorizationImpl;
import com.argus.oth.cases.management.model.impl.StagingCasesImpl;
import com.argus.oth.cases.management.model.impl.StagingClaimDetailImpl;
import com.argus.oth.cases.management.model.impl.StagingClaimImpl;
import com.argus.oth.cases.management.model.impl.StagingClientGroupImpl;
import com.argus.oth.cases.management.model.impl.StagingClientImpl;
import com.argus.oth.cases.management.model.impl.StagingMemberImpl;
import com.argus.oth.cases.management.model.impl.StagingNoteImpl;
import com.argus.oth.cases.management.model.impl.StagingReferenceTypeCodeImpl;
import com.argus.oth.cases.management.model.impl.StagingTaskImpl;
import com.argus.oth.cases.management.model.impl.TaskImpl;
import com.argus.oth.common.upgrade.BaseUpgradeProcess;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

import org.osgi.service.component.annotations.Component;

/**
 * @author Jaclyn Ong
 */
@Component(immediate = true, service = UpgradeProcess.class)
public class RecreateAllTablesUpgradeProcess extends BaseUpgradeProcess {

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
		if (hasTable(StagingAuthorizationImpl.TABLE_NAME)) {
			runSQL(StagingAuthorizationImpl.TABLE_SQL_DROP);
		}

		runSQL(StagingAuthorizationImpl.TABLE_SQL_CREATE);

		if (hasTable(AuthorizationImpl.TABLE_NAME)) {
			runSQL(AuthorizationImpl.TABLE_SQL_DROP);
		}

		runSQL(AuthorizationImpl.TABLE_SQL_CREATE);
	}

	private void _upgradeCasesTable() throws Exception {
		if (hasTable(StagingCasesImpl.TABLE_NAME)) {
			runSQL(StagingCasesImpl.TABLE_SQL_DROP);
		}

		runSQL(StagingCasesImpl.TABLE_SQL_CREATE);

		if (hasTable(CasesImpl.TABLE_NAME)) {
			runSQL(CasesImpl.TABLE_SQL_DROP);
		}

		runSQL(CasesImpl.TABLE_SQL_CREATE);
	}

	private void _upgradeClaimDetailTable() throws Exception {
		if (hasTable(StagingClaimDetailImpl.TABLE_NAME)) {
			runSQL(StagingClaimDetailImpl.TABLE_SQL_DROP);
		}

		runSQL(StagingClaimDetailImpl.TABLE_SQL_CREATE);

		if (hasTable(ClaimDetailImpl.TABLE_NAME)) {
			runSQL(ClaimDetailImpl.TABLE_SQL_DROP);
		}

		runSQL(ClaimDetailImpl.TABLE_SQL_CREATE);
	}

	private void _upgradeClaimTable() throws Exception {
		if (hasTable(StagingClaimImpl.TABLE_NAME)) {
			runSQL(StagingClaimImpl.TABLE_SQL_DROP);
		}

		runSQL(StagingClaimImpl.TABLE_SQL_CREATE);

		if (hasTable(ClaimImpl.TABLE_NAME)) {
			runSQL(ClaimImpl.TABLE_SQL_DROP);
		}

		runSQL(ClaimImpl.TABLE_SQL_CREATE);
	}

	private void _upgradeClientGroupTable() throws Exception {
		if (hasTable(StagingClientGroupImpl.TABLE_NAME)) {
			runSQL(StagingClientGroupImpl.TABLE_SQL_DROP);
		}

		runSQL(StagingClientGroupImpl.TABLE_SQL_CREATE);

		if (hasTable(ClientGroupImpl.TABLE_NAME)) {
			runSQL(ClientGroupImpl.TABLE_SQL_DROP);
		}

		runSQL(ClientGroupImpl.TABLE_SQL_CREATE);
	}

	private void _upgradeClientTable() throws Exception {
		if (hasTable(StagingClientImpl.TABLE_NAME)) {
			runSQL(StagingClientImpl.TABLE_SQL_DROP);
		}

		runSQL(StagingClientImpl.TABLE_SQL_CREATE);

		if (hasTable(ClientImpl.TABLE_NAME)) {
			runSQL(ClientImpl.TABLE_SQL_DROP);
		}

		runSQL(ClientImpl.TABLE_SQL_CREATE);
	}

	private void _upgradeMemberTable() throws Exception {
		if (hasTable(StagingMemberImpl.TABLE_NAME)) {
			runSQL(StagingMemberImpl.TABLE_SQL_DROP);
		}

		runSQL(StagingMemberImpl.TABLE_SQL_CREATE);

		if (hasTable(MemberImpl.TABLE_NAME)) {
			runSQL(MemberImpl.TABLE_SQL_DROP);
		}

		runSQL(MemberImpl.TABLE_SQL_CREATE);
	}

	private void _upgradeNoteTable() throws Exception {
		if (hasTable(StagingNoteImpl.TABLE_NAME)) {
			runSQL(StagingNoteImpl.TABLE_SQL_DROP);
		}

		runSQL(StagingNoteImpl.TABLE_SQL_CREATE);

		if (hasTable(NoteImpl.TABLE_NAME)) {
			runSQL(NoteImpl.TABLE_SQL_DROP);
		}

		runSQL(NoteImpl.TABLE_SQL_CREATE);
	}

	private void _upgradeReferenceTypeCodeTable() throws Exception {
		if (hasTable(StagingReferenceTypeCodeImpl.TABLE_NAME)) {
			runSQL(StagingReferenceTypeCodeImpl.TABLE_SQL_DROP);
		}

		runSQL(StagingReferenceTypeCodeImpl.TABLE_SQL_CREATE);

		if (hasTable(ReferenceTypeCodeImpl.TABLE_NAME)) {
			runSQL(ReferenceTypeCodeImpl.TABLE_SQL_DROP);
		}

		runSQL(ReferenceTypeCodeImpl.TABLE_SQL_CREATE);
	}

	private void _upgradeTaskTable() throws Exception {
		if (hasTable(StagingTaskImpl.TABLE_NAME)) {
			runSQL(StagingTaskImpl.TABLE_SQL_DROP);
		}

		runSQL(StagingTaskImpl.TABLE_SQL_CREATE);

		if (hasTable(TaskImpl.TABLE_NAME)) {
			runSQL(TaskImpl.TABLE_SQL_DROP);
		}

		runSQL(TaskImpl.TABLE_SQL_CREATE);
	}

}