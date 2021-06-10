package com.argus.oth.cases.management.webhook.rs.client.serdes.v1_0;

import com.argus.oth.cases.management.webhook.rs.client.dto.v1_0.ProcessEvent;
import com.argus.oth.cases.management.webhook.rs.client.json.BaseJSONParser;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.annotation.Generated;

/**
 * @author Davy
 * @generated
 */
@Generated("")
public class ProcessEventSerDes {

	public static ProcessEvent toDTO(String json) {
		ProcessEventJSONParser processEventJSONParser =
			new ProcessEventJSONParser();

		return processEventJSONParser.parseToDTO(json);
	}

	public static ProcessEvent[] toDTOs(String json) {
		ProcessEventJSONParser processEventJSONParser =
			new ProcessEventJSONParser();

		return processEventJSONParser.parseToDTOs(json);
	}

	public static String toJSON(ProcessEvent processEvent) {
		if (processEvent == null) {
			return "null";
		}

		StringBuilder sb = new StringBuilder();

		sb.append("{");

		if (processEvent.getPrimaryKey() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"primaryKey\": ");

			sb.append(processEvent.getPrimaryKey());
		}

		if (processEvent.getStatusCode() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"statusCode\": ");

			sb.append(processEvent.getStatusCode());
		}

		if (processEvent.getStatusDescription() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"statusDescription\": ");

			sb.append("\"");

			sb.append(_escape(processEvent.getStatusDescription()));

			sb.append("\"");
		}

		if (processEvent.getType() != null) {
			if (sb.length() > 1) {
				sb.append(", ");
			}

			sb.append("\"type\": ");

			sb.append("\"");

			sb.append(_escape(processEvent.getType()));

			sb.append("\"");
		}

		sb.append("}");

		return sb.toString();
	}

	public static Map<String, Object> toMap(String json) {
		ProcessEventJSONParser processEventJSONParser =
			new ProcessEventJSONParser();

		return processEventJSONParser.parseToMap(json);
	}

	public static Map<String, String> toMap(ProcessEvent processEvent) {
		if (processEvent == null) {
			return null;
		}

		Map<String, String> map = new HashMap<>();

		if (processEvent.getPrimaryKey() == null) {
			map.put("primaryKey", null);
		}
		else {
			map.put("primaryKey", String.valueOf(processEvent.getPrimaryKey()));
		}

		if (processEvent.getStatusCode() == null) {
			map.put("statusCode", null);
		}
		else {
			map.put("statusCode", String.valueOf(processEvent.getStatusCode()));
		}

		if (processEvent.getStatusDescription() == null) {
			map.put("statusDescription", null);
		}
		else {
			map.put(
				"statusDescription",
				String.valueOf(processEvent.getStatusDescription()));
		}

		if (processEvent.getType() == null) {
			map.put("type", null);
		}
		else {
			map.put("type", String.valueOf(processEvent.getType()));
		}

		return map;
	}

	private static String _escape(Object object) {
		String string = String.valueOf(object);

		return string.replaceAll("\"", "\\\\\"");
	}

	private static String _toJSON(Map<String, ?> map) {
		StringBuilder sb = new StringBuilder("{");

		@SuppressWarnings("unchecked")
		Set set = map.entrySet();

		@SuppressWarnings("unchecked")
		Iterator<Map.Entry<String, ?>> iterator = set.iterator();

		while (iterator.hasNext()) {
			Map.Entry<String, ?> entry = iterator.next();

			sb.append("\"");
			sb.append(entry.getKey());
			sb.append("\":");
			sb.append("\"");
			sb.append(entry.getValue());
			sb.append("\"");

			if (iterator.hasNext()) {
				sb.append(",");
			}
		}

		sb.append("}");

		return sb.toString();
	}

	private static class ProcessEventJSONParser
		extends BaseJSONParser<ProcessEvent> {

		@Override
		protected ProcessEvent createDTO() {
			return new ProcessEvent();
		}

		@Override
		protected ProcessEvent[] createDTOArray(int size) {
			return new ProcessEvent[size];
		}

		@Override
		protected void setField(
			ProcessEvent processEvent, String jsonParserFieldName,
			Object jsonParserFieldValue) {

			if (Objects.equals(jsonParserFieldName, "primaryKey")) {
				if (jsonParserFieldValue != null) {
					processEvent.setPrimaryKey(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "statusCode")) {
				if (jsonParserFieldValue != null) {
					processEvent.setStatusCode(
						Long.valueOf((String)jsonParserFieldValue));
				}
			}
			else if (Objects.equals(jsonParserFieldName, "statusDescription")) {
				if (jsonParserFieldValue != null) {
					processEvent.setStatusDescription(
						(String)jsonParserFieldValue);
				}
			}
			else if (Objects.equals(jsonParserFieldName, "type")) {
				if (jsonParserFieldValue != null) {
					processEvent.setType((String)jsonParserFieldValue);
				}
			}
			else {
				throw new IllegalArgumentException(
					"Unsupported field name " + jsonParserFieldName);
			}
		}

	}

}