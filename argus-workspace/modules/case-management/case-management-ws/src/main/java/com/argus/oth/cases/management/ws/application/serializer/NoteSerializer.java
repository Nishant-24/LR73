package com.argus.oth.cases.management.ws.application.serializer;

import com.argus.oth.cases.management.model.Note;
import com.argus.oth.common.DateFormatter;
import com.argus.oth.common.ws.base.BaseSerializer;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactory;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.UserLocalService;

import java.util.List;
import java.util.Objects;
import java.util.TimeZone;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Davy Duran
 */
@Component(immediate = true, service = NoteSerializer.class)
public class NoteSerializer extends BaseSerializer {

	public String getEmailAddress(long userId) {
		User user = _fetchUser(userId);

		if (Objects.isNull(user)) {
			return StringPool.BLANK;
		}

		return user.getEmailAddress();
	}

	public String getFirstName(long userId) {
		User user = _fetchUser(userId);

		if (Objects.isNull(user)) {
			return StringPool.BLANK;
		}

		return user.getFirstName();
	}

	public String getLastName(long userId) {
		User user = _fetchUser(userId);

		if (Objects.isNull(user)) {
			return StringPool.BLANK;
		}

		return user.getLastName();
	}

	public JSONArray serialize(List<Note> notes, TimeZone timeZone) {
		JSONArray result = _jsonFactory.createJSONArray();

		for (Note note : notes) {
			JSONObject obj = serialize(note, timeZone);

			result.put(obj);
		}

		return result;
	}

	public JSONObject serialize(Note note, TimeZone timeZone) {
		JSONObject jsonObject = _jsonFactory.createJSONObject();

		jsonObject.put("callee", note.getCallee());
		jsonObject.put("caller", note.getCaller());
		jsonObject.put("caseId", note.getCaseId());
		jsonObject.put("code", note.getCode());
		jsonObject.put("direction", note.getDirection());
		jsonObject.put("emailAddress", getEmailAddress(note.getUserId()));
		jsonObject.put("externalNoteId", note.getExternalNoteId());
		jsonObject.put("firstName", getFirstName(note.getUserId()));
		jsonObject.put("groupId", note.getGroupId());
		jsonObject.put("lastName", getLastName(note.getUserId()));
		jsonObject.put("noteAuthor", note.getNoteAuthor());
		jsonObject.put(
			"noteCreateDate",
			_dateFormatter.getISODateString(_dateFormatter.convertToTimeZone(note.getNoteCreateDate(), timeZone)));
		jsonObject.put("noteCreateDateTimeZone", _dateFormatter.getTimeZoneDisplay(note.getNoteCreateDate(), timeZone));
		jsonObject.put("noteId", note.getNoteId());
		jsonObject.put("noteType", note.getNoteType());
		jsonObject.put("text", note.getText());
		jsonObject.put("type", note.getType());
		jsonObject.put("userId", note.getUserId());

		return jsonObject;
	}

	private User _fetchUser(long userId) {
		if (userId == 0) {
			return null;
		}

		return _userLocalService.fetchUser(userId);
	}

	@Reference
	private DateFormatter _dateFormatter;

	@Reference
	private JSONFactory _jsonFactory;

	@Reference
	private UserLocalService _userLocalService;

}