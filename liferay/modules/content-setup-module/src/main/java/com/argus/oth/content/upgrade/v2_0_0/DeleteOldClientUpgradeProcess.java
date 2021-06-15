package com.argus.oth.content.upgrade.v2_0_0;

import com.argus.oth.cases.management.service.ClientLocalService;
import com.argus.oth.common.upgrade.BaseUpgradeProcess;

import com.liferay.portal.kernel.upgrade.UpgradeProcess;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jaclyn Ong
 */
@Component(immediate = true, service = UpgradeProcess.class)
public class DeleteOldClientUpgradeProcess extends BaseUpgradeProcess {

	@Override
	protected void doUpgrade() {
		_clientLocalService.deleteAllClients();
	}

	@Reference
	private ClientLocalService _clientLocalService;

}