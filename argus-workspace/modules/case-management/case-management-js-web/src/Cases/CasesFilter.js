import React, { useState } from 'react';
import ClayButton from '@clayui/button';
import ClayIcon from '@clayui/icon';
import ClayLabel from '@clayui/label';
import groupBy from 'lodash.groupby';
import map from 'lodash.map';
import isEqual from 'lodash.isequal';
import { useSelector, useDispatch } from 'react-redux';
import { setFilters } from './CasesSlice';
import { DatePicker, DatePickerRange, ListPicker } from '~/Filters/index';
import { getCaseIcon } from '~/Utils/index';
import { getFilterFunction, clearFilters } from './TableHelpers';

const CasesFilter = (props) => {
	const dispatch = useDispatch();
	const source = useSelector((state) => state.cases.data);

	const [visible, setVisible] = useState(false);
	const [labels, setLabels] = useState([]);
	const [activeLabels, setActiveLabels] = useState([]);

	const resetActiveFilters = () => {
		clearFilters();
		dispatch(setFilters([]));
		setLabels([]);
		setActiveLabels([]);
		setVisible(false);
	}

	const setActiveFilters = (list = labels) => {
		clearFilters();

		if (list.length) {
			const grouped = groupBy(list, label => label.key);

			map(grouped, (value, key) => {
				value = value.map(v => v.value);

				try {
					getFilterFunction(key)(value);
				}
				catch (e) {
					console.error(e);
				}
			});

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

	return (
		<div className="case-filter">

			{visible ? (
				<div className="case-filter__header">
					<h4 className="mb-0">{Liferay.Language.get('filters-for-all-cases')}</h4>
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
					<div className="case-filter__header">
						<h4 className="flex-shrink-0 mb-0">{Liferay.Language.get('all-cases')}</h4>
						<div className="d-flex align-items-center text-right">
							{activeLabels.length > 0 && (
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
					<div className="case-filter__body">
						<div className="case-filter__selection">
							<div>
								<div className="case-filter__subtitle">{Liferay.Language.get('by-date')}</div>
								<div>
									<ClayButton.Group spaced>
										<DatePickerRange
											dataField="caseStartDate"
											filterLabel={Liferay.Language.get('open-date')}
											labels={labels}
											onFilterSelect={toggleLabel}
										/>

										<DatePickerRange
											dataField="caseEndDate"
											filterLabel={Liferay.Language.get('close-date')}
											labels={labels}
											onFilterSelect={toggleLabel}
										/>
									</ClayButton.Group>
								</div>
							</div>

							<div>
								<div className="case-filter__subtitle">{Liferay.Language.get('by-member-info')}</div>
								<div>
									<ClayButton.Group spaced>
										<ListPicker
											dataField="member.memberName"
											filterLabel={Liferay.Language.get('member-name')}
											labels={labels}
											onFilterSelect={toggleLabel}
											source={source}
										/>

										<ListPicker
											dataField="member.memberNumber"
											filterLabel={Liferay.Language.get('member-id')}
											labels={labels}
											onFilterSelect={toggleLabel}
											source={source}
										/>

										<DatePicker
											dataField="member.memberDOB"
											filterLabel={Liferay.Language.get('member-dob')}
											labels={labels}
											onFilterSelect={toggleLabel}
										/>
									</ClayButton.Group>
								</div>
							</div>

							<div>
								<div className="case-filter__subtitle">{Liferay.Language.get('by-case-details')}</div>
								<div>
									<ClayButton.Group spaced>
										<ListPicker
											dataField="primaryFacility"
											filterLabel={Liferay.Language.get('provider')}
											labels={labels}
											onFilterSelect={toggleLabel}
											source={source}
										/>

										<ListPicker
											dataField="primaryCode"
											filterLabel={Liferay.Language.get('diagnosis-code')}
											labels={labels}
											onFilterSelect={toggleLabel}
											source={source}
										/>

										<ListPicker
											dataField="status"
											dynamic={false}
											filterLabel={Liferay.Language.get('status')}
											formatter={getCaseIcon}
											labels={labels}
											onFilterSelect={toggleLabel}
											searchable={false}
											source={['Closed', 'Processed', 'In Process']}
										/>
									</ClayButton.Group>
								</div>
							</div>
						</div>
					</div>

					<div className="case-filter__body">
						<div className="case-filter__filters">
							{labels.length > 0 ? (
								<React.Fragment>
									<h5>{Liferay.Language.get('added-filters')}:</h5>

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
									<h5>{Liferay.Language.get('no-filter-selected')}</h5>
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

export default CasesFilter;