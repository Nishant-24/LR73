import React from 'react';
import ClayLayout from '@clayui/layout';
import ClayButton from '@clayui/button';

const Buttons = () => {
	return (
		<ClayLayout.Sheet className="mb-5">
			<ClayLayout.SheetHeader>
				<h3 className="sheet-title">Buttons</h3>
			</ClayLayout.SheetHeader>
			<ClayLayout.SheetSection>
				<h4 className="sheet-subtitle">Primary</h4>
				<div className="sheet-text">
					<ClayButton.Group spaced>
						<ClayButton displayType="primary">Default</ClayButton>
						<ClayButton displayType="primary" className="focus">Focus</ClayButton>
						<ClayButton displayType="primary" className="active">Active</ClayButton>
						<ClayButton displayType="primary" disabled>Disabled</ClayButton>
					</ClayButton.Group>
				</div>
			</ClayLayout.SheetSection>

			<ClayLayout.SheetSection>
				<h4 className="sheet-subtitle">Outline Primary</h4>
				<div className="sheet-text">
					<ClayButton.Group spaced>
						<ClayButton displayType="primary" outline="true">Default</ClayButton>
						<ClayButton displayType="primary" outline="true" className="focus">Focus</ClayButton>
						<ClayButton displayType="primary" outline="true" className="active">Active</ClayButton>
						<ClayButton displayType="primary" outline="true" disabled>Disabled</ClayButton>
					</ClayButton.Group>
				</div>
			</ClayLayout.SheetSection>

			<ClayLayout.SheetSection>
				<h4 className="sheet-subtitle">Approve</h4>
				<div className="sheet-text">
					<ClayButton.Group spaced>
						<ClayButton displayType="success">Default</ClayButton>
						<ClayButton displayType="success" className="focus">Focus</ClayButton>
						<ClayButton displayType="success" className="active">Active</ClayButton>
						<ClayButton displayType="success" disabled>Disabled</ClayButton>
					</ClayButton.Group>
				</div>
			</ClayLayout.SheetSection>
		</ClayLayout.Sheet>
	);
};

export default Buttons;