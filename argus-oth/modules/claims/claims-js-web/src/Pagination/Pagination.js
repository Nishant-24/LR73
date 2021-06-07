import React from 'react';
import { ClayPaginationBarWithBasicItems } from '@clayui/pagination-bar';

const Pagination = (props) => {
	const spritemap = themeDisplay.getPathThemeImages() + '/clay/icons.svg';

	const {
		dataSize = 0,
		onPageChange,
		onSizePerPageChange,
		page,
		sizePerPage,
		sizePerPageList,
	} = props;

	const deltas = sizePerPageList.map(delta => {
		return { label: delta };
	});

	return (dataSize > 0) && (
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
			spritemap={spritemap}
			totalItems={dataSize}
		/>
	);
};
	
export default Pagination;
