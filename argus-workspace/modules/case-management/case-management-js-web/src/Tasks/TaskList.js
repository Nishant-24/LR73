import React, { useCallback, useEffect } from 'react';
import ClayLayout from '@clayui/layout';
import ClayCard from '@clayui/card';
import ClayIcon from "@clayui/icon";
import { useSelector } from 'react-redux';
import DateDisplay from '~/Date/DateDisplay';
import { emDash, formatDate, getTaskIcon, MMM_DD_YYYY, MMM_DD_YYYY_at_h_mm_aa } from '~/Utils/index';

const TaskList = (props) => {
	let refs = {};

	const tasks = useSelector(state => state.tasks.data);
	const taskId = useSelector(state => state.tasks.taskId);
	const spritemap = themeDisplay.getPathThemeImages() + '/argus/icons.svg';

	const onRefChange = useCallback((node, id) => {
		if (node && !refs[id]) {
			refs = {
				...refs,
				[id]: node
			};
		}
	}, [taskId]);

	useEffect(() => {
		if (taskId && refs[taskId]) {
			refs[taskId].scrollIntoView({
				behavior: 'smooth',
			});
		}
	}, [taskId]);

	return (
		<div className="case-tasks">
			{tasks.map((task, index) => (
				<div className="case-tasks__task" key={index} ref={element => onRefChange(element, task.taskId)}>
					<div className="case-tasks__header">
						<h3 className="mb-0">{task.description || emDash}</h3>
						<div>
							{task.taskStatus || emDash}
							<ClayIcon
								className={`case-tasks__icon lexicon-icon-lg ${getTaskIcon(task.taskStatus)}`}
								spritemap={spritemap}
								symbol={getTaskIcon(task.taskStatus)}
							/>
						</div>
					</div>
					<ClayCard className="card--secondary">
						<ClayCard.Body>
							<ClayLayout.Row>
								<ClayLayout.Col md={4}>
									<h5 className="font-weight-bold">{Liferay.Language.get('start-date')}</h5>
									<div>
										{(task.startDate && <DateDisplay date={task.startDate} format={MMM_DD_YYYY} />) || Liferay.Language.get('to-be-determined')}
									</div>
								</ClayLayout.Col>

								<ClayLayout.Col md={4}>
									<h5 className="font-weight-bold">{Liferay.Language.get('due-date')}</h5>
									<div>
										{(task.dueDate && <DateDisplay date={task.dueDate} format={MMM_DD_YYYY} />) || Liferay.Language.get('to-be-determined')}
									</div>
								</ClayLayout.Col>

								<ClayLayout.Col md={4}>
									{task.endDate &&
										<React.Fragment>
											<h5 className="font-weight-bold">{Liferay.Language.get('completion-date')}</h5>
											<div>
												{(task.endDate && <DateDisplay date={task.endDate} format={MMM_DD_YYYY} />) || Liferay.Language.get('to-be-determined')}
											</div>
										</React.Fragment>
									}
								</ClayLayout.Col>

								<ClayLayout.Col md={4} className="mt-3">
									<h5 className="font-weight-bold">{Liferay.Language.get('priority')}</h5>
									<div>{task.priority || Liferay.Language.get('to-be-determined')} </div>
								</ClayLayout.Col>
							</ClayLayout.Row>
						</ClayCard.Body>
					</ClayCard>
				</div>
			))}
		</div>
	);
}

export default TaskList;