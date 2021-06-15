import React, { useCallback, useEffect } from 'react';
import ClayLayout from '@clayui/layout';
import ClayCard from '@clayui/card';
import ClayIcon from '@clayui/icon';
import { useSelector } from 'react-redux';
import DateDisplay from '~/Date/DateDisplay';
import { emDash, getCalleeKey, getCallerKey, getNoteIcon, getTitle, MMM_DD_YYYY_at_h_mm_aa } from '~/Utils/index';
import ShowMoreText from '~/ShowMore/ShowMoreText';

const NotesList = (props) => {
	let refs = {};

	const notes = useSelector(state => state.notes.data);
	const noteId = useSelector(state => state.notes.noteId);
	const spritemap = themeDisplay.getPathThemeImages() + '/argus/icons.svg';

	const onRefChange = useCallback((node, id) => {
		if (node && !refs[id]) {
			refs = {
				...refs,
				[id]: node
			};
		}
	}, [noteId]);

	useEffect(() => {
		if (noteId && refs[noteId]) {
			refs[noteId].scrollIntoView({
				behavior: 'smooth'
			});
		}
	}, [noteId]);

	return (
		<div className="case-notes">
			{notes.map((note, index) => (
				<div className="case-notes__note" key={index} ref={element => onRefChange(element, note.noteId)}>
					<h3 className="case-notes__title">
						<ClayIcon className={`case-notes__icon lexicon-icon-lg ${getNoteIcon(note.type, note.code)} ${note.direction.toLowerCase()}`} symbol={getNoteIcon(note.type, note.code)} spritemap={spritemap} />
						{getTitle(note) || emDash}
					</h3>
					<ClayCard className="card--secondary">
						<div className="card-header">
							<DateDisplay date={note.noteCreateDate} format={MMM_DD_YYYY_at_h_mm_aa} timeZone={note.noteCreateDateTimeZone} />
						</div>
						<ClayCard.Body>
							<ClayLayout.Row>
								{note.type !== 'Note' &&
									<ClayLayout.Col md={5}>
										<div className="mb-3">
											<h5 className="font-weight-bold">{getCallerKey(note.code)}</h5>
											<div>{note.caller || Liferay.Language.get('not-recorded')}</div>
										</div>

										<div>
											<h5 className="font-weight-bold">{getCalleeKey(note.code)}</h5>
											<div>{note.callee || Liferay.Language.get('not-recorded')}</div>
										</div>
									</ClayLayout.Col>
								}

								<ClayLayout.Col size={note.type === 'Note' ? 12 : 7}>
									<div className='case-notes__text'>
										{note.type === 'Note' &&
											<div className="mb-3">
												<h5 className="font-weight-bold">{Liferay.Language.get('created-by')}</h5>
												<div>{note.noteAuthor}</div>
											</div>
										}
										<h5 className="font-weight-bold">{Liferay.Language.get('notes')}</h5>
										<ShowMoreText>
											<div dangerouslySetInnerHTML={{__html: note.text || Liferay.Language.get('no-note')}}></div>
										</ShowMoreText>
									</div>
								</ClayLayout.Col>
							</ClayLayout.Row>
						</ClayCard.Body>
					</ClayCard>
				</div>
			))}
		</div>
	);
};

export default NotesList;