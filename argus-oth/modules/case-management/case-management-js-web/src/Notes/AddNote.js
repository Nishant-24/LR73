import React, { useState, useEffect, useRef } from 'react';
import ClayButton from '@clayui/button';
import ClayCard from '@clayui/card';
import ClayIcon from '@clayui/icon';
import ClayForm from '@clayui/form';
import { unwrapResult } from '@reduxjs/toolkit';
import { useDispatch, useSelector } from 'react-redux';
import { addNewNote, setShowAddNote, reloadNotes } from './NotesSlice';
import { alertService } from '~/Toast/index';
import Input from '~/Input/Input';

const AddNote = (props) => {
	const dispatch = useDispatch();
	const caseId = useSelector((state) => state.modal.caseId);
	
	const ref = useRef(null);

	const [hasError, setHasError] = useState(false);
	const [note, setNote] = useState('');

	const spritemap = themeDisplay.getPathThemeImages() + '/argus/icons.svg';

	useEffect(() => {
		ref.current.scrollIntoView({
			behavior: 'smooth',
		});
	}, []);

	const onSubmit = async (event) => {
		event.preventDefault();

		if (note === '') {
			setHasError(true);
		}
		else {
			try {
				const resultAction = await dispatch(
					addNewNote({
						caseId: caseId,
						text: note
					})
				);

				unwrapResult(resultAction);
				setNote('');

				alertService.success(Liferay.Language.get('new-carrier-note-successfully-added'));

				dispatch(setShowAddNote(false));
				dispatch(reloadNotes());
			}
			catch (err) {
				alertService.error(Liferay.Language.get('failed-to-create-note'));
			}
		}
	}

	return (
		<div className="case-notes mb-5" ref={ref}>
			<div className="case-notes__title justify-content-between">
				<h3 className="mb-0">
					<ClayIcon className="case-notes__icon lexicon-icon-lg note" symbol="note" spritemap={spritemap} />
					{Liferay.Language.get('new-carrier-note')}
				</h3>
				<span className="font-weight-light">{Liferay.Language.get('all-fields-required')}</span>
			</div>

			<ClayCard className="card--secondary">
				<ClayCard.Body>
					<ClayForm noValidate onSubmit={(event) => onSubmit(event)}>
						<Input
							component="textarea"
							errorMsg={Liferay.Language.get('you-must-enter-a-note-to-continue')}
							fieldName="note"
							handleFieldChange={(fieldName, fieldValue) => setNote(fieldValue)}
							label={Liferay.Language.get('note')}
							placeholder={Liferay.Language.get('please-enter-your-note-here')}
							required={true}
							showErrors={hasError}
							errorMsg={Liferay.Language.get('you-must-enter-a-note-to-continue')}
							type="text"
							value={note}
						/>
						<div className="text-right">
							<ClayButton.Group spaced>
								<ClayButton displayType="primary" outline="true" onClick={() => dispatch(setShowAddNote(false))}>{Liferay.Language.get('discard')}</ClayButton>
								<ClayButton displayType="primary" type="submit">{Liferay.Language.get('add-note')}</ClayButton>
							</ClayButton.Group>
						</div>
					</ClayForm>
				</ClayCard.Body>
			</ClayCard>
		</div>
	);
}

export default AddNote;