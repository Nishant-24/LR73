import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import { client } from '~/api/client';
import { getDateRangeFormat } from '~/Utils/index';

export const getBreakoutByPaidAmount = createAsyncThunk('closed/getBreakoutByPaidAmount', async (arg, thunkAPI) => {
	const dateRange = getDateRangeFormat(thunkAPI.getState().claims.dateRange);
	const response = await client.get(`/o/claim-analytics/chart-claim-breakout?status=Closed&sum=paidAmount&term=chargedRange&startDate=${dateRange.startDate}&endDate=${dateRange.endDate}&p_auth=${Liferay.authToken}`);
	return response;
});

export const getBreakoutByVolume = createAsyncThunk('closed/getBreakoutByVolume', async (arg, thunkAPI) => {
	const dateRange = getDateRangeFormat(thunkAPI.getState().claims.dateRange);
	const response = await client.get(`/o/claim-analytics/chart-claim-breakout?status=Closed&sum=paidAmount&term=chargedRange&startDate=${dateRange.startDate}&endDate=${dateRange.endDate}&p_auth=${Liferay.authToken}`);
	return response;
});

export const getBreakoutBySavingsRange = createAsyncThunk('closed/getBreakoutBySavingsRange', async (arg, thunkAPI) => {
	const dateRange = getDateRangeFormat(thunkAPI.getState().claims.dateRange);
	const response = await client.get(`/o/claim-analytics/chart-claim-breakout-avg/closed?startDate=${dateRange.startDate}&endDate=${dateRange.endDate}&p_auth=${Liferay.authToken}`);
	return response;
});

export const getPaidAmountArea = createAsyncThunk('closed/getPaidAmountArea', async (arg, thunkAPI) => {
	const dateRange = getDateRangeFormat(thunkAPI.getState().claims.dateRange);
	const response = await client.get(`/o/claim-analytics/chart-claim-area?status=Closed&overallAvgField=financialExposure&startDate=${dateRange.startDate}&endDate=${dateRange.endDate}&p_auth=${Liferay.authToken}`);
	return response;
})

export const ClosedSlice = createSlice({
	name: 'closed',
	initialState: {
		activeTab: 0,
		charts: {
			claimVolume: {},
			paidAmount: {},
			paidAmountArea: {},
			savingsRange: {
				data: {
					averageX: 0,
					averageY: 0,
					savingRanges: [],
					chargedRanges: [],
				}
			},
		},
		error: {
			claimVolume: null,
			paidAmount: null,
			paidAmountArea: null,
			savingsRange: null,
		},
		status: {
			claimVolume: 'idle',
			paidAmount: 'idle',
			paidAmountArea: 'idle',
			savingsRange: 'idle',
		}
	},
	reducers: {
		setActiveTab: (state, action) => {
			state.activeTab = action.payload;
		}
	},
	extraReducers: {
		[getBreakoutByPaidAmount.pending]: (state, action) => {
			state.status.paidAmount = 'loading';
		},
		[getBreakoutByPaidAmount.fulfilled]: (state, action) => {
			state.status.paidAmount = 'succeeded';
			state.charts.paidAmount = action.payload;
		},
		[getBreakoutByPaidAmount.rejected]: (state, action) => {
			state.status.paidAmount = 'failed';
			state.error.paidAmount = action.payload;
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
		[getBreakoutBySavingsRange.pending]: (state, action) => {
			state.status.savingsRange = 'loading';
		},
		[getBreakoutBySavingsRange.fulfilled]: (state, action) => {
			state.status.savingsRange = 'succeeded';
			state.charts.savingsRange = action.payload;
		},
		[getBreakoutBySavingsRange.rejected]: (state, action) => {
			state.status.savingsRange = 'failed';
			state.error.savingsRange = action.payload;
		},
		[getPaidAmountArea.pending]: (state, action) => {
			state.status.paidAmountArea = 'loading';
		},
		[getPaidAmountArea.fulfilled]: (state, action) => {
			state.status.paidAmountArea = 'succeeded';
			state.charts.paidAmountArea = action.payload;
		},
		[getPaidAmountArea.rejected]: (state, action) => {
			state.status.paidAmountArea = 'failed';
			state.error.paidAmountArea = action.payload;
		},
	},
})

export const { setActiveTab } = ClosedSlice.actions;

export default ClosedSlice.reducer;