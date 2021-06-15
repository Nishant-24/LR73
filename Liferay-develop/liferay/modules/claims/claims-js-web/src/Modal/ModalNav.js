import React from 'react';
import ClayNav from '@clayui/nav';
import { useSelector, useDispatch } from 'react-redux';
import { setActiveTab } from './ModalSlice';

const ModalNav = () => {
	const dispatch = useDispatch();
	const caseId = useSelector((state) => state.modal.caseId);
	const tabs = useSelector((state) => state.modal.tabs);
	const activeTab = useSelector((state) => state.modal.activeTab);

	return (
		<div className="case-detail__nav">
			<ClayNav className="nav-pills nav-inverse">
				{tabs.map((tab, index) => (
					<ClayNav.Item key={index}>
						<ClayNav.Link
							active={activeTab === index}
							onClick={() => dispatch(setActiveTab(index))}
							data-analytics-asset-type="custom"
							data-analytics-asset-id={tab}
							data-analytics-asset-category="cases"
							data-analytics-asset-title={`${tab}-${caseId}`}
						>
							{tab}
						</ClayNav.Link>
					</ClayNav.Item>
				))}
			</ClayNav>
		</div>
	)
}

export default ModalNav;
