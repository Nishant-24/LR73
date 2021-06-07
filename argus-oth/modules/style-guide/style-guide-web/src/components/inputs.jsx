import React from 'react';
import ClayIcon from '@clayui/icon';
import ClayForm, {ClayInput, ClayCheckbox, ClayRadio, ClayToggle} from '@clayui/form';
import ClayLayout from '@clayui/layout';

const spritemap = themeDisplay.getPathThemeImages() + '/lexicon/icons.svg';
const symbol = { off: "plus", on: "hr" };

const Inputs = () => {
	return (
		<ClayLayout.Sheet className="mb-5">
			<ClayLayout.SheetHeader>
				<h3 className="sheet-title">Inputs</h3>
			</ClayLayout.SheetHeader>
			<ClayLayout.SheetSection>
				<h4 className="sheet-subtitle">Text</h4>
				<div className="sheet-text">
					<ClayLayout.Row>
						<ClayLayout.Col>
							<ClayForm.Group>
								<ClayInput id="defaultInputText" placeholder="Default" type="text" />
							</ClayForm.Group>
						</ClayLayout.Col>

						<ClayLayout.Col>
							<ClayForm.Group>
								<ClayInput id="focusInputText" placeholder="Focus" type="text" className="focus" />
							</ClayForm.Group>
						</ClayLayout.Col>

						<ClayLayout.Col>
							<ClayForm.Group>
								<ClayInput id="disableInputText" placeholder="Disabled" type="text" disabled />
							</ClayForm.Group>
						</ClayLayout.Col>
					</ClayLayout.Row>
				</div>
			</ClayLayout.SheetSection>

			<ClayLayout.SheetSection>
				<h4 className="sheet-subtitle">Checkbox</h4>
				<div className="sheet-text">
					<ClayCheckbox label="Default" checked={false} onChange={() => {}} inline />
					<ClayCheckbox label="Checked" checked={true} onChange={() => {}} inline />
					<ClayCheckbox label="Default Disabled" onChange={() => {}} disabled inline />
					<ClayCheckbox label="Checked Disabled" checked={true} onChange={() => {}} disabled inline />
				</div>
			</ClayLayout.SheetSection>

			<ClayLayout.SheetSection>
				<h4 className="sheet-subtitle">Radio</h4>
				<div className="sheet-text">
					<ClayRadio label="Default" value="1" inline />
					<ClayRadio label="Checked" value="1" checked={true} onChange={() => {}} inline />
					<ClayRadio label="Default Disabled" value="1" disabled inline />
					<ClayRadio label="Checked Disabled" value="1" checked={true} onChange={() => {}} disabled inline />
				</div>
			</ClayLayout.SheetSection>

			<ClayLayout.SheetSection>
				<h4 className="sheet-subtitle">Toggle Switch</h4>
				<div className="sheet-text">
					<span className="mr-4">
						<ClayToggle
							label="Off"
							onToggle={() => {}}
							spritemap={spritemap}
							symbol={symbol}
							toggled={false}
						/>
					</span>

					<ClayToggle
						label="On"
						onToggle={() => {}}
						spritemap={spritemap}
						symbol={symbol}
						toggled={true}
					/>
				</div>
			</ClayLayout.SheetSection>
		</ClayLayout.Sheet>
	);
};

export default Inputs;