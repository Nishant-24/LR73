package com.argus.oth.bulk.load.background.task.service;

import com.argus.oth.cases.management.model.StagingReferenceTypeCode;
import com.argus.oth.cases.management.service.StagingReferenceTypeCodeLocalService;

import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HashMapBuilder;

import java.util.HashMap;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jaclyn Ong
 */
@Component(immediate = true, service = ReferenceTypeCodeFileLoadStagingService.class)
public class ReferenceTypeCodeFileLoadStagingService extends BaseFileLoadStagingService<StagingReferenceTypeCode> {

	@Override
	public void cleanup() {
		_stagingReferenceTypeCodeLocalService.deleteAll();
	}

	@Override
	public String getEntityName() {
		return "ReferenceTypeCode";
	}

	@Override
	protected HashMap<Integer, String> getHeaders() {
		return HashMapBuilder.put(
			0, "Type"
		).put(
			1, "ID"
		).put(
			2, "Key"
		).put(
			3, "Description"
		).put(
			4, "ModifiedDate"
		).put(
			getMaxFieldArrayPosition(), "CreatedDate"
		).build();
	}

	@Override
	protected int getMaxFieldArrayLength() {
		return 6;
	}

	@Override
	protected StagingReferenceTypeCode getStagingModel(String[] fields) {
		StagingReferenceTypeCode stagingReferenceTypeCode =
			_stagingReferenceTypeCodeLocalService.createStagingReferenceTypeCode(0);

		stagingReferenceTypeCode.setExternalReferenceTypeCodeId(GetterUtil.getLong(fields[1]));
		stagingReferenceTypeCode.setType(fields[0]);
		stagingReferenceTypeCode.setKey(fields[2]);
		stagingReferenceTypeCode.setDescription(fields[3]);
		stagingReferenceTypeCode.setExternalModifiedDate(fields[4]);
		stagingReferenceTypeCode.setExternalCreatedDate(fields[5]);

		return stagingReferenceTypeCode;
	}

	@Override
	protected String getStagingModelClassName() {
		return StagingReferenceTypeCode.class.getName();
	}

	@Override
	protected void insert(StagingReferenceTypeCode stagingReferenceTypeCode) {
		_stagingReferenceTypeCodeLocalService.addStagingReferenceTypeCode(
			stagingReferenceTypeCode.getExternalReferenceTypeCodeId(), stagingReferenceTypeCode.getType(),
			stagingReferenceTypeCode.getKey(), stagingReferenceTypeCode.getDescription(),
			stagingReferenceTypeCode.getExternalModifiedDate(), stagingReferenceTypeCode.getExternalCreatedDate());
	}

	@Reference
	private StagingReferenceTypeCodeLocalService _stagingReferenceTypeCodeLocalService;

}