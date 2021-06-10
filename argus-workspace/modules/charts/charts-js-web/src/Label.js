import React from 'react';

const Label = (props) => {
	const {
		fill = 'white',
		fontSize = 14,
		value,
		viewBox,
		labelOffset = 30,
		labelYOffset = 0
	} = props;
	
	const { x, y } = viewBox;
	
	return (
		<text
			x={x + labelOffset} y={y + labelYOffset}
			fill={fill}
			filter="url(#bgColor)"
			fontSize={fontSize}
			fontWeight="300"
		>
			{value}
		</text>
	)
}

export default Label;