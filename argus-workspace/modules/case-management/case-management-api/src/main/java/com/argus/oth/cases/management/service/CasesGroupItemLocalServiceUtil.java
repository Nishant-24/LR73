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

import com.argus.oth.cases.management.model.CasesGroupItem;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for CasesGroupItem. This utility wraps
 * <code>com.argus.oth.cases.management.service.impl.CasesGroupItemLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CasesGroupItemLocalService
 * @generated
 */
public class CasesGroupItemLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.argus.oth.cases.management.service.impl.CasesGroupItemLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the cases group item to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CasesGroupItemLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param casesGroupItem the cases group item
	 * @return the cases group item that was added
	 */
	public static CasesGroupItem addCasesGroupItem(
		CasesGroupItem casesGroupItem) {

		return getService().addCasesGroupItem(casesGroupItem);
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>CasesGroupItemLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>CasesGroupItemLocalServiceUtil</code>.
	 */
	public static CasesGroupItem addCasesGroupItem(
		long groupId, long userId, long externalCaseId, String type) {

		return getService().addCasesGroupItem(
			groupId, userId, externalCaseId, type);
	}

	/**
	 * Creates a new cases group item with the primary key. Does not add the cases group item to the database.
	 *
	 * @param casesGroupItemId the primary key for the new cases group item
	 * @return the new cases group item
	 */
	public static CasesGroupItem createCasesGroupItem(long casesGroupItemId) {
		return getService().createCasesGroupItem(casesGroupItemId);
	}

	/**
	 * Deletes the cases group item from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CasesGroupItemLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param casesGroupItem the cases group item
	 * @return the cases group item that was removed
	 */
	public static CasesGroupItem deleteCasesGroupItem(
		CasesGroupItem casesGroupItem) {

		return getService().deleteCasesGroupItem(casesGroupItem);
	}

	/**
	 * Deletes the cases group item with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CasesGroupItemLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param casesGroupItemId the primary key of the cases group item
	 * @return the cases group item that was removed
	 * @throws PortalException if a cases group item with the primary key could not be found
	 */
	public static CasesGroupItem deleteCasesGroupItem(long casesGroupItemId)
		throws PortalException {

		return getService().deleteCasesGroupItem(casesGroupItemId);
	}

	/**
	 * @throws PortalException
	 */
	public static PersistedModel deletePersistedModel(
			PersistedModel persistedModel)
		throws PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.CasesGroupItemModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.CasesGroupItemModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(DynamicQuery dynamicQuery) {
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
		DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static CasesGroupItem fetchCasesGroupItem(long casesGroupItemId) {
		return getService().fetchCasesGroupItem(casesGroupItemId);
	}

	public static CasesGroupItem fetchCasesGroupItemByE_U_T(
		long externalCaseId, long userId, String type) {

		return getService().fetchCasesGroupItemByE_U_T(
			externalCaseId, userId, type);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the cases group item with the primary key.
	 *
	 * @param casesGroupItemId the primary key of the cases group item
	 * @return the cases group item
	 * @throws PortalException if a cases group item with the primary key could not be found
	 */
	public static CasesGroupItem getCasesGroupItem(long casesGroupItemId)
		throws PortalException {

		return getService().getCasesGroupItem(casesGroupItemId);
	}

	/**
	 * Returns a range of all the cases group items.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.CasesGroupItemModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of cases group items
	 * @param end the upper bound of the range of cases group items (not inclusive)
	 * @return the range of cases group items
	 */
	public static List<CasesGroupItem> getCasesGroupItems(int start, int end) {
		return getService().getCasesGroupItems(start, end);
	}

	public static List<CasesGroupItem> getCasesGroupItemsByG_U_T(
		long groupId, long userId, String type, int rowLimit) {

		return getService().getCasesGroupItemsByG_U_T(
			groupId, userId, type, rowLimit);
	}

	/**
	 * Returns the number of cases group items.
	 *
	 * @return the number of cases group items
	 */
	public static int getCasesGroupItemsCount() {
		return getService().getCasesGroupItemsCount();
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
	public static PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	public static void setModifiedDate(long casesGroupItemId) {
		getService().setModifiedDate(casesGroupItemId);
	}

	/**
	 * Updates the cases group item in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CasesGroupItemLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param casesGroupItem the cases group item
	 * @return the cases group item that was updated
	 */
	public static CasesGroupItem updateCasesGroupItem(
		CasesGroupItem casesGroupItem) {

		return getService().updateCasesGroupItem(casesGroupItem);
	}

	public static CasesGroupItemLocalService getService() {
		return _service;
	}

	private static volatile CasesGroupItemLocalService _service;

}