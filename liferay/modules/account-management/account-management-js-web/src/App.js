import React, { lazy, Suspense } from 'react';
import ClayLoadingIndicator from '@clayui/loading-indicator';
import { AccountNav } from '~/Nav/index';
import { Toast } from '~/Toast/index';
import load from '~/hooks/load';

const AccountSLA = lazy(() => load('AccountSLA', 'SLA/'));

const App = (props) => {
	
	return (
		<div className="portlet-account-management">
			<Suspense fallback={<ClayLoadingIndicator />}>
				{
					{
						'operational-slas': (
							<AccountNav>
								<AccountSLA />
							</AccountNav>
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