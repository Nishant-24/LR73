import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import { client } from '~/api/client';

const groupId = themeDisplay.getScopeGroupId();

export const addNewTask = createAsyncThunk('tasks/addNewTask', async (initialPost) => {
	const response = await client.post(`/o/case-task/group/${groupId}/task?p_auth=${Liferay.authToken}`, initialPost );
	return response;
});

export const getTasks = createAsyncThunk('tasks/getTasks', async (arg, thunkAPI) => {
	const caseId = thunkAPI.getState().modal.caseId;
	const response = await client.get(`/o/case-task/group/${groupId}/task/?caseId=${caseId}&start=${arg.start}&end=${arg.end}&p_auth=${Liferay.authToken}`);
	return response;
});

export const getTaskTypeReferenceTypeCodes = createAsyncThunk('tasks/getTaskTypeReferenceTypeCodes', async () => {
	const response = await client.get(`/o/reference-type-code/group/${groupId}/type/TaskType?p_auth=${Liferay.authToken}`);
	return response;
});

export const reloadTasks = createAsyncThunk('tasks/reloadTasks', async (arg, thunkAPI) => {
	const caseId = thunkAPI.getState().modal.caseId;
	const response = await client.get(`/o/case-task/group/${groupId}/task/?caseId=${caseId}&start=0&end=20&p_auth=${Liferay.authToken}`);
	return response;
});

export const tasksSlice = createSlice({
	name: 'tasks',
	initialState: {
		data: [],
		error: null,
		showAddTask: false,
		status: 'idle',
		taskId: null,
		taskPriorityReferenceTypeCodes: [
			{ label: Liferay.Language.get('high'), value: '004:High' },
			{ label: Liferay.Language.get('medium'), value: '004:Medium' },
			{ label: Liferay.Language.get('low'), value: '004:Low' },
		],
		taskTypeReferenceTypeCodes: [],
	},
	reducers: {
		resetData: (state, action) => {
			state.data = [];
		},
		setShowAddTask: (state, action) => {
			state.showAddTask = action.payload;
			state.taskId = null;
		},
		setTaskId: (state, action) => {
			state.taskId = action.payload;
		},
	},
	extraReducers: {
		[getTasks.pending]: (state, action) => {
			state.status = 'loading';
		},
		[getTasks.fulfilled]: (state, action) => {
			state.status = 'succeeded';
			state.data = state.data.concat(action.payload);
		},
		[getTasks.rejected]: (state, action) => {
			state.status = 'failed';
			state.error = action.payload;
		},
		[reloadTasks.pending]: (state, action) => {
			state.status = 'loading';
		},
		[reloadTasks.fulfilled]: (state, action) => {
			state.status = 'succeeded';
			state.data = action.payload;
		},
		[reloadTasks.rejected]: (state, action) => {
			state.status = 'failed';
			state.error = action.payload;
		},
		[getTaskTypeReferenceTypeCodes.fulfilled]: (state, action) => {
			state.taskTypeReferenceTypeCodes = action.payload.map((item) => ({ label: item.description, value: item.key }));
		},
	},
})

export const { resetData, setTaskId, setShowAddTask } = tasksSlice.actions;

export default tasksSlice.reducer;

