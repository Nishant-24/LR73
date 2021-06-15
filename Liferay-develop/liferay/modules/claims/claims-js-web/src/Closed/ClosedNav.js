import React from 'react';
import ClayNav from '@clayui/nav';
import { useSelector, useDispatch } from 'react-redux';
import { setActiveTab } from './ClosedSlice';

const ClosedNav = () => {
	const dispatch = useDispatch();
	const activeTab = useSelector((state) => state.closed.activeTab);
	const charts = useSelector((state) => state.closed.charts);

	return (
		<ClayNav className="nav-pills claim__nav">
			<ClayNav.Item>
				<ClayNav.Link
					active={activeTab === 0}
					onClick={() => dispatch(setActiveTab(0))}
					data-analytics-asset-type="custom"
					data-analytics-asset-id="claims-closed-total-paid"
					data-analytics-asset-category="claims"
					data-analytics-asset-title={Liferay.Language.get('claims-closed-total-paid')}
				>
					{Liferay.Language.get('total-paid')}: {charts.paidAmount.total_formatted}
				</ClayNav.Link>
			</ClayNav.Item>

			<ClayNav.Item>
				<ClayNav.Link
					active={activeTab === 1}
					onClick={() => dispatch(setActiveTab(1))}
					data-analytics-asset-type="custom"
					data-analytics-asset-id="claims-closed-volume"
					data-analytics-asset-category="claims"
					data-analytics-asset-title={Liferay.Language.get('claims-closed-volume')}
				>
					{Liferay.Language.get('claim-volume')}: {charts.claimVolume.totalCount}
				</ClayNav.Link>
			</ClayNav.Item>

			<ClayNav.Item>
				<ClayNav.Link
					active={activeTab === 2}
					onClick={() => dispatch(setActiveTab(2))}
					data-analytics-asset-type="custom"
					data-analytics-asset-id="claims-closed-savings-range"
					data-analytics-asset-category="claims"
					data-analytics-asset-title={Liferay.Language.get('claims-closed-savings-range')}
				>
					{Liferay.Language.get('savings-range')}: {charts.savingsRange.data.averageX_formatted} {charts.savingsRange.data.savingsAmount_formatted}
				</ClayNav.Link>
			</ClayNav.Item>
		</ClayNav>
	);
}

export default ClosedNav;