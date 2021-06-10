import React, { useEffect, useRef, useState } from 'react';
import InfiniteScroll from 'react-infinite-scroll-component';
import { useDispatch, useSelector } from 'react-redux';
import { getTasks, resetData } from './TasksSlice';
import { AddTask, TaskList, TasksQuickList } from './index';

const CaseTasks = (props) => {
	const dispatch = useDispatch();

	const caseId = useSelector((state) => state.modal.caseId);
	const showAddTask = useSelector(state => state.tasks.showAddTask);
	const tasks = useSelector(state => state.tasks.data);

	const mountedRef = useRef();
	const limit = 20;
	const [start, setStart] = useState(0);
	const [end, setEnd] = useState(limit);
	const [hasMore, setHasMore] = useState(true);

	const loadMore = () => {
		setStart(start + limit);
		setEnd(end + limit);
	}

	useEffect(() => {
		if (mountedRef.current) {
			dispatch(getTasks({start: start, end: end}));
		}
	}, [end]);

	useEffect(() => {
		if (tasks.length < end) {
			setHasMore(false);
		}
		else {
			setHasMore(true);
		}
	}, [tasks]);

	useEffect(() => {
		mountedRef.current = true;

		if (caseId) {
			dispatch(getTasks({start: start, end: end}));
		}

		return () => {
			dispatch(resetData());
		}
	}, []);

	return (
		<div className="case-template">
			<div id="taskList" className="case-template__content case-template__content--left">
				<InfiniteScroll
					dataLength={tasks.length}
					next={loadMore}
					hasMore={hasMore}
					loader={<div className="loading-animation"></div>}
					scrollableTarget="taskList"
				>
					{showAddTask &&
						<AddTask />
					}

					<TaskList />
				</InfiniteScroll>
				
			</div>
			<div id="tasksQuickList" className="case-template__content case-template__content--right">
				<InfiniteScroll
					dataLength={tasks.length}
					next={loadMore}
					hasMore={hasMore}
					loader={<div className="loading-animation"></div>}
					scrollableTarget="tasksQuickList"
				>
					<TasksQuickList />
				</InfiniteScroll>
				
			</div>
		</div>
	);
}

export default CaseTasks;