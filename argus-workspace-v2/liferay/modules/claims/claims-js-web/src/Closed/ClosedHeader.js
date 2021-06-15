import React from 'react';
import { ClaimsFilter } from '~/Claims/index';
import { FileDownload } from '~/FileDownload/index';

const ClosedHeader = () => {

	return (
		<ClaimsFilter>
			<h4 className="mb-0 mr-3">{Liferay.Language.get('closed-claims')}</h4>
			<FileDownload />
		</ClaimsFilter>
	);
}

export default ClosedHeader;