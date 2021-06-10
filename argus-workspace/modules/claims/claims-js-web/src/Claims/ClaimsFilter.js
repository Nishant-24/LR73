import React, { useEffect, useState } from 'react';
import ClayButton from '@clayui/button';
import ClayIcon from '@clayui/icon';
import ClayLabel from '@clayui/label';
import isEqual from 'lodash.isequal';
import { useSelector, useDispatch } from 'react-redux';
import DatePickerRange from '~/Filters/DatePickerRange';
import { resetDateRange, resetFilters, setDateRange, setFilters, defaultDateRange } from './ClaimsSlice';

const ClaimsFilter = (props) => {
	const dispatch = useDispatch();
	const filters = useSelector((state) => state.claims.filters);

	const [visible, setVisible] = useState(false);
	const [labels, setLabels] = useState(filters);
	const [activeLabels, setActiveLabels] = useState(filters);

	const resetActiveFilters = () => {
		dispatch(resetDateRange());
		dispatch(resetFilters());
		setLabels([]);
		setActiveLabels([]);
		setVisible(false);
	}

	const setActiveFilters = (list = labels) => {
		const dateRange = list.find(item => item.key === 'receivedDate');

		if (list.length) {
			dispatch(setDateRange(dateRange.value));
			dispatch(setFilters(list));
			setActiveLabels(list);
			setVisible(false);
		}
		else {
			resetActiveFilters();
		}
	}

	const toggleLabel = (label, list = labels, setState = setLabels, updateTable = false) => {
		let currentLabels = [...list];

		if (currentLabels.some(item => isEqual(item, label))) {
			currentLabels = currentLabels.filter(item => !isEqual(item, label));
		}
		else {
			currentLabels.push(label);
		}

		setState(currentLabels);

		if (updateTable) {
			setActiveFilters(currentLabels);
		}
	}

	const updateLabel = (label) => {
		let currentLabels = [...labels];
		const index = currentLabels.findIndex((item => item.key === label.key));

		if (index !== -1) {
			currentLabels[index] = label;
			setLabels(currentLabels);
		}
		else {
			toggleLabel(label);
		}
	}

	useEffect(() => {
		Liferay.once('beforeNavigate', function(event) {
			if (!event.path.includes('claims')) {
				dispatch(resetDateRange());
				dispatch(resetFilters());
			}
		});
	}, []);

	return (
		<div className="claim-filter">

			{visible ? (
				<div className="claim-filter__header">
					<h4 className="mb-0">{Liferay.Language.get('filters')}</h4>
					<div>
						<ClayButton
							displayType="link"
							onClick={() => {
								setVisible(false)
								setLabels(activeLabels);
							}}
						>
							{Liferay.Language.get('close')}
							<span className="inline-item inline-item-after">
								<ClayIcon symbol="times" />
							</span>
						</ClayButton>
					</div>
				</div>
			) : (
				<div className="claim-filter__header">
					<div className="d-flex flex-shrink-0">
						{props.children}
					</div>
					<div className="d-flex align-items-center text-right">
						{activeLabels.length > 0 ? (
							<div>
								{activeLabels.map((label, index) => (
									<ClayLabel
										closeButtonProps={{
											onClick: () => {
												toggleLabel(label, activeLabels, setActiveLabels, true);
											}
										}}
										displayType="light"
										key={index}
									>
										{label.value}
									</ClayLabel>
								))}
							</div>
						) : (
							<div>
								<ClayLabel displayType="light">{defaultDateRange}</ClayLabel>
							</div>
						)}

						<div className="flex-shrink-0">
							{activeLabels.length > 0 &&
								<ClayButton
									displayType="link"
									onClick={() => resetActiveFilters()}
									small
								>
									<ClayIcon className="inline-item-before" symbol="times-circle" />
									{Liferay.Language.get('reset')}
								</ClayButton>
							}

							<ClayButton
								displayType="primary"
								onClick={() => setVisible(true)}
								outline
							>
								<span className="inline-item inline-item-before">
									<ClayIcon symbol="filter" />
								</span>
								{Liferay.Language.get('filter')}
							</ClayButton>
						</div>
					</div>
				</div>
			)}

			{visible &&
				<React.Fragment>
					<div className="claim-filter__body">
						<div className="claim-filter__selection">
							<div>
								<div className="claim-filter__subtitle">{Liferay.Language.get('date-received')}</div>
								<div>
									<DatePickerRange
										dataField="receivedDate"
										filterLabel={Liferay.Language.get('date-range')}
										onFilterSelect={updateLabel}
									/>
								</div>
							</div>
						</div>
					</div>

					<div className="claim-filter__body">
						<div className="claim-filter__filters">
							<h5>{Liferay.Language.get('added-filters')}:</h5>

							{labels.length > 0 ? (
								<React.Fragment>
									{labels.map((label, index) => (
										<ClayLabel
											closeButtonProps={{
												onClick: () => {
													toggleLabel(label)
												}
											}}
											displayType="light"
											key={index}
										>
											{label.value}
										</ClayLabel>
									))}

									<ClayButton
										displayType="link"
										onClick={() => setLabels([])}
										small
									>
										<ClayIcon className="inline-item-before" symbol="times-circle" />
										{Liferay.Language.get('clear')}
									</ClayButton>
								</React.Fragment>
							) : (
								<ClayLabel displayType="light">{defaultDateRange}</ClayLabel>
							)}
						</div>
						<ClayButton.Group spaced>
							<ClayButton
								displayType="primary"
								onClick={() => setActiveFilters()}
							>
								{Liferay.Language.get('apply')}
							</ClayButton>
							<ClayButton
								displayType="primary"
								onClick={() => resetActiveFilters()}
								outline
							>
								{Liferay.Language.get('reset')}
							</ClayButton>
						</ClayButton.Group>
					</div>
				</React.Fragment>
			}
		</div>
	)
}

export default ClaimsFilter;