import React from 'react';

const TooltipContent = (props) => {
	const {
		active,
		dateKey,
		formatter,
		payload,
		text,
		valueKey,
	} = props;

	if (active && payload) {
		return (
			<div className="recharts-custom-tooltip">
				<h5 className="recharts-tooltip-header">{payload[0].payload[dateKey]}</h5>
				
				{payload.map((entry, index) => (
					<div key={index} className="recharts-tooltip-label">
						<div>
							<span className="recharts-tooltip-label-text">{text}</span>
						</div>

						<div className="recharts-tooltip-label-value">
							<span>
								{entry.payload[valueKey]}
							</span>
						</div>
					</div>
				))}
			</div>
		);
	}

	return null;
}

export default TooltipContent;