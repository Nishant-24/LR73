import React from 'react';
import ClayLayout from '@clayui/layout';
import ClayTabs from "@clayui/tabs";
import { PieChart, AreaChart, themeColors } from 'charts-js-web';
import { useSelector } from "react-redux";
import { Legend, Label } from '~/Chart/index';
import { chartCountFormatter, chartCurrencyFormatter } from '~/Utils/index';
import { DashboardLegend } from './index';
import TooltipContent from './TooltipContent';
import LoadingIndicator from '~/LoadingIndicator/LoadingIndicator';

const DashboardContent = () => {
	const activeTab = useSelector((state) => state.dashboard.activeTab);
	const charts = useSelector((state) => state.dashboard.charts);
	const status = useSelector((state) => state.dashboard.status);
	const error = useSelector((state) => state.dashboard.error);
	const layouts = useSelector((state) => state.nav.data);

	const financialExposure = charts.financialExposure;
	const financialExposureVolume = charts.financialExposureVolume;
	const financialExposureTopProviders = charts.financialExposureTopProviders;
	const financialExposureTopSavings = charts.financialExposureTopSavings;

	const colors = [themeColors.info, themeColors.teal, themeColors.warning];

	return (
		<ClayTabs.Content
			activeIndex={activeTab}
			className="claim__content"
		>
			<ClayTabs.TabPane aria-labelledby="financial-exposure">
				<div>
					<LoadingIndicator status={status.financialExposure} error={error.financialExposure}>
						<AreaChart
							colors={colors}
							data={financialExposure.data}
							dataKeys={['Closed', 'Processed', 'In Process']}
							height={420}
							xAxis={{ dataKey: 'receivedDate_mmm_dd' }}
							legend={{
								align: 'right',
								content: <DashboardLegend
									datamap={financialExposure.legendMap_formatted}
									layouts={layouts}
								/>,
								layout: 'vertical',
								verticalAlign: 'middle',
								wrapperStyle: {
									top: '0.188rem',
									bottom: 0,
									right: '-0.313rem',
									width:'15.625rem'
								}
							}}
							tooltip={{
								content: <TooltipContent />
							}}
						/>
					</LoadingIndicator>
				</div>
				<ClayLayout.Row>
					<ClayLayout.Col xl={6}>
						<h4>{Liferay.Language.get('top-providers')}</h4>
						<LoadingIndicator status={status.financialExposureTopProviders} error={error.financialExposureTopProviders}>
							<PieChart
								data={financialExposureTopProviders.data}
								dataKey="financialExposure"
								label={{
									content: <Label heading={financialExposureTopProviders.total_formatted} subheading={Liferay.Language.get('total')} />
								}}
								legend={{
									align:'right',
									content: <Legend datamap={financialExposureTopProviders.dataMap} keyColumnLabel={Liferay.Language.get('provider-name')} columnLabel={Liferay.Language.get('total')} />,
									layout: 'vertical',
									verticalAlign: 'middle',
								}}
								tooltip={{
									datamap: financialExposureTopProviders.countMap,
									dateRange: `${financialExposureTopProviders.startDate} - ${financialExposureTopProviders.endDate}`,
									formatter: chartCurrencyFormatter
								}}
							/>
						</LoadingIndicator>
					</ClayLayout.Col>

					<ClayLayout.Col xl={6}>
						<h4>{Liferay.Language.get('top-savings-by-provider')}</h4>
						<LoadingIndicator status={status.financialExposureTopSavings} error={error.financialExposureTopSavings}>
							<PieChart
								data={financialExposureTopSavings.data}
								dataKey="savings"
								label={{
									content: <Label heading={financialExposureTopSavings.savingsTotal_formatted} subheading={Liferay.Language.get('total')} />
								}}
								legend={{
									align:'right',
									content: <Legend datamap={financialExposureTopSavings.savingsMap} keyColumnLabel={Liferay.Language.get('provider-name')} columnLabel={Liferay.Language.get('total')} />,
									layout: 'vertical',
									verticalAlign: 'middle',
								}}
								tooltip={{
									datamap: financialExposureTopSavings.countMap,
									dateRange: `${financialExposureTopSavings.startDate} - ${financialExposureTopSavings.endDate}`,
									formatter: chartCurrencyFormatter
								}}
							/>
						</LoadingIndicator>
					</ClayLayout.Col>
				</ClayLayout.Row>
			</ClayTabs.TabPane>

			<ClayTabs.TabPane aria-labelledby="claim-volume">
				<div>
					<LoadingIndicator status={status.financialExposureVolume} error={error.financialExposureVolume}>
						<AreaChart
							colors={colors}
							data={financialExposureVolume.data}
							dataKeys={['Closed', 'Processed', 'In Process']}
							height={420}
							xAxis={{ dataKey: 'receivedDate_mmm_dd' }}
							legend={{
								align: 'right',
								content: <DashboardLegend
									datamap={financialExposureVolume.legendMap_formatted}
									layouts={layouts}
								/>,
								layout: 'vertical',
								verticalAlign: 'middle',
								wrapperStyle: {
									top: '0.188rem',
									bottom: 0,
									right: '-0.313rem',
									width:'15.625rem'
								}
							}}
							tooltip={{
								content: <TooltipContent />
							}}

						/>
					</LoadingIndicator>
				</div>
				<ClayLayout.Row>
					<ClayLayout.Col xl={6}>
						<h4>{Liferay.Language.get('top-providers')}</h4>
						<LoadingIndicator status={status.financialExposureTopProviders} error={error.financialExposureTopProviders}>
							<PieChart
								data={financialExposureTopProviders.data}
								dataKey="total"
								label={{
									content: <Label heading={financialExposureTopProviders.totalCount} subheading={Liferay.Language.get('total-claims')} />
								}}
								legend={{
									align:'right',
									content: <Legend datamap={financialExposureTopProviders.countMap} keyColumnLabel={Liferay.Language.get('provider-name')} columnLabel={Liferay.Language.get('total')} />,
									layout: 'vertical',
									verticalAlign: 'middle',
								}}
								tooltip={{
									datamap: financialExposureTopProviders.dataMap,
									dateRange: `${financialExposureTopProviders.startDate} - ${financialExposureTopProviders.endDate}`,
									formatter: chartCountFormatter
								}}
							/>
						</LoadingIndicator>
					</ClayLayout.Col>

					<ClayLayout.Col xl={6}>
						<h4>{Liferay.Language.get('top-savings-by-provider')}</h4>
						<LoadingIndicator status={status.financialExposureTopSavings} error={error.financialExposureTopSavings}>
							<PieChart
								data={financialExposureTopSavings.data}
								dataKey="total"
								label={{
									content: <Label heading={financialExposureTopSavings.totalCount} subheading={Liferay.Language.get('total-claims')} />
								}}
								legend={{
									align:'right',
									content: <Legend datamap={financialExposureTopSavings.countMap} keyColumnLabel={Liferay.Language.get('provider-name')} columnLabel={Liferay.Language.get('total')} />,
									layout: 'vertical',
									verticalAlign: 'middle',
								}}
								tooltip={{
									datamap: financialExposureTopSavings.savingsMap,
									dateRange: `${financialExposureTopSavings.startDate} - ${financialExposureTopSavings.endDate}`,
									formatter: chartCountFormatter
								}}
							/>
						</LoadingIndicator>
					</ClayLayout.Col>
				</ClayLayout.Row>
			</ClayTabs.TabPane>
		</ClayTabs.Content>
	);
}

export default DashboardContent;