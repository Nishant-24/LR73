package com.argus.oth.content.upgrade.v2_0_5;

import com.argus.oth.common.ExpandoConstants;

import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoColumnConstants;
import com.liferay.expando.kernel.model.ExpandoTable;
import com.liferay.expando.kernel.model.ExpandoTableConstants;
import com.liferay.expando.kernel.service.ExpandoColumnLocalService;
import com.liferay.expando.kernel.service.ExpandoTableLocalService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.Portal;

import java.util.Objects;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = UpgradeProcess.class)
public class UpdateCustomFieldsUpgradeProcess extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		_updateUserExpandoColumns();
	}

	private void _updateUserExpandoColumns() throws PortalException {
		long companyId = _portal.getDefaultCompanyId();

		String className = User.class.getName();

		ExpandoTable expandoTable = _expandoTableLocalService.fetchTable(
			companyId, _portal.getClassNameId(className), ExpandoTableConstants.DEFAULT_TABLE_NAME);

		if (Objects.isNull(expandoTable)) {
			_log.error("User ExpandoTable not found");

			return;
		}

		long expandoTableId = expandoTable.getTableId();

		ExpandoColumn clientIdColumn = _expandoColumnLocalService.getColumn(expandoTableId, ExpandoConstants.CLIENT_ID);

		_expandoColumnLocalService.updateColumn(
			clientIdColumn.getColumnId(), ExpandoConstants.CLIENT_ID, ExpandoColumnConstants.LONG, 0L);

		ExpandoColumn externalUserColumn = _expandoColumnLocalService.getColumn(
			expandoTableId, ExpandoConstants.EXTERNAL_USER);

		_expandoColumnLocalService.updateColumn(
			externalUserColumn.getColumnId(), ExpandoConstants.EXTERNAL_USER, ExpandoColumnConstants.BOOLEAN, true);

		if (_log.isInfoEnabled()) {
			_log.info("Updated clientID and externalUser columns for User table");
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(UpdateCustomFieldsUpgradeProcess.class);

	@Reference
	private ExpandoColumnLocalService _expandoColumnLocalService;

	@Reference
	private ExpandoTableLocalService _expandoTableLocalService;

	@Reference
	private Portal _portal;

}