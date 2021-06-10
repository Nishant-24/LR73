import React from 'react';
import ClayDatePicker from '@clayui/date-picker'
import ClayForm, { ClayInput, ClaySelect, ClayRadio, ClayRadioGroup } from '@clayui/form';
import ClayIcon from '@clayui/icon';

const Input = (props) => {
	const dateNow = new Date();
	const {
		component = 'input',
		defaultValue,
		disabled,
		errorMsg = Liferay.Language.get('this-field-is-required'),
		fieldName,
		handleFieldChange,
		inline = false,
		inputRef,
		items,
		label,
		labelClassName,
		placeholder,
		required,
		showErrors,
		type = 'text',
		value,
		years = {
			end: dateNow.getFullYear() + 5,
			start: dateNow.getFullYear(),
		},
	} = props;

	const displayError = showErrors && !defaultValue;
	const onChange = (event) => {
		const fieldValue = event.target ? event.target.value : event;
		handleFieldChange(fieldName, fieldValue);
	};

	return (
		<ClayForm.Group className={displayError && 'has-error'} filled={defaultValue ? 'true' : null}>
			<label
				htmlFor={fieldName}
				className={labelClassName}>
				{label}
				{required &&
					<ClayIcon
						className="reference-mark"
						symbol="asterisk"
					/>
				}
			</label>

			{type === 'text' &&
				<ClayInput
					component={component}
					defaultValue={defaultValue}
					disabled={disabled}
					id={fieldName}
					name={fieldName}
					placeholder={placeholder}
					type={type}
					onChange={(e) => onChange(e)}
					ref={inputRef}
				/>
			}

			{type === 'select' &&
				<ClaySelect
					defaultValue={0}
					id={fieldName}
					onChange={(e) => onChange(e)}
				>
					<ClaySelect.Option
						disabled
						label={placeholder}
						value={0}
					/>
					{items.map((item, index) => (
						<ClaySelect.Option
							label={item.label}
							key={index}
							value={item.value}
						/>
					))}
				</ClaySelect>
			}

			{type === 'date' &&
				<ClayDatePicker
					id={fieldName}
					onValueChange={(e) => onChange(e)}
					placeholder={placeholder}
					value={value}
					years={years}
				/>
			}

			{type === 'radio' &&
				<ClayRadioGroup
					inline={inline}
					onSelectedValueChange={(e) => onChange(e)}
					selectedValue={value}
				>
					{items.map((item, index) => (
						<ClayRadio
							label={item.label}
							key={index}
							value={item.value}
						/>
					))}
				</ClayRadioGroup>
			}

			{displayError &&
				<ClayForm.FeedbackGroup>
					<ClayForm.FeedbackItem>
						<ClayForm.FeedbackIndicator
							symbol="exclamation-full"
						/>
						{errorMsg}
					</ClayForm.FeedbackItem>
				</ClayForm.FeedbackGroup>
			}
		</ClayForm.Group>
	);
};

export default Input;