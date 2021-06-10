import React, { useEffect } from 'react';
import ClayCard from '@clayui/card';
import { useSelector, useDispatch } from 'react-redux';
import { ClaimsList } from '~/Claims/index';
import CollapsiblePanel from '~/CollapsiblePanel/CollapsiblePanel';
import { ProcessedContent, ProcessedHeader, ProcessedNav } from './index';
import { getBreakoutByRepricedAmount, getBreakoutByVolume, getRepricedAmountArea } from './ProcessedSlice';

const ClaimProcessed = () => {
	const dispatch = useDispatch();
	const dateRange = useSelector((state) => state.claims.dateRange);

	useEffect(() => {
		dispatch(getBreakoutByRepricedAmount());
		dispatch(getBreakoutByVolume());
		dispatch(getRepricedAmountArea());
	}, [dateRange]);

	return (
		<React.Fragment>
			<div className="bg-secondary pb-1">
				<ProcessedHeader/>

				<ClayCard className="card mx-3">
					<ClayCard.Body className="claim__card-body">
						<ProcessedNav/>

						<CollapsiblePanel>
							<ProcessedContent/>
						</CollapsiblePanel>
					</ClayCard.Body>
				</ClayCard>
			</div>

			<ClaimsList status="Processed" />
		</React.Fragment>
	)
}

export default ClaimProcessed;