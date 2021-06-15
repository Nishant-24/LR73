import React from 'react';
import ClayIcon from '@clayui/icon';
import { getCaseIcon } from '~/Utils/index';

const HomeLegend = (props) => {
	const spritemap = themeDisplay.getPathThemeImages() + '/argus/icons.svg';

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
							className={`case-claim-details__icon ${getCaseIcon(entry.value)}`}
							spritemap={spritemap}
							symbol={getCaseIcon(entry.value)}
						/>
						{`${entry.value} ${Liferay.Language.get('cases')}`}
					</div>
					<div className="text-right">
						{`${datamap[entry.value]} ${Liferay.Language.get('cases')}`}
					</div>
				</li>
			))}
		</ul>
	);
}

export default HomeLegend;