import { configureStore } from '@reduxjs/toolkit';
import navReducer from './Nav/NavSlice';
import slaReducer from './SLA/SLASlice';

export default configureStore({
	reducer: {
		nav: navReducer,
		sla: slaReducer,
	}
});