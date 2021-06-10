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

import com.argus.oth.cases.management.service.CasesServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>CasesServiceUtil</code> service
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
 * @see CasesServiceSoap
 * @generated
 */
public class CasesServiceHttp {

	public static com.argus.oth.cases.management.model.Cases fetchCaseByCaseId(
			HttpPrincipal httpPrincipal, long caseId)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				CasesServiceUtil.class, "fetchCaseByCaseId",
				_fetchCaseByCaseIdParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey, caseId);

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

			return (com.argus.oth.cases.management.model.Cases)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.argus.oth.cases.management.model.Cases
		fetchCaseByExternalCaseId(
			HttpPrincipal httpPrincipal, long externalCaseId) {

		try {
			MethodKey methodKey = new MethodKey(
				CasesServiceUtil.class, "fetchCaseByExternalCaseId",
				_fetchCaseByExternalCaseIdParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, externalCaseId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.argus.oth.cases.management.model.Cases)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.argus.oth.cases.management.model.Cases fetchCases(
		HttpPrincipal httpPrincipal, long caseId) {

		try {
			MethodKey methodKey = new MethodKey(
				CasesServiceUtil.class, "fetchCases",
				_fetchCasesParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, caseId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.argus.oth.cases.management.model.Cases)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.argus.oth.cases.management.model.Cases>
			getCasesByG_C(
				HttpPrincipal httpPrincipal, long groupId, long clientId)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				CasesServiceUtil.class, "getCasesByG_C",
				_getCasesByG_CParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, groupId, clientId);

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

			return (java.util.List<com.argus.oth.cases.management.model.Cases>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(CasesServiceHttp.class);

	private static final Class<?>[] _fetchCaseByCaseIdParameterTypes0 =
		new Class[] {long.class};
	private static final Class<?>[] _fetchCaseByExternalCaseIdParameterTypes1 =
		new Class[] {long.class};
	private static final Class<?>[] _fetchCasesParameterTypes2 = new Class[] {
		long.class
	};
	private static final Class<?>[] _getCasesByG_CParameterTypes3 =
		new Class[] {long.class, long.class};

}