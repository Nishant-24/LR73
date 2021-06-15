import React from 'react';
import ClayNav from '@clayui/nav';
import { useSelector, useDispatch } from 'react-redux';
import { setActiveTab } from './ProcessedSlice';

const ProcessedNav = () => {
	const dispatch = useDispatch();
	const activeTab = useSelector((state) => state.processed.activeTab);
	const charts = useSelector((state) => state.processed.charts);

	return (
		<ClayNav className="nav-pills claim__nav">
			<ClayNav.Item>
				<ClayNav.Link
					active={activeTab === 0}
					onClick={() => dispatch(setActiveTab(0))}
					data-analytics-asset-type="custom"
					data-analytics-asset-id="claims-processed-total-repriced"
					data-analytics-asset-category="claims"
					data-analytics-asset-title={Liferay.Language.get('claims-processed-total-repriced')}
				>
					{Liferay.Language.get('total-repriced')}: {charts.repricedAmount.total_formatted}
				</ClayNav.Link>
			</ClayNav.Item>

			<ClayNav.Item>
				<ClayNav.Link
					active={activeTab === 1}
					onClick={() => dispatch(setActiveTab(1))}
					data-analytics-asset-type="custom"
					data-analytics-asset-id="claims-processed-volume"
					data-analytics-asset-category="claims"
					data-analytics-asset-title={Liferay.Language.get('claims-processed-volume')}
				>
					{Liferay.Language.get('claim-volume')}: {charts.claimVolume.totalCount}
				</ClayNav.Link>
			</ClayNav.Item>
		</ClayNav>
	);
}

export default ProcessedNav;