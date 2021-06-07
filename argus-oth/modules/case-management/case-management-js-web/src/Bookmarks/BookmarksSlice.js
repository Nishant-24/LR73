import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import { client } from '~/api/client';

export const getBookmarks = createAsyncThunk('bookmarks/getBookmarks', async () => {
	const groupId = themeDisplay.getScopeGroupId();
	const response = await client.get(`/o/case-management/group/${groupId}/bookmarks?rowLimit=10&p_auth=${Liferay.authToken}`);
    return response;
});

export const addBookmark = createAsyncThunk('bookmarks/addBookmark', async (caseId, thunkAPI) => {
    const response = await client.post(
        `/o/case-management/case/${caseId}/bookmark/add?p_auth=${Liferay.authToken}`,
        {
            method: 'POST'
        }
    );

    return response;
});

export const removeBookmark = createAsyncThunk('bookmarks/removeBookmark', async (caseId, thunkAPI) => {
    const response = await client.post(
        `/o/case-management/case/${caseId}/bookmark/remove?p_auth=${Liferay.authToken}`,
        {
            method: 'POST'
        }
    );

    return response;
});

export const BookmarksSlice = createSlice({
	name: 'bookmarks',
    initialState: {
		data: [],
		error: null,
        status: 'idle',
    },
    reducers: {},
    extraReducers: {
        [getBookmarks.pending]: (state, action) => {
            state.status = 'loading';
        },
        [getBookmarks.fulfilled]: (state, action) => {
            state.status = 'succeeded';
            state.data = action.payload;
        },
        [getBookmarks.rejected]: (state, action) => {
            state.status = 'failed';
            state.error = action.payload;
        }
    }
})

export default BookmarksSlice.reducer;