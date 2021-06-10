import React from 'react';
import ClayNav from '@clayui/nav';
import { useSelector, useDispatch } from 'react-redux';
import { setActiveTab } from './InProcessSlice';

const InProcessNav = () => {
	const dispatch = useDispatch();
	const activeTab = useSelector((state) => state.inProcess.activeTab);
	const charts = useSelector((state) => state.inProcess.charts);

	return (
		<ClayNav className="nav-pills claim__nav">
			<ClayNav.Item>
				<ClayNav.Link
					active={activeTab === 0}
					onClick={() => dispatch(setActiveTab(0))}
					data-analytics-asset-type="custom"
					data-analytics-asset-id="claims-in-process-total-charged"
					data-analytics-asset-category="claims"
					data-analytics-asset-title={Liferay.Language.get('claims-in-process-total-charged')}
				>
					{Liferay.Language.get('total-charged')}: {charts.chargedAmount.total_formatted}
				</ClayNav.Link>
			</ClayNav.Item>

			<ClayNav.Item>
				<ClayNav.Link
					active={activeTab === 1}
					onClick={() => dispatch(setActiveTab(1))}
					data-analytics-asset-type="custom"
					data-analytics-asset-id="claims-in-process-volume"
					data-analytics-asset-category="claims"
					data-analytics-asset-title={Liferay.Language.get('claims-in-process-volume')}
				>
					{Liferay.Language.get('claim-volume')}: {charts.claimVolume.totalCount}
				</ClayNav.Link>
			</ClayNav.Item>

			<ClayNav.Item>
				<ClayNav.Link
					active={activeTab === 2}
					onClick={() => dispatch(setActiveTab(2))}
					data-analytics-asset-type="custom"
					data-analytics-asset-id="claims-in-process-aging"
					data-analytics-asset-category="claims"
					data-analytics-asset-title={Liferay.Language.get('claims-in-process-aging')}
				>
					{Liferay.Language.get('claim-aging')}: {charts.claimAgingArea.averageX} {Liferay.Language.get('day-average')}
				</ClayNav.Link>
			</ClayNav.Item>
		</ClayNav>
	);
}

export default InProcessNav;