import React, { useEffect } from 'react';
import ClayBadge from '@clayui/badge';
import ClayCard from '@clayui/card';
import ClayIcon from '@clayui/icon';
import { useSelector } from 'react-redux';
import { AreaChart, themeColors } from 'charts-js-web';
import { colors, symbol } from '~/Utils/index';
import LoadingIndicator from '~/LoadingIndicator/LoadingIndicator';
import TooltipContentTurnaroundTime from './TooltipContentTurnaroundTime';

const ClaimsTurnaroundTime = (props) => {
	const chart = useSelector((state) => state.sla.charts.claimsTurnaroundTime);
	const status = useSelector((state) => state.sla.status.claimsTurnaroundTime);
	const error = useSelector((state) => state.sla.error.claimsTurnaroundTime);

	return (
		<ClayCard>
			<LoadingIndicator status={status} error={error}>
				<ClayCard.Body>
					<div className="card-title">
						<div>
							<ClayBadge displayType="dark" label={chart.goal_formatted} />
							<span>{Liferay.Language.get('claims-turnaround-time')}</span>
						</div>
						<div>
							<span className="font-weight-light">{chart.average_formatted} {Liferay.Language.get('avg')}</span>
							<ClayIcon
								symbol={symbol(chart.average, chart.goal)}
							/>
						</div>
					</div>

					<AreaChart
						colors={colors}
						data={chart.data}
						dataKeys={['avgClaimTurnAround']}
						height={220}
						fillByValue={chart.goal}
						referenceLine={{
							y: {
								value: chart.goal,
								label: chart.goal_formatted
							}
						}}
						tooltip={{
							content: <TooltipContentTurnaroundTime
										dateKey="amAnalyticsClaimDate_mmm_dd_yyyy"
										texts={[
											Liferay.Language.get('average-claims-turnaround-time'),
											Liferay.Language.get('shortest-claims-turnaround-time'),
											Liferay.Language.get('longest-claims-turnaround-time')
										]}
										valueKeys={[
											'avgClaimTurnAround_formatted',
											'minClaimTurnAround_formatted',
											'maxClaimTurnAround_formatted'
										]}
									/>
						}}
						xAxis={{
							dataKey: 'amAnalyticsClaimDate_mmm_dd',
							tick: { fontSize: 12 }
						}}
					/>
				</ClayCard.Body>
			</LoadingIndicator>
		</ClayCard>
	)
}

export default ClaimsTurnaroundTime;