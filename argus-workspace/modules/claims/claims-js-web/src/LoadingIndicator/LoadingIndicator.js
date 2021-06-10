import React from 'react';
import ClayAlert from '@clayui/alert';
import ClayLoadingIndicator from '@clayui/loading-indicator';

const LoadingIndicator = (props) => {
	const {
		error,
		status,
	} = props;

	switch(status) {
		case 'succeeded':
			return props.children;

			break;
		case 'failed':
			return (
				<ClayAlert displayType="danger" title={Liferay.Language.get('error')}>
					{error}
				</ClayAlert>
			);

			break;
		default:
			return (
				<div className="p-1">
					<ClayLoadingIndicator />
				</div>
			);
	}
}

export default LoadingIndicator;