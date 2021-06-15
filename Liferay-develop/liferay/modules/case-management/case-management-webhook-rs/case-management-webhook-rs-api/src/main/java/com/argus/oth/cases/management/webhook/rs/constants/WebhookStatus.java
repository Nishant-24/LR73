package com.argus.oth.cases.management.webhook.rs.constants;

/**
 * @author Eric Chin
 */
public enum WebhookStatus {

	DEFAULT(-1), SUCCESS(0);

	public static WebhookStatus getWebhookStatusByCode(long statusCode) {
		for (WebhookStatus webhookStatus : WebhookStatus.values()) {
			if (webhookStatus.getStatusCode() == statusCode) {
				return webhookStatus;
			}
		}

		return DEFAULT;
	}

	public long getStatusCode() {
		return _statusCode;
	}

	private WebhookStatus(long statusCode) {
		_statusCode = statusCode;
	}

	private final long _statusCode;

}