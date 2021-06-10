import React, { lazy, Suspense } from 'react';
import ClayLoadingIndicator from '@clayui/loading-indicator';
import { ClaimNav } from '~/Nav/index';
import { Toast } from '~/Toast/index';
import load from '~/hooks/load';

const ClaimDashboard = lazy(() => load('ClaimDashboard', 'Dashboard/'));
const ClaimInProcess = lazy(() => load('ClaimInProcess', 'InProcess/'));
const ClaimProcessed = lazy(() => load('ClaimProcessed', 'Processed/'));
const ClaimClosed = lazy(() => load('ClaimClosed', 'Closed/'));

const App = (props) => {

	return (
		<div>
			<Suspense fallback={<ClayLoadingIndicator />}>
				{
					{
						'dashboard': (
							<ClaimNav>
								<ClaimDashboard />
							</ClaimNav>
						),
						'in-process-claims': (
							<ClaimNav>
								<ClaimInProcess />
							</ClaimNav>
						),
						'processed-claims': (
							<ClaimNav>
								<ClaimProcessed />
							</ClaimNav>
						),
						'closed-claims': (
							<ClaimNav>
								<ClaimClosed />
							</ClaimNav>
						)

					}[props.configuration.portletInstance.view] ||

					<div className="alert alert-info text-center">
						{Liferay.Language.get('missing-portlet-configuration')}
					</div>
				}
			</Suspense>

			<Toast />
		</div>
	)
}

export default App;
