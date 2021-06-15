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

package com.argus.oth.cases.management.model.impl;

import com.argus.oth.cases.management.model.StagingClaimDetail;
import com.argus.oth.cases.management.model.StagingClaimDetailModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.ProxyUtil;

import java.io.Serializable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;

import java.sql.Types;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * The base model implementation for the StagingClaimDetail service. Represents a row in the &quot;OTH_StagingClaimDetail&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>StagingClaimDetailModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link StagingClaimDetailImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingClaimDetailImpl
 * @generated
 */
public class StagingClaimDetailModelImpl
	extends BaseModelImpl<StagingClaimDetail>
	implements StagingClaimDetailModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a staging claim detail model instance should use the <code>StagingClaimDetail</code> interface instead.
	 */
	public static final String TABLE_NAME = "OTH_StagingClaimDetail";

	public static final Object[][] TABLE_COLUMNS = {
		{"stagingClaimDetailId", Types.BIGINT}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"lineId", Types.BIGINT},
		{"externalClaimId", Types.BIGINT}, {"serviceFrom", Types.VARCHAR},
		{"serviceThru", Types.VARCHAR}, {"resultCodes", Types.VARCHAR},
		{"procedureCode", Types.VARCHAR}, {"chargedAmount", Types.DOUBLE},
		{"repricedAmount", Types.DOUBLE}, {"claimAmount", Types.DOUBLE},
		{"paidDate", Types.VARCHAR}, {"paidAmount", Types.DOUBLE},
		{"savingsAmount", Types.DOUBLE}, {"units", Types.INTEGER},
		{"coverage", Types.VARCHAR}, {"lineStatus", Types.VARCHAR},
		{"revCode", Types.VARCHAR}, {"externalModifiedDate", Types.VARCHAR},
		{"externalCreatedDate", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("stagingClaimDetailId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("lineId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("externalClaimId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("serviceFrom", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("serviceThru", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("resultCodes", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("procedureCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("chargedAmount", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("repricedAmount", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("claimAmount", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("paidDate", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("paidAmount", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("savingsAmount", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("units", Types.INTEGER);
		TABLE_COLUMNS_MAP.put("coverage", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("lineStatus", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("revCode", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("externalModifiedDate", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("externalCreatedDate", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table OTH_StagingClaimDetail (stagingClaimDetailId LONG not null primary key,createDate DATE null,modifiedDate DATE null,lineId LONG,externalClaimId LONG,serviceFrom VARCHAR(75) null,serviceThru VARCHAR(75) null,resultCodes STRING null,procedureCode VARCHAR(1000) null,chargedAmount DOUBLE,repricedAmount DOUBLE,claimAmount DOUBLE,paidDate VARCHAR(75) null,paidAmount DOUBLE,savingsAmount DOUBLE,units INTEGER,coverage VARCHAR(75) null,lineStatus VARCHAR(75) null,revCode VARCHAR(1000) null,externalModifiedDate VARCHAR(75) null,externalCreatedDate VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table OTH_StagingClaimDetail";

	public static final String ORDER_BY_JPQL =
		" ORDER BY stagingClaimDetail.stagingClaimDetailId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY OTH_StagingClaimDetail.stagingClaimDetailId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	public StagingClaimDetailModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _stagingClaimDetailId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setStagingClaimDetailId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _stagingClaimDetailId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return StagingClaimDetail.class;
	}

	@Override
	public String getModelClassName() {
		return StagingClaimDetail.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<StagingClaimDetail, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<StagingClaimDetail, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<StagingClaimDetail, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((StagingClaimDetail)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<StagingClaimDetail, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<StagingClaimDetail, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(StagingClaimDetail)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<StagingClaimDetail, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<StagingClaimDetail, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, StagingClaimDetail>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			StagingClaimDetail.class.getClassLoader(), StagingClaimDetail.class,
			ModelWrapper.class);

		try {
			Constructor<StagingClaimDetail> constructor =
				(Constructor<StagingClaimDetail>)proxyClass.getConstructor(
					InvocationHandler.class);

			return invocationHandler -> {
				try {
					return constructor.newInstance(invocationHandler);
				}
				catch (ReflectiveOperationException
							reflectiveOperationException) {

					throw new InternalError(reflectiveOperationException);
				}
			};
		}
		catch (NoSuchMethodException noSuchMethodException) {
			throw new InternalError(noSuchMethodException);
		}
	}

	private static final Map<String, Function<StagingClaimDetail, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<StagingClaimDetail, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<StagingClaimDetail, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<StagingClaimDetail, Object>>();
		Map<String, BiConsumer<StagingClaimDetail, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<StagingClaimDetail, ?>>();

		attributeGetterFunctions.put(
			"stagingClaimDetailId",
			StagingClaimDetail::getStagingClaimDetailId);
		attributeSetterBiConsumers.put(
			"stagingClaimDetailId",
			(BiConsumer<StagingClaimDetail, Long>)
				StagingClaimDetail::setStagingClaimDetailId);
		attributeGetterFunctions.put(
			"createDate", StagingClaimDetail::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<StagingClaimDetail, Date>)
				StagingClaimDetail::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", StagingClaimDetail::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<StagingClaimDetail, Date>)
				StagingClaimDetail::setModifiedDate);
		attributeGetterFunctions.put("lineId", StagingClaimDetail::getLineId);
		attributeSetterBiConsumers.put(
			"lineId",
			(BiConsumer<StagingClaimDetail, Long>)
				StagingClaimDetail::setLineId);
		attributeGetterFunctions.put(
			"externalClaimId", StagingClaimDetail::getExternalClaimId);
		attributeSetterBiConsumers.put(
			"externalClaimId",
			(BiConsumer<StagingClaimDetail, Long>)
				StagingClaimDetail::setExternalClaimId);
		attributeGetterFunctions.put(
			"serviceFrom", StagingClaimDetail::getServiceFrom);
		attributeSetterBiConsumers.put(
			"serviceFrom",
			(BiConsumer<StagingClaimDetail, String>)
				StagingClaimDetail::setServiceFrom);
		attributeGetterFunctions.put(
			"serviceThru", StagingClaimDetail::getServiceThru);
		attributeSetterBiConsumers.put(
			"serviceThru",
			(BiConsumer<StagingClaimDetail, String>)
				StagingClaimDetail::setServiceThru);
		attributeGetterFunctions.put(
			"resultCodes", StagingClaimDetail::getResultCodes);
		attributeSetterBiConsumers.put(
			"resultCodes",
			(BiConsumer<StagingClaimDetail, String>)
				StagingClaimDetail::setResultCodes);
		attributeGetterFunctions.put(
			"procedureCode", StagingClaimDetail::getProcedureCode);
		attributeSetterBiConsumers.put(
			"procedureCode",
			(BiConsumer<StagingClaimDetail, String>)
				StagingClaimDetail::setProcedureCode);
		attributeGetterFunctions.put(
			"chargedAmount", StagingClaimDetail::getChargedAmount);
		attributeSetterBiConsumers.put(
			"chargedAmount",
			(BiConsumer<StagingClaimDetail, Double>)
				StagingClaimDetail::setChargedAmount);
		attributeGetterFunctions.put(
			"repricedAmount", StagingClaimDetail::getRepricedAmount);
		attributeSetterBiConsumers.put(
			"repricedAmount",
			(BiConsumer<StagingClaimDetail, Double>)
				StagingClaimDetail::setRepricedAmount);
		attributeGetterFunctions.put(
			"claimAmount", StagingClaimDetail::getClaimAmount);
		attributeSetterBiConsumers.put(
			"claimAmount",
			(BiConsumer<StagingClaimDetail, Double>)
				StagingClaimDetail::setClaimAmount);
		attributeGetterFunctions.put(
			"paidDate", StagingClaimDetail::getPaidDate);
		attributeSetterBiConsumers.put(
			"paidDate",
			(BiConsumer<StagingClaimDetail, String>)
				StagingClaimDetail::setPaidDate);
		attributeGetterFunctions.put(
			"paidAmount", StagingClaimDetail::getPaidAmount);
		attributeSetterBiConsumers.put(
			"paidAmount",
			(BiConsumer<StagingClaimDetail, Double>)
				StagingClaimDetail::setPaidAmount);
		attributeGetterFunctions.put(
			"savingsAmount", StagingClaimDetail::getSavingsAmount);
		attributeSetterBiConsumers.put(
			"savingsAmount",
			(BiConsumer<StagingClaimDetail, Double>)
				StagingClaimDetail::setSavingsAmount);
		attributeGetterFunctions.put("units", StagingClaimDetail::getUnits);
		attributeSetterBiConsumers.put(
			"units",
			(BiConsumer<StagingClaimDetail, Integer>)
				StagingClaimDetail::setUnits);
		attributeGetterFunctions.put(
			"coverage", StagingClaimDetail::getCoverage);
		attributeSetterBiConsumers.put(
			"coverage",
			(BiConsumer<StagingClaimDetail, String>)
				StagingClaimDetail::setCoverage);
		attributeGetterFunctions.put(
			"lineStatus", StagingClaimDetail::getLineStatus);
		attributeSetterBiConsumers.put(
			"lineStatus",
			(BiConsumer<StagingClaimDetail, String>)
				StagingClaimDetail::setLineStatus);
		attributeGetterFunctions.put("revCode", StagingClaimDetail::getRevCode);
		attributeSetterBiConsumers.put(
			"revCode",
			(BiConsumer<StagingClaimDetail, String>)
				StagingClaimDetail::setRevCode);
		attributeGetterFunctions.put(
			"externalModifiedDate",
			StagingClaimDetail::getExternalModifiedDate);
		attributeSetterBiConsumers.put(
			"externalModifiedDate",
			(BiConsumer<StagingClaimDetail, String>)
				StagingClaimDetail::setExternalModifiedDate);
		attributeGetterFunctions.put(
			"externalCreatedDate", StagingClaimDetail::getExternalCreatedDate);
		attributeSetterBiConsumers.put(
			"externalCreatedDate",
			(BiConsumer<StagingClaimDetail, String>)
				StagingClaimDetail::setExternalCreatedDate);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getStagingClaimDetailId() {
		return _stagingClaimDetailId;
	}

	@Override
	public void setStagingClaimDetailId(long stagingClaimDetailId) {
		_stagingClaimDetailId = stagingClaimDetailId;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public boolean hasSetModifiedDate() {
		return _setModifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_setModifiedDate = true;

		_modifiedDate = modifiedDate;
	}

	@Override
	public long getLineId() {
		return _lineId;
	}

	@Override
	public void setLineId(long lineId) {
		_lineId = lineId;
	}

	@Override
	public long getExternalClaimId() {
		return _externalClaimId;
	}

	@Override
	public void setExternalClaimId(long externalClaimId) {
		_externalClaimId = externalClaimId;
	}

	@Override
	public String getServiceFrom() {
		if (_serviceFrom == null) {
			return "";
		}
		else {
			return _serviceFrom;
		}
	}

	@Override
	public void setServiceFrom(String serviceFrom) {
		_serviceFrom = serviceFrom;
	}

	@Override
	public String getServiceThru() {
		if (_serviceThru == null) {
			return "";
		}
		else {
			return _serviceThru;
		}
	}

	@Override
	public void setServiceThru(String serviceThru) {
		_serviceThru = serviceThru;
	}

	@Override
	public String getResultCodes() {
		if (_resultCodes == null) {
			return "";
		}
		else {
			return _resultCodes;
		}
	}

	@Override
	public void setResultCodes(String resultCodes) {
		_resultCodes = resultCodes;
	}

	@Override
	public String getProcedureCode() {
		if (_procedureCode == null) {
			return "";
		}
		else {
			return _procedureCode;
		}
	}

	@Override
	public void setProcedureCode(String procedureCode) {
		_procedureCode = procedureCode;
	}

	@Override
	public double getChargedAmount() {
		return _chargedAmount;
	}

	@Override
	public void setChargedAmount(double chargedAmount) {
		_chargedAmount = chargedAmount;
	}

	@Override
	public double getRepricedAmount() {
		return _repricedAmount;
	}

	@Override
	public void setRepricedAmount(double repricedAmount) {
		_repricedAmount = repricedAmount;
	}

	@Override
	public double getClaimAmount() {
		return _claimAmount;
	}

	@Override
	public void setClaimAmount(double claimAmount) {
		_claimAmount = claimAmount;
	}

	@Override
	public String getPaidDate() {
		if (_paidDate == null) {
			return "";
		}
		else {
			return _paidDate;
		}
	}

	@Override
	public void setPaidDate(String paidDate) {
		_paidDate = paidDate;
	}

	@Override
	public double getPaidAmount() {
		return _paidAmount;
	}

	@Override
	public void setPaidAmount(double paidAmount) {
		_paidAmount = paidAmount;
	}

	@Override
	public double getSavingsAmount() {
		return _savingsAmount;
	}

	@Override
	public void setSavingsAmount(double savingsAmount) {
		_savingsAmount = savingsAmount;
	}

	@Override
	public int getUnits() {
		return _units;
	}

	@Override
	public void setUnits(int units) {
		_units = units;
	}

	@Override
	public String getCoverage() {
		if (_coverage == null) {
			return "";
		}
		else {
			return _coverage;
		}
	}

	@Override
	public void setCoverage(String coverage) {
		_coverage = coverage;
	}

	@Override
	public String getLineStatus() {
		if (_lineStatus == null) {
			return "";
		}
		else {
			return _lineStatus;
		}
	}

	@Override
	public void setLineStatus(String lineStatus) {
		_lineStatus = lineStatus;
	}

	@Override
	public String getRevCode() {
		if (_revCode == null) {
			return "";
		}
		else {
			return _revCode;
		}
	}

	@Override
	public void setRevCode(String revCode) {
		_revCode = revCode;
	}

	@Override
	public String getExternalModifiedDate() {
		if (_externalModifiedDate == null) {
			return "";
		}
		else {
			return _externalModifiedDate;
		}
	}

	@Override
	public void setExternalModifiedDate(String externalModifiedDate) {
		_externalModifiedDate = externalModifiedDate;
	}

	@Override
	public String getExternalCreatedDate() {
		if (_externalCreatedDate == null) {
			return "";
		}
		else {
			return _externalCreatedDate;
		}
	}

	@Override
	public void setExternalCreatedDate(String externalCreatedDate) {
		_externalCreatedDate = externalCreatedDate;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, StagingClaimDetail.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public StagingClaimDetail toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, StagingClaimDetail>
				escapedModelProxyProviderFunction =
					EscapedModelProxyProviderFunctionHolder.
						_escapedModelProxyProviderFunction;

			_escapedModel = escapedModelProxyProviderFunction.apply(
				new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		StagingClaimDetailImpl stagingClaimDetailImpl =
			new StagingClaimDetailImpl();

		stagingClaimDetailImpl.setStagingClaimDetailId(
			getStagingClaimDetailId());
		stagingClaimDetailImpl.setCreateDate(getCreateDate());
		stagingClaimDetailImpl.setModifiedDate(getModifiedDate());
		stagingClaimDetailImpl.setLineId(getLineId());
		stagingClaimDetailImpl.setExternalClaimId(getExternalClaimId());
		stagingClaimDetailImpl.setServiceFrom(getServiceFrom());
		stagingClaimDetailImpl.setServiceThru(getServiceThru());
		stagingClaimDetailImpl.setResultCodes(getResultCodes());
		stagingClaimDetailImpl.setProcedureCode(getProcedureCode());
		stagingClaimDetailImpl.setChargedAmount(getChargedAmount());
		stagingClaimDetailImpl.setRepricedAmount(getRepricedAmount());
		stagingClaimDetailImpl.setClaimAmount(getClaimAmount());
		stagingClaimDetailImpl.setPaidDate(getPaidDate());
		stagingClaimDetailImpl.setPaidAmount(getPaidAmount());
		stagingClaimDetailImpl.setSavingsAmount(getSavingsAmount());
		stagingClaimDetailImpl.setUnits(getUnits());
		stagingClaimDetailImpl.setCoverage(getCoverage());
		stagingClaimDetailImpl.setLineStatus(getLineStatus());
		stagingClaimDetailImpl.setRevCode(getRevCode());
		stagingClaimDetailImpl.setExternalModifiedDate(
			getExternalModifiedDate());
		stagingClaimDetailImpl.setExternalCreatedDate(getExternalCreatedDate());

		stagingClaimDetailImpl.resetOriginalValues();

		return stagingClaimDetailImpl;
	}

	@Override
	public int compareTo(StagingClaimDetail stagingClaimDetail) {
		int value = 0;

		if (getStagingClaimDetailId() <
				stagingClaimDetail.getStagingClaimDetailId()) {

			value = -1;
		}
		else if (getStagingClaimDetailId() >
					stagingClaimDetail.getStagingClaimDetailId()) {

			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StagingClaimDetail)) {
			return false;
		}

		StagingClaimDetail stagingClaimDetail = (StagingClaimDetail)obj;

		long primaryKey = stagingClaimDetail.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _entityCacheEnabled;
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _finderCacheEnabled;
	}

	@Override
	public void resetOriginalValues() {
		StagingClaimDetailModelImpl stagingClaimDetailModelImpl = this;

		stagingClaimDetailModelImpl._setModifiedDate = false;
	}

	@Override
	public CacheModel<StagingClaimDetail> toCacheModel() {
		StagingClaimDetailCacheModel stagingClaimDetailCacheModel =
			new StagingClaimDetailCacheModel();

		stagingClaimDetailCacheModel.stagingClaimDetailId =
			getStagingClaimDetailId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			stagingClaimDetailCacheModel.createDate = createDate.getTime();
		}
		else {
			stagingClaimDetailCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			stagingClaimDetailCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			stagingClaimDetailCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		stagingClaimDetailCacheModel.lineId = getLineId();

		stagingClaimDetailCacheModel.externalClaimId = getExternalClaimId();

		stagingClaimDetailCacheModel.serviceFrom = getServiceFrom();

		String serviceFrom = stagingClaimDetailCacheModel.serviceFrom;

		if ((serviceFrom != null) && (serviceFrom.length() == 0)) {
			stagingClaimDetailCacheModel.serviceFrom = null;
		}

		stagingClaimDetailCacheModel.serviceThru = getServiceThru();

		String serviceThru = stagingClaimDetailCacheModel.serviceThru;

		if ((serviceThru != null) && (serviceThru.length() == 0)) {
			stagingClaimDetailCacheModel.serviceThru = null;
		}

		stagingClaimDetailCacheModel.resultCodes = getResultCodes();

		String resultCodes = stagingClaimDetailCacheModel.resultCodes;

		if ((resultCodes != null) && (resultCodes.length() == 0)) {
			stagingClaimDetailCacheModel.resultCodes = null;
		}

		stagingClaimDetailCacheModel.procedureCode = getProcedureCode();

		String procedureCode = stagingClaimDetailCacheModel.procedureCode;

		if ((procedureCode != null) && (procedureCode.length() == 0)) {
			stagingClaimDetailCacheModel.procedureCode = null;
		}

		stagingClaimDetailCacheModel.chargedAmount = getChargedAmount();

		stagingClaimDetailCacheModel.repricedAmount = getRepricedAmount();

		stagingClaimDetailCacheModel.claimAmount = getClaimAmount();

		stagingClaimDetailCacheModel.paidDate = getPaidDate();

		String paidDate = stagingClaimDetailCacheModel.paidDate;

		if ((paidDate != null) && (paidDate.length() == 0)) {
			stagingClaimDetailCacheModel.paidDate = null;
		}

		stagingClaimDetailCacheModel.paidAmount = getPaidAmount();

		stagingClaimDetailCacheModel.savingsAmount = getSavingsAmount();

		stagingClaimDetailCacheModel.units = getUnits();

		stagingClaimDetailCacheModel.coverage = getCoverage();

		String coverage = stagingClaimDetailCacheModel.coverage;

		if ((coverage != null) && (coverage.length() == 0)) {
			stagingClaimDetailCacheModel.coverage = null;
		}

		stagingClaimDetailCacheModel.lineStatus = getLineStatus();

		String lineStatus = stagingClaimDetailCacheModel.lineStatus;

		if ((lineStatus != null) && (lineStatus.length() == 0)) {
			stagingClaimDetailCacheModel.lineStatus = null;
		}

		stagingClaimDetailCacheModel.revCode = getRevCode();

		String revCode = stagingClaimDetailCacheModel.revCode;

		if ((revCode != null) && (revCode.length() == 0)) {
			stagingClaimDetailCacheModel.revCode = null;
		}

		stagingClaimDetailCacheModel.externalModifiedDate =
			getExternalModifiedDate();

		String externalModifiedDate =
			stagingClaimDetailCacheModel.externalModifiedDate;

		if ((externalModifiedDate != null) &&
			(externalModifiedDate.length() == 0)) {

			stagingClaimDetailCacheModel.externalModifiedDate = null;
		}

		stagingClaimDetailCacheModel.externalCreatedDate =
			getExternalCreatedDate();

		String externalCreatedDate =
			stagingClaimDetailCacheModel.externalCreatedDate;

		if ((externalCreatedDate != null) &&
			(externalCreatedDate.length() == 0)) {

			stagingClaimDetailCacheModel.externalCreatedDate = null;
		}

		return stagingClaimDetailCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<StagingClaimDetail, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<StagingClaimDetail, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<StagingClaimDetail, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((StagingClaimDetail)this));
			sb.append(", ");
		}

		if (sb.index() > 1) {
			sb.setIndex(sb.index() - 1);
		}

		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		Map<String, Function<StagingClaimDetail, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<StagingClaimDetail, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<StagingClaimDetail, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((StagingClaimDetail)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, StagingClaimDetail>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _stagingClaimDetailId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _lineId;
	private long _externalClaimId;
	private String _serviceFrom;
	private String _serviceThru;
	private String _resultCodes;
	private String _procedureCode;
	private double _chargedAmount;
	private double _repricedAmount;
	private double _claimAmount;
	private String _paidDate;
	private double _paidAmount;
	private double _savingsAmount;
	private int _units;
	private String _coverage;
	private String _lineStatus;
	private String _revCode;
	private String _externalModifiedDate;
	private String _externalCreatedDate;
	private StagingClaimDetail _escapedModel;

}