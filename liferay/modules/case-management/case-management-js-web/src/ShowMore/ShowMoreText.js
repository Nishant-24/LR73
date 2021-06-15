import React, { Component } from 'react';
import Truncate from './Truncate';

class ShowMoreText extends Component {

	constructor(props) {
		super(props);

		this._isMounted = false;

		this.state = {
			expanded: false,
			truncated: false
		};

		this.handleTruncate = this.handleTruncate.bind(this);
		this.toggleLines = this.toggleLines.bind(this);
	}

	componentDidMount() {
		this._isMounted = true;

		var _self = this;
		if (this._isMounted) {
			this.setState({
				expanded: _self.props.expanded
			});
		}
	}

	componentWillUnmount() {
		this._isMounted = false;
	}

	handleTruncate(truncated) {
		if (this._isMounted && truncated !== this.state.truncated) {
			this.setState({
				truncated
			});
			if (truncated) { this.truncateRef.onResize(); }
		}
	};

	toggleLines(event) {
		event.preventDefault();
		var _self = this;
		if (this._isMounted) {
			this.setState(
				{
					expanded: !this.state.expanded
				},
				() => {
					if (_self.props.onClick) {
						_self.props.onClick(_self.state.expanded);
					}
				}
			);
		}
	};

	render() {
		const {
			children,
			more,
			less,
			lines,
			anchorClass,
			className,
			width,
			keepNewLines
		} = this.props;

		const { expanded, truncated } = this.state;

		return (
			<div className={className}>
				<Truncate
					width={width}
					lines={!expanded && lines}
					ellipsis={
						<span>
							...{' '}
							<a
								href='javascript:;'
								className={anchorClass}
								onClick={this.toggleLines}
							>
								{more}
							</a>
						</span>
					}
					onTruncate={this.handleTruncate}
					ref={ref => (this.truncateRef = ref)}
				>
					{keepNewLines ?
						children.split('\n').map((line, i, arr) => {
							line = <span key={i}>{line}</span>;

							if (i === arr.length - 1) {
								return line;
							} else {
								return [line, <br key={i + 'br'} />];
							}
						}
						)
						: children
					}
				</Truncate>
				{!truncated && expanded && (
					<span>
						{' '}
						<a
							href='javascript:;'
							className={anchorClass}
							onClick={this.toggleLines}
						>
							{less}
						</a>
					</span>
				)}
			</div>
		);
	}
}

ShowMoreText.defaultProps = {
	lines: 10,
	more: Liferay.Language.get('show-more'),
	less: Liferay.Language.get('show-less'),
	anchorClass: '',
	onClick: undefined,
	expanded: false,
	width: 0,
	keepNewLines: false
}

export default ShowMoreText;