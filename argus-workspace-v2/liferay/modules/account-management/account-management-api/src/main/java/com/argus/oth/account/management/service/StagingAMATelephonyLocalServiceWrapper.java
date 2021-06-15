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
 * Provides a wrapper for {@link StagingAMATelephonyLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see StagingAMATelephonyLocalService
 * @generated
 */
public class StagingAMATelephonyLocalServiceWrapper
	implements ServiceWrapper<StagingAMATelephonyLocalService>,
			   StagingAMATelephonyLocalService {

	public StagingAMATelephonyLocalServiceWrapper(
		StagingAMATelephonyLocalService stagingAMATelephonyLocalService) {

		_stagingAMATelephonyLocalService = stagingAMATelephonyLocalService;
	}

	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>StagingAMATelephonyLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>StagingAMATelephonyLocalServiceUtil</code>.
	 */
	@Override
	public com.argus.oth.account.management.model.StagingAMATelephony add(
		long clientId, String amAnalyticsTelephonyDate, double avgDownTime,
		double avgSpeedOfAnswer, double abandonmentRate, double downTimeGoal,
		double speedAnswerGoal, double abandonmentRateGoal,
		double overallAvgDownTime, double overallAvgSpeedOfAnswer,
		double overallAvgAbandonmentRate) {

		return _stagingAMATelephonyLocalService.add(
			clientId, amAnalyticsTelephonyDate, avgDownTime, avgSpeedOfAnswer,
			abandonmentRate, downTimeGoal, speedAnswerGoal, abandonmentRateGoal,
			overallAvgDownTime, overallAvgSpeedOfAnswer,
			overallAvgAbandonmentRate);
	}

	/**
	 * Adds the staging ama telephony to the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingAMATelephony the staging ama telephony
	 * @return the staging ama telephony that was added
	 */
	@Override
	public com.argus.oth.account.management.model.StagingAMATelephony
		addStagingAMATelephony(
			com.argus.oth.account.management.model.StagingAMATelephony
				stagingAMATelephony) {

		return _stagingAMATelephonyLocalService.addStagingAMATelephony(
			stagingAMATelephony);
	}

	/**
	 * Creates a new staging ama telephony with the primary key. Does not add the staging ama telephony to the database.
	 *
	 * @param stagingAMATelephonyId the primary key for the new staging ama telephony
	 * @return the new staging ama telephony
	 */
	@Override
	public com.argus.oth.account.management.model.StagingAMATelephony
		createStagingAMATelephony(long stagingAMATelephonyId) {

		return _stagingAMATelephonyLocalService.createStagingAMATelephony(
			stagingAMATelephonyId);
	}

	@Override
	public void deleteAll() {
		_stagingAMATelephonyLocalService.deleteAll();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingAMATelephonyLocalService.deletePersistedModel(
			persistedModel);
	}

	/**
	 * Deletes the staging ama telephony with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingAMATelephonyId the primary key of the staging ama telephony
	 * @return the staging ama telephony that was removed
	 * @throws PortalException if a staging ama telephony with the primary key could not be found
	 */
	@Override
	public com.argus.oth.account.management.model.StagingAMATelephony
			deleteStagingAMATelephony(long stagingAMATelephonyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingAMATelephonyLocalService.deleteStagingAMATelephony(
			stagingAMATelephonyId);
	}

	/**
	 * Deletes the staging ama telephony from the database. Also notifies the appropriate model listeners.
	 *
	 * @param stagingAMATelephony the staging ama telephony
	 * @return the staging ama telephony that was removed
	 */
	@Override
	public com.argus.oth.account.management.model.StagingAMATelephony
		deleteStagingAMATelephony(
			com.argus.oth.account.management.model.StagingAMATelephony
				stagingAMATelephony) {

		return _stagingAMATelephonyLocalService.deleteStagingAMATelephony(
			stagingAMATelephony);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _stagingAMATelephonyLocalService.dynamicQuery();
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

		return _stagingAMATelephonyLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.account.management.model.impl.StagingAMATelephonyModelImpl</code>.
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

		return _stagingAMATelephonyLocalService.dynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.account.management.model.impl.StagingAMATelephonyModelImpl</code>.
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

		return _stagingAMATelephonyLocalService.dynamicQuery(
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

		return _stagingAMATelephonyLocalService.dynamicQueryCount(dynamicQuery);
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

		return _stagingAMATelephonyLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.argus.oth.account.management.model.StagingAMATelephony
		fetchStagingAMATelephony(long stagingAMATelephonyId) {

		return _stagingAMATelephonyLocalService.fetchStagingAMATelephony(
			stagingAMATelephonyId);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _stagingAMATelephonyLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _stagingAMATelephonyLocalService.
			getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _stagingAMATelephonyLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingAMATelephonyLocalService.getPersistedModel(
			primaryKeyObj);
	}

	/**
	 * Returns a range of all the staging ama telephonies.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.account.management.model.impl.StagingAMATelephonyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of staging ama telephonies
	 * @param end the upper bound of the range of staging ama telephonies (not inclusive)
	 * @return the range of staging ama telephonies
	 */
	@Override
	public java.util.List
		<com.argus.oth.account.management.model.StagingAMATelephony>
			getStagingAMATelephonies(int start, int end) {

		return _stagingAMATelephonyLocalService.getStagingAMATelephonies(
			start, end);
	}

	/**
	 * Returns the number of staging ama telephonies.
	 *
	 * @return the number of staging ama telephonies
	 */
	@Override
	public int getStagingAMATelephoniesCount() {
		return _stagingAMATelephonyLocalService.getStagingAMATelephoniesCount();
	}

	/**
	 * Returns the staging ama telephony with the primary key.
	 *
	 * @param stagingAMATelephonyId the primary key of the staging ama telephony
	 * @return the staging ama telephony
	 * @throws PortalException if a staging ama telephony with the primary key could not be found
	 */
	@Override
	public com.argus.oth.account.management.model.StagingAMATelephony
			getStagingAMATelephony(long stagingAMATelephonyId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _stagingAMATelephonyLocalService.getStagingAMATelephony(
			stagingAMATelephonyId);
	}

	/**
	 * Updates the staging ama telephony in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param stagingAMATelephony the staging ama telephony
	 * @return the staging ama telephony that was updated
	 */
	@Override
	public com.argus.oth.account.management.model.StagingAMATelephony
		updateStagingAMATelephony(
			com.argus.oth.account.management.model.StagingAMATelephony
				stagingAMATelephony) {

		return _stagingAMATelephonyLocalService.updateStagingAMATelephony(
			stagingAMATelephony);
	}

	@Override
	public StagingAMATelephonyLocalService getWrappedService() {
		return _stagingAMATelephonyLocalService;
	}

	@Override
	public void setWrappedService(
		StagingAMATelephonyLocalService stagingAMATelephonyLocalService) {

		_stagingAMATelephonyLocalService = stagingAMATelephonyLocalService;
	}

	private StagingAMATelephonyLocalService _stagingAMATelephonyLocalService;

}