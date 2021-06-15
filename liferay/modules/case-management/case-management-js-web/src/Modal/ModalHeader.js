import React from 'react';
import ClayIcon from '@clayui/icon';
import { useSelector } from 'react-redux';
import DateDisplay from '~/Date/DateDisplay';
import { currencyFormat, emDash, getCaseIcon } from '~/Utils/index';

const ModalHeader = () => {
	const data = useSelector((state) => state.modal.data);
	const spritemap = themeDisplay.getPathThemeImages() + '/argus/icons.svg';

	let diagnosisCode = '';

	if (data.case.primaryDiagCode || data.case.primaryCode) {
		diagnosisCode = `${data.case.primaryDiagCode} ${data.case.primaryCode}`;
	}

	return (
		<div className="case-detail__header">
			<div>
				<div className="truncate-text">
					<span>{(data.case.member && data.case.member.memberName) || emDash}</span>
					<span>(ID# {(data.case.member && data.case.member.memberNumber) || emDash})</span>
				</div>
				<div className="case-detail__value truncate-text">
					<span>{diagnosisCode || emDash}</span>
				</div>
			</div>
			<div className="text-right">
				<div className="case-detail__label">{Liferay.Language.get('cost-estimate')}</div>
				<div className="case-detail__value">{data.case.costEstimate || emDash}</div>
			</div>
			<div>
				<div className="case-detail__label">{Liferay.Language.get('est-entry-update-date')}</div>
				<div className="case-detail__value">
					{(data.case.estimateEntryDate && <DateDisplay date={data.case.estimateEntryDate} />) || emDash}
				</div>
			</div>
			<div>
				<div className="case-detail__label">{Liferay.Language.get('case-status')}</div>
				{
					data.case.status ? (
						<React.Fragment>
							<span className="label label-secondary label-lg">
								<span className="label-item">
									<ClayIcon
										className={`case-detail__icon ${getCaseIcon(data.case.status)}`}
										spritemap={spritemap}
										symbol={getCaseIcon(data.case.status)}
									/>
								</span>
								<span className="label-item label-item-expand">{data.case.status}</span>
							</span>
						</React.Fragment>
					) : (
						<span className="case-detail__value">{emDash}</span>
					)
				}
			</div>
		</div>
	)
}

export default ModalHeader;
