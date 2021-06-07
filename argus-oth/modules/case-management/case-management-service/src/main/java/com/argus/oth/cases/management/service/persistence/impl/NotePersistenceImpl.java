/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.argus.oth.cases.management.service.persistence.impl;

import com.argus.oth.cases.management.exception.NoSuchNoteException;
import com.argus.oth.cases.management.model.Note;
import com.argus.oth.cases.management.model.impl.NoteImpl;
import com.argus.oth.cases.management.model.impl.NoteModelImpl;
import com.argus.oth.cases.management.service.persistence.NotePersistence;
import com.argus.oth.cases.management.service.persistence.impl.constants.OTHPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.security.auth.CompanyThreadLocal;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the note service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = NotePersistence.class)
public class NotePersistenceImpl
	extends BasePersistenceImpl<Note> implements NotePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>NoteUtil</code> to access the note persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		NoteImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByUuid;
	private FinderPath _finderPathWithoutPaginationFindByUuid;
	private FinderPath _finderPathCountByUuid;

	/**
	 * Returns all the notes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching notes
	 */
	@Override
	public List<Note> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the notes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @return the range of matching notes
	 */
	@Override
	public List<Note> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
	}

	/**
	 * Returns an ordered range of all the notes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching notes
	 */
	@Override
	public List<Note> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Note> orderByComparator) {

		return findByUuid(uuid, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the notes where uuid = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching notes
	 */
	@Override
	public List<Note> findByUuid(
		String uuid, int start, int end,
		OrderByComparator<Note> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid;
				finderArgs = new Object[] {uuid};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid;
			finderArgs = new Object[] {uuid, start, end, orderByComparator};
		}

		List<Note> list = null;

		if (useFinderCache) {
			list = (List<Note>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Note note : list) {
					if (!uuid.equals(note.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_NOTE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(NoteModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				list = (List<Note>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first note in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching note
	 * @throws NoSuchNoteException if a matching note could not be found
	 */
	@Override
	public Note findByUuid_First(
			String uuid, OrderByComparator<Note> orderByComparator)
		throws NoSuchNoteException {

		Note note = fetchByUuid_First(uuid, orderByComparator);

		if (note != null) {
			return note;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchNoteException(sb.toString());
	}

	/**
	 * Returns the first note in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching note, or <code>null</code> if a matching note could not be found
	 */
	@Override
	public Note fetchByUuid_First(
		String uuid, OrderByComparator<Note> orderByComparator) {

		List<Note> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last note in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching note
	 * @throws NoSuchNoteException if a matching note could not be found
	 */
	@Override
	public Note findByUuid_Last(
			String uuid, OrderByComparator<Note> orderByComparator)
		throws NoSuchNoteException {

		Note note = fetchByUuid_Last(uuid, orderByComparator);

		if (note != null) {
			return note;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append("}");

		throw new NoSuchNoteException(sb.toString());
	}

	/**
	 * Returns the last note in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching note, or <code>null</code> if a matching note could not be found
	 */
	@Override
	public Note fetchByUuid_Last(
		String uuid, OrderByComparator<Note> orderByComparator) {

		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<Note> list = findByUuid(uuid, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the notes before and after the current note in the ordered set where uuid = &#63;.
	 *
	 * @param noteId the primary key of the current note
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next note
	 * @throws NoSuchNoteException if a note with the primary key could not be found
	 */
	@Override
	public Note[] findByUuid_PrevAndNext(
			long noteId, String uuid, OrderByComparator<Note> orderByComparator)
		throws NoSuchNoteException {

		uuid = Objects.toString(uuid, "");

		Note note = findByPrimaryKey(noteId);

		Session session = null;

		try {
			session = openSession();

			Note[] array = new NoteImpl[3];

			array[0] = getByUuid_PrevAndNext(
				session, note, uuid, orderByComparator, true);

			array[1] = note;

			array[2] = getByUuid_PrevAndNext(
				session, note, uuid, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Note getByUuid_PrevAndNext(
		Session session, Note note, String uuid,
		OrderByComparator<Note> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_NOTE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(NoteModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(note)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Note> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the notes where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (Note note :
				findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(note);
		}
	}

	/**
	 * Returns the number of notes where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching notes
	 */
	@Override
	public int countByUuid(String uuid) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid;

		Object[] finderArgs = new Object[] {uuid};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_NOTE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_2 = "note.uuid = ?";

	private static final String _FINDER_COLUMN_UUID_UUID_3 =
		"(note.uuid IS NULL OR note.uuid = '')";

	private FinderPath _finderPathFetchByUUID_G;
	private FinderPath _finderPathCountByUUID_G;

	/**
	 * Returns the note where uuid = &#63; and groupId = &#63; or throws a <code>NoSuchNoteException</code> if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching note
	 * @throws NoSuchNoteException if a matching note could not be found
	 */
	@Override
	public Note findByUUID_G(String uuid, long groupId)
		throws NoSuchNoteException {

		Note note = fetchByUUID_G(uuid, groupId);

		if (note == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("uuid=");
			sb.append(uuid);

			sb.append(", groupId=");
			sb.append(groupId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchNoteException(sb.toString());
		}

		return note;
	}

	/**
	 * Returns the note where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching note, or <code>null</code> if a matching note could not be found
	 */
	@Override
	public Note fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the note where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching note, or <code>null</code> if a matching note could not be found
	 */
	@Override
	public Note fetchByUUID_G(
		String uuid, long groupId, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {uuid, groupId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByUUID_G, finderArgs, this);
		}

		if (result instanceof Note) {
			Note note = (Note)result;

			if (!Objects.equals(uuid, note.getUuid()) ||
				(groupId != note.getGroupId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_NOTE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				List<Note> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByUUID_G, finderArgs, list);
					}
				}
				else {
					Note note = list.get(0);

					result = note;

					cacheResult(note);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByUUID_G, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Note)result;
		}
	}

	/**
	 * Removes the note where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the note that was removed
	 */
	@Override
	public Note removeByUUID_G(String uuid, long groupId)
		throws NoSuchNoteException {

		Note note = findByUUID_G(uuid, groupId);

		return remove(note);
	}

	/**
	 * Returns the number of notes where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching notes
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUUID_G;

		Object[] finderArgs = new Object[] {uuid, groupId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_NOTE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(groupId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_2 =
		"note.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_G_UUID_3 =
		"(note.uuid IS NULL OR note.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 =
		"note.groupId = ?";

	private FinderPath _finderPathWithPaginationFindByUuid_C;
	private FinderPath _finderPathWithoutPaginationFindByUuid_C;
	private FinderPath _finderPathCountByUuid_C;

	/**
	 * Returns all the notes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching notes
	 */
	@Override
	public List<Note> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(
			uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the notes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @return the range of matching notes
	 */
	@Override
	public List<Note> findByUuid_C(
		String uuid, long companyId, int start, int end) {

		return findByUuid_C(uuid, companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the notes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching notes
	 */
	@Override
	public List<Note> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Note> orderByComparator) {

		return findByUuid_C(
			uuid, companyId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the notes where uuid = &#63; and companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching notes
	 */
	@Override
	public List<Note> findByUuid_C(
		String uuid, long companyId, int start, int end,
		OrderByComparator<Note> orderByComparator, boolean useFinderCache) {

		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByUuid_C;
				finderArgs = new Object[] {uuid, companyId};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByUuid_C;
			finderArgs = new Object[] {
				uuid, companyId, start, end, orderByComparator
			};
		}

		List<Note> list = null;

		if (useFinderCache) {
			list = (List<Note>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Note note : list) {
					if (!uuid.equals(note.getUuid()) ||
						(companyId != note.getCompanyId())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_NOTE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(NoteModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				list = (List<Note>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first note in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching note
	 * @throws NoSuchNoteException if a matching note could not be found
	 */
	@Override
	public Note findByUuid_C_First(
			String uuid, long companyId,
			OrderByComparator<Note> orderByComparator)
		throws NoSuchNoteException {

		Note note = fetchByUuid_C_First(uuid, companyId, orderByComparator);

		if (note != null) {
			return note;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchNoteException(sb.toString());
	}

	/**
	 * Returns the first note in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching note, or <code>null</code> if a matching note could not be found
	 */
	@Override
	public Note fetchByUuid_C_First(
		String uuid, long companyId,
		OrderByComparator<Note> orderByComparator) {

		List<Note> list = findByUuid_C(
			uuid, companyId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last note in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching note
	 * @throws NoSuchNoteException if a matching note could not be found
	 */
	@Override
	public Note findByUuid_C_Last(
			String uuid, long companyId,
			OrderByComparator<Note> orderByComparator)
		throws NoSuchNoteException {

		Note note = fetchByUuid_C_Last(uuid, companyId, orderByComparator);

		if (note != null) {
			return note;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("uuid=");
		sb.append(uuid);

		sb.append(", companyId=");
		sb.append(companyId);

		sb.append("}");

		throw new NoSuchNoteException(sb.toString());
	}

	/**
	 * Returns the last note in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching note, or <code>null</code> if a matching note could not be found
	 */
	@Override
	public Note fetchByUuid_C_Last(
		String uuid, long companyId,
		OrderByComparator<Note> orderByComparator) {

		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<Note> list = findByUuid_C(
			uuid, companyId, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the notes before and after the current note in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param noteId the primary key of the current note
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next note
	 * @throws NoSuchNoteException if a note with the primary key could not be found
	 */
	@Override
	public Note[] findByUuid_C_PrevAndNext(
			long noteId, String uuid, long companyId,
			OrderByComparator<Note> orderByComparator)
		throws NoSuchNoteException {

		uuid = Objects.toString(uuid, "");

		Note note = findByPrimaryKey(noteId);

		Session session = null;

		try {
			session = openSession();

			Note[] array = new NoteImpl[3];

			array[0] = getByUuid_C_PrevAndNext(
				session, note, uuid, companyId, orderByComparator, true);

			array[1] = note;

			array[2] = getByUuid_C_PrevAndNext(
				session, note, uuid, companyId, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Note getByUuid_C_PrevAndNext(
		Session session, Note note, String uuid, long companyId,
		OrderByComparator<Note> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_NOTE_WHERE);

		boolean bindUuid = false;

		if (uuid.isEmpty()) {
			sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(NoteModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindUuid) {
			queryPos.add(uuid);
		}

		queryPos.add(companyId);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(note)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Note> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the notes where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (Note note :
				findByUuid_C(
					uuid, companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(note);
		}
	}

	/**
	 * Returns the number of notes where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching notes
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		uuid = Objects.toString(uuid, "");

		FinderPath finderPath = _finderPathCountByUuid_C;

		Object[] finderArgs = new Object[] {uuid, companyId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_NOTE_WHERE);

			boolean bindUuid = false;

			if (uuid.isEmpty()) {
				sb.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				sb.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			sb.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindUuid) {
					queryPos.add(uuid);
				}

				queryPos.add(companyId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_2 =
		"note.uuid = ? AND ";

	private static final String _FINDER_COLUMN_UUID_C_UUID_3 =
		"(note.uuid IS NULL OR note.uuid = '') AND ";

	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 =
		"note.companyId = ?";

	private FinderPath _finderPathWithPaginationFindByC_NotP;
	private FinderPath _finderPathWithPaginationCountByC_NotP;

	/**
	 * Returns all the notes where caseId = &#63; and processStatus &ne; &#63;.
	 *
	 * @param caseId the case ID
	 * @param processStatus the process status
	 * @return the matching notes
	 */
	@Override
	public List<Note> findByC_NotP(long caseId, String processStatus) {
		return findByC_NotP(
			caseId, processStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the notes where caseId = &#63; and processStatus &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param caseId the case ID
	 * @param processStatus the process status
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @return the range of matching notes
	 */
	@Override
	public List<Note> findByC_NotP(
		long caseId, String processStatus, int start, int end) {

		return findByC_NotP(caseId, processStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the notes where caseId = &#63; and processStatus &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param caseId the case ID
	 * @param processStatus the process status
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching notes
	 */
	@Override
	public List<Note> findByC_NotP(
		long caseId, String processStatus, int start, int end,
		OrderByComparator<Note> orderByComparator) {

		return findByC_NotP(
			caseId, processStatus, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the notes where caseId = &#63; and processStatus &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param caseId the case ID
	 * @param processStatus the process status
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching notes
	 */
	@Override
	public List<Note> findByC_NotP(
		long caseId, String processStatus, int start, int end,
		OrderByComparator<Note> orderByComparator, boolean useFinderCache) {

		processStatus = Objects.toString(processStatus, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByC_NotP;
		finderArgs = new Object[] {
			caseId, processStatus, start, end, orderByComparator
		};

		List<Note> list = null;

		if (useFinderCache) {
			list = (List<Note>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Note note : list) {
					if ((caseId != note.getCaseId()) ||
						processStatus.equals(note.getProcessStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_NOTE_WHERE);

			sb.append(_FINDER_COLUMN_C_NOTP_CASEID_2);

			boolean bindProcessStatus = false;

			if (processStatus.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_NOTP_PROCESSSTATUS_3);
			}
			else {
				bindProcessStatus = true;

				sb.append(_FINDER_COLUMN_C_NOTP_PROCESSSTATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(NoteModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(caseId);

				if (bindProcessStatus) {
					queryPos.add(processStatus);
				}

				list = (List<Note>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first note in the ordered set where caseId = &#63; and processStatus &ne; &#63;.
	 *
	 * @param caseId the case ID
	 * @param processStatus the process status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching note
	 * @throws NoSuchNoteException if a matching note could not be found
	 */
	@Override
	public Note findByC_NotP_First(
			long caseId, String processStatus,
			OrderByComparator<Note> orderByComparator)
		throws NoSuchNoteException {

		Note note = fetchByC_NotP_First(
			caseId, processStatus, orderByComparator);

		if (note != null) {
			return note;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("caseId=");
		sb.append(caseId);

		sb.append(", processStatus!=");
		sb.append(processStatus);

		sb.append("}");

		throw new NoSuchNoteException(sb.toString());
	}

	/**
	 * Returns the first note in the ordered set where caseId = &#63; and processStatus &ne; &#63;.
	 *
	 * @param caseId the case ID
	 * @param processStatus the process status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching note, or <code>null</code> if a matching note could not be found
	 */
	@Override
	public Note fetchByC_NotP_First(
		long caseId, String processStatus,
		OrderByComparator<Note> orderByComparator) {

		List<Note> list = findByC_NotP(
			caseId, processStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last note in the ordered set where caseId = &#63; and processStatus &ne; &#63;.
	 *
	 * @param caseId the case ID
	 * @param processStatus the process status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching note
	 * @throws NoSuchNoteException if a matching note could not be found
	 */
	@Override
	public Note findByC_NotP_Last(
			long caseId, String processStatus,
			OrderByComparator<Note> orderByComparator)
		throws NoSuchNoteException {

		Note note = fetchByC_NotP_Last(
			caseId, processStatus, orderByComparator);

		if (note != null) {
			return note;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("caseId=");
		sb.append(caseId);

		sb.append(", processStatus!=");
		sb.append(processStatus);

		sb.append("}");

		throw new NoSuchNoteException(sb.toString());
	}

	/**
	 * Returns the last note in the ordered set where caseId = &#63; and processStatus &ne; &#63;.
	 *
	 * @param caseId the case ID
	 * @param processStatus the process status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching note, or <code>null</code> if a matching note could not be found
	 */
	@Override
	public Note fetchByC_NotP_Last(
		long caseId, String processStatus,
		OrderByComparator<Note> orderByComparator) {

		int count = countByC_NotP(caseId, processStatus);

		if (count == 0) {
			return null;
		}

		List<Note> list = findByC_NotP(
			caseId, processStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the notes before and after the current note in the ordered set where caseId = &#63; and processStatus &ne; &#63;.
	 *
	 * @param noteId the primary key of the current note
	 * @param caseId the case ID
	 * @param processStatus the process status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next note
	 * @throws NoSuchNoteException if a note with the primary key could not be found
	 */
	@Override
	public Note[] findByC_NotP_PrevAndNext(
			long noteId, long caseId, String processStatus,
			OrderByComparator<Note> orderByComparator)
		throws NoSuchNoteException {

		processStatus = Objects.toString(processStatus, "");

		Note note = findByPrimaryKey(noteId);

		Session session = null;

		try {
			session = openSession();

			Note[] array = new NoteImpl[3];

			array[0] = getByC_NotP_PrevAndNext(
				session, note, caseId, processStatus, orderByComparator, true);

			array[1] = note;

			array[2] = getByC_NotP_PrevAndNext(
				session, note, caseId, processStatus, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Note getByC_NotP_PrevAndNext(
		Session session, Note note, long caseId, String processStatus,
		OrderByComparator<Note> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_NOTE_WHERE);

		sb.append(_FINDER_COLUMN_C_NOTP_CASEID_2);

		boolean bindProcessStatus = false;

		if (processStatus.isEmpty()) {
			sb.append(_FINDER_COLUMN_C_NOTP_PROCESSSTATUS_3);
		}
		else {
			bindProcessStatus = true;

			sb.append(_FINDER_COLUMN_C_NOTP_PROCESSSTATUS_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(NoteModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(caseId);

		if (bindProcessStatus) {
			queryPos.add(processStatus);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(note)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Note> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the notes where caseId = &#63; and processStatus &ne; &#63; from the database.
	 *
	 * @param caseId the case ID
	 * @param processStatus the process status
	 */
	@Override
	public void removeByC_NotP(long caseId, String processStatus) {
		for (Note note :
				findByC_NotP(
					caseId, processStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(note);
		}
	}

	/**
	 * Returns the number of notes where caseId = &#63; and processStatus &ne; &#63;.
	 *
	 * @param caseId the case ID
	 * @param processStatus the process status
	 * @return the number of matching notes
	 */
	@Override
	public int countByC_NotP(long caseId, String processStatus) {
		processStatus = Objects.toString(processStatus, "");

		FinderPath finderPath = _finderPathWithPaginationCountByC_NotP;

		Object[] finderArgs = new Object[] {caseId, processStatus};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_NOTE_WHERE);

			sb.append(_FINDER_COLUMN_C_NOTP_CASEID_2);

			boolean bindProcessStatus = false;

			if (processStatus.isEmpty()) {
				sb.append(_FINDER_COLUMN_C_NOTP_PROCESSSTATUS_3);
			}
			else {
				bindProcessStatus = true;

				sb.append(_FINDER_COLUMN_C_NOTP_PROCESSSTATUS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(caseId);

				if (bindProcessStatus) {
					queryPos.add(processStatus);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_C_NOTP_CASEID_2 =
		"note.caseId = ? AND ";

	private static final String _FINDER_COLUMN_C_NOTP_PROCESSSTATUS_2 =
		"note.processStatus != ?";

	private static final String _FINDER_COLUMN_C_NOTP_PROCESSSTATUS_3 =
		"(note.processStatus IS NULL OR note.processStatus != '')";

	private FinderPath _finderPathFetchByExternalNoteId;
	private FinderPath _finderPathCountByExternalNoteId;

	/**
	 * Returns the note where externalNoteId = &#63; or throws a <code>NoSuchNoteException</code> if it could not be found.
	 *
	 * @param externalNoteId the external note ID
	 * @return the matching note
	 * @throws NoSuchNoteException if a matching note could not be found
	 */
	@Override
	public Note findByExternalNoteId(long externalNoteId)
		throws NoSuchNoteException {

		Note note = fetchByExternalNoteId(externalNoteId);

		if (note == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("externalNoteId=");
			sb.append(externalNoteId);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchNoteException(sb.toString());
		}

		return note;
	}

	/**
	 * Returns the note where externalNoteId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param externalNoteId the external note ID
	 * @return the matching note, or <code>null</code> if a matching note could not be found
	 */
	@Override
	public Note fetchByExternalNoteId(long externalNoteId) {
		return fetchByExternalNoteId(externalNoteId, true);
	}

	/**
	 * Returns the note where externalNoteId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param externalNoteId the external note ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching note, or <code>null</code> if a matching note could not be found
	 */
	@Override
	public Note fetchByExternalNoteId(
		long externalNoteId, boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {externalNoteId};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByExternalNoteId, finderArgs, this);
		}

		if (result instanceof Note) {
			Note note = (Note)result;

			if (externalNoteId != note.getExternalNoteId()) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_NOTE_WHERE);

			sb.append(_FINDER_COLUMN_EXTERNALNOTEID_EXTERNALNOTEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(externalNoteId);

				List<Note> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByExternalNoteId, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {externalNoteId};
							}

							_log.warn(
								"NotePersistenceImpl.fetchByExternalNoteId(long, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Note note = list.get(0);

					result = note;

					cacheResult(note);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(
						_finderPathFetchByExternalNoteId, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Note)result;
		}
	}

	/**
	 * Removes the note where externalNoteId = &#63; from the database.
	 *
	 * @param externalNoteId the external note ID
	 * @return the note that was removed
	 */
	@Override
	public Note removeByExternalNoteId(long externalNoteId)
		throws NoSuchNoteException {

		Note note = findByExternalNoteId(externalNoteId);

		return remove(note);
	}

	/**
	 * Returns the number of notes where externalNoteId = &#63;.
	 *
	 * @param externalNoteId the external note ID
	 * @return the number of matching notes
	 */
	@Override
	public int countByExternalNoteId(long externalNoteId) {
		FinderPath finderPath = _finderPathCountByExternalNoteId;

		Object[] finderArgs = new Object[] {externalNoteId};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_NOTE_WHERE);

			sb.append(_FINDER_COLUMN_EXTERNALNOTEID_EXTERNALNOTEID_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(externalNoteId);

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_EXTERNALNOTEID_EXTERNALNOTEID_2 =
		"note.externalNoteId = ?";

	private FinderPath _finderPathWithPaginationFindByE_P;
	private FinderPath _finderPathWithoutPaginationFindByE_P;
	private FinderPath _finderPathCountByE_P;

	/**
	 * Returns all the notes where externalNoteId = &#63; and processStatus = &#63;.
	 *
	 * @param externalNoteId the external note ID
	 * @param processStatus the process status
	 * @return the matching notes
	 */
	@Override
	public List<Note> findByE_P(long externalNoteId, String processStatus) {
		return findByE_P(
			externalNoteId, processStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the notes where externalNoteId = &#63; and processStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param externalNoteId the external note ID
	 * @param processStatus the process status
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @return the range of matching notes
	 */
	@Override
	public List<Note> findByE_P(
		long externalNoteId, String processStatus, int start, int end) {

		return findByE_P(externalNoteId, processStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the notes where externalNoteId = &#63; and processStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param externalNoteId the external note ID
	 * @param processStatus the process status
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching notes
	 */
	@Override
	public List<Note> findByE_P(
		long externalNoteId, String processStatus, int start, int end,
		OrderByComparator<Note> orderByComparator) {

		return findByE_P(
			externalNoteId, processStatus, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the notes where externalNoteId = &#63; and processStatus = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param externalNoteId the external note ID
	 * @param processStatus the process status
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching notes
	 */
	@Override
	public List<Note> findByE_P(
		long externalNoteId, String processStatus, int start, int end,
		OrderByComparator<Note> orderByComparator, boolean useFinderCache) {

		processStatus = Objects.toString(processStatus, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByE_P;
				finderArgs = new Object[] {externalNoteId, processStatus};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByE_P;
			finderArgs = new Object[] {
				externalNoteId, processStatus, start, end, orderByComparator
			};
		}

		List<Note> list = null;

		if (useFinderCache) {
			list = (List<Note>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Note note : list) {
					if ((externalNoteId != note.getExternalNoteId()) ||
						!processStatus.equals(note.getProcessStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_NOTE_WHERE);

			sb.append(_FINDER_COLUMN_E_P_EXTERNALNOTEID_2);

			boolean bindProcessStatus = false;

			if (processStatus.isEmpty()) {
				sb.append(_FINDER_COLUMN_E_P_PROCESSSTATUS_3);
			}
			else {
				bindProcessStatus = true;

				sb.append(_FINDER_COLUMN_E_P_PROCESSSTATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(NoteModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(externalNoteId);

				if (bindProcessStatus) {
					queryPos.add(processStatus);
				}

				list = (List<Note>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first note in the ordered set where externalNoteId = &#63; and processStatus = &#63;.
	 *
	 * @param externalNoteId the external note ID
	 * @param processStatus the process status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching note
	 * @throws NoSuchNoteException if a matching note could not be found
	 */
	@Override
	public Note findByE_P_First(
			long externalNoteId, String processStatus,
			OrderByComparator<Note> orderByComparator)
		throws NoSuchNoteException {

		Note note = fetchByE_P_First(
			externalNoteId, processStatus, orderByComparator);

		if (note != null) {
			return note;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("externalNoteId=");
		sb.append(externalNoteId);

		sb.append(", processStatus=");
		sb.append(processStatus);

		sb.append("}");

		throw new NoSuchNoteException(sb.toString());
	}

	/**
	 * Returns the first note in the ordered set where externalNoteId = &#63; and processStatus = &#63;.
	 *
	 * @param externalNoteId the external note ID
	 * @param processStatus the process status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching note, or <code>null</code> if a matching note could not be found
	 */
	@Override
	public Note fetchByE_P_First(
		long externalNoteId, String processStatus,
		OrderByComparator<Note> orderByComparator) {

		List<Note> list = findByE_P(
			externalNoteId, processStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last note in the ordered set where externalNoteId = &#63; and processStatus = &#63;.
	 *
	 * @param externalNoteId the external note ID
	 * @param processStatus the process status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching note
	 * @throws NoSuchNoteException if a matching note could not be found
	 */
	@Override
	public Note findByE_P_Last(
			long externalNoteId, String processStatus,
			OrderByComparator<Note> orderByComparator)
		throws NoSuchNoteException {

		Note note = fetchByE_P_Last(
			externalNoteId, processStatus, orderByComparator);

		if (note != null) {
			return note;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("externalNoteId=");
		sb.append(externalNoteId);

		sb.append(", processStatus=");
		sb.append(processStatus);

		sb.append("}");

		throw new NoSuchNoteException(sb.toString());
	}

	/**
	 * Returns the last note in the ordered set where externalNoteId = &#63; and processStatus = &#63;.
	 *
	 * @param externalNoteId the external note ID
	 * @param processStatus the process status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching note, or <code>null</code> if a matching note could not be found
	 */
	@Override
	public Note fetchByE_P_Last(
		long externalNoteId, String processStatus,
		OrderByComparator<Note> orderByComparator) {

		int count = countByE_P(externalNoteId, processStatus);

		if (count == 0) {
			return null;
		}

		List<Note> list = findByE_P(
			externalNoteId, processStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the notes before and after the current note in the ordered set where externalNoteId = &#63; and processStatus = &#63;.
	 *
	 * @param noteId the primary key of the current note
	 * @param externalNoteId the external note ID
	 * @param processStatus the process status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next note
	 * @throws NoSuchNoteException if a note with the primary key could not be found
	 */
	@Override
	public Note[] findByE_P_PrevAndNext(
			long noteId, long externalNoteId, String processStatus,
			OrderByComparator<Note> orderByComparator)
		throws NoSuchNoteException {

		processStatus = Objects.toString(processStatus, "");

		Note note = findByPrimaryKey(noteId);

		Session session = null;

		try {
			session = openSession();

			Note[] array = new NoteImpl[3];

			array[0] = getByE_P_PrevAndNext(
				session, note, externalNoteId, processStatus, orderByComparator,
				true);

			array[1] = note;

			array[2] = getByE_P_PrevAndNext(
				session, note, externalNoteId, processStatus, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Note getByE_P_PrevAndNext(
		Session session, Note note, long externalNoteId, String processStatus,
		OrderByComparator<Note> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_NOTE_WHERE);

		sb.append(_FINDER_COLUMN_E_P_EXTERNALNOTEID_2);

		boolean bindProcessStatus = false;

		if (processStatus.isEmpty()) {
			sb.append(_FINDER_COLUMN_E_P_PROCESSSTATUS_3);
		}
		else {
			bindProcessStatus = true;

			sb.append(_FINDER_COLUMN_E_P_PROCESSSTATUS_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(NoteModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(externalNoteId);

		if (bindProcessStatus) {
			queryPos.add(processStatus);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(note)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Note> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the notes where externalNoteId = &#63; and processStatus = &#63; from the database.
	 *
	 * @param externalNoteId the external note ID
	 * @param processStatus the process status
	 */
	@Override
	public void removeByE_P(long externalNoteId, String processStatus) {
		for (Note note :
				findByE_P(
					externalNoteId, processStatus, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(note);
		}
	}

	/**
	 * Returns the number of notes where externalNoteId = &#63; and processStatus = &#63;.
	 *
	 * @param externalNoteId the external note ID
	 * @param processStatus the process status
	 * @return the number of matching notes
	 */
	@Override
	public int countByE_P(long externalNoteId, String processStatus) {
		processStatus = Objects.toString(processStatus, "");

		FinderPath finderPath = _finderPathCountByE_P;

		Object[] finderArgs = new Object[] {externalNoteId, processStatus};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_NOTE_WHERE);

			sb.append(_FINDER_COLUMN_E_P_EXTERNALNOTEID_2);

			boolean bindProcessStatus = false;

			if (processStatus.isEmpty()) {
				sb.append(_FINDER_COLUMN_E_P_PROCESSSTATUS_3);
			}
			else {
				bindProcessStatus = true;

				sb.append(_FINDER_COLUMN_E_P_PROCESSSTATUS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(externalNoteId);

				if (bindProcessStatus) {
					queryPos.add(processStatus);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_E_P_EXTERNALNOTEID_2 =
		"note.externalNoteId = ? AND ";

	private static final String _FINDER_COLUMN_E_P_PROCESSSTATUS_2 =
		"note.processStatus = ?";

	private static final String _FINDER_COLUMN_E_P_PROCESSSTATUS_3 =
		"(note.processStatus IS NULL OR note.processStatus = '')";

	private FinderPath
		_finderPathWithPaginationFindByRowProcessed_ProcessStatus;
	private FinderPath
		_finderPathWithPaginationCountByRowProcessed_ProcessStatus;

	/**
	 * Returns all the notes where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @return the matching notes
	 */
	@Override
	public List<Note> findByRowProcessed_ProcessStatus(
		String rowProcessed, String processStatus) {

		return findByRowProcessed_ProcessStatus(
			rowProcessed, processStatus, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the notes where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @return the range of matching notes
	 */
	@Override
	public List<Note> findByRowProcessed_ProcessStatus(
		String rowProcessed, String processStatus, int start, int end) {

		return findByRowProcessed_ProcessStatus(
			rowProcessed, processStatus, start, end, null);
	}

	/**
	 * Returns an ordered range of all the notes where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching notes
	 */
	@Override
	public List<Note> findByRowProcessed_ProcessStatus(
		String rowProcessed, String processStatus, int start, int end,
		OrderByComparator<Note> orderByComparator) {

		return findByRowProcessed_ProcessStatus(
			rowProcessed, processStatus, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the notes where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching notes
	 */
	@Override
	public List<Note> findByRowProcessed_ProcessStatus(
		String rowProcessed, String processStatus, int start, int end,
		OrderByComparator<Note> orderByComparator, boolean useFinderCache) {

		rowProcessed = Objects.toString(rowProcessed, "");
		processStatus = Objects.toString(processStatus, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = _finderPathWithPaginationFindByRowProcessed_ProcessStatus;
		finderArgs = new Object[] {
			rowProcessed, processStatus, start, end, orderByComparator
		};

		List<Note> list = null;

		if (useFinderCache) {
			list = (List<Note>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Note note : list) {
					if (rowProcessed.equals(note.getRowProcessed()) ||
						processStatus.equals(note.getProcessStatus())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_NOTE_WHERE);

			boolean bindRowProcessed = false;

			if (rowProcessed.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_ROWPROCESSED_PROCESSSTATUS_ROWPROCESSED_3);
			}
			else {
				bindRowProcessed = true;

				sb.append(
					_FINDER_COLUMN_ROWPROCESSED_PROCESSSTATUS_ROWPROCESSED_2);
			}

			boolean bindProcessStatus = false;

			if (processStatus.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_ROWPROCESSED_PROCESSSTATUS_PROCESSSTATUS_3);
			}
			else {
				bindProcessStatus = true;

				sb.append(
					_FINDER_COLUMN_ROWPROCESSED_PROCESSSTATUS_PROCESSSTATUS_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(NoteModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRowProcessed) {
					queryPos.add(rowProcessed);
				}

				if (bindProcessStatus) {
					queryPos.add(processStatus);
				}

				list = (List<Note>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first note in the ordered set where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching note
	 * @throws NoSuchNoteException if a matching note could not be found
	 */
	@Override
	public Note findByRowProcessed_ProcessStatus_First(
			String rowProcessed, String processStatus,
			OrderByComparator<Note> orderByComparator)
		throws NoSuchNoteException {

		Note note = fetchByRowProcessed_ProcessStatus_First(
			rowProcessed, processStatus, orderByComparator);

		if (note != null) {
			return note;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("rowProcessed!=");
		sb.append(rowProcessed);

		sb.append(", processStatus!=");
		sb.append(processStatus);

		sb.append("}");

		throw new NoSuchNoteException(sb.toString());
	}

	/**
	 * Returns the first note in the ordered set where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching note, or <code>null</code> if a matching note could not be found
	 */
	@Override
	public Note fetchByRowProcessed_ProcessStatus_First(
		String rowProcessed, String processStatus,
		OrderByComparator<Note> orderByComparator) {

		List<Note> list = findByRowProcessed_ProcessStatus(
			rowProcessed, processStatus, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last note in the ordered set where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching note
	 * @throws NoSuchNoteException if a matching note could not be found
	 */
	@Override
	public Note findByRowProcessed_ProcessStatus_Last(
			String rowProcessed, String processStatus,
			OrderByComparator<Note> orderByComparator)
		throws NoSuchNoteException {

		Note note = fetchByRowProcessed_ProcessStatus_Last(
			rowProcessed, processStatus, orderByComparator);

		if (note != null) {
			return note;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("rowProcessed!=");
		sb.append(rowProcessed);

		sb.append(", processStatus!=");
		sb.append(processStatus);

		sb.append("}");

		throw new NoSuchNoteException(sb.toString());
	}

	/**
	 * Returns the last note in the ordered set where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching note, or <code>null</code> if a matching note could not be found
	 */
	@Override
	public Note fetchByRowProcessed_ProcessStatus_Last(
		String rowProcessed, String processStatus,
		OrderByComparator<Note> orderByComparator) {

		int count = countByRowProcessed_ProcessStatus(
			rowProcessed, processStatus);

		if (count == 0) {
			return null;
		}

		List<Note> list = findByRowProcessed_ProcessStatus(
			rowProcessed, processStatus, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the notes before and after the current note in the ordered set where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * @param noteId the primary key of the current note
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next note
	 * @throws NoSuchNoteException if a note with the primary key could not be found
	 */
	@Override
	public Note[] findByRowProcessed_ProcessStatus_PrevAndNext(
			long noteId, String rowProcessed, String processStatus,
			OrderByComparator<Note> orderByComparator)
		throws NoSuchNoteException {

		rowProcessed = Objects.toString(rowProcessed, "");
		processStatus = Objects.toString(processStatus, "");

		Note note = findByPrimaryKey(noteId);

		Session session = null;

		try {
			session = openSession();

			Note[] array = new NoteImpl[3];

			array[0] = getByRowProcessed_ProcessStatus_PrevAndNext(
				session, note, rowProcessed, processStatus, orderByComparator,
				true);

			array[1] = note;

			array[2] = getByRowProcessed_ProcessStatus_PrevAndNext(
				session, note, rowProcessed, processStatus, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected Note getByRowProcessed_ProcessStatus_PrevAndNext(
		Session session, Note note, String rowProcessed, String processStatus,
		OrderByComparator<Note> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_NOTE_WHERE);

		boolean bindRowProcessed = false;

		if (rowProcessed.isEmpty()) {
			sb.append(_FINDER_COLUMN_ROWPROCESSED_PROCESSSTATUS_ROWPROCESSED_3);
		}
		else {
			bindRowProcessed = true;

			sb.append(_FINDER_COLUMN_ROWPROCESSED_PROCESSSTATUS_ROWPROCESSED_2);
		}

		boolean bindProcessStatus = false;

		if (processStatus.isEmpty()) {
			sb.append(
				_FINDER_COLUMN_ROWPROCESSED_PROCESSSTATUS_PROCESSSTATUS_3);
		}
		else {
			bindProcessStatus = true;

			sb.append(
				_FINDER_COLUMN_ROWPROCESSED_PROCESSSTATUS_PROCESSSTATUS_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(NoteModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindRowProcessed) {
			queryPos.add(rowProcessed);
		}

		if (bindProcessStatus) {
			queryPos.add(processStatus);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(note)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<Note> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the notes where rowProcessed &ne; &#63; and processStatus &ne; &#63; from the database.
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 */
	@Override
	public void removeByRowProcessed_ProcessStatus(
		String rowProcessed, String processStatus) {

		for (Note note :
				findByRowProcessed_ProcessStatus(
					rowProcessed, processStatus, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(note);
		}
	}

	/**
	 * Returns the number of notes where rowProcessed &ne; &#63; and processStatus &ne; &#63;.
	 *
	 * @param rowProcessed the row processed
	 * @param processStatus the process status
	 * @return the number of matching notes
	 */
	@Override
	public int countByRowProcessed_ProcessStatus(
		String rowProcessed, String processStatus) {

		rowProcessed = Objects.toString(rowProcessed, "");
		processStatus = Objects.toString(processStatus, "");

		FinderPath finderPath =
			_finderPathWithPaginationCountByRowProcessed_ProcessStatus;

		Object[] finderArgs = new Object[] {rowProcessed, processStatus};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_NOTE_WHERE);

			boolean bindRowProcessed = false;

			if (rowProcessed.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_ROWPROCESSED_PROCESSSTATUS_ROWPROCESSED_3);
			}
			else {
				bindRowProcessed = true;

				sb.append(
					_FINDER_COLUMN_ROWPROCESSED_PROCESSSTATUS_ROWPROCESSED_2);
			}

			boolean bindProcessStatus = false;

			if (processStatus.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_ROWPROCESSED_PROCESSSTATUS_PROCESSSTATUS_3);
			}
			else {
				bindProcessStatus = true;

				sb.append(
					_FINDER_COLUMN_ROWPROCESSED_PROCESSSTATUS_PROCESSSTATUS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindRowProcessed) {
					queryPos.add(rowProcessed);
				}

				if (bindProcessStatus) {
					queryPos.add(processStatus);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_ROWPROCESSED_PROCESSSTATUS_ROWPROCESSED_2 =
			"note.rowProcessed != ? AND ";

	private static final String
		_FINDER_COLUMN_ROWPROCESSED_PROCESSSTATUS_ROWPROCESSED_3 =
			"(note.rowProcessed IS NULL OR note.rowProcessed != '') AND ";

	private static final String
		_FINDER_COLUMN_ROWPROCESSED_PROCESSSTATUS_PROCESSSTATUS_2 =
			"note.processStatus != ?";

	private static final String
		_FINDER_COLUMN_ROWPROCESSED_PROCESSSTATUS_PROCESSSTATUS_3 =
			"(note.processStatus IS NULL OR note.processStatus != '')";

	public NotePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("uuid", "uuid_");
		dbColumnNames.put("type", "type_");
		dbColumnNames.put("text", "text_");
		dbColumnNames.put("code", "code_");

		setDBColumnNames(dbColumnNames);

		setModelClass(Note.class);

		setModelImplClass(NoteImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the note in the entity cache if it is enabled.
	 *
	 * @param note the note
	 */
	@Override
	public void cacheResult(Note note) {
		entityCache.putResult(
			entityCacheEnabled, NoteImpl.class, note.getPrimaryKey(), note);

		finderCache.putResult(
			_finderPathFetchByUUID_G,
			new Object[] {note.getUuid(), note.getGroupId()}, note);

		finderCache.putResult(
			_finderPathFetchByExternalNoteId,
			new Object[] {note.getExternalNoteId()}, note);

		note.resetOriginalValues();
	}

	/**
	 * Caches the notes in the entity cache if it is enabled.
	 *
	 * @param notes the notes
	 */
	@Override
	public void cacheResult(List<Note> notes) {
		for (Note note : notes) {
			if (entityCache.getResult(
					entityCacheEnabled, NoteImpl.class, note.getPrimaryKey()) ==
						null) {

				cacheResult(note);
			}
			else {
				note.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all notes.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(NoteImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the note.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Note note) {
		entityCache.removeResult(
			entityCacheEnabled, NoteImpl.class, note.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((NoteModelImpl)note, true);
	}

	@Override
	public void clearCache(List<Note> notes) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Note note : notes) {
			entityCache.removeResult(
				entityCacheEnabled, NoteImpl.class, note.getPrimaryKey());

			clearUniqueFindersCache((NoteModelImpl)note, true);
		}
	}

	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(
				entityCacheEnabled, NoteImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(NoteModelImpl noteModelImpl) {
		Object[] args = new Object[] {
			noteModelImpl.getUuid(), noteModelImpl.getGroupId()
		};

		finderCache.putResult(
			_finderPathCountByUUID_G, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByUUID_G, args, noteModelImpl, false);

		args = new Object[] {noteModelImpl.getExternalNoteId()};

		finderCache.putResult(
			_finderPathCountByExternalNoteId, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByExternalNoteId, args, noteModelImpl, false);
	}

	protected void clearUniqueFindersCache(
		NoteModelImpl noteModelImpl, boolean clearCurrent) {

		if (clearCurrent) {
			Object[] args = new Object[] {
				noteModelImpl.getUuid(), noteModelImpl.getGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if ((noteModelImpl.getColumnBitmask() &
			 _finderPathFetchByUUID_G.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				noteModelImpl.getOriginalUuid(),
				noteModelImpl.getOriginalGroupId()
			};

			finderCache.removeResult(_finderPathCountByUUID_G, args);
			finderCache.removeResult(_finderPathFetchByUUID_G, args);
		}

		if (clearCurrent) {
			Object[] args = new Object[] {noteModelImpl.getExternalNoteId()};

			finderCache.removeResult(_finderPathCountByExternalNoteId, args);
			finderCache.removeResult(_finderPathFetchByExternalNoteId, args);
		}

		if ((noteModelImpl.getColumnBitmask() &
			 _finderPathFetchByExternalNoteId.getColumnBitmask()) != 0) {

			Object[] args = new Object[] {
				noteModelImpl.getOriginalExternalNoteId()
			};

			finderCache.removeResult(_finderPathCountByExternalNoteId, args);
			finderCache.removeResult(_finderPathFetchByExternalNoteId, args);
		}
	}

	/**
	 * Creates a new note with the primary key. Does not add the note to the database.
	 *
	 * @param noteId the primary key for the new note
	 * @return the new note
	 */
	@Override
	public Note create(long noteId) {
		Note note = new NoteImpl();

		note.setNew(true);
		note.setPrimaryKey(noteId);

		String uuid = PortalUUIDUtil.generate();

		note.setUuid(uuid);

		note.setCompanyId(CompanyThreadLocal.getCompanyId());

		return note;
	}

	/**
	 * Removes the note with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param noteId the primary key of the note
	 * @return the note that was removed
	 * @throws NoSuchNoteException if a note with the primary key could not be found
	 */
	@Override
	public Note remove(long noteId) throws NoSuchNoteException {
		return remove((Serializable)noteId);
	}

	/**
	 * Removes the note with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the note
	 * @return the note that was removed
	 * @throws NoSuchNoteException if a note with the primary key could not be found
	 */
	@Override
	public Note remove(Serializable primaryKey) throws NoSuchNoteException {
		Session session = null;

		try {
			session = openSession();

			Note note = (Note)session.get(NoteImpl.class, primaryKey);

			if (note == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchNoteException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(note);
		}
		catch (NoSuchNoteException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Note removeImpl(Note note) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(note)) {
				note = (Note)session.get(
					NoteImpl.class, note.getPrimaryKeyObj());
			}

			if (note != null) {
				session.delete(note);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (note != null) {
			clearCache(note);
		}

		return note;
	}

	@Override
	public Note updateImpl(Note note) {
		boolean isNew = note.isNew();

		if (!(note instanceof NoteModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(note.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(note);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in note proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom Note implementation " +
					note.getClass());
		}

		NoteModelImpl noteModelImpl = (NoteModelImpl)note;

		if (Validator.isNull(note.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			note.setUuid(uuid);
		}

		ServiceContext serviceContext =
			ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (note.getCreateDate() == null)) {
			if (serviceContext == null) {
				note.setCreateDate(now);
			}
			else {
				note.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!noteModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				note.setModifiedDate(now);
			}
			else {
				note.setModifiedDate(serviceContext.getModifiedDate(now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(note);

				note.setNew(false);
			}
			else {
				note = (Note)session.merge(note);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!_columnBitmaskEnabled) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else if (isNew) {
			Object[] args = new Object[] {noteModelImpl.getUuid()};

			finderCache.removeResult(_finderPathCountByUuid, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid, args);

			args = new Object[] {
				noteModelImpl.getUuid(), noteModelImpl.getCompanyId()
			};

			finderCache.removeResult(_finderPathCountByUuid_C, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByUuid_C, args);

			args = new Object[] {
				noteModelImpl.getExternalNoteId(),
				noteModelImpl.getProcessStatus()
			};

			finderCache.removeResult(_finderPathCountByE_P, args);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindByE_P, args);

			finderCache.removeResult(_finderPathCountAll, FINDER_ARGS_EMPTY);
			finderCache.removeResult(
				_finderPathWithoutPaginationFindAll, FINDER_ARGS_EMPTY);
		}
		else {
			if ((noteModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {noteModelImpl.getOriginalUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);

				args = new Object[] {noteModelImpl.getUuid()};

				finderCache.removeResult(_finderPathCountByUuid, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid, args);
			}

			if ((noteModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByUuid_C.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					noteModelImpl.getOriginalUuid(),
					noteModelImpl.getOriginalCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);

				args = new Object[] {
					noteModelImpl.getUuid(), noteModelImpl.getCompanyId()
				};

				finderCache.removeResult(_finderPathCountByUuid_C, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByUuid_C, args);
			}

			if ((noteModelImpl.getColumnBitmask() &
				 _finderPathWithoutPaginationFindByE_P.getColumnBitmask()) !=
					 0) {

				Object[] args = new Object[] {
					noteModelImpl.getOriginalExternalNoteId(),
					noteModelImpl.getOriginalProcessStatus()
				};

				finderCache.removeResult(_finderPathCountByE_P, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByE_P, args);

				args = new Object[] {
					noteModelImpl.getExternalNoteId(),
					noteModelImpl.getProcessStatus()
				};

				finderCache.removeResult(_finderPathCountByE_P, args);
				finderCache.removeResult(
					_finderPathWithoutPaginationFindByE_P, args);
			}
		}

		entityCache.putResult(
			entityCacheEnabled, NoteImpl.class, note.getPrimaryKey(), note,
			false);

		clearUniqueFindersCache(noteModelImpl, false);
		cacheUniqueFindersCache(noteModelImpl);

		note.resetOriginalValues();

		return note;
	}

	/**
	 * Returns the note with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the note
	 * @return the note
	 * @throws NoSuchNoteException if a note with the primary key could not be found
	 */
	@Override
	public Note findByPrimaryKey(Serializable primaryKey)
		throws NoSuchNoteException {

		Note note = fetchByPrimaryKey(primaryKey);

		if (note == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchNoteException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return note;
	}

	/**
	 * Returns the note with the primary key or throws a <code>NoSuchNoteException</code> if it could not be found.
	 *
	 * @param noteId the primary key of the note
	 * @return the note
	 * @throws NoSuchNoteException if a note with the primary key could not be found
	 */
	@Override
	public Note findByPrimaryKey(long noteId) throws NoSuchNoteException {
		return findByPrimaryKey((Serializable)noteId);
	}

	/**
	 * Returns the note with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param noteId the primary key of the note
	 * @return the note, or <code>null</code> if a note with the primary key could not be found
	 */
	@Override
	public Note fetchByPrimaryKey(long noteId) {
		return fetchByPrimaryKey((Serializable)noteId);
	}

	/**
	 * Returns all the notes.
	 *
	 * @return the notes
	 */
	@Override
	public List<Note> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the notes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @return the range of notes
	 */
	@Override
	public List<Note> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the notes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of notes
	 */
	@Override
	public List<Note> findAll(
		int start, int end, OrderByComparator<Note> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the notes.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>NoteModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of notes
	 * @param end the upper bound of the range of notes (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of notes
	 */
	@Override
	public List<Note> findAll(
		int start, int end, OrderByComparator<Note> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<Note> list = null;

		if (useFinderCache) {
			list = (List<Note>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_NOTE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_NOTE;

				sql = sql.concat(NoteModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<Note>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				if (useFinderCache) {
					finderCache.removeResult(finderPath, finderArgs);
				}

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the notes from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Note note : findAll()) {
			remove(note);
		}
	}

	/**
	 * Returns the number of notes.
	 *
	 * @return the number of notes
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_NOTE);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				finderCache.removeResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY);

				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "noteId";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_NOTE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return NoteModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the note persistence.
	 */
	@Activate
	public void activate() {
		NoteModelImpl.setEntityCacheEnabled(entityCacheEnabled);
		NoteModelImpl.setFinderCacheEnabled(finderCacheEnabled);

		_finderPathWithPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, NoteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);

		_finderPathWithoutPaginationFindAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, NoteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll",
			new String[0]);

		_finderPathCountAll = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0]);

		_finderPathWithPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, NoteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, NoteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] {String.class.getName()},
			NoteModelImpl.UUID_COLUMN_BITMASK |
			NoteModelImpl.NOTECREATEDATE_COLUMN_BITMASK);

		_finderPathCountByUuid = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] {String.class.getName()});

		_finderPathFetchByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, NoteImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()},
			NoteModelImpl.UUID_COLUMN_BITMASK |
			NoteModelImpl.GROUPID_COLUMN_BITMASK);

		_finderPathCountByUUID_G = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, NoteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, NoteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()},
			NoteModelImpl.UUID_COLUMN_BITMASK |
			NoteModelImpl.COMPANYID_COLUMN_BITMASK |
			NoteModelImpl.NOTECREATEDATE_COLUMN_BITMASK);

		_finderPathCountByUuid_C = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] {String.class.getName(), Long.class.getName()});

		_finderPathWithPaginationFindByC_NotP = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, NoteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByC_NotP",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithPaginationCountByC_NotP = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByC_NotP",
			new String[] {Long.class.getName(), String.class.getName()});

		_finderPathFetchByExternalNoteId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, NoteImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByExternalNoteId",
			new String[] {Long.class.getName()},
			NoteModelImpl.EXTERNALNOTEID_COLUMN_BITMASK);

		_finderPathCountByExternalNoteId = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByExternalNoteId",
			new String[] {Long.class.getName()});

		_finderPathWithPaginationFindByE_P = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, NoteImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByE_P",
			new String[] {
				Long.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});

		_finderPathWithoutPaginationFindByE_P = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, NoteImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByE_P",
			new String[] {Long.class.getName(), String.class.getName()},
			NoteModelImpl.EXTERNALNOTEID_COLUMN_BITMASK |
			NoteModelImpl.PROCESSSTATUS_COLUMN_BITMASK |
			NoteModelImpl.NOTECREATEDATE_COLUMN_BITMASK);

		_finderPathCountByE_P = new FinderPath(
			entityCacheEnabled, finderCacheEnabled, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByE_P",
			new String[] {Long.class.getName(), String.class.getName()});

		_finderPathWithPaginationFindByRowProcessed_ProcessStatus =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled, NoteImpl.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"findByRowProcessed_ProcessStatus",
				new String[] {
					String.class.getName(), String.class.getName(),
					Integer.class.getName(), Integer.class.getName(),
					OrderByComparator.class.getName()
				});

		_finderPathWithPaginationCountByRowProcessed_ProcessStatus =
			new FinderPath(
				entityCacheEnabled, finderCacheEnabled, Long.class,
				FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
				"countByRowProcessed_ProcessStatus",
				new String[] {String.class.getName(), String.class.getName()});
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(NoteImpl.class.getName());

		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	@Reference(
		target = OTHPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
		super.setConfiguration(configuration);

		_columnBitmaskEnabled = GetterUtil.getBoolean(
			configuration.get(
				"value.object.column.bitmask.enabled.com.argus.oth.cases.management.model.Note"),
			true);
	}

	@Override
	@Reference(
		target = OTHPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = OTHPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private boolean _columnBitmaskEnabled;

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_NOTE = "SELECT note FROM Note note";

	private static final String _SQL_SELECT_NOTE_WHERE =
		"SELECT note FROM Note note WHERE ";

	private static final String _SQL_COUNT_NOTE =
		"SELECT COUNT(note) FROM Note note";

	private static final String _SQL_COUNT_NOTE_WHERE =
		"SELECT COUNT(note) FROM Note note WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "note.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No Note exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No Note exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		NotePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"uuid", "type", "text", "code"});

	static {
		try {
			Class.forName(OTHPersistenceConstants.class.getName());
		}
		catch (ClassNotFoundException classNotFoundException) {
			throw new ExceptionInInitializerError(classNotFoundException);
		}
	}

}