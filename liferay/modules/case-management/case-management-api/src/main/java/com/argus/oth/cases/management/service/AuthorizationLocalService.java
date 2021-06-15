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

import com.argus.oth.cases.management.model.Authorization;

import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
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
 * Provides the local service interface for Authorization. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see AuthorizationLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface AuthorizationLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AuthorizationLocalServiceUtil} to access the authorization local service. Add custom service methods to <code>com.argus.oth.cases.management.service.impl.AuthorizationLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	 * Adds the authorization to the database. Also notifies the appropriate model listeners.
	 *
	 * @param authorization the authorization
	 * @return the authorization that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Authorization addAuthorization(Authorization authorization);

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>AuthorizationLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>AuthorizationLocalServiceUtil</code>.
	 */
	public void addAuthorization(
		long groupId, long caseId, long externalAuthorizationId, long memberId,
		String description, String rtcAuthorizationStatus, String authStatus,
		Date statusChangeDate, Date receivedDate, String authNumber,
		String category, String rtcAuthorizationType, String facility,
		String procedureCode, String comments, Date externalModifiedDate,
		Date effectiveFrom, Date effectiveThru, String randomString);

	public void addAuthorization(
		long groupId, long caseId, long externalAuthorizationId, long memberId,
		String description, String rtcAuthorizationStatus, String authStatus,
		Date statusChangeDate, Date receivedDate, String authNumber,
		String category, String rtcAuthorizationType, String facility,
		String procedureCode, String comments, Date externalModifiedDate,
		Date effectiveFrom, Date effectiveThru, String processStatus,
		String failureDescription, String randomString);

	/**
	 * Creates a new authorization with the primary key. Does not add the authorization to the database.
	 *
	 * @param authorizationId the primary key for the new authorization
	 * @return the new authorization
	 */
	@Transactional(enabled = false)
	public Authorization createAuthorization(long authorizationId);

	/**
	 * Deletes the authorization from the database. Also notifies the appropriate model listeners.
	 *
	 * @param authorization the authorization
	 * @return the authorization that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public Authorization deleteAuthorization(Authorization authorization);

	/**
	 * Deletes the authorization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param authorizationId the primary key of the authorization
	 * @return the authorization that was removed
	 * @throws PortalException if a authorization with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public Authorization deleteAuthorization(long authorizationId)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	public void deleteUnprocessed(String randomString);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.AuthorizationModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.AuthorizationModelImpl</code>.
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
	public Authorization fetchAuthorization(long authorizationId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Authorization fetchAuthorizationByExternalAuthorizationId(
		long externalAuthorizationId);

	/**
	 * Returns the authorization matching the UUID and group.
	 *
	 * @param uuid the authorization's UUID
	 * @param groupId the primary key of the group
	 * @return the matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Authorization fetchAuthorizationByUuidAndGroupId(
		String uuid, long groupId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	/**
	 * Returns the authorization with the primary key.
	 *
	 * @param authorizationId the primary key of the authorization
	 * @return the authorization
	 * @throws PortalException if a authorization with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Authorization getAuthorization(long authorizationId)
		throws PortalException;

	/**
	 * Returns the authorization matching the UUID and group.
	 *
	 * @param uuid the authorization's UUID
	 * @param groupId the primary key of the group
	 * @return the matching authorization
	 * @throws PortalException if a matching authorization could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Authorization getAuthorizationByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException;

	/**
	 * Returns a range of all the authorizations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.AuthorizationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of authorizations
	 * @param end the upper bound of the range of authorizations (not inclusive)
	 * @return the range of authorizations
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Authorization> getAuthorizations(int start, int end);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Authorization> getAuthorizationsByAuthNumber(String authNumber);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Authorization> getAuthorizationsByCaseId(long caseId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Authorization> getAuthorizationsByCaseId(
		long caseId, int start, int end);

	/**
	 * Returns all the authorizations matching the UUID and company.
	 *
	 * @param uuid the UUID of the authorizations
	 * @param companyId the primary key of the company
	 * @return the matching authorizations, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Authorization> getAuthorizationsByUuidAndCompanyId(
		String uuid, long companyId);

	/**
	 * Returns a range of authorizations matching the UUID and company.
	 *
	 * @param uuid the UUID of the authorizations
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of authorizations
	 * @param end the upper bound of the range of authorizations (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching authorizations, or an empty list if no matches were found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Authorization> getAuthorizationsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Authorization> orderByComparator);

	/**
	 * Returns the number of authorizations.
	 *
	 * @return the number of authorizations
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAuthorizationsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		PortletDataContext portletDataContext);

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

	/**
	 * Updates the authorization in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param authorization the authorization
	 * @return the authorization that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public Authorization updateAuthorization(Authorization authorization);

	public Authorization updateAuthorization(
		long authorizationId, long externalAuthorizationId, long memberId,
		String rtcAuthorizationStatus, String authStatus, Date statusChangeDate,
		Date receivedDate, String authNumber, String category,
		String rtcAuthorizationType, String facility, String procedureCode,
		String comments, Date externalModifiedDate, Date effectiveFrom,
		Date effectiveThru);

	public Authorization updateAuthorization(
		long authorizationId, long externalAuthorizationId,
		String processStatus, String failureDescription);

}