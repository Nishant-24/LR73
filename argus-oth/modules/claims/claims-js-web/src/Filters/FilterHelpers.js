import React, { useState } from 'react';
import ClayButton from '@clayui/button';
import ClayIcon from '@clayui/icon';

const range = ({end, start}) => {
	return Array.from(
		{
			length: end - start + 1,
		},
		(v, k) => k + start
	);
}

const renderNavPrevButton = (buttonProps) => {
	const {
		ariaLabel,
		disabled,
		onClick,
		onKeyUp,
		onMouseUp,
	} = buttonProps;

	return (
		<ClayButton
			aria-label={ariaLabel}
			className="DayPickerNavigation_button__horizontalDefault DayPickerNavigation_leftButton__horizontalDefault mt-1"
			disabled={disabled}
			displayType="unstyled"
			monospaced
			onClick={onClick}
			onKeyUp={onKeyUp}
			onMouseUp={onMouseUp}
			small
		>
			<ClayIcon symbol="angle-left" />
		</ClayButton>
	)
}

const renderNavNextButton = (buttonProps) => {
	const {
		ariaLabel,
		disabled,
		onClick,
		onKeyUp,
		onMouseUp,
	} = buttonProps;

	return (
		<ClayButton
			aria-label={ariaLabel}
			className="DayPickerNavigation_button__horizontalDefault DayPickerNavigation_rightButton__horizontalDefault mt-1"
			disabled={disabled}
			displayType="unstyled"
			monospaced
			onClick={onClick}
			onKeyUp={onKeyUp}
			onMouseUp={onMouseUp}
			small
		>
			<ClayIcon symbol="angle-right" />
		</ClayButton>
	)
}

export {
	renderNavNextButton,
	renderNavPrevButton,
	range,
}