import React, { useState, useRef } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import BootstrapTable from 'react-bootstrap-table-next';
import paginationFactory, { PaginationProvider } from 'react-bootstrap-table2-paginator';
import { getBookmarks } from './BookmarksSlice';
import BookmarksSort from './BookmarksSort';
import { CaseModal } from "~/Modal/index";
import { setCaseId, setFilteredResults } from '~/Modal/ModalSlice';
import { bookmarksColumns } from './TableHelpers';
import { Pagination } from '~/Pagination/index';


const Bookmarks = (props) => {
	const dispatch = useDispatch();
	const bookmarks = useSelector((state) => state.bookmarks.data);

	const tableRef = useRef(null);
	
    const [modalVisible, setModalVisible] = useState(false);
    
    const [field, setField] = useState(null);
	const [order, setOrder] = useState(null);

    const sortBookmarksHandler = (event) => {
        
        if(event.target.value) {
            const valueParts = event.target.value.split('-');

            if(valueParts.length === 2){
                setField(valueParts[0]);
                setOrder(valueParts[1]);
            } 
        }
    }
    
	const options = {
		custom: true,
		totalSize: bookmarks.length,
	};
	  
	return (
		<React.Fragment>
			<PaginationProvider pagination={ paginationFactory(options) }>
				{
					({
						paginationProps,
						paginationTableProps
					}) => (
						<React.Fragment>
                            <BookmarksSort onChange={sortBookmarksHandler}/>
							<BootstrapTable
								{...paginationTableProps}
								bordered={false}
								classes="table-list table-autofit table-valign-bottom table-nowrap table-border-top-0"
								columns={bookmarksColumns}
                                data={bookmarks}
                                sort={{
                                    dataField: field,
                                    order: order
                                }}
								headerWrapperClasses="d-none"
								hover={true}
								keyField="caseId"
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

							<Pagination {...paginationProps} />
						</React.Fragment>
					)
				}
			</PaginationProvider>
			
			<CaseModal
				setVisible={(visible) => {
					setModalVisible(visible);
					dispatch(getBookmarks());
				}}
				visible={modalVisible}
			/>
			
		</React.Fragment>
	)
}

export default Bookmarks;