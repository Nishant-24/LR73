import React, { useEffect } from 'react';
import ClayIcon from '@clayui/icon';
import ClayNav from '@clayui/nav';
import { BarChart } from 'charts-js-web';
import { useDispatch, useSelector } from 'react-redux';
import { getChartRecentCases } from './CasesSlice';
import Legend from './Legend';
import Label from './Label';
import LoadingIndicator from '~/LoadingIndicator/LoadingIndicator';

const Cases = () => {
	const dispatch = useDispatch();
	const chart = useSelector((state) => state.cases.chart);
	const layouts = useSelector((state) => state.layouts.data.cases);
	const status = useSelector((state) => state.cases.status);
	const error = useSelector((state) => state.cases.error);

	useEffect(() => {
		dispatch(getChartRecentCases());
	}, []);

	return (
		<LoadingIndicator status={status} error={error}>
			<div className="case-home">
				{layouts[0] &&
					<div className="card-header">
						<div className="case-home__header">
							<a href={layouts[0].layoutSetFriendlyURL}>
								<ClayIcon
									className="case-home__icon"
									symbol="cases"
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
							{layouts.map((layout, index) => (
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
					<h4>{Liferay.Language.get('recent-cases')}</h4>
					<h5>{Liferay.Language.get('past-4-weeks')}</h5>
					<BarChart
						data={chart.data}
						dataKeys={['In Process', 'Closed']}
						height={450}
						legend={{
							content: <Legend datamap={chart.caseTotals} />,
							layout: 'vertical',
							verticalAlign: 'bottom',
							wrapperStyle: {
								bottom: '-1rem',
								left: 0,
								width: '100%'
							}
						}}
						referenceLine={{
							y: { value: chart.average, label: <Label dx='-300' dy='10' fill='#FFFFFF' fontSize='14' value={`${chart.average} ${Liferay.Language.get('cases-avg')}`} viewBox='0' /> }
						}}
						showTooltip={false}
						xAxis={{ dataKey: 'name', tickLine: false }}
					/>
				</div>
			</div>
		</LoadingIndicator>
	)
}

export default Cases;