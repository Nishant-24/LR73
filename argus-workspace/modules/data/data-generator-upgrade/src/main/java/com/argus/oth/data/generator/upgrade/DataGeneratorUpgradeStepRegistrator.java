package com.argus.oth.data.generator.upgrade;

import com.liferay.portal.kernel.module.framework.ModuleServiceLifecycle;
import com.liferay.portal.upgrade.registry.UpgradeStepRegistrator;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Ricky Pan
 *
 * This class keeps track of dependencies for the scripts in this module.
 * The scripts will not run until all of the references are satisfied.
 */
@Component(immediate = true, service = UpgradeStepRegistrator.class)
public class DataGeneratorUpgradeStepRegistrator implements UpgradeStepRegistrator {

	@Override
	public void register(Registry registry) {
		registry.register("0.0.0", "0.0.1", _dataGeneratorUpgradeSteps);
	}

	@Reference(target = ModuleServiceLifecycle.SYSTEM_CHECK, unbind = "-")
	protected void setModuleServiceLifecycle(ModuleServiceLifecycle moduleServiceLifecycle) {
	}

	@Reference(target = "(component.name=com.argus.oth.content.upgrade.ContentSetupUpgradeStepRegistrator)")
	private UpgradeStepRegistrator _contentSetupUpgradeStepRegistrator;

	@Reference
	private DataGeneratorUpgradeSteps _dataGeneratorUpgradeSteps;

}