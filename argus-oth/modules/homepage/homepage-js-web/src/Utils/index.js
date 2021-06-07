const chartCurrencyFormatter = (number) => {
	if (!number) {
		return emDash;
	}

	return new Intl.NumberFormat('en', {
		style: 'currency',
		currency: 'USD',
		notation: 'compact'
	}).format(number);
}

const getCaseIcon = (status) => {
	status = status ? status.toLowerCase() : null;

	switch (status) {
		case 'in process':
			return 'circle-semi';
		case 'processed':
			return 'circle-check-solid';
		case 'closed':
			return 'circle-minus';
		default:
			return null;
	}
}

const getClaimDetailsIcon = (status) => {
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
		case 'closed':
			return 'circle-minus';
		case 'error':
			return 'exclamation-full';
		default:
			return null;
	}
}

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

const ACCOUNT_MANAGEMENT_FURL = '/account-management';
const CASES_FURL = '/cases';
const CLAIMS_FURL = '/claims';

export {
	ACCOUNT_MANAGEMENT_FURL,
	CASES_FURL,
	CLAIMS_FURL,
	chartCurrencyFormatter,
	getCaseIcon,
	getClaimDetailsIcon,
	getRecentSlasIcon,
}