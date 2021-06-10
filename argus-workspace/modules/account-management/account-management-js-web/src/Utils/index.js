import { themeColors } from 'charts-js-web';

const colors = [themeColors.pink, themeColors.teal];

const getRecentSlasIcon = (status) => {
	status = status ? status.toLowerCase() : null;

	switch (status) {
		case 'pend':
		case 'in process':
			return 'circle-semi';
		case 'open':
			return 'circle-open';
		case 'adjusted':
		case 'approved':
		case 'processed':
			return 'circle-check-solid';
		case 'denied':
			return 'circle-x-solid';
		case 'closed':
			return 'circle-minus';
		case 'error':
			return 'exclamation-full';
		default:
			return null;
	}
}

const symbol = (avg, goal) => {
	return avg <= goal ? 'circle-check-solid' : 'circle-x-solid';
}

export {
	colors,
	getRecentSlasIcon,
	symbol,
}