import React from 'react';
import ClayIcon from '@clayui/icon';
import ClayLayout from '@clayui/layout';
import DateDisplay from '~/Date/DateDisplay';
import { currencyFormat, getCaseIcon } from '~/Utils/index';
import { AddRemoveBookmark } from './index';

const spritemap = themeDisplay.getPathThemeImages() + '/argus/icons.svg';

const bookmarksColumns = [
    {
		dataField: 'memberName',
        sort:true,
        hidden:true,
		headerClasses: 'table-cell-ws-nowrap',
		text: Liferay.Language.get('memberName'),
	},
	{
		dataField: 'caseNumber',
		formatter: (cell, row) => {
			return (
				<ClayLayout.ContentRow padded>
					<ClayLayout.ContentCol className="justify-content-start">
						<AddRemoveBookmark caseId={row.caseId} bookmarked/>
					</ClayLayout.ContentCol>
					<ClayLayout.ContentCol expand>
						<ClayLayout.ContentSection>
							<h5 className="font-weight-bold text-dark">{row.memberName} ({row.memberId})</h5>
							<h6 className="text-dark">{Liferay.Language.get('case-id')}</h6>
							<div>{cell}</div>
						</ClayLayout.ContentSection>
					</ClayLayout.ContentCol>
				</ClayLayout.ContentRow>
			);
        },
        sort:true,
		text: Liferay.Language.get('case-id'),
	},
	{
		dataField: 'diagnosis',
		formatter: (cell, row) => {
			return (
				<React.Fragment>
					<h6 className="text-dark">{Liferay.Language.get('diagnosis')}</h6>
					<div>{row.primaryCode || 'N/A'} - {cell || 'N/A'}</div>
				</React.Fragment>
			)	
		},
		text: Liferay.Language.get('diagnosis')
	},
	{
		dataField: 'estimate',
		formatter: (cell) => {
			return (
				<React.Fragment>
					<h6 className="text-dark">{Liferay.Language.get('estimate')}</h6>
					<div>{currencyFormat(cell)}</div>
				</React.Fragment>
			)
        },
        sort:true,
		text: Liferay.Language.get('estimate')
	},
	{
		dataField: 'createDate',
		formatter: (cell) => {
			return (
				<React.Fragment>
					<h6 className="text-dark">{Liferay.Language.get('bookmarked-on')}</h6>
					<div>
						<DateDisplay date={cell} />
					</div>
				</React.Fragment>
			)
        },
        sort:true,
		text: Liferay.Language.get('bookmarked-on')
	},
	{
		dataField: 'status',
		formatter: (cell) => {
			return (
				<React.Fragment>
					<h6 className="text-dark">{Liferay.Language.get('status')}</h6>
					<div>
						<ClayIcon
							className={`case-list__icon ${getCaseIcon(cell)}`}
							spritemap={spritemap}
							symbol={getCaseIcon(cell)}
						/>
						{cell}
					</div>
				</React.Fragment>
			)
        },
        sort:true,
		text: Liferay.Language.get('status'),
	}
]

export {
	bookmarksColumns,
};
