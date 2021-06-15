import React, { useEffect, useState } from 'react';
import Dialog from './Dialog';
import { useSelector, useDispatch } from 'react-redux';
import { getData, setActiveTab, setCaseId } from './ModalSlice';
import { setShowAddNote } from '~/Notes/NotesSlice';
import { setShowAddTask } from '~/Tasks/TasksSlice';
import { ModalContent, ModalHeader, ModalNav, ModalPagination } from './index';
import { AddRemoveBookmark } from '~/Bookmarks/index';
import LoadingIndicator from '~/LoadingIndicator/LoadingIndicator';

const CaseModal = ({ setVisible, visible }) => {
	const dispatch = useDispatch();
	const caseId = useSelector((state) => state.modal.caseId);
	const activeTab = useSelector((state) => state.modal.activeTab);
	const data = useSelector((state) => state.modal.data);
	const status = useSelector((state) => state.modal.status);
	const error = useSelector((state) => state.modal.error);

	useEffect(() => {
		if (caseId) {
			dispatch(getData());
		}
	}, [caseId, dispatch]);

	useEffect(() => {
		if (visible && activeTab !== 0) {
			dispatch(setActiveTab(0));
		}
		if (!visible && caseId) {
			dispatch(setCaseId(null));
		}
	}, [visible, dispatch]);

	return (
		<Dialog
			hideFooter={true}
			setVisible={(isVisible) => {
				setVisible(isVisible);
				dispatch(setShowAddNote(false));
				dispatch(setShowAddTask(false));
			}}
			visible={visible}
			title={
				<div className="case-modal-title">
					<AddRemoveBookmark className="text-light" bookmarked={data.case.bookmarked} />
					<ModalPagination />
				</div>
			}
		>
			<LoadingIndicator status={status} error={error}>
				<div className="case-detail">
					<ModalHeader />

					<ModalNav />

					<ModalContent />
				</div>
			</LoadingIndicator>
		</Dialog>
	)
}

export default CaseModal;
