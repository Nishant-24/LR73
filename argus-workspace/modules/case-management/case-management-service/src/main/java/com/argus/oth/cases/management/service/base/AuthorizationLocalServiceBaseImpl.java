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

import com.argus.oth.cases.management.model.Authorization;
import com.argus.oth.cases.management.service.AuthorizationLocalService;
import com.argus.oth.cases.management.service.AuthorizationLocalServiceUtil;
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

import com.liferay.exportimport.kernel.lar.ExportImportHelperUtil;
import com.liferay.exportimport.kernel.lar.ManifestSummary;
import com.liferay.exportimport.kernel.lar.PortletDataContext;
import com.liferay.exportimport.kernel.lar.StagedModelDataHandlerUtil;
import com.liferay.exportimport.kernel.lar.StagedModelType;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery;
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

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the authorization local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.argus.oth.cases.management.service.impl.AuthorizationLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.argus.oth.cases.management.service.impl.AuthorizationLocalServiceImpl
 * @generated
 */
public abstract class AuthorizationLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, AuthorizationLocalService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>AuthorizationLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>AuthorizationLocalServiceUtil</code>.
	 */

	/**
	 * Adds the authorization to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AuthorizationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param authorization the authorization
	 * @return the authorization that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Authorization addAuthorization(Authorization authorization) {
		authorization.setNew(true);

		return authorizationPersistence.update(authorization);
	}

	/**
	 * Creates a new authorization with the primary key. Does not add the authorization to the database.
	 *
	 * @param authorizationId the primary key for the new authorization
	 * @return the new authorization
	 */
	@Override
	@Transactional(enabled = false)
	public Authorization createAuthorization(long authorizationId) {
		return authorizationPersistence.create(authorizationId);
	}

	/**
	 * Deletes the authorization with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AuthorizationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param authorizationId the primary key of the authorization
	 * @return the authorization that was removed
	 * @throws PortalException if a authorization with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Authorization deleteAuthorization(long authorizationId)
		throws PortalException {

		return authorizationPersistence.remove(authorizationId);
	}

	/**
	 * Deletes the authorization from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AuthorizationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param authorization the authorization
	 * @return the authorization that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Authorization deleteAuthorization(Authorization authorization) {
		return authorizationPersistence.remove(authorization);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			Authorization.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return authorizationPersistence.findWithDynamicQuery(dynamicQuery);
	}

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
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return authorizationPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

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
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return authorizationPersistence.findWithDynamicQuery(
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
		return authorizationPersistence.countWithDynamicQuery(dynamicQuery);
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

		return authorizationPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public Authorization fetchAuthorization(long authorizationId) {
		return authorizationPersistence.fetchByPrimaryKey(authorizationId);
	}

	/**
	 * Returns the authorization matching the UUID and group.
	 *
	 * @param uuid the authorization's UUID
	 * @param groupId the primary key of the group
	 * @return the matching authorization, or <code>null</code> if a matching authorization could not be found
	 */
	@Override
	public Authorization fetchAuthorizationByUuidAndGroupId(
		String uuid, long groupId) {

		return authorizationPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the authorization with the primary key.
	 *
	 * @param authorizationId the primary key of the authorization
	 * @return the authorization
	 * @throws PortalException if a authorization with the primary key could not be found
	 */
	@Override
	public Authorization getAuthorization(long authorizationId)
		throws PortalException {

		return authorizationPersistence.findByPrimaryKey(authorizationId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(authorizationLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Authorization.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("authorizationId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			authorizationLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Authorization.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"authorizationId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(authorizationLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Authorization.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("authorizationId");
	}

	@Override
	public ExportActionableDynamicQuery getExportActionableDynamicQuery(
		final PortletDataContext portletDataContext) {

		final ExportActionableDynamicQuery exportActionableDynamicQuery =
			new ExportActionableDynamicQuery() {

				@Override
				public long performCount() throws PortalException {
					ManifestSummary manifestSummary =
						portletDataContext.getManifestSummary();

					StagedModelType stagedModelType = getStagedModelType();

					long modelAdditionCount = super.performCount();

					manifestSummary.addModelAdditionCount(
						stagedModelType, modelAdditionCount);

					long modelDeletionCount =
						ExportImportHelperUtil.getModelDeletionCount(
							portletDataContext, stagedModelType);

					manifestSummary.addModelDeletionCount(
						stagedModelType, modelDeletionCount);

					return modelAdditionCount;
				}

			};

		initActionableDynamicQuery(exportActionableDynamicQuery);

		exportActionableDynamicQuery.setAddCriteriaMethod(
			new ActionableDynamicQuery.AddCriteriaMethod() {

				@Override
				public void addCriteria(DynamicQuery dynamicQuery) {
					portletDataContext.addDateRangeCriteria(
						dynamicQuery, "modifiedDate");
				}

			});

		exportActionableDynamicQuery.setCompanyId(
			portletDataContext.getCompanyId());

		exportActionableDynamicQuery.setPerformActionMethod(
			new ActionableDynamicQuery.PerformActionMethod<Authorization>() {

				@Override
				public void performAction(Authorization authorization)
					throws PortalException {

					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, authorization);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(Authorization.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return authorizationLocalService.deleteAuthorization(
			(Authorization)persistedModel);
	}

	public BasePersistence<Authorization> getBasePersistence() {
		return authorizationPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return authorizationPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the authorizations matching the UUID and company.
	 *
	 * @param uuid the UUID of the authorizations
	 * @param companyId the primary key of the company
	 * @return the matching authorizations, or an empty list if no matches were found
	 */
	@Override
	public List<Authorization> getAuthorizationsByUuidAndCompanyId(
		String uuid, long companyId) {

		return authorizationPersistence.findByUuid_C(uuid, companyId);
	}

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
	@Override
	public List<Authorization> getAuthorizationsByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Authorization> orderByComparator) {

		return authorizationPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the authorization matching the UUID and group.
	 *
	 * @param uuid the authorization's UUID
	 * @param groupId the primary key of the group
	 * @return the matching authorization
	 * @throws PortalException if a matching authorization could not be found
	 */
	@Override
	public Authorization getAuthorizationByUuidAndGroupId(
			String uuid, long groupId)
		throws PortalException {

		return authorizationPersistence.findByUUID_G(uuid, groupId);
	}

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
	@Override
	public List<Authorization> getAuthorizations(int start, int end) {
		return authorizationPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of authorizations.
	 *
	 * @return the number of authorizations
	 */
	@Override
	public int getAuthorizationsCount() {
		return authorizationPersistence.countAll();
	}

	/**
	 * Updates the authorization in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AuthorizationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param authorization the authorization
	 * @return the authorization that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Authorization updateAuthorization(Authorization authorization) {
		return authorizationPersistence.update(authorization);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			AuthorizationLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		authorizationLocalService = (AuthorizationLocalService)aopProxy;

		_setLocalServiceUtilService(authorizationLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return AuthorizationLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Authorization.class;
	}

	protected String getModelClassName() {
		return Authorization.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = authorizationPersistence.getDataSource();

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

	private void _setLocalServiceUtilService(
		AuthorizationLocalService authorizationLocalService) {

		try {
			Field field = AuthorizationLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, authorizationLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	protected AuthorizationLocalService authorizationLocalService;

	@Reference
	protected AuthorizationPersistence authorizationPersistence;

	@Reference
	protected AuthProcedurePersistence authProcedurePersistence;

	@Reference
	protected CasesPersistence casesPersistence;

	@Reference
	protected CasesGroupItemPersistence casesGroupItemPersistence;

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
	protected com.liferay.portal.kernel.service.GroupLocalService
		groupLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

}