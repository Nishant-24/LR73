import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import { client } from '~/api/client';

const groupId = themeDisplay.getScopeGroupId();

export const authorize = createAsyncThunk('authorizations/authorize', async (initialPost) => {
	return await client.post(`/o/case-authorization/group/${groupId}/authorization/${initialPost.authorizeAction}?p_auth=${Liferay.authToken}&authorizationId=${initialPost.authorizationId}`, initialPost );
});

export const getAuthorizations = createAsyncThunk('authorizations/getAuthorizations', async (arg, thunkAPI) => {
	const caseId = thunkAPI.getState().modal.caseId;
	const response = await client.get(`/o/case-authorization/group/${groupId}/authorization/?caseId=${caseId}&p_auth=${Liferay.authToken}`);
	return response;
});

export const authorizationsSlice = createSlice({
	name: 'authorizations',
	initialState: {
		authId: null,
		data: [],
		error: null,
		status: 'idle',
	},
	reducers: {
		setAuthId: (state, action) => {
			state.authId = action.payload;
		},
	},
	extraReducers: {
		[getAuthorizations.pending]: (state, action) => {
			state.status = 'loading';
		},
		[getAuthorizations.fulfilled]: (state, action) => {
			state.status = 'succeeded';
			state.data = action.payload;
		},
		[getAuthorizations.rejected]: (state, action) => {
			state.status = 'failed';
			state.error = action.payload;
		},
	},
})

export const { setAuthId } = authorizationsSlice.actions;

export default authorizationsSlice.reducer;