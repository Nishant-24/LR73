import React, { useEffect } from 'react';
import { useDispatch, useSelector } from "react-redux";
import { getAuthorizations } from './AuthorizationsSlice';
import { AuthorizationsList, AuthorizationsQuickList } from './index';
import LoadingIndicator from '~/LoadingIndicator/LoadingIndicator';

const CaseAuthorizations = () => {
	const dispatch = useDispatch();
	const caseId = useSelector((state) => state.modal.caseId);
	const status = useSelector((state) => state.authorizations.status);
	const error = useSelector((state) => state.authorizations.error);

	useEffect(() => {
		if (caseId) {
			dispatch(getAuthorizations());
		}
	}, [caseId, dispatch]);

	return (
		<LoadingIndicator status={status} error={error}>
			<div className="case-template">
				<div className="case-template__content case-template__content--left">
					<AuthorizationsList />
				</div>
				<div className="case-template__content case-template__content--right">
					<AuthorizationsQuickList />
				</div>
			</div>
		</LoadingIndicator>
	);
}

export default CaseAuthorizations;