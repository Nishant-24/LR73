import React, { useEffect, useState, useRef } from 'react';
import BootstrapTable from 'react-bootstrap-table-next';
import filterFactory from 'react-bootstrap-table2-filter';
import paginationFactory, { PaginationProvider } from 'react-bootstrap-table2-paginator';
import { useSelector, useDispatch } from 'react-redux';
import { CaseModal } from '~/Modal/index';
import { setCaseId, setFilteredResults } from '~/Modal/ModalSlice';
import { getPermissions } from './CasesSlice';
import { Pagination } from '~/Pagination/index';
import { columns, defaultSorted } from './TableHelpers';

const CasesList = (props) => {
	const dispatch = useDispatch();
	const cases = useSelector((state) => state.cases.data);

	const tableRef = useRef(null);

	const [modalVisible, setModalVisible] = useState(false);

	const {
		hasPagination = true,
		id
	} = props;

	useEffect(() => {
		dispatch(getPermissions());
	}, []);

	const paginationOpts = {
		custom: true,
		totalSize: cases.length
	}

	return (
		<React.Fragment>
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
									classes="table-list table-autofit"
									columns={columns}
									data={cases}
									defaultSorted={defaultSorted}
									filter={filterFactory()}
									hover={true}
									keyField="caseId"
									noDataIndication={Liferay.Language.get('no-results-were-found')}
									ref={tableRef}
									rowClasses="cursor-pointer"
									rowEvents={{
										onClick: (event, row, rowIndex) => {
											dispatch(setCaseId(row.caseId));
											setModalVisible(true);
											setTimeout(() => {
												dispatch(setFilteredResults(tableRef.current.sortContext._reactInternalFiber.lastEffect.memoizedProps.data));
											}, 100);
										}
									}}
									wrapperClasses="table-responsive"
								/>

								{hasPagination &&
									<Pagination {...paginationProps} />
								}
							</React.Fragment>
						)
				}
			</PaginationProvider>

			<CaseModal
				setVisible={(visible) => setModalVisible(visible)}
				visible={modalVisible}
			/>
		</React.Fragment>
	)
}

export default CasesList;
