import React from 'react';
import { Surface, Symbols } from 'charts-js-web';

const TooltipContent = (props) => {
	const {
		active,
		payload = []
	} = props;
	
	if (active && payload) {
		return (
			<div className="recharts-custom-tooltip">
				{(payload.length > 0) &&
					<h5 className="recharts-tooltip-header"><span>{ payload[0].payload.receivedDate_mmm_dd_yyyy }</span></h5>
				}

				<ul className="recharts-custom-legend">
					{payload.reverse().map((entry, index) => (
						<li key={index} className="recharts-tooltip-item">
							<div>
								<Surface
									width={10}
									height={10}
									viewBox={{ x: 0, y: 0, width: 32, height: 32 }}
									>
										<Symbols
											fill={entry.color}
											cx={16}
											cy={16}
											size={32}
											sizeType="diameter"
											type="circle"
										/>
								</Surface>
								{`${entry.name}`}
							</div>

							<span>{entry.payload.countMap[entry.name]}</span>
							<span>{entry.payload.valueMap[entry.name]}</span>
						</li>
					))}

					{(payload.length > 0) &&
						<React.Fragment>
							<hr />
							<li className="recharts-tooltip-item">
								<div>
									<span>{Liferay.Language.get('total')}</span>
								</div>
								<span>{payload[0].payload.count_formatted}</span>
								<span>{payload[0].payload.total_formatted}</span>
							</li>
						</React.Fragment>
					}
				</ul>
			</div>
		)
	}

	return null;
}

export default TooltipContent;