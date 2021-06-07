import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import { client } from '~/api/client';

export const getAvgDownTime = createAsyncThunk('sla/getAvgDownTime', async () => {
	const response = await client.get(`/o/account-management/phone-stats?averageField=avgDownTime&overallAvgField=overallAvgDownTime&goalField=downTimeGoal&p_auth=${Liferay.authToken}`);
	return response;
});

export const getAvgSpeed = createAsyncThunk('sla/getAvgSpeed', async () => {
	const response = await client.get(`/o/account-management/phone-stats?averageField=avgSpeedOfAnswer&overallAvgField=overallAvgSpeedOfAnswer&goalField=speedAnswerGoal&p_auth=${Liferay.authToken}`);
	return response;
});

export const getAbandonmentRate = createAsyncThunk('sla/getAbandonmentRate', async () => {
	const response = await client.get(`/o/account-management/phone-stats?averageField=abandonmentRate&overallAvgField=overallAvgAbandonmentRate&goalField=abandonmentRateGoal&p_auth=${Liferay.authToken}`);
	return response;
});

export const getClaimsTurnaroundTime = createAsyncThunk('sla/getClaimsTurnaroundTime', async () => {
	const response = await client.get(`/o/account-management/claim-stats?averageField=avgClaimTurnAround&overallAvgField=overallAvgClaimTurnAround&goalField=claimTurnAroundGoal&p_auth=${Liferay.authToken}`);
	return response;
});

export const InProcessSlice = createSlice({
	name: 'sla',
	initialState: {
		charts: {
			abandonmentRate: {},
			avgDownTime: {},
			avgSpeed: {},
			claimsTurnaroundTime: {}
		},
		error: {
			abandonmentRate: null,
			avgDownTime: null,
			avgSpeed: null,
			claimsTurnaroundTime: null
		},
		status: {
			abandonmentRate: 'idle',
			avgDownTime: 'idle',
			avgSpeed: 'idle',
			claimsTurnaroundTime: 'idle'
		},
	},
	reducers: {},
	extraReducers: {
		[getAvgDownTime.pending]: (state, action) => {
			state.status.avgDownTime = 'loading';
		},
		[getAvgDownTime.fulfilled]: (state, action) => {
			state.status.avgDownTime = 'succeeded';
			state.charts.avgDownTime = action.payload;
		},
		[getAvgDownTime.rejected]: (state, action) => {
			state.status.avgDownTime = 'failed';
			state.error.avgDownTime = action.payload;
		},
		[getAvgSpeed.pending]: (state, action) => {
			state.status.avgSpeed = 'loading';
		},
		[getAvgSpeed.fulfilled]: (state, action) => {
			state.status.avgSpeed = 'succeeded';
			state.charts.avgSpeed = action.payload;
		},
		[getAvgSpeed.rejected]: (state, action) => {
			state.status.avgSpeed = 'failed';
			state.error.avgSpeed = action.payload;
		},
		[getAbandonmentRate.pending]: (state, action) => {
			state.status.abandonmentRate = 'loading';
		},
		[getAbandonmentRate.fulfilled]: (state, action) => {
			state.status.abandonmentRate = 'succeeded';
			state.charts.abandonmentRate = action.payload;
		},
		[getAbandonmentRate.rejected]: (state, action) => {
			state.status.abandonmentRate = 'failed';
			state.error.abandonmentRate = action.payload;
		},
		[getClaimsTurnaroundTime.pending]: (state, action) => {
			state.status.claimsTurnaroundTime = 'loading';
		},
		[getClaimsTurnaroundTime.fulfilled]: (state, action) => {
			state.status.claimsTurnaroundTime = 'succeeded';
			state.charts.claimsTurnaroundTime = action.payload;
		},
		[getClaimsTurnaroundTime.rejected]: (state, action) => {
			state.status.claimsTurnaroundTime = 'failed';
			state.error.claimsTurnaroundTime = action.payload;
		}
	},
})

export default InProcessSlice.reducer;