import React from 'react';
import ClayIcon from '@clayui/icon';
import ClayLayout from '@clayui/layout';
import ClayTable from '@clayui/table';
import DateDisplay from '~/Date/DateDisplay';
import { formatDate, currencyFormat, emDash, getClaimDetailsIcon, sortCaret } from '~/Utils/index';

const spritemap = themeDisplay.getPathThemeImages() + '/argus/icons.svg';

const columns = [
	{
		classes: 'table-col-3',
		dataField: 'providerName',
		formatter: (cell, row) => {
			return (
				<React.Fragment>
					<div className="font-weight-bold">{cell || emDash}</div>
					<div>{row.billType || emDash}</div>
				</React.Fragment>
			);
		},
		headerAttrs: {
			tabIndex: -1,
		},
		headerClasses: 'table-col-3',
		headerFormatter: (column, colIndex) => {
			return (
				<React.Fragment>
					<div className="font-weight-bold text-body">{column.text}</div>
					<div className="font-weight-light">{Liferay.Language.get('bill-type')}</div>
				</React.Fragment>
			);
		},
		text: Liferay.Language.get('provider-name')
	},
	{
		classes: 'table-col-1',
		dataField: 'serviceFrom',
		formatter: (cell, row) => {
			if (!cell && !row.serviceTo) {
				return '';
			}

			return (
				<React.Fragment>
					<div>
						<DateDisplay date={cell} /> -
					</div>
					<div>
						<DateDisplay date={row.serviceTo} />
					</div>
				</React.Fragment>
			);
		},
		headerAttrs: {
			tabIndex: -1,
		},
		headerClasses: 'table-col-1',
		headerFormatter: (column, colIndex) => {
			return (
				<React.Fragment>
					<div>{column.text}</div>
					<div className="font-weight-light">{Liferay.Language.get('from-to')}</div>
				</React.Fragment>
			);
		},
		text: Liferay.Language.get('service-date')
	},
	{
		classes: 'table-col-2 table-cell-ws-nowrap',
		dataField: 'network',
		formatter: (cell) => {
			return (
				<span>{cell || emDash}</span>
			)
		},
		headerAttrs: {
			tabIndex: -1,
		},
		headerClasses: 'table-col-2 table-cell-ws-nowrap',
		text: Liferay.Language.get('network')
	},
	{
		classes: 'table-col-1 text-right',
		dataField: 'billedAmount',
		formatter: (cell, row) => {
			return (
				currencyFormat(cell)
			);
		},
		headerAttrs: {
			tabIndex: -1,
		},
		headerClasses: 'table-col-1 text-right',
		text: Liferay.Language.get('billed')
	},
	{
		classes: 'table-col-1 text-right',
		dataField: 'repricedAmount',
		formatter: (cell, row) => {
			return (
				currencyFormat(cell)
			);
		},
		headerAttrs: {
			tabIndex: -1,
		},
		headerClasses: 'table-col-1 text-right',
		text: Liferay.Language.get('repriced')
	},
	{
		classes: 'table-col-1 text-right',
		dataField: 'savingsAmount',
		formatter: (cell, row) => {
			return (
				currencyFormat(cell)
			);
		},
		headerAttrs: {
			tabIndex: -1,
		},
		headerClasses: 'table-col-1 text-right',
		text: Liferay.Language.get('savings')
	},
	{
		classes: 'table-col-1 text-right',
		dataField: 'paidAmount',
		formatter: (cell, row) => {
			return (
				currencyFormat(cell)
			);
		},
		headerAttrs: {
			tabIndex: -1,
		},
		headerClasses: 'table-col-1 text-right',
		text: Liferay.Language.get('paid')
	},
	{
		classes: 'table-col-1 table-cell-ws-nowrap',
		dataField: 'paidDate',
		formatter: (cell, row) => {
			return cell ? (
				<DateDisplay date={cell} />
			) : emDash;
		},
		headerAttrs: {
			tabIndex: -1,
		},
		headerClasses: 'table-col-1 table-cell-ws-nowrap',
		text: Liferay.Language.get('last-payment')
	},
	{
		classes: 'table-col-1 table-cell-ws-nowrap',
		dataField: 'status',
		formatter: (cell, row) => {
			return cell ? (
				<React.Fragment>
					<ClayIcon
						className={`case-claim-details__icon ${getClaimDetailsIcon(cell)}`}
						spritemap={spritemap}
						symbol={getClaimDetailsIcon(cell)}
					/>
					{cell}
				</React.Fragment>
			) : emDash;
		},
		headerAttrs: {
			tabIndex: -1,
		},
		headerClasses: 'table-col-1 table-cell-ws-nowrap',
		sort: true,
		sortFunc: (a, b, order, dataField) => {
			const sortOrder = {
				'In Process': 0,
				'Processed': 1,
				'Closed': 2
			};

			if (order === 'asc'){
				return sortOrder[a] - sortOrder[b];
			}
			else {
				return sortOrder[b] - sortOrder[a];
			}
		},
		sortCaret: sortCaret,
		text: Liferay.Language.get('status'),
	}
];

