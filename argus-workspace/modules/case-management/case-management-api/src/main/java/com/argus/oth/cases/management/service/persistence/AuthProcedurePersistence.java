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

package com.argus.oth.cases.management.service.persistence;

import com.argus.oth.cases.management.exception.NoSuchAuthProcedureException;
import com.argus.oth.cases.management.model.AuthProcedure;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the auth procedure service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AuthProcedureUtil
 * @generated
 */
@ProviderType
public interface AuthProcedurePersistence
	extends BasePersistence<AuthProcedure> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AuthProcedureUtil} to access the auth procedure persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the auth procedures where authNumber = &#63;.
	 *
	 * @param authNumber the auth number
	 * @return the matching auth procedures
	 */
	public java.util.List<AuthProcedure> findByAuthNumber(String authNumber);

	/**
	 * Returns a range of all the auth procedures where authNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthProcedureModelImpl</code>.
	 * </p>
	 *
	 * @param authNumber the auth number
	 * @param start the lower bound of the range of auth procedures
	 * @param end the upper bound of the range of auth procedures (not inclusive)
	 * @return the range of matching auth procedures
	 */
	public java.util.List<AuthProcedure> findByAuthNumber(
		String authNumber, int start, int end);

	/**
	 * Returns an ordered range of all the auth procedures where authNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthProcedureModelImpl</code>.
	 * </p>
	 *
	 * @param authNumber the auth number
	 * @param start the lower bound of the range of auth procedures
	 * @param end the upper bound of the range of auth procedures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching auth procedures
	 */
	public java.util.List<AuthProcedure> findByAuthNumber(
		String authNumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AuthProcedure>
			orderByComparator);

	/**
	 * Returns an ordered range of all the auth procedures where authNumber = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthProcedureModelImpl</code>.
	 * </p>
	 *
	 * @param authNumber the auth number
	 * @param start the lower bound of the range of auth procedures
	 * @param end the upper bound of the range of auth procedures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching auth procedures
	 */
	public java.util.List<AuthProcedure> findByAuthNumber(
		String authNumber, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AuthProcedure>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first auth procedure in the ordered set where authNumber = &#63;.
	 *
	 * @param authNumber the auth number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auth procedure
	 * @throws NoSuchAuthProcedureException if a matching auth procedure could not be found
	 */
	public AuthProcedure findByAuthNumber_First(
			String authNumber,
			com.liferay.portal.kernel.util.OrderByComparator<AuthProcedure>
				orderByComparator)
		throws NoSuchAuthProcedureException;

	/**
	 * Returns the first auth procedure in the ordered set where authNumber = &#63;.
	 *
	 * @param authNumber the auth number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auth procedure, or <code>null</code> if a matching auth procedure could not be found
	 */
	public AuthProcedure fetchByAuthNumber_First(
		String authNumber,
		com.liferay.portal.kernel.util.OrderByComparator<AuthProcedure>
			orderByComparator);

	/**
	 * Returns the last auth procedure in the ordered set where authNumber = &#63;.
	 *
	 * @param authNumber the auth number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auth procedure
	 * @throws NoSuchAuthProcedureException if a matching auth procedure could not be found
	 */
	public AuthProcedure findByAuthNumber_Last(
			String authNumber,
			com.liferay.portal.kernel.util.OrderByComparator<AuthProcedure>
				orderByComparator)
		throws NoSuchAuthProcedureException;

	/**
	 * Returns the last auth procedure in the ordered set where authNumber = &#63;.
	 *
	 * @param authNumber the auth number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auth procedure, or <code>null</code> if a matching auth procedure could not be found
	 */
	public AuthProcedure fetchByAuthNumber_Last(
		String authNumber,
		com.liferay.portal.kernel.util.OrderByComparator<AuthProcedure>
			orderByComparator);

	/**
	 * Returns the auth procedures before and after the current auth procedure in the ordered set where authNumber = &#63;.
	 *
	 * @param authProcedureId the primary key of the current auth procedure
	 * @param authNumber the auth number
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next auth procedure
	 * @throws NoSuchAuthProcedureException if a auth procedure with the primary key could not be found
	 */
	public AuthProcedure[] findByAuthNumber_PrevAndNext(
			long authProcedureId, String authNumber,
			com.liferay.portal.kernel.util.OrderByComparator<AuthProcedure>
				orderByComparator)
		throws NoSuchAuthProcedureException;

	/**
	 * Removes all the auth procedures where authNumber = &#63; from the database.
	 *
	 * @param authNumber the auth number
	 */
	public void removeByAuthNumber(String authNumber);

	/**
	 * Returns the number of auth procedures where authNumber = &#63;.
	 *
	 * @param authNumber the auth number
	 * @return the number of matching auth procedures
	 */
	public int countByAuthNumber(String authNumber);

	/**
	 * Returns all the auth procedures where externalAuthorizationId = &#63;.
	 *
	 * @param externalAuthorizationId the external authorization ID
	 * @return the matching auth procedures
	 */
	public java.util.List<AuthProcedure> findByExtAuthorizationId(
		long externalAuthorizationId);

	/**
	 * Returns a range of all the auth procedures where externalAuthorizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthProcedureModelImpl</code>.
	 * </p>
	 *
	 * @param externalAuthorizationId the external authorization ID
	 * @param start the lower bound of the range of auth procedures
	 * @param end the upper bound of the range of auth procedures (not inclusive)
	 * @return the range of matching auth procedures
	 */
	public java.util.List<AuthProcedure> findByExtAuthorizationId(
		long externalAuthorizationId, int start, int end);

	/**
	 * Returns an ordered range of all the auth procedures where externalAuthorizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthProcedureModelImpl</code>.
	 * </p>
	 *
	 * @param externalAuthorizationId the external authorization ID
	 * @param start the lower bound of the range of auth procedures
	 * @param end the upper bound of the range of auth procedures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching auth procedures
	 */
	public java.util.List<AuthProcedure> findByExtAuthorizationId(
		long externalAuthorizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AuthProcedure>
			orderByComparator);

	/**
	 * Returns an ordered range of all the auth procedures where externalAuthorizationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthProcedureModelImpl</code>.
	 * </p>
	 *
	 * @param externalAuthorizationId the external authorization ID
	 * @param start the lower bound of the range of auth procedures
	 * @param end the upper bound of the range of auth procedures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching auth procedures
	 */
	public java.util.List<AuthProcedure> findByExtAuthorizationId(
		long externalAuthorizationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AuthProcedure>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first auth procedure in the ordered set where externalAuthorizationId = &#63;.
	 *
	 * @param externalAuthorizationId the external authorization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auth procedure
	 * @throws NoSuchAuthProcedureException if a matching auth procedure could not be found
	 */
	public AuthProcedure findByExtAuthorizationId_First(
			long externalAuthorizationId,
			com.liferay.portal.kernel.util.OrderByComparator<AuthProcedure>
				orderByComparator)
		throws NoSuchAuthProcedureException;

	/**
	 * Returns the first auth procedure in the ordered set where externalAuthorizationId = &#63;.
	 *
	 * @param externalAuthorizationId the external authorization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching auth procedure, or <code>null</code> if a matching auth procedure could not be found
	 */
	public AuthProcedure fetchByExtAuthorizationId_First(
		long externalAuthorizationId,
		com.liferay.portal.kernel.util.OrderByComparator<AuthProcedure>
			orderByComparator);

	/**
	 * Returns the last auth procedure in the ordered set where externalAuthorizationId = &#63;.
	 *
	 * @param externalAuthorizationId the external authorization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auth procedure
	 * @throws NoSuchAuthProcedureException if a matching auth procedure could not be found
	 */
	public AuthProcedure findByExtAuthorizationId_Last(
			long externalAuthorizationId,
			com.liferay.portal.kernel.util.OrderByComparator<AuthProcedure>
				orderByComparator)
		throws NoSuchAuthProcedureException;

	/**
	 * Returns the last auth procedure in the ordered set where externalAuthorizationId = &#63;.
	 *
	 * @param externalAuthorizationId the external authorization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching auth procedure, or <code>null</code> if a matching auth procedure could not be found
	 */
	public AuthProcedure fetchByExtAuthorizationId_Last(
		long externalAuthorizationId,
		com.liferay.portal.kernel.util.OrderByComparator<AuthProcedure>
			orderByComparator);

	/**
	 * Returns the auth procedures before and after the current auth procedure in the ordered set where externalAuthorizationId = &#63;.
	 *
	 * @param authProcedureId the primary key of the current auth procedure
	 * @param externalAuthorizationId the external authorization ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next auth procedure
	 * @throws NoSuchAuthProcedureException if a auth procedure with the primary key could not be found
	 */
	public AuthProcedure[] findByExtAuthorizationId_PrevAndNext(
			long authProcedureId, long externalAuthorizationId,
			com.liferay.portal.kernel.util.OrderByComparator<AuthProcedure>
				orderByComparator)
		throws NoSuchAuthProcedureException;

	/**
	 * Removes all the auth procedures where externalAuthorizationId = &#63; from the database.
	 *
	 * @param externalAuthorizationId the external authorization ID
	 */
	public void removeByExtAuthorizationId(long externalAuthorizationId);

	/**
	 * Returns the number of auth procedures where externalAuthorizationId = &#63;.
	 *
	 * @param externalAuthorizationId the external authorization ID
	 * @return the number of matching auth procedures
	 */
	public int countByExtAuthorizationId(long externalAuthorizationId);

	/**
	 * Returns the auth procedure where authNumber = &#63; and medicalCodeId = &#63; or throws a <code>NoSuchAuthProcedureException</code> if it could not be found.
	 *
	 * @param authNumber the auth number
	 * @param medicalCodeId the medical code ID
	 * @return the matching auth procedure
	 * @throws NoSuchAuthProcedureException if a matching auth procedure could not be found
	 */
	public AuthProcedure findByA_M(String authNumber, String medicalCodeId)
		throws NoSuchAuthProcedureException;

	/**
	 * Returns the auth procedure where authNumber = &#63; and medicalCodeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param authNumber the auth number
	 * @param medicalCodeId the medical code ID
	 * @return the matching auth procedure, or <code>null</code> if a matching auth procedure could not be found
	 */
	public AuthProcedure fetchByA_M(String authNumber, String medicalCodeId);

	/**
	 * Returns the auth procedure where authNumber = &#63; and medicalCodeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param authNumber the auth number
	 * @param medicalCodeId the medical code ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching auth procedure, or <code>null</code> if a matching auth procedure could not be found
	 */
	public AuthProcedure fetchByA_M(
		String authNumber, String medicalCodeId, boolean useFinderCache);

	/**
	 * Removes the auth procedure where authNumber = &#63; and medicalCodeId = &#63; from the database.
	 *
	 * @param authNumber the auth number
	 * @param medicalCodeId the medical code ID
	 * @return the auth procedure that was removed
	 */
	public AuthProcedure removeByA_M(String authNumber, String medicalCodeId)
		throws NoSuchAuthProcedureException;

	/**
	 * Returns the number of auth procedures where authNumber = &#63; and medicalCodeId = &#63;.
	 *
	 * @param authNumber the auth number
	 * @param medicalCodeId the medical code ID
	 * @return the number of matching auth procedures
	 */
	public int countByA_M(String authNumber, String medicalCodeId);

	/**
	 * Caches the auth procedure in the entity cache if it is enabled.
	 *
	 * @param authProcedure the auth procedure
	 */
	public void cacheResult(AuthProcedure authProcedure);

	/**
	 * Caches the auth procedures in the entity cache if it is enabled.
	 *
	 * @param authProcedures the auth procedures
	 */
	public void cacheResult(java.util.List<AuthProcedure> authProcedures);

	/**
	 * Creates a new auth procedure with the primary key. Does not add the auth procedure to the database.
	 *
	 * @param authProcedureId the primary key for the new auth procedure
	 * @return the new auth procedure
	 */
	public AuthProcedure create(long authProcedureId);

	/**
	 * Removes the auth procedure with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param authProcedureId the primary key of the auth procedure
	 * @return the auth procedure that was removed
	 * @throws NoSuchAuthProcedureException if a auth procedure with the primary key could not be found
	 */
	public AuthProcedure remove(long authProcedureId)
		throws NoSuchAuthProcedureException;

	public AuthProcedure updateImpl(AuthProcedure authProcedure);

	/**
	 * Returns the auth procedure with the primary key or throws a <code>NoSuchAuthProcedureException</code> if it could not be found.
	 *
	 * @param authProcedureId the primary key of the auth procedure
	 * @return the auth procedure
	 * @throws NoSuchAuthProcedureException if a auth procedure with the primary key could not be found
	 */
	public AuthProcedure findByPrimaryKey(long authProcedureId)
		throws NoSuchAuthProcedureException;

	/**
	 * Returns the auth procedure with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param authProcedureId the primary key of the auth procedure
	 * @return the auth procedure, or <code>null</code> if a auth procedure with the primary key could not be found
	 */
	public AuthProcedure fetchByPrimaryKey(long authProcedureId);

	/**
	 * Returns all the auth procedures.
	 *
	 * @return the auth procedures
	 */
	public java.util.List<AuthProcedure> findAll();

	/**
	 * Returns a range of all the auth procedures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthProcedureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of auth procedures
	 * @param end the upper bound of the range of auth procedures (not inclusive)
	 * @return the range of auth procedures
	 */
	public java.util.List<AuthProcedure> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the auth procedures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthProcedureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of auth procedures
	 * @param end the upper bound of the range of auth procedures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of auth procedures
	 */
	public java.util.List<AuthProcedure> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AuthProcedure>
			orderByComparator);

	/**
	 * Returns an ordered range of all the auth procedures.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AuthProcedureModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of auth procedures
	 * @param end the upper bound of the range of auth procedures (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of auth procedures
	 */
	public java.util.List<AuthProcedure> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AuthProcedure>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the auth procedures from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of auth procedures.
	 *
	 * @return the number of auth procedures
	 */
	public int countAll();

}