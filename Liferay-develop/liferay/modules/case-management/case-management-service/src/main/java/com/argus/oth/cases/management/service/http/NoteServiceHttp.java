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

import com.argus.oth.cases.management.service.NoteServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>NoteServiceUtil</code> service
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
 * @see NoteServiceSoap
 * @generated
 */
public class NoteServiceHttp {

	public static com.liferay.portal.kernel.json.JSONObject addNote(
			HttpPrincipal httpPrincipal, String uuid, long groupId, long caseId,
			String callee, String caller, String code, String direction,
			long externalNoteId, java.util.Date noteCreateDate, String noteType,
			String type, String text, String processStatus,
			String failureDescription, long userId, String noteAuthor)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				NoteServiceUtil.class, "addNote", _addNoteParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, uuid, groupId, caseId, callee, caller, code,
				direction, externalNoteId, noteCreateDate, noteType, type, text,
				processStatus, failureDescription, userId, noteAuthor);

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

	public static int countNotesByCaseId(
			HttpPrincipal httpPrincipal, long caseId)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				NoteServiceUtil.class, "countNotesByCaseId",
				_countNotesByCaseIdParameterTypes1);

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

			return ((Integer)returnObj).intValue();
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List<com.argus.oth.cases.management.model.Note>
			getNotesByCaseId(
				HttpPrincipal httpPrincipal, long caseId, int start, int end)
		throws Exception {

		try {
			MethodKey methodKey = new MethodKey(
				NoteServiceUtil.class, "getNotesByCaseId",
				_getNotesByCaseIdParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, caseId, start, end);

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

			return (java.util.List<com.argus.oth.cases.management.model.Note>)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(NoteServiceHttp.class);

	private static final Class<?>[] _addNoteParameterTypes0 = new Class[] {
		String.class, long.class, long.class, String.class, String.class,
		String.class, String.class, long.class, java.util.Date.class,
		String.class, String.class, String.class, String.class, String.class,
		long.class, String.class
	};
	private static final Class<?>[] _countNotesByCaseIdParameterTypes1 =
		new Class[] {long.class};
	private static final Class<?>[] _getNotesByCaseIdParameterTypes2 =
		new Class[] {long.class, int.class, int.class};

}