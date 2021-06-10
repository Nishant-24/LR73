package com.argus.oth.data.generator.service.internal;

import com.argus.oth.cases.management.service.CasesLocalService;
import com.argus.oth.common.OTHConstants;
import com.argus.oth.data.generator.FakeCasesGenerator;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.service.GroupLocalService;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PwdGenerator;

import java.text.ParseException;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(immediate = true, service = FakeCasesGenerator.class)
public class FakeCasesGeneratorImpl implements FakeCasesGenerator {

	@Override
	public void addCases() {
		for (String[] entry : _fakeCases) {
			_addCase(entry);
		}
	}

	private void _addCase(String[] entry) {
		Long groupId = _getGroupId();

		try {
			Date minDate = new Date(0);

			_casesLocalService.addCase(
				groupId, GetterUtil.getLong(entry[1]), 1L, entry[3], 0L, entry[2], minDate, minDate, 0L, null, entry[4],
				entry[9], minDate, null, minDate, null, "$0",
				DateUtil.parseDate("MM/dd/yyyy", entry[0], Locale.getDefault()), minDate, _parseDouble(entry[5]),
				_parseDouble(entry[6]), _parseDouble(entry[7]), _parseDouble(entry[8]), _parseDouble(entry[10]),
				StringPool.BLANK, StringPool.BLANK, PwdGenerator.getPassword(8));
		}
		catch (ParseException e) {
			throw new IllegalStateException("Source data is invalid", e);
		}
	}

	private Long _getGroupId() {
		long companyId = PortalUtil.getDefaultCompanyId();

		Group group = _groupLocalService.fetchGroup(companyId, OTHConstants.OTH_PORTAL_GROUP_NAME);

		if (group == null) {
			_log.error(
				"Group with name \"" + OTHConstants.OTH_PORTAL_GROUP_NAME + "\" under company ID " + companyId +
					" is not found");

			return null;
		}

		return group.getGroupId();
	}

	private Double _parseDouble(String value) {
		if ("NA".equalsIgnoreCase(value)) {
			return 0D;
		}

		return GetterUtil.getDouble(value);
	}

	// last updated, case id, client name, diag code, charged amount, reprice amount, paid amount, savings, status

	private static final Log _log = LogFactoryUtil.getLog(FakeCasesGeneratorImpl.class);

	@Reference
	private CasesLocalService _casesLocalService;

	private final List<String[]> _fakeCases = Arrays.asList(
		new String[] {
			"10/13/2020", "56", "20190802-56", "Hiscox Services Limited", "M10", "100233.20", "175", "175", "18.6",
			"Completed", "2.3"
		},
		new String[] {
			"10/05/2020", "59", "20190717-59", "FIDELIS INSURANCE BERMUDA LTD", "Z00.0", "220.00", "119", "119", "45.9",
			"Completed", "0.000000"
		},
		new String[] {
			"10/06/2020", "64", "20190724-64", "Chubb Group Management and Holdings Ltd.", "Z01.00", "295", "180",
			"180", "20", "Completed", "0.000000"
		},
		new String[] {
			"10/07/2020", "66", "20190529-66", "The Bermuda Hospitals Board", "569.42", "390.00", "84.5", "84.5",
			"78.33", "Completed", "0.000000"
		},
		new String[] {
			"10/01/2020", "67", "20190215-67", "Appleby (Bermuda) Limited", "D80.1", "264.00", "234.00", "234.00", "11",
			"Completed", "1.7"
		},
		new String[] {
			"10/01/2020", "69", "20190729-69", "C & S West Medical Services Ltd.", "701.4", "925.96", "311.12",
			"311.12", "66.4", "Completed", "0.000000"
		},
		new String[] {
			"10/01/2020", "70", "20190717-70", "FIDELIS INSURANCE BERMUDA LTD", "Z00.0", "163.00", "163.00", "163.00",
			"0", "Completed", "0.000000"
		},
		new String[] {
			"10/13/2020", "1", "341344-22", "Scott Smith", "RB", "100233.20", "NA", "NA", "NA", "In Process", "0.000000"
		},
		new String[] {
			"11/14/2020", "2", "3252454-22", "Alan Park", "RB", "100233.20", "NA", "NA", "NA", "In Process", "0.000000"
		},
		new String[] {
			"10/11/2020", "3", "654645-22", "Robert Freeman", "RB", "100233.20", "NA", "NA", "NA", "In Process",
			"0.000000"
		},
		new String[] {
			"09/20/2020", "4", "23246466-11", "Alan Smith", "RB", "100233.20", "NA", "NA", "NA", "In Process",
			"0.000000"
		},
		new String[] {
			"08/17/2020", "5", "23343-55", "Scott Park", "RB", "100233.20", "NA", "NA", "NA", "In Process", "3"
		},
		new String[] {
			"10/18/2020", "6", "324343-33", "Davy Jones", "RB", "100233.20", "NA", "NA", "NA", "In Process", "0.000000"
		});

	@Reference
	private GroupLocalService _groupLocalService;

}