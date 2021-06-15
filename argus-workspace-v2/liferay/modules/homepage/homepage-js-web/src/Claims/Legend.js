import React from 'react';
import ClayIcon from '@clayui/icon';
import { getClaimDetailsIcon } from '~/Utils/index';

const Legend = (props) => {
	const {
		datamap = [],
		payload,
	} = props;

	return (
		<ul className="recharts-custom-legend">
			{payload.map((entry, index) => (
				<li key={index} className={`recharts-home-legend-item legend-item-${index}`}>
					<div>
						<ClayIcon
							className={`case-claim-details__icon ${getClaimDetailsIcon(entry.value)}`}
							symbol={getClaimDetailsIcon(entry.value)}
						/>
						{`${entry.value} ${Liferay.Language.get('claims')}`}
					</div>
					<div className="text-right">
						{datamap[entry.value]}
					</div>
				</li>
			))}
		</ul>
	);
}

export default Legend;