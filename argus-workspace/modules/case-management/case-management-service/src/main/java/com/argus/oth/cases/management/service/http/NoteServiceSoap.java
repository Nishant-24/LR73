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

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>NoteServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * ServiceBuilder follows certain rules in translating the methods. For example,
 * if the method in the service utility returns a <code>java.util.List</code>,
 * that is translated to an array of
 * <code>com.argus.oth.cases.management.model.NoteSoap</code>. If the method in the
 * service utility returns a
 * <code>com.argus.oth.cases.management.model.Note</code>, that is translated to a
 * <code>com.argus.oth.cases.management.model.NoteSoap</code>. Methods that SOAP
 * cannot safely wire are skipped.
 * </p>
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see NoteServiceHttp
 * @generated
 */
public class NoteServiceSoap {

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use <code>NoteServiceUtil</code> to access the note remote service.
	 */
	public static String addNote(
			String uuid, long groupId, long caseId, String callee,
			String caller, String code, String direction, long externalNoteId,
			java.util.Date noteCreateDate, String noteType, String type,
			String text, String processStatus, String failureDescription,
			long userId, String noteAuthor)
		throws RemoteException {

		try {
			com.liferay.portal.kernel.json.JSONObject returnValue =
				NoteServiceUtil.addNote(
					uuid, groupId, caseId, callee, caller, code, direction,
					externalNoteId, noteCreateDate, noteType, type, text,
					processStatus, failureDescription, userId, noteAuthor);

			return returnValue.toString();
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static int countNotesByCaseId(long caseId) throws RemoteException {
		try {
			int returnValue = NoteServiceUtil.countNotesByCaseId(caseId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.argus.oth.cases.management.model.NoteSoap[]
			getNotesByCaseId(long caseId, int start, int end)
		throws RemoteException {

		try {
			java.util.List<com.argus.oth.cases.management.model.Note>
				returnValue = NoteServiceUtil.getNotesByCaseId(
					caseId, start, end);

			return com.argus.oth.cases.management.model.NoteSoap.toSoapModels(
				returnValue);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(NoteServiceSoap.class);

}