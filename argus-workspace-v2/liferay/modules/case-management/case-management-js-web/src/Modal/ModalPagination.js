import React from 'react';
import { ClayButtonWithIcon } from '@clayui/button';
import { useSelector, useDispatch } from 'react-redux';
import { setCaseId } from './ModalSlice';

const ModalPagination = () => {
	const dispatch = useDispatch();
	const caseId = useSelector((state) => state.modal.caseId);
	const filteredResults = useSelector((state) => state.modal.filteredResults);

	const currentIndex = filteredResults.indexOf(caseId);
	const currentLength = filteredResults.length;

	const onPrevClick = () => {
		const prevIndex = currentIndex - 1;

		dispatch(setCaseId(filteredResults[prevIndex]));
	}

	const onNextClick = () => {
		const nextIndex = currentIndex + 1;

		dispatch(setCaseId(filteredResults[nextIndex]));
	}

	return (
		<div className="case-modal-pagination">
			<ClayButtonWithIcon
				disabled={currentIndex === 0}
				displayType="unstyled"
				onClick={onPrevClick}
				symbol="angle-left"
				small
			/>

			<div>{Liferay.Util.sub(Liferay.Language.get('x-of-x'), [currentIndex + 1, currentLength])}</div>

			<ClayButtonWithIcon
				disabled={currentIndex === currentLength - 1}
				displayType="unstyled"
				onClick={onNextClick}
				symbol="angle-right"
				small
			/>
		</div>
	)
}

export default ModalPagination;
