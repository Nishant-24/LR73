import React, { useEffect, useState, useRef } from 'react';
import BootstrapTable from 'react-bootstrap-table-next';
import filterFactory from 'react-bootstrap-table2-filter';
import paginationFactory, { PaginationProvider } from 'react-bootstrap-table2-paginator';
import { useSelector, useDispatch } from 'react-redux';
import { getClaimsByStatus, getPermissions } from './ClaimsSlice';
import { CaseModal } from '~/Modal/index';
import { setCaseId, setClaimNumber } from '~/Modal/ModalSlice';
import { Pagination } from '~/Pagination/index';
import { defaultSorted, getColumns } from './TableHelpers';
import LoadingIndicator from '~/LoadingIndicator/LoadingIndicator';

const ClaimsList = (props) => {
	const dispatch = useDispatch();
	const claims = useSelector((state) => state.claims.data);
	const status = useSelector((state) => state.claims.status);
	const error = useSelector((state) => state.claims.error);
	const dateRange = useSelector((state) => state.claims.dateRange);

	const tableRef = useRef(null);

	const [modalVisible, setModalVisible] = useState(false);

	useEffect(() => {
		dispatch(getPermissions());
		dispatch(getClaimsByStatus(props.status));
	}, [dateRange]);

	const paginationOpts = {
		custom: true,
		totalSize: claims.length
	}

	return (
		<React.Fragment>
			<LoadingIndicator status={status} error={error}>
				<PaginationProvider pagination={paginationFactory(paginationOpts)}>
					{
						({
							paginationProps,
							paginationTableProps
						}) => (
							<React.Fragment>
										<BootstrapTable
											{...paginationTableProps}
											bordered={false}
											classes="table-list table-autofit tbody-valign-top thead-border-top-0"
											columns={getColumns(props.status)}
											data={claims}
											defaultSorted={defaultSorted}
											filter={filterFactory()}
											hover={true}
											keyField="claimNumber"
											noDataIndication={Liferay.Language.get('no-results-were-found')}
											ref={tableRef}
											rowClasses={(row, rowIndex) => {
												return row.caseId ? 'cursor-pointer': '';
											}}
											rowEvents={{
												onClick: (event, row, rowIndex) => {
													if (row.caseId) {
														dispatch(setCaseId(row.caseId));
														dispatch(setClaimNumber(row.claimNumber));
														setModalVisible(true);
													}
												}
											}}
											wrapperClasses="table-responsive"
										/>

										<Pagination {...paginationProps} />
								</React.Fragment>
							)
						}
				</PaginationProvider>
			</LoadingIndicator>

			<CaseModal
				setVisible={(visible) => setModalVisible(visible)}
				visible={modalVisible}
			/>
		</React.Fragment>
	)
}

export default ClaimsList;
