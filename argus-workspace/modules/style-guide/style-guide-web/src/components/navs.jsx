import React from 'react';
import ClayLayout from '@clayui/layout';
import ClayNav from '@clayui/nav';
import ClayTabs from '@clayui/tabs';

const Navs = () => {
	return (
		<ClayLayout.Sheet className="mb-5">
			<ClayLayout.SheetHeader>
				<h3 className="sheet-title">Navs</h3>
			</ClayLayout.SheetHeader>
			<ClayLayout.SheetSection>
				<h4 className="sheet-subtitle">Tabs</h4>
				<div className="sheet-text">
					<ClayTabs modern={false}>
						<ClayTabs.Item active={true}>{"Active"}</ClayTabs.Item>
						<ClayTabs.Item>{"Default"}</ClayTabs.Item>
						<ClayTabs.Item disabled>{"Disabled"}</ClayTabs.Item>
					</ClayTabs>
				</div>
			</ClayLayout.SheetSection>

			<ClayLayout.SheetSection>
				<h4 className="sheet-subtitle">Underline</h4>
				<div className="sheet-text">
					<ClayTabs>
						<ClayTabs.Item active={true}>{"Active"}</ClayTabs.Item>
						<ClayTabs.Item>{"Default"}</ClayTabs.Item>
						<ClayTabs.Item disabled>{"Disabled"}</ClayTabs.Item>
					</ClayTabs>
				</div>
			</ClayLayout.SheetSection>

			<ClayLayout.SheetSection>
				<h4 className="sheet-subtitle">Pills</h4>
				<div className="sheet-text">
					<ClayNav className="nav-pills">
						<ClayNav.Item>
							<ClayNav.Link active href="#">{"Active"}</ClayNav.Link>
						</ClayNav.Item>
						<ClayNav.Item>
							<ClayNav.Link href="#">{"Default"}</ClayNav.Link>
						</ClayNav.Item>
						<ClayNav.Item>
							<ClayNav.Link disabled href="#">{"Disabled"}</ClayNav.Link>
						</ClayNav.Item>
					</ClayNav>
				</div>
			</ClayLayout.SheetSection>
		</ClayLayout.Sheet>
	);
};

export default Navs;