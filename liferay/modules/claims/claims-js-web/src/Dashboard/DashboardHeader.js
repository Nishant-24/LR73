import React from 'react';
import { ClaimsFilter } from '~/Claims/index';

const DashboardHeader = () => {
	return (
		<ClaimsFilter>
			<h4 className="mb-0">{Liferay.Language.get('claims-dashboard')}</h4>
		</ClaimsFilter>
	);
}

export default DashboardHeader;