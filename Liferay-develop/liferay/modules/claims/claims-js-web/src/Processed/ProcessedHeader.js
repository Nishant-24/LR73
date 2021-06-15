import React from 'react';
import { ClaimsFilter } from '~/Claims/index';
import { FileDownload } from '~/FileDownload/index';

const ProcessedHeader = () => {
	
	return (
		<ClaimsFilter>
			<h4 className="mb-0 mr-3">{Liferay.Language.get('processed-claims')}</h4>
			<FileDownload />
		</ClaimsFilter>
	);
}

export default ProcessedHeader;