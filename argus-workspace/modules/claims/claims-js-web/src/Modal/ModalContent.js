import React, { lazy, Suspense } from 'react';
import ClayLoadingIndicator from '@clayui/loading-indicator';
import ClayTabs from '@clayui/tabs';
import { useSelector } from 'react-redux';
import load from '~/hooks/load';

const CaseSummary = lazy(() => load('CaseSummary', 'Summary/'));
const CaseNotes = lazy(() => load('CaseNotes', 'Notes/'));
const CaseTasks = lazy(() => load('CaseTasks', 'Tasks/'));
const CaseAuthorizations = lazy(() => load('CaseAuthorizations', 'Authorizations/'));
const ClaimDetails = lazy(() => load('ClaimDetails', 'Details/'));

const ModalContent = () => {
	const activeTab = useSelector((state) => state.modal.activeTab);
	const caseId = useSelector((state) => state.modal.caseId);

	return (
		<Suspense fallback={<ClayLoadingIndicator />}>
			<ClayTabs.Content
				activeIndex={activeTab}
				className="case-detail__body"
				fade
			>
				<ClayTabs.TabPane aria-labelledby="summary">
					<CaseSummary />
				</ClayTabs.TabPane>

				<ClayTabs.TabPane aria-labelledby="notes">
					<CaseNotes />
				</ClayTabs.TabPane>

				<ClayTabs.TabPane aria-labelledby="tasks">
					<CaseTasks />
				</ClayTabs.TabPane>

				<ClayTabs.TabPane aria-labelledby="authorizations">
					<CaseAuthorizations />
				</ClayTabs.TabPane>

				<ClayTabs.TabPane aria-labelledby="claim-details">
					<ClaimDetails caseId={caseId} />
				</ClayTabs.TabPane>
			</ClayTabs.Content>
		</Suspense>
	)
}

export default ModalContent;
