import React, { useState } from 'react';
import ClayButton from '@clayui/button';
import ClayDropDown from '@clayui/drop-down';
import { ClayInput } from '@clayui/form';
import ClayIcon from '@clayui/icon';
import isEqual from 'lodash.isequal';

const ListPicker = (props) => {
	const spritemap = themeDisplay.getPathThemeImages() + '/argus/icons.svg';

	const {
		dataField,
		dynamic = true,
		filterLabel,
		formatter,
		labels,
		onFilterSelect,
		searchable = true,
		source,
	} = props;

	let data = [];

	const reduce = (obj, key) => {
		const keySplit = key.split('.');

		if (keySplit.length > 1) {
			return reduce(obj[keySplit[0]], keySplit.slice(1, keySplit.length).join('.'));
		}

		if (keySplit.length == 1) {
			if (key in obj) {
				return obj[key];
			}
			else {
				return;
			}
		}
		else {
			return;
		}
	}

	if (dynamic) {
		source.map((ref) => {
			data.push(reduce(ref, dataField));
		});

		data = [...new Set(data)].filter(n => n);
	}
	else {
		data = source;
	}

	const [active, setActive] = useState(false);
	const [search, setSearch] = useState('');
	const [items, setItems] = useState(() => dynamic ? [] : data);

	const onSearchValueChange = (event) => {
		const value = event.target.value;

		setSearch(value);

		if (value) {
			const result = data.filter((item) =>
				item.toLowerCase().match(value.toLowerCase())
			).slice(0, 5);

			setItems(result);
		}
		else {
			setItems([]);
		}
	}

	const selected = (value) => {
		return labels.some(label => isEqual(label,
			{
				key: dataField,
				value: value
			}
		));
	}

	const onKeyPress = (event) => {
		if (event.key === 'Enter') {

			if (items.length) {
				const target = event.target;
				const keyboardEvent = new KeyboardEvent('keydown', {
					bubbles: true,
					key: 'ArrowDown',
					keyCode: 40,
					charCode: 0,
				});

				target.dispatchEvent(keyboardEvent);
			}
		}
	}

	return(
		<ClayDropDown
			active={active}
			hasRightSymbols={true}
			onActiveChange={setActive}
			trigger={
				<ClayButton className={active && "active"} displayType="hybrid" small>
					<ClayIcon className="inline-item-before" symbol="plus" />
					{filterLabel}
				</ClayButton>
			}
		>
			{searchable &&
				<div className="dropdown-section mb-2">
					<ClayInput.Group small>
						<ClayInput.GroupItem>
							<ClayInput
								insetAfter
								onChange={onSearchValueChange}
								onKeyPress={onKeyPress}
								type="text"
								value={search}
							/>
							<ClayInput.GroupInsetItem after tag="span">
								<ClayIcon
									className="mt-0 mx-2"
									symbol="search"
								/>
							</ClayInput.GroupInsetItem>
						</ClayInput.GroupItem>
					</ClayInput.Group>
				</div>
			}

			<div className="inline-scroller">
				<ClayDropDown.ItemList className="mb-0">
					{search && !items.length &&
						<ClayDropDown.Caption>{Liferay.Language.get('sorry-we-couldnt-find-any-matches')}</ClayDropDown.Caption>
					}

					{items.map((item, index) => (
						<ClayDropDown.Item
							active={selected(item)}
							disabled={selected(item)}
							key={index}
							onClick={() => {
								onFilterSelect({ key: dataField, value: item });
								setActive(false);

								if (searchable) {
									setSearch('');
									setItems([]);
								}
							}}
							symbolRight="check"
						>
							{formatter &&
								<ClayIcon
									className={`case-list__icon ${formatter(item)}`}
									spritemap={spritemap}
									symbol={formatter(item)}
								/>
							}
							{item}
						</ClayDropDown.Item>
					))}
				</ClayDropDown.ItemList>
			</div>
		</ClayDropDown>
	)
}

export default ListPicker;