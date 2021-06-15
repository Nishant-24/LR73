import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import { client } from '~/api/client';

const groupId = themeDisplay.getScopeGroupId();

export const getChartRecentCases = createAsyncThunk('cases/getChartRecentCases', async () => {
	const response = await client.get(`/o/case-management/group/${groupId}/chart-recent-cases?p_auth=${Liferay.authToken}`);
	return response;
});

export const CasesSlice = createSlice({
	name: 'cases',
	initialState: {
		chart: {},
		error: null,
		status: 'idle',
	},
	reducers: {},
	extraReducers: {
		[getChartRecentCases.pending]: (state, action) => {
			state.status = 'loading';
		},
		[getChartRecentCases.fulfilled]: (state, action) => {
			state.status = 'succeeded';
			state.chart = action.payload;
		},
		[getChartRecentCases.rejected]: (state, action) => {
			state.status = 'failed';
			state.error = action.payload;
		},
	},
})

export default CasesSlice.reducer;