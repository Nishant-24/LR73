import React from 'react';
import ClayLayout from '@clayui/layout';
import ClayCard from '@clayui/card';

const Colors = () => {
	return (
		<ClayLayout.Sheet className="mb-5">
			<ClayLayout.SheetHeader>
				<h3 className="sheet-title">Colors</h3>
			</ClayLayout.SheetHeader>

			<ClayLayout.SheetSection>
				<h4 className="sheet-subtitle">Text</h4>
				<div className="sheet-text">
					<div className="card-deck">
						<ClayCard>
							<ClayCard.Body className="card-item-first d-flex align-items-center justify-content-center" style={{ height: 150, backgroundColor: 'var(--gray-dark)' }}>
								<ClayCard.Description displayType="title" className="text-white">
									Main Text
								</ClayCard.Description>
							</ClayCard.Body>
							<div className="card-footer text-center">
								<small className="text-muted text-uppercase">{getComputedStyle(document.documentElement).getPropertyValue('--gray-dark')}</small>
							</div>
						</ClayCard>

						<ClayCard>
							<ClayCard.Body className="card-item-first d-flex align-items-center justify-content-center" style={{ height: 150, backgroundColor: 'var(--gray-500)' }}>
								<ClayCard.Description displayType="title" className="text-white">
									Default Input Text
								</ClayCard.Description>
							</ClayCard.Body>
							<div className="card-footer text-center">
								<small className="text-muted text-uppercase">{getComputedStyle(document.documentElement).getPropertyValue('--gray-500')}</small>
							</div>
						</ClayCard>

						<ClayCard>
							<ClayCard.Body className="card-item-first d-flex align-items-center justify-content-center" style={{ height: 150, backgroundColor: 'var(--white)' }}>
								<ClayCard.Description displayType="title" className="text-gray">
									Button Text
								</ClayCard.Description>
							</ClayCard.Body>
							<div className="card-footer text-center">
								<small className="text-muted text-uppercase">{getComputedStyle(document.documentElement).getPropertyValue('--white')}</small>
							</div>
						</ClayCard>

						<ClayCard>
							<ClayCard.Body className="card-item-first d-flex align-items-center justify-content-center" style={{ height: 150, backgroundColor: 'var(--danger)' }}>
								<ClayCard.Description displayType="title" className="text-white">
									Required Text
								</ClayCard.Description>
							</ClayCard.Body>
							<div className="card-footer text-center">
								<small className="text-muted text-uppercase">{getComputedStyle(document.documentElement).getPropertyValue('--danger')}</small>
							</div>
						</ClayCard>
					</div>
				</div>
			</ClayLayout.SheetSection>

			<ClayLayout.SheetSection>
				<h4 className="sheet-subtitle">Buttons</h4>
				<div className="sheet-text">
					<div className="card-deck">
						<ClayCard>
							<ClayCard.Body className="card-item-first d-flex align-items-center justify-content-center" style={{ height: 150, backgroundColor: 'var(--primary)' }}>
								<ClayCard.Description displayType="title" className="text-white">
									Default State
								</ClayCard.Description>
							</ClayCard.Body>
							<div className="card-footer text-center">
								<small className="text-muted text-uppercase">{getComputedStyle(document.documentElement).getPropertyValue('--primary')}</small>
							</div>
						</ClayCard>

						<ClayCard>
							<ClayCard.Body className="card-item-first d-flex align-items-center justify-content-center" style={{ height: 150, backgroundColor: '#004d92' }}>
								<ClayCard.Description displayType="title" className="text-white">
									Hover / Active
								</ClayCard.Description>
							</ClayCard.Body>
							<div className="card-footer text-center">
								<small className="text-muted text-uppercase">#004d92</small>
							</div>
						</ClayCard>

						<ClayCard>
							<ClayCard.Body className="card-item-first d-flex align-items-center justify-content-center" style={{ height: 150, backgroundColor: 'var(--gray-400)' }}>
								<ClayCard.Description displayType="title" className="text-white">
									Disabled
								</ClayCard.Description>
							</ClayCard.Body>
							<div className="card-footer text-center">
								<small className="text-muted text-uppercase">{getComputedStyle(document.documentElement).getPropertyValue('--gray-400')}</small>
							</div>
						</ClayCard>

						<ClayCard>
							<ClayCard.Body className="card-item-first d-flex align-items-center justify-content-center" style={{ height: 150, backgroundColor: 'var(--success)' }}>
								<ClayCard.Description displayType="title" className="text-white">
									Approve Default State
								</ClayCard.Description>
							</ClayCard.Body>
							<div className="card-footer text-center">
								<small className="text-muted text-uppercase">{getComputedStyle(document.documentElement).getPropertyValue('--success')}</small>
							</div>
						</ClayCard>

						<ClayCard>
							<ClayCard.Body className="card-item-first d-flex align-items-center justify-content-center" style={{ height: 150, backgroundColor: '#075653' }}>
								<ClayCard.Description displayType="title" className="text-white">
									Approve Hover / Active
								</ClayCard.Description>
							</ClayCard.Body>
							<div className="card-footer text-center">
								<small className="text-muted text-uppercase">#075653</small>
							</div>
						</ClayCard>
					</div>
				</div>
			</ClayLayout.SheetSection>

			<ClayLayout.SheetSection>
				<h4 className="sheet-subtitle">Backgrounds & Lines</h4>
				<div className="sheet-text">
					<div className="card-deck">
						<ClayCard>
							<ClayCard.Body className="card-item-first d-flex align-items-center justify-content-center" style={{ height: 150, backgroundColor: 'var(--white)' }}>
								<ClayCard.Description displayType="title" className="text-gray">
									Main Background
								</ClayCard.Description>
							</ClayCard.Body>
							<div className="card-footer text-center">
								<small className="text-muted text-uppercase">{getComputedStyle(document.documentElement).getPropertyValue('--white')}</small>
							</div>
						</ClayCard>

						<ClayCard>
							<ClayCard.Body className="card-item-first d-flex align-items-center justify-content-center" style={{ height: 150, backgroundColor: 'var(--gray-200)' }}>
								<ClayCard.Description displayType="title" className="text-gray">
									Secondary Background
								</ClayCard.Description>
							</ClayCard.Body>
							<div className="card-footer text-center">
								<small className="text-muted text-uppercase">{getComputedStyle(document.documentElement).getPropertyValue('--gray-200')}</small>
							</div>
						</ClayCard>

						<ClayCard>
							<ClayCard.Body className="card-item-first d-flex align-items-center justify-content-center" style={{ height: 150, backgroundColor: '#e7f7ff' }}>
								<ClayCard.Description displayType="title" className="text-gray">
									Highlight Background
								</ClayCard.Description>
							</ClayCard.Body>
							<div className="card-footer text-center">
								<small className="text-muted text-uppercase">#e7f7ff</small>
							</div>
						</ClayCard>

						<ClayCard>
							<ClayCard.Body className="card-item-first d-flex align-items-center justify-content-center" style={{ height: 150, backgroundColor: '#d1efff' }}>
								<ClayCard.Description displayType="title" className="text-gray">
									Highlight Sub-Row
								</ClayCard.Description>
							</ClayCard.Body>
							<div className="card-footer text-center">
								<small className="text-muted text-uppercase">#d1efff</small>
							</div>
						</ClayCard>

						<ClayCard>
							<ClayCard.Body className="card-item-first d-flex align-items-center justify-content-center" style={{ height: 150, backgroundColor: 'var(--gray-300)' }}>
								<ClayCard.Description displayType="title" className="text-center">
										Card Border<br/>
										Row Lines
								</ClayCard.Description>
							</ClayCard.Body>
							<div className="card-footer text-center">
								<small className="text-muted text-uppercase">{getComputedStyle(document.documentElement).getPropertyValue('--gray-300')}</small>
							</div>
						</ClayCard>

						<ClayCard>
							<ClayCard.Body className="card-item-first d-flex align-items-center justify-content-center" style={{ height: 150, backgroundColor: 'var(--info)' }}>
								<ClayCard.Description displayType="title" className="text-white">
									Row Highlights
								</ClayCard.Description>
							</ClayCard.Body>
							<div className="card-footer text-center">
								<small className="text-muted text-uppercase">{getComputedStyle(document.documentElement).getPropertyValue('--info')}</small>
							</div>
						</ClayCard>

						<ClayCard>
							<ClayCard.Body className="card-item-first d-flex align-items-center justify-content-center" style={{ height: 150, backgroundColor: 'var(--gray-400)' }}>
								<ClayCard.Description displayType="title" className="text-white">
									Input Field Default Stroke
								</ClayCard.Description>
							</ClayCard.Body>
							<div className="card-footer text-center">
								<small className="text-muted text-uppercase">{getComputedStyle(document.documentElement).getPropertyValue('--gray-400')}</small>
							</div>
						</ClayCard>

						<ClayCard>
							<ClayCard.Body className="card-item-first d-flex align-items-center justify-content-center" style={{ height: 150, backgroundColor: 'var(--gray-500)' }}>
								<ClayCard.Description displayType="title" className="text-white text-center">
										Input Field Hover<br/>
										Active Stroke
								</ClayCard.Description>
							</ClayCard.Body>
							<div className="card-footer text-center">
								<small className="text-muted text-uppercase">{getComputedStyle(document.documentElement).getPropertyValue('--gray-500')}</small>
							</div>
						</ClayCard>
					</div>
				</div>
			</ClayLayout.SheetSection>

			<ClayLayout.SheetSection>
				<h4 className="sheet-subtitle">Status</h4>
				<div className="sheet-text">
					<div className="card-deck">
						<ClayCard>
							<ClayCard.Body className="card-item-first d-flex align-items-center justify-content-center" style={{ height: 150, backgroundColor: 'var(--warning)' }}>
								<ClayCard.Description displayType="title" className="text-white">
									Open
								</ClayCard.Description>
							</ClayCard.Body>
							<div className="card-footer text-center">
								<small className="text-muted text-uppercase">{getComputedStyle(document.documentElement).getPropertyValue('--warning')}</small>
							</div>
						</ClayCard>

						<ClayCard>
							<ClayCard.Body className="card-item-first d-flex align-items-center justify-content-center" style={{ height: 150, backgroundColor: 'var(--teal)' }}>
								<ClayCard.Description displayType="title" className="text-white">
									Approved
								</ClayCard.Description>
							</ClayCard.Body>
							<div className="card-footer text-center">
								<small className="text-muted text-uppercase">{getComputedStyle(document.documentElement).getPropertyValue('--teal')}</small>
							</div>
						</ClayCard>

						<ClayCard>
							<ClayCard.Body className="card-item-first d-flex align-items-center justify-content-center" style={{ height: 150, backgroundColor: 'var(--info)' }}>
								<ClayCard.Description displayType="title" className="text-white">
									Closed
								</ClayCard.Description>
							</ClayCard.Body>
							<div className="card-footer text-center">
								<small className="text-muted text-uppercase">{getComputedStyle(document.documentElement).getPropertyValue('--info')}</small>
							</div>
						</ClayCard>
					</div>
				</div>
			</ClayLayout.SheetSection>

			<ClayLayout.SheetSection>
				<h4 className="sheet-subtitle">Charts</h4>
				<div className="sheet-text">
					<div className="card-deck">
						<ClayCard>
							<ClayCard.Body className="card-item-first d-flex align-items-center justify-content-center" style={{ height: 150, backgroundColor: 'var(--purple)' }}>
								<ClayCard.Description displayType="title" className="text-white">
									Color 1
								</ClayCard.Description>
							</ClayCard.Body>
							<div className="card-footer text-center">
								<small className="text-muted text-uppercase">{getComputedStyle(document.documentElement).getPropertyValue('--purple')}</small>
							</div>
						</ClayCard>

						<ClayCard>
							<ClayCard.Body className="card-item-first d-flex align-items-center justify-content-center" style={{ height: 150, backgroundColor: 'var(--pink)' }}>
								<ClayCard.Description displayType="title" className="text-white">
									Color 2
								</ClayCard.Description>
							</ClayCard.Body>
							<div className="card-footer text-center">
								<small className="text-muted text-uppercase">{getComputedStyle(document.documentElement).getPropertyValue('--pink')}</small>
							</div>
						</ClayCard>

						<ClayCard>
							<ClayCard.Body className="card-item-first d-flex align-items-center justify-content-center" style={{ height: 150, backgroundColor: 'var(--orange)' }}>
								<ClayCard.Description displayType="title" className="text-white">
									Color 3
								</ClayCard.Description>
							</ClayCard.Body>
							<div className="card-footer text-center">
								<small className="text-muted text-uppercase">{getComputedStyle(document.documentElement).getPropertyValue('--orange')}</small>
							</div>
						</ClayCard>

						<ClayCard>
							<ClayCard.Body className="card-item-first d-flex align-items-center justify-content-center" style={{ height: 150, backgroundColor: 'var(--yellow)' }}>
								<ClayCard.Description displayType="title" className="text-white">
									Color 4
								</ClayCard.Description>
							</ClayCard.Body>
							<div className="card-footer text-center">
								<small className="text-muted text-uppercase">{getComputedStyle(document.documentElement).getPropertyValue('--yellow')}</small>
							</div>
						</ClayCard>

						<ClayCard>
							<ClayCard.Body className="card-item-first d-flex align-items-center justify-content-center" style={{ height: 150, backgroundColor: 'var(--gold)' }}>
								<ClayCard.Description displayType="title" className="text-white">
									Color 5
								</ClayCard.Description>
							</ClayCard.Body>
							<div className="card-footer text-center">
								<small className="text-muted text-uppercase">{getComputedStyle(document.documentElement).getPropertyValue('--gold')}</small>
							</div>
						</ClayCard>

						<ClayCard>
							<ClayCard.Body className="card-item-first d-flex align-items-center justify-content-center" style={{ height: 150, backgroundColor: 'var(--green)' }}>
								<ClayCard.Description displayType="title" className="text-white">
									Color 6
								</ClayCard.Description>
							</ClayCard.Body>
							<div className="card-footer text-center">
								<small className="text-muted text-uppercase">{getComputedStyle(document.documentElement).getPropertyValue('--green')}</small>
							</div>
						</ClayCard>

						<ClayCard>
							<ClayCard.Body className="card-item-first d-flex align-items-center justify-content-center" style={{ height: 150, backgroundColor: 'var(--cyan)' }}>
								<ClayCard.Description displayType="title" className="text-white">
									Color 7
								</ClayCard.Description>
							</ClayCard.Body>
							<div className="card-footer text-center">
								<small className="text-muted text-uppercase">{getComputedStyle(document.documentElement).getPropertyValue('--cyan')}</small>
							</div>
						</ClayCard>

						<ClayCard>
							<ClayCard.Body className="card-item-first d-flex align-items-center justify-content-center" style={{ height: 150, backgroundColor: 'var(--gray-400)' }}>
								<ClayCard.Description displayType="title" className="text-white">
									Others
								</ClayCard.Description>
							</ClayCard.Body>
							<div className="card-footer text-center">
								<small className="text-muted text-uppercase">{getComputedStyle(document.documentElement).getPropertyValue('--gray-400')}</small>
							</div>
						</ClayCard>
					</div>
				</div>
			</ClayLayout.SheetSection>
		</ClayLayout.Sheet>
	);
};

export default Colors;