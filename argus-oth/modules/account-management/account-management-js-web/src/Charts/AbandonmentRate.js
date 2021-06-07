import React, { useEffect } from 'react';
import ClayBadge from '@clayui/badge';
import ClayCard from '@clayui/card';
import ClayIcon from '@clayui/icon';
import { useSelector } from 'react-redux';
import { AreaChart, themeColors } from 'charts-js-web';
import { colors, symbol } from '~/Utils/index';
import LoadingIndicator from '~/LoadingIndicator/LoadingIndicator';
import TooltipContent from './TooltipContent';

const AbandonmentRate = (props) => {
	const chart = useSelector((state) => state.sla.charts.abandonmentRate);
	const status = useSelector((state) => state.sla.status.abandonmentRate);
	const error = useSelector((state) => state.sla.error.abandonmentRate);

	return (
		<ClayCard>
			<LoadingIndicator status={status} error={error}>
				<ClayCard.Body>
					<div className="card-title">
						<div>
							<ClayBadge displayType="dark" label={chart.goal_formatted} />
							<span>{Liferay.Language.get('abandonment-rate')}</span>
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
						dataKeys={['abandonmentRate']}
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
										text={Liferay.Language.get('abandonment-rate')}
										valueKey="abandonmentRate_formatted"
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

export default AbandonmentRate;