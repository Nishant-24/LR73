import React from 'react';
import ClayLayout from '@clayui/layout';
import Summary from './Summary';
import { AuthorizationsQuickList } from '~/Authorizations/index';

const CaseSummary = (props) => {

	return (
		<div className="case-template">
			<div className="case-template__content">
				<ClayLayout.ContainerFluid size={false}>
					<ClayLayout.Row>
						<ClayLayout.Col md={6}>
							<Summary />
						</ClayLayout.Col>
						
						<ClayLayout.Col md={6}>
							<AuthorizationsQuickList title={Liferay.Language.get('date-of-services-authorizations')} />
						</ClayLayout.Col>
					</ClayLayout.Row>
				</ClayLayout.ContainerFluid>
			</div>
		</div>
	)
}

export default CaseSummary;
