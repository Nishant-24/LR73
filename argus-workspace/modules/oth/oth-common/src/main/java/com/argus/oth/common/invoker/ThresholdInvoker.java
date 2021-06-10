package com.argus.oth.common.invoker;

import com.argus.oth.cases.management.model.Cases;
import com.argus.oth.cases.management.model.DataRequest;
import com.argus.oth.cases.management.service.CasesLocalService;
import com.argus.oth.cases.management.service.DataRequestLocalService;
import com.argus.oth.common.configurator.CaseManagementConfigurator;
import com.argus.oth.common.enums.DataRequestType;
import com.argus.oth.common.helper.OTHCommonHelper;

import com.liferay.portal.kernel.util.ListUtil;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Function;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eric Chin
 */
@Component(immediate = true, service = ThresholdInvoker.class)
public class ThresholdInvoker<T> {

	public void invokeByCase(
		long caseId, DataRequestType dataRequestType, Function<String, List<T>> integrationFunction,
		Consumer<List<T>> processConsumer) {

		Cases cases = _casesLocalService.fetchCases(caseId);

		if (Objects.isNull(cases)) {
			return;
		}

		long externalCaseId = cases.getExternalCaseId();

		DataRequest dataRequest = _dataRequestLocalService.fetchByExternalCaseId_Type(
			externalCaseId, dataRequestType.name());

		_invoke(0, caseId, externalCaseId, dataRequestType, dataRequest, integrationFunction, processConsumer);
	}

	public void invokeByClient(
		long clientId, DataRequestType dataRequestType, Function<String, List<T>> integrationFunction,
		Consumer<List<T>> processConsumer) {

		DataRequest dataRequest = _dataRequestLocalService.fetchByClientId_Type(clientId, dataRequestType.name());

		_invoke(clientId, 0, 0, dataRequestType, dataRequest, integrationFunction, processConsumer);
	}

	private void _invoke(
		long clientId, long caseId, long externalCaseId, DataRequestType dataRequestType, DataRequest dataRequest,
		Function<String, List<T>> integrationFunction, Consumer<List<T>> processConsumer) {

		Date lastUpdatedDate;

		if (Objects.nonNull(dataRequest)) {
			lastUpdatedDate = dataRequest.getLastUpdatedDate();
		}
		else {
			lastUpdatedDate = new Date(0);
		}

		Date currentDate = new Date();

		long timeDifference = Math.abs(lastUpdatedDate.getTime() - currentDate.getTime());

		long timeDifferenceMinutes = TimeUnit.MINUTES.convert(timeDifference, TimeUnit.MILLISECONDS);

		if (timeDifferenceMinutes >= _caseManagementConfigurator.requestThreshold()) {
			String lastUpdatedDateString = _othCommonHelper.formatDate_yyyyMMddHHmmssZ(lastUpdatedDate);

			List<T> response = integrationFunction.apply(lastUpdatedDateString);

			if (!ListUtil.isEmpty(response)) {
				processConsumer.accept(response);

				_dataRequestLocalService.setDataRequestLastUpdatedDate(
					clientId, caseId, externalCaseId, dataRequestType.name());
			}
		}
	}

	@Reference
	private CaseManagementConfigurator _caseManagementConfigurator;

	@Reference
	private CasesLocalService _casesLocalService;

	@Reference
	private DataRequestLocalService _dataRequestLocalService;

	@Reference
	private OTHCommonHelper _othCommonHelper;

}