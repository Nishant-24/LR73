import React from 'react';
import ClayIcon from '@clayui/icon';
import moment from 'moment';
import { customFilter, Comparator, FILTER_TYPES } from 'react-bootstrap-table2-filter';
import isSameDay from 'react-dates/lib/utils/isSameDay';
import DateDisplay from '~/Date/DateDisplay';
import { currencyFormat, dateStringFormat, emDash, getCaseIcon, MMM_DD_YYYY, percentageFormat, sortCaret } from '~/Utils/index';

const spritemap = themeDisplay.getPathThemeImages() + '/argus/icons.svg';

let caseStartDateFilter, caseEndDateFilter, memberDOBFilter, memberNameFilter, memberNumberFilter, primaryCodeFilter, primaryFacilityFilter, statusFilter;

const columns = [
	{
		classes: 'table-cell-ws-nowrap',
		dataField: 'lastUpdated',
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
		text: Liferay.Language.get('last-updated')
	},
	{
		classes: 'table-cell-ws-nowrap',
		dataField: 'caseNumber',
		formatter: (cell) => (cell || emDash),
		headerAttrs: {
			tabIndex: -1,
		},
		headerClasses: 'table-cell-ws-nowrap',
		sort: true,
		sortCaret: sortCaret,
		text: Liferay.Language.get('case-id')
	},
	{
		classes: 'table-cell-expand table-cell-expand-smaller',
		dataField: 'clientGroup.clientGroupName',
		formatter: (cell) => (cell || emDash),
		headerAttrs: {
			tabIndex: -1,
		},
		headerClasses: 'table-cell-expand table-cell-expand-smaller',
		sort: true,
		sortCaret: sortCaret,
		text: Liferay.Language.get('client-name')
	},
	{
		classes: 'table-cell-ws-nowrap',
		dataField: 'primaryCode',
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
		headerClasses: 'table-cell-ws-nowrap',
		sort: true,
		sortCaret: sortCaret,
		text: Liferay.Language.get('diag-code')
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
		dataField: 'repricedAmount',
		formatter: currencyFormat,
		headerAttrs: {
			tabIndex: -1,
		},
		headerClasses: 'table-cell-ws-nowrap text-right',
		sort: true,
		sortCaret: sortCaret,
		text: Liferay.Language.get('reprice-amount')
	},
	{
		classes: 'table-cell-ws-nowrap text-right',
		dataField: 'paidAmount',
		formatter: currencyFormat,
		headerAttrs: {
			tabIndex: -1,
		},
		headerClasses: 'table-cell-ws-nowrap text-right',
		sort: true,
		sortCaret: sortCaret,
		text: Liferay.Language.get('paid-amount')
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
		dataField: 'status',
		filter: customFilter({
			type: FILTER_TYPES.MULTISELECT,
		}),
		filterRenderer: (onFilter, column) => {
			statusFilter = onFilter;
			return null;
		},
		formatter: (cell, row) => {
			return cell ? (
				<React.Fragment>
					<ClayIcon
						className={`case-list__icon ${getCaseIcon(cell)}`}
						spritemap={spritemap}
						symbol={getCaseIcon(cell)}
					/>
					{cell}
				</React.Fragment>
			) : emDash;
		},
		headerAttrs: {
			tabIndex: -1,
		},
		headerClasses: 'table-cell-ws-nowrap',
		sort: true,
		sortCaret: sortCaret,
		text: Liferay.Language.get('status')
	},
	{
		classes: 'd-none',
		dataField: 'caseStartDate',
		text: Liferay.Language.get('start-date'),
		filter: customFilter({
			type: FILTER_TYPES.MULTISELECT,
			onFilter: (filterVal, data) => {
				if (filterVal) {
					return data.filter(row => isInRange(filterVal, row.caseStartDate));
				}

				return data;
			},
		}),
		filterRenderer: (onFilter, column) => {
			caseStartDateFilter = onFilter;
			return null;
		},
		headerClasses: 'd-none',
	},
	{
		classes: 'd-none',
		dataField: 'caseEndDate',
		text: Liferay.Language.get('end-date'),
		filter: customFilter({
			type: FILTER_TYPES.MULTISELECT,
			onFilter: (filterVal, data) => {
				if (filterVal) {
					return data.filter(row => isInRange(filterVal, row.caseEndDate));
				}

				return data;
			},
		}),
		filterRenderer: (onFilter, column) => {
			caseEndDateFilter = onFilter;
			return null;
		},
		headerClasses: 'd-none',
	},
	{
		classes: 'd-none',
		dataField: 'member.memberDOB',
		text: Liferay.Language.get('member-dob'),
		filter: customFilter({
			type: FILTER_TYPES.MULTISELECT,
			onFilter: (filterVal, data) => {
				if (filterVal) {
					return data.filter(row => isInArray(filterVal, row.member.memberDOB));
				}

				return data;
			},
		}),
		filterRenderer: (onFilter, column) => {
			memberDOBFilter = onFilter;
			return null;
		},
		headerClasses: 'd-none',
	},
	{
		classes: 'd-none',
		dataField: 'member.memberName',
		text: Liferay.Language.get('member-name'),
		filter: customFilter({
			type: FILTER_TYPES.MULTISELECT,
		}),
		filterRenderer: (onFilter, column) => {
			memberNameFilter = onFilter;
			return null;
		},
		headerClasses: 'd-none',
	},
	{
		classes: 'd-none',
		dataField: 'member.memberNumber',
		text: Liferay.Language.get('member-id'),
		filter: customFilter({
			type: FILTER_TYPES.MULTISELECT,
		}),
		filterRenderer: (onFilter, column) => {
			memberNumberFilter = onFilter;
			return null;
		},
		headerClasses: 'd-none',
	},
	{
		classes: 'd-none',
		dataField: 'primaryFacility',
		text: Liferay.Language.get('provider'),
		filter: customFilter({
			type: FILTER_TYPES.MULTISELECT,
		}),
		filterRenderer: (onFilter, column) => {
			primaryFacilityFilter = onFilter;
			return null;
		},
		headerClasses: 'd-none',
	},
];

const getFilterFunction = (key) => {
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
}

const defaultSorted = [{
	dataField: 'lastUpdated',
	order: 'desc'
}];

export {
	clearFilters,
	columns,
	defaultSorted,
	getFilterFunction,
};
