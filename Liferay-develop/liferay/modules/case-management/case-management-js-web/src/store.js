import { configureStore, getDefaultMiddleware } from '@reduxjs/toolkit';
import authorizationsReducer from '~/Authorizations/AuthorizationsSlice';
import bookmarksReducer from '~/Bookmarks/BookmarksSlice';
import casesReducer from '~/Cases/CasesSlice';
import detailsReducer from '~/Details/DetailsSlice';
import modalReducer from '~/Modal/ModalSlice';
import navReducer from '~/Nav/NavSlice';
import notesReducer from '~/Notes/NotesSlice';
import tasksReducer from '~/Tasks/TasksSlice';

export default configureStore({
	middleware: [...getDefaultMiddleware({immutableCheck: false, serializableCheck: false})],
	reducer: {
		authorizations: authorizationsReducer,
		bookmarks: bookmarksReducer,
		cases: casesReducer,
		details: detailsReducer,
		modal: modalReducer,
		nav: navReducer,
		notes: notesReducer,
		tasks: tasksReducer
	}
});