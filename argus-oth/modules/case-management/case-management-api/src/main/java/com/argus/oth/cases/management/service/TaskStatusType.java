package com.argus.oth.cases.management.service;

public enum TaskStatusType {

	COMPLETED("Completed"), IN_PROGRESS("In Progress"), NEW("New");

	public String getStatusText() {
		return _statusText;
	}

	private TaskStatusType(String key) {
		_statusText = key;
	}

	private final String _statusText;

}