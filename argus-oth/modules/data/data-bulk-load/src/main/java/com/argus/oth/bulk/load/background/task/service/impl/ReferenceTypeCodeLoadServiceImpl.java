package com.argus.oth.bulk.load.background.task.service.impl;

import com.argus.oth.bulk.load.background.task.service.BaseLoadService;
import com.argus.oth.bulk.load.background.task.service.LoadService;
import com.argus.oth.cases.management.model.ReferenceTypeCode;
import com.argus.oth.cases.management.model.StagingReferenceTypeCode;
import com.argus.oth.cases.management.service.ReferenceTypeCodeLocalService;
import com.argus.oth.cases.management.service.StagingReferenceTypeCodeLocalService;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jaclyn Ong
 */
@Component(
	immediate = true,
	property = {
		"model.name=com.argus.oth.cases.management.model.ReferenceTypeCode",
		"staging.model.name=com.argus.oth.cases.management.model.StagingReferenceTypeCode"
	},
	service = AopService.class
)
public class ReferenceTypeCodeLoadServiceImpl
	extends BaseLoadService implements AopService, LoadService<StagingReferenceTypeCode> {

	@Override
	public boolean validate(StagingReferenceTypeCode stagingReferenceTypeCode) {
		long externalReferenceTypeCodeId = stagingReferenceTypeCode.getExternalReferenceTypeCodeId();

		if ((externalReferenceTypeCodeId == 0L) || blankNullOrNullString(stagingReferenceTypeCode.getType()) ||
			blankNullOrNullString(stagingReferenceTypeCode.getDescription())) {

			logError(
				"Missing required field for " + getEntityName() + " ID " + externalReferenceTypeCodeId +
					", skipping upsert");

			return false;
		}

		Date createdDate = parseDate_yyyyMMddHHmmsss(stagingReferenceTypeCode.getExternalCreatedDate());

		if (dateParseFailed(createdDate)) {
			logError(
				"Error parsing createdDate, " + getEntityName() + " ID " + externalReferenceTypeCodeId +
					", skipping upsert");

			return false;
		}

		Date modifiedDate = parseDate_yyyyMMddHHmmsss(stagingReferenceTypeCode.getExternalModifiedDate());

		if (dateParseFailed(modifiedDate)) {
			logError(
				"Error parsing modifiedDate, " + getEntityName() + " ID " + externalReferenceTypeCodeId +
					", skipping upsert");

			return false;
		}

		return true;
	}

	@Override
	protected String getEntityName() {
		return "ReferenceTypeCode";
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	protected boolean load(String randomString) {
		List<StagingReferenceTypeCode> stagingReferenceTypeCodes =
			_stagingReferenceTypeCodeLocalService.getStagingReferenceTypeCodes(QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		for (StagingReferenceTypeCode stagingReferenceTypeCode : stagingReferenceTypeCodes) {
			_upsertReferenceTypeCode(stagingReferenceTypeCode, randomString);
		}

		return true;
	}

	private void _upsertReferenceTypeCode(StagingReferenceTypeCode stagingReferenceTypeCode, String randomString) {
		long externalReferenceTypeCodeId = stagingReferenceTypeCode.getExternalReferenceTypeCodeId();

		logDebug("Upserting externalReferenceTypeCode (ID: " + externalReferenceTypeCodeId + ")");

		Date modifiedDate = parseDate_yyyyMMddHHmmsss(stagingReferenceTypeCode.getExternalModifiedDate());
		Date createdDate = parseDate_yyyyMMddHHmmsss(stagingReferenceTypeCode.getExternalCreatedDate());

		if (!validate(stagingReferenceTypeCode)) {
			logError(getEntityName() + " ID " + externalReferenceTypeCodeId + " invalid, skipping upsert");

			return;
		}

		ReferenceTypeCode referenceTypeCode = _referenceTypeCodeLocalService.fetchByKey(
			stagingReferenceTypeCode.getKey());

		long groupId = getGroupId();

		if (Objects.isNull(referenceTypeCode)) {
			_referenceTypeCodeLocalService.addReferenceTypeCode(
				groupId, externalReferenceTypeCodeId, stagingReferenceTypeCode.getType(),
				stagingReferenceTypeCode.getKey(), stagingReferenceTypeCode.getDescription(), modifiedDate, createdDate,
				randomString);
		}
		else {
			referenceTypeCode.setGroupId(groupId);
			referenceTypeCode.setType(stagingReferenceTypeCode.getType());
			referenceTypeCode.setKey(stagingReferenceTypeCode.getKey());
			referenceTypeCode.setDescription(stagingReferenceTypeCode.getDescription());
			referenceTypeCode.setModifiedDate(modifiedDate);
			referenceTypeCode.setCreateDate(createdDate);
			referenceTypeCode.setRowProcessed(randomString);

			_referenceTypeCodeLocalService.updateReferenceTypeCode(referenceTypeCode);
		}
	}

	@Reference
	private ReferenceTypeCodeLocalService _referenceTypeCodeLocalService;

	@Reference
	private StagingReferenceTypeCodeLocalService _stagingReferenceTypeCodeLocalService;

}