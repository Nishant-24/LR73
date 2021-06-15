import React from 'react';
import ClayLayout from '@clayui/layout';
import ClayCard from '@clayui/card';
import { useSelector } from 'react-redux';
import DateDisplay from '~/Date/DateDisplay';

const Summary = (props) => {
	const data = useSelector((state) => state.modal.data);

	let memberName = Liferay.Language.get('to-be-determined');

	if (data.case.member) {
		if (data.case.member.memberName || data.case.member.memberNumber) {
			memberName = `${data.case.member.memberName} (ID# ${data.case.member.memberNumber || Liferay.Language.get('to-be-determined')})`
		}
	}

	let diagnosisNameCode = Liferay.Language.get('to-be-determined');

	if (data.case.primaryDiagCode || data.case.primaryCode) {
		diagnosisNameCode = `${data.case.primaryDiagCode} ${data.case.primaryCode}`;
	}

	return (
		<div className="case-summary">
			<h3 className="mb-3">
				{Liferay.Language.get('case-id-number')} {data.case.caseNumber || Liferay.Language.get('to-be-determined')}
			</h3>

			<ClayCard className="card--secondary">
				<ClayCard.Body>
					<ClayLayout.Row className="mb-4">
						<ClayLayout.Col md={6}>
							<h5 className="font-weight-bold">{Liferay.Language.get('case-manager')}</h5>
							<span>{data.case.caseManager || Liferay.Language.get('to-be-determined')}</span>
						</ClayLayout.Col>
						<ClayLayout.Col md={6}>
							<h5 className="font-weight-bold">{Liferay.Language.get('facility')}</h5>
							<span>{data.case.primaryFacility || Liferay.Language.get('to-be-determined')}</span>
						</ClayLayout.Col>
					</ClayLayout.Row>

					<ClayLayout.Row className="mb-4">
						<ClayLayout.Col md={6}>
							<h5 className="font-weight-bold">{Liferay.Language.get('member-name')}</h5>
							<span>{memberName}</span>
						</ClayLayout.Col>
						<ClayLayout.Col md={6}>
							<h5 className="font-weight-bold">{Liferay.Language.get('client-name')}</h5>
							<span>{(data.case.clientGroup && data.case.clientGroup.clientGroupName) || Liferay.Language.get('to-be-determined')}</span>
						</ClayLayout.Col>
					</ClayLayout.Row>

					<ClayLayout.Row className="mb-4">
						<ClayLayout.Col md={6}>
							<h5 className="font-weight-bold">{Liferay.Language.get('treating-physician')}</h5>
							<span>{data.case.treatingPhysician || Liferay.Language.get('to-be-determined')}</span>
						</ClayLayout.Col>
						<ClayLayout.Col md={6}>
							<h5 className="font-weight-bold">{Liferay.Language.get('plan')}</h5>
							<span>{data.case.medicalPlan || Liferay.Language.get('to-be-determined')}</span>
						</ClayLayout.Col>
					</ClayLayout.Row>

					<hr />

					<ClayLayout.Row className="my-4">
						<ClayLayout.Col md={6}>
							<h5 className="font-weight-bold">{Liferay.Language.get('diagnosis-name-code')}</h5>
							<span>{diagnosisNameCode}</span>
						</ClayLayout.Col>
						<ClayLayout.Col md={6}>
							<h5 className="font-weight-bold">{Liferay.Language.get('rx')}</h5>
							<span>{(data.case.member && data.case.member.rxNumber) || Liferay.Language.get('to-be-determined')}</span>
						</ClayLayout.Col>
					</ClayLayout.Row>

					<hr />

					<ClayLayout.Row className="mt-4">
						<ClayLayout.Col md={12}>
							<h5 className="font-weight-bold">{Liferay.Language.get('hipaa-consent')}</h5>
							<span>
								{
									(data.case.consentReceivedDate &&
										(<React.Fragment>
											{Liferay.Language.get('received')} <DateDisplay date={data.case.consentReceivedDate} />
										</React.Fragment>))
									|| Liferay.Language.get('to-be-determined')
								}
							</span>
						</ClayLayout.Col>
					</ClayLayout.Row>

				</ClayCard.Body>
			</ClayCard>
		</div>
	);
}

export default Summary;