const expandRow = {
	renderer: row => (
		<table className="table table-list case-claim-details table-valign-top table-border-top-0">
			<ClayTable.Head>
				<ClayTable.Row
					className="dropdown-details table-divider"
					key={`row-expanded-header-${row.claimId}`}
				>
					<ClayTable.Cell headingCell><span className="lexicon-icon"></span></ClayTable.Cell>
					<ClayTable.Cell headingCell className="table-col-3">
						<ClayLayout.Row gutters={false}>
							<ClayLayout.Col size={4}>{Liferay.Language.get('rev-code')}</ClayLayout.Col>
							<ClayLayout.Col size={4}>{Liferay.Language.get('p-code')}</ClayLayout.Col>
							<ClayLayout.Col size={4}>{Liferay.Language.get('units')}</ClayLayout.Col>
						</ClayLayout.Row>
					</ClayTable.Cell>
					<ClayTable.Cell headingCell className="table-col-1">{Liferay.Language.get('service-date')}</ClayTable.Cell>
					<ClayTable.Cell headingCell className="table-col-2 table-cell-ws-nowrap">{Liferay.Language.get('network')}</ClayTable.Cell>
					<ClayTable.Cell headingCell className="table-col-1 text-right">{Liferay.Language.get('billed')}</ClayTable.Cell>
					<ClayTable.Cell headingCell className="table-col-1 text-right">{Liferay.Language.get('repriced')}</ClayTable.Cell>
					<ClayTable.Cell headingCell className="table-col-1 text-right">{Liferay.Language.get('savings')}</ClayTable.Cell>
					<ClayTable.Cell headingCell className="table-col-1 text-right">{Liferay.Language.get('paid')}</ClayTable.Cell>
					<ClayTable.Cell headingCell className="table-col-1 table-cell-ws-nowrap">{Liferay.Language.get('last-payment')}</ClayTable.Cell>
					<ClayTable.Cell headingCell className="table-col-1 table-cell-ws-nowrap">{Liferay.Language.get('status')}</ClayTable.Cell>
				</ClayTable.Row>
			</ClayTable.Head>

			<ClayTable.Body>
				{row.claimDetails.map((detail, index) => (
					<ClayTable.Row
						className="dropdown-details"
						key={`row-expanded-${detail.claimId}-${index}`}
					>
						<ClayTable.Cell></ClayTable.Cell>
						<ClayTable.Cell className="table-col-3">
							<ClayLayout.Row gutters={false}>
								<ClayLayout.Col size={4}>{detail.revCode || emDash}</ClayLayout.Col>
								<ClayLayout.Col size={4}>{detail.pCode || emDash}</ClayLayout.Col>
								<ClayLayout.Col size={4}>{detail.units}</ClayLayout.Col>
							</ClayLayout.Row>
						</ClayTable.Cell>
						<ClayTable.Cell className="table-col-1">
							{
								(detail.serviceFrom || detail.serviceTo) ?
									(
										<React.Fragment>
											<div>
												<DateDisplay date={detail.serviceFrom}/> -
											</div>
											<div>
												<DateDisplay date={detail.serviceTo} />
											</div>
										</React.Fragment>
									) : ''

							}
						</ClayTable.Cell>
						<ClayTable.Cell className="table-col-2 table-cell-ws-nowrap">{detail.network || emDash}</ClayTable.Cell>
						<ClayTable.Cell className="table-col-1 text-right">{currencyFormat(detail.billedAmount)}</ClayTable.Cell>
						<ClayTable.Cell className="table-col-1 text-right">{currencyFormat(detail.repricedAmount)}</ClayTable.Cell>
						<ClayTable.Cell className="table-col-1 text-right">{currencyFormat(detail.savingsAmount)}</ClayTable.Cell>
						<ClayTable.Cell className="table-col-1 text-right">{currencyFormat(detail.paidAmount)}</ClayTable.Cell>
						<ClayTable.Cell className="table-col-1 table-cell-ws-nowrap">
							{detail.paidDate ? <DateDisplay date={detail.paidDate} /> : emDash}
						</ClayTable.Cell>
						<ClayTable.Cell className="table-col-1 table-cell-ws-nowrap">
							<small>
								<ClayIcon
									className={`case-claim-details__icon ${getClaimDetailsIcon(detail.status)}`}
									spritemap={spritemap}
									symbol={getClaimDetailsIcon(detail.status)}
								/>
							</small>
							{detail.status || emDash}
						</ClayTable.Cell>
					</ClayTable.Row>
				))}
			</ClayTable.Body>
		</table>
	),
	showExpandColumn: true,
	parentClassName: (isExpanded, row, rowIndex) => {
		if (isExpanded) {
			return 'active';
		}
		return '';
	},
	expandHeaderColumnRenderer: () => {
		return null;
	},
	expandColumnRenderer: ({ expanded }) => {
		return (
			<small>
				<ClayIcon
					className="text-primary"
					symbol={expanded ? 'caret-top' : 'caret-bottom'}
				/>
			</small>
		);
	}
};

const defaultSorted = [{
	dataField: 'status',
	order: 'asc'
}];

export {
	columns,
	defaultSorted,
	expandRow
};