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

import com.argus.oth.cases.management.model.ReferenceTypeCode;
import com.argus.oth.cases.management.model.ReferenceTypeCodeModel;

import com.liferay.expando.kernel.model.ExpandoBridge;
import com.liferay.expando.kernel.util.ExpandoBridgeFactoryUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.impl.BaseModelImpl;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.GetterUtil;
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
 * The base model implementation for the ReferenceTypeCode service. Represents a row in the &quot;OTH_ReferenceTypeCode&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>ReferenceTypeCodeModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ReferenceTypeCodeImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ReferenceTypeCodeImpl
 * @generated
 */
public class ReferenceTypeCodeModelImpl
	extends BaseModelImpl<ReferenceTypeCode> implements ReferenceTypeCodeModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a reference type code model instance should use the <code>ReferenceTypeCode</code> interface instead.
	 */
	public static final String TABLE_NAME = "OTH_ReferenceTypeCode";

	public static final Object[][] TABLE_COLUMNS = {
		{"referenceTypeCodeId", Types.BIGINT}, {"groupId", Types.BIGINT},
		{"companyId", Types.BIGINT}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP},
		{"externalReferenceTypeCodeId", Types.BIGINT}, {"type_", Types.VARCHAR},
		{"key_", Types.VARCHAR}, {"description", Types.VARCHAR},
		{"rowProcessed", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("referenceTypeCodeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("groupId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("companyId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("externalReferenceTypeCodeId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("type_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("key_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("description", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("rowProcessed", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table OTH_ReferenceTypeCode (referenceTypeCodeId LONG not null primary key,groupId LONG,companyId LONG,createDate DATE null,modifiedDate DATE null,externalReferenceTypeCodeId LONG,type_ VARCHAR(1000) null,key_ VARCHAR(1000) null,description STRING null,rowProcessed VARCHAR(75) null)";

	public static final String TABLE_SQL_DROP =
		"drop table OTH_ReferenceTypeCode";

	public static final String ORDER_BY_JPQL =
		" ORDER BY referenceTypeCode.description ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY OTH_ReferenceTypeCode.description ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static final long KEY_COLUMN_BITMASK = 1L;

	public static final long ROWPROCESSED_COLUMN_BITMASK = 2L;

	public static final long TYPE_COLUMN_BITMASK = 4L;

	public static final long DESCRIPTION_COLUMN_BITMASK = 8L;

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	public ReferenceTypeCodeModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _referenceTypeCodeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setReferenceTypeCodeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _referenceTypeCodeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return ReferenceTypeCode.class;
	}

	@Override
	public String getModelClassName() {
		return ReferenceTypeCode.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<ReferenceTypeCode, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		for (Map.Entry<String, Function<ReferenceTypeCode, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ReferenceTypeCode, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((ReferenceTypeCode)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<ReferenceTypeCode, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<ReferenceTypeCode, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(ReferenceTypeCode)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<ReferenceTypeCode, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<ReferenceTypeCode, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, ReferenceTypeCode>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			ReferenceTypeCode.class.getClassLoader(), ReferenceTypeCode.class,
			ModelWrapper.class);

		try {
			Constructor<ReferenceTypeCode> constructor =
				(Constructor<ReferenceTypeCode>)proxyClass.getConstructor(
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

	private static final Map<String, Function<ReferenceTypeCode, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<ReferenceTypeCode, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<ReferenceTypeCode, Object>>
			attributeGetterFunctions =
				new LinkedHashMap
					<String, Function<ReferenceTypeCode, Object>>();
		Map<String, BiConsumer<ReferenceTypeCode, ?>>
			attributeSetterBiConsumers =
				new LinkedHashMap<String, BiConsumer<ReferenceTypeCode, ?>>();

		attributeGetterFunctions.put(
			"referenceTypeCodeId", ReferenceTypeCode::getReferenceTypeCodeId);
		attributeSetterBiConsumers.put(
			"referenceTypeCodeId",
			(BiConsumer<ReferenceTypeCode, Long>)
				ReferenceTypeCode::setReferenceTypeCodeId);
		attributeGetterFunctions.put("groupId", ReferenceTypeCode::getGroupId);
		attributeSetterBiConsumers.put(
			"groupId",
			(BiConsumer<ReferenceTypeCode, Long>)ReferenceTypeCode::setGroupId);
		attributeGetterFunctions.put(
			"companyId", ReferenceTypeCode::getCompanyId);
		attributeSetterBiConsumers.put(
			"companyId",
			(BiConsumer<ReferenceTypeCode, Long>)
				ReferenceTypeCode::setCompanyId);
		attributeGetterFunctions.put(
			"createDate", ReferenceTypeCode::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<ReferenceTypeCode, Date>)
				ReferenceTypeCode::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", ReferenceTypeCode::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<ReferenceTypeCode, Date>)
				ReferenceTypeCode::setModifiedDate);
		attributeGetterFunctions.put(
			"externalReferenceTypeCodeId",
			ReferenceTypeCode::getExternalReferenceTypeCodeId);
		attributeSetterBiConsumers.put(
			"externalReferenceTypeCodeId",
			(BiConsumer<ReferenceTypeCode, Long>)
				ReferenceTypeCode::setExternalReferenceTypeCodeId);
		attributeGetterFunctions.put("type", ReferenceTypeCode::getType);
		attributeSetterBiConsumers.put(
			"type",
			(BiConsumer<ReferenceTypeCode, String>)ReferenceTypeCode::setType);
		attributeGetterFunctions.put("key", ReferenceTypeCode::getKey);
		attributeSetterBiConsumers.put(
			"key",
			(BiConsumer<ReferenceTypeCode, String>)ReferenceTypeCode::setKey);
		attributeGetterFunctions.put(
			"description", ReferenceTypeCode::getDescription);
		attributeSetterBiConsumers.put(
			"description",
			(BiConsumer<ReferenceTypeCode, String>)
				ReferenceTypeCode::setDescription);
		attributeGetterFunctions.put(
			"rowProcessed", ReferenceTypeCode::getRowProcessed);
		attributeSetterBiConsumers.put(
			"rowProcessed",
			(BiConsumer<ReferenceTypeCode, String>)
				ReferenceTypeCode::setRowProcessed);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getReferenceTypeCodeId() {
		return _referenceTypeCodeId;
	}

	@Override
	public void setReferenceTypeCodeId(long referenceTypeCodeId) {
		_referenceTypeCodeId = referenceTypeCodeId;
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
		_columnBitmask |= TYPE_COLUMN_BITMASK;

		if (_originalType == null) {
			_originalType = _type;
		}

		_type = type;
	}

	public String getOriginalType() {
		return GetterUtil.getString(_originalType);
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
		_columnBitmask |= KEY_COLUMN_BITMASK;

		if (_originalKey == null) {
			_originalKey = _key;
		}

		_key = key;
	}

	public String getOriginalKey() {
		return GetterUtil.getString(_originalKey);
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
		_columnBitmask = -1L;

		_description = description;
	}

	@Override
	public String getRowProcessed() {
		if (_rowProcessed == null) {
			return "";
		}
		else {
			return _rowProcessed;
		}
	}

	@Override
	public void setRowProcessed(String rowProcessed) {
		_columnBitmask |= ROWPROCESSED_COLUMN_BITMASK;

		if (_originalRowProcessed == null) {
			_originalRowProcessed = _rowProcessed;
		}

		_rowProcessed = rowProcessed;
	}

	public String getOriginalRowProcessed() {
		return GetterUtil.getString(_originalRowProcessed);
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			getCompanyId(), ReferenceTypeCode.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public ReferenceTypeCode toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, ReferenceTypeCode>
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
		ReferenceTypeCodeImpl referenceTypeCodeImpl =
			new ReferenceTypeCodeImpl();

		referenceTypeCodeImpl.setReferenceTypeCodeId(getReferenceTypeCodeId());
		referenceTypeCodeImpl.setGroupId(getGroupId());
		referenceTypeCodeImpl.setCompanyId(getCompanyId());
		referenceTypeCodeImpl.setCreateDate(getCreateDate());
		referenceTypeCodeImpl.setModifiedDate(getModifiedDate());
		referenceTypeCodeImpl.setExternalReferenceTypeCodeId(
			getExternalReferenceTypeCodeId());
		referenceTypeCodeImpl.setType(getType());
		referenceTypeCodeImpl.setKey(getKey());
		referenceTypeCodeImpl.setDescription(getDescription());
		referenceTypeCodeImpl.setRowProcessed(getRowProcessed());

		referenceTypeCodeImpl.resetOriginalValues();

		return referenceTypeCodeImpl;
	}

	@Override
	public int compareTo(ReferenceTypeCode referenceTypeCode) {
		int value = 0;

		value = getDescription().compareTo(referenceTypeCode.getDescription());

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

		if (!(obj instanceof ReferenceTypeCode)) {
			return false;
		}

		ReferenceTypeCode referenceTypeCode = (ReferenceTypeCode)obj;

		long primaryKey = referenceTypeCode.getPrimaryKey();

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
		ReferenceTypeCodeModelImpl referenceTypeCodeModelImpl = this;

		referenceTypeCodeModelImpl._setModifiedDate = false;

		referenceTypeCodeModelImpl._originalType =
			referenceTypeCodeModelImpl._type;

		referenceTypeCodeModelImpl._originalKey =
			referenceTypeCodeModelImpl._key;

		referenceTypeCodeModelImpl._originalRowProcessed =
			referenceTypeCodeModelImpl._rowProcessed;

		referenceTypeCodeModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<ReferenceTypeCode> toCacheModel() {
		ReferenceTypeCodeCacheModel referenceTypeCodeCacheModel =
			new ReferenceTypeCodeCacheModel();

		referenceTypeCodeCacheModel.referenceTypeCodeId =
			getReferenceTypeCodeId();

		referenceTypeCodeCacheModel.groupId = getGroupId();

		referenceTypeCodeCacheModel.companyId = getCompanyId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			referenceTypeCodeCacheModel.createDate = createDate.getTime();
		}
		else {
			referenceTypeCodeCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			referenceTypeCodeCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			referenceTypeCodeCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		referenceTypeCodeCacheModel.externalReferenceTypeCodeId =
			getExternalReferenceTypeCodeId();

		referenceTypeCodeCacheModel.type = getType();

		String type = referenceTypeCodeCacheModel.type;

		if ((type != null) && (type.length() == 0)) {
			referenceTypeCodeCacheModel.type = null;
		}

		referenceTypeCodeCacheModel.key = getKey();

		String key = referenceTypeCodeCacheModel.key;

		if ((key != null) && (key.length() == 0)) {
			referenceTypeCodeCacheModel.key = null;
		}

		referenceTypeCodeCacheModel.description = getDescription();

		String description = referenceTypeCodeCacheModel.description;

		if ((description != null) && (description.length() == 0)) {
			referenceTypeCodeCacheModel.description = null;
		}

		referenceTypeCodeCacheModel.rowProcessed = getRowProcessed();

		String rowProcessed = referenceTypeCodeCacheModel.rowProcessed;

		if ((rowProcessed != null) && (rowProcessed.length() == 0)) {
			referenceTypeCodeCacheModel.rowProcessed = null;
		}

		return referenceTypeCodeCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<ReferenceTypeCode, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			4 * attributeGetterFunctions.size() + 2);

		sb.append("{");

		for (Map.Entry<String, Function<ReferenceTypeCode, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ReferenceTypeCode, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((ReferenceTypeCode)this));
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
		Map<String, Function<ReferenceTypeCode, Object>>
			attributeGetterFunctions = getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			5 * attributeGetterFunctions.size() + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<ReferenceTypeCode, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<ReferenceTypeCode, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((ReferenceTypeCode)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, ReferenceTypeCode>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _referenceTypeCodeId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _externalReferenceTypeCodeId;
	private String _type;
	private String _originalType;
	private String _key;
	private String _originalKey;
	private String _description;
	private String _rowProcessed;
	private String _originalRowProcessed;
	private long _columnBitmask;
	private ReferenceTypeCode _escapedModel;

}