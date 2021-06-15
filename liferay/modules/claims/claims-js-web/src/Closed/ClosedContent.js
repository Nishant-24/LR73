import React from 'react';
import ClayLayout from '@clayui/layout';
import ClayTabs from '@clayui/tabs';
import { useSelector } from 'react-redux';
import { PieChart, AreaChart, themeColors } from 'charts-js-web';
import { Legend, Label } from '~/Chart/index';
import { chartCountFormatter, chartCurrencyFormatter, getClaimAmountRangeColor } from '~/Utils/index';
import TooltipContent from './TooltipContent';
import LoadingIndicator from '~/LoadingIndicator/LoadingIndicator';

const ClosedContent = () => {
	const activeTab = useSelector((state) => state.closed.activeTab);
	const charts = useSelector((state) => state.closed.charts);
	const status = useSelector((state) => state.closed.status);
	const error = useSelector((state) => state.closed.error);
	
	const claimVolume = charts.claimVolume;
	const paidAmount = charts.paidAmount;
	const paidAmountArea = charts.paidAmountArea;
	const savingsRange = charts.savingsRange.data;
	const colors = [themeColors.info];

	return (
		<ClayTabs.Content
			activeIndex={activeTab}
			className="claim__content"
		>
			<ClayTabs.TabPane aria-labelledby="total-paid">
				<ClayLayout.Row>
					<ClayLayout.Col xl={6}>
						<LoadingIndicator status={status.paidAmount} error={error.paidAmount}>
							<h4>{Liferay.Language.get('claim-breakout-by-paid-amount')}</h4>
							<PieChart
								data={paidAmount.data}
								dataKey="value"
								label={{
									content: <Label heading={paidAmount.total_formatted} subheading={Liferay.Language.get('total')} />
								}}
								legend={{
									align:'right',
									content: <Legend datamap={paidAmount.valueMap} columnLabel={Liferay.Language.get('total-paid')} />,
									layout: 'vertical',
									verticalAlign: 'middle',
								}}
								tooltip={{
									addtlDatamap: paidAmount.avgSavingsPctMap,
									datamap: paidAmount.countMap,
									dateRange: `${paidAmount.startDate} - ${paidAmount.endDate}`,
									formatter: chartCurrencyFormatter,
								}}
							/>
						</LoadingIndicator>
					</ClayLayout.Col>

					<ClayLayout.Col xl={6}>
						<LoadingIndicator status={status.paidAmountArea} error={error.paidAmountArea}>
							<h4>{Liferay.Language.get('paid-amount')} ({paidAmountArea.average_formatted} {Liferay.Language.get('average')})</h4>
							<AreaChart 
								colors={colors}
								data={paidAmountArea.data}
								dataKeys={['financialExposure']}
								height={320}
								referenceLine={{
									y: {
										value: paidAmountArea.average,
										label: `${paidAmountArea.average_formatted} ${Liferay.Language.get('avg')}`,
										labelOffset: 60
									},
								}}
								tooltip={{
									content: <TooltipContent
									texts={[
										Liferay.Language.get('total-paid'),
										Liferay.Language.get('total-claims'),
										Liferay.Language.get('average-savings')
									]}
									valueKeys={[
										'financialExposure_formatted',
										'count_formatted',
										'savingsPercent_average_formatted'
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
									addtlDatamap: claimVolume.avgSavingsPctMap,
									datamap: claimVolume.valueMap,
									dateRange: `${claimVolume.startDate} - ${claimVolume.endDate}`,
									formatter: chartCountFormatter,
								}}
							/>
						</LoadingIndicator>
					</ClayLayout.Col>

					<ClayLayout.Col xl={6}>
						<LoadingIndicator status={status.paidAmountArea} error={error.paidAmountArea}>
							<h4>{Liferay.Language.get('claim-volume')} ({paidAmountArea.count_average} {Liferay.Language.get('average')})</h4>
							<AreaChart 
								colors={colors}
								data={paidAmountArea.data}
								dataKeys={['count']}
								height={320}
								referenceLine={{
									y: {
										value: paidAmountArea.count_average,
										label: `${paidAmountArea.count_average} ${Liferay.Language.get('claims-avg')}`,
										labelOffset: 60
									},
								}}
								tooltip={{
									content: <TooltipContent
									texts={[
										Liferay.Language.get('total-paid'),
										Liferay.Language.get('total-claims'),
										Liferay.Language.get('average-savings')
									]}
									valueKeys={[
										'financialExposure_formatted',
										'count_formatted',
										'savingsPercent_average_formatted'
									]} />
								}}
								xAxis={{ dataKey: 'receivedDate_mmm_dd' }}
							/>
						</LoadingIndicator>
					</ClayLayout.Col>
				</ClayLayout.Row>
			</ClayTabs.TabPane>

			<ClayTabs.TabPane aria-labelledby="savings-range">
				<ClayLayout.Row>
					<ClayLayout.Col xl={6}>
						<LoadingIndicator status={status.savingsRange} error={error.savingsRange}>
							<h4 className="progress-bar-header mb-4">{Liferay.Language.get('claim-amount-breakout-by-savings')}</h4>
							{savingsRange.chargedRanges.map((entry, index) => (
								<div key={index} className="progress-group progress-group-stacked mt-2">
									<div className="progress-bar-label">
										<span>{entry.chargedRange}</span>
										<span>
											{entry.savingsPercentage_formatted} ({entry.savingsAmount_formatted} {Liferay.Language.get('savings')})
										</span>
									</div>
									<div className="progress">
										<div
											aria-valuemin="0"
											aria-valuemax="100"
											aria-valuenow={entry.savingsPercentage}
											className="progress-bar"
											role="progressbar"
											style={{
												width: `${entry.savingsPercentage}%`,
												backgroundColor: getClaimAmountRangeColor(entry.chargedRange)
											}}
										>
										</div>
									</div>
								</div>
							))}
						</LoadingIndicator>
					</ClayLayout.Col>
					<ClayLayout.Col xl={6}>
						<LoadingIndicator status={status.savingsRange} error={error.savingsRange}>
							<h4>{`${Liferay.Language.get('savings')} % ${Liferay.Language.get('range')}`} ({savingsRange.averageX_formatted} {Liferay.Language.get('average')})</h4>
							<AreaChart
								colors={[themeColors.green, themeColors.yellow, themeColors.warning]}
								data={savingsRange.savingRanges}
								dataKeys={['count']}
								gradient={true}
								height={320}
								referenceLine={{
									x: {
										value: savingsRange.averageX,
										label: `${savingsRange.averageX_formatted} ${Liferay.Language.get('savings')}`,
										labelOffset: -40,
										labelYOffset: 100
									},
									y: {
										value: savingsRange.averageY,
										label: `${savingsRange.averageY} ${Liferay.Language.get('claims-avg')}`,
										labelOffset: 60
									}
								}}
								tooltip={{
									content: <TooltipContent
										dateRange={savingsRange.dateRange}
										texts={[
											Liferay.Language.get('savings-percentage'),
											Liferay.Language.get('total-claims'),
											Liferay.Language.get('total-savings')
										]}
										valueKeys={[
											'savingsPercentage_formatted',
											'count_formatted',
											'savingsAmount_formatted'
										]}
									/>
								}}
								xAxis={{
									dataKey: 'savingsPercentage',
									domain: ['dataMin', 'dataMax'],
									tickCount: 2,
									tickFormatter: (tick) => `${tick}% ${Liferay.Language.get('savings')}`,
									type: 'number'
								}}
								margin={{ left: 10, right: 20 }}
							/>
						</LoadingIndicator>
					</ClayLayout.Col>
				</ClayLayout.Row>
			</ClayTabs.TabPane>
		</ClayTabs.Content>
	);
}

export default ClosedContent;