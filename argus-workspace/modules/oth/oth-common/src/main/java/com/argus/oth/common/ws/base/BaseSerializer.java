package com.argus.oth.common.ws.base;

import com.liferay.portal.kernel.util.Validator;

/**
 * @author Eric Chin
 */
public abstract class BaseSerializer {

	public String getValue(String value, String blankValue) {
		if (Validator.isBlank(value)) {
			return blankValue;
		}

		return value;
	}

}