package com.argus.oth.integration.auth0.service.listener;

import com.argus.oth.integration.auth0.background.task.configuration.Auth0Configurator;
import com.argus.oth.integration.auth0.service.background.task.Auth0CreateUserTask;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.background.task.service.BackgroundTaskLocalService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModelListener;
import com.liferay.portal.kernel.model.ModelListener;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PwdGenerator;

import java.io.Serializable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Ricky Pan
 */
@Component(
	configurationPid = "com.argus.oth.integration.auth0.configuration.Auth0IntegrationConfiguration", immediate = true,
	service = ModelListener.class
)
public class Auth0UserListener extends BaseModelListener<User> {

	@Override
	public void onAfterCreate(User user) {
		if (_excludedUserEmails.contains(user.getEmailAddress())) {
			return;
		}

		ExpandoBridge expandoBridge = user.getExpandoBridge();

		boolean externalUser = GetterUtil.getBoolean(expandoBridge.getAttribute("external-user"));

		if (_auth0Configurator.isIntegrationEnabled() && externalUser) {
			try {
				User executionUser = _getExecutionUser();

				// generate random password for Auth0 user creation

				String password = PwdGenerator.getPassword(20);

				Map<String, Serializable> taskContextMap = _getTaskContextMap(user, password);

				_backgroundTaskLocalService.addBackgroundTask(
					executionUser.getUserId(), executionUser.getGroupId(), StringPool.BLANK,
					Auth0CreateUserTask.class.getName(), taskContextMap, new ServiceContext());
			}
			catch (Exception ae) {
				_log.error(String.format("Auth0 user creation request unsuccessful. See exception: "), ae);
			}
		}
	}

	private User _getExecutionUser() {
		long companyId = PortalUtil.getDefaultCompanyId();

		return _userLocalService.fetchUserByEmailAddress(companyId, _auth0Configurator.getExecutionUser());
	}

	private Map<String, Serializable> _getTaskContextMap(User user, String password) {
		Map<String, Serializable> taskContext = new HashMap<>();

		taskContext.put(Auth0CreateUserTask.EMAIL, user.getEmailAddress());
		taskContext.put(Auth0CreateUserTask.FIRST_NAME, user.getFirstName());
		taskContext.put(Auth0CreateUserTask.LAST_NAME, user.getLastName());
		taskContext.put(Auth0CreateUserTask.PASSWORD, password);
		taskContext.put(Auth0CreateUserTask.USER_ID, user.getUserId());

		return taskContext;
	}

	private static final Log _log = LogFactoryUtil.getLog(Auth0UserListener.class);

	private static final List<String> _excludedUserEmails = Arrays.asList(
		"default@liferay.com", "test@liferay.com", "admin-liferay@argus.bm", "admin-data@argus.bm");

	@Reference
	private Auth0Configurator _auth0Configurator;

	@Reference
	private BackgroundTaskLocalService _backgroundTaskLocalService;

	@Reference
	private UserLocalService _userLocalService;

}