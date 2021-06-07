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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for ReferenceTypeCode. This utility wraps
 * <code>com.argus.oth.cases.management.service.impl.ReferenceTypeCodeLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ReferenceTypeCodeLocalService
 * @generated
 */
public class ReferenceTypeCodeLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.argus.oth.cases.management.service.impl.ReferenceTypeCodeLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>ReferenceTypeCodeLocalService</code> via injection or a <code>ServiceTracker</code> or use <code>ReferenceTypeCodeLocalServiceUtil</code>.
	 */
	public static com.argus.oth.cases.management.model.ReferenceTypeCode
		addReferenceTypeCode(
			long groupId, long externalReferenceTypeCode, String type,
			String key, String description, java.util.Date modifiedDate,
			java.util.Date createdDate, String randomString) {

		return getService().addReferenceTypeCode(
			groupId, externalReferenceTypeCode, type, key, description,
			modifiedDate, createdDate, randomString);
	}

	/**
	 * Adds the reference type code to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ReferenceTypeCodeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param referenceTypeCode the reference type code
	 * @return the reference type code that was added
	 */
	public static com.argus.oth.cases.management.model.ReferenceTypeCode
		addReferenceTypeCode(
			com.argus.oth.cases.management.model.ReferenceTypeCode
				referenceTypeCode) {

		return getService().addReferenceTypeCode(referenceTypeCode);
	}

	/**
	 * Creates a new reference type code with the primary key. Does not add the reference type code to the database.
	 *
	 * @param referenceTypeCodeId the primary key for the new reference type code
	 * @return the new reference type code
	 */
	public static com.argus.oth.cases.management.model.ReferenceTypeCode
		createReferenceTypeCode(long referenceTypeCodeId) {

		return getService().createReferenceTypeCode(referenceTypeCodeId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the reference type code with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ReferenceTypeCodeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param referenceTypeCodeId the primary key of the reference type code
	 * @return the reference type code that was removed
	 * @throws PortalException if a reference type code with the primary key could not be found
	 */
	public static com.argus.oth.cases.management.model.ReferenceTypeCode
			deleteReferenceTypeCode(long referenceTypeCodeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteReferenceTypeCode(referenceTypeCodeId);
	}

	/**
	 * Deletes the reference type code from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ReferenceTypeCodeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param referenceTypeCode the reference type code
	 * @return the reference type code that was removed
	 */
	public static com.argus.oth.cases.management.model.ReferenceTypeCode
		deleteReferenceTypeCode(
			com.argus.oth.cases.management.model.ReferenceTypeCode
				referenceTypeCode) {

		return getService().deleteReferenceTypeCode(referenceTypeCode);
	}

	public static void deleteUnprocessed(String randomString) {
		getService().deleteUnprocessed(randomString);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.ReferenceTypeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.ReferenceTypeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.argus.oth.cases.management.model.ReferenceTypeCode
		fetchByKey(String key) {

		return getService().fetchByKey(key);
	}

	public static com.argus.oth.cases.management.model.ReferenceTypeCode
		fetchReferenceTypeCode(long referenceTypeCodeId) {

		return getService().fetchReferenceTypeCode(referenceTypeCodeId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List
		<com.argus.oth.cases.management.model.ReferenceTypeCode> getByType(
			String type) {

		return getService().getByType(type);
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the reference type code with the primary key.
	 *
	 * @param referenceTypeCodeId the primary key of the reference type code
	 * @return the reference type code
	 * @throws PortalException if a reference type code with the primary key could not be found
	 */
	public static com.argus.oth.cases.management.model.ReferenceTypeCode
			getReferenceTypeCode(long referenceTypeCodeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getReferenceTypeCode(referenceTypeCodeId);
	}

	/**
	 * Returns a range of all the reference type codes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.ReferenceTypeCodeModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of reference type codes
	 * @param end the upper bound of the range of reference type codes (not inclusive)
	 * @return the range of reference type codes
	 */
	public static java.util.List
		<com.argus.oth.cases.management.model.ReferenceTypeCode>
			getReferenceTypeCodes(int start, int end) {

		return getService().getReferenceTypeCodes(start, end);
	}

	/**
	 * Returns the number of reference type codes.
	 *
	 * @return the number of reference type codes
	 */
	public static int getReferenceTypeCodesCount() {
		return getService().getReferenceTypeCodesCount();
	}

	/**
	 * Updates the reference type code in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ReferenceTypeCodeLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param referenceTypeCode the reference type code
	 * @return the reference type code that was updated
	 */
	public static com.argus.oth.cases.management.model.ReferenceTypeCode
		updateReferenceTypeCode(
			com.argus.oth.cases.management.model.ReferenceTypeCode
				referenceTypeCode) {

		return getService().updateReferenceTypeCode(referenceTypeCode);
	}

	public static ReferenceTypeCodeLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ReferenceTypeCodeLocalService, ReferenceTypeCodeLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ReferenceTypeCodeLocalService.class);

		ServiceTracker
			<ReferenceTypeCodeLocalService, ReferenceTypeCodeLocalService>
				serviceTracker =
					new ServiceTracker
						<ReferenceTypeCodeLocalService,
						 ReferenceTypeCodeLocalService>(
							 bundle.getBundleContext(),
							 ReferenceTypeCodeLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}