import React, { useState } from 'react';
import { ClayButtonWithIcon } from '@clayui/button';

const CollapsiblePanel = (props) => {
	const [collapse, setCollapse] = useState(false);

	return (
		<React.Fragment>
			<ClayButtonWithIcon
				className="btn-expand claim__icon lexicon-icon-lg"
				displayType="unstyled"
				onClick={() => setCollapse(!collapse)}
				symbol={collapse ? 'angle-up' : 'angle-down'}
			/>
			{!collapse && props.children}
		</React.Fragment>
	)
}

export default CollapsiblePanel;