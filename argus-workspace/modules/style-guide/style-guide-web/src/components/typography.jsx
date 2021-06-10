import React from 'react';
import ClayLayout from '@clayui/layout';

const Typography = () => {
	return (
		<ClayLayout.Sheet className="mb-5">
			<ClayLayout.SheetHeader>
				<h3 className="sheet-title">Typography</h3>
			</ClayLayout.SheetHeader>

			<ClayLayout.SheetSection>
				<h4 className="sheet-subtitle">Font Family</h4>
				<div className="sheet-text">
					<ClayLayout.Row>
						<ClayLayout.Col>
							<div className="display-3 font-weight-normal">Aa</div>
							<div className="h3 font-weight-normal">Interstate-Regular</div>
							<div>abcdefghijklmnopqrstuvwxyz</div>
							<div>ABCDEFGHIJKLMNOPQRSTUVWXYZ</div>
							<div>1234567890?!"@#$%&()[]=</div>
						</ClayLayout.Col>
						<ClayLayout.Col className="font-weight-light">
							<div className="display-3 font-weight-light">Aa</div>
							<div className="h3">Interstate-Light</div>
							<div>abcdefghijklmnopqrstuvwxyz</div>
							<div>ABCDEFGHIJKLMNOPQRSTUVWXYZ</div>
							<div>1234567890?!"@#$%&()[]=</div>
						</ClayLayout.Col>
					</ClayLayout.Row>
				</div>
			</ClayLayout.SheetSection>

			<ClayLayout.SheetSection>
				<h4 className="sheet-subtitle">Headings</h4>
				<div className="sheet-text">
					<h1>H1 - 36 Interstate-Light</h1>
					<h2>H2 - 30 Interstate-Regular</h2>
					<h3>H3 - 24 Interstate-Light</h3>
					<h4>H4 - 20 Interstate-Regular</h4>
					<h5>H5 - 16 Interstate-Light</h5>
					<h6>H6 - 12 Interstate-Regular</h6>
				</div>
			</ClayLayout.SheetSection>
		</ClayLayout.Sheet>
	);
};

export default Typography;