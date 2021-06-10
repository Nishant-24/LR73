import React, { useEffect } from 'react';
import ClayIcon from '@clayui/icon';
import ClayLayout from '@clayui/layout';
import ClayNav from '@clayui/nav';
import { useDispatch, useSelector } from 'react-redux';
import { getRecentClaims } from './ClaimsSlice';
import { PieChart, themeColors } from 'charts-js-web';
import { chartCurrencyFormatter } from '~/Utils/index';
import Legend from './Legend';
import Label from './Label';
import LoadingIndicator from '~/LoadingIndicator/LoadingIndicator';

const ClaimHome = () => {
	const dispatch = useDispatch();
	const chart = useSelector((state) => state.claims.chart);
	const layouts = useSelector((state) => state.layouts.data.claims);
	const status = useSelector((state) => state.claims.status);
	const error = useSelector((state) => state.claims.error);

	useEffect(() => {
		dispatch(getRecentClaims());
	}, []);

	return (
		<LoadingIndicator status={status} error={error}>
			<div className="claim-home">
				{layouts[0] &&
					<div className="card-header">
						<div className="claim-home__header">
							<a href={layouts[0].layoutSetFriendlyURL}>
								<ClayIcon
									className="claim-home__icon"
									symbol="claims"
								>
								</ClayIcon>
							</a>
							<h3>
								<a href={layouts[0].layoutSetFriendlyURL}>
									{layouts[0].nameCurrentValue}
								</a>
							</h3>
						</div>
						<ClayNav className="card-header-tabs flex-row">
							{layouts.filter(layout => layout.friendlyURL !== '/claims').map((layout, index) => (
								<ClayNav.Item key={index}>
									<ClayNav.Link href={layout.layoutSetFriendlyURL}>
										{layout.titleCurrentValue}
									</ClayNav.Link>
								</ClayNav.Item>
							))}
						</ClayNav>
					</div>
				}

				<div className="card-body">
					<ClayLayout.Row justify="start">
						<ClayLayout.Col size={12}>
							<h4>{Liferay.Language.get('recent-claims')}</h4>
							<h5>{Liferay.Language.get('past-4-weeks')}</h5>
							<PieChart
								colors={[
									themeColors.warning,
									themeColors.teal,
									themeColors.info
								]}
								data={chart.data}
								dataKey="value"
								height={475}
								innerRadius={110}
								outerRadius={150}
								label={{
									content: <Label heading={chart.total} subheading={Liferay.Language.get('financial-exposure')} />
								}}
								legend={{
									content: <Legend datamap={chart.claimTotals} />,
									layout: 'vertical',
									verticalAlign: 'bottom',
									wrapperStyle: {
										bottom: '-1rem',
										left: 0,
										width: '100%'
									}
								}}
								tooltip={{
									formatter: chartCurrencyFormatter,
								}}
							/>
						</ClayLayout.Col>
					</ClayLayout.Row>
				</div>
			</div>
		</LoadingIndicator>
	)
}

export default ClaimHome;