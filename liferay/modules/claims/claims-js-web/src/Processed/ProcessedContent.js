import React from 'react';
import ClayLayout from '@clayui/layout';
import ClayTabs from '@clayui/tabs';
import { useSelector } from 'react-redux';
import { PieChart, AreaChart, themeColors } from 'charts-js-web';
import { Legend, Label } from '~/Chart/index';
import TooltipContent from './TooltipContent';
import { chartCountFormatter, chartCurrencyFormatter } from '~/Utils/index';
import LoadingIndicator from '~/LoadingIndicator/LoadingIndicator';

const ProcessedContent = () => {
	const activeTab = useSelector((state) => state.processed.activeTab);
	const charts = useSelector((state) => state.processed.charts);
	const status = useSelector((state) => state.processed.status);
	const error = useSelector((state) => state.processed.error);

	const claimVolume = charts.claimVolume;
	const repricedAmount = charts.repricedAmount;
	const repricedAmountArea = charts.repricedAmountArea;

	const colors = [themeColors.teal];

	return (
		<ClayTabs.Content
			activeIndex={activeTab}
			className="claim__content"
		>
			<ClayTabs.TabPane aria-labelledby="total-repriced">
				<ClayLayout.Row>
					<ClayLayout.Col xl={6}>
						<LoadingIndicator status={status.repricedAmount} error={error.repricedAmount}>
							<h4>{Liferay.Language.get('claim-breakout-by-repriced-amount')}</h4>
							<PieChart
								data={repricedAmount.data}
								dataKey="value"
								label={{
									content: <Label heading={repricedAmount.total_formatted} subheading={Liferay.Language.get('total')} />
								}}
								legend={{
									align:'right',
									content: <Legend datamap={repricedAmount.valueMap} columnLabel={Liferay.Language.get('total-repriced')} />,
									layout: 'vertical',
									verticalAlign: 'middle',
								}}
								tooltip={{
									datamap: repricedAmount.countMap,
									dateRange: `${repricedAmount.startDate} - ${repricedAmount.endDate}`,
									formatter: chartCurrencyFormatter,
								}}
							/>
						</LoadingIndicator>
					</ClayLayout.Col>

					<ClayLayout.Col xl={6}>
						<LoadingIndicator status={status.repricedAmountArea} error={error.repricedAmountArea}>
							<h4>{Liferay.Language.get('repriced-amount')} ({repricedAmountArea.average_formatted} {Liferay.Language.get('average')})</h4>
							<AreaChart
								colors={colors}
								data={repricedAmountArea.data}
								dataKeys={['financialExposure']}
								height={320}
								referenceLine={{
									y: {
										value: repricedAmountArea.average,
										label: `${repricedAmountArea.average_formatted} ${Liferay.Language.get('avg')}`,
										labelOffset: 60
									},
								}}
								tooltip={{
									content: <TooltipContent
										texts={[
											Liferay.Language.get('total-repriced'),
											Liferay.Language.get('total-claims')
										]}
										valueKeys={[
											'financialExposure_formatted',
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
									datamap: claimVolume.valueMap,
									dateRange: `${claimVolume.startDate} - ${claimVolume.endDate}`,
									formatter: chartCountFormatter,
								}}
							/>
						</LoadingIndicator>
					</ClayLayout.Col>

					<ClayLayout.Col xl={6}>
						<LoadingIndicator status={status.repricedAmountArea} error={error.repricedAmountArea}>
							<h4>{Liferay.Language.get('claim-volume')} ({repricedAmountArea.count_average} {Liferay.Language.get('average')})</h4>
							<AreaChart 
								colors={colors}
								data={repricedAmountArea.data}
								dataKeys={['count']}
								height={320}
								referenceLine={{
									y: {
										value: repricedAmountArea.count_average,
										label: `${repricedAmountArea.count_average} ${Liferay.Language.get('claims-avg')}`,
										labelOffset: 60},
								}}
								tooltip={{
									content: <TooltipContent
										texts={[
											Liferay.Language.get('total-repriced'),
											Liferay.Language.get('total-claims')
										]}
										valueKeys={[
											'financialExposure_formatted',
											'count_formatted'
									]} />
								}}
								xAxis={{ dataKey: 'receivedDate_mmm_dd' }}
							/>
						</LoadingIndicator>
					</ClayLayout.Col>
				</ClayLayout.Row>
			</ClayTabs.TabPane>
		</ClayTabs.Content>
	);
}

export default ProcessedContent;