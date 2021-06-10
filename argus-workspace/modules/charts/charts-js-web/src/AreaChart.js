import React from 'react';
import { AreaChart, Area, XAxis, YAxis, Legend, CartesianGrid, ReferenceLine, Tooltip, ResponsiveContainer } from 'recharts';
import Label from './Label';
import { gradientOffset, themeColors } from './Utils';

const AreaRechart = (props) => {

	const {
		colors = [
			themeColors.warning,
			themeColors.teal,
			themeColors.info,
		],
		data = [],
		dataKeys = [],
		fillByValue,
		gradient = false,
		height,
		legend,
		referenceLine = {},
		tooltip,
		width = '100%',
		margin,
	} = props;

	const randomString = Liferay.Util.randomInt().toString(36);

	const xAxis = Object.assign({}, {
		interval: 'preserveStartEnd',
		tick: {
			fontSize: 12
		},
	} , props.xAxis);
	
	return (
		<ResponsiveContainer width={width} height={height}>
			<AreaChart
				data={data}
				margin={margin}
			>
				<defs>
					<filter id="bgColor" width="120%" height="190%" x="-10%" y="-50%" >
						<feFlood floodColor="#000000"/>
						<feGaussianBlur stdDeviation="2"/>
						<feComponentTransfer>
						<feFuncA type="table" tableValues="0 0 0 1"/>
						</feComponentTransfer>
						<feComponentTransfer>
						<feFuncA type="table" tableValues="0 1 1 1 1 1 1 1"/>
						</feComponentTransfer>
						<feComposite operator="over" in="SourceGraphic"/>
					</filter>

					{gradient &&
						<linearGradient id="gradient" x1="0" y1="0" x2="100%" y2="0">
							<stop offset="0%" stopColor={themeColors.green} />
							<stop offset="33%" stopColor={themeColors.gold} />
							<stop offset="66%" stopColor={themeColors.yellow} />
							<stop offset="100%" stopColor={themeColors.orange} />
						</linearGradient>
					}

					{fillByValue &&
						<linearGradient id={`splitColor_${randomString}`} x1="0" y1="0" x2="0" y2="1">
							{colors.map((color, index) => 
								<stop key={index} offset={gradientOffset(data, dataKeys, fillByValue)} stopColor={color} stopOpacity={1} />
							)}
						</linearGradient>
					}
				</defs>

				<CartesianGrid
					fill="#e8eced"
					horizontal={false}
					vertical={false}
				/>

				<XAxis {...xAxis} />

				<YAxis hide={true} padding={{ top: 20 }} />

				{legend &&
					<Legend {...legend} />
				}

				{dataKeys.map((dataKey, index) => (
					<Area
						activeDot={{ fill: themeColors.gray800 }}
						dataKey={dataKey}
						fill={gradient ? 'url(#gradient)' : fillByValue ? `url(#splitColor_${randomString})` : colors[index]}
						fillOpacity="1"
						key={index}
						stackId="1"
						stroke="none"
						type="monotone"
					/>
				))}

				<Tooltip {...tooltip} cursor={{ stroke: 'rgba(255, 255, 255, 0.4)', strokeWidth: 2 }} />

				{referenceLine.x &&
					<ReferenceLine
						x={referenceLine.x.value}
						label={
							<Label
								value={referenceLine.x.label}
								labelOffset={referenceLine.x.labelOffset}
								labelYOffset={referenceLine.x.labelYOffset}
							/>
						}
						stroke="black"
					/>
				}

				{referenceLine.y &&
					<ReferenceLine
						y={referenceLine.y.value}
						label={
							<Label
								value={referenceLine.y.label}
								labelOffset={referenceLine.y.labelOffset}
							/>
						}
						stroke="black"
					/>
				}
			</AreaChart>
		</ResponsiveContainer>
	)
}

export default AreaRechart;