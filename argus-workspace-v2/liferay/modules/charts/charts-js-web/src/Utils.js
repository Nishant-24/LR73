const getCSSVariable = (property) => {
	return getComputedStyle(document.documentElement).getPropertyValue(property);
}

const themeColors = {
	blue: getCSSVariable('--blue'),
	indigo: getCSSVariable('--indigo'),
	purple: getCSSVariable('--purple'),
	pink: getCSSVariable('--pink'),
	red: getCSSVariable('--red'),
	orange: getCSSVariable('--orange'),
	yellow: getCSSVariable('--yellow'),
	green: getCSSVariable('--green'),
	teal: getCSSVariable('--teal'),
	cyan: getCSSVariable('--cyan'),
	gold: getCSSVariable('--gold'),
	primary: getCSSVariable('--primary'),
	secondary: getCSSVariable('--secondary'),
	success: getCSSVariable('--success'),
	info: getCSSVariable('--info'),
	warning: getCSSVariable('--warning'),
	danger: getCSSVariable('--danger'),
	gray100: getCSSVariable('--gray-100'),
	gray200: getCSSVariable('--gray-200'),
	gray300: getCSSVariable('--gray-300'),
	gray400: getCSSVariable('--gray-400'),
	gray500: getCSSVariable('--gray-500'),
	gray600: getCSSVariable('--gray-600'),
	gray700: getCSSVariable('--gray-700'),
	gray800: getCSSVariable('--gray-800'),
	gray900: getCSSVariable('--gray-900'),
}

const gradientOffset = (data, dataKeys, ref) => {
	const dataKey = dataKeys[0];
	const dataMax = Math.max(...data.map(i => i[dataKey]));
	const dataMin = 0;

	if (dataMax <= ref || dataMin >= ref) {
		return 0;
	}

	return (1 - ref / dataMax).toFixed(2);
}

export {
	getCSSVariable,
	gradientOffset,
	themeColors,
}