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

package com.argus.oth.cases.management.service;

import com.argus.oth.cases.management.model.DataRequest;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for DataRequest. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see DataRequestLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface DataRequestLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DataRequestLocalServiceUtil} to access the data request local service. Add custom service methods to <code>com.argus.oth.cases.management.service.impl.DataRequestLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	 * Adds the data request to the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataRequest the data request
	 * @return the data request that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public DataRequest addDataRequest(DataRequest dataRequest);

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>DataRequestLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>DataRequestLocalServiceUtil</code>.
	 */
	public DataRequest addDataRequest(
		long clientId, long caseId, long externalCaseId, String type,
		Date lastUpdatedDate);

	/**
	 * Creates a new data request with the primary key. Does not add the data request to the database.
	 *
	 * @param dataRequestId the primary key for the new data request
	 * @return the new data request
	 */
	@Transactional(enabled = false)
	public DataRequest createDataRequest(long dataRequestId);

	/**
	 * Deletes the data request from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataRequest the data request
	 * @return the data request that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public DataRequest deleteDataRequest(DataRequest dataRequest);

	/**
	 * Deletes the data request with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dataRequestId the primary key of the data request
	 * @return the data request that was removed
	 * @throws PortalException if a data request with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public DataRequest deleteDataRequest(long dataRequestId)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.DataRequestModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.DataRequestModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DataRequest fetchByClientId_Type(long clientId, String type);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DataRequest fetchByExternalCaseId_Type(
		long externalCaseId, String type);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DataRequest fetchDataRequest(long dataRequestId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the data request with the primary key.
	 *
	 * @param dataRequestId the primary key of the data request
	 * @return the data request
	 * @throws PortalException if a data request with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DataRequest getDataRequest(long dataRequestId)
		throws PortalException;

	/**
	 * Returns a range of all the data requests.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.DataRequestModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of data requests
	 * @param end the upper bound of the range of data requests (not inclusive)
	 * @return the range of data requests
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<DataRequest> getDataRequests(int start, int end);

	/**
	 * Returns the number of data requests.
	 *
	 * @return the number of data requests
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getDataRequestsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	public DataRequest setDataRequestLastUpdatedDate(
		long clientId, long caseId, long externalCaseId, String type);

	/**
	 * Updates the data request in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param dataRequest the data request
	 * @return the data request that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public DataRequest updateDataRequest(DataRequest dataRequest);

	public DataRequest updateDataRequest(
		long clientId, long caseId, long externalCaseId, String type,
		Date lastUpdatedDate);

}