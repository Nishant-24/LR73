package com.argus.oth.content.upgrade.v1_0_0;

import com.argus.oth.common.helper.OTHCommonHelper;
import com.argus.oth.content.upgrade.constants.ContentSetupKeys;

import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.CompanyLocalService;
import com.liferay.portal.kernel.service.RoleLocalService;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.upgrade.UpgradeProcess;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.UnicodeProperties;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = UpgradeProcess.class)
public class AddUsersUpgradeProcess extends UpgradeProcess {

	@Override
	protected void doUpgrade() throws Exception {
		_disableStrangerAccounts();

		long groupId = _othCommonHelper.getOTHPortalGroupId();

		User liferayAdmin = _userLocalService.addUser(
			_userLocalService.getDefaultUserId(PortalUtil.getDefaultCompanyId()), //creatorUserId
				PortalUtil.getDefaultCompanyId(), //companyId
				true, //autoPassword
				null, //password1
				null, //password2
				false, //autoScreenName
				"admin-liferay", //screenName
				"admin-liferay@argus.bm", //emailAddress
				0, //facebookId
				null, //openId
				LocaleUtil.getDefault(), //locale
				"Liferay", //firstName
				"", //middleName
				"Admin", //lastName
				0, //prefixId
				0, //suffixId
				true, //male
				0, //birthdayMonth
				1, //birthdayDay
				1970, //birthdayYear
				null, //jobTitle
				null, //groupIds
				null, //organizationIds
				null, //roleIds
				null, //userGroupIds
				false, //sendEmail
				null); //serviceContext

		_roleLocalService.addUserRole(
			liferayAdmin.getUserId(),
			_roleLocalService.fetchRole(PortalUtil.getDefaultCompanyId(), "OTH User Administrator"));

		User dataAdmin = _userLocalService.addUser(
			_userLocalService.getDefaultUserId(PortalUtil.getDefaultCompanyId()), //creatorUserId
				PortalUtil.getDefaultCompanyId(), //companyId
				true, //autoPassword
				null, //password1
				null, //password2
				false, //autoScreenName
				"admin-data", //screenName
				"admin-data@argus.bm", //emailAddress
				0, //facebookId
				null, //openId
				LocaleUtil.getDefault(), //locale
				"Data", //firstName
				"", //middleName
				"Admin", //lastName
				0, //prefixId
				0, //suffixId
				true, //male
				0, //birthdayMonth
				1, //birthdayDay
				1970, //birthdayYear
				null, //jobTitle
				new long[] {groupId}, //groupIds
				null, //organizationIds
				null, //roleIds
				null, //userGroupIds
				false, //sendEmail
				null); //serviceContext

		_roleLocalService.addUserRole(
			dataAdmin.getUserId(), _roleLocalService.fetchRole(PortalUtil.getDefaultCompanyId(), "Data Administrator"));

		_roleLocalService.addUserRole(
			dataAdmin.getUserId(),
			_roleLocalService.fetchRole(PortalUtil.getDefaultCompanyId(), ContentSetupKeys.CARRIER_CASE_MANAGER));

		_othCommonHelper.setUserClientId(dataAdmin, ContentSetupKeys.DATA_ADMIN_DEFAULT_CLIENT_ID);
	}

	private void _disableStrangerAccounts() throws Exception {
		long companyId = PortalUtil.getDefaultCompanyId();

		UnicodeProperties properties = new UnicodeProperties(true);

		properties.setProperty(PropsKeys.COMPANY_SECURITY_STRANGERS, "false");
		properties.setProperty(PropsKeys.COMPANY_SECURITY_STRANGERS_WITH_MX, "false");

		_companyLocalService.updatePreferences(companyId, properties);
	}

	@Reference
	private CompanyLocalService _companyLocalService;

	@Reference
	private OTHCommonHelper _othCommonHelper;

	@Reference
	private RoleLocalService _roleLocalService;

	@Reference
	private UserLocalService _userLocalService;

}