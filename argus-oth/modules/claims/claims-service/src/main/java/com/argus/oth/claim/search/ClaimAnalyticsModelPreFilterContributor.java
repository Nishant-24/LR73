package com.argus.oth.claim.search;

import com.argus.oth.common.OTHConstants;

import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.filter.BooleanFilter;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.search.spi.model.query.contributor.ModelPreFilterContributor;
import com.liferay.portal.search.spi.model.registrar.ModelSearchSettings;

import org.osgi.service.component.annotations.Component;

/**
 * @author Jaclyn Ong
 */
@Component(
	immediate = true, property = "indexer.class.name=com.argus.oth.claim.model.ClaimAnalytics",
	service = ModelPreFilterContributor.class
)
public class ClaimAnalyticsModelPreFilterContributor implements ModelPreFilterContributor {

	@Override
	public void contribute(
		BooleanFilter booleanFilter, ModelSearchSettings modelSearchSettings, SearchContext searchContext) {

		long externalClientId = GetterUtil.getLong(searchContext.getAttribute(OTHConstants.FIELD_EXTERNAL_CLIENT_ID));

		booleanFilter.addRequiredTerm(OTHConstants.FIELD_EXTERNAL_CLIENT_ID, externalClientId);

		long startDate = GetterUtil.getLong(searchContext.getAttribute(OTHConstants.FIELD_START_DATE));
		long endDate = GetterUtil.getLong(searchContext.getAttribute(OTHConstants.FIELD_END_DATE));

		if ((startDate == 0) && (endDate == 0)) {
			return;
		}

		if (endDate == 0) {
			endDate = Long.MAX_VALUE;
		}

		booleanFilter.addRangeTerm(Field.getSortableFieldName(OTHConstants.FIELD_RECEIVED_DATE), startDate, endDate);
	}

}