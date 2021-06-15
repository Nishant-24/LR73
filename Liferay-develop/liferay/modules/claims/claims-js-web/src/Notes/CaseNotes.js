import React, { useEffect, useRef, useState } from 'react';
import InfiniteScroll from 'react-infinite-scroll-component';
import { useDispatch, useSelector } from 'react-redux';
import { getNotes, resetData } from './NotesSlice';
import { AddNote, NotesList, NotesQuickList } from './index';

const CaseNotes = (props) => {
	const dispatch = useDispatch();

	const caseId = useSelector((state) => state.modal.caseId);
	const showAddNote = useSelector(state => state.notes.showAddNote);
	const notes = useSelector(state => state.notes.data);

	const mountedRef = useRef();
	const limit = 20;
	const [start, setStart] = useState(0);
	const [end, setEnd] = useState(limit);
	const [hasMore, setHasMore] = useState(true);

	const loadMore = () => {
		setStart(start + limit);
		setEnd(end + limit);
	}

	useEffect(() => {
		if (caseId) {
			dispatch(getNotes({start: start, end: end}));
		}
	}, [caseId, dispatch]);

	useEffect(() => {
		if (mountedRef.current) {
			dispatch(getNotes({start: start, end: end}));
		}
	}, [end]);

	useEffect(() => {
		if (notes.length < end) {
			setHasMore(false);
		}
		else {
			setHasMore(true);
		}
	}, [notes]);

	useEffect(() => {
		mountedRef.current = true;

		return () => {
			dispatch(resetData());
		}
	}, []);

	return (
		<div className="case-template">
			<div id="notesList" className="case-template__content case-template__content--left">
				<InfiniteScroll
					dataLength={notes.length}
					next={loadMore}
					hasMore={hasMore}
					loader={<div className="loading-animation"></div>}
					scrollableTarget="notesList"
				>
					{showAddNote &&
						<AddNote />
					}

					<NotesList />
				</InfiniteScroll>
			</div>
			<div id="notesQuickList" className="case-template__content case-template__content--right">
				<InfiniteScroll
					dataLength={notes.length}
					next={loadMore}
					hasMore={hasMore}
					loader={<div className="loading-animation"></div>}
					scrollableTarget="notesQuickList"
				>
					<NotesQuickList />
				</InfiniteScroll>
			</div>
		</div>
	);
}

export default CaseNotes;
