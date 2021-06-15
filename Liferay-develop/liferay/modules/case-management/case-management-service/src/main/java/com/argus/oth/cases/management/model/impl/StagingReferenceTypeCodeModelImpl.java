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

import com.argus.oth.cases.management.model.StagingReferenceTypeCode;
import com.argus.oth.cases.management.model.StagingReferenceTypeCodeModel;

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
 * The base model implementation for the StagingReferenceTypeCode service. Represents a row in the &quot;OTH_StagingReferenceTypeCode&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>StagingReferenceTypeCodeModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link StagingReferenceTypeCodeImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingReferenceTypeCodeImpl
 * @generated
 */
public class StagingReferenceTypeCodeModelImpl
	extends BaseModelImpl<StagingReferenceTypeCode>
	implements StagingReferenceTypeCodeModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a staging reference type code model instance should use the <code>StagingReferenceTypeCode</code> interface instead.
	 */
	public static final String TABLE_NAME = "OTH_StagingReferenceTypeCode";

	public static final Object[][] TABLE_COLUMNS = {
		{"stagingReferenceTypeCodeId", Types.BIGINT},
		{"createDate", Types.TIMESTAMP}, {"modifiedDate", Types.TIMESTAMP},
		{"externalReferenceTypeCodeId", Types.BIGINT}, {"type_", Types.VARCHAR},
		{"key_", Types.VARCHAR}, {"description", Types.VARCHAR},
		{"externalModifiedDate", Types.VARCHAR},
		{"externalCreatedDate", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("stagingReferenceTypeCodeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("externalReferenceTypeCodeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("type_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("key_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("externalModifiedDate", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("externalCreatedDate", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table OTH_StagingReferenceTypeCode (stagingReferenceTypeCodeId LONG not null primary key,createDate DATE null,modifiedDate DATE null,externalReferenceTypeCodeId LONG,type_ VARCHAR(1000) null,key_ VARCHAR(1000) null,description STRING null,externalModifiedDate VARCHAR(75) null,externalCreatedDate VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table OTH_StagingReferenceTypeCode";

	public static final String ORDER_BY_JPQL =
		" ORDER BY stagingReferenceTypeCode.stagingReferenceTypeCodeId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY OTH_StagingReferenceTypeCode.stagingReferenceTypeCodeId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	public StagingReferenceTypeCodeModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _stagingReferenceTypeCodeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setStagingReferenceTypeCodeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _stagingReferenceTypeCodeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return StagingReferenceTypeCode.class;
	}

	@Override
	public String getModelClassName() {
		return StagingReferenceTypeCode.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<StagingReferenceTypeCode, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<StagingReferenceTypeCode, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<StagingReferenceTypeCode, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((StagingReferenceTypeCode)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<StagingReferenceTypeCode, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<StagingReferenceTypeCode, Object>
				attributeSetterBiConsumer = attributeSetterBiConsumers.get(
					attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(StagingReferenceTypeCode)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<StagingReferenceTypeCode, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<StagingReferenceTypeCode, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, StagingReferenceTypeCode>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			StagingReferenceTypeCode.class.getClassLoader(),
			StagingReferenceTypeCode.class, ModelWrapper.class);

		try {
			Constructor<StagingReferenceTypeCode> constructor =
				(Constructor<StagingReferenceTypeCode>)
					proxyClass.getConstructor(InvocationHandler.class);

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

	private static final Map<String, Function<StagingReferenceTypeCode, Object>>
		_attributeGetterFunctions;
	private static final Map
		<String, BiConsumer<StagingReferenceTypeCode, Object>>
			_attributeSetterBiConsumers;

	static {
		Map<String, Function<StagingReferenceTypeCode, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<StagingReferenceTypeCode, Object>>();
		Map<String, BiConsumer<StagingReferenceTypeCode, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap
					<String, BiConsumer<StagingReferenceTypeCode, ?>>();

		attributeGetterFunctions.put(
			"stagingReferenceTypeCodeId",
			StagingReferenceTypeCode::getStagingReferenceTypeCodeId);
		attributeSetterBiConsumers.put(
			"stagingReferenceTypeCodeId",
			(BiConsumer<StagingReferenceTypeCode, Long>)
				StagingReferenceTypeCode::setStagingReferenceTypeCodeId);
		attributeGetterFunctions.put(
			"createDate", StagingReferenceTypeCode::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<StagingReferenceTypeCode, Date>)
				StagingReferenceTypeCode::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", StagingReferenceTypeCode::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<StagingReferenceTypeCode, Date>)
				StagingReferenceTypeCode::setModifiedDate);
		attributeGetterFunctions.put(
			"externalReferenceTypeCodeId",
			StagingReferenceTypeCode::getExternalReferenceTypeCodeId);
		attributeSetterBiConsumers.put(
			"externalReferenceTypeCodeId",
			(BiConsumer<StagingReferenceTypeCode, Long>)
				StagingReferenceTypeCode::setExternalReferenceTypeCodeId);
		attributeGetterFunctions.put("type", StagingReferenceTypeCode::getType);
		attributeSetterBiConsumers.put(
			"type",
			(BiConsumer<StagingReferenceTypeCode, String>)
				StagingReferenceTypeCode::setType);
		attributeGetterFunctions.put("key", StagingReferenceTypeCode::getKey);
		attributeSetterBiConsumers.put(
			"key",
			(BiConsumer<StagingReferenceTypeCode, String>)
				StagingReferenceTypeCode::setKey);
		attributeGetterFunctions.put(
			"description", StagingReferenceTypeCode::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<StagingReferenceTypeCode, String>)
				StagingReferenceTypeCode::setDescription);
		attributeGetterFunctions.put(
			"externalModifiedDate",
			StagingReferenceTypeCode::getExternalModifiedDate);
		attributeSetterBiConsumers.put(
			"externalModifiedDate",
			(BiConsumer<StagingReferenceTypeCode, String>)
				StagingReferenceTypeCode::setExternalModifiedDate);
		attributeGetterFunctions.put(
			"externalCreatedDate",
			StagingReferenceTypeCode::getExternalCreatedDate);
		attributeSetterBiConsumers.put(
			"externalCreatedDate",
			(BiConsumer<StagingReferenceTypeCode, String>)
				StagingReferenceTypeCode::setExternalCreatedDate);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getStagingReferenceTypeCodeId() {
		return _stagingReferenceTypeCodeId;
	}

	@Override
	public void setStagingReferenceTypeCodeId(long stagingReferenceTypeCodeId) {
		_stagingReferenceTypeCodeId = stagingReferenceTypeCodeId;
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
	public long getExternalReferenceTypeCodeId() {
		return _externalReferenceTypeCodeId;
	}

	@Override
	public void setExternalReferenceTypeCodeId(
		long externalReferenceTypeCodeId) {

		_externalReferenceTypeCodeId = externalReferenceTypeCodeId;
	}

	@Override
	public String getType() {
		if (_type == null) {
			return "";
		}
		else {
			return _type;
		}
	}

	@Override
	public void setType(String type) {
		_type = type;
	}

	@Override
	public String getKey() {
		if (_key == null) {
			return "";
		}
		else {
			return _key;
		}
	}

	@Override
	public void setKey(String key) {
		_key = key;
	}

	@Override
	public String getDescription() {
		if (_description == null) {
			return "";
		}
		else {
			return _description;
		}
	}

	@Override
	public void setDescription(String description) {
		_description = description;
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
			0, StagingReferenceTypeCode.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public StagingReferenceTypeCode toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, StagingReferenceTypeCode>
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
		StagingReferenceTypeCodeImpl stagingReferenceTypeCodeImpl =
			new StagingReferenceTypeCodeImpl();

		stagingReferenceTypeCodeImpl.setStagingReferenceTypeCodeId(
			getStagingReferenceTypeCodeId());
		stagingReferenceTypeCodeImpl.setCreateDate(getCreateDate());
		stagingReferenceTypeCodeImpl.setModifiedDate(getModifiedDate());
		stagingReferenceTypeCodeImpl.setExternalReferenceTypeCodeId(
			getExternalReferenceTypeCodeId());
		stagingReferenceTypeCodeImpl.setType(getType());
		stagingReferenceTypeCodeImpl.setKey(getKey());
		stagingReferenceTypeCodeImpl.setDescription(getDescription());
		stagingReferenceTypeCodeImpl.setExternalModifiedDate(
			getExternalModifiedDate());
		stagingReferenceTypeCodeImpl.setExternalCreatedDate(
			getExternalCreatedDate());

		stagingReferenceTypeCodeImpl.resetOriginalValues();

		return stagingReferenceTypeCodeImpl;
	}

	@Override
	public int compareTo(StagingReferenceTypeCode stagingReferenceTypeCode) {
		int value = 0;

		if (getStagingReferenceTypeCodeId() <
				stagingReferenceTypeCode.getStagingReferenceTypeCodeId()) {

			value = -1;
		}
		else if (getStagingReferenceTypeCodeId() >
					stagingReferenceTypeCode.getStagingReferenceTypeCodeId()) {

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

		if (!(obj instanceof StagingReferenceTypeCode)) {
			return false;
		}

		StagingReferenceTypeCode stagingReferenceTypeCode =
			(StagingReferenceTypeCode)obj;

		long primaryKey = stagingReferenceTypeCode.getPrimaryKey();

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
		StagingReferenceTypeCodeModelImpl stagingReferenceTypeCodeModelImpl =
			this;

		stagingReferenceTypeCodeModelImpl._setModifiedDate = false;
	}

	@Override
	public CacheModel<StagingReferenceTypeCode> toCacheModel() {
		StagingReferenceTypeCodeCacheModel stagingReferenceTypeCodeCacheModel =
			new StagingReferenceTypeCodeCacheModel();

		stagingReferenceTypeCodeCacheModel.stagingReferenceTypeCodeId =
			getStagingReferenceTypeCodeId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			stagingReferenceTypeCodeCacheModel.createDate =
				createDate.getTime();
		}
		else {
			stagingReferenceTypeCodeCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			stagingReferenceTypeCodeCacheModel.modifiedDate =
				modifiedDate.getTime();
		}
		else {
			stagingReferenceTypeCodeCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		stagingReferenceTypeCodeCacheModel.externalReferenceTypeCodeId =
			getExternalReferenceTypeCodeId();

		stagingReferenceTypeCodeCacheModel.type = getType();

		String type = stagingReferenceTypeCodeCacheModel.type;

		if ((type != null) && (type.length() == 0)) {
			stagingReferenceTypeCodeCacheModel.type = null;
		}

		stagingReferenceTypeCodeCacheModel.key = getKey();

		String key = stagingReferenceTypeCodeCacheModel.key;

		if ((key != null) && (key.length() == 0)) {
			stagingReferenceTypeCodeCacheModel.key = null;
		}

		stagingReferenceTypeCodeCacheModel.description = getDescription();

		String description = stagingReferenceTypeCodeCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			stagingReferenceTypeCodeCacheModel.description = null;
		}

		stagingReferenceTypeCodeCacheModel.externalModifiedDate =
			getExternalModifiedDate();

		String externalModifiedDate =
			stagingReferenceTypeCodeCacheModel.externalModifiedDate;

		if ((externalModifiedDate != null) &&
			(externalModifiedDate.length() == 0)) {

			stagingReferenceTypeCodeCacheModel.externalModifiedDate = null;
		}

		stagingReferenceTypeCodeCacheModel.externalCreatedDate =
			getExternalCreatedDate();

		String externalCreatedDate =
			stagingReferenceTypeCodeCacheModel.externalCreatedDate;

		if ((externalCreatedDate != null) &&
			(externalCreatedDate.length() == 0)) {

			stagingReferenceTypeCodeCacheModel.externalCreatedDate = null;
		}

		return stagingReferenceTypeCodeCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<StagingReferenceTypeCode, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<StagingReferenceTypeCode, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<StagingReferenceTypeCode, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(
				attributeGetterFunction.apply((StagingReferenceTypeCode)this));
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
		Map<String, Function<StagingReferenceTypeCode, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<StagingReferenceTypeCode, Object>>
				entry : attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<StagingReferenceTypeCode, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(
				attributeGetterFunction.apply((StagingReferenceTypeCode)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function
			<InvocationHandler, StagingReferenceTypeCode>
				_escapedModelProxyProviderFunction =
					_getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _stagingReferenceTypeCodeId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _externalReferenceTypeCodeId;
	private String _type;
	private String _key;
	private String _description;
	private String _externalModifiedDate;
	private String _externalCreatedDate;
	private StagingReferenceTypeCode _escapedModel;

}