/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.argus.oth.cases.management.service.http;

import com.argus.oth.cases.management.service.AuthorizationServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>AuthorizationServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuthorizationServiceSoap
 * @generated
 */
public class AuthorizationServiceHttp {

	public static com.liferay.portal.kernel.json.JSONObject authorize(
			HttpPrincipal httpPrincipal,
			com.argus.oth.cases.management.model.Authorization authorization,
			String rtcAuthorizationStatus, String processStatus,
			long modifiedUserId, String comments)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				AuthorizationServiceUtil.class, "authorize",
				_authorizeParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, authorization, rtcAuthorizationStatus, processStatus,
				modifiedUserId, comments);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof Exception) {
					throw (Exception)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.liferay.portal.kernel.json.JSONObject)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<com.argus.oth.cases.management.model.Authorization>
				getAuthorizationsByCaseId(
					HttpPrincipal httpPrincipal, long caseId,
					long externalCaseId, int start, int end)
			throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				AuthorizationServiceUtil.class, "getAuthorizationsByCaseId",
				_getAuthorizationsByCaseIdParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, caseId, externalCaseId, start, end);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof Exception) {
					throw (Exception)exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.argus.oth.cases.management.model.Authorization>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		AuthorizationServiceHttp.class);

	private static final Class<?>[] _authorizeParameterTypes0 = new Class[] {
		com.argus.oth.cases.management.model.Authorization.class, String.class,
		String.class, long.class, String.class
	};
	private static final Class<?>[] _getAuthorizationsByCaseIdParameterTypes1 =
		new Class[] {long.class, long.class, int.class, int.class};

}