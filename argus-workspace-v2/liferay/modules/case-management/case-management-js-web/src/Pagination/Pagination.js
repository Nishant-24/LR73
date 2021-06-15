import React from 'react';
import { ClayPaginationBarWithBasicItems } from '@clayui/pagination-bar';

const Pagination = (props) => {
	const {
		dataSize,
		onPageChange,
		onSizePerPageChange,
		page,
		sizePerPage,
		sizePerPageList,
	} = props;

	const deltas = sizePerPageList.map(delta => {
		return { label: delta };
	});
		
	return (
		<ClayPaginationBarWithBasicItems
			activeDelta={sizePerPage}
			activePage={page}
			className="px-3"
			deltas={deltas}
			ellipsisBuffer={3}
			onDeltaChange={(delta) => {
				onSizePerPageChange(delta, 1);
			}}
			onPageChange={onPageChange}
			size="sm"
			totalItems={dataSize}
		/>
	);
};
	
export default Pagination;
