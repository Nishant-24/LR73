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

import com.argus.oth.cases.management.model.Cases;
import com.argus.oth.cases.management.service.CasesLocalService;
import com.argus.oth.cases.management.service.CasesLocalServiceUtil;
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
 * Provides the base implementation for the cases local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.argus.oth.cases.management.service.impl.CasesLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.argus.oth.cases.management.service.impl.CasesLocalServiceImpl
 * @generated
 */
public abstract class CasesLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, CasesLocalService, IdentifiableOSGiService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>CasesLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>CasesLocalServiceUtil</code>.
	 */

	/**
	 * Adds the cases to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CasesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cases the cases
	 * @return the cases that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Cases addCases(Cases cases) {
		cases.setNew(true);

		return casesPersistence.update(cases);
	}

	/**
	 * Creates a new cases with the primary key. Does not add the cases to the database.
	 *
	 * @param caseId the primary key for the new cases
	 * @return the new cases
	 */
	@Override
	@Transactional(enabled = false)
	public Cases createCases(long caseId) {
		return casesPersistence.create(caseId);
	}

	/**
	 * Deletes the cases with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CasesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param caseId the primary key of the cases
	 * @return the cases that was removed
	 * @throws PortalException if a cases with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Cases deleteCases(long caseId) throws PortalException {
		return casesPersistence.remove(caseId);
	}

	/**
	 * Deletes the cases from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CasesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cases the cases
	 * @return the cases that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public Cases deleteCases(Cases cases) {
		return casesPersistence.remove(cases);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			Cases.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return casesPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.CasesModelImpl</code>.
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

		return casesPersistence.findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.CasesModelImpl</code>.
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

		return casesPersistence.findWithDynamicQuery(
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
		return casesPersistence.countWithDynamicQuery(dynamicQuery);
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

		return casesPersistence.countWithDynamicQuery(dynamicQuery, projection);
	}

	@Override
	public Cases fetchCases(long caseId) {
		return casesPersistence.fetchByPrimaryKey(caseId);
	}

	/**
	 * Returns the cases matching the UUID and group.
	 *
	 * @param uuid the cases's UUID
	 * @param groupId the primary key of the group
	 * @return the matching cases, or <code>null</code> if a matching cases could not be found
	 */
	@Override
	public Cases fetchCasesByUuidAndGroupId(String uuid, long groupId) {
		return casesPersistence.fetchByUUID_G(uuid, groupId);
	}

	/**
	 * Returns the cases with the primary key.
	 *
	 * @param caseId the primary key of the cases
	 * @return the cases
	 * @throws PortalException if a cases with the primary key could not be found
	 */
	@Override
	public Cases getCases(long caseId) throws PortalException {
		return casesPersistence.findByPrimaryKey(caseId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(casesLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Cases.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("caseId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(casesLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(Cases.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName("caseId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(casesLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(Cases.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("caseId");
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
			new ActionableDynamicQuery.PerformActionMethod<Cases>() {

				@Override
				public void performAction(Cases cases) throws PortalException {
					StagedModelDataHandlerUtil.exportStagedModel(
						portletDataContext, cases);
				}

			});
		exportActionableDynamicQuery.setStagedModelType(
			new StagedModelType(
				PortalUtil.getClassNameId(Cases.class.getName())));

		return exportActionableDynamicQuery;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return casesLocalService.deleteCases((Cases)persistedModel);
	}

	public BasePersistence<Cases> getBasePersistence() {
		return casesPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return casesPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns all the caseses matching the UUID and company.
	 *
	 * @param uuid the UUID of the caseses
	 * @param companyId the primary key of the company
	 * @return the matching caseses, or an empty list if no matches were found
	 */
	@Override
	public List<Cases> getCasesesByUuidAndCompanyId(
		String uuid, long companyId) {

		return casesPersistence.findByUuid_C(uuid, companyId);
	}

	/**
	 * Returns a range of caseses matching the UUID and company.
	 *
	 * @param uuid the UUID of the caseses
	 * @param companyId the primary key of the company
	 * @param start the lower bound of the range of caseses
	 * @param end the upper bound of the range of caseses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the range of matching caseses, or an empty list if no matches were found
	 */
	@Override
	public List<Cases> getCasesesByUuidAndCompanyId(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Cases> orderByComparator) {

		return casesPersistence.findByUuid_C(
			uuid, companyId, start, end, orderByComparator);
	}

	/**
	 * Returns the cases matching the UUID and group.
	 *
	 * @param uuid the cases's UUID
	 * @param groupId the primary key of the group
	 * @return the matching cases
	 * @throws PortalException if a matching cases could not be found
	 */
	@Override
	public Cases getCasesByUuidAndGroupId(String uuid, long groupId)
		throws PortalException {

		return casesPersistence.findByUUID_G(uuid, groupId);
	}

	/**
	 * Returns a range of all the caseses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.argus.oth.cases.management.model.impl.CasesModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of caseses
	 * @param end the upper bound of the range of caseses (not inclusive)
	 * @return the range of caseses
	 */
	@Override
	public List<Cases> getCaseses(int start, int end) {
		return casesPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of caseses.
	 *
	 * @return the number of caseses
	 */
	@Override
	public int getCasesesCount() {
		return casesPersistence.countAll();
	}

	/**
	 * Updates the cases in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CasesLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param cases the cases
	 * @return the cases that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public Cases updateCases(Cases cases) {
		return casesPersistence.update(cases);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			CasesLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		casesLocalService = (CasesLocalService)aopProxy;

		_setLocalServiceUtilService(casesLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return CasesLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return Cases.class;
	}

	protected String getModelClassName() {
		return Cases.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = casesPersistence.getDataSource();

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
		CasesLocalService casesLocalService) {

		try {
			Field field = CasesLocalServiceUtil.class.getDeclaredField(
				"_service");

			field.setAccessible(true);

			field.set(null, casesLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
		}
	}

	@Reference
	protected AuthorizationPersistence authorizationPersistence;

	@Reference
	protected AuthProcedurePersistence authProcedurePersistence;

	protected CasesLocalService casesLocalService;

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