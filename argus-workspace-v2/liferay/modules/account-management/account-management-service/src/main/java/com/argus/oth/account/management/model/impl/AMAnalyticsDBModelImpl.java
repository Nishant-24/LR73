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

package com.argus.oth.account.management.model.impl;

import com.argus.oth.account.management.model.AMAnalyticsDB;
import com.argus.oth.account.management.model.AMAnalyticsDBModel;

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
 * The base model implementation for the AMAnalyticsDB service. Represents a row in the &quot;OTH_AMAnalyticsDB&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>AMAnalyticsDBModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link AMAnalyticsDBImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AMAnalyticsDBImpl
 * @generated
 */
public class AMAnalyticsDBModelImpl
	extends BaseModelImpl<AMAnalyticsDB> implements AMAnalyticsDBModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a am analytics db model instance should use the <code>AMAnalyticsDB</code> interface instead.
	 */
	public static final String TABLE_NAME = "OTH_AMAnalyticsDB";

	public static final Object[][] TABLE_COLUMNS = {
		{"amAnalyticsDbId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"clientId", Types.BIGINT},
		{"savingsPercent", Types.DOUBLE}, {"chargedAmount", Types.DOUBLE},
		{"repricedAmount", Types.DOUBLE}, {"avgDownTime", Types.DOUBLE},
		{"avgSpeedOfAnswer", Types.DOUBLE}, {"abandonmentRate", Types.DOUBLE},
		{"claimsTurnaround", Types.BIGINT}, {"downTimeGoal", Types.DOUBLE},
		{"speedOfAnswerGoal", Types.DOUBLE},
		{"abandonmentRateGoal", Types.DOUBLE},
		{"claimsTurnaroundGoal", Types.DOUBLE}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("amAnalyticsDbId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("clientId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("savingsPercent", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("chargedAmount", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("repricedAmount", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("avgDownTime", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("avgSpeedOfAnswer", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("abandonmentRate", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("claimsTurnaround", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("downTimeGoal", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("speedOfAnswerGoal", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("abandonmentRateGoal", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("claimsTurnaroundGoal", Types.DOUBLE);
	}

	public static final String TABLE_SQL_CREATE =
		"create table OTH_AMAnalyticsDB (amAnalyticsDbId LONG not null primary key,groupId LONG,companyId LONG,createDate DATE null,modifiedDate DATE null,clientId LONG,savingsPercent DOUBLE,chargedAmount DOUBLE,repricedAmount DOUBLE,avgDownTime DOUBLE,avgSpeedOfAnswer DOUBLE,abandonmentRate DOUBLE,claimsTurnaround LONG,downTimeGoal DOUBLE,speedOfAnswerGoal DOUBLE,abandonmentRateGoal DOUBLE,claimsTurnaroundGoal DOUBLE)";

	public static final String TABLE_SQL_DROP = "drop table OTH_AMAnalyticsDB";

	public static final String ORDER_BY_JPQL =
		" ORDER BY amAnalyticsDB.amAnalyticsDbId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY OTH_AMAnalyticsDB.amAnalyticsDbId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long CLIENTID_COLUMN_BITMASK = 1L;

	public static final long AMANALYTICSDBID_COLUMN_BITMASK = 2L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	public AMAnalyticsDBModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _amAnalyticsDbId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setAmAnalyticsDbId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _amAnalyticsDbId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return AMAnalyticsDB.class;
	}

	@Override
	public String getModelClassName() {
		return AMAnalyticsDB.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<AMAnalyticsDB, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<AMAnalyticsDB, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AMAnalyticsDB, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((AMAnalyticsDB)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<AMAnalyticsDB, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<AMAnalyticsDB, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(AMAnalyticsDB)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<AMAnalyticsDB, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<AMAnalyticsDB, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, AMAnalyticsDB>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			AMAnalyticsDB.class.getClassLoader(), AMAnalyticsDB.class,
			ModelWrapper.class);

		try {
			Constructor<AMAnalyticsDB> constructor =
				(Constructor<AMAnalyticsDB>)proxyClass.getConstructor(
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

	private static final Map<String, Function<AMAnalyticsDB, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<AMAnalyticsDB, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<AMAnalyticsDB, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<AMAnalyticsDB, Object>>();
		Map<String, BiConsumer<AMAnalyticsDB, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<AMAnalyticsDB, ?>>();

		attributeGetterFunctions.put(
			"amAnalyticsDbId", AMAnalyticsDB::getAmAnalyticsDbId);
		attributeSetterBiConsumers.put(
			"amAnalyticsDbId",
			(BiConsumer<AMAnalyticsDB, Long>)AMAnalyticsDB::setAmAnalyticsDbId);
		attributeGetterFunctions.put("groupId", AMAnalyticsDB::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<AMAnalyticsDB, Long>)AMAnalyticsDB::setGroupId);
		attributeGetterFunctions.put("companyId", AMAnalyticsDB::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<AMAnalyticsDB, Long>)AMAnalyticsDB::setCompanyId);
		attributeGetterFunctions.put(
			"createDate", AMAnalyticsDB::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<AMAnalyticsDB, Date>)AMAnalyticsDB::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", AMAnalyticsDB::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<AMAnalyticsDB, Date>)AMAnalyticsDB::setModifiedDate);
		attributeGetterFunctions.put("clientId", AMAnalyticsDB::getClientId);
		attributeSetterBiConsumers.put(
			"clientId",
			(BiConsumer<AMAnalyticsDB, Long>)AMAnalyticsDB::setClientId);
		attributeGetterFunctions.put(
			"savingsPercent", AMAnalyticsDB::getSavingsPercent);
		attributeSetterBiConsumers.put(
			"savingsPercent",
			(BiConsumer<AMAnalyticsDB, Double>)
				AMAnalyticsDB::setSavingsPercent);
		attributeGetterFunctions.put(
			"chargedAmount", AMAnalyticsDB::getChargedAmount);
		attributeSetterBiConsumers.put(
			"chargedAmount",
			(BiConsumer<AMAnalyticsDB, Double>)AMAnalyticsDB::setChargedAmount);
		attributeGetterFunctions.put(
			"repricedAmount", AMAnalyticsDB::getRepricedAmount);
		attributeSetterBiConsumers.put(
			"repricedAmount",
			(BiConsumer<AMAnalyticsDB, Double>)
				AMAnalyticsDB::setRepricedAmount);
		attributeGetterFunctions.put(
			"avgDownTime", AMAnalyticsDB::getAvgDownTime);
		attributeSetterBiConsumers.put(
			"avgDownTime",
			(BiConsumer<AMAnalyticsDB, Double>)AMAnalyticsDB::setAvgDownTime);
		attributeGetterFunctions.put(
			"avgSpeedOfAnswer", AMAnalyticsDB::getAvgSpeedOfAnswer);
		attributeSetterBiConsumers.put(
			"avgSpeedOfAnswer",
			(BiConsumer<AMAnalyticsDB, Double>)
				AMAnalyticsDB::setAvgSpeedOfAnswer);
		attributeGetterFunctions.put(
			"abandonmentRate", AMAnalyticsDB::getAbandonmentRate);
		attributeSetterBiConsumers.put(
			"abandonmentRate",
			(BiConsumer<AMAnalyticsDB, Double>)
				AMAnalyticsDB::setAbandonmentRate);
		attributeGetterFunctions.put(
			"claimsTurnaround", AMAnalyticsDB::getClaimsTurnaround);
		attributeSetterBiConsumers.put(
			"claimsTurnaround",
			(BiConsumer<AMAnalyticsDB, Long>)
				AMAnalyticsDB::setClaimsTurnaround);
		attributeGetterFunctions.put(
			"downTimeGoal", AMAnalyticsDB::getDownTimeGoal);
		attributeSetterBiConsumers.put(
			"downTimeGoal",
			(BiConsumer<AMAnalyticsDB, Double>)AMAnalyticsDB::setDownTimeGoal);
		attributeGetterFunctions.put(
			"speedOfAnswerGoal", AMAnalyticsDB::getSpeedOfAnswerGoal);
		attributeSetterBiConsumers.put(
			"speedOfAnswerGoal",
			(BiConsumer<AMAnalyticsDB, Double>)
				AMAnalyticsDB::setSpeedOfAnswerGoal);
		attributeGetterFunctions.put(
			"abandonmentRateGoal", AMAnalyticsDB::getAbandonmentRateGoal);
		attributeSetterBiConsumers.put(
			"abandonmentRateGoal",
			(BiConsumer<AMAnalyticsDB, Double>)
				AMAnalyticsDB::setAbandonmentRateGoal);
		attributeGetterFunctions.put(
			"claimsTurnaroundGoal", AMAnalyticsDB::getClaimsTurnaroundGoal);
		attributeSetterBiConsumers.put(
			"claimsTurnaroundGoal",
			(BiConsumer<AMAnalyticsDB, Double>)
				AMAnalyticsDB::setClaimsTurnaroundGoal);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getAmAnalyticsDbId() {
		return _amAnalyticsDbId;
	}

	@Override
	public void setAmAnalyticsDbId(long amAnalyticsDbId) {
		_columnBitmask = -1L;

		_amAnalyticsDbId = amAnalyticsDbId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
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
	public long getClientId() {
		return _clientId;
	}

	@Override
	public void setClientId(long clientId) {
		_columnBitmask |= CLIENTID_COLUMN_BITMASK;

		if (!_setOriginalClientId) {
			_setOriginalClientId = true;

			_originalClientId = _clientId;
		}

		_clientId = clientId;
	}

	public long getOriginalClientId() {
		return _originalClientId;
	}

	@Override
	public double getSavingsPercent() {
		return _savingsPercent;
	}

	@Override
	public void setSavingsPercent(double savingsPercent) {
		_savingsPercent = savingsPercent;
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
	public double getAvgDownTime() {
		return _avgDownTime;
	}

	@Override
	public void setAvgDownTime(double avgDownTime) {
		_avgDownTime = avgDownTime;
	}

	@Override
	public double getAvgSpeedOfAnswer() {
		return _avgSpeedOfAnswer;
	}

	@Override
	public void setAvgSpeedOfAnswer(double avgSpeedOfAnswer) {
		_avgSpeedOfAnswer = avgSpeedOfAnswer;
	}

	@Override
	public double getAbandonmentRate() {
		return _abandonmentRate;
	}

	@Override
	public void setAbandonmentRate(double abandonmentRate) {
		_abandonmentRate = abandonmentRate;
	}

	@Override
	public long getClaimsTurnaround() {
		return _claimsTurnaround;
	}

	@Override
	public void setClaimsTurnaround(long claimsTurnaround) {
		_claimsTurnaround = claimsTurnaround;
	}

	@Override
	public double getDownTimeGoal() {
		return _downTimeGoal;
	}

	@Override
	public void setDownTimeGoal(double downTimeGoal) {
		_downTimeGoal = downTimeGoal;
	}

	@Override
	public double getSpeedOfAnswerGoal() {
		return _speedOfAnswerGoal;
	}

	@Override
	public void setSpeedOfAnswerGoal(double speedOfAnswerGoal) {
		_speedOfAnswerGoal = speedOfAnswerGoal;
	}

	@Override
	public double getAbandonmentRateGoal() {
		return _abandonmentRateGoal;
	}

	@Override
	public void setAbandonmentRateGoal(double abandonmentRateGoal) {
		_abandonmentRateGoal = abandonmentRateGoal;
	}

	@Override
	public double getClaimsTurnaroundGoal() {
		return _claimsTurnaroundGoal;
	}

	@Override
	public void setClaimsTurnaroundGoal(double claimsTurnaroundGoal) {
		_claimsTurnaroundGoal = claimsTurnaroundGoal;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), AMAnalyticsDB.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public AMAnalyticsDB toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, AMAnalyticsDB>
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
		AMAnalyticsDBImpl amAnalyticsDBImpl = new AMAnalyticsDBImpl();

		amAnalyticsDBImpl.setAmAnalyticsDbId(getAmAnalyticsDbId());
		amAnalyticsDBImpl.setGroupId(getGroupId());
		amAnalyticsDBImpl.setCompanyId(getCompanyId());
		amAnalyticsDBImpl.setCreateDate(getCreateDate());
		amAnalyticsDBImpl.setModifiedDate(getModifiedDate());
		amAnalyticsDBImpl.setClientId(getClientId());
		amAnalyticsDBImpl.setSavingsPercent(getSavingsPercent());
		amAnalyticsDBImpl.setChargedAmount(getChargedAmount());
		amAnalyticsDBImpl.setRepricedAmount(getRepricedAmount());
		amAnalyticsDBImpl.setAvgDownTime(getAvgDownTime());
		amAnalyticsDBImpl.setAvgSpeedOfAnswer(getAvgSpeedOfAnswer());
		amAnalyticsDBImpl.setAbandonmentRate(getAbandonmentRate());
		amAnalyticsDBImpl.setClaimsTurnaround(getClaimsTurnaround());
		amAnalyticsDBImpl.setDownTimeGoal(getDownTimeGoal());
		amAnalyticsDBImpl.setSpeedOfAnswerGoal(getSpeedOfAnswerGoal());
		amAnalyticsDBImpl.setAbandonmentRateGoal(getAbandonmentRateGoal());
		amAnalyticsDBImpl.setClaimsTurnaroundGoal(getClaimsTurnaroundGoal());

		amAnalyticsDBImpl.resetOriginalValues();

		return amAnalyticsDBImpl;
	}

	@Override
	public int compareTo(AMAnalyticsDB amAnalyticsDB) {
		int value = 0;

		if (getAmAnalyticsDbId() < amAnalyticsDB.getAmAnalyticsDbId()) {
			value = -1;
		}
		else if (getAmAnalyticsDbId() > amAnalyticsDB.getAmAnalyticsDbId()) {
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

		if (!(obj instanceof AMAnalyticsDB)) {
			return false;
		}

		AMAnalyticsDB amAnalyticsDB = (AMAnalyticsDB)obj;

		long primaryKey = amAnalyticsDB.getPrimaryKey();

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
		AMAnalyticsDBModelImpl amAnalyticsDBModelImpl = this;

		amAnalyticsDBModelImpl._setModifiedDate = false;

		amAnalyticsDBModelImpl._originalClientId =
			amAnalyticsDBModelImpl._clientId;

		amAnalyticsDBModelImpl._setOriginalClientId = false;

		amAnalyticsDBModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<AMAnalyticsDB> toCacheModel() {
		AMAnalyticsDBCacheModel amAnalyticsDBCacheModel =
			new AMAnalyticsDBCacheModel();

		amAnalyticsDBCacheModel.amAnalyticsDbId = getAmAnalyticsDbId();

		amAnalyticsDBCacheModel.groupId = getGroupId();

		amAnalyticsDBCacheModel.companyId = getCompanyId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			amAnalyticsDBCacheModel.createDate = createDate.getTime();
		}
		else {
			amAnalyticsDBCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			amAnalyticsDBCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			amAnalyticsDBCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		amAnalyticsDBCacheModel.clientId = getClientId();

		amAnalyticsDBCacheModel.savingsPercent = getSavingsPercent();

		amAnalyticsDBCacheModel.chargedAmount = getChargedAmount();

		amAnalyticsDBCacheModel.repricedAmount = getRepricedAmount();

		amAnalyticsDBCacheModel.avgDownTime = getAvgDownTime();

		amAnalyticsDBCacheModel.avgSpeedOfAnswer = getAvgSpeedOfAnswer();

		amAnalyticsDBCacheModel.abandonmentRate = getAbandonmentRate();

		amAnalyticsDBCacheModel.claimsTurnaround = getClaimsTurnaround();

		amAnalyticsDBCacheModel.downTimeGoal = getDownTimeGoal();

		amAnalyticsDBCacheModel.speedOfAnswerGoal = getSpeedOfAnswerGoal();

		amAnalyticsDBCacheModel.abandonmentRateGoal = getAbandonmentRateGoal();

		amAnalyticsDBCacheModel.claimsTurnaroundGoal =
			getClaimsTurnaroundGoal();

		return amAnalyticsDBCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<AMAnalyticsDB, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<AMAnalyticsDB, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AMAnalyticsDB, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((AMAnalyticsDB)this));
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
		Map<String, Function<AMAnalyticsDB, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<AMAnalyticsDB, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<AMAnalyticsDB, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((AMAnalyticsDB)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, AMAnalyticsDB>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _amAnalyticsDbId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _clientId;
	private long _originalClientId;
	private boolean _setOriginalClientId;
	private double _savingsPercent;
	private double _chargedAmount;
	private double _repricedAmount;
	private double _avgDownTime;
	private double _avgSpeedOfAnswer;
	private double _abandonmentRate;
	private long _claimsTurnaround;
	private double _downTimeGoal;
	private double _speedOfAnswerGoal;
	private double _abandonmentRateGoal;
	private double _claimsTurnaroundGoal;
	private long _columnBitmask;
	private AMAnalyticsDB _escapedModel;

}