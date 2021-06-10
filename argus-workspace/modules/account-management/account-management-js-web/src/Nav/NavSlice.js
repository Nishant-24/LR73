import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';

const groupId = themeDisplay.getScopeGroupId();

export const getNavLayouts = createAsyncThunk('nav/getNavLayouts', async () => {
	const parentLayoutId = themeDisplay.getParentLayoutId();
	const layoutId = themeDisplay.getLayoutId();
	const layoutSetFriendlyURL = themeDisplay.getLayoutSetFriendlyURL();
	let response = [];

	const layouts = await getLayouts();

	const parentLayout = layouts.find(layout => layout.layoutId === (parentLayoutId === '0' ? layoutId : parentLayoutId));
	const childLayouts = await getLayouts(parentLayout.layoutId);

	parentLayout.layoutSetFriendlyURL = layoutSetFriendlyURL + parentLayout.friendlyURL;
	childLayouts.map(layout => {
		layout.layoutSetFriendlyURL = layoutSetFriendlyURL + layout.friendlyURL;
	});

	response.push(parentLayout, ...childLayouts);

	return response;
});

const getLayouts = (parentLayoutId = 0) => {
	return Liferay.Service(
		'/layout/get-layouts',
		{
			groupId: groupId,
			parentLayoutId: parentLayoutId,
			privateLayout: true,
		}
	);
}

export const NavSlice = createSlice({
	name: 'nav',
	initialState: {
		data: [],
		error: null,
		status: 'idle',
	},
	reducers: {},
	extraReducers: {
		[getNavLayouts.pending]: (state, action) => {
			state.status = 'loading';
		},
		[getNavLayouts.fulfilled]: (state, action) => {
			state.status = 'succeeded';
			state.data = action.payload;
		},
		[getNavLayouts.rejected]: (state, action) => {
			state.status = 'failed';
			state.error = action.payload;
		},
	},
})

export default NavSlice.reducer;

