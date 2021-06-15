import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import { client } from '~/api/client';

const groupId = themeDisplay.getScopeGroupId();

export const addNewNote = createAsyncThunk('notes/addNewNote', async (initialPost) => {
	const response = await client.post(`/o/case-note/group/${groupId}/note/?p_auth=${Liferay.authToken}`, initialPost );
	return response;
});

export const getNotes = createAsyncThunk('notes/getNotes', async (arg, thunkAPI) => {
	const caseId = thunkAPI.getState().modal.caseId;
	const response = await client.get(`/o/case-note/group/${groupId}/note/?caseId=${caseId}&start=${arg.start}&end=${arg.end}&p_auth=${Liferay.authToken}`);
	return response;
});

export const reloadNotes = createAsyncThunk('notes/reloadNotes', async (arg, thunkAPI) => {
	const caseId = thunkAPI.getState().modal.caseId;
	const response = await client.get(`/o/case-note/group/${groupId}/note/?caseId=${caseId}&start=0&end=20&p_auth=${Liferay.authToken}`);
	return response;
});

export const notesSlice = createSlice({
	name: 'notes',
	initialState: {
		data: [],
		error: null,
		noteId: null,
		showAddNote: false,
		status: 'idle',
		total: 0
	},
	reducers: {
		resetData: (state, action) => {
			state.data = [];
			state.total = 0;
		},
		setShowAddNote: (state, action) => {
			state.showAddNote = action.payload;
			state.noteId = null;
		},
		setNoteId: (state, action) => {
			state.noteId = action.payload;
		},
	},
	extraReducers: {
		[getNotes.pending]: (state, action) => {
			state.status = 'loading';
		},
		[getNotes.fulfilled]: (state, action) => {
			state.status = 'succeeded';
			state.data = state.data.concat(action.payload.list);
			state.total = action.payload.total;
		},
		[getNotes.rejected]: (state, action) => {
			state.status = 'failed';
			state.error = action.payload;
		},
		[reloadNotes.pending]: (state, action) => {
			state.status = 'loading';
		},
		[reloadNotes.fulfilled]: (state, action) => {
			state.status = 'succeeded';
			state.data = action.payload.list;
			state.total = action.payload.total;
		},
		[reloadNotes.rejected]: (state, action) => {
			state.status = 'failed';
			state.error = action.payload;
		},
	},
})

export const { resetData, setNoteId, setShowAddNote } = notesSlice.actions;

export default notesSlice.reducer;

