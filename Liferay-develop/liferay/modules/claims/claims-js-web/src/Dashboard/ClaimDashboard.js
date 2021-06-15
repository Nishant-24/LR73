import React, { useEffect } from 'react';
import ClayCard from '@clayui/card';
import { useSelector, useDispatch } from 'react-redux';
import { DashboardContent, DashboardHeader, DashboardNav } from './index';
import { getFinancialExposure, getFinancialExposureVolume, getFinancialExposureTopProviders, getFinancialExposureTopSavings } from './DashboardSlice';

const ClaimDashboard = () => {
	const dispatch = useDispatch();
	const dateRange = useSelector((state) => state.claims.dateRange);

	useEffect(() => {
		dispatch(getFinancialExposure());
		dispatch(getFinancialExposureVolume());
		dispatch(getFinancialExposureTopProviders());
		dispatch(getFinancialExposureTopSavings());
	}, [dateRange]);

	return (
		<React.Fragment>
			<DashboardHeader />

			<ClayCard className="card mx-3">
				<ClayCard.Body className="claim__card-body">
					<DashboardNav />
					<DashboardContent />
				</ClayCard.Body>
			</ClayCard>
		</React.Fragment>
	)
}

export default ClaimDashboard;