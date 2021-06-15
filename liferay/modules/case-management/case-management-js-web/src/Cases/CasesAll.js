import React, { useEffect } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { CasesFilter, CasesList } from '~/Cases/index';
import { getCases } from './CasesSlice';
import LoadingIndicator from '~/LoadingIndicator/LoadingIndicator';

const CasesAll = (props) => {
	const dispatch = useDispatch();
	const status = useSelector((state) => state.cases.status);
	const error = useSelector((state) => state.cases.error);

	useEffect(() => {
		dispatch(getCases());
	}, []);

	return (
		<LoadingIndicator status={status} error={error}>
			<CasesFilter />
			<CasesList />
		</LoadingIndicator>
	)
}

export default CasesAll;
