import React from 'react';
import moment from 'moment';
import { MMM_DD_YYYY } from '~/Utils/index';

const DateDisplay = (props) => {

	const {
		date,
		format = MMM_DD_YYYY,
		timeZone,
	} = props;

	const getTimeZoneDisplay = () => {
		if (!timeZone) {
			return '';
		}

		return ` ${timeZone}`;
	};

	return `${moment.utc(date).format(format)}${getTimeZoneDisplay()}`;
};

export default DateDisplay;

