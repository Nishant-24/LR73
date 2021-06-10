import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import { client } from '~/api/client';

export const getRecentClaims = createAsyncThunk('claims/getRecentClaims', async () => {
	const response = await client.get(`/o/claim-analytics/chart-recent-claims?p_auth=${Liferay.authToken}`);
	return response;
});

export const ClaimsSlice = createSlice({
	name: 'claims',
	initialState: {
		chart: {},
		error: null,
		layouts: [],
		status: 'idle',
	},
	reducers: {},
	extraReducers: {
		[getRecentClaims.pending]: (state, action) => {
			state.status = 'loading';
		},
		[getRecentClaims.fulfilled]: (state, action) => {
			state.status = 'succeeded';
			state.chart = action.payload;
		},
		[getRecentClaims.rejected]: (state, action) => {
			state.status = 'failed';
			state.error = action.payload;
		},
	},
})

export default ClaimsSlice.reducer;