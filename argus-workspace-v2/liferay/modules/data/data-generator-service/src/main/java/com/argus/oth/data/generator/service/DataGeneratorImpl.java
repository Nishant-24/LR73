package com.argus.oth.data.generator.service;

import com.argus.oth.cases.management.service.CasesLocalService;
import com.argus.oth.data.generator.DataGenerator;

import com.argus.oth.data.generator.FakeCasesGenerator;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.transaction.Transactional;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;


/**
 * @author Ricky Pan
 */
@Component(immediate = true, service = AopService.class)
public class DataGeneratorImpl implements AopService, DataGenerator {

	@Override
	@Transactional(
		rollbackFor = {
			PortalException.class, SystemException.class,
			IllegalStateException.class
		}
	)
	public void addSampleData() throws Exception {
		_log.info(">>> Adding cases");
		_fakeCasesGenerator.addCases();
		_log.info(">>> Adding sample data completed");
	}

	@Override
	@Transactional(rollbackFor = {PortalException.class, SystemException.class})
	public void deleteAllData(long companyId) throws Exception {
		_log.info(">>> Deleting all sample data...");
		_caseCasesLocalService.deleteAllCases();
		_log.info(">>> All sample data deleted");

		// placeholder

	}

	@Reference
	private CasesLocalService _caseCasesLocalService;

	@Reference
	private FakeCasesGenerator _fakeCasesGenerator;

	private static final Log _log = LogFactoryUtil.getLog(DataGeneratorImpl.class);

	private void _addCasesData() {
		_log.info("Adding cases...");
		_log.info("Adding cases completed.");
	}

	private void _addClaimsData() {
		_log.info("Adding claims...");
		_log.info("Adding claims completed");
	}

}