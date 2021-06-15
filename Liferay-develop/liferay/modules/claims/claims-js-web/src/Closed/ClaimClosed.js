import React, { useEffect } from 'react';
import ClayCard from '@clayui/card';
import { useSelector, useDispatch } from 'react-redux';
import { ClaimsList } from '~/Claims/index';
import CollapsiblePanel from '~/CollapsiblePanel/CollapsiblePanel';
import { ClosedContent, ClosedHeader, ClosedNav } from './index';
import { getBreakoutByPaidAmount, getBreakoutByVolume, getBreakoutBySavingsRange, getPaidAmountArea } from './ClosedSlice';

const ClaimClosed = () => {
	const dispatch = useDispatch();
	const dateRange = useSelector((state) => state.claims.dateRange);

	useEffect(() => {
		dispatch(getBreakoutByPaidAmount());
		dispatch(getBreakoutByVolume());
		dispatch(getBreakoutBySavingsRange());
		dispatch(getPaidAmountArea());
	}, [dateRange]);

	return (
		<React.Fragment>
			<div className="bg-secondary pb-1">
				<ClosedHeader/>

				<ClayCard className="card mx-3">
					<ClayCard.Body className="claim__card-body">
						<ClosedNav/>

						<CollapsiblePanel>
							<ClosedContent/>
						</CollapsiblePanel>
					</ClayCard.Body>
				</ClayCard>
			</div>

			<ClaimsList status="Closed" />
		</React.Fragment>
	)
}

export default ClaimClosed;