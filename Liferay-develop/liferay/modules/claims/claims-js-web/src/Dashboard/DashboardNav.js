import React from 'react';
import ClayNav from "@clayui/nav";
import { useSelector, useDispatch } from 'react-redux';
import { setActiveTab } from "./DashboardSlice";

const DashboardNav = () => {
	const dispatch = useDispatch();
	const activeTab = useSelector((state) => state.dashboard.activeTab);
	const charts = useSelector((state) => state.dashboard.charts);
	
	return (
		<ClayNav className="nav-pills claim__nav">
			<ClayNav.Item>
				<ClayNav.Link
					active={activeTab === 0}
					onClick={() => dispatch(setActiveTab(0))}
					data-analytics-asset-type="custom"
					data-analytics-asset-id="claims-dashboard-financial-exposure"
					data-analytics-asset-category="claims"
					data-analytics-asset-title={Liferay.Language.get('claims-dashboard-financial-exposure')}
				>
					{Liferay.Language.get('financial-exposure')}: {charts.financialExposure.total_formatted}
				</ClayNav.Link>
			</ClayNav.Item>

			<ClayNav.Item>
				<ClayNav.Link
					active={activeTab === 1}
					onClick={() => dispatch(setActiveTab(1))}
					data-analytics-asset-type="custom"
					data-analytics-asset-id="claims-dashboard-volume"
					data-analytics-asset-category="claims"
					data-analytics-asset-title={Liferay.Language.get('claims-dashboard-volume')}
				>
					{Liferay.Language.get('claim-volume')}: {charts.financialExposure.count_formatted}
				</ClayNav.Link>
			</ClayNav.Item>
		</ClayNav>
	);
}

export default DashboardNav;