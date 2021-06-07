import React, {useCallback, useEffect, useState} from 'react';
import ClayButton from '@clayui/button';
import ClayCard from '@clayui/card';
import ClayForm from '@clayui/form';
import ClayIcon from '@clayui/icon';
import ClayLayout from '@clayui/layout';
import Dialog from '~/Modal/Dialog';
import { useDispatch, useSelector } from 'react-redux';
import { approvedAuthStatusKey, cancelledAuthStatusKey, deniedAuthStatusKey, getAuthorizationIcon, MMM_DD_YYYY_at_h_mm_aa, pendingAuthStatusKey } from '~/Utils/index';
import { authorize, getAuthorizations } from './AuthorizationsSlice';
import DateDisplay from '~/Date/DateDisplay';
import { alertService } from '~/Toast/index';
import { unwrapResult } from "@reduxjs/toolkit";
import Input from '~/Input/Input';

const AuthorizationsList = () => {
	let refs = {};

	const authorizations = useSelector(state => state.authorizations.data);
	const authId = useSelector(state => state.authorizations.authId);
	const dispatch = useDispatch();
	const permissions = useSelector(state => state.cases.permissions);
	const spritemap = themeDisplay.getPathThemeImages() + '/argus/icons.svg';

	const [authIdToUpdate, setAuthIdToUpdate] = useState(false);
	const [authorizeAction, setAuthorizeAction] = useState(false);
	const [comments, setComments] = useState('');
	const [modalContinueMessage, setModalContinueMessage] = useState(false);
	const [modalMessage, setModalMessage] = useState(false);
	const [modalTitle, setModalTitle] = useState(false);
	const [modalVisible, setModalVisible] = useState(false);

	const getActionDate = (authorization) => {
		if (!authorization.authStatusRefTypeCode) {
			return authorization.receivedDate;
		}

		switch(authorization.authStatusRefTypeCode.toLowerCase()) {
			case approvedAuthStatusKey:
			case cancelledAuthStatusKey:
			case deniedAuthStatusKey:
				return authorization.statusChangeDate;
			case pendingAuthStatusKey:
			default:
				return authorization.receivedDate;
		}
	};

	const getActionDateLabel = (authStatusRefTypeCode) => {
		var requestedLabel = Liferay.Language.get('requested');

		if (!authStatusRefTypeCode) {
			return requestedLabel;
		}

		switch(authStatusRefTypeCode.toLowerCase()) {
			case approvedAuthStatusKey:
				return Liferay.Language.get('approved');
			case cancelledAuthStatusKey:
				return Liferay.Language.get('cancelled');
			case deniedAuthStatusKey:
				return Liferay.Language.get('declined');
			case pendingAuthStatusKey:
				return Liferay.Language.get('pending');
			default:
				return requestedLabel;
		}
	};

	const getActionDateTimeZone = (authorization) => {
		var actionDate = getActionDate(authorization);

		if (actionDate === authorization.statusChangeDate) {
			return authorization.statusChangeDateTimeZone;
		}

		return authorization.receivedDateTimeZone;
	};

	const getEffectiveDatesDisplay = (effectiveFrom, effectiveThru) => {
		if (effectiveFrom && effectiveThru) {
			return (
				<React.Fragment>
					<DateDisplay date={effectiveFrom} /> {'-'} <DateDisplay date={effectiveThru} />
				</React.Fragment>
			);
		}

		if (effectiveFrom) {
			return (
				<DateDisplay date={effectiveFrom} />
			);
		}

		if (effectiveThru) {
			return (
				<DateDisplay date={effectiveThru} />
			);
		}

		return Liferay.Language.get('to-be-determined');
	};

	const onAuthorizeClick = async (authorizeAction, authorizationIdToUpdate) => {
		let modalContinueMessage;
		let modalMessage;
		let modalTitle;

		if (authorizeAction.toLowerCase() === 'approve') {
			modalContinueMessage = Liferay.Language.get('yes-approve-this-request');
			modalMessage = Liferay.Language.get('approving-this-request-will-trigger-the-next-step');
			modalTitle = Liferay.Language.get('approve-this-request');
		}
		else if (authorizeAction.toLowerCase() === 'deny') {
			modalContinueMessage = Liferay.Language.get('yes-decline-this-request');
			modalMessage = Liferay.Language.get('declining-this-request-will-inform-the-provider');
			modalTitle = Liferay.Language.get('decline-this-request');
		}

		setModalContinueMessage(modalContinueMessage);
		setModalMessage(modalMessage);
		setModalTitle(modalTitle);
		setModalVisible(true);
		setAuthIdToUpdate(authorizationIdToUpdate);
		setAuthorizeAction(authorizeAction.toLowerCase());
	};

	const callAuthorize = async (authorizeAction, authorizationId) => {
		try {
			const resultAction = await dispatch(
				authorize({
					authorizeAction: authorizeAction,
					authorizationId: authorizationId,
					comments: comments,
				})
			);

			setModalVisible(false);

			unwrapResult(resultAction);

			setComments('');

			let successMessage;

			if (authorizeAction.toLowerCase() === 'approve') {
				successMessage = Liferay.Language.get('authorization-has-been-approved');
			}
			else if (authorizeAction.toLowerCase() === 'deny') {
				successMessage = Liferay.Language.get('authorization-has-been-declined');
			}

			alertService.success(successMessage);

			dispatch(getAuthorizations());
		}
		catch (err) {
			alertService.error(Liferay.Language.get('failed-to-update-authorization'));
		}
	};

	const onRefChange = useCallback((node, id) => {
		if (node && !refs[id]) {
			refs = {
				...refs,
				[id]: node
			};
		}
	}, [authId]);

	useEffect(() => {
		if (authId && refs[authId]) {
			refs[authId].scrollIntoView({
				behavior: 'smooth'
			});
		}
	}, [authId]);

	return (
		<React.Fragment>
			<div className="case-authorizations">
				{authorizations.map((authorization, index) => (
					<div className="case-authorizations__authorization" key={index} ref={element => onRefChange(element, authorization.authId)}>
						<div className="case-authorizations__header">
							<h3 className="mb-0">{authorization.title || Liferay.Language.get('to-be-determined')}</h3>
							<div>
								{authorization.authStatus || Liferay.Language.get('to-be-determined')}
								<ClayIcon
									className={`case-authorizations__icon lexicon-icon-lg ${getAuthorizationIcon(authorization.authStatusRefTypeCode)}`}
									spritemap={spritemap}
									symbol={getAuthorizationIcon(authorization.authStatusRefTypeCode)}
								/>
							</div>
						</div>
						<ClayCard className="card--secondary">
							<div className="card-header">
								<ClayLayout.Row>
									<ClayLayout.Col md={6}>
										<span className="font-weight-bold mr-2">{getActionDateLabel(authorization.authStatusRefTypeCode)}</span>
										{
											(getActionDate(authorization) &&
												<DateDisplay date={getActionDate(authorization)} format={MMM_DD_YYYY_at_h_mm_aa} timeZone={getActionDateTimeZone(authorization)} />)
											|| Liferay.Language.get('to-be-determined')
										}
									</ClayLayout.Col>
									<ClayLayout.Col md={6}>
										<span className="font-weight-bold mr-2">{Liferay.Language.get('effective-date')}</span>
										{getEffectiveDatesDisplay(authorization.effectiveFrom, authorization.effectiveThru)}
									</ClayLayout.Col>
								</ClayLayout.Row>
							</div>
							<ClayCard.Body>
								<ClayLayout.Row className="mb-4">
									<ClayLayout.Col md={6}>
										<h5 className="font-weight-bold">{Liferay.Language.get('tracking-#')}</h5>
										<div>{authorization.authNumber || Liferay.Language.get('to-be-determined')}</div>
									</ClayLayout.Col>

									<ClayLayout.Col md={6}>
										<h5 className="font-weight-bold">{Liferay.Language.get('provider')}</h5>
										<div>{authorization.facility.toUpperCase() || Liferay.Language.get('to-be-determined')}</div>
									</ClayLayout.Col>
								</ClayLayout.Row>

								<ClayLayout.Row className="mb-4">
									<ClayLayout.Col md={6}>
										<h5 className="font-weight-bold">{Liferay.Language.get('authorization-type')}</h5>
										<div>{authorization.authType || Liferay.Language.get('to-be-determined')}</div>
									</ClayLayout.Col>

									<ClayLayout.Col md={6}>
										<h5 className="font-weight-bold">{Liferay.Language.get('member-eligibility')}</h5>
										<div>{authorization.memberEligibility || Liferay.Language.get('to-be-determined')}</div>
									</ClayLayout.Col>
								</ClayLayout.Row>

								<hr />

								<div className="my-4">
									<h5 className="font-weight-bold">{Liferay.Util.sub(Liferay.Language.get('procedure-codes-x'), [authorization.procedureCodeCount])}</h5>
									<ol className="case-authorizations__ordered-list">
										{authorization.procedureCodes.map((procedureCode, index) => (
											<li key={index}>
												{procedureCode || Liferay.Language.get('to-be-determined')}
											</li>
										))}
									</ol>
								</div>

								<hr />

								<div className="mt-4">
									<h5 className="font-weight-bold">{Liferay.Language.get('authorization-comments')}</h5>
									<div dangerouslySetInnerHTML={{__html: authorization.comments}}></div>
								</div>

								{authorization.authStatusRefTypeCode && authorization.authStatusRefTypeCode.toLowerCase() === pendingAuthStatusKey &&
									permissions['AUTHORIZE'] &&
									<React.Fragment>
										<ClayForm.Group className="my-4">
											<Input
												component="textarea"
												errorMsg={Liferay.Language.get('you-must-enter-a-note-to-continue')}
												fieldName="comments"
												handleFieldChange={(fieldName, fieldValue) => setComments(fieldValue)}
												label={Liferay.Language.get('comments-optional')}
												labelClassName="font-weight-bold"
												placeholder={Liferay.Language.get('please-add-any-comments-here')}
												required={false}
												showErrors={false}
												type="text"
											/>
										</ClayForm.Group>

										<ClayButton.Group spaced>
											<ClayButton
												displayType="primary"
												onClick={() => onAuthorizeClick('approve', authorization.authId)}>
												<span className="inline-item inline-item-before">
													<ClayIcon
														className="case-authorizations__icon"
														symbol="thumbs-up"
													/>
												</span>
												{Liferay.Language.get('approve-request')}
											</ClayButton>
											<ClayButton
												displayType="primary"
												onClick={() => onAuthorizeClick('deny', authorization.authId)}>
												<span className="inline-item inline-item-before">
													<ClayIcon
														className="case-authorizations__icon"
														symbol="thumbs-down"
													/>
												</span>
												{Liferay.Language.get('decline-request')}
											</ClayButton>
										</ClayButton.Group>
									</React.Fragment>
								}
							</ClayCard.Body>
						</ClayCard>
					</div>
				))}
			</div>

			<Dialog
				center={true}
				className="case-authorizations-modal"
				setVisible={(visible) => setModalVisible(visible)}
				size="md"
				status="warning"
				title={modalTitle}
				visible={modalVisible}
			>

				<p className="font-weight-light">
					{modalMessage}
				</p>

				<ClayButton.Group spaced>
					<ClayButton onClick={() => callAuthorize(authorizeAction, authIdToUpdate)}>{modalContinueMessage}</ClayButton>
					<ClayButton displayType="link" onClick={() => setModalVisible(false)}>{Liferay.Language.get('no-go-back')}</ClayButton>
				</ClayButton.Group>
			</Dialog>
		</React.Fragment>
	);
};

export default AuthorizationsList;