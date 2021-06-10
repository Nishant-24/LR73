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

package com.argus.oth.account.management.service;

import com.argus.oth.account.management.model.AMAnalyticsTelephony;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

/**
 * Provides the local service utility for AMAnalyticsTelephony. This utility wraps
 * <code>com.argus.oth.account.management.service.impl.AMAnalyticsTelephonyLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AMAnalyticsTelephonyLocalService
 * @generated
 */
public class AMAnalyticsTelephonyLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.argus.oth.account.management.service.impl.AMAnalyticsTelephonyLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>AMAnalyticsTelephonyLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>AMAnalyticsTelephonyLocalServiceUtil</code>.
	 */
	public static AMAnalyticsTelephony add(
		long groupId, long clientId, java.util.Date amAnalyticsTelephonyDate,
		double avgDownTime, double avgSpeedOfAnswer, double abandonmentRate,
		double downTimeGoal, double speedAnswerGoal, double abandonmentRateGoal,
		double overallAvgDownTime, double overallAvgSpeedOfAnswer,
		double overallAvgAbandonmentRate) {

		return getService().add(
			groupId, clientId, amAnalyticsTelephonyDate, avgDownTime,
			avgSpeedOfAnswer, abandonmentRate, downTimeGoal, speedAnswerGoal,
			abandonmentRateGoal, overallAvgDownTime, overallAvgSpeedOfAnswer,
			overallAvgAbandonmentRate);
	}

	/**
	 * Adds the am analytics telephony to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AMAnalyticsTelephonyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amAnalyticsTelephony the am analytics telephony
	 * @return the am analytics telephony that was added
	 */
	public static AMAnalyticsTelephony addAMAnalyticsTelephony(
		AMAnalyticsTelephony amAnalyticsTelephony) {

		return getService().addAMAnalyticsTelephony(amAnalyticsTelephony);
	}

	/**
	 * Creates a new am analytics telephony with the primary key. Does not add the am analytics telephony to the database.
	 *
	 * @param amAnalyticsTelephonyId the primary key for the new am analytics telephony
	 * @return the new am analytics telephony
	 */
	public static AMAnalyticsTelephony createAMAnalyticsTelephony(
		long amAnalyticsTelephonyId) {

		return getService().createAMAnalyticsTelephony(amAnalyticsTelephonyId);
	}

	public static void deleteAll() {
		getService().deleteAll();
	}

	/**
	 * Deletes the am analytics telephony from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AMAnalyticsTelephonyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amAnalyticsTelephony the am analytics telephony
	 * @return the am analytics telephony that was removed
	 */
	public static AMAnalyticsTelephony deleteAMAnalyticsTelephony(
		AMAnalyticsTelephony amAnalyticsTelephony) {

		return getService().deleteAMAnalyticsTelephony(amAnalyticsTelephony);
	}

	/**
	 * Deletes the am analytics telephony with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AMAnalyticsTelephonyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amAnalyticsTelephonyId the primary key of the am analytics telephony
	 * @return the am analytics telephony that was removed
	 * @throws PortalException if a am analytics telephony with the primary key could not be found
	 */
	public static AMAnalyticsTelephony deleteAMAnalyticsTelephony(
			long amAnalyticsTelephonyId)
		throws PortalException {

		return getService().deleteAMAnalyticsTelephony(amAnalyticsTelephonyId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.account.management.model.impl.AMAnalyticsTelephonyModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.account.management.model.impl.AMAnalyticsTelephonyModelImpl</code>.
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

	public static AMAnalyticsTelephony fetchAMAnalyticsTelephony(
		long amAnalyticsTelephonyId) {

		return getService().fetchAMAnalyticsTelephony(amAnalyticsTelephonyId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns a range of all the am analytics telephonies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.account.management.model.impl.AMAnalyticsTelephonyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of am analytics telephonies
	 * @param end the upper bound of the range of am analytics telephonies (not inclusive)
	 * @return the range of am analytics telephonies
	 */
	public static List<AMAnalyticsTelephony> getAMAnalyticsTelephonies(
		int start, int end) {

		return getService().getAMAnalyticsTelephonies(start, end);
	}

	/**
	 * Returns the number of am analytics telephonies.
	 *
	 * @return the number of am analytics telephonies
	 */
	public static int getAMAnalyticsTelephoniesCount() {
		return getService().getAMAnalyticsTelephoniesCount();
	}

	/**
	 * Returns the am analytics telephony with the primary key.
	 *
	 * @param amAnalyticsTelephonyId the primary key of the am analytics telephony
	 * @return the am analytics telephony
	 * @throws PortalException if a am analytics telephony with the primary key could not be found
	 */
	public static AMAnalyticsTelephony getAMAnalyticsTelephony(
			long amAnalyticsTelephonyId)
		throws PortalException {

		return getService().getAMAnalyticsTelephony(amAnalyticsTelephonyId);
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

	public static void reindex()
		throws com.liferay.portal.kernel.search.SearchException {

		getService().reindex();
	}

	public static void reindex(long companyId)
		throws com.liferay.portal.kernel.search.SearchException {

		getService().reindex(companyId);
	}

	/**
	 * Updates the am analytics telephony in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AMAnalyticsTelephonyLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param amAnalyticsTelephony the am analytics telephony
	 * @return the am analytics telephony that was updated
	 */
	public static AMAnalyticsTelephony updateAMAnalyticsTelephony(
		AMAnalyticsTelephony amAnalyticsTelephony) {

		return getService().updateAMAnalyticsTelephony(amAnalyticsTelephony);
	}

	public static AMAnalyticsTelephonyLocalService getService() {
		return _service;
	}

	private static volatile AMAnalyticsTelephonyLocalService _service;

}