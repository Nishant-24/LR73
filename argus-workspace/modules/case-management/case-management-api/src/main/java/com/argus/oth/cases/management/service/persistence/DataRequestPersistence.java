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

import com.argus.oth.cases.management.exception.NoSuchDataRequestException;
import com.argus.oth.cases.management.model.DataRequest;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the data request service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see DataRequestUtil
 * @generated
 */
@ProviderType
public interface DataRequestPersistence extends BasePersistence<DataRequest> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DataRequestUtil} to access the data request persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the data request where clientId = &#63; and type = &#63; or throws a <code>NoSuchDataRequestException</code> if it could not be found.
	 *
	 * @param clientId the client ID
	 * @param type the type
	 * @return the matching data request
	 * @throws NoSuchDataRequestException if a matching data request could not be found
	 */
	public DataRequest findByClientId_Type(long clientId, String type)
		throws NoSuchDataRequestException;

	/**
	 * Returns the data request where clientId = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param clientId the client ID
	 * @param type the type
	 * @return the matching data request, or <code>null</code> if a matching data request could not be found
	 */
	public DataRequest fetchByClientId_Type(long clientId, String type);

	/**
	 * Returns the data request where clientId = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param clientId the client ID
	 * @param type the type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching data request, or <code>null</code> if a matching data request could not be found
	 */
	public DataRequest fetchByClientId_Type(
		long clientId, String type, boolean useFinderCache);

	/**
	 * Removes the data request where clientId = &#63; and type = &#63; from the database.
	 *
	 * @param clientId the client ID
	 * @param type the type
	 * @return the data request that was removed
	 */
	public DataRequest removeByClientId_Type(long clientId, String type)
		throws NoSuchDataRequestException;

	/**
	 * Returns the number of data requests where clientId = &#63; and type = &#63;.
	 *
	 * @param clientId the client ID
	 * @param type the type
	 * @return the number of matching data requests
	 */
	public int countByClientId_Type(long clientId, String type);

	/**
	 * Returns the data request where externalCaseId = &#63; and type = &#63; or throws a <code>NoSuchDataRequestException</code> if it could not be found.
	 *
	 * @param externalCaseId the external case ID
	 * @param type the type
	 * @return the matching data request
	 * @throws NoSuchDataRequestException if a matching data request could not be found
	 */
	public DataRequest findByExtCaseId_Type(long externalCaseId, String type)
		throws NoSuchDataRequestException;

	/**
	 * Returns the data request where externalCaseId = &#63; and type = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param externalCaseId the external case ID
	 * @param type the type
	 * @return the matching data request, or <code>null</code> if a matching data request could not be found
	 */
	public DataRequest fetchByExtCaseId_Type(long externalCaseId, String type);

	/**
	 * Returns the data request where externalCaseId = &#63; and type = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param externalCaseId the external case ID
	 * @param type the type
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching data request, or <code>null</code> if a matching data request could not be found
	 */
	public DataRequest fetchByExtCaseId_Type(
		long externalCaseId, String type, boolean useFinderCache);

	/**
	 * Removes the data request where externalCaseId = &#63; and type = &#63; from the database.
	 *
	 * @param externalCaseId the external case ID
	 * @param type the type
	 * @return the data request that was removed
	 */
	public DataRequest removeByExtCaseId_Type(long externalCaseId, String type)
		throws NoSuchDataRequestException;

	/**
	 * Returns the number of data requests where externalCaseId = &#63; and type = &#63;.
	 *
	 * @param externalCaseId the external case ID
	 * @param type the type
	 * @return the number of matching data requests
	 */
	public int countByExtCaseId_Type(long externalCaseId, String type);

	/**
	 * Caches the data request in the entity cache if it is enabled.
	 *
	 * @param dataRequest the data request
	 */
	public void cacheResult(DataRequest dataRequest);

	/**
	 * Caches the data requests in the entity cache if it is enabled.
	 *
	 * @param dataRequests the data requests
	 */
	public void cacheResult(java.util.List<DataRequest> dataRequests);

	/**
	 * Creates a new data request with the primary key. Does not add the data request to the database.
	 *
	 * @param dataRequestId the primary key for the new data request
	 * @return the new data request
	 */
	public DataRequest create(long dataRequestId);

	/**
	 * Removes the data request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataRequestId the primary key of the data request
	 * @return the data request that was removed
	 * @throws NoSuchDataRequestException if a data request with the primary key could not be found
	 */
	public DataRequest remove(long dataRequestId)
		throws NoSuchDataRequestException;

	public DataRequest updateImpl(DataRequest dataRequest);

	/**
	 * Returns the data request with the primary key or throws a <code>NoSuchDataRequestException</code> if it could not be found.
	 *
	 * @param dataRequestId the primary key of the data request
	 * @return the data request
	 * @throws NoSuchDataRequestException if a data request with the primary key could not be found
	 */
	public DataRequest findByPrimaryKey(long dataRequestId)
		throws NoSuchDataRequestException;

	/**
	 * Returns the data request with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dataRequestId the primary key of the data request
	 * @return the data request, or <code>null</code> if a data request with the primary key could not be found
	 */
	public DataRequest fetchByPrimaryKey(long dataRequestId);

	/**
	 * Returns all the data requests.
	 *
	 * @return the data requests
	 */
	public java.util.List<DataRequest> findAll();

	/**
	 * Returns a range of all the data requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data requests
	 * @param end the upper bound of the range of data requests (not inclusive)
	 * @return the range of data requests
	 */
	public java.util.List<DataRequest> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the data requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data requests
	 * @param end the upper bound of the range of data requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of data requests
	 */
	public java.util.List<DataRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataRequest>
			orderByComparator);

	/**
	 * Returns an ordered range of all the data requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>DataRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data requests
	 * @param end the upper bound of the range of data requests (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of data requests
	 */
	public java.util.List<DataRequest> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<DataRequest>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the data requests from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of data requests.
	 *
	 * @return the number of data requests
	 */
	public int countAll();

}