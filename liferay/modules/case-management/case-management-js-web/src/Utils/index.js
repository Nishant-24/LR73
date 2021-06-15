import React from 'react';
import ClayIcon from '@clayui/icon';
import NumberFormat from 'react-number-format';

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

const percentageFormat = (cell) => {
	return (
		<NumberFormat
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

const approvedAuthStatusKey = '068:waiting';

const cancelledAuthStatusKey = '068:cancelled';

const deniedAuthStatusKey = '068:denied';

const emDash = '\u2014';

const pendingAuthStatusKey = '068:pend';

const MMM_DD_YYYY = "MMM DD, YYYY";

const MMM_DD_YYYY_at_h_mm_aa = MMM_DD_YYYY + " [@] h:mm a";

const dateStringFormat = 'ddd MMM DD HH:mm:ss zzz YYYY';

export {
	approvedAuthStatusKey,
	cancelledAuthStatusKey,
	currencyFormat,
	dateStringFormat,
	deniedAuthStatusKey,
	emDash,
	getAuthorizationIcon,
	getCalleeKey,
	getCallerKey,
	getCaseIcon,
	getClaimDetailsIcon,
	getNoteIcon,
	getNowInUserTimeZone,
	getTaskDateMessage,
	getTaskIcon,
	getTitle,
	MMM_DD_YYYY,
	MMM_DD_YYYY_at_h_mm_aa,
	pendingAuthStatusKey,
	percentageFormat,
	sortCaret,
	getBookmarksIcon
}