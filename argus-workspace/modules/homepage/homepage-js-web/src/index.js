import React from 'react';
import ReactDOM from 'react-dom';
import {Provider} from 'react-redux';
import regeneratorRuntime from 'regenerator-runtime';
import { ClayIconSpriteContext } from '@clayui/icon';
import store from './store';
import App from './App';

export default function main({portletNamespace, contextPath, portletElementId, configuration}) {
	const container = document.getElementById(portletElementId);
	const spritemap = themeDisplay.getPathThemeImages() + '/argus/icons.svg';

	ReactDOM.render(
		<ClayIconSpriteContext.Provider value={spritemap}>
			<Provider store={store}>
				<App
					configuration={configuration}
					contextPath={contextPath}
					portletElementId={portletElementId}
					portletNamespace={portletNamespace}
				/>
			</Provider>
		</ClayIconSpriteContext.Provider>,
		container
	);

	Liferay.once('destroyPortlet', function() {
		ReactDOM.unmountComponentAtNode(container);
	});
}