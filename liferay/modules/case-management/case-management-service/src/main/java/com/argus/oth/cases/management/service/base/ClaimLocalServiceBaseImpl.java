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

package com.argus.oth.cases.management.service.base;

import com.argus.oth.cases.management.model.Claim;
import com.argus.oth.cases.management.service.ClaimLocalService;
import com.argus.oth.cases.management.service.persistence.AuthProcedurePersistence;
import com.argus.oth.cases.management.service.persistence.AuthorizationPersistence;
import com.argus.oth.cases.management.service.persistence.CasesGroupItemPersistence;
import com.argus.oth.cases.management.service.persistence.CasesPersistence;
import com.argus.oth.cases.management.service.persistence.ClaimDetailPersistence;
import com.argus.oth.cases.management.service.persistence.ClaimPersistence;
import com.argus.oth.cases.management.service.persistence.ClientGroupPersistence;
import com.argus.oth.cases.management.service.persistence.ClientPersistence;
import com.argus.oth.cases.management.service.persistence.DataRequestPersistence;
import com.argus.oth.cases.management.service.persistence.MemberPersistence;
import com.argus.oth.cases.management.service.persistence.NotePersistence;
import com.argus.oth.cases.management.service.persistence.ReferenceTypeCodePersistence;
import com.argus.oth.cases.management.service.persistence.StagingAuthProcedurePersistence;
import com.argus.oth.cases.management.service.persistence.StagingAuthorizationPersistence;
import com.argus.oth.cases.management.service.persistence.StagingCasesPersistence;
import com.argus.oth.cases.management.service.persistence.StagingClaimDetailPersistence;
import com.argus.oth.cases.management.service.persistence.StagingClaimPersistence;
import com.argus.oth.cases.management.service.persistence.StagingClientGroupPersistence;
import com.argus.oth.cases.management.service.persistence.StagingClientPersistence;
import com.argus.oth.cases.management.service.persistence.StagingMemberPersistence;
import com.argus.oth.cases.management.service.persistence.StagingNotePersistence;
import com.argus.oth.cases.management.service.persistence.StagingReferenceTypeCodePersistence;
import com.argus.oth.cases.management.service.persistence.StagingTaskPersistence;
import com.argus.oth.cases.management.service.persistence.TaskPersistence;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the claim local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.argus.oth.cases.management.service.impl.ClaimLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.argus.oth.cases.management.service.impl.ClaimLocalServiceImpl
 * @generated
 */
public abstract class ClaimLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, ClaimLocalService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ClaimLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.argus.oth.cases.management.service.ClaimLocalServiceUtil</code>.
	 */

	/**
	 * Adds the claim to the database. Also notifies the appropriate model listeners.
	 *
	 * @param claim the claim
	 * @return the claim that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Claim addClaim(Claim claim) {
		claim.setNew(true);

		return claimPersistence.update(claim);
	}

	/**
	 * Creates a new claim with the primary key. Does not add the claim to the database.
	 *
	 * @param claimId the primary key for the new claim
	 * @return the new claim
	 */
	@Override
	@Transactional(enabled = false)
	public Claim createClaim(long claimId) {
		return claimPersistence.create(claimId);
	}

	/**
	 * Deletes the claim with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param claimId the primary key of the claim
	 * @return the claim that was removed
	 * @throws PortalException if a claim with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Claim deleteClaim(long claimId) throws PortalException {
		return claimPersistence.remove(claimId);
	}

	/**
	 * Deletes the claim from the database. Also notifies the appropriate model listeners.
	 *
	 * @param claim the claim
	 * @return the claim that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Claim deleteClaim(Claim claim) {
		return claimPersistence.remove(claim);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			Claim.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return claimPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.ClaimModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return claimPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.ClaimModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return claimPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return claimPersistence.countWithDynamicQuery(dynamicQuery);
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
		DynamicQuery dynamicQuery, Projection projection) {

		return claimPersistence.countWithDynamicQuery(dynamicQuery, projection);
	}

	@Override
	public Claim fetchClaim(long claimId) {
		return claimPersistence.fetchByPrimaryKey(claimId);
	}

	/**
	 * Returns the claim with the primary key.
	 *
	 * @param claimId the primary key of the claim
	 * @return the claim
	 * @throws PortalException if a claim with the primary key could not be found
	 */
	@Override
	public Claim getClaim(long claimId) throws PortalException {
		return claimPersistence.findByPrimaryKey(claimId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(claimLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Claim.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("claimId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(claimLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Claim.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("claimId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(claimLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Claim.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("claimId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return claimLocalService.deleteClaim((Claim)persistedModel);
	}

	public BasePersistence<Claim> getBasePersistence() {
		return claimPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return claimPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the claims.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.ClaimModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claims
	 * @param end the upper bound of the range of claims (not inclusive)
	 * @return the range of claims
	 */
	@Override
	public List<Claim> getClaims(int start, int end) {
		return claimPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of claims.
	 *
	 * @return the number of claims
	 */
	@Override
	public int getClaimsCount() {
		return claimPersistence.countAll();
	}

	/**
	 * Updates the claim in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * @param claim the claim
	 * @return the claim that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Claim updateClaim(Claim claim) {
		return claimPersistence.update(claim);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			ClaimLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		claimLocalService = (ClaimLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ClaimLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Claim.class;
	}

	protected String getModelClassName() {
		return Claim.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = claimPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	@Reference
	protected AuthorizationPersistence authorizationPersistence;

	@Reference
	protected AuthProcedurePersistence authProcedurePersistence;

	@Reference
	protected CasesPersistence casesPersistence;

	@Reference
	protected CasesGroupItemPersistence casesGroupItemPersistence;

	protected ClaimLocalService claimLocalService;

	@Reference
	protected ClaimPersistence claimPersistence;

	@Reference
	protected ClaimDetailPersistence claimDetailPersistence;

	@Reference
	protected ClientPersistence clientPersistence;

	@Reference
	protected ClientGroupPersistence clientGroupPersistence;

	@Reference
	protected DataRequestPersistence dataRequestPersistence;

	@Reference
	protected MemberPersistence memberPersistence;

	@Reference
	protected NotePersistence notePersistence;

	@Reference
	protected ReferenceTypeCodePersistence referenceTypeCodePersistence;

	@Reference
	protected StagingAuthorizationPersistence stagingAuthorizationPersistence;

	@Reference
	protected StagingAuthProcedurePersistence stagingAuthProcedurePersistence;

	@Reference
	protected StagingCasesPersistence stagingCasesPersistence;

	@Reference
	protected StagingClaimPersistence stagingClaimPersistence;

	@Reference
	protected StagingClaimDetailPersistence stagingClaimDetailPersistence;

	@Reference
	protected StagingClientPersistence stagingClientPersistence;

	@Reference
	protected StagingClientGroupPersistence stagingClientGroupPersistence;

	@Reference
	protected StagingMemberPersistence stagingMemberPersistence;

	@Reference
	protected StagingNotePersistence stagingNotePersistence;

	@Reference
	protected StagingReferenceTypeCodePersistence
		stagingReferenceTypeCodePersistence;

	@Reference
	protected StagingTaskPersistence stagingTaskPersistence;

	@Reference
	protected TaskPersistence taskPersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

}