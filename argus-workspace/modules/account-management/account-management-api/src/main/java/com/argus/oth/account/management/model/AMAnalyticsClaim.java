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

package com.argus.oth.account.management.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the AMAnalyticsClaim service. Represents a row in the &quot;OTH_AMAnalyticsClaim&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see AMAnalyticsClaimModel
 * @generated
 */
@ImplementationClassName(
	"com.argus.oth.account.management.model.impl.AMAnalyticsClaimImpl"
)
@ProviderType
public interface AMAnalyticsClaim
	extends AMAnalyticsClaimModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.argus.oth.account.management.model.impl.AMAnalyticsClaimImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<AMAnalyticsClaim, Long>
		AM_ANALYTICS_CLAIM_ID_ACCESSOR =
			new Accessor<AMAnalyticsClaim, Long>() {

				@Override
				public Long get(AMAnalyticsClaim amAnalyticsClaim) {
					return amAnalyticsClaim.getAmAnalyticsClaimId();
				}

				@Override
				public Class<Long> getAttributeClass() {
					return Long.class;
				}

				@Override
				public Class<AMAnalyticsClaim> getTypeClass() {
					return AMAnalyticsClaim.class;
				}

			};

}