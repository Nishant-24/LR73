package com.argus.oth.cases.management.webhook.rs.client.function;

import javax.annotation.Generated;

/**
 * @author Davy
 * @generated
 */
@FunctionalInterface
@Generated("")
public interface UnsafeSupplier<T, E extends Throwable> {

	public T get() throws E;

}