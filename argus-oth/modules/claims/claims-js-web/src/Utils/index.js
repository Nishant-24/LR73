import React from 'react';
import ClayIcon from '@clayui/icon';
import moment from 'moment';
import NumberFormat from 'react-number-format';
import { themeColors } from 'charts-js-web';

const spritemap = themeDisplay.getPathThemeImages() + '/clay/icons.svg';

const getTitle = (note) => {
	switch (note.type.toLowerCase()) {
		case 'note':
			return note.noteType;
		default:
			if (note.direction) {
				return Liferay.Util.sub(Liferay.Language.get('x-parentheses-x'), [note.direction, note.code]);
			} else {
				return note.code;
			}
	}
}

const getCallerKey = (code) => {
	code = code ? code.toLowerCase() : null;

	switch (code) {
		case 'email':
		case 'fax':
			return Liferay.Language.get('sender');
		default:
			return Liferay.Language.get('caller');
	}
}

const getCalleeKey = (code) => {
	code = code ? code.toLowerCase() : null;

	switch (code) {
		case 'email':
		case 'fax':
			return Liferay.Language.get('receiver');
		default:
			return Liferay.Language.get('callee');
	}
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

const getNoteIcon = (type, code) => {
	type = type ? type.toLowerCase() : null;
	code = code ? code.toLowerCase() : null;

	switch (type) {
		case 'call':
			if (code === 'call') {
				return 'phone';
			} else if (code === 'email') {
				return 'email';
			} else if (code === 'fax') {
				return 'fax';
			} else {
				return '';
			}
		default:
			return 'note';
	}
}

const getTaskIcon = (status) => {
	status = status ? status.toLowerCase() : null;

	switch (status) {
		case 'new':
			return 'circle-open';
		case 'in progress':
			return 'circle-semi';
		case 'completed':
			return 'circle-check-solid';
		default:
			return null;
	}
}

const getTaskDateMessage = (task) => {
	switch (task.taskStatus.toLowerCase()) {
		case 'new':
			return task.dueDate ? Liferay.Language.get('due-on') : Liferay.Language.get('started-on');
		case 'in progress':
			return Liferay.Language.get('due-on');
		case 'completed':
			return Liferay.Language.get('completed-on');
		default:
			return null;
	}
}

const getAuthorizationIcon = (code) => {
	code = code ? code.toLowerCase() : null;

	switch (code) {
		case pendingAuthStatusKey:
			return 'circle-semi';
		case deniedAuthStatusKey:
			return 'circle-minus';
		case approvedAuthStatusKey:
			return 'circle-check-solid';
		case cancelledAuthStatusKey:
			return 'circle-x-solid';
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

const sortCaret = (order) => {
	let symbol;
	let className;

	switch (order) {
		case 'asc':
			className = 'text-primary';
			symbol = 'order-arrow-up';
			break;
		case 'desc':
			className = 'text-primary';
			symbol = 'order-arrow-down';
			break;
		default:
			className = 'ml-1';
			symbol = 'order-arrow';
	}

	return (
		<ClayIcon
			className={className}
			spritemap={spritemap}
			symbol={symbol}
		/>
	)
}

const currencyFormat = (cell) => {
	if (!cell && (cell !== 0)) {
		return emDash;
	}

	return (
		<NumberFormat
			decimalScale={2}
			displayType={'text'}
			fixedDecimalScale={true}
			prefix={'$'}
			thousandSeparator={true}
			value={cell}
		/>
	)
}

const chartAgeFormatter = (number) => {
	return `${number} ${number === 1 ? Liferay.Language.get('day') : Liferay.Language.get('days')}`;
}

const chartCountFormatter = (number) => {
	return `${number} ${number === 1 ? Liferay.Language.get('claim') : Liferay.Language.get('claims')}`;
}

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

const percentageFormat = (cell) => {
	return (
		<NumberFormat
			decimalScale={0}
			displayType={'text'}
			suffix={'%'}
			thousandSeparator={true}
			value={cell}
		/>
	)
}

const getBookmarksIcon = (bookmarked) => {
	return bookmarked ? 'bookmark-solid' : 'bookmark-outline';
}

const getNowInUserTimeZone = async () => {
	let now = await fetch(`/o/user/now?p_auth=${Liferay.authToken}`).then(response => {
		if(response.ok){
			return response.json();
		}
	});

	return now;
}

const getClaimAmountRangeColor = (param) => {
	switch(param){
		case '$1 - $1K':
			return themeColors.purple;
		case '$1K - $5K':
			return themeColors.pink;
		case '$5K - $10K':
			return themeColors.orange;
		case '$10K - $20K':
			return themeColors.yellow;
		case '$20K - $50K':
			return themeColors.green;
		case '$50K - $100K':
			return themeColors.gold;
		case '$100K - $500K':
			return themeColors.cyan;
	}
}

const approvedAuthStatusKey = '068:waiting';

const cancelledAuthStatusKey = '068:cancelled';

const deniedAuthStatusKey = '068:denied';

const emDash = '\u2014';

const pendingAuthStatusKey = '068:pend';

const MM_DD_YYYY = "MM/DD/YYYY";

const MMM_DD_YYYY = "MMM DD, YYYY";

const MMM_DD_YYYY_at_h_mm_aa = MMM_DD_YYYY + " [@] h:mm a";

const dateStringFormat = 'ddd MMM DD HH:mm:ss zzz YYYY';

const getDateRangeFormat = (range) => {
	const dateRange = range.split(' - ');
	const startDate = moment(dateRange[0], MMM_DD_YYYY).format('L');
	const endDate = moment(dateRange[1], MMM_DD_YYYY).format('L');

	return {
		startDate: startDate,
		endDate: endDate,
	}
}

export {
	approvedAuthStatusKey,
	cancelledAuthStatusKey,
	chartAgeFormatter,
	chartCountFormatter,
	chartCurrencyFormatter,
	currencyFormat,
	dateStringFormat,
	deniedAuthStatusKey,
	emDash,
	getAuthorizationIcon,
	getBookmarksIcon,
	getCalleeKey,
	getCallerKey,
	getCaseIcon,
	getClaimAmountRangeColor,
	getClaimDetailsIcon,
	getDateRangeFormat,
	getNoteIcon,
	getNowInUserTimeZone,
	getTaskDateMessage,
	getTaskIcon,
	getTitle,
	MM_DD_YYYY,
	MMM_DD_YYYY,
	MMM_DD_YYYY_at_h_mm_aa,
	pendingAuthStatusKey,
	percentageFormat,
	sortCaret,
}