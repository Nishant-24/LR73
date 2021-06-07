import React, { useEffect } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import CasesList from './CasesList';
import { getRecentlyViewedCases } from './CasesSlice';
import LoadingIndicator from '~/LoadingIndicator/LoadingIndicator';

const CasesRecent = (props) => {
	const dispatch = useDispatch();
	const status = useSelector((state) => state.cases.status);
	const error = useSelector((state) => state.cases.error);

	useEffect(() => {
		dispatch(getRecentlyViewedCases());
	}, []);

	return (
		<LoadingIndicator status={status} error={error}>
			<div className="case-filter">
				<div className="case-filter__header">
					<h4 className="mb-2 mt-2">{Liferay.Language.get('recently-viewed-cases')}</h4>
				</div>
			</div>

			<CasesList hasPagination={false} />
		</LoadingIndicator>
	)
}

export default CasesRecent;
