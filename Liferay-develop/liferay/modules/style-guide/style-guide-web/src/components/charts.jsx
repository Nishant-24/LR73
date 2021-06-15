import React from 'react';
import ClayLayout from '@clayui/layout';
import { AreaChart, BarChart, PieChart } from 'charts-js-web';

const Charts = () => {
	const areaChartData = [
		{ name: 'Page A', uv: 4000, pv: 2400, amt: 2400 },
		{ name: 'Page B', uv: 3000, pv: 1398, amt: 2210 },
		{ name: 'Page C', uv: 2000, pv: 9800, amt: 2290 },
		{ name: 'Page D', uv: 2780, pv: 3908, amt: 2000 },
		{ name: 'Page E', uv: 1890, pv: 4800, amt: 2181 },
		{ name: 'Page F', uv: 2390, pv: 3800, amt: 2500 },
		{ name: 'Page G', uv: 3490, pv: 4300, amt: 2100 },
	];

	const barChartData = [
		{ name: 'Page A', uv: 4000, pv: 2400, amt: 2400 },
		{ name: 'Page B', uv: 3000, pv: 1398, amt: 2210 },
		{ name: 'Page C', uv: 2000, pv: 9800, amt: 2290 },
		{ name: 'Page D', uv: 2780, pv: 3908, amt: 2000 },
		{ name: 'Page E', uv: 1890, pv: 4800, amt: 2181 },
		{ name: 'Page F', uv: 2390, pv: 3800, amt: 2500 },
		{ name: 'Page G', uv: 3490, pv: 4300, amt: 2100 },
	];

	const pieChartData = [
		{ name: 'Group A', value: 400 },
		{ name: 'Group B', value: 300 },
		{ name: 'Group C', value: 300 },
		{ name: 'Group D', value: 200 },
	];

	return (
		<ClayLayout.Sheet className="mb-5">
			<ClayLayout.SheetHeader>
				<h3 className="sheet-title">Charts</h3>
			</ClayLayout.SheetHeader>
			<ClayLayout.SheetSection>
				<ClayLayout.Row>
					<ClayLayout.Col size={4}>
						<h4 className="sheet-subtitle">Area</h4>
						<div className="sheet-text">
							<AreaChart
								data={areaChartData}
								dataKeys={['uv', 'pv']}
								height={300}
								xAxis={{ dataKey: 'name' }}
							/>

							<AreaChart
								data={areaChartData}
								dataKeys={['amt']}
								gradient={true}
								height={300}
								referenceLine={{
									x: { value: 'Page C' },
									y: { value: 1000, label: '1000 (Avg.)' }
								}}
								xAxis={{ dataKey: 'name' }}
							/>
						</div>
					</ClayLayout.Col>

					<ClayLayout.Col size={4}>
						<h4 className="sheet-subtitle">Bar</h4>
						<div className="sheet-text">
							<BarChart
								data={barChartData}
								dataKeys={['uv', 'pv']}
								height={300}
								xAxis={{ dataKey: 'name' }}
							/>

							<BarChart
								data={barChartData}
								dataKeys={['amt']}
								height={300}
								referenceLine={{
									y: { value: 1000, label: '1000 (Avg.)' }
								}}
								xAxis={{ dataKey: 'name' }}
							/>
						</div>
					</ClayLayout.Col>

					<ClayLayout.Col size={4}>
						<h4 className="sheet-subtitle">Pie</h4>
						<div className="sheet-text">
							<PieChart
								data={pieChartData}
								dataKey="value"
								label="13M Financial Exposure"
								legend={{
									iconType: 'circle',
								}}
							/>

							<PieChart
								data={pieChartData}
								dataKey="value"
								label="955 Total Claims"
								legend={{
									align: 'right',
									iconType: 'circle',
									layout: 'vertical',
									verticalAlign: 'middle',
								}}
							/>
						</div>
					</ClayLayout.Col>
				</ClayLayout.Row>
						
			</ClayLayout.SheetSection>
		</ClayLayout.Sheet>
	);
};

export default Charts;