import React, { useEffect } from 'react';
import ClayBadge from '@clayui/badge';
import ClayCard from '@clayui/card';
import ClayIcon from '@clayui/icon';
import { useSelector } from 'react-redux';
import { AreaChart, themeColors } from 'charts-js-web';
import { colors, symbol } from '~/Utils/index';
import LoadingIndicator from '~/LoadingIndicator/LoadingIndicator';
import TooltipContent from './TooltipContent';

const AvgDownTime = (props) => {
	const chart = useSelector((state) => state.sla.charts.avgDownTime);
	const status = useSelector((state) => state.sla.status.avgDownTime);
	const error = useSelector((state) => state.sla.error.avgDownTime);

	return (
		<ClayCard>
			<LoadingIndicator status={status} error={error}>
				<ClayCard.Body>
					<div className="card-title">
						<div>
							<ClayBadge displayType="dark" label={chart.goal_formatted} />
							<span>{Liferay.Language.get('average-down-time')}</span>
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
						dataKeys={['avgDownTime']}
						height={220}
						fillByValue={chart.goal}
						referenceLine={{
							y: {
								value: chart.goal,
								label: chart.goal_formatted
							}
						}}
						tooltip={{
							content: <TooltipContent
										dateKey="amAnalyticsTelephonyDate_mmm_dd_yyyy"
										text={Liferay.Language.get('average-down-time-adt')}
										valueKey="avgDownTime_formatted"
									/>
						}}
						xAxis={{
							dataKey: 'amAnalyticsTelephonyDate_mmm_dd',
							tick: { fontSize: 12 }
						}}
					/>
				</ClayCard.Body>
			</LoadingIndicator>
		</ClayCard>
	)
}

export default AvgDownTime;