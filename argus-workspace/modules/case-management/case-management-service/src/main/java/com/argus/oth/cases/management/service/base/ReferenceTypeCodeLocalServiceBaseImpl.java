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

import com.argus.oth.cases.management.model.ReferenceTypeCode;
import com.argus.oth.cases.management.service.ReferenceTypeCodeLocalService;
import com.argus.oth.cases.management.service.ReferenceTypeCodeLocalServiceUtil;
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

import java.lang.reflect.Field;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the reference type code local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.argus.oth.cases.management.service.impl.ReferenceTypeCodeLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.argus.oth.cases.management.service.impl.ReferenceTypeCodeLocalServiceImpl
 * @generated
 */
public abstract class ReferenceTypeCodeLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService,
			   ReferenceTypeCodeLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>ReferenceTypeCodeLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>ReferenceTypeCodeLocalServiceUtil</code>.
	 */

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
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ReferenceTypeCode addReferenceTypeCode(
		ReferenceTypeCode referenceTypeCode) {

		referenceTypeCode.setNew(true);

		return referenceTypeCodePersistence.update(referenceTypeCode);
	}

	/**
	 * Creates a new reference type code with the primary key. Does not add the reference type code to the database.
	 *
	 * @param referenceTypeCodeId the primary key for the new reference type code
	 * @return the new reference type code
	 */
	@Override
	@Transactional(enabled = false)
	public ReferenceTypeCode createReferenceTypeCode(long referenceTypeCodeId) {
		return referenceTypeCodePersistence.create(referenceTypeCodeId);
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
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ReferenceTypeCode deleteReferenceTypeCode(long referenceTypeCodeId)
		throws PortalException {

		return referenceTypeCodePersistence.remove(referenceTypeCodeId);
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
	@Indexable(type = IndexableType.DELETE)
	@Override
	public ReferenceTypeCode deleteReferenceTypeCode(
		ReferenceTypeCode referenceTypeCode) {

		return referenceTypeCodePersistence.remove(referenceTypeCode);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			ReferenceTypeCode.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return referenceTypeCodePersistence.findWithDynamicQuery(dynamicQuery);
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
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return referenceTypeCodePersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return referenceTypeCodePersistence.findWithDynamicQuery(
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
		return referenceTypeCodePersistence.countWithDynamicQuery(dynamicQuery);
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

		return referenceTypeCodePersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public ReferenceTypeCode fetchReferenceTypeCode(long referenceTypeCodeId) {
		return referenceTypeCodePersistence.fetchByPrimaryKey(
			referenceTypeCodeId);
	}

	/**
	 * Returns the reference type code with the primary key.
	 *
	 * @param referenceTypeCodeId the primary key of the reference type code
	 * @return the reference type code
	 * @throws PortalException if a reference type code with the primary key could not be found
	 */
	@Override
	public ReferenceTypeCode getReferenceTypeCode(long referenceTypeCodeId)
		throws PortalException {

		return referenceTypeCodePersistence.findByPrimaryKey(
			referenceTypeCodeId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			referenceTypeCodeLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ReferenceTypeCode.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("referenceTypeCodeId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			referenceTypeCodeLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(ReferenceTypeCode.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"referenceTypeCodeId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			referenceTypeCodeLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(ReferenceTypeCode.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("referenceTypeCodeId");
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return referenceTypeCodeLocalService.deleteReferenceTypeCode(
			(ReferenceTypeCode)persistedModel);
	}

	public BasePersistence<ReferenceTypeCode> getBasePersistence() {
		return referenceTypeCodePersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return referenceTypeCodePersistence.findByPrimaryKey(primaryKeyObj);
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
	@Override
	public List<ReferenceTypeCode> getReferenceTypeCodes(int start, int end) {
		return referenceTypeCodePersistence.findAll(start, end);
	}

	/**
	 * Returns the number of reference type codes.
	 *
	 * @return the number of reference type codes
	 */
	@Override
	public int getReferenceTypeCodesCount() {
		return referenceTypeCodePersistence.countAll();
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
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public ReferenceTypeCode updateReferenceTypeCode(
		ReferenceTypeCode referenceTypeCode) {

		return referenceTypeCodePersistence.update(referenceTypeCode);
	}

	@Deactivate
	protected void deactivate() {
		_setLocalServiceUtilService(null);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			ReferenceTypeCodeLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		referenceTypeCodeLocalService = (ReferenceTypeCodeLocalService)aopProxy;

		_setLocalServiceUtilService(referenceTypeCodeLocalService);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return ReferenceTypeCodeLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return ReferenceTypeCode.class;
	}

	protected String getModelClassName() {
		return ReferenceTypeCode.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				referenceTypeCodePersistence.getDataSource();

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
		ReferenceTypeCodeLocalService referenceTypeCodeLocalService) {

		try {
			Field field =
				ReferenceTypeCodeLocalServiceUtil.class.getDeclaredField(
					"_service");

			field.setAccessible(true);

			field.set(null, referenceTypeCodeLocalService);
		}
		catch (ReflectiveOperationException reflectiveOperationException) {
			throw new RuntimeException(reflectiveOperationException);
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

	protected ReferenceTypeCodeLocalService referenceTypeCodeLocalService;

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