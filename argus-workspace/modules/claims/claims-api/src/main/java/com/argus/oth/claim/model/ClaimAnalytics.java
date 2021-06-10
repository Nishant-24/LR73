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

package com.argus.oth.claim.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the ClaimAnalytics service. Represents a row in the &quot;OTH_ClaimAnalytics&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ClaimAnalyticsModel
 * @generated
 */
@ImplementationClassName("com.argus.oth.claim.model.impl.ClaimAnalyticsImpl")
@ProviderType
public interface ClaimAnalytics extends ClaimAnalyticsModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.argus.oth.claim.model.impl.ClaimAnalyticsImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ClaimAnalytics, Long>
		CLAIM_ANALYTICS_ID_ACCESSOR = new Accessor<ClaimAnalytics, Long>() {

			@Override
			public Long get(ClaimAnalytics claimAnalytics) {
				return claimAnalytics.getClaimAnalyticsId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ClaimAnalytics> getTypeClass() {
				return ClaimAnalytics.class;
			}

		};

}