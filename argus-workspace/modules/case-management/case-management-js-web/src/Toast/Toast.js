import React, {useState, useEffect} from 'react';
import ClayAlert from '@clayui/alert';
import {alertService} from './Service';

export default class Toast extends React.Component {
	constructor(props) {
		super(props);

		this.state = {
			toastItems: []
		};
	}

	componentDidMount() {
		this.subscription = alertService.onAlert(this.props.id)
			.subscribe(toastItem => {
				if (!toastItem.message) {
					this.setState({ toastItems: [] });
					return;
				}

				this.setState({
					toastItems: [...this.state.toastItems, toastItem]
				});
			});
	}

	componentWillUnmount() {
		this.subscription.unsubscribe();
	}

	removeToastItem(item) {
		this.setState({
			toastItems: this.state.toastItems.filter(x => x !== item)
		});
	}

	render() {
		const { toastItems } = this.state;

		if (!toastItems.length) return null;

		return (
			<ClayAlert.ToastContainer>
				{toastItems.map((item, index) => (
					<ClayAlert
						autoClose={3000}
						key={index}
						displayType={item.type}
						onClose={() => this.removeToastItem(item)}
						title={item.title}
					>
						{item.message}
					</ClayAlert>
				))}
			</ClayAlert.ToastContainer>
		);
	}
}

Toast.defaultProps = {
	id: 'default-alert',
};