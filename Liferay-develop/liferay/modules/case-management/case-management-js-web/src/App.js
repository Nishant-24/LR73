import React, { lazy, Suspense } from 'react';
import ClayLoadingIndicator from '@clayui/loading-indicator';
import { CaseNav } from '~/Nav/index';
import { Toast } from '~/Toast/index';
import load from '~/hooks/load';

const CasesAll = lazy(() => load('CasesAll', 'Cases/'));
const CasesRecent = lazy(() => load('CasesRecent', 'Cases/'));
const CaseBookmarks = lazy(() => load('CaseBookmarks', 'Bookmarks/'));

const App = (props) => {

	return (
		<div className="portlet-case-management">
			<Suspense fallback={<ClayLoadingIndicator />}>
				{
					{
						'all': (
							<CaseNav>
								<CasesAll />
							</CaseNav>
						),
						'recent': (
							<CaseNav>
								<CasesRecent />
							</CaseNav>
						),
						'bookmarks': (
							<CaseNav>
								<CaseBookmarks />
							</CaseNav>
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
