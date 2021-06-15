import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import { client } from '~/api/client';

const groupId = themeDisplay.getScopeGroupId();

export const getDetails = createAsyncThunk('details/getDetails', async (arg, thunkAPI) => {
	const caseId = thunkAPI.getState().modal.caseId;
	const claimNumber = thunkAPI.getState().modal.claimNumber;
	const response = await client.get(`/o/claim-management/group/${groupId}/claims/?caseId=${caseId}&claimNumber=${claimNumber}&p_auth=${Liferay.authToken}`);
	return response;
});

export const detailsSlice = createSlice({
	name: 'details',
	initialState: {
		data: {
			claims: [],
			page: 1
		},
		error: null,
		status: 'idle',
	},
	extraReducers: {
		[getDetails.pending]: (state, action) => {
			state.status = 'loading';
		},
		[getDetails.fulfilled]: (state, action) => {
			state.status = 'succeeded';
			state.data = action.payload;
		},
		[getDetails.rejected]: (state, action) => {
			state.status = 'failed';
			state.error = action.payload;
		},
	}
});

export default detailsSlice.reducer;