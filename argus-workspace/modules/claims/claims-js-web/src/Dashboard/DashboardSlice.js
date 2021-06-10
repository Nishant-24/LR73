import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import { client } from '~/api/client';
import { getDateRangeFormat } from '~/Utils/index';

export const getFinancialExposure = createAsyncThunk('dashboard/getFinancialExposure', async (arg, thunkAPI) => {
	const dateRange = getDateRangeFormat(thunkAPI.getState().claims.dateRange);
	const response = await client.get(`/o/claim-analytics/chart-claim-stacked-area?volume=false&startDate=${dateRange.startDate}&endDate=${dateRange.endDate}&p_auth=${Liferay.authToken}`);
	return response;
});

export const getFinancialExposureVolume = createAsyncThunk('dashboard/getFinancialExposureVolume', async (arg, thunkAPI) => {
	const dateRange = getDateRangeFormat(thunkAPI.getState().claims.dateRange);
	const response = await client.get(`/o/claim-analytics/chart-claim-stacked-area?volume=true&startDate=${dateRange.startDate}&endDate=${dateRange.endDate}&p_auth=${Liferay.authToken}`);
	return response;
});

export const getFinancialExposureTopProviders = createAsyncThunk('dashboard/getFinancialExposureTopProviders', async (arg, thunkAPI) => {
	const dateRange = getDateRangeFormat(thunkAPI.getState().claims.dateRange);
	const response = await client.get(`/o/claim-analytics/chart-providers-claims?startDate=${dateRange.startDate}&endDate=${dateRange.endDate}&p_auth=${Liferay.authToken}`);
	return response;
});

export const getFinancialExposureTopSavings = createAsyncThunk('dashboard/getFinancialExposureTopSavings', async (arg, thunkAPI) => {
	const dateRange = getDateRangeFormat(thunkAPI.getState().claims.dateRange);
	const response = await client.get(`/o/claim-analytics/chart-providers-claims?field=savingsAmount&startDate=${dateRange.startDate}&endDate=${dateRange.endDate}&p_auth=${Liferay.authToken}`);
	return response;
});

export const DashboardSlice = createSlice({
	name: 'dashboard',
	initialState: {
		activeTab: 0,
		charts: {
			financialExposure: {},
			financialExposureVolume: {},
			financialExposureTopProviders: {},
			financialExposureTopSavings: {},
		},
		data: {},
		error: {
			financialExposure: null,
			financialExposureVolume: null,
			financialExposureTopProviders: null,
			financialExposureTopSavings: null,
		},
		status: {
			financialExposure: 'idle',
			financialExposureVolume: 'idle',
			financialExposureTopProviders: 'idle',
			financialExposureTopSavings: 'idle',
		},
	},
	reducers: {
		setActiveTab: (state, action) => {
			state.activeTab = action.payload;
		},
	},
	extraReducers: {
		[getFinancialExposure.pending]: (state, action) => {
			state.status.financialExposure = 'loading';
		},
		[getFinancialExposure.fulfilled]: (state, action) => {
			state.status.financialExposure = 'succeeded';
			state.charts.financialExposure = action.payload;
		},
		[getFinancialExposure.rejected]: (state, action) => {
			state.status.financialExposure = 'failed';
			state.error.financialExposure = action.payload;
		},
		[getFinancialExposureVolume.pending]: (state, action) => {
			state.status.financialExposureVolume = 'loading';
		},
		[getFinancialExposureVolume.fulfilled]: (state, action) => {
			state.status.financialExposureVolume = 'succeeded';
			state.charts.financialExposureVolume = action.payload;
		},
		[getFinancialExposureVolume.rejected]: (state, action) => {
			state.status.financialExposureVolume = 'failed';
			state.error.financialExposureVolume = action.payload;
		},
		[getFinancialExposureTopProviders.pending]: (state, action) => {
			state.status.financialExposureTopProviders = 'loading';
		},
		[getFinancialExposureTopProviders.fulfilled]: (state, action) => {
			state.status.financialExposureTopProviders = 'succeeded';
			state.charts.financialExposureTopProviders = action.payload;
		},
		[getFinancialExposureTopProviders.rejected]: (state, action) => {
			state.status.financialExposureTopProviders = 'failed';
			state.error.financialExposureTopProviders = action.payload;
		},
		[getFinancialExposureTopSavings.pending]: (state, action) => {
			state.status.financialExposureTopSavings = 'loading';
		},
		[getFinancialExposureTopSavings.fulfilled]: (state, action) => {
			state.status.financialExposureTopSavings = 'succeeded';
			state.charts.financialExposureTopSavings = action.payload;
		},
		[getFinancialExposureTopSavings.rejected]: (state, action) => {
			state.status.financialExposureTopSavings = 'failed';
			state.error.financialExposureTopSavings = action.payload;
		},
	},
})

export const { setActiveTab } = DashboardSlice.actions;

export default DashboardSlice.reducer;