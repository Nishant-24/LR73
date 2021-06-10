package com.argus.oth.account.management.upgrade.common;

import com.argus.oth.common.upgrade.BaseUpgradeProcess;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eric Chin
 */
@Component(immediate = true, service = UpgradeProcess.class)
public class UpgradeAccountManagementTables extends BaseUpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		_upgradeAMAnalyticsClaimTableUpgradeProcess.upgrade();
		_upgradeAMAnalyticsDBTableUpgradeProcess.upgrade();
		_upgradeAMAAnalyticsTelephonyTableUpgradeProcess.upgrade();
	}

	@Reference(
		target = "(component.name=com.argus.oth.account.management.upgrade.common.UpgradeAMAnalyticsTelephonyTable)"
	)
	private UpgradeProcess _upgradeAMAAnalyticsTelephonyTableUpgradeProcess;

	@Reference(target = "(component.name=com.argus.oth.account.management.upgrade.common.UpgradeAMAnalyticsClaimTable)")
	private UpgradeProcess _upgradeAMAnalyticsClaimTableUpgradeProcess;

	@Reference(target = "(component.name=com.argus.oth.account.management.upgrade.common.UpgradeAMAnalyticsDBTable)")
	private UpgradeProcess _upgradeAMAnalyticsDBTableUpgradeProcess;

}