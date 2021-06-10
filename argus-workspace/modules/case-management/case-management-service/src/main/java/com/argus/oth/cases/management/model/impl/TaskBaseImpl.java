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

import com.argus.oth.cases.management.model.Task;
import com.argus.oth.cases.management.service.TaskLocalServiceUtil;

/**
 * The extended model base implementation for the Task service. Represents a row in the &quot;OTH_Task&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link TaskImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see TaskImpl
 * @see Task
 * @generated
 */
public abstract class TaskBaseImpl extends TaskModelImpl implements Task {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a task model instance should use the <code>Task</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			TaskLocalServiceUtil.addTask(this);
		}
		else {
			TaskLocalServiceUtil.updateTask(this);
		}
	}

}