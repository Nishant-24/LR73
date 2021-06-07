import React, { useEffect } from 'react';
import ClayLayout from '@clayui/layout';
import { useDispatch, useSelector } from 'react-redux';
import { getAvgDownTime, getAvgSpeed, getAbandonmentRate, getClaimsTurnaroundTime } from './SLASlice';
import { AbandonmentRate, AvgDownTime, AvgSpeed, ClaimsTurnaroundTime } from '~/Charts/index';
import ClayLabel from "@clayui/label";

const AccountSLA = () => {
	const dispatch = useDispatch();
	const dateRange = themeDisplay.getDefaultDateRange();

	useEffect(() => {
		dispatch(getAvgDownTime());
		dispatch(getAvgSpeed());
		dispatch(getAbandonmentRate());
		dispatch(getClaimsTurnaroundTime());
	}, []);

	return (
		<div className="account-sla p-3 bg-secondary">
			<section className="account-sla__header mb-4">
				<h4 className="flex-shrink-0 mb-0">{Liferay.Language.get('operational-slas')}</h4>

				{dateRange &&
					<span className="d-flex align-items-center text-right">
						<ClayLabel displayType="light">
							{dateRange}
						</ClayLabel>
					</span>
				}
			</section>

			<section className="mb-4">
				<h5>{Liferay.Language.get('telephone')}</h5>
				<ClayLayout.Row>
					<ClayLayout.Col xl={4}>
						<AvgDownTime />
					</ClayLayout.Col>

					<ClayLayout.Col xl={4}>
						<AvgSpeed />
					</ClayLayout.Col>

					<ClayLayout.Col xl={4}>
						<AbandonmentRate />
					</ClayLayout.Col>
				</ClayLayout.Row>
			</section>

			<section>
				<h5>{Liferay.Language.get('claims')}</h5>
				<ClaimsTurnaroundTime />
			</section>
		</div>
	)
}

export default AccountSLA;