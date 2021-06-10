import { configureStore, getDefaultMiddleware } from '@reduxjs/toolkit';
import authorizationsReducer from '~/Authorizations/AuthorizationsSlice';
import claimsReducer from '~/Claims/ClaimsSlice';
import closedReducer from '~/Closed/ClosedSlice';
import dashboardReducer from '~/Dashboard/DashboardSlice';
import detailsReducer from '~/Details/DetailsSlice';
import inProcessReducer from '~/InProcess/InProcessSlice';
import modalReducer from '~/Modal/ModalSlice';
import navReducer from '~/Nav/NavSlice';
import notesReducer from '~/Notes/NotesSlice';
import processedReducer from '~/Processed/ProcessedSlice';
import tasksReducer from '~/Tasks/TasksSlice';

export default configureStore({
	middleware: [...getDefaultMiddleware({immutableCheck: false, serializableCheck: false})],
	reducer: {
		authorizations: authorizationsReducer,
		claims: claimsReducer,
		closed: closedReducer,
		dashboard: dashboardReducer,
		details: detailsReducer,
		inProcess: inProcessReducer,
		modal: modalReducer,
		nav: navReducer,
		notes: notesReducer,
		processed: processedReducer,
		tasks: tasksReducer
	}
});