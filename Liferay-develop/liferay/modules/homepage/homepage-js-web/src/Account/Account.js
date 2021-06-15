import React, { useEffect } from 'react';
import ClayIcon from '@clayui/icon';
import ClayNav from '@clayui/nav';
import { useDispatch, useSelector } from 'react-redux';
import { getAccountStats, getLayouts } from './AccountSlice';
import { getRecentSlasIcon } from '~/Utils/index';
import LoadingIndicator from '~/LoadingIndicator/LoadingIndicator';

const Account = () => {
	const dispatch = useDispatch();
	const chart = useSelector((state) => state.account.chart);
	const layouts = useSelector((state) => state.layouts.data.sla);
	const status = useSelector((state) => state.account.status);
	const error = useSelector((state) => state.account.error);

	useEffect(() => {
		dispatch(getAccountStats());
	}, []);

	const calcRepriced = (x, y) => {
		if (y === 0) {
			return 0;
		} else {
			return (x / y) * 100;
		}
	};

	return (
		<LoadingIndicator status={status} error={error}>
			<div className="account-home">
				{layouts[0] &&
					<div className="card-header">
						<div className="account-home__header">
							<a href={layouts[0].layoutSetFriendlyURL}>
								<ClayIcon
									className="claim-home__icon"
									symbol="account"
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

				<div className="card-body account-home__recent-savings">
					<h4>{Liferay.Language.get('recent-savings')}</h4>
					<h5 className="mb-3">{Liferay.Language.get('past-4-weeks')}</h5>
					<h1 className="d-inline mr-2">{`${chart.savingsPercent}%`}</h1>
					<h3 className="d-inline">{Liferay.Language.get('savings')}</h3>
					<h5 className="mb-1 mt-3">{`${chart.chargedAmount_formatted} ${Liferay.Language.get('charged')}`}</h5>
					<div className="progress mb-2">
						<div
							aria-valuemin="0"
							aria-valuemax="100"
							aria-valuenow="100"
							className="progress-bar"
							role="progressbar"
							style={{ width: '100%' }}
						/>
					</div>
					<h5 className="mb-1 mt-3">{`${chart.repricedAmount_formatted} ${Liferay.Language.get('repriced')}`}</h5>
					<div className="progress">
						<div
							aria-valuemin="0"
							aria-valuemax="100"
							aria-valuenow={calcRepriced(chart.repricedAmount, chart.chargedAmount)}
							className="progress-bar"
							role="progressbar"
							style={{ width: `${calcRepriced(chart.repricedAmount, chart.chargedAmount)}%` }}
						/>
					</div>
				</div>

				<div className="card-body">
					<h4>{Liferay.Language.get('recent-slas')}</h4>
					<h5 className="mb-3">{Liferay.Language.get('past-4-weeks')}</h5>
					<ul className="recharts-custom-legend">
						<li className="recharts-home-legend-item">
							<div>
								<ClayIcon
									className={`case-claim-details__icon ${getRecentSlasIcon((chart.avgDownTime <= chart.downTimeGoal) ? 'processed' : 'denied')}`}
									symbol={getRecentSlasIcon((chart.avgDownTime <= chart.downTimeGoal) ? 'processed' : 'denied')}
								/>
								<span>
									{Liferay.Language.get('average-down-time')}
								</span>
							</div>
							<div className="text-right">
								{chart.avgDownTime_formatted}
							</div>
						</li>
						<li className="recharts-home-legend-item">
							<div>
								<ClayIcon
									className={`case-claim-details__icon ${getRecentSlasIcon((chart.avgSpeedOfAnswer <= chart.speedOfAnswerGoal) ? 'processed' : 'denied')}`}
									symbol={getRecentSlasIcon((chart.avgSpeedOfAnswer <= chart.speedOfAnswerGoal) ? 'processed' : 'denied')}
								/>
								<span>
									{Liferay.Language.get('average-speed-of-answer')}
								</span>
							</div>
							<div className="text-right">
								{chart.avgSpeedOfAnswer_formatted}
							</div>
						</li>
						<li className="recharts-home-legend-item">
							<div>
								<ClayIcon
									className={`case-claim-details__icon ${getRecentSlasIcon((chart.abandonmentRate <= chart.abandonmentRateGoal) ? 'processed' : 'denied')}`}
									symbol={getRecentSlasIcon((chart.abandonmentRate <= chart.abandonmentRateGoal) ? 'processed' : 'denied')}
								/>
								<span>
									{Liferay.Language.get('abandonment-rate')}
								</span>
							</div>
							<div className="text-right">
								{chart.abandonmentRate_formatted}
							</div>
						</li>
						<li className="recharts-home-legend-item">
							<div>
								<ClayIcon
									className={`case-claim-details__icon ${getRecentSlasIcon((chart.claimsTurnaroundTime <= chart.claimsTurnaroundGoal) ? 'processed' : 'denied')}`}
									symbol={getRecentSlasIcon((chart.claimsTurnaroundTime <= chart.claimsTurnaroundGoal) ? 'processed' : 'denied')}
								/>
								<span>
									{Liferay.Language.get('claims-turnaround-time')}
								</span>
							</div>
							<div className="text-right">
								{chart.claimsTurnaroundTime_formatted}
							</div>
						</li>
					</ul>
				</div>
			</div>
		</LoadingIndicator>
	)
}

export default Account;