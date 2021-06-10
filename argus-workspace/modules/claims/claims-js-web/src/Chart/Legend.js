import React from 'react';
import { Surface, Symbols } from 'charts-js-web';

const Legend = (props) => {

	const {
		keyColumnLabel = Liferay.Language.get('claim-amount'),
		columnLabel,
		datamap = {},
		iconSize,
		payload,
	} = props;

	return (
		<ul className="recharts-custom-legend">
			<li className="recharts-legend-item">
				<div>
					<h5 className="font-weight-bold">{keyColumnLabel}</h5>
				</div>
				<div className="text-right">
					<h5 className="font-weight-bold">{columnLabel}</h5>
				</div>
			</li>

			{payload.map((entry, index) => (
				<li key={index} className={`recharts-legend-item legend-item-${index}`}>
					<div className="text-truncate-inline align-items-center">
						<Surface
							width={iconSize}
							height={iconSize}
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
						
						<abbr className="recharts-legend-item-text lfr-portal-tooltip text-truncate" data-title={entry.value}>
							{entry.value}
						</abbr>
					</div>
					<div className="text-right font-weight-light">
						{datamap[entry.value]}
					</div>
				</li>
			))}
		</ul>
	);
}

export default Legend;