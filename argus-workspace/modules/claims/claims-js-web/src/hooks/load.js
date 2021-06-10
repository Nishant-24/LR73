import React from 'react';

const load = (key, path) => {
	return new Promise((resolve, reject) => {
		Liferay.Loader.require(
			[`claims-js-web@1.0.0/${path}${key}`],
			(Plugin) => {
				resolve(Plugin.default);
			},
			(error) => {
				reject(error);
			}
		);
	}).then((Component) => {
		return {
			default: () => {
				return Component ? <Component /> : null;
			}
		}
	});
}

export default load;