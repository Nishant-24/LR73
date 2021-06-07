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

import com.argus.oth.cases.management.model.StagingNote;
import com.argus.oth.cases.management.model.StagingNoteModel;

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
 * The base model implementation for the StagingNote service. Represents a row in the &quot;OTH_StagingNote&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface <code>StagingNoteModel</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link StagingNoteImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see StagingNoteImpl
 * @generated
 */
public class StagingNoteModelImpl
	extends BaseModelImpl<StagingNote> implements StagingNoteModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a staging note model instance should use the <code>StagingNote</code> interface instead.
	 */
	public static final String TABLE_NAME = "OTH_StagingNote";

	public static final Object[][] TABLE_COLUMNS = {
		{"noteId", Types.BIGINT}, {"createDate", Types.TIMESTAMP},
		{"modifiedDate", Types.TIMESTAMP}, {"externalCaseId", Types.BIGINT},
		{"caseNoteID", Types.BIGINT}, {"type_", Types.VARCHAR},
		{"noteType", Types.VARCHAR}, {"noteText", Types.VARCHAR},
		{"noteCreateDate", Types.VARCHAR}, {"direction", Types.VARCHAR},
		{"code_", Types.VARCHAR}, {"caller", Types.VARCHAR},
		{"callee", Types.VARCHAR}, {"externalCreateDate", Types.VARCHAR},
		{"externalModifiedDate", Types.VARCHAR}, {"noteAuthor", Types.VARCHAR}
	};

	public static final Map<String, Integer> TABLE_COLUMNS_MAP =
		new HashMap<String, Integer>();

	static {
		TABLE_COLUMNS_MAP.put("noteId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("createDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("modifiedDate", Types.TIMESTAMP);
		TABLE_COLUMNS_MAP.put("externalCaseId", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("caseNoteID", Types.BIGINT);
		TABLE_COLUMNS_MAP.put("type_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("noteType", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("noteText", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("noteCreateDate", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("direction", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("code_", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("caller", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("callee", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("externalCreateDate", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("externalModifiedDate", Types.VARCHAR);
		TABLE_COLUMNS_MAP.put("noteAuthor", Types.VARCHAR);
	}

	public static final String TABLE_SQL_CREATE =
		"create table OTH_StagingNote (noteId LONG not null primary key,createDate DATE null,modifiedDate DATE null,externalCaseId LONG,caseNoteID LONG,type_ VARCHAR(75) null,noteType VARCHAR(75) null,noteText STRING null,noteCreateDate VARCHAR(75) null,direction VARCHAR(1000) null,code_ VARCHAR(75) null,caller VARCHAR(1000) null,callee VARCHAR(1000) null,externalCreateDate VARCHAR(75) null,externalModifiedDate VARCHAR(75) null,noteAuthor VARCHAR(1000) null)";

	public static final String TABLE_SQL_DROP = "drop table OTH_StagingNote";

	public static final String ORDER_BY_JPQL =
		" ORDER BY stagingNote.noteId ASC";

	public static final String ORDER_BY_SQL =
		" ORDER BY OTH_StagingNote.noteId ASC";

	public static final String DATA_SOURCE = "liferayDataSource";

	public static final String SESSION_FACTORY = "liferaySessionFactory";

	public static final String TX_MANAGER = "liferayTransactionManager";

	public static void setEntityCacheEnabled(boolean entityCacheEnabled) {
		_entityCacheEnabled = entityCacheEnabled;
	}

	public static void setFinderCacheEnabled(boolean finderCacheEnabled) {
		_finderCacheEnabled = finderCacheEnabled;
	}

	public StagingNoteModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _noteId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setNoteId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _noteId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return StagingNote.class;
	}

	@Override
	public String getModelClassName() {
		return StagingNote.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		Map<String, Function<StagingNote, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		for (Map.Entry<String, Function<StagingNote, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<StagingNote, Object> attributeGetterFunction =
				entry.getValue();

			attributes.put(
				attributeName,
				attributeGetterFunction.apply((StagingNote)this));
		}

		attributes.put("entityCacheEnabled", isEntityCacheEnabled());
		attributes.put("finderCacheEnabled", isFinderCacheEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Map<String, BiConsumer<StagingNote, Object>>
			attributeSetterBiConsumers = getAttributeSetterBiConsumers();

		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			String attributeName = entry.getKey();

			BiConsumer<StagingNote, Object> attributeSetterBiConsumer =
				attributeSetterBiConsumers.get(attributeName);

			if (attributeSetterBiConsumer != null) {
				attributeSetterBiConsumer.accept(
					(StagingNote)this, entry.getValue());
			}
		}
	}

	public Map<String, Function<StagingNote, Object>>
		getAttributeGetterFunctions() {

		return _attributeGetterFunctions;
	}

	public Map<String, BiConsumer<StagingNote, Object>>
		getAttributeSetterBiConsumers() {

		return _attributeSetterBiConsumers;
	}

	private static Function<InvocationHandler, StagingNote>
		_getProxyProviderFunction() {

		Class<?> proxyClass = ProxyUtil.getProxyClass(
			StagingNote.class.getClassLoader(), StagingNote.class,
			ModelWrapper.class);

		try {
			Constructor<StagingNote> constructor =
				(Constructor<StagingNote>)proxyClass.getConstructor(
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

	private static final Map<String, Function<StagingNote, Object>>
		_attributeGetterFunctions;
	private static final Map<String, BiConsumer<StagingNote, Object>>
		_attributeSetterBiConsumers;

	static {
		Map<String, Function<StagingNote, Object>> attributeGetterFunctions =
			new LinkedHashMap<String, Function<StagingNote, Object>>();
		Map<String, BiConsumer<StagingNote, ?>> attributeSetterBiConsumers =
			new LinkedHashMap<String, BiConsumer<StagingNote, ?>>();

		attributeGetterFunctions.put("noteId", StagingNote::getNoteId);
		attributeSetterBiConsumers.put(
			"noteId", (BiConsumer<StagingNote, Long>)StagingNote::setNoteId);
		attributeGetterFunctions.put("createDate", StagingNote::getCreateDate);
		attributeSetterBiConsumers.put(
			"createDate",
			(BiConsumer<StagingNote, Date>)StagingNote::setCreateDate);
		attributeGetterFunctions.put(
			"modifiedDate", StagingNote::getModifiedDate);
		attributeSetterBiConsumers.put(
			"modifiedDate",
			(BiConsumer<StagingNote, Date>)StagingNote::setModifiedDate);
		attributeGetterFunctions.put(
			"externalCaseId", StagingNote::getExternalCaseId);
		attributeSetterBiConsumers.put(
			"externalCaseId",
			(BiConsumer<StagingNote, Long>)StagingNote::setExternalCaseId);
		attributeGetterFunctions.put("caseNoteID", StagingNote::getCaseNoteID);
		attributeSetterBiConsumers.put(
			"caseNoteID",
			(BiConsumer<StagingNote, Long>)StagingNote::setCaseNoteID);
		attributeGetterFunctions.put("type", StagingNote::getType);
		attributeSetterBiConsumers.put(
			"type", (BiConsumer<StagingNote, String>)StagingNote::setType);
		attributeGetterFunctions.put("noteType", StagingNote::getNoteType);
		attributeSetterBiConsumers.put(
			"noteType",
			(BiConsumer<StagingNote, String>)StagingNote::setNoteType);
		attributeGetterFunctions.put("noteText", StagingNote::getNoteText);
		attributeSetterBiConsumers.put(
			"noteText",
			(BiConsumer<StagingNote, String>)StagingNote::setNoteText);
		attributeGetterFunctions.put(
			"noteCreateDate", StagingNote::getNoteCreateDate);
		attributeSetterBiConsumers.put(
			"noteCreateDate",
			(BiConsumer<StagingNote, String>)StagingNote::setNoteCreateDate);
		attributeGetterFunctions.put("direction", StagingNote::getDirection);
		attributeSetterBiConsumers.put(
			"direction",
			(BiConsumer<StagingNote, String>)StagingNote::setDirection);
		attributeGetterFunctions.put("code", StagingNote::getCode);
		attributeSetterBiConsumers.put(
			"code", (BiConsumer<StagingNote, String>)StagingNote::setCode);
		attributeGetterFunctions.put("caller", StagingNote::getCaller);
		attributeSetterBiConsumers.put(
			"caller", (BiConsumer<StagingNote, String>)StagingNote::setCaller);
		attributeGetterFunctions.put("callee", StagingNote::getCallee);
		attributeSetterBiConsumers.put(
			"callee", (BiConsumer<StagingNote, String>)StagingNote::setCallee);
		attributeGetterFunctions.put(
			"externalCreateDate", StagingNote::getExternalCreateDate);
		attributeSetterBiConsumers.put(
			"externalCreateDate",
			(BiConsumer<StagingNote, String>)
				StagingNote::setExternalCreateDate);
		attributeGetterFunctions.put(
			"externalModifiedDate", StagingNote::getExternalModifiedDate);
		attributeSetterBiConsumers.put(
			"externalModifiedDate",
			(BiConsumer<StagingNote, String>)
				StagingNote::setExternalModifiedDate);
		attributeGetterFunctions.put("noteAuthor", StagingNote::getNoteAuthor);
		attributeSetterBiConsumers.put(
			"noteAuthor",
			(BiConsumer<StagingNote, String>)StagingNote::setNoteAuthor);

		_attributeGetterFunctions = Collections.unmodifiableMap(
			attributeGetterFunctions);
		_attributeSetterBiConsumers = Collections.unmodifiableMap(
			(Map)attributeSetterBiConsumers);
	}

	@Override
	public long getNoteId() {
		return _noteId;
	}

	@Override
	public void setNoteId(long noteId) {
		_noteId = noteId;
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
	public long getExternalCaseId() {
		return _externalCaseId;
	}

	@Override
	public void setExternalCaseId(long externalCaseId) {
		_externalCaseId = externalCaseId;
	}

	@Override
	public long getCaseNoteID() {
		return _caseNoteID;
	}

	@Override
	public void setCaseNoteID(long caseNoteID) {
		_caseNoteID = caseNoteID;
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
	public String getNoteType() {
		if (_noteType == null) {
			return "";
		}
		else {
			return _noteType;
		}
	}

	@Override
	public void setNoteType(String noteType) {
		_noteType = noteType;
	}

	@Override
	public String getNoteText() {
		if (_noteText == null) {
			return "";
		}
		else {
			return _noteText;
		}
	}

	@Override
	public void setNoteText(String noteText) {
		_noteText = noteText;
	}

	@Override
	public String getNoteCreateDate() {
		if (_noteCreateDate == null) {
			return "";
		}
		else {
			return _noteCreateDate;
		}
	}

	@Override
	public void setNoteCreateDate(String noteCreateDate) {
		_noteCreateDate = noteCreateDate;
	}

	@Override
	public String getDirection() {
		if (_direction == null) {
			return "";
		}
		else {
			return _direction;
		}
	}

	@Override
	public void setDirection(String direction) {
		_direction = direction;
	}

	@Override
	public String getCode() {
		if (_code == null) {
			return "";
		}
		else {
			return _code;
		}
	}

	@Override
	public void setCode(String code) {
		_code = code;
	}

	@Override
	public String getCaller() {
		if (_caller == null) {
			return "";
		}
		else {
			return _caller;
		}
	}

	@Override
	public void setCaller(String caller) {
		_caller = caller;
	}

	@Override
	public String getCallee() {
		if (_callee == null) {
			return "";
		}
		else {
			return _callee;
		}
	}

	@Override
	public void setCallee(String callee) {
		_callee = callee;
	}

	@Override
	public String getExternalCreateDate() {
		if (_externalCreateDate == null) {
			return "";
		}
		else {
			return _externalCreateDate;
		}
	}

	@Override
	public void setExternalCreateDate(String externalCreateDate) {
		_externalCreateDate = externalCreateDate;
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
	public String getNoteAuthor() {
		if (_noteAuthor == null) {
			return "";
		}
		else {
			return _noteAuthor;
		}
	}

	@Override
	public void setNoteAuthor(String noteAuthor) {
		_noteAuthor = noteAuthor;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(
			0, StagingNote.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public StagingNote toEscapedModel() {
		if (_escapedModel == null) {
			Function<InvocationHandler, StagingNote>
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
		StagingNoteImpl stagingNoteImpl = new StagingNoteImpl();

		stagingNoteImpl.setNoteId(getNoteId());
		stagingNoteImpl.setCreateDate(getCreateDate());
		stagingNoteImpl.setModifiedDate(getModifiedDate());
		stagingNoteImpl.setExternalCaseId(getExternalCaseId());
		stagingNoteImpl.setCaseNoteID(getCaseNoteID());
		stagingNoteImpl.setType(getType());
		stagingNoteImpl.setNoteType(getNoteType());
		stagingNoteImpl.setNoteText(getNoteText());
		stagingNoteImpl.setNoteCreateDate(getNoteCreateDate());
		stagingNoteImpl.setDirection(getDirection());
		stagingNoteImpl.setCode(getCode());
		stagingNoteImpl.setCaller(getCaller());
		stagingNoteImpl.setCallee(getCallee());
		stagingNoteImpl.setExternalCreateDate(getExternalCreateDate());
		stagingNoteImpl.setExternalModifiedDate(getExternalModifiedDate());
		stagingNoteImpl.setNoteAuthor(getNoteAuthor());

		stagingNoteImpl.resetOriginalValues();

		return stagingNoteImpl;
	}

	@Override
	public int compareTo(StagingNote stagingNote) {
		long primaryKey = stagingNote.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof StagingNote)) {
			return false;
		}

		StagingNote stagingNote = (StagingNote)object;

		long primaryKey = stagingNote.getPrimaryKey();

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
		_setModifiedDate = false;
	}

	@Override
	public CacheModel<StagingNote> toCacheModel() {
		StagingNoteCacheModel stagingNoteCacheModel =
			new StagingNoteCacheModel();

		stagingNoteCacheModel.noteId = getNoteId();

		Date createDate = getCreateDate();

		if (createDate != null) {
			stagingNoteCacheModel.createDate = createDate.getTime();
		}
		else {
			stagingNoteCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			stagingNoteCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			stagingNoteCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		stagingNoteCacheModel.externalCaseId = getExternalCaseId();

		stagingNoteCacheModel.caseNoteID = getCaseNoteID();

		stagingNoteCacheModel.type = getType();

		String type = stagingNoteCacheModel.type;

		if ((type != null) && (type.length() == 0)) {
			stagingNoteCacheModel.type = null;
		}

		stagingNoteCacheModel.noteType = getNoteType();

		String noteType = stagingNoteCacheModel.noteType;

		if ((noteType != null) && (noteType.length() == 0)) {
			stagingNoteCacheModel.noteType = null;
		}

		stagingNoteCacheModel.noteText = getNoteText();

		String noteText = stagingNoteCacheModel.noteText;

		if ((noteText != null) && (noteText.length() == 0)) {
			stagingNoteCacheModel.noteText = null;
		}

		stagingNoteCacheModel.noteCreateDate = getNoteCreateDate();

		String noteCreateDate = stagingNoteCacheModel.noteCreateDate;

		if ((noteCreateDate != null) && (noteCreateDate.length() == 0)) {
			stagingNoteCacheModel.noteCreateDate = null;
		}

		stagingNoteCacheModel.direction = getDirection();

		String direction = stagingNoteCacheModel.direction;

		if ((direction != null) && (direction.length() == 0)) {
			stagingNoteCacheModel.direction = null;
		}

		stagingNoteCacheModel.code = getCode();

		String code = stagingNoteCacheModel.code;

		if ((code != null) && (code.length() == 0)) {
			stagingNoteCacheModel.code = null;
		}

		stagingNoteCacheModel.caller = getCaller();

		String caller = stagingNoteCacheModel.caller;

		if ((caller != null) && (caller.length() == 0)) {
			stagingNoteCacheModel.caller = null;
		}

		stagingNoteCacheModel.callee = getCallee();

		String callee = stagingNoteCacheModel.callee;

		if ((callee != null) && (callee.length() == 0)) {
			stagingNoteCacheModel.callee = null;
		}

		stagingNoteCacheModel.externalCreateDate = getExternalCreateDate();

		String externalCreateDate = stagingNoteCacheModel.externalCreateDate;

		if ((externalCreateDate != null) &&
			(externalCreateDate.length() == 0)) {

			stagingNoteCacheModel.externalCreateDate = null;
		}

		stagingNoteCacheModel.externalModifiedDate = getExternalModifiedDate();

		String externalModifiedDate =
			stagingNoteCacheModel.externalModifiedDate;

		if ((externalModifiedDate != null) &&
			(externalModifiedDate.length() == 0)) {

			stagingNoteCacheModel.externalModifiedDate = null;
		}

		stagingNoteCacheModel.noteAuthor = getNoteAuthor();

		String noteAuthor = stagingNoteCacheModel.noteAuthor;

		if ((noteAuthor != null) && (noteAuthor.length() == 0)) {
			stagingNoteCacheModel.noteAuthor = null;
		}

		return stagingNoteCacheModel;
	}

	@Override
	public String toString() {
		Map<String, Function<StagingNote, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(4 * attributeGetterFunctions.size()) + 2);

		sb.append("{");

		for (Map.Entry<String, Function<StagingNote, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<StagingNote, Object> attributeGetterFunction =
				entry.getValue();

			sb.append(attributeName);
			sb.append("=");
			sb.append(attributeGetterFunction.apply((StagingNote)this));
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
		Map<String, Function<StagingNote, Object>> attributeGetterFunctions =
			getAttributeGetterFunctions();

		StringBundler sb = new StringBundler(
			(5 * attributeGetterFunctions.size()) + 4);

		sb.append("<model><model-name>");
		sb.append(getModelClassName());
		sb.append("</model-name>");

		for (Map.Entry<String, Function<StagingNote, Object>> entry :
				attributeGetterFunctions.entrySet()) {

			String attributeName = entry.getKey();
			Function<StagingNote, Object> attributeGetterFunction =
				entry.getValue();

			sb.append("<column><column-name>");
			sb.append(attributeName);
			sb.append("</column-name><column-value><![CDATA[");
			sb.append(attributeGetterFunction.apply((StagingNote)this));
			sb.append("]]></column-value></column>");
		}

		sb.append("</model>");

		return sb.toString();
	}

	private static class EscapedModelProxyProviderFunctionHolder {

		private static final Function<InvocationHandler, StagingNote>
			_escapedModelProxyProviderFunction = _getProxyProviderFunction();

	}

	private static boolean _entityCacheEnabled;
	private static boolean _finderCacheEnabled;

	private long _noteId;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _setModifiedDate;
	private long _externalCaseId;
	private long _caseNoteID;
	private String _type;
	private String _noteType;
	private String _noteText;
	private String _noteCreateDate;
	private String _direction;
	private String _code;
	private String _caller;
	private String _callee;
	private String _externalCreateDate;
	private String _externalModifiedDate;
	private String _noteAuthor;
	private StagingNote _escapedModel;

}