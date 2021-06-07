import React from 'react';
import ClayCard from '@clayui/card';
import ClayIcon from '@clayui/icon';
import ClayButton from '@clayui/button';
import { useDispatch, useSelector } from 'react-redux';
import DateDisplay from '~/Date/DateDisplay';
import { setNoteId, setShowAddNote } from './NotesSlice';
import { emDash, getNoteIcon, getTitle, MMM_DD_YYYY_at_h_mm_aa } from '~/Utils/index';

const NotesQuickList = (props) => {
	const dispatch = useDispatch();

	const notes = useSelector(state => state.notes.data);
	const noteId = useSelector(state => state.notes.noteId);
	const permissions = useSelector(state => state.claims.permissions);
	const showAddNote = useSelector(state => state.notes.showAddNote);
	const total = useSelector(state => state.notes.total);

	const spritemap = themeDisplay.getPathThemeImages() + '/argus/icons.svg';
	
	return (
		<div className="case-notes">
			<div className="case-notes__header">
				<h3 className="mb-0">{Liferay.Util.sub(Liferay.Language.get('communications-x'), [total])}</h3>
				{permissions['ADD_NOTE'] &&
					<ClayButton
						disabled={showAddNote}
						displayType="primary"
						onClick={() => dispatch(setShowAddNote(true))}
						outline="true"
					>
						{Liferay.Language.get('new-note')}
					</ClayButton>
				}
			</div>

			{notes.map((note, index) => (
				<ClayCard
					className={`card--condensed card-interactive ${noteId === note.noteId && 'active'}`}
					key={index}
					onClick={() => dispatch(setNoteId(note.noteId))}
				>
					<ClayCard.Body>
						<h5 className="font-weight-bold">
							<ClayIcon className={`case-notes__icon ${getNoteIcon(note.type, note.code)} ${note.direction.toLowerCase()}`} spritemap={spritemap} symbol={getNoteIcon(note.type, note.code)} />
							{getTitle(note) || emDash}
						</h5>
						<div className="case-notes__timestamp">
							{(note.noteCreateDate && <DateDisplay date={note.noteCreateDate} format={MMM_DD_YYYY_at_h_mm_aa} timeZone={note.noteCreateDateTimeZone} />) || emDash}
						</div>
					</ClayCard.Body>
				</ClayCard>
			))}
		</div>
	);
}

export default NotesQuickList;