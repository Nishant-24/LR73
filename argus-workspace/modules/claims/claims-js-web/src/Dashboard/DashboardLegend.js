import React from 'react';

const DashboardLegend = (props) => {

	const {
		datamap = [],
		title = {
			'In Process': `${Liferay.Language.get('in-process')}`,
			'Processed': `${Liferay.Language.get('processed')}`,
			'Closed': `${Liferay.Language.get('closed')}`
		},
		layouts,
		payload = [],
	} = props;

	return (
		payload.reverse().map((entry, index) => (
			<div className="card--dashboard card-dashboard" style={{ borderLeftColor: entry.color }} key={index}>
				<a href={layouts[index+1] ? layouts[index+1].layoutSetFriendlyURL : '#'}>
					<div className="card-horizontal align-items-center d-flex">
						<div className="card-body align-items-center justify-content-center">
							<h5>{`${title[entry.value]} ${Liferay.Language.get('claims')}`}</h5>
							<h4>{`${datamap[entry.value]}`}</h4>
						</div>
					</div>
				</a>
			</div>
		))
	)
}

export default DashboardLegend;