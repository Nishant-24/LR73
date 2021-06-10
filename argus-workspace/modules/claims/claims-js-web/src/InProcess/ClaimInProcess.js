import React, { useEffect } from 'react';
import ClayCard from '@clayui/card';
import { useSelector, useDispatch } from 'react-redux';
import { ClaimsList } from '~/Claims/index';
import CollapsiblePanel from '~/CollapsiblePanel/CollapsiblePanel';
import { InProcessContent, InProcessHeader, InProcessNav } from './index';
import { getBreakoutByChargedAmount, getBreakoutByVolume, getBreakoutByDays, getChargedAmountArea, getClaimAgingArea } from './InProcessSlice';

const ClaimInProcess = () => {
	const dispatch = useDispatch();
	const dateRange = useSelector((state) => state.claims.dateRange);

	useEffect(() => {
		dispatch(getBreakoutByChargedAmount());
		dispatch(getBreakoutByVolume());
		dispatch(getBreakoutByDays());
		dispatch(getChargedAmountArea());
		dispatch(getClaimAgingArea());
	}, [dateRange]);

	return (
		<React.Fragment>
			<div className="bg-secondary pb-1">
				<InProcessHeader/>

				<ClayCard className="card mx-3">
					<ClayCard.Body className="claim__card-body">
						<InProcessNav/>

						<CollapsiblePanel>
							<InProcessContent/>
						</CollapsiblePanel>
					</ClayCard.Body>
				</ClayCard>
			</div>

			<ClaimsList status="In Process" />
		</React.Fragment>
	)
}

export default ClaimInProcess;