import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import { client } from '~/api/client';

export const getData = createAsyncThunk('modal/getData', async (arg, thunkAPI) => {
	const caseId = thunkAPI.getState().modal.caseId;
	const response = await client.get(`/o/case-management/case/${caseId}?p_auth=${Liferay.authToken}`);
	return response;
});

export const ModalSlice = createSlice({
	name: 'modal',
	initialState: {
		activeTab: 4,
		caseId: null,
		claimNumber: null,
		data: {
			case: {
				clientGroup: {},
				member: {}
			}
		},
		error: null,
		status: 'idle',
		tabs: [
			Liferay.Language.get('summary'),
			Liferay.Language.get('notes'),
			Liferay.Language.get('tasks'),
			Liferay.Language.get('authorizations'),
			Liferay.Language.get('claim-details'),
		],
	},
	reducers: {
		setActiveTab: (state, action) => {
			state.activeTab = action.payload;
		},
		setCaseId: (state, action) => {
			state.caseId = action.payload;
		},
		setClaimNumber: (state, action) => {
			state.claimNumber = action.payload;
		},
	},
	extraReducers: {
		[getData.pending]: (state, action) => {
			state.status = 'loading';
		},
		[getData.fulfilled]: (state, action) => {
			state.status = 'succeeded';
			state.data = action.payload;
		},
		[getData.rejected]: (state, action) => {
			state.status = 'failed';
			state.error = action.payload;
		},
	},
})

export const { setActiveTab, setCaseId, setClaimNumber } = ModalSlice.actions;

export default ModalSlice.reducer;

