import React, { useState, useEffect, useRef } from 'react';
import ClayButton from '@clayui/button';
import ClayCard from '@clayui/card';
import ClayIcon from '@clayui/icon';
import ClayForm from '@clayui/form';
import { unwrapResult } from '@reduxjs/toolkit';
import { useDispatch, useSelector } from 'react-redux';
import { addNewTask, setShowAddTask, getTaskTypeReferenceTypeCodes, reloadTasks } from './TasksSlice';
import { alertService } from '~/Toast/index';
import Input from '~/Input/Input';
import moment from 'moment';
import { getNowInUserTimeZone } from '~/Utils/index';

const AddTask = (props) => {
	const dispatch = useDispatch();
	const ref = useRef(null);

	const [descriptionKey, setDescriptionKey] = useState('');
	const [startDate, setStartDate] = useState('');
	const [priorityKey, setPriorityKey] = useState('');

	const caseId = useSelector((state) => state.modal.caseId);
	const taskTypeReferenceTypeCodes = useSelector((state) => state.tasks.taskTypeReferenceTypeCodes);
	const taskPriorityReferenceTypeCodes = useSelector((state) => state.tasks.taskPriorityReferenceTypeCodes);

	const [hasDescriptionError, setHasDescriptionError] = useState(false);
	const [hasStartDateError, setHasStartDateError] = useState(false);
	const [hasPriorityError, setHasPriorityError] = useState(false);

	const [startDateErrorMsg, setStartDateErrorMsg] = useState(Liferay.Language.get('this-field-is-required'));

	useEffect(() => {
		ref.current.scrollIntoView({
			behavior: 'smooth',
		});

		dispatch(getTaskTypeReferenceTypeCodes());
	}, []);

	const isValid = async () => {
		let valid = true;

		if (!descriptionKey) {
			setHasDescriptionError(true);
			valid = false;
		}
		else {
			setHasDescriptionError(false);
		}

		const startDateMoment = moment.utc(startDate, true);

		const dateNowResponse = await getNowInUserTimeZone();

		const dateNow = dateNowResponse['now'];

		const dateNowMoment = moment.utc(dateNow);

		if (!startDate) {
			setHasStartDateError(true);
			setStartDateErrorMsg(Liferay.Language.get('this-field-is-required'));
			valid = false;
		}
		else if (startDateMoment.isBefore(dateNowMoment, 'day')) {
			setHasStartDateError(true);
			setStartDateErrorMsg(Liferay.Language.get('date-must-not-be-in-the-past'));
			valid = false;
		}
		else if (!startDateMoment.isValid()) {
			setHasStartDateError(true);
			setStartDateErrorMsg(Liferay.Language.get('please-enter-the-correct-format-yyyy-mm-dd'));
			valid = false;
		}
		else {
			setHasStartDateError(false);
		}

		if (!priorityKey) {
			setHasPriorityError(true);
			valid = false;
		}
		else {
			setHasPriorityError(false);
		}

		return valid;
	}

	const onSubmit = async (event) => {
		event.preventDefault();

		if (await isValid()) {
			try {
				const resultAction = await dispatch(
					addNewTask({
						caseId: caseId,
						descriptionKey: descriptionKey,
						startDate: startDate,
						priorityKey: priorityKey,
					})
				);

				unwrapResult(resultAction);
				setDescriptionKey('');
				setStartDate('');
				setPriorityKey('');

				alertService.success(Liferay.Language.get('new-task-successfully-added'));

				dispatch(setShowAddTask(false));
				dispatch(reloadTasks());
			}
			catch (err) {
				alertService.error(Liferay.Language.get('failed-to-create-task'));
			}
		}
	}

	return (
		<div className="case-tasks mb-5" ref={ref}>
			<div className="case-tasks__header">
				<h3 className="mb-0">{Liferay.Language.get('add-new-task')}</h3>
				<span className="font-weight-light">{Liferay.Language.get('all-fields-required')}</span>
			</div>
			<ClayCard className="card--secondary">
				<ClayCard.Body>
					<ClayForm noValidate onSubmit={(event) => onSubmit(event)}>
						<Input
							fieldName="descriptionKey"
							handleFieldChange={(fieldName, fieldValue) => setDescriptionKey(fieldValue)}
							items={taskTypeReferenceTypeCodes}
							label={Liferay.Language.get('task-description')}
							placeholder={Liferay.Language.get('please-select-a-task')}
							required={true}
							showErrors={hasDescriptionError}
							type="select"
						/>

						<Input
							errorMsg={startDateErrorMsg}
							fieldName="startDate"
							handleFieldChange={(fieldName, fieldValue) => setStartDate(fieldValue)}
							label={Liferay.Language.get('start-date')}
							placeholder='YYYY-MM-DD'
							required={true}
							showErrors={hasStartDateError}
							type="date"
							value={startDate}
						/>

						<Input
							fieldName="priorityKey"
							handleFieldChange={(fieldName, fieldValue) => setPriorityKey(fieldValue)}
							inline={true}
							items={taskPriorityReferenceTypeCodes}
							label={Liferay.Language.get('priority')}
							required={true}
							showErrors={hasPriorityError}
							type="radio"
							value={priorityKey}
						/>

						<div className="text-right">
							<ClayButton.Group spaced>
								<ClayButton displayType="primary" outline="true" onClick={() => dispatch(setShowAddTask(false))}>{Liferay.Language.get('discard')}</ClayButton>
								<ClayButton displayType="primary" type="submit">{Liferay.Language.get('add-task')}</ClayButton>
							</ClayButton.Group>
						</div>
					</ClayForm>
				</ClayCard.Body>
			</ClayCard>
		</div>
	);
}

export default AddTask;