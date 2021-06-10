package com.argus.oth.claim.model;

import com.argus.oth.common.report.ReportRetrievalParameters;

import com.liferay.portal.kernel.util.DateRange;

/**
 * @author Jaclyn Ong
 */
public class ClaimsReportRetrievalParametersImpl implements ReportRetrievalParameters {

	public DateRange getDateRange() {
		return _dateRange;
	}

	public int getEnd() {
		return _end;
	}

	public long getExternalClientId() {
		return _externalClientId;
	}

	public int getStart() {
		return _start;
	}

	public void setDateRange(DateRange dateRange) {
		_dateRange = dateRange;
	}

	public void setEnd(int end) {
		_end = end;
	}

	public void setExternalClientId(long externalClientId) {
		_externalClientId = externalClientId;
	}

	public void setStart(int start) {
		_start = start;
	}

	private DateRange _dateRange;
	private int _end;
	private long _externalClientId;
	private int _start;

}