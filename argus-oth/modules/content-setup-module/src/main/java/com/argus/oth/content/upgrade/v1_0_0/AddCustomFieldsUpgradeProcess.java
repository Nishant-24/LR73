package com.argus.oth.content.upgrade.v1_0_0;

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
import com.liferay.portal.kernel.util.UnicodeProperties;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = UpgradeProcess.class)
public class AddCustomFieldsUpgradeProcess extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		_addUserExpandoColumns();
	}

	private void _addUserExpandoColumn(
			String columnName, int dataType, Object defaultValue, UnicodeProperties unicodeProperties)
		throws PortalException {

		long companyId = _portal.getDefaultCompanyId();

		String className = User.class.getName();

		ExpandoTable expandoTable = _expandoTableLocalService.fetchTable(
			companyId, _portal.getClassNameId(className), ExpandoTableConstants.DEFAULT_TABLE_NAME);

		if (expandoTable == null) {
			expandoTable = _expandoTableLocalService.addTable(
				companyId, className, ExpandoTableConstants.DEFAULT_TABLE_NAME);
		}

		ExpandoColumn expandoColumn = _expandoColumnLocalService.addColumn(
			expandoTable.getTableId(), columnName, dataType, defaultValue);

		expandoColumn.setTypeSettingsProperties(unicodeProperties);

		_expandoColumnLocalService.updateExpandoColumn(expandoColumn);

		if (_log.isInfoEnabled()) {
			_log.info(String.format("Added an expando column for className, %s, with name %s", className, columnName));
		}
	}

	private void _addUserExpandoColumns() throws PortalException {
		UnicodeProperties properties = new UnicodeProperties();

		_addUserExpandoColumn(ExpandoConstants.CLIENT_ID, ExpandoColumnConstants.LONG, 9999L, properties);

		properties.put(ExpandoColumnConstants.PROPERTY_DISPLAY_TYPE_CHECKBOX, Boolean.TRUE.toString());

		_addUserExpandoColumn(ExpandoConstants.EXTERNAL_USER, ExpandoColumnConstants.BOOLEAN, false, properties);
	}

	private static final Log _log = LogFactoryUtil.getLog(AddCustomFieldsUpgradeProcess.class);

	@Reference
	private ExpandoColumnLocalService _expandoColumnLocalService;

	@Reference
	private ExpandoTableLocalService _expandoTableLocalService;

	@Reference
	private Portal _portal;

}