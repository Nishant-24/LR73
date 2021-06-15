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

package com.argus.oth.cases.management.model.impl;

import com.argus.oth.cases.management.model.Member;
import com.argus.oth.cases.management.service.MemberLocalServiceUtil;

/**
 * The extended model base implementation for the Member service. Represents a row in the &quot;OTH_Member&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link MemberImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MemberImpl
 * @see Member
 * @generated
 */
public abstract class MemberBaseImpl extends MemberModelImpl implements Member {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a member model instance should use the <code>Member</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			MemberLocalServiceUtil.addMember(this);
		}
		else {
			MemberLocalServiceUtil.updateMember(this);
		}
	}

}