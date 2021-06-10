import React, { useEffect } from 'react';
import { useDispatch } from 'react-redux';
import Account from '~/Account/Account';
import Cases from '~/Cases/Cases';
import Claims from '~/Claims/Claims';
import { getHomeLayouts } from '~/Layouts/LayoutsSlice';

const App = (props) => {
	const dispatch = useDispatch();

	useEffect(() => {
		dispatch(getHomeLayouts());
	}, []);

	return (
		<div className="portlet-homepage row row-cols-1 row-cols-md-3 p-4">
			<div className="col-md-4">
				<div className="h-100 card">
					<Claims />
				</div>
			</div>
			<div className="col-md-4">
				<div className="h-100 card">
					<Cases />
				</div>
			</div>
			<div className="col-md-4">
				<div className="h-100 card">
					<Account />
				</div>
			</div>
		</div>
	)

}

export default App;