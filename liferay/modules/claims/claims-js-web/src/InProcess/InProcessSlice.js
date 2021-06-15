import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import { client } from '~/api/client';
import { getDateRangeFormat } from '~/Utils/index';

export const getBreakoutByChargedAmount = createAsyncThunk('inProcess/getBreakoutByChargedAmount', async (arg, thunkAPI) => {
	const dateRange = getDateRangeFormat(thunkAPI.getState().claims.dateRange);
	const response = await client.get(`/o/claim-analytics/chart-claim-breakout?status=In Process&sum=chargedAmount&term=chargedRange&startDate=${dateRange.startDate}&endDate=${dateRange.endDate}&p_auth=${Liferay.authToken}`);
	return response;
});

export const getBreakoutByVolume = createAsyncThunk('inProcess/getBreakoutByVolume', async (arg, thunkAPI) => {
	const dateRange = getDateRangeFormat(thunkAPI.getState().claims.dateRange);
	const response = await client.get(`/o/claim-analytics/chart-claim-breakout?status=In Process&sum=chargedAmount&term=chargedRange&startDate=${dateRange.startDate}&endDate=${dateRange.endDate}&p_auth=${Liferay.authToken}`);
	return response;
});

export const getBreakoutByDays = createAsyncThunk('inProcess/getBreakoutByDays', async (arg, thunkAPI) => {
	const dateRange = getDateRangeFormat(thunkAPI.getState().claims.dateRange);
	const response = await client.get(`/o/claim-analytics/chart-claim-breakout?status=In Process&sum=claimAging&term=chargedRange&startDate=${dateRange.startDate}&endDate=${dateRange.endDate}&p_auth=${Liferay.authToken}`);
	return response;
});

export const getChargedAmountArea = createAsyncThunk('inProcess/chargedAmount', async (arg, thunkAPI) => {
	const dateRange = getDateRangeFormat(thunkAPI.getState().claims.dateRange);
	const response = await client.get(`/o/claim-analytics/chart-claim-area?status=In Process&overallAvgField=chargedAmount&startDate=${dateRange.startDate}&endDate=${dateRange.endDate}&p_auth=${Liferay.authToken}`);
	return response;
});

export const getClaimAgingArea = createAsyncThunk('inProcess/claimAging', async (arg, thunkAPI) => {
	const dateRange = getDateRangeFormat(thunkAPI.getState().claims.dateRange);
	const response = await client.get(`/o/claim-analytics/chart-claims-aging?startDate=${dateRange.startDate}&endDate=${dateRange.endDate}&p_auth=${Liferay.authToken}`);
	return response;
});

export const InProcessSlice = createSlice({
	name: 'inProcess',
	initialState: {
		activeTab: 0,
		charts: {
			chargedAmount: {},
			chargedAmountArea: {},
			claimAging: {},
			claimAgingArea: {},
			claimVolume: {},
		},
		error: {
			chargedAmount: null,
			chargedAmountArea: null,
			claimAging: null,
			claimAgingArea: null,
			claimVolume: null,
		},
		status: {
			chargedAmount: 'idle',
			chargedAmountArea: 'idle',
			claimAging: 'idle',
			claimAgingArea: 'idle',
			claimVolume: 'idle',
		},
	},
	reducers: {
		setActiveTab: (state, action) => {
			state.activeTab = action.payload;
		}
	},
	extraReducers: {
		[getBreakoutByChargedAmount.pending]: (state, action) => {
			state.status.chargedAmount = 'loading';
		},
		[getBreakoutByChargedAmount.fulfilled]: (state, action) => {
			state.status.chargedAmount = 'succeeded';
			state.charts.chargedAmount = action.payload;
		},
		[getBreakoutByChargedAmount.rejected]: (state, action) => {
			state.status.chargedAmount = 'failed';
			state.error.chargedAmount = action.payload;
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
		[getBreakoutByDays.pending]: (state, action) => {
			state.status.claimAging = 'loading';
		},
		[getBreakoutByDays.fulfilled]: (state, action) => {
			state.status.claimAging = 'succeeded';
			state.charts.claimAging = action.payload;
		},
		[getBreakoutByDays.rejected]: (state, action) => {
			state.status.claimAging = 'failed';
			state.error.claimAging = action.payload;
		},
		[getChargedAmountArea.pending]: (state, action) => {
			state.status.chargedAmountArea = 'loading';
		},
		[getChargedAmountArea.fulfilled]: (state, action) => {
			state.status.chargedAmountArea = 'succeeded';
			state.charts.chargedAmountArea = action.payload;
		},
		[getChargedAmountArea.rejected]: (state, action) => {
			state.status.chargedAmountArea = 'failed';
			state.error.chargedAmountArea = action.payload;
		},
		[getClaimAgingArea.pending]: (state, action) => {
			state.status.claimAgingArea = 'loading';
		},
		[getClaimAgingArea.fulfilled]: (state, action) => {
			state.status.claimAgingArea = 'succeeded';
			state.charts.claimAgingArea = action.payload;
		},
		[getClaimAgingArea.rejected]: (state, action) => {
			state.status.claimAgingArea = 'failed';
			state.error.claimAgingArea = action.payload;
		},
		
	},
})

export const { setActiveTab } = InProcessSlice.actions;

export default InProcessSlice.reducer;