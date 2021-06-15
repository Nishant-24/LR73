import React, { useEffect } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import Bookmarks from './Bookmarks';
import { getBookmarks } from './BookmarksSlice';
import LoadingIndicator from '~/LoadingIndicator/LoadingIndicator'

const CaseBookmarks = (props) => {
	const dispatch = useDispatch();
	const status = useSelector((state) => state.bookmarks.status);
	const error = useSelector((state) => state.bookmarks.error);

	useEffect(() => {
		dispatch(getBookmarks());
	}, []);

	return (
		<LoadingIndicator status={status} error={error}>
			<Bookmarks />
		</LoadingIndicator>
	)
}

export default CaseBookmarks;