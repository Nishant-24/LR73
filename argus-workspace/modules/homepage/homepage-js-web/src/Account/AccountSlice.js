import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import { client } from '~/api/client';

export const getAccountStats = createAsyncThunk('account/getAccountStats', async (status, thunkAPI) => {
	const response = await client.get(`/o/account-management/homepage-stats?p_auth=${Liferay.authToken}`);
	return response;
});

export const AccountSlice = createSlice({
	name: 'account',
	initialState: {
		chart: {},
		error: null,
		status: 'idle',
	},
	reducers: {},
	extraReducers: {
		[getAccountStats.pending]: (state, action) => {
			state.status = 'loading';
		},
		[getAccountStats.fulfilled]: (state, action) => {
			state.status = 'succeeded';
			state.chart = action.payload;
		},
		[getAccountStats.rejected]: (state, action) => {
			state.status = 'failed';
			state.error = action.payload;
		},
	},
})

export default AccountSlice.reducer;