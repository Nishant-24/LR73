import React from 'react';
import ClayCard from '@clayui/card';
import ClayIcon from '@clayui/icon';
import ClayButton from '@clayui/button';
import { useDispatch, useSelector } from 'react-redux';
import DateDisplay from '~/Date/DateDisplay';
import { setTaskId, setShowAddTask } from './TasksSlice';
import { emDash, getTaskIcon, getTaskDateMessage } from '~/Utils/index';

const TasksQuickList = () => {
	const dispatch = useDispatch();

	const permissions = useSelector(state => state.claims.permissions);
	const tasks = useSelector(state => state.tasks.data);
	const taskId = useSelector(state => state.tasks.taskId);
	const showAddTask = useSelector(state => state.tasks.showAddTask);

	const spritemap = themeDisplay.getPathThemeImages() + '/argus/icons.svg';

	const getTaskDateDisplay = (task) => {
		switch (task.taskStatus.toLowerCase()) {
			case 'new':
				return task.dueDate ? <DateDisplay date={task.dueDate} /> : <DateDisplay date={task.startDate} />;
			case 'in progress':
				return task.dueDate ? <DateDisplay date={task.dueDate} /> : Liferay.Language.get('to-be-determined');
			case 'completed':
				return <DateDisplay date={task.endDate} />;
			default:
				return null;
		}
	}

	return (
		<div className="case-tasks">
			<div className="case-tasks__header">
				<h3 className="mb-0">{Liferay.Language.get('tasks')}</h3>
				{permissions['ADD_TASK'] &&
					<ClayButton
						disabled={showAddTask}
						displayType="primary"
						onClick={() => dispatch(setShowAddTask(true))}
						outline="true"
					>
						{Liferay.Language.get('new-task')}
					</ClayButton>
				}
			</div>

			{tasks.map((task, index) => (
				<ClayCard
					className={`card--condensed card-interactive ${taskId === task.taskId && 'active'}`}
					key={index}
					onClick={() => dispatch(setTaskId(task.taskId))}
				>
					<ClayCard.Body>
						<div className="case-tasks__header mb-2">
							<h5 className="font-weight-bold mb-0">{task.description || emDash}</h5>
							<small>
								{task.taskStatus || emDash}
								<ClayIcon
									className={`case-tasks__icon ${getTaskIcon(task.taskStatus)}`}
									spritemap={spritemap}
									symbol={getTaskIcon(task.taskStatus)}
								/>
							</small>
						</div>

						{getTaskDateDisplay(task) &&
							<div className="case-tasks__timestamp">
								{getTaskDateMessage(task)} {getTaskDateDisplay(task)}
							</div>
						}
					</ClayCard.Body>
				</ClayCard>
			))}
		</div>
	);
}

export default TasksQuickList;