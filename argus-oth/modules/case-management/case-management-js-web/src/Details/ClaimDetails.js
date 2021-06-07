import React, { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import BootstrapTable from 'react-bootstrap-table-next';
import paginationFactory, { PaginationProvider } from 'react-bootstrap-table2-paginator';
import { getDetails } from './DetailsSlice';
import { columns, expandRow, defaultSorted } from './TableHelpers';
import { Pagination } from '~/Pagination/index';
import LoadingIndicator from '~/LoadingIndicator/LoadingIndicator';

const ClaimDetails = (props) => {
	const caseId = useSelector((state) => state.modal.caseId);
	const details = useSelector((state) => state.details.data.claims);
	const status = useSelector((state) => state.details.status);
	const error = useSelector((state) => state.details.error);
	const dispatch = useDispatch();

	useEffect(() => {
		if (caseId) {
			dispatch(getDetails());
		}
	}, []);

	const options = {
		custom: true,
		totalSize: details.length,
	};

	return (
		<LoadingIndicator status={status} error={error}>
			<div className="case-template">
				<div className="case-template__content p-0">
					<div className="case-claim-details__header">
						<h4 className="mb-0">{Liferay.Language.get('claim-details')}</h4>
					</div>

					<PaginationProvider pagination={paginationFactory(options)}>
						{
							({
								paginationProps,
								paginationTableProps
							}) => (
								<React.Fragment>
									<BootstrapTable
										{...paginationTableProps}
										bordered={false}
										classes="case-claim-details table-list table-valign-top thead-border-top-0"
										columns={columns}
										data={details}
										defaultSorted={defaultSorted}
										expandRow={expandRow}
										hover={true}
										keyField="claimId"
										noDataIndication={Liferay.Language.get('no-results-were-found')}
										wrapperClasses="table-responsive"
									/>

									<Pagination {...paginationProps} />
								</React.Fragment>
							)
						}
					</PaginationProvider>
				</div>
			</div>
		</LoadingIndicator>
	)
}

export default ClaimDetails;