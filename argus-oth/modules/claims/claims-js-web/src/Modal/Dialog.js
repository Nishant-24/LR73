import React, { useRef } from 'react';
import ClayButton from '@clayui/button';
import ClayModal, { useModal } from '@clayui/modal';
import { removeOutsideClickEvent } from './removeOutsideClickEvent';

const Dialog = (props) => {
	const wrapperRef = useRef(null);

	removeOutsideClickEvent(wrapperRef);

	const { observer, onClose } = useModal({
		onClose: () => {
			props.setVisible(false);
		}
	});

	const {
		center = false,
		className = '',
		hideFooter = true,
		size = 'full-screen',
		status,
		title,
		visible = false,
	} = props;

	return visible && (
		<ClayModal
			center={center}
			className={className}
			observer={observer}
			size={size}
			status={status}
		>
			<div ref={wrapperRef}>
				<ClayModal.Header>{title}</ClayModal.Header>
				<ClayModal.Body>
					{props.children}
				</ClayModal.Body>
				{!hideFooter &&
					<ClayModal.Footer
						last={
							<ClayButton displayType="secondary" onClick={onClose}>
								{Liferay.Language.get("close")}
							</ClayButton>
						}
					/>
				}
			</div>
		</ClayModal>
	);
};

export default Dialog;