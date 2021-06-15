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

import com.argus.oth.account.management.model.StagingAMATelephony;
import com.argus.oth.account.management.model.StagingAMATelephonyModel;

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
 * The base model implementation for the StagingAMATelephony service. Represents a row in the &quot;OTH_StagingAMATelephony&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>StagingAMATelephonyModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link StagingAMATelephonyImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingAMATelephonyImpl
 * @generated
 */
public class StagingAMATelephonyModelImpl
	extends BaseModelImpl<StagingAMATelephony>
	implements StagingAMATelephonyModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a staging ama telephony model instance should use the <code>StagingAMATelephony</code> interface instead.
	 */
	public static final String TABLE_NAME = "OTH_StagingAMATelephony";

	public static final Object[][] TABLE_COLUMNS = {
		{"stagingAMATelephonyId", Types.BIGINT},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"clientId", Types.BIGINT}, {"amAnalyticsTelephonyDate", Types.VARCHAR},
		{"avgDownTime", Types.DOUBLE}, {"avgSpeedOfAnswer", Types.DOUBLE},
		{"abandonmentRate", Types.DOUBLE}, {"downTimeGoal", Types.DOUBLE},
		{"speedAnswerGoal", Types.DOUBLE},
		{"abandonmentRateGoal", Types.DOUBLE},
		{"overallAvgDownTime", Types.DOUBLE},
		{"overallAvgSpeedOfAnswer", Types.DOUBLE},
		{"overallAvgAbandonmentRate", Types.DOUBLE}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("stagingAMATelephonyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("clientId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("amAnalyticsTelephonyDate", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("avgDownTime", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("avgSpeedOfAnswer", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("abandonmentRate", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("downTimeGoal", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("speedAnswerGoal", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("abandonmentRateGoal", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("overallAvgDownTime", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("overallAvgSpeedOfAnswer", Types.DOUBLE);
		TABLE_COLUMNS_MAP.put("overallAvgAbandonmentRate", Types.DOUBLE);
	}

	public static final String TABLE_SQL_CREATE =
		"create table OTH_StagingAMATelephony (stagingAMATelephonyId LONG not null primary key,createDate DATE null,modifiedDate DATE null,clientId LONG,amAnalyticsTelephonyDate VARCHAR(75) null,avgDownTime DOUBLE,avgSpeedOfAnswer DOUBLE,abandonmentRate DOUBLE,downTimeGoal DOUBLE,speedAnswerGoal DOUBLE,abandonmentRateGoal DOUBLE,overallAvgDownTime DOUBLE,overallAvgSpeedOfAnswer DOUBLE,overallAvgAbandonmentRate DOUBLE)";

	public static final String TABLE_SQL_DROP =
		"drop table OTH_StagingAMATelephony";

	public static final String ORDER_BY_JPQL =
		" ORDER BY stagingAMATelephony.amAnalyticsTelephonyDate ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY OTH_StagingAMATelephony.amAnalyticsTelephonyDate ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	public StagingAMATelephonyModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _stagingAMATelephonyId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setStagingAMATelephonyId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _stagingAMATelephonyId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return StagingAMATelephony.class;
	}

	@Override
	public String getModelClassName() {
		return StagingAMATelephony.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<StagingAMATelephony, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<StagingAMATelephony, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<StagingAMATelephony, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((StagingAMATelephony)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<StagingAMATelephony, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<StagingAMATelephony, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(StagingAMATelephony)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<StagingAMATelephony, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<StagingAMATelephony, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, StagingAMATelephony>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			StagingAMATelephony.class.getClassLoader(),
			StagingAMATelephony.class, ModelWrapper.class);

		try {
			Constructor<StagingAMATelephony> constructor =
				(Constructor<StagingAMATelephony>)proxyClass.getConstructor(
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

	private static final Map<String, Function<StagingAMATelephony, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<StagingAMATelephony, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<StagingAMATelephony, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<StagingAMATelephony, Object>>();
		Map<String, BiConsumer<StagingAMATelephony, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<StagingAMATelephony, ?>>();

		attributeGetterFunctions.put(
			"stagingAMATelephonyId",
			StagingAMATelephony::getStagingAMATelephonyId);
		attributeSetterBiConsumers.put(
			"stagingAMATelephonyId",
			(BiConsumer<StagingAMATelephony, Long>)
				StagingAMATelephony::setStagingAMATelephonyId);
		attributeGetterFunctions.put(
			"createDate", StagingAMATelephony::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<StagingAMATelephony, Date>)
				StagingAMATelephony::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", StagingAMATelephony::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<StagingAMATelephony, Date>)
				StagingAMATelephony::setModifiedDate);
		attributeGetterFunctions.put(
			"clientId", StagingAMATelephony::getClientId);
		attributeSetterBiConsumers.put(
			"clientId",
			(BiConsumer<StagingAMATelephony, Long>)
				StagingAMATelephony::setClientId);
		attributeGetterFunctions.put(
			"amAnalyticsTelephonyDate",
			StagingAMATelephony::getAmAnalyticsTelephonyDate);
		attributeSetterBiConsumers.put(
			"amAnalyticsTelephonyDate",
			(BiConsumer<StagingAMATelephony, String>)
				StagingAMATelephony::setAmAnalyticsTelephonyDate);
		attributeGetterFunctions.put(
			"avgDownTime", StagingAMATelephony::getAvgDownTime);
		attributeSetterBiConsumers.put(
			"avgDownTime",
			(BiConsumer<StagingAMATelephony, Double>)
				StagingAMATelephony::setAvgDownTime);
		attributeGetterFunctions.put(
			"avgSpeedOfAnswer", StagingAMATelephony::getAvgSpeedOfAnswer);
		attributeSetterBiConsumers.put(
			"avgSpeedOfAnswer",
			(BiConsumer<StagingAMATelephony, Double>)
				StagingAMATelephony::setAvgSpeedOfAnswer);
		attributeGetterFunctions.put(
			"abandonmentRate", StagingAMATelephony::getAbandonmentRate);
		attributeSetterBiConsumers.put(
			"abandonmentRate",
			(BiConsumer<StagingAMATelephony, Double>)
				StagingAMATelephony::setAbandonmentRate);
		attributeGetterFunctions.put(
			"downTimeGoal", StagingAMATelephony::getDownTimeGoal);
		attributeSetterBiConsumers.put(
			"downTimeGoal",
			(BiConsumer<StagingAMATelephony, Double>)
				StagingAMATelephony::setDownTimeGoal);
		attributeGetterFunctions.put(
			"speedAnswerGoal", StagingAMATelephony::getSpeedAnswerGoal);
		attributeSetterBiConsumers.put(
			"speedAnswerGoal",
			(BiConsumer<StagingAMATelephony, Double>)
				StagingAMATelephony::setSpeedAnswerGoal);
		attributeGetterFunctions.put(
			"abandonmentRateGoal", StagingAMATelephony::getAbandonmentRateGoal);
		attributeSetterBiConsumers.put(
			"abandonmentRateGoal",
			(BiConsumer<StagingAMATelephony, Double>)
				StagingAMATelephony::setAbandonmentRateGoal);
		attributeGetterFunctions.put(
			"overallAvgDownTime", StagingAMATelephony::getOverallAvgDownTime);
		attributeSetterBiConsumers.put(
			"overallAvgDownTime",
			(BiConsumer<StagingAMATelephony, Double>)
				StagingAMATelephony::setOverallAvgDownTime);
		attributeGetterFunctions.put(
			"overallAvgSpeedOfAnswer",
			StagingAMATelephony::getOverallAvgSpeedOfAnswer);
		attributeSetterBiConsumers.put(
			"overallAvgSpeedOfAnswer",
			(BiConsumer<StagingAMATelephony, Double>)
				StagingAMATelephony::setOverallAvgSpeedOfAnswer);
		attributeGetterFunctions.put(
			"overallAvgAbandonmentRate",
			StagingAMATelephony::getOverallAvgAbandonmentRate);
		attributeSetterBiConsumers.put(
			"overallAvgAbandonmentRate",
			(BiConsumer<StagingAMATelephony, Double>)
				StagingAMATelephony::setOverallAvgAbandonmentRate);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getStagingAMATelephonyId() {
		return _stagingAMATelephonyId;
	}

	@Override
	public void setStagingAMATelephonyId(long stagingAMATelephonyId) {
		_stagingAMATelephonyId = stagingAMATelephonyId;
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
		_clientId = clientId;
	}

	@Override
	public String getAmAnalyticsTelephonyDate() {
		if (_amAnalyticsTelephonyDate == null) {
			return "";
		}
		else {
			return _amAnalyticsTelephonyDate;
		}
	}

	@Override
	public void setAmAnalyticsTelephonyDate(String amAnalyticsTelephonyDate) {
		_amAnalyticsTelephonyDate = amAnalyticsTelephonyDate;
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
	public double getDownTimeGoal() {
		return _downTimeGoal;
	}

	@Override
	public void setDownTimeGoal(double downTimeGoal) {
		_downTimeGoal = downTimeGoal;
	}

	@Override
	public double getSpeedAnswerGoal() {
		return _speedAnswerGoal;
	}

	@Override
	public void setSpeedAnswerGoal(double speedAnswerGoal) {
		_speedAnswerGoal = speedAnswerGoal;
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
	public double getOverallAvgDownTime() {
		return _overallAvgDownTime;
	}

	@Override
	public void setOverallAvgDownTime(double overallAvgDownTime) {
		_overallAvgDownTime = overallAvgDownTime;
	}

	@Override
	public double getOverallAvgSpeedOfAnswer() {
		return _overallAvgSpeedOfAnswer;
	}

	@Override
	public void setOverallAvgSpeedOfAnswer(double overallAvgSpeedOfAnswer) {
		_overallAvgSpeedOfAnswer = overallAvgSpeedOfAnswer;
	}

	@Override
	public double getOverallAvgAbandonmentRate() {
		return _overallAvgAbandonmentRate;
	}

	@Override
	public void setOverallAvgAbandonmentRate(double overallAvgAbandonmentRate) {
		_overallAvgAbandonmentRate = overallAvgAbandonmentRate;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, StagingAMATelephony.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public StagingAMATelephony toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, StagingAMATelephony>
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
		StagingAMATelephonyImpl stagingAMATelephonyImpl =
			new StagingAMATelephonyImpl();

		stagingAMATelephonyImpl.setStagingAMATelephonyId(
			getStagingAMATelephonyId());
		stagingAMATelephonyImpl.setCreateDate(getCreateDate());
		stagingAMATelephonyImpl.setModifiedDate(getModifiedDate());
		stagingAMATelephonyImpl.setClientId(getClientId());
		stagingAMATelephonyImpl.setAmAnalyticsTelephonyDate(
			getAmAnalyticsTelephonyDate());
		stagingAMATelephonyImpl.setAvgDownTime(getAvgDownTime());
		stagingAMATelephonyImpl.setAvgSpeedOfAnswer(getAvgSpeedOfAnswer());
		stagingAMATelephonyImpl.setAbandonmentRate(getAbandonmentRate());
		stagingAMATelephonyImpl.setDownTimeGoal(getDownTimeGoal());
		stagingAMATelephonyImpl.setSpeedAnswerGoal(getSpeedAnswerGoal());
		stagingAMATelephonyImpl.setAbandonmentRateGoal(
			getAbandonmentRateGoal());
		stagingAMATelephonyImpl.setOverallAvgDownTime(getOverallAvgDownTime());
		stagingAMATelephonyImpl.setOverallAvgSpeedOfAnswer(
			getOverallAvgSpeedOfAnswer());
		stagingAMATelephonyImpl.setOverallAvgAbandonmentRate(
			getOverallAvgAbandonmentRate());

		stagingAMATelephonyImpl.resetOriginalValues();

		return stagingAMATelephonyImpl;
	}

	@Override
	public int compareTo(StagingAMATelephony stagingAMATelephony) {
		int value = 0;

		value = getAmAnalyticsTelephonyDate().compareTo(
			stagingAMATelephony.getAmAnalyticsTelephonyDate());

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

		if (!(obj instanceof StagingAMATelephony)) {
			return false;
		}

		StagingAMATelephony stagingAMATelephony = (StagingAMATelephony)obj;

		long primaryKey = stagingAMATelephony.getPrimaryKey();

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
		StagingAMATelephonyModelImpl stagingAMATelephonyModelImpl = this;

		stagingAMATelephonyModelImpl._setModifiedDate = false;
	}

	@Override
	public CacheModel<StagingAMATelephony> toCacheModel() {
		StagingAMATelephonyCacheModel stagingAMATelephonyCacheModel =
			new StagingAMATelephonyCacheModel();

		stagingAMATelephonyCacheModel.stagingAMATelephonyId =
			getStagingAMATelephonyId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			stagingAMATelephonyCacheModel.createDate = createDate.getTime();
		}
		else {
			stagingAMATelephonyCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			stagingAMATelephonyCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			stagingAMATelephonyCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		stagingAMATelephonyCacheModel.clientId = getClientId();

		stagingAMATelephonyCacheModel.amAnalyticsTelephonyDate =
			getAmAnalyticsTelephonyDate();

		String amAnalyticsTelephonyDate =
			stagingAMATelephonyCacheModel.amAnalyticsTelephonyDate;

		if ((amAnalyticsTelephonyDate != null) &&
			(amAnalyticsTelephonyDate.length() == 0)) {

			stagingAMATelephonyCacheModel.amAnalyticsTelephonyDate = null;
		}

		stagingAMATelephonyCacheModel.avgDownTime = getAvgDownTime();

		stagingAMATelephonyCacheModel.avgSpeedOfAnswer = getAvgSpeedOfAnswer();

		stagingAMATelephonyCacheModel.abandonmentRate = getAbandonmentRate();

		stagingAMATelephonyCacheModel.downTimeGoal = getDownTimeGoal();

		stagingAMATelephonyCacheModel.speedAnswerGoal = getSpeedAnswerGoal();

		stagingAMATelephonyCacheModel.abandonmentRateGoal =
			getAbandonmentRateGoal();

		stagingAMATelephonyCacheModel.overallAvgDownTime =
			getOverallAvgDownTime();

		stagingAMATelephonyCacheModel.overallAvgSpeedOfAnswer =
			getOverallAvgSpeedOfAnswer();

		stagingAMATelephonyCacheModel.overallAvgAbandonmentRate =
			getOverallAvgAbandonmentRate();

		return stagingAMATelephonyCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<StagingAMATelephony, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<StagingAMATelephony, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<StagingAMATelephony, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((StagingAMATelephony)this));
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
		Map<String, Function<StagingAMATelephony, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<StagingAMATelephony, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<StagingAMATelephony, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((StagingAMATelephony)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, StagingAMATelephony>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _stagingAMATelephonyId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _clientId;
	private String _amAnalyticsTelephonyDate;
	private double _avgDownTime;
	private double _avgSpeedOfAnswer;
	private double _abandonmentRate;
	private double _downTimeGoal;
	private double _speedAnswerGoal;
	private double _abandonmentRateGoal;
	private double _overallAvgDownTime;
	private double _overallAvgSpeedOfAnswer;
	private double _overallAvgAbandonmentRate;
	private StagingAMATelephony _escapedModel;

}