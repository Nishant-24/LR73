import React, { useEffect } from 'react';
import ClayTabs from '@clayui/tabs'
import { useDispatch, useSelector } from 'react-redux'
import { getNavLayouts } from './NavSlice';

const AccountNav = (props) => {
	const dispatch = useDispatch();
	const layouts = useSelector((state) => state.nav.data);
	const status = useSelector((state) => state.nav.status);

	useEffect(() => {
		if (status === 'idle') {
			dispatch(getNavLayouts());
		}
	}, [status, dispatch]);

	return (
		<React.Fragment>
			<div className="px-3 pt-3 bg-secondary">
				<ClayTabs modern={false}>
					<ClayTabs.Item active={true}>
						{Liferay.Language.get('account-management')}
					</ClayTabs.Item>
				</ClayTabs>
			</div>

			<div className="px-3 pt-3">
				<ClayTabs>
					{layouts.map((layout, index) => (
						<ClayTabs.Item
							active={layout.layoutId === themeDisplay.getLayoutId()}
							href={layout.layoutSetFriendlyURL}
							key={index}
						>
							{layout.titleCurrentValue}
						</ClayTabs.Item>
					))}
				</ClayTabs>
			</div>
			<div>
				{props.children}
			</div>
		</React.Fragment>
	)
}

export default AccountNav;