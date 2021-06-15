import React from 'react';
import ReactDOM from 'react-dom';

import Typography from './components/typography';
import Colors from './components/colors';
import Buttons from './components/buttons';
import Inputs from './components/inputs';
import Navs from './components/navs';
import Charts from './components/charts';

export default class extends React.Component {
	render() {
		return (
			<React.Fragment>
				<Typography />
				<Colors />
				<Buttons />
				<Inputs />
				<Navs />
				<Charts />
			</React.Fragment>
		);
	}
}