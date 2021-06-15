import React from 'react';

const Label = (props) => {
	const {cx, cy} = props.viewBox;
	
	return (
		<text
			className="recharts-text recharts-label"
			dominantBaseline="central"
			fill={getComputedStyle(document.documentElement).getPropertyValue('--dark')}
			textAnchor="middle"
			x={cx}
			y={cy}
		>
			<tspan alignmentBaseline="middle" fontSize="36" x={cx} y={cy - 5}>
				{props.heading}
			</tspan>

			<tspan fontWeight="bold" x={cx} y={cy + 25}>
				{props.subheading}
			</tspan>
		</text>
	)
}

export default Label;
