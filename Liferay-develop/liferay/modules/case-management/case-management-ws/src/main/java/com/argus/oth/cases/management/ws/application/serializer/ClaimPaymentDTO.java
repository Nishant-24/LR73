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

package com.argus.oth.cases.management.ws.application.serializer;

import com.argus.oth.cases.management.model.ClaimDetail;

/**
 * @author Ricky Pan
 */
public class ClaimPaymentDTO {

	public ClaimPaymentDTO() {
		_balance = 0;
		_chargedAmount = 0;
		_paidAmount = 0;
		_repricedAmount = 0;
		_savingsAmount = 0;
	}

	public void addClaimDetails(ClaimDetail claimDetail) {
		_balance = _balance + claimDetail.getClaimAmount();
		_chargedAmount = _chargedAmount + claimDetail.getChargedAmount();
		_paidAmount = _paidAmount + claimDetail.getPaidAmount();
		_repricedAmount = _repricedAmount + claimDetail.getRepricedAmount();
		_savingsAmount = _savingsAmount + claimDetail.getSavingsAmount();
	}

	public double getBalance() {
		return _balance;
	}

	public double getChargedAmount() {
		return _chargedAmount;
	}

	public double getPaidAmount() {
		return _paidAmount;
	}

	public double getRepricedAmount() {
		return _repricedAmount;
	}

	public double getSavingsAmount() {
		return _savingsAmount;
	}

	private double _balance;
	private double _chargedAmount;
	private double _paidAmount;
	private double _repricedAmount;
	private double _savingsAmount;

}