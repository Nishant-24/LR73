import React from 'react';
import ClayIcon from '@clayui/icon';
import moment from 'moment';
import { customFilter, Comparator, FILTER_TYPES } from 'react-bootstrap-table2-filter';
//import isSameDay from 'react-dates/lib/utils/isSameDay';
import DateDisplay from '~/Date/DateDisplay';
import { currencyFormat, dateStringFormat, emDash, getCaseIcon, MMM_DD_YYYY, percentageFormat, sortCaret } from '~/Utils/index';

const spritemap = themeDisplay.getPathThemeImages() + '/argus/icons.svg';

let caseStartDateFilter, caseEndDateFilter, memberDOBFilter, memberNameFilter, memberNumberFilter, primaryCodeFilter, primaryFacilityFilter, statusFilter;

const getColumns = (status) => {
	const showPaidAmount = status === 'Closed' ? true : false;

	return [
		{
			classes: 'table-cell-ws-nowrap',
			dataField: 'receivedDate',
			formatter: (cell, row) => {
				return cell ? (
					<DateDisplay date={cell} />
				) : emDash;
			},
			headerAttrs: {
				tabIndex: -1,
			},
			headerClasses: 'table-cell-ws-nowrap',
			sort: true,
			sortCaret: sortCaret,
			sortFunc: (a, b, order, dataField) => {
				if (order === 'asc') {
					return Date.parse(a) - Date.parse(b);
				}
				else if (order === 'desc') {
					return  Date.parse(b) - Date.parse(a);
				}
			},
			text: Liferay.Language.get('received')
		},
		{
			classes: 'table-cell-ws-nowrap',
			dataField: 'serviceDate',
			formatter: (cell, row) => {
				return cell ? (
					<DateDisplay date={cell} />
				) : emDash;
			},
			headerAttrs: {
				tabIndex: -1,
			},
			headerClasses: 'table-cell-ws-nowrap',
			sort: true,
			sortCaret: sortCaret,
			sortFunc: (a, b, order, dataField) => {
				if (order === 'asc') {
					return Date.parse(a) - Date.parse(b);
				}
				else if (order === 'desc') {
					return  Date.parse(b) - Date.parse(a);
				}
			},
			text: Liferay.Language.get('serviced')
		},
		{
			classes: 'table-cell-expand',
			dataField: 'memberName',
			filter: customFilter({
				type: FILTER_TYPES.MULTISELECT,
			}),
			filterRenderer: (onFilter, column) => {
				memberNameFilter = onFilter;
				return null;
			},
			formatter: (cell, row) => {
				return (
					<React.Fragment>
						<div>{cell || emDash}</div>
						<small>{row.memberNumber || emDash}</small>
					</React.Fragment>
				);
			},
			headerAttrs: {
				tabIndex: -1,
			},
			headerClasses: 'table-cell-expand',
			sort: true,
			sortCaret: sortCaret,
			text: Liferay.Language.get('member-name')
		},
		{
			classes: 'table-cell-expand table-cell-expand-smaller',
			dataField: 'providerName',
			formatter: (cell) => (cell || emDash),
			headerAttrs: {
				tabIndex: -1,
			},
			headerClasses: 'table-cell-expand table-cell-expand-smaller',
			sort: true,
			sortCaret: sortCaret,
			text: Liferay.Language.get('provider-name')
		},
		{
			classes: 'table-cell-expand',
			dataField: 'billType',
			formatter: (cell) => (cell || emDash),
			headerAttrs: {
				tabIndex: -1,
			},
			headerClasses: 'table-cell-ws-nowrap table-cell-expand',
			sort: true,
			sortCaret: sortCaret,
			text: Liferay.Language.get('bill-type')
		},
		{
			classes: 'table-cell-expand',
			dataField: 'primaryDiagnosis',
			filter: customFilter({
				type: FILTER_TYPES.MULTISELECT,
			}),
			filterRenderer: (onFilter, column) => {
				primaryCodeFilter = onFilter;
				return null;
			},
			formatter: (cell) => (cell || emDash),
			headerAttrs: {
				tabIndex: -1,
			},
			headerClasses: 'table-cell-ws-nowrap table-cell-expand',
			sort: true,
			sortCaret: sortCaret,
			text: Liferay.Language.get('primary-diagnosis')
		},
		{
			classes: 'table-cell-ws-nowrap text-right',
			dataField: 'chargedAmount',
			formatter: currencyFormat,
			headerAttrs: {
				tabIndex: -1,
			},
			headerClasses: 'table-cell-ws-nowrap text-right',
			sort: true,
			sortCaret: sortCaret,
			text: Liferay.Language.get('charged-amount')
		},
		{
			classes: 'table-cell-ws-nowrap text-right',
			dataField: showPaidAmount ? 'paidAmount' : 'repricedAmount',
			formatter: currencyFormat,
			headerAttrs: {
				tabIndex: -1,
			},
			headerClasses: 'table-cell-ws-nowrap text-right',
			sort: true,
			sortCaret: sortCaret,
			text: showPaidAmount ? Liferay.Language.get('paid-amount') : Liferay.Language.get('repriced-amount')
		},
		{
			classes: 'table-cell-ws-nowrap text-right',
			dataField: 'savingsPercent',
			formatter: percentageFormat,
			headerAttrs: {
				tabIndex: -1,
			},
			headerClasses: 'table-cell-ws-nowrap text-right',
			sort: true,
			sortCaret: sortCaret,
			text: Liferay.Language.get('savings-percent')
		},
		{
			classes: 'table-cell-ws-nowrap',
			dataField: 'caseId',
			formatter: (cell, row) => {
				return cell ? (
					<ClayIcon
						className="text-primary fs-5 mt-1"
						symbol="angle-right"
					/>
				) : null;
			},
			headerAttrs: {
				tabIndex: -1,
			},
			headerClasses: 'table-cell-ws-nowrap',
			sort: false,
			text: ''
		},
	];
}

/*const getFilterFunction = (key) => {
	switch (key) {
		case 'caseEndDate':
			return caseEndDateFilter;
		case 'caseStartDate':
			return caseStartDateFilter;
		case 'member.memberDOB':
			return memberDOBFilter;
		case 'member.memberName':
			return memberNameFilter;
		case 'member.memberNumber':
			return memberNumberFilter;
		case 'primaryCode':
			return primaryCodeFilter;
		case 'primaryFacility':
			return primaryFacilityFilter;
		case 'status':
			return statusFilter;
		default:
			return null;
	}
}

const clearFilters = () => {
	caseStartDateFilter();
	caseEndDateFilter();
	memberDOBFilter();
	memberNameFilter();
	memberNumberFilter();
	primaryCodeFilter();
	primaryFacilityFilter();
	statusFilter();
}

const isInRange = (array, value) => {
	return !!array.find(item => {
		item = item.split(' - ');
		const min = moment.utc(item[0], MMM_DD_YYYY).startOf('day');
		const max = moment.utc(item[1], MMM_DD_YYYY).endOf('day');
		if (!value) {
			return false;
		}
		return moment.utc(value).isSameOrAfter(min) && moment.utc(value).isSameOrBefore(max);
	});
}
const isInArray = (array, value) => {
	return !!array.find(item => {
		const itemMoment = moment.utc(item, MMM_DD_YYYY);
		const valueMoment = moment.utc(value);
		return isSameDay(itemMoment, valueMoment);
	});
}*/

const defaultSorted = [{
	dataField: 'receivedDate',
	order: 'desc'
}];

export {
	//clearFilters,
	getColumns,
	defaultSorted,
	//getFilterFunction,
};
