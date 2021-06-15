import React from 'react';
import { themeColors } from './Utils';
import { PieChart, Pie, Cell, Legend, Label, ResponsiveContainer, Surface, Symbols, Tooltip } from 'recharts';

const TooltipContent = (props) => {
	const {
		active,
		addtlDatamap,
		datamap,
		dateRange,
		formatter,
		payload,
	} = props;

	if (active) {
		return (
			<div className="recharts-custom-tooltip">
				{dateRange &&
					<h5 className="recharts-tooltip-header">{dateRange}</h5>
				}
				
				{payload.map((entry, index) => (
					<div key={index} className="recharts-tooltip-label">
						<div>
							<Surface
								width={14}
								height={14}
								viewBox={{ x: 0, y: 0, width: 32, height: 32 }}
							>
								<Symbols
									fill={entry.payload.fill}
									cx={16}
									cy={16}
									size={32}
									sizeType="diameter"
									type="circle"
								/>
							</Surface>
							<span className="recharts-tooltip-label-text">{entry.name}</span>
						</div>

						<div className="recharts-tooltip-label-value">
							<span>
								{formatter ? formatter(entry.value) : entry.value}
							</span>

							{datamap &&
								<span>{datamap[entry.name]}</span>
							}

							{addtlDatamap &&
								<span>{addtlDatamap[entry.name]}</span>
							}
						</div>
					</div>
				))}
			</div>
		);
	}

	return null;
}

const PieRechart = (props) => {
	const {
		colors = [
			themeColors.purple,
			themeColors.pink,
			themeColors.orange,
			themeColors.yellow,
			themeColors.gold,
			themeColors.green,
			themeColors.cyan
		],
		data = [],
		dataKey,
		height = 320,
		innerRadius = 95,
		label,
		legend,
		outerRadius = 135,
		tooltip,
		width = '100%',
	} = props;

	return (
		<ResponsiveContainer width={width} height={height}>
			<PieChart>
				<Pie
					data={data}
					dataKey={dataKey}
					innerRadius={innerRadius}
					outerRadius={outerRadius}
					stroke="none"
				>
					{label &&
						<Label width={120} position="center" {...label} />
					}

					{data.map((entry, index) =>
						<Cell
							key={index}
							fill={colors[index % colors.length]}
						/>
					)}
				</Pie>

				<Legend {...legend}/>

				<Tooltip content={<TooltipContent {...tooltip} />} />

			</PieChart>
		</ResponsiveContainer>
	)
}

export default PieRechart;