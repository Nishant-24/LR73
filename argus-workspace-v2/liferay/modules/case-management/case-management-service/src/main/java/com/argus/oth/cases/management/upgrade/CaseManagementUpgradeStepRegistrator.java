package com.argus.oth.cases.management.upgrade;

import com.liferay.portal.kernel.upgrade.DummyUpgradeStep;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jaclyn Ong
 */
@Component(immediate = true, service = UpgradeStepRegistrator.class)
public class CaseManagementUpgradeStepRegistrator implements UpgradeStepRegistrator {

	@Override
	public void register(Registry registry) {
		registry.register("0.0.1", "1.0.0", new DummyUpgradeStep());

		registry.register("1.0.0", "2.0.0", new DummyUpgradeStep());

		registry.register(
			"1.0.0", "2.0.0", _alterStagingCasesUpgradeProcess, _alterStagingClientUpgradeProcess,
			_alterClientUpgradeProcess, _createTableUpgradeProcess);

		registry.register("2.0.0", "2.0.1", _createTableUpgradeProcess_v2_0_1);

		registry.register("2.0.1", "3.0.0", _createTableUpgradeProcess_v3_0_0);

		registry.register("3.0.0", "3.0.1", _alterClaimUpgradeProcess);

		registry.register("3.0.1", "3.0.2", _createTableUpgradeProcess_v3_0_2);

		registry.register("3.0.2", "3.0.3", _recreateTableUpgradeProcess);

		// Adding another version here due to an increase in version being deployed

		registry.register("3.0.3", "3.0.4", _recreateTableUpgradeProcess);

		registry.register("3.0.4", "3.0.5", _recreateTableUpgradeProcess_v3_0_5);

		registry.register("3.0.5", "3.0.6", _createTableUpgradeProcess_v3_0_6);

		registry.register("3.0.6", "4.0.0", _recreateTableUpgradeProcess_4_0_0);

		registry.register("4.0.0", "4.0.1", _recreateAuthorizationTableUpgradeProcess_4_0_1);

		registry.register("4.0.1", "4.0.2", _createDataRequestTableUpgradeProcess);

		registry.register("4.0.2", "4.0.3", _recreateCasesTableUpgradeProcess_v4_0_3);

		registry.register("4.0.3", "4.0.4", _recreateClaimsTableUpgradeProcess_v4_0_4);

		registry.register("4.0.4", "4.0.5", _recreateClaimsTableUpgradeProcess_v4_0_5);

		registry.register("4.0.5", "4.0.6", _recreateTablesUpgradeProcess_v4_0_6);

		registry.register("4.0.6", "4.0.7", _recreateCasesTableUpgradeProcess_v4_0_7);

		registry.register("4.0.7", "4.0.8", _recreateAllTablesUpgradeProcess);
	}

	@Reference(target = "(component.name=com.argus.oth.cases.management.upgrade.v3_0_1.AlterClaimUpgradeProcess)")
	private UpgradeProcess _alterClaimUpgradeProcess;

	@Reference(target = "(component.name=com.argus.oth.cases.management.upgrade.v2_0_0.AlterClientUpgradeProcess)")
	private UpgradeProcess _alterClientUpgradeProcess;

	@Reference(
		target = "(component.name=com.argus.oth.cases.management.upgrade.v2_0_0.AlterStagingCasesUpgradeProcess)"
	)
	private UpgradeProcess _alterStagingCasesUpgradeProcess;

	@Reference(
		target = "(component.name=com.argus.oth.cases.management.upgrade.v2_0_0.AlterStagingClientUpgradeProcess)"
	)
	private UpgradeProcess _alterStagingClientUpgradeProcess;

	@Reference(
		target = "(component.name=com.argus.oth.cases.management.upgrade.v4_0_2.CreateDataRequestTableUpgradeProcess)"
	)
	private UpgradeProcess _createDataRequestTableUpgradeProcess;

	@Reference(target = "(component.name=com.argus.oth.cases.management.upgrade.v2_0_0.CreateTableUpgradeProcess)")
	private UpgradeProcess _createTableUpgradeProcess;

	@Reference(target = "(component.name=com.argus.oth.cases.management.upgrade.v2_0_1.CreateTableUpgradeProcess)")
	private UpgradeProcess _createTableUpgradeProcess_v2_0_1;

	@Reference(target = "(component.name=com.argus.oth.cases.management.upgrade.v3_0_0.CreateTableUpgradeProcess)")
	private UpgradeProcess _createTableUpgradeProcess_v3_0_0;

	@Reference(target = "(component.name=com.argus.oth.cases.management.upgrade.v3_0_2.CreateTableUpgradeProcess)")
	private UpgradeProcess _createTableUpgradeProcess_v3_0_2;

	@Reference(target = "(component.name=com.argus.oth.cases.management.upgrade.v3_0_6.CreateTableUpgradeProcess)")
	private UpgradeProcess _createTableUpgradeProcess_v3_0_6;

	@Reference(
		target = "(component.name=com.argus.oth.cases.management.upgrade.common.RecreateAllTablesUpgradeProcess)"
	)
	private UpgradeProcess _recreateAllTablesUpgradeProcess;

	@Reference(
		target = "(component.name=com.argus.oth.cases.management.upgrade.v4_0_1.RecreateAuthorizationTableUpgradeProcess)"
	)
	private UpgradeProcess _recreateAuthorizationTableUpgradeProcess_4_0_1;

	@Reference(
		target = "(component.name=com.argus.oth.cases.management.upgrade.v4_0_3.RecreateCasesTableUpgradeProcess)"
	)
	private UpgradeProcess _recreateCasesTableUpgradeProcess_v4_0_3;

	@Reference(
		target = "(component.name=com.argus.oth.cases.management.upgrade.v4_0_7.RecreateCasesTableUpgradeProcess)"
	)
	private UpgradeProcess _recreateCasesTableUpgradeProcess_v4_0_7;

	@Reference(
		target = "(component.name=com.argus.oth.cases.management.upgrade.v4_0_4.RecreateClaimsTableUpgradeProcess)"
	)
	private UpgradeProcess _recreateClaimsTableUpgradeProcess_v4_0_4;

	@Reference(
		target = "(component.name=com.argus.oth.cases.management.upgrade.v4_0_5.RecreateClaimsTableUpgradeProcess)"
	)
	private UpgradeProcess _recreateClaimsTableUpgradeProcess_v4_0_5;

	@Reference(target = "(component.name=com.argus.oth.cases.management.upgrade.v4_0_6.RecreateTablesUpgradeProcess)")
	private UpgradeProcess _recreateTablesUpgradeProcess_v4_0_6;

	@Reference(target = "(component.name=com.argus.oth.cases.management.upgrade.v3_0_3.RecreateTableUpgradeProcess)")
	private UpgradeProcess _recreateTableUpgradeProcess;

	@Reference(target = "(component.name=com.argus.oth.cases.management.upgrade.v4_0_0.RecreateTableUpgradeProcess)")
	private UpgradeProcess _recreateTableUpgradeProcess_4_0_0;

	@Reference(target = "(component.name=com.argus.oth.cases.management.upgrade.v3_0_5.RecreateTableUpgradeProcess)")
	private UpgradeProcess _recreateTableUpgradeProcess_v3_0_5;

}