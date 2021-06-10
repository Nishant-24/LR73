package com.argus.oth.bulk.load.background.task.service.impl;

import com.argus.oth.bulk.load.background.task.service.BaseLoadService;
import com.argus.oth.bulk.load.background.task.service.LoadService;
import com.argus.oth.cases.management.model.AuthProcedure;
import com.argus.oth.cases.management.model.StagingAuthProcedure;
import com.argus.oth.cases.management.service.AuthProcedureLocalService;
import com.argus.oth.cases.management.service.StagingAuthProcedureLocalService;

import com.liferay.counter.kernel.service.CounterLocalService;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eric Chin
 */
@Component(
	immediate = true,
	property = {
		"model.name=com.argus.oth.cases.management.model.AuthProcedure",
		"staging.model.name=com.argus.oth.cases.management.model.StagingAuthProcedure"
	},
	service = AopService.class
)
public class AuthProcedureLoadServiceImpl
	extends BaseLoadService implements AopService, LoadService<StagingAuthProcedure> {

	@Override
	public boolean validate(StagingAuthProcedure stagingAuthProcedure) {
		String authNumber = stagingAuthProcedure.getAuthNumber();

		if (blankNullOrNullString(authNumber) || blankNullOrNullString(stagingAuthProcedure.getMedicalCodeId()) ||
			blankNullOrNullString(stagingAuthProcedure.getDescription())) {

			logError("Missing required field for AuthProc with authNumber " + authNumber + ", skipping upsert");

			return false;
		}

		Date externalModifiedDate = parseDate_yyyyMMddHHmmsss(stagingAuthProcedure.getExternalModifiedDate());

		if ((externalModifiedDate != null) && (minDate.compareTo(externalModifiedDate) == 0)) {
			logError(
				"Error parsing externalModifiedDate, AuthProc with authNumber " + authNumber + ", skipping upsert");

			return false;
		}

		Date externalCreatedDate = parseDate_yyyyMMddHHmmsss(stagingAuthProcedure.getExternalCreatedDate());

		if ((externalCreatedDate != null) && (minDate.compareTo(externalCreatedDate) == 0)) {
			logError("Error parsing externalCreatedDate, AuthProc with authNumber " + authNumber + ", skipping upsert");

			return false;
		}

		return true;
	}

	@Override
	protected String getEntityName() {
		return "AuthProcedure";
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	protected boolean load(String randomString) {
		List<StagingAuthProcedure> stagingAuthProcedures = _stagingAuthProcedureLocalService.getStagingAuthProcedures(
			QueryUtil.ALL_POS, QueryUtil.ALL_POS);

		_deleteMain();

		_counterLocalService.reset(AuthProcedure.class.getName());

		for (StagingAuthProcedure stagingAuthProcedure : stagingAuthProcedures) {
			_upsertAuthProcedure(stagingAuthProcedure);
		}

		return true;
	}

	private void _deleteMain() {
		_authProcedureLocalService.deleteAll();
	}

	private void _upsertAuthProcedure(StagingAuthProcedure stagingAuthProcedure) {
		String authNumber = stagingAuthProcedure.getAuthNumber();
		String medicalCodeId = stagingAuthProcedure.getMedicalCodeId();
		String description = stagingAuthProcedure.getDescription();

		if (!validate(stagingAuthProcedure)) {
			logError("AuthProcedure with authNumber " + authNumber + " invalid, skipping upsert");

			return;
		}

		Date externalModifiedDate = parseDate_yyyyMMddHHmmsss(stagingAuthProcedure.getExternalModifiedDate());
		Date externalCreatedDate = parseDate_yyyyMMddHHmmsss(stagingAuthProcedure.getExternalCreatedDate());

		_authProcedureLocalService.addAuthProcedure(
			stagingAuthProcedure.getExternalAuthorizationId(), authNumber, medicalCodeId, description,
			externalModifiedDate, externalCreatedDate);
	}

	@Reference
	private AuthProcedureLocalService _authProcedureLocalService;

	@Reference
	private CounterLocalService _counterLocalService;

	@Reference
	private StagingAuthProcedureLocalService _stagingAuthProcedureLocalService;

}