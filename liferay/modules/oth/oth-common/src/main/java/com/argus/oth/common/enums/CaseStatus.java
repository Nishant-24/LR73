package com.argus.oth.common.enums;

/**
 * @author Jaclyn Ong
 */
public enum CaseStatus {

	CLOSED("Closed"), IN_PROCESS("In Process");

	public String getStatusText() {
		return _statusText;
	}

	private CaseStatus(String key) {
		_statusText = key;
	}

	private final String _statusText;

}