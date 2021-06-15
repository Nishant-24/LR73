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

import com.argus.oth.cases.management.exception.NoSuchReferenceTypeCodeException;
import com.argus.oth.cases.management.model.ReferenceTypeCode;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the reference type code service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReferenceTypeCodeUtil
 * @generated
 */
@ProviderType
public interface ReferenceTypeCodePersistence
	extends BasePersistence<ReferenceTypeCode> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ReferenceTypeCodeUtil} to access the reference type code persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the reference type code where key = &#63; or throws a <code>NoSuchReferenceTypeCodeException</code> if it could not be found.
	 *
	 * @param key the key
	 * @return the matching reference type code
	 * @throws NoSuchReferenceTypeCodeException if a matching reference type code could not be found
	 */
	public ReferenceTypeCode findByKey(String key)
		throws NoSuchReferenceTypeCodeException;

	/**
	 * Returns the reference type code where key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param key the key
	 * @return the matching reference type code, or <code>null</code> if a matching reference type code could not be found
	 */
	public ReferenceTypeCode fetchByKey(String key);

	/**
	 * Returns the reference type code where key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param key the key
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching reference type code, or <code>null</code> if a matching reference type code could not be found
	 */
	public ReferenceTypeCode fetchByKey(String key, boolean useFinderCache);

	/**
	 * Removes the reference type code where key = &#63; from the database.
	 *
	 * @param key the key
	 * @return the reference type code that was removed
	 */
	public ReferenceTypeCode removeByKey(String key)
		throws NoSuchReferenceTypeCodeException;

	/**
	 * Returns the number of reference type codes where key = &#63;.
	 *
	 * @param key the key
	 * @return the number of matching reference type codes
	 */
	public int countByKey(String key);

	/**
	 * Returns all the reference type codes where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the matching reference type codes
	 */
	public java.util.List<ReferenceTypeCode> findByRowProcessed(
		String rowProcessed);

	/**
	 * Returns a range of all the reference type codes where rowProcessed &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferenceTypeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of reference type codes
	 * @param end the upper bound of the range of reference type codes (not inclusive)
	 * @return the range of matching reference type codes
	 */
	public java.util.List<ReferenceTypeCode> findByRowProcessed(
		String rowProcessed, int start, int end);

	/**
	 * Returns an ordered range of all the reference type codes where rowProcessed &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferenceTypeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of reference type codes
	 * @param end the upper bound of the range of reference type codes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching reference type codes
	 */
	public java.util.List<ReferenceTypeCode> findByRowProcessed(
		String rowProcessed, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ReferenceTypeCode>
			orderByComparator);

	/**
	 * Returns an ordered range of all the reference type codes where rowProcessed &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferenceTypeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param start the lower bound of the range of reference type codes
	 * @param end the upper bound of the range of reference type codes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching reference type codes
	 */
	public java.util.List<ReferenceTypeCode> findByRowProcessed(
		String rowProcessed, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ReferenceTypeCode>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first reference type code in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reference type code
	 * @throws NoSuchReferenceTypeCodeException if a matching reference type code could not be found
	 */
	public ReferenceTypeCode findByRowProcessed_First(
			String rowProcessed,
			com.liferay.portal.kernel.util.OrderByComparator<ReferenceTypeCode>
				orderByComparator)
		throws NoSuchReferenceTypeCodeException;

	/**
	 * Returns the first reference type code in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reference type code, or <code>null</code> if a matching reference type code could not be found
	 */
	public ReferenceTypeCode fetchByRowProcessed_First(
		String rowProcessed,
		com.liferay.portal.kernel.util.OrderByComparator<ReferenceTypeCode>
			orderByComparator);

	/**
	 * Returns the last reference type code in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reference type code
	 * @throws NoSuchReferenceTypeCodeException if a matching reference type code could not be found
	 */
	public ReferenceTypeCode findByRowProcessed_Last(
			String rowProcessed,
			com.liferay.portal.kernel.util.OrderByComparator<ReferenceTypeCode>
				orderByComparator)
		throws NoSuchReferenceTypeCodeException;

	/**
	 * Returns the last reference type code in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reference type code, or <code>null</code> if a matching reference type code could not be found
	 */
	public ReferenceTypeCode fetchByRowProcessed_Last(
		String rowProcessed,
		com.liferay.portal.kernel.util.OrderByComparator<ReferenceTypeCode>
			orderByComparator);

	/**
	 * Returns the reference type codes before and after the current reference type code in the ordered set where rowProcessed &ne; &#63;.
	 *
	 * @param referenceTypeCodeId the primary key of the current reference type code
	 * @param rowProcessed the row processed
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next reference type code
	 * @throws NoSuchReferenceTypeCodeException if a reference type code with the primary key could not be found
	 */
	public ReferenceTypeCode[] findByRowProcessed_PrevAndNext(
			long referenceTypeCodeId, String rowProcessed,
			com.liferay.portal.kernel.util.OrderByComparator<ReferenceTypeCode>
				orderByComparator)
		throws NoSuchReferenceTypeCodeException;

	/**
	 * Removes all the reference type codes where rowProcessed &ne; &#63; from the database.
	 *
	 * @param rowProcessed the row processed
	 */
	public void removeByRowProcessed(String rowProcessed);

	/**
	 * Returns the number of reference type codes where rowProcessed &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @return the number of matching reference type codes
	 */
	public int countByRowProcessed(String rowProcessed);

	/**
	 * Returns all the reference type codes where type = &#63;.
	 *
	 * @param type the type
	 * @return the matching reference type codes
	 */
	public java.util.List<ReferenceTypeCode> findByType(String type);

	/**
	 * Returns a range of all the reference type codes where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferenceTypeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of reference type codes
	 * @param end the upper bound of the range of reference type codes (not inclusive)
	 * @return the range of matching reference type codes
	 */
	public java.util.List<ReferenceTypeCode> findByType(
		String type, int start, int end);

	/**
	 * Returns an ordered range of all the reference type codes where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferenceTypeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of reference type codes
	 * @param end the upper bound of the range of reference type codes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching reference type codes
	 */
	public java.util.List<ReferenceTypeCode> findByType(
		String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ReferenceTypeCode>
			orderByComparator);

	/**
	 * Returns an ordered range of all the reference type codes where type = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferenceTypeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param type the type
	 * @param start the lower bound of the range of reference type codes
	 * @param end the upper bound of the range of reference type codes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching reference type codes
	 */
	public java.util.List<ReferenceTypeCode> findByType(
		String type, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ReferenceTypeCode>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first reference type code in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reference type code
	 * @throws NoSuchReferenceTypeCodeException if a matching reference type code could not be found
	 */
	public ReferenceTypeCode findByType_First(
			String type,
			com.liferay.portal.kernel.util.OrderByComparator<ReferenceTypeCode>
				orderByComparator)
		throws NoSuchReferenceTypeCodeException;

	/**
	 * Returns the first reference type code in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching reference type code, or <code>null</code> if a matching reference type code could not be found
	 */
	public ReferenceTypeCode fetchByType_First(
		String type,
		com.liferay.portal.kernel.util.OrderByComparator<ReferenceTypeCode>
			orderByComparator);

	/**
	 * Returns the last reference type code in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reference type code
	 * @throws NoSuchReferenceTypeCodeException if a matching reference type code could not be found
	 */
	public ReferenceTypeCode findByType_Last(
			String type,
			com.liferay.portal.kernel.util.OrderByComparator<ReferenceTypeCode>
				orderByComparator)
		throws NoSuchReferenceTypeCodeException;

	/**
	 * Returns the last reference type code in the ordered set where type = &#63;.
	 *
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching reference type code, or <code>null</code> if a matching reference type code could not be found
	 */
	public ReferenceTypeCode fetchByType_Last(
		String type,
		com.liferay.portal.kernel.util.OrderByComparator<ReferenceTypeCode>
			orderByComparator);

	/**
	 * Returns the reference type codes before and after the current reference type code in the ordered set where type = &#63;.
	 *
	 * @param referenceTypeCodeId the primary key of the current reference type code
	 * @param type the type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next reference type code
	 * @throws NoSuchReferenceTypeCodeException if a reference type code with the primary key could not be found
	 */
	public ReferenceTypeCode[] findByType_PrevAndNext(
			long referenceTypeCodeId, String type,
			com.liferay.portal.kernel.util.OrderByComparator<ReferenceTypeCode>
				orderByComparator)
		throws NoSuchReferenceTypeCodeException;

	/**
	 * Removes all the reference type codes where type = &#63; from the database.
	 *
	 * @param type the type
	 */
	public void removeByType(String type);

	/**
	 * Returns the number of reference type codes where type = &#63;.
	 *
	 * @param type the type
	 * @return the number of matching reference type codes
	 */
	public int countByType(String type);

	/**
	 * Caches the reference type code in the entity cache if it is enabled.
	 *
	 * @param referenceTypeCode the reference type code
	 */
	public void cacheResult(ReferenceTypeCode referenceTypeCode);

	/**
	 * Caches the reference type codes in the entity cache if it is enabled.
	 *
	 * @param referenceTypeCodes the reference type codes
	 */
	public void cacheResult(
		java.util.List<ReferenceTypeCode> referenceTypeCodes);

	/**
	 * Creates a new reference type code with the primary key. Does not add the reference type code to the database.
	 *
	 * @param referenceTypeCodeId the primary key for the new reference type code
	 * @return the new reference type code
	 */
	public ReferenceTypeCode create(long referenceTypeCodeId);

	/**
	 * Removes the reference type code with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param referenceTypeCodeId the primary key of the reference type code
	 * @return the reference type code that was removed
	 * @throws NoSuchReferenceTypeCodeException if a reference type code with the primary key could not be found
	 */
	public ReferenceTypeCode remove(long referenceTypeCodeId)
		throws NoSuchReferenceTypeCodeException;

	public ReferenceTypeCode updateImpl(ReferenceTypeCode referenceTypeCode);

	/**
	 * Returns the reference type code with the primary key or throws a <code>NoSuchReferenceTypeCodeException</code> if it could not be found.
	 *
	 * @param referenceTypeCodeId the primary key of the reference type code
	 * @return the reference type code
	 * @throws NoSuchReferenceTypeCodeException if a reference type code with the primary key could not be found
	 */
	public ReferenceTypeCode findByPrimaryKey(long referenceTypeCodeId)
		throws NoSuchReferenceTypeCodeException;

	/**
	 * Returns the reference type code with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param referenceTypeCodeId the primary key of the reference type code
	 * @return the reference type code, or <code>null</code> if a reference type code with the primary key could not be found
	 */
	public ReferenceTypeCode fetchByPrimaryKey(long referenceTypeCodeId);

	/**
	 * Returns all the reference type codes.
	 *
	 * @return the reference type codes
	 */
	public java.util.List<ReferenceTypeCode> findAll();

	/**
	 * Returns a range of all the reference type codes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferenceTypeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of reference type codes
	 * @param end the upper bound of the range of reference type codes (not inclusive)
	 * @return the range of reference type codes
	 */
	public java.util.List<ReferenceTypeCode> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the reference type codes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferenceTypeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of reference type codes
	 * @param end the upper bound of the range of reference type codes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of reference type codes
	 */
	public java.util.List<ReferenceTypeCode> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ReferenceTypeCode>
			orderByComparator);

	/**
	 * Returns an ordered range of all the reference type codes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ReferenceTypeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of reference type codes
	 * @param end the upper bound of the range of reference type codes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of reference type codes
	 */
	public java.util.List<ReferenceTypeCode> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ReferenceTypeCode>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the reference type codes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of reference type codes.
	 *
	 * @return the number of reference type codes
	 */
	public int countAll();

}