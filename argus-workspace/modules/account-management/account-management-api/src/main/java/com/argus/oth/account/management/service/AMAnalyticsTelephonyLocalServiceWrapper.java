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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link AMAnalyticsTelephonyLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see AMAnalyticsTelephonyLocalService
 * @generated
 */
public class AMAnalyticsTelephonyLocalServiceWrapper
	implements AMAnalyticsTelephonyLocalService,
			   ServiceWrapper<AMAnalyticsTelephonyLocalService> {

	public AMAnalyticsTelephonyLocalServiceWrapper(
		AMAnalyticsTelephonyLocalService amAnalyticsTelephonyLocalService) {

		_amAnalyticsTelephonyLocalService = amAnalyticsTelephonyLocalService;
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>AMAnalyticsTelephonyLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>AMAnalyticsTelephonyLocalServiceUtil</code>.
	 */
	@Override
	public com.argus.oth.account.management.model.AMAnalyticsTelephony add(
		long groupId, long clientId, java.util.Date amAnalyticsTelephonyDate,
		double avgDownTime, double avgSpeedOfAnswer, double abandonmentRate,
		double downTimeGoal, double speedAnswerGoal, double abandonmentRateGoal,
		double overallAvgDownTime, double overallAvgSpeedOfAnswer,
		double overallAvgAbandonmentRate) {

		return _amAnalyticsTelephonyLocalService.add(
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
	@Override
	public com.argus.oth.account.management.model.AMAnalyticsTelephony
		addAMAnalyticsTelephony(
			com.argus.oth.account.management.model.AMAnalyticsTelephony
				amAnalyticsTelephony) {

		return _amAnalyticsTelephonyLocalService.addAMAnalyticsTelephony(
			amAnalyticsTelephony);
	}

	/**
	 * Creates a new am analytics telephony with the primary key. Does not add the am analytics telephony to the database.
	 *
	 * @param amAnalyticsTelephonyId the primary key for the new am analytics telephony
	 * @return the new am analytics telephony
	 */
	@Override
	public com.argus.oth.account.management.model.AMAnalyticsTelephony
		createAMAnalyticsTelephony(long amAnalyticsTelephonyId) {

		return _amAnalyticsTelephonyLocalService.createAMAnalyticsTelephony(
			amAnalyticsTelephonyId);
	}

	@Override
	public void deleteAll() {
		_amAnalyticsTelephonyLocalService.deleteAll();
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
	@Override
	public com.argus.oth.account.management.model.AMAnalyticsTelephony
		deleteAMAnalyticsTelephony(
			com.argus.oth.account.management.model.AMAnalyticsTelephony
				amAnalyticsTelephony) {

		return _amAnalyticsTelephonyLocalService.deleteAMAnalyticsTelephony(
			amAnalyticsTelephony);
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
	@Override
	public com.argus.oth.account.management.model.AMAnalyticsTelephony
			deleteAMAnalyticsTelephony(long amAnalyticsTelephonyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amAnalyticsTelephonyLocalService.deleteAMAnalyticsTelephony(
			amAnalyticsTelephonyId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amAnalyticsTelephonyLocalService.deletePersistedModel(
			persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _amAnalyticsTelephonyLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _amAnalyticsTelephonyLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _amAnalyticsTelephonyLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _amAnalyticsTelephonyLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _amAnalyticsTelephonyLocalService.dynamicQueryCount(
			dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _amAnalyticsTelephonyLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.argus.oth.account.management.model.AMAnalyticsTelephony
		fetchAMAnalyticsTelephony(long amAnalyticsTelephonyId) {

		return _amAnalyticsTelephonyLocalService.fetchAMAnalyticsTelephony(
			amAnalyticsTelephonyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _amAnalyticsTelephonyLocalService.getActionableDynamicQuery();
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
	@Override
	public java.util.List
		<com.argus.oth.account.management.model.AMAnalyticsTelephony>
			getAMAnalyticsTelephonies(int start, int end) {

		return _amAnalyticsTelephonyLocalService.getAMAnalyticsTelephonies(
			start, end);
	}

	/**
	 * Returns the number of am analytics telephonies.
	 *
	 * @return the number of am analytics telephonies
	 */
	@Override
	public int getAMAnalyticsTelephoniesCount() {
		return _amAnalyticsTelephonyLocalService.
			getAMAnalyticsTelephoniesCount();
	}

	/**
	 * Returns the am analytics telephony with the primary key.
	 *
	 * @param amAnalyticsTelephonyId the primary key of the am analytics telephony
	 * @return the am analytics telephony
	 * @throws PortalException if a am analytics telephony with the primary key could not be found
	 */
	@Override
	public com.argus.oth.account.management.model.AMAnalyticsTelephony
			getAMAnalyticsTelephony(long amAnalyticsTelephonyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amAnalyticsTelephonyLocalService.getAMAnalyticsTelephony(
			amAnalyticsTelephonyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _amAnalyticsTelephonyLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _amAnalyticsTelephonyLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _amAnalyticsTelephonyLocalService.getPersistedModel(
			primaryKeyObj);
	}

	@Override
	public void reindex()
		throws com.liferay.portal.kernel.search.SearchException {

		_amAnalyticsTelephonyLocalService.reindex();
	}

	@Override
	public void reindex(long companyId)
		throws com.liferay.portal.kernel.search.SearchException {

		_amAnalyticsTelephonyLocalService.reindex(companyId);
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
	@Override
	public com.argus.oth.account.management.model.AMAnalyticsTelephony
		updateAMAnalyticsTelephony(
			com.argus.oth.account.management.model.AMAnalyticsTelephony
				amAnalyticsTelephony) {

		return _amAnalyticsTelephonyLocalService.updateAMAnalyticsTelephony(
			amAnalyticsTelephony);
	}

	@Override
	public AMAnalyticsTelephonyLocalService getWrappedService() {
		return _amAnalyticsTelephonyLocalService;
	}

	@Override
	public void setWrappedService(
		AMAnalyticsTelephonyLocalService amAnalyticsTelephonyLocalService) {

		_amAnalyticsTelephonyLocalService = amAnalyticsTelephonyLocalService;
	}

	private AMAnalyticsTelephonyLocalService _amAnalyticsTelephonyLocalService;

}