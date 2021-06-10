package com.argus.oth.claim.upgrade;

import com.liferay.portal.kernel.upgrade.DummyUpgradeStep;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eric Chin
 */
@Component(immediate = true, service = UpgradeStepRegistrator.class)
public class ClaimUpgradeStepRegistrator implements UpgradeStepRegistrator {

	@Override
	public void register(Registry registry) {
		registry.register("0.0.1", "1.0.0", new DummyUpgradeStep());

		registry.register("1.0.0", "1.0.1", _recreateClaimAnalyticsTableUpgradeProcess);

		registry.register("1.0.1", "1.0.2", _recreateClaimAnalyticsTableUpgradeProcess);
	}

	@Reference(target = "(component.name=com.argus.oth.claim.upgrade.common.RecreateClaimAnalyticsTableUpgradeProcess)")
	private UpgradeProcess _recreateClaimAnalyticsTableUpgradeProcess;

}