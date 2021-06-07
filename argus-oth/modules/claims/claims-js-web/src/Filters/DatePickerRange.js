import React, { useState } from 'react';
import ClayButton from '@clayui/button';
import ClayDropDown from '@clayui/drop-down';
import ClayIcon from '@clayui/icon';
import { ClaySelect } from '@clayui/form';
import moment from 'moment';
import 'react-dates/initialize';
import { DateRangePicker } from 'react-dates';
import { START_DATE, END_DATE, HORIZONTAL_ORIENTATION, ANCHOR_LEFT, NAV_POSITION_TOP } from 'react-dates/lib/constants';
import { DateRangePickerPhrases } from 'react-dates/lib/defaultPhrases';
import isInclusivelyAfterDay from 'react-dates/lib/utils/isInclusivelyAfterDay';
import { range, renderNavNextButton, renderNavPrevButton } from './FilterHelpers';

const DatePickerRange = (props) => {
	const {
		autoFocus = false,
		autoFocusEndDate = false,
		dataField,
		dateFormat = 'MMM DD, YYYY',
		filterLabel,
		initialEndDate = null,
		initialStartDate = null,
		labels,
		onFilterSelect,
		years = {
			end: moment().year(),
			start: moment().year() - 2,
		},
	} = props;

	const currentDate = moment.utc(themeDisplay.getUserCurrentDate());
	const maxDate = currentDate.clone();
	const minDate = moment.utc(themeDisplay.getUserCurrentDate()).subtract(2, 'years').add(1, 'day');

	const maxDateInYear = maxDate.clone().set('month', 11);
	const minDateInYear = minDate.clone().set('month', 0);

	const [navDate, setNavDate] = useState(currentDate.clone());

	const otherProps = {
		hideKeyboardShortcutsPanel: true,

		// input related props
		startDateId: START_DATE,
		startDatePlaceholderText: Liferay.Language.get('start-date'),
		endDateId: END_DATE,
		endDatePlaceholderText: Liferay.Language.get('end-date'),
		disabled: false,
		required: false,
		screenReaderInputMessage: '',
		showClearDates: false,
		showDefaultInputIcon: false,
		customInputIcon: null,
		customArrowIcon: <ClayIcon className="mx-2" symbol="order-arrow-right" />,
		customCloseIcon: null,
		block: false,
		small: false,
		regular: false,
		readOnly: true,

		// calendar presentation and interaction related props
		renderMonthText: null,
		orientation: HORIZONTAL_ORIENTATION,
		anchorDirection: ANCHOR_LEFT,
		horizontalMargin: 0,
		withPortal: false,
		withFullScreenPortal: false,
		initialVisibleMonth: null,
		numberOfMonths: 1,
		keepOpenOnDateSelect: false,
		reopenPickerOnClearDates: false,
		isRTL: false,

		// navigation related props
		navPosition: NAV_POSITION_TOP,
		navPrev: null,
		navNext: null,
		renderNavPrevButton: (props) => {
			return renderNavPrevButton({
				...props,
				disabled: navDate && navDate.isSame(minDateInYear, 'month')
			});
		},
		renderNavNextButton: (props) => {
			return renderNavNextButton({
				...props,
				disabled: navDate && navDate.isSame(maxDateInYear, 'month')
			});
		},
		onPrevMonthClick: (day) => setNavDate(moment.utc(day)),
		onNextMonthClick: (day) => setNavDate(moment.utc(day)),
		onClose() {},

		// day presentation and interaction related props
		renderCalendarDay: undefined,
		renderDayContents: null,
		minimumNights: 1,
		enableOutsideDays: false,
		isDayBlocked: () => false,
		isOutsideRange: day => moment.utc(day).isBefore(minDate, 'day') || moment.utc(day).isAfter(maxDate, 'day'),
		isDayHighlighted: () => false,

		// internationalization
		displayFormat: () => moment.localeData().longDateFormat('L'),
		monthFormat: 'MMMM YYYY',
		phrases: DateRangePickerPhrases,
	};

	const stateDateWrapper = date => date;

	const [active, setActive] = useState(false);
	const [startDate, setStartDate] = useState(initialStartDate);
	const [endDate, setEndDate] = useState(initialEndDate);

	const [focusedInput, setFocusedInput] = useState(() => {
		if (autoFocus) {
			return START_DATE;
		}
		else if (autoFocusEndDate) {
			return END_DATE;
		}
		else {
			return null;
		}
	});

	const onActiveChange = (active) => {
		setActive(active);
		setStartDate(initialStartDate);
		setEndDate(initialEndDate);
		setFocusedInput(null);

		if (!active) {
			setNavDate(currentDate.clone());
		}
	}

	const onDatesChange = ({ startDate, endDate }) => {
		setStartDate(startDate && stateDateWrapper(startDate));
		setEndDate(endDate && stateDateWrapper(endDate));
	}

	const onFocusChange = (focusedInput) => {
		setFocusedInput(focusedInput);
		setNavDate(currentDate.clone());
	}

	const setFilterValue = () => {
		const startDateString = startDate.format(dateFormat);
		const endDateString = endDate.format(dateFormat);

		onFilterSelect({ key: dataField, value: `${startDateString} - ${endDateString}` });
		setActive(false);
		setStartDate(initialStartDate);
		setEndDate(initialEndDate);
		setFocusedInput(null);
		setNavDate(currentDate.clone());
	}

	return(
		<ClayDropDown
			active={active}
			menuElementAttrs={{
				className: 'dropdown-menu-width-auto overflow-visible'
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
					<div className="dropdown-section">
						<DateRangePicker
							{...otherProps}
							onDatesChange={onDatesChange}
							onFocusChange={onFocusChange}
							focusedInput={focusedInput}
							startDate={startDate}
							endDate={endDate}
							renderMonthElement={({ month, onMonthSelect, onYearSelect }) => (
								<div className="date-picker-nav justify-content-center">
									<div className="date-picker-nav-item input-date-picker-month">
										<ClaySelect
											className="form-control-sm"
											name="month"
											onChange={(e) => {
												onMonthSelect(month, e.target.value);
												setNavDate(month.clone().set('month', e.target.value));
											}}
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
											onChange={(e) => {
												onYearSelect(month, e.target.value);
												setNavDate(month.clone().set('year', e.target.value));
											}}
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
					</div>

					<div className="dropdown-section">
						<ClayButton block disabled={startDate && endDate ? false : true} onClick={setFilterValue} displayType="primary">
							{Liferay.Language.get('add-filter')}
						</ClayButton>
					</div>
				</React.Fragment>
			}
		</ClayDropDown>
	)
}

export default DatePickerRange;