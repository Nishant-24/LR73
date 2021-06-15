import React from 'react';
import ClayCard from '@clayui/card';
import ClayIcon from '@clayui/icon';
import { useDispatch, useSelector } from 'react-redux';
import { setAuthId } from './AuthorizationsSlice';
import DateDisplay from '~/Date/DateDisplay';
import { setActiveTab } from '~/Modal/ModalSlice';
import { getAuthorizationIcon } from '~/Utils/index';

const AuthorizationsQuickList = (props) => {
	const dispatch = useDispatch();

	const authorizations = useSelector(state => state.authorizations.data);
	const authId = useSelector(state => state.authorizations.authId);
	const activeTab = useSelector((state) => state.modal.activeTab);

	const spritemap = themeDisplay.getPathThemeImages() + '/argus/icons.svg';

	const {
		title = Liferay.Util.sub(Liferay.Language.get('authorizations-x'), [authorizations.length]),
	} = props;

	return (
		<div className="case-authorizations">
			<div className="case-authorizations__header">
				<h3 className="mb-0">{title}</h3>
			</div>

			{authorizations.map((authorization, index) => (
				<ClayCard
					className={`card--condensed card-interactive ${activeTab !== 3 && 'card-interactive-secondary'} ${(activeTab === 3 && authId === authorization.authId) && 'active'}`}
					key={index}
					onClick={() => {
						if (activeTab !== 3) {
							dispatch(setActiveTab(3));

							setTimeout(() => {
								dispatch(setAuthId(authorization.authId));
							}, 500);
						}
						else {
							dispatch(setAuthId(authorization.authId));
						}
					}}
				>
					<ClayCard.Body>
						<div className="case-authorizations__header mb-2">
							<h5 className="font-weight-bold mb-0 mr-4">
								{!!authorization.procedureCodes[0] ? authorization.procedureCodes[0] : Liferay.Language.get('to-be-determined')}
								{!!authorization.procedureCodes[0] && authorization.procedureCodeCount > 1 ? `, ${Liferay.Util.sub(Liferay.Language.get('+-x-more'), [authorization.procedureCodeCount - 1])}` : ""}
							</h5>
							<small>
								{authorization.authStatus || Liferay.Language.get('to-be-determined')}
								<ClayIcon
									className={`case-authorizations__icon ${getAuthorizationIcon(authorization.authStatusRefTypeCode)}`}
									spritemap={spritemap}
									symbol={getAuthorizationIcon(authorization.authStatusRefTypeCode)}
								/>
							</small>
						</div>
						<div className="case-authorizations__timestamp">
							{!!authorization.effectiveFrom ?
								<DateDisplay date={authorization.effectiveFrom} /> : Liferay.Language.get('to-be-determined')
							} : {authorization.facility || Liferay.Language.get('to-be-determined')}
						</div>
						<div className="case-authorizations__timestamp">
							{!!authorization.memberEligibility ? authorization.memberEligibility.length > 0 ? authorization.memberEligibility : "" : ""}
							{!!authorization.authType && !!authorization.memberEligibility ? ", " : ""}
							{!!authorization.authType ? authorization.authType.length > 0 ? authorization.authType : "" : ""}
						</div>
					</ClayCard.Body>
				</ClayCard>
			))}
		</div>
	);
}

export default AuthorizationsQuickList;