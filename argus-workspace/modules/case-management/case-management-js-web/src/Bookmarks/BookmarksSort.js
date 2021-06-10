import React from 'react';
import { ClaySelect } from '@clayui/form';
import { useSelector } from 'react-redux';
import ClayLayout from '@clayui/layout';

const options = [
	{
		label: Liferay.Language.get('estimate-asc'),
		value: "estimate-asc"
	},
	{
		label: Liferay.Language.get('estimate-desc'),
		value: "estimate-desc"
	},
	{
		label: Liferay.Language.get('member-name-asc'),
		value: "memberName-asc"
	},
	{
		label: Liferay.Language.get('member-name-desc'),
		value: "memberName-desc"
	},
	{
		label: Liferay.Language.get('status-asc'),
		value: "status-asc"
	},
	{
		label: Liferay.Language.get('status-desc'),
		value: "status-desc"
	},
	{
		label: Liferay.Language.get('bookmarked-on-asc'),
		value: "createDate-asc"
	},
	{
		label: Liferay.Language.get('bookmarked-on-desc'),
		value: "createDate-desc"
	}
];

const Sort = (props) => {
	const bookmarks = useSelector((state) => state.bookmarks.data);

	return (
		<div className="case-filter bg-white">
			<div className="case-filter__header">
				<h4 className="mb-0">{Liferay.Language.get('bookmarks')} ({bookmarks.length})</h4>
				<div className="d-flex align-items-center">
					<div className="text-nowrap mr-2">{Liferay.Language.get('sort-by')}</div>
					<ClaySelect onChange={props.onChange} defaultValue=''>
						<ClaySelect.Option
							disabled={true}
							label={Liferay.Language.get('select-an-option')}
							value=''
						/>

						{options.map(item => (
							<ClaySelect.Option
								key={item.value}
								label={item.label}
								value={item.value}
							/>
						))}
					</ClaySelect>
				</div>
			</div>
		</div>
	)
}

export default Sort;