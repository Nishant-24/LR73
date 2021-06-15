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

import com.argus.oth.cases.management.exception.NoSuchStagingReferenceTypeCodeException;
import com.argus.oth.cases.management.model.StagingReferenceTypeCode;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the staging reference type code service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingReferenceTypeCodeUtil
 * @generated
 */
@ProviderType
public interface StagingReferenceTypeCodePersistence
	extends BasePersistence<StagingReferenceTypeCode> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link StagingReferenceTypeCodeUtil} to access the staging reference type code persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Caches the staging reference type code in the entity cache if it is enabled.
	 *
	 * @param stagingReferenceTypeCode the staging reference type code
	 */
	public void cacheResult(StagingReferenceTypeCode stagingReferenceTypeCode);

	/**
	 * Caches the staging reference type codes in the entity cache if it is enabled.
	 *
	 * @param stagingReferenceTypeCodes the staging reference type codes
	 */
	public void cacheResult(
		java.util.List<StagingReferenceTypeCode> stagingReferenceTypeCodes);

	/**
	 * Creates a new staging reference type code with the primary key. Does not add the staging reference type code to the database.
	 *
	 * @param stagingReferenceTypeCodeId the primary key for the new staging reference type code
	 * @return the new staging reference type code
	 */
	public StagingReferenceTypeCode create(long stagingReferenceTypeCodeId);

	/**
	 * Removes the staging reference type code with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingReferenceTypeCodeId the primary key of the staging reference type code
	 * @return the staging reference type code that was removed
	 * @throws NoSuchStagingReferenceTypeCodeException if a staging reference type code with the primary key could not be found
	 */
	public StagingReferenceTypeCode remove(long stagingReferenceTypeCodeId)
		throws NoSuchStagingReferenceTypeCodeException;

	public StagingReferenceTypeCode updateImpl(
		StagingReferenceTypeCode stagingReferenceTypeCode);

	/**
	 * Returns the staging reference type code with the primary key or throws a <code>NoSuchStagingReferenceTypeCodeException</code> if it could not be found.
	 *
	 * @param stagingReferenceTypeCodeId the primary key of the staging reference type code
	 * @return the staging reference type code
	 * @throws NoSuchStagingReferenceTypeCodeException if a staging reference type code with the primary key could not be found
	 */
	public StagingReferenceTypeCode findByPrimaryKey(
			long stagingReferenceTypeCodeId)
		throws NoSuchStagingReferenceTypeCodeException;

	/**
	 * Returns the staging reference type code with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param stagingReferenceTypeCodeId the primary key of the staging reference type code
	 * @return the staging reference type code, or <code>null</code> if a staging reference type code with the primary key could not be found
	 */
	public StagingReferenceTypeCode fetchByPrimaryKey(
		long stagingReferenceTypeCodeId);

	/**
	 * Returns all the staging reference type codes.
	 *
	 * @return the staging reference type codes
	 */
	public java.util.List<StagingReferenceTypeCode> findAll();

	/**
	 * Returns a range of all the staging reference type codes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingReferenceTypeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging reference type codes
	 * @param end the upper bound of the range of staging reference type codes (not inclusive)
	 * @return the range of staging reference type codes
	 */
	public java.util.List<StagingReferenceTypeCode> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the staging reference type codes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingReferenceTypeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging reference type codes
	 * @param end the upper bound of the range of staging reference type codes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of staging reference type codes
	 */
	public java.util.List<StagingReferenceTypeCode> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<StagingReferenceTypeCode> orderByComparator);

	/**
	 * Returns an ordered range of all the staging reference type codes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>StagingReferenceTypeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging reference type codes
	 * @param end the upper bound of the range of staging reference type codes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of staging reference type codes
	 */
	public java.util.List<StagingReferenceTypeCode> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<StagingReferenceTypeCode> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the staging reference type codes from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of staging reference type codes.
	 *
	 * @return the number of staging reference type codes
	 */
	public int countAll();

}