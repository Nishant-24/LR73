import React, { useState } from 'react';
import ClayButton from '@clayui/button';
import ClayDropDown from '@clayui/drop-down';
import ClayIcon from '@clayui/icon';
import { ClaySelect } from '@clayui/form';
import moment from 'moment';
import 'react-dates/initialize';
import { DayPickerSingleDateController } from 'react-dates';
import { HORIZONTAL_ORIENTATION } from 'react-dates/lib/constants';
import isInclusivelyAfterDay from 'react-dates/lib/utils/isInclusivelyAfterDay';
import isSameDay from 'react-dates/lib/utils/isSameDay';
import { range, renderNavNextButton, renderNavPrevButton } from './FilterHelpers';

const DatePicker = (props) => {
	const {
		dataField,
		dateFormat = 'MMM DD, YYYY',
		filterLabel,
		initialDate = null,
		labels,
		onFilterSelect,
		years = {
			end: moment().year(),
			start: moment().year() - 60,
		},
	} = props;

	const otherProps = {
		noBorder: true,
		hideKeyboardShortcutsPanel: true,

		// day presentation and interaction related props
		renderCalendarDay: undefined,
		renderDayContents: null,
		isDayBlocked: (day) => {
			return labels.some(label => label.key === dataField && isSameDay(moment(label.value, dateFormat), day));
		},
		isOutsideRange: () => false,
		isDayHighlighted: () => false,
		enableOutsideDays: false,

		// calendar presentation and interaction related props
		orientation: HORIZONTAL_ORIENTATION,
		withPortal: false,
		initialVisibleMonth: null,
		numberOfMonths: 1,
		onOutsideClick: () => {},
		keepOpenOnDateSelect: false,
		renderCalendarInfo: null,
		isRTL: false,

		// navigation related props
		navPrev: null,
		navNext: null,
		renderNavPrevButton: renderNavPrevButton,
		renderNavNextButton: renderNavNextButton,
		onPrevMonthClick: () => {},
		onNextMonthClick: () => {},

		// internationalization
		monthFormat: 'MMMM YYYY',
	};

	const [active, setActive] = useState(false);
	const [focused, setFocused] = useState(true);
	const [date, setDate] = useState(initialDate);

	const onActiveChange = (active) => {
		setActive(active);
		setDate(initialDate);
	}

	const onDateChange = (date) => {
		setDate(date);
	}

	const onFocusChange = () => {
		setFocused(true);
	}

	const setFilterValue = () => {
		const dateString = date.format(dateFormat);

		onFilterSelect({ key: dataField, value: dateString });
		setActive(false);
		setDate(initialDate);
	}

	return(
		<ClayDropDown
			active={active}
			menuElementAttrs={{
				className: 'dropdown-menu-width-auto'
			}}
			onActiveChange={onActiveChange}
			trigger={
				<ClayButton className={active && "active"} displayType="hybrid" small>
					<ClayIcon className="inline-item-before" symbol="plus" />
					{filterLabel}
				</ClayButton>
			}
		>
			{active &&
				<React.Fragment>
					<DayPickerSingleDateController
						{...otherProps}
						onDateChange={onDateChange}
						onFocusChange={onFocusChange}
						focused={focused}
						date={date}
						renderMonthElement={({ month, onMonthSelect, onYearSelect }) => (
							<div className="date-picker-nav justify-content-center">
								<div className="date-picker-nav-item input-date-picker-month">
									<ClaySelect
										className="form-control-sm"
										name="month"
										onChange={(e) => onMonthSelect(month, e.target.value)}
										value={month.month()}
									>
										{moment.months().map((label, value) => (
											<ClaySelect.Option
												key={value}
												label={label}
												value={value}
											/>
										))}
									</ClaySelect>
								</div>

								<div className="date-picker-nav-item input-date-picker-year">
									<ClaySelect
										className="form-control-sm"
										name="year"
										onChange={(e) => onYearSelect(month, e.target.value)}
										value={month.year()}
									>
										{range(years).map(value => (
											<ClaySelect.Option
												key={value}
												label={value}
												value={value}
											/>
										))}
									</ClaySelect>
								</div>
							</div>
						)}
					/>

					<div className="dropdown-section">
						<ClayButton block disabled={date ? false : true} onClick={setFilterValue} displayType="primary">
							{Liferay.Language.get('add-filter')}
						</ClayButton>
					</div>
				</React.Fragment>
			}
		</ClayDropDown>
	)
}

export default DatePicker;