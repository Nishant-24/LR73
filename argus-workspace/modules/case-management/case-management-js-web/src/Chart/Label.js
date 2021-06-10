import React from 'react';

const Label = (props) => {
	const {
		dy,
		dx,
		fill,
		fontSize,
		viewBox
	} = props;
	const x = viewBox.width + viewBox.x + 20;
	const y = viewBox.y - 6;
	return (
		<text
			x={x} y={y}
			dy={dy}
			dx={dx}
			fill={fill}
			filter="url(#bgColor)"
			fontSize={fontSize || 10}
			fontWeight="300">
			{props.value}
		</text>
	)
}

export default Label;