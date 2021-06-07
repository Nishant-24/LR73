import { createSlice, createAsyncThunk } from '@reduxjs/toolkit';
import { ACCOUNT_MANAGEMENT_FURL, CASES_FURL, CLAIMS_FURL } from '~/Utils/index';

const groupId = themeDisplay.getScopeGroupId();

const getNavLayouts = async (layouts, friendlyUrl) => {
    const layoutSetFriendlyURL = themeDisplay.getLayoutSetFriendlyURL();
    let response = [];

    const parentLayout = layouts.find(layout => layout.friendlyURL === friendlyUrl);
    const childLayouts = await getLayouts(parentLayout.layoutId);

    parentLayout.layoutSetFriendlyURL = layoutSetFriendlyURL + parentLayout.friendlyURL;

    childLayouts.map(layout => {
        layout.layoutSetFriendlyURL = layoutSetFriendlyURL + layout.friendlyURL;
    });

    response.push(parentLayout, ...childLayouts);

    return response;
};

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

export const getHomeLayouts = createAsyncThunk('layouts/getHomeLayouts', async () => {
    const response = {};
    const layouts = await getLayouts();

    response.sla = await getNavLayouts(layouts, ACCOUNT_MANAGEMENT_FURL);
    response.cases = await getNavLayouts(layouts, CASES_FURL);
    response.claims = await getNavLayouts(layouts, CLAIMS_FURL);

    return response;
});

export const LayoutsSlice = createSlice({
	name: 'layouts',
	initialState: {
		data: {
			cases: [],
			claims: [],
			sla: [],
		}
	},
	reducers: {},
	extraReducers: {
		[getHomeLayouts.fulfilled]: (state, action) => {
			state.data = action.payload;
		},
	},
})

export default LayoutsSlice.reducer;