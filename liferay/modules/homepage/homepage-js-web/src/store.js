import { configureStore, getDefaultMiddleware } from '@reduxjs/toolkit';
import accountReducer from '~/Account/AccountSlice';
import casesReducer from '~/Cases/CasesSlice';
import claimsReducer from '~/Claims/ClaimsSlice';
import layoutsReducer from '~/Layouts/LayoutsSlice';

export default configureStore({
	middleware: [...getDefaultMiddleware({immutableCheck: false, serializableCheck: false})],
	reducer: {
		account: accountReducer,
		cases: casesReducer,
		claims: claimsReducer,
		layouts: layoutsReducer,
	}
});