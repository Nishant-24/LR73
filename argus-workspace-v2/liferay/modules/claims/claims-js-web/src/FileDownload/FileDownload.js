import React from 'react';
import { useSelector } from 'react-redux';
import ClayIcon from '@clayui/icon';
import { getDateRangeFormat } from '~/Utils/index';

const FileDownload = (props) => {
	const spritemap = themeDisplay.getPathThemeImages() + '/clay/icons.svg';
	const dateRange = useSelector((state) => getDateRangeFormat(state.claims.dateRange));
	const downloadReportLink = `/o/reporting/download?startDate=${dateRange.startDate}&endDate=${dateRange.endDate}&p_auth=${Liferay.authToken}`;

	return (
		<a data-senna-off="true" href={downloadReportLink} data-analytics-asset-action="download">
			<ClayIcon
				className="claim-filter__icon lexicon-icon-md"
				spritemap={spritemap}
				symbol="download"/>
			{Liferay.Language.get('download-all-claims-report')}
		</a>
	)
}

export default FileDownload;