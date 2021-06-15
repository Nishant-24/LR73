import React from 'react';
import ClayLayout from '@clayui/layout';
import ClayTabs from '@clayui/tabs';
import { useSelector } from 'react-redux';
import { PieChart, AreaChart, themeColors } from 'charts-js-web';
import { Legend, Label } from '~/Chart/index';
import TooltipContent from './TooltipContent';
import { chartAgeFormatter, chartCountFormatter, chartCurrencyFormatter } from '~/Utils/index';
import LoadingIndicator from '~/LoadingIndicator/LoadingIndicator';

const InProcessContent = () => {
	const activeTab = useSelector((state) => state.inProcess.activeTab);
	const charts = useSelector((state) => state.inProcess.charts);
	const status = useSelector((state) => state.inProcess.status);
	const error = useSelector((state) => state.inProcess.error);

	const chargedAmount = charts.chargedAmount;
	const chargedAmountArea = charts.chargedAmountArea;
	const claimVolume = charts.claimVolume;
	const claimAging = charts.claimAging;
	const claimAgingArea = charts.claimAgingArea;
	
	const colors = [themeColors.warning];

	return (
		<ClayTabs.Content
			activeIndex={activeTab}
			className="claim__content"
		>
			<ClayTabs.TabPane aria-labelledby="total-charge">
				<ClayLayout.Row>
					<ClayLayout.Col xl={6}>
						<LoadingIndicator status={status.chargedAmount} error={error.chargedAmount}>
							<h4>{Liferay.Language.get('claim-breakout-by-charged-amount')}</h4>
							<PieChart
								data={chargedAmount.data}
								dataKey="value"
								label={{
									content: <Label heading={chargedAmount.total_formatted} subheading={Liferay.Language.get('total')} />
								}}
								legend={{
									align:'right',
									content: <Legend datamap={chargedAmount.valueMap} columnLabel={Liferay.Language.get('total-charged')} />,
									layout: 'vertical',
									verticalAlign: 'middle',
								}}
								tooltip={{
									addtlDatamap: chargedAmount.avgDaysMap,
									datamap: chargedAmount.countMap,
									dateRange: `${chargedAmount.startDate} - ${chargedAmount.endDate}`,
									formatter: chartCurrencyFormatter,
								}}
							/>
						</LoadingIndicator>
					</ClayLayout.Col>

					<ClayLayout.Col xl={6}>
						<LoadingIndicator status={status.chargedAmountArea} error={error.chargedAmountArea}>
							<h4>{Liferay.Language.get('charged-amount')} ({chargedAmountArea.average_formatted} {Liferay.Language.get('average')})</h4>
							<AreaChart 
								colors={colors}
								data={chargedAmountArea.data}
								dataKeys={['chargedAmount']}
								height={320}
								referenceLine={{
									y: { value: chargedAmountArea.average, label: `${chargedAmountArea.average_formatted} ${Liferay.Language.get('charged-avg')}`, labelOffset: 60},
								}}
								tooltip={{
									content: <TooltipContent
										texts={[
											Liferay.Language.get('total-charged'),
											Liferay.Language.get('average-age'),
											Liferay.Language.get('total-claims'),
										]}
										valueKeys={[
											'chargedAmount_formatted',
											'claimAging_average_formatted',
											'count_formatted'
										]} />
								}}
								xAxis={{ dataKey: 'receivedDate_mmm_dd' }}
							/>
						</LoadingIndicator>
					</ClayLayout.Col>
				</ClayLayout.Row>
			</ClayTabs.TabPane>

			<ClayTabs.TabPane aria-labelledby="claim-volume">
				<ClayLayout.Row>
					<ClayLayout.Col xl={6}>
						<LoadingIndicator status={status.claimVolume} error={error.claimVolume}>
							<h4>{Liferay.Language.get('claim-breakout-by-volume')}</h4>
							<PieChart
								data={claimVolume.data}
								dataKey="count"
								label={{
									content: <Label heading={claimVolume.totalCount} subheading={Liferay.Language.get('total-claims')} />
								}}
								legend={{
									align:'right',
									content: <Legend datamap={claimVolume.countMap} columnLabel={Liferay.Language.get('total-claims')} />,
									layout: 'vertical',
									verticalAlign: 'middle',
								}}
								tooltip={{
									addtlDatamap: claimVolume.avgDaysMap,
									datamap: claimVolume.valueMap,
									dateRange: `${claimVolume.startDate} - ${claimVolume.endDate}`,
									formatter: chartCountFormatter,
								}}
							/>
						</LoadingIndicator>
					</ClayLayout.Col>

					<ClayLayout.Col xl={6}>
						<LoadingIndicator status={status.chargedAmountArea} error={error.chargedAmountArea}>
							<h4>{Liferay.Language.get('claim-volume')} ({chargedAmountArea.count_average} {Liferay.Language.get('average')})</h4>
							<AreaChart
								colors={colors}
								data={chargedAmountArea.data}
								dataKeys={['count']}
								height={320}
								referenceLine={{
									y: { value: chargedAmountArea.count_average, label: `${chargedAmountArea.count_average} ${Liferay.Language.get('claims-avg')}`, labelOffset: 60 },
								}}
								tooltip={{
									content: <TooltipContent
									texts={[
										Liferay.Language.get('total-charged'),
										Liferay.Language.get('average-age'),
										Liferay.Language.get('total-claims'),
									]}
									valueKeys={[
										'chargedAmount_formatted',
										'claimAging_average_formatted',
										'count_formatted'
									]} />
								}}
								xAxis={{ dataKey: 'receivedDate_mmm_dd' }}
							/>
						</LoadingIndicator>
					</ClayLayout.Col>
				</ClayLayout.Row>
			</ClayTabs.TabPane>

			<ClayTabs.TabPane aria-labelledby="claims-aging">
				<ClayLayout.Row>
					<ClayLayout.Col xl={6}>
						<LoadingIndicator status={status.claimAging} error={error.claimAging}>
							<h4>{Liferay.Language.get('claim-breakout-by-days')}</h4>
							<PieChart
								data={claimAging.data}
								dataKey="value"
								label={{
									content: <Label heading={claimAging.average_formatted} subheading={Liferay.Language.get('average')} />
								}}
								legend={{
									align:'right',
									content: <Legend datamap={claimAging.valueMap} columnLabel={Liferay.Language.get('total-days')} />,
									layout: 'vertical',
									verticalAlign: 'middle',
								}}
								tooltip={{
									datamap: claimAging.countMap,
									dateRange: `${claimAging.startDate} - ${claimAging.endDate}`,
									formatter: chartAgeFormatter
								}}
							/>
						</LoadingIndicator>
					</ClayLayout.Col>
					<ClayLayout.Col xl={6}>
						<LoadingIndicator status={status.claimAgingArea} error={error.claimAgingArea}>
							<h4>{Liferay.Language.get('claims-aging')} ({claimAgingArea.averageX} {Liferay.Language.get('day-average')})</h4>
							<AreaChart 
								colors={[themeColors.green, themeColors.yellow, themeColors.warning]}
								data={claimAgingArea.data}
								dataKeys={['count']}
								gradient={true}
								height={320}
								referenceLine={{
									y: {
										value: claimAgingArea.averageY,
										label: `${claimAgingArea.averageY} ${Liferay.Language.get('claims-avg')}`,
										labelOffset: 60
									},
								}}
								tooltip={{
									content: <TooltipContent
										dateRange={claimAgingArea.dateRange}
										texts={[
											Liferay.Language.get('age'),
											Liferay.Language.get('total-claims'),
											Liferay.Language.get('total-charged')
										]}
										valueKeys={[
											'claimAge_formatted',
											'count_formatted',
											'chargedAmount_formatted'
										]}
									/>
								}}
								xAxis={{
									dataKey: 'claimAge',
									domain: ['dataMin', 'dataMax'],
									tickCount: 2,
									tickFormatter: (tick) => `${tick} ${(tick === 1) ? Liferay.Language.get('day') : Liferay.Language.get('days')}`,
									type: 'number'
								}}
							/>
						</LoadingIndicator>
					</ClayLayout.Col>
				</ClayLayout.Row>
			</ClayTabs.TabPane>
		</ClayTabs.Content>
	);
}

export default InProcessContent;