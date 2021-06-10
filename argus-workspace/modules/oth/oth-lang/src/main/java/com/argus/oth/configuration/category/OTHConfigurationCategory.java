package com.argus.oth.configuration.category;

import com.liferay.configuration.admin.category.ConfigurationCategory;

import org.osgi.service.component.annotations.Component;

/**
 * @author Eric Chin
 */
@Component(service = ConfigurationCategory.class)
public class OTHConfigurationCategory implements ConfigurationCategory {

	@Override
	public String getBundleSymbolicName() {
		return "com.argus.oth.lang";
	}

	@Override
	public String getCategoryKey() {
		return _CATEGORY_KEY;
	}

	@Override
	public String getCategorySection() {
		return _SECTION_KEY;
	}

	private static final String _CATEGORY_KEY = "oth-portal";

	private static final String _SECTION_KEY = "platform";

}