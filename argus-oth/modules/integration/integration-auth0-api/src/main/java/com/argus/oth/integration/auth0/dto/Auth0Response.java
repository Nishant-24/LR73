package com.argus.oth.integration.auth0.dto;

/**
 * @author Eric Chin
 */
public class Auth0Response {

	public Auth0Response(Status status) {
		_status = status;
	}

	public Auth0Response(String message, Status status) {
		_message = message;
		_status = status;
	}

	public String getMessage() {
		return _message;
	}

	public Status getStatus() {
		return _status;
	}

	public void setMessage(String message) {
		_message = message;
	}

	public void setStatus(Status status) {
		_status = status;
	}

	public enum Status {

		FAILURE, SUCCESS

	}

	private String _message;
	private Status _status;

}