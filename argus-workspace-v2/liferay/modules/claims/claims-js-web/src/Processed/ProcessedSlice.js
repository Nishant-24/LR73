import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import { client } from '~/api/client';
import { getDateRangeFormat } from '~/Utils/index';

export const getBreakoutByRepricedAmount = createAsyncThunk('processed/getBreakoutByRepricedAmount', async (arg, thunkAPI) => {
	const dateRange = getDateRangeFormat(thunkAPI.getState().claims.dateRange);
	const response = await client.get(`/o/claim-analytics/chart-claim-breakout?status=Processed&sum=repricedAmount&term=chargedRange&startDate=${dateRange.startDate}&endDate=${dateRange.endDate}&p_auth=${Liferay.authToken}`);
	return response;
});

export const getBreakoutByVolume = createAsyncThunk('processed/getBreakoutByVolume', async (arg, thunkAPI) => {
	const dateRange = getDateRangeFormat(thunkAPI.getState().claims.dateRange);
	const response = await client.get(`/o/claim-analytics/chart-claim-breakout?status=Processed&sum=repricedAmount&term=chargedRange&startDate=${dateRange.startDate}&endDate=${dateRange.endDate}&p_auth=${Liferay.authToken}`);
	return response;
});

export const getRepricedAmountArea = createAsyncThunk('processed/getRepricedAmountArea', async (arg, thunkAPI) => {
	const dateRange = getDateRangeFormat(thunkAPI.getState().claims.dateRange);
	const response = await client.get(`/o/claim-analytics/chart-claim-area?status=Processed&overallAvgField=financialExposure&startDate=${dateRange.startDate}&endDate=${dateRange.endDate}&p_auth=${Liferay.authToken}`);
	return response;
})

export const ProcessedSlice = createSlice({
	name: 'processed',
	initialState: {
		activeTab: 0,
		charts: {
			claimVolume: {},
			repricedAmount: {},
			repricedAmountArea: {}
		},
		error: {
			claimVolume: null,
			repricedAmount: null,
			repricedAmountArea: null
		},
		status: {
			claimVolume: 'idle',
			repricedAmount: 'idle',
			repricedAmountArea: 'idle'
		},
	},
	reducers: {
		setActiveTab: (state, action) => {
			state.activeTab = action.payload;
		}
	},
	extraReducers: {
		[getBreakoutByRepricedAmount.pending]: (state, action) => {
			state.status.repricedAmount = 'loading';
		},
		[getBreakoutByRepricedAmount.fulfilled]: (state, action) => {
			state.status.repricedAmount = 'succeeded';
			state.charts.repricedAmount = action.payload;
		},
		[getBreakoutByRepricedAmount.rejected]: (state, action) => {
			state.status.repricedAmount = 'failed';
			state.error.repricedAmount = action.payload;
		},
		[getBreakoutByVolume.pending]: (state, action) => {
			state.status.claimVolume = 'loading';
		},
		[getBreakoutByVolume.fulfilled]: (state, action) => {
			state.status.claimVolume = 'succeeded';
			state.charts.claimVolume = action.payload;
		},
		[getBreakoutByVolume.rejected]: (state, action) => {
			state.status.claimVolume = 'failed';
			state.error.claimVolume = action.payload;
		},
		[getRepricedAmountArea.pending]: (state, action) => {
			state.status.repricedAmountArea = 'loading';
		},
		[getRepricedAmountArea.fulfilled]: (state, action) => {
			state.status.repricedAmountArea = 'succeeded';
			state.charts.repricedAmountArea = action.payload;
		},
		[getRepricedAmountArea.rejected]: (state, action) => {
			state.status.repricedAmountArea = 'failed';
			state.error.repricedAmountArea = action.payload;
		},
	},
})

export const { setActiveTab } = ProcessedSlice.actions;

export default ProcessedSlice.reducer;