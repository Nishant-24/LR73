package com.argus.oth.cases.management.webhook.rs.client.dto.v1_0;

import com.argus.oth.cases.management.webhook.rs.client.function.UnsafeSupplier;
import com.argus.oth.cases.management.webhook.rs.client.serdes.v1_0.ProcessEventSerDes;

import java.util.Objects;

import javax.annotation.Generated;

/**
 * @author Davy
 * @generated
 */
@Generated("")
public class ProcessEvent {

	public Long getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(Long primaryKey) {
		this.primaryKey = primaryKey;
	}

	public void setPrimaryKey(
		UnsafeSupplier<Long, Exception> primaryKeyUnsafeSupplier) {

		try {
			primaryKey = primaryKeyUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long primaryKey;

	public Long getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Long statusCode) {
		this.statusCode = statusCode;
	}

	public void setStatusCode(
		UnsafeSupplier<Long, Exception> statusCodeUnsafeSupplier) {

		try {
			statusCode = statusCodeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected Long statusCode;

	public String getStatusDescription() {
		return statusDescription;
	}

	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}

	public void setStatusDescription(
		UnsafeSupplier<String, Exception> statusDescriptionUnsafeSupplier) {

		try {
			statusDescription = statusDescriptionUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String statusDescription;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setType(UnsafeSupplier<String, Exception> typeUnsafeSupplier) {
		try {
			type = typeUnsafeSupplier.get();
		}
		catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	protected String type;

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProcessEvent)) {
			return false;
		}

		ProcessEvent processEvent = (ProcessEvent)object;

		return Objects.equals(toString(), processEvent.toString());
	}

	@Override
	public int hashCode() {
		String string = toString();

		return string.hashCode();
	}

	public String toString() {
		return ProcessEventSerDes.toJSON(this);
	}

}