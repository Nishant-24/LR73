package com.argus.oth.integration.mulesoft.service;

import com.argus.oth.integration.mulesoft.service.configuration.MuleSoftConfigurator;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpMethods;
import com.liferay.portal.kernel.util.StringBundler;

import io.swagger.client.ApiClient;
import io.swagger.client.api.DefaultApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.net.HttpURLConnection;
import java.net.URL;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Jaclyn Ong
 */
public abstract class BaseMuleSoftIntegrationImpl {

	protected String callEndpoint(
			String urlString, String httpMethod, JSONObject bodyJSONObject, Map<String, String> headers)
		throws Exception {

		_headers = headers;

		_logDebug("URL: " + urlString);

		URL url = new URL(urlString);

		HttpURLConnection httpURLConnection = _getHttpURLConnection(httpMethod, url, bodyJSONObject);

		int responseCode = httpURLConnection.getResponseCode();

		InputStream inputStream;

		if (responseCode >= HttpURLConnection.HTTP_BAD_REQUEST) {
			inputStream = httpURLConnection.getErrorStream();
		}
		else {
			inputStream = httpURLConnection.getInputStream();
		}

		String response = _getResponse(inputStream);

		_logResponse(responseCode, response, httpURLConnection);

		httpURLConnection.disconnect();

		return response;
	}

	protected DefaultApi getClient(String basePath) {
		ApiClient apiClient = new ApiClient();

		apiClient.setBasePath(basePath);

		return new DefaultApi(apiClient);
	}

	protected abstract MuleSoftConfigurator getMuleSoftConfigurator();

	protected static final String REQUESTED_DATETIME_HEADER = "requestedDateTime";

	protected static final String TYPE = "type";

	protected static final String UUID = "uuid";

	protected static final String X_CORRELATION_ID_HEADER = "X-Correlation-ID";

	private HttpURLConnection _getHttpURLConnection(String httpMethod, URL url, JSONObject bodyJSONObject)
		throws IOException {

		HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();

		httpURLConnection.setRequestMethod(httpMethod);

		MuleSoftConfigurator muleSoftConfigurator = getMuleSoftConfigurator();

		httpURLConnection.setReadTimeout(muleSoftConfigurator.getTimeout());

		_setHeaders(httpURLConnection, httpMethod, muleSoftConfigurator);

		if (httpMethod.equalsIgnoreCase(HttpMethods.POST)) {
			httpURLConnection.setDoOutput(true);

			_logDebug("Body: " + bodyJSONObject.toString());

			try (OutputStreamWriter outputStreamWriter = new OutputStreamWriter(httpURLConnection.getOutputStream())) {
				outputStreamWriter.write(bodyJSONObject.toString());

				outputStreamWriter.flush();
			}
		}

		return httpURLConnection;
	}

	private String _getResponse(InputStream inputStream) throws IOException {
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

		StringBundler responseSB = new StringBundler();

		String line;

		while ((line = bufferedReader.readLine()) != null) {
			responseSB.append(line);
		}

		String response = responseSB.toString();

		return response.trim();
	}

	private void _logDebug(String message) {
		if (_log.isDebugEnabled()) {
			_log.debug(message);
		}
	}

	private void _logResponse(int responseCode, String responseBody, HttpURLConnection httpURLConnection)
		throws IOException {

		if (_log.isDebugEnabled()) {
			StringBundler sb = new StringBundler(5);

			sb.append("Response code: [");
			sb.append(responseCode);
			sb.append("] Response: [");
			sb.append(httpURLConnection.getResponseMessage());
			sb.append("] Response Body: [");
			sb.append(responseBody);
			sb.append("]");

			_log.debug(sb.toString());
		}
	}

	private void _setHeaders(
		HttpURLConnection httpURLConnection, String httpMethod, MuleSoftConfigurator muleSoftConfigurator) {

		httpURLConnection.setRequestProperty(_CLIENT_ID_HEADER, muleSoftConfigurator.getClientId());
		httpURLConnection.setRequestProperty(_CLIENT_SECRET_HEADER, muleSoftConfigurator.getClientSecret());
		httpURLConnection.setRequestProperty(_X_FORWARDED_FOR_HEADER, muleSoftConfigurator.getForwardedForHeader());

		if (httpMethod.equalsIgnoreCase(HttpMethods.POST)) {
			httpURLConnection.setRequestProperty(_CONTENT_TYPE_HEADER, _JSON_CONTENT_TYPE);
		}

		for (Map.Entry<String, String> header : _headers.entrySet()) {
			httpURLConnection.setRequestProperty(header.getKey(), header.getValue());
		}
	}

	private static final String _CLIENT_ID_HEADER = "client_id";

	private static final String _CLIENT_SECRET_HEADER = "client_secret";

	private static final String _CONTENT_TYPE_HEADER = "Content-Type";

	private static final String _JSON_CONTENT_TYPE = "application/json";

	private static final String _X_FORWARDED_FOR_HEADER = "X-Forwarded-For";

	private static final Log _log = LogFactoryUtil.getLog(BaseMuleSoftIntegrationImpl.class);

	private Map<String, String> _headers = new HashMap<>();

}