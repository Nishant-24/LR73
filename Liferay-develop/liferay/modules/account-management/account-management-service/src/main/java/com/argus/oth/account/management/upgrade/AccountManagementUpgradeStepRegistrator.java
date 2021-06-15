package com.argus.oth.account.management.upgrade;

import com.liferay.portal.kernel.upgrade.DummyUpgradeStep;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eric Chin
 */
@Component(immediate = true, service = UpgradeStepRegistrator.class)
public class AccountManagementUpgradeStepRegistrator implements UpgradeStepRegistrator {

	@Override
	public void register(Registry registry) {
		registry.register("0.0.1", "1.0.0", new DummyUpgradeStep());

		registry.register("1.0.0", "1.0.1", _upgradeAccountManagementTablesUpgradeProcess);

		registry.register("1.0.1", "1.0.2", _upgradeAccountManagementTablesUpgradeProcess);

		registry.register("1.0.2", "1.0.3", _upgradeAccountManagementTablesUpgradeProcess);

		registry.register("1.0.3", "1.0.4", _upgradeAMAnalyticsDBTableUpgradeProcess);
	}

	@Reference(
		target = "(component.name=com.argus.oth.account.management.upgrade.common.UpgradeAccountManagementTables)"
	)
	private UpgradeProcess _upgradeAccountManagementTablesUpgradeProcess;

	@Reference(target = "(component.name=com.argus.oth.account.management.upgrade.common.UpgradeAMAnalyticsDBTable)")
	private UpgradeProcess _upgradeAMAnalyticsDBTableUpgradeProcess;

}