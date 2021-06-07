import React from 'react';

const TooltipContent = (props) => {
	const {
		active,
		formatter,
		texts = [],
		payload,
		valueKeys,
	} = props;

	if (active && payload) {
		return (
			<div className="recharts-custom-tooltip">
				{(payload.length > 0) &&
					<h5 className="recharts-tooltip-header">{payload[0].payload.receivedDate_mmm_dd_yyyy}</h5>
				}

				{payload.map((entry, index) =>
					<div key={index}>
						{texts.map((text, index) => (
							<div key={index} className="recharts-tooltip-label">
								<div>
									<span className="recharts-tooltip-label-text">{text}</span>
								</div>

								<div className="recharts-tooltip-label-value">
									<span>
										{entry.payload[valueKeys[index]]}
									</span>
								</div>
							</div>
						))}
					</div>
				)}
			</div>
		);
	}

	return null;
}

export default TooltipContent;