import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import { client } from '~/api/client';

const groupId = themeDisplay.getScopeGroupId();

export const getCases = createAsyncThunk('cases/getCases', async () => {
	const response = await client.get(`/o/case-management/group/${groupId}?p_auth=${Liferay.authToken}`);
	return response;
});

export const getRecentlyViewedCases = createAsyncThunk('cases/getRecentlyViewed', async () => {
	const response = await client.get(`/o/case-management/group/${groupId}/recentlyViewed?rowLimit=10&p_auth=${Liferay.authToken}`);
	return response;
});

export const getPermissions = createAsyncThunk('getPermissions', async () => {
	const response = await client.get(`/o/permission/permission?p_auth=${Liferay.authToken}`);
	return response;
});

export const CasesSlice = createSlice({
	name: 'cases',
	initialState: {
		data: [],
		filters: [],
		permissions: [],
		error: null,
		status: 'idle',
	},
	reducers: {
		setFilters: (state, action) => {
			state.filters = action.payload;
		},
	},
	extraReducers: {
		[getCases.pending]: (state, action) => {
			state.status = 'loading';
		},
		[getCases.fulfilled]: (state, action) => {
			state.status = 'succeeded';
			state.data = action.payload;
		},
		[getCases.rejected]: (state, action) => {
			state.status = 'failed';
			state.error = action.payload;
		},
		[getRecentlyViewedCases.pending]: (state, action) => {
			state.status = 'loading';
		},
		[getRecentlyViewedCases.fulfilled]: (state, action) => {
			state.status = 'succeeded';
			state.data = action.payload;
		},
		[getRecentlyViewedCases.rejected]: (state, action) => {
			state.status = 'failed';
			state.error = action.payload;
		},
		[getPermissions.fulfilled]: (state, action) => {
			state.permissions = action.payload;
		},
	},
})

export const { setFilters } = CasesSlice.actions;

export default CasesSlice.reducer;

