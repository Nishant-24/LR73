import React, { useState, useEffect, useRef } from 'react';
import ClayIcon from '@clayui/icon';
import { unwrapResult } from '@reduxjs/toolkit';
import { useSelector, useDispatch } from 'react-redux';
import { getBookmarksIcon } from '~/Utils/index';
import { addBookmark, removeBookmark } from './BookmarksSlice';
import { alertService } from '~/Toast/index';

const spritemap = themeDisplay.getPathThemeImages() + '/argus/icons.svg';

const AddRemoveBookmark = (props) => {
	const dispatch = useDispatch();

	const [bookmarked, setBookmarked] = useState(props.bookmarked || false);
	const caseId = props.caseId || useSelector((state) => state.modal.caseId);

	const mountedRef = useRef();

	useEffect(() => {
		if (mountedRef.current) {
			if (props.bookmarked !== bookmarked) {
				setBookmarked(props.bookmarked);
			}
		}
	}, [caseId, props.bookmarked]);

	useEffect(() => {
		mountedRef.current = true;
	}, []);

	const addRemoveBookmarkHandler = async (event) => {

		event.preventDefault();
		event.stopPropagation();

		try {
			let resultAction;

			if (bookmarked) {
				resultAction = await dispatch(removeBookmark(caseId));
			} else {
				resultAction = await dispatch(addBookmark(caseId));
			}

			unwrapResult(resultAction);
			setBookmarked(!bookmarked);
		}
		catch (err) {
			alertService.error(Liferay.Language.get('failed-to-add-remove-bookmark'));
		}
	}

	return (
		<a href="javascript:void(0)" onClick={addRemoveBookmarkHandler}>
			<ClayIcon
				className={`case-bookmarks__icon ${getBookmarksIcon(bookmarked)} ${props.className}`}
				spritemap={spritemap}
				symbol={getBookmarksIcon(bookmarked)}
			/>
		</a>
	)
}

export default AddRemoveBookmark;