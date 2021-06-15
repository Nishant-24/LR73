import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import { client } from '~/api/client';
import { getDateRangeFormat } from '~/Utils/index';

const groupId = themeDisplay.getScopeGroupId();

export const defaultDateRange = themeDisplay.getDefaultDateRange();

const savedFilters = ('React::Claims::Filters' in sessionStorage) ? JSON.parse(sessionStorage.getItem('React::Claims::Filters')) : [];
const savedDateRange = ('React::Claims::DateRange' in sessionStorage) ? sessionStorage.getItem('React::Claims::DateRange') : defaultDateRange;

export const getClaimsByStatus = createAsyncThunk('claims/getClaimsByStatus', async (status, thunkAPI) => {
	const dateRange = getDateRangeFormat(thunkAPI.getState().claims.dateRange);
	const response = await client.get(`/o/claim-analytics/status/${status}?startDate=${dateRange.startDate}&endDate=${dateRange.endDate}&p_auth=${Liferay.authToken}`);
	return response;
});

export const getPermissions = createAsyncThunk('getPermissions', async () => {
	const response = await client.get(`/o/permission/permission?p_auth=${Liferay.authToken}`);
	return response;
});

export const ClaimsSlice = createSlice({
	name: 'claims',
	initialState: {
		data: [],
		dateRange: savedDateRange,
		error: null,
		filters: savedFilters,
		permissions: [],
		status: 'idle',
	},
	reducers: {
		resetDateRange: (state, action) => {
			state.dateRange = defaultDateRange;
			sessionStorage.removeItem('React::Claims::DateRange');
		},
		resetFilters: (state, action) => {
			state.filters = [];
			sessionStorage.removeItem('React::Claims::Filters');
		},
		setDateRange: (state, action) => {
			state.dateRange = action.payload;
			sessionStorage.setItem('React::Claims::DateRange', action.payload);
		},
		setFilters: (state, action) => {
			state.filters = action.payload;
			sessionStorage.setItem('React::Claims::Filters', JSON.stringify(action.payload));
		},
	},
	extraReducers: {
		[getClaimsByStatus.pending]: (state, action) => {
			state.status = 'loading';
		},
		[getClaimsByStatus.fulfilled]: (state, action) => {
			state.status = 'succeeded';
			state.data = action.payload;
		},
		[getClaimsByStatus.rejected]: (state, action) => {
			state.status = 'failed';
			state.error = action.payload;
		},
		[getPermissions.fulfilled]: (state, action) => {
			state.permissions = action.payload;
		},
	},
})

export const { resetDateRange, resetFilters, setDateRange, setFilters } = ClaimsSlice.actions;

export default ClaimsSlice.reducer;

