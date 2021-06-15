package com.argus.oth.integration.auth0.service.background.task;

import com.argus.oth.integration.auth0.Auth0Integration;
import com.argus.oth.integration.auth0.dto.Auth0Response;

import com.liferay.portal.kernel.backgroundtask.BackgroundTask;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskConstants;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.BackgroundTaskResult;
import com.liferay.portal.kernel.backgroundtask.BaseBackgroundTaskExecutor;
import com.liferay.portal.kernel.backgroundtask.display.BackgroundTaskDisplay;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;

import java.io.Serializable;

import java.util.Map;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jaclyn Ong
 */
@Component(
	immediate = true,
	property = "background.task.executor.class.name=com.argus.oth.integration.auth0.service.background.task.Auth0CreateUserTask",
	service = BackgroundTaskExecutor.class
)
public class Auth0CreateUserTask extends BaseBackgroundTaskExecutor {

	public static final String EMAIL = "email";

	public static final String FIRST_NAME = "firstName";

	public static final String LAST_NAME = "lastName";

	public static final String PASSWORD = "password";

	public static final String USER_ID = "userId";

	@Override
	public BackgroundTaskExecutor clone() {
		Auth0CreateUserTask auth0CreateUserTask = new Auth0CreateUserTask();

		auth0CreateUserTask.setAuth0Integration(_auth0Integration);

		return auth0CreateUserTask;
	}

	@Override
	public BackgroundTaskResult execute(BackgroundTask backgroundTask) {
		try {
			Map<String, Serializable> contextMap = backgroundTask.getTaskContextMap();

			long userId = GetterUtil.getLong(contextMap.get(USER_ID));
			String firstName = GetterUtil.getString(contextMap.get(FIRST_NAME));
			String lastName = GetterUtil.getString(contextMap.get(LAST_NAME));
			String email = GetterUtil.getString(contextMap.get(EMAIL));
			String password = GetterUtil.getString(contextMap.get(PASSWORD));

			boolean result = _createUser(userId, firstName, lastName, email, password);

			if (!result) {
				return new BackgroundTaskResult(BackgroundTaskConstants.STATUS_FAILED);
			}
		}
		catch (Exception e) {
			if (_log.isErrorEnabled()) {
				_log.error("Failed to create Auth0 user", e);
			}

			return new BackgroundTaskResult(BackgroundTaskConstants.STATUS_FAILED);
		}

		return BackgroundTaskResult.SUCCESS;
	}

	@Override
	public BackgroundTaskDisplay getBackgroundTaskDisplay(BackgroundTask backgroundTask) {
		return new Auth0BackgroundTaskDisplay(backgroundTask);
	}

	@Reference(unbind = "-")
	protected void setAuth0Integration(Auth0Integration auth0Integration) {
		_auth0Integration = auth0Integration;
	}

	private boolean _createUser(long userId, String firstName, String lastName, String email, String password)
		throws Exception {

		Auth0Response response = _auth0Integration.createUser(firstName, lastName, email, password);

		if (response.getStatus().equals(Auth0Response.Status.FAILURE)) {
			_log.error(
				String.format(
					"Auth0 user unable to be created for User with id: %s, with response: %s", userId,
					response.getMessage()));

			return false;
		}

		return true;
	}

	private static final Log _log = LogFactoryUtil.getLog(Auth0CreateUserTask.class);

	private Auth0Integration _auth0Integration;

}