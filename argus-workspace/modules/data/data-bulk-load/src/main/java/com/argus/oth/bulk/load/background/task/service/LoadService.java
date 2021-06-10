package com.argus.oth.bulk.load.background.task.service;

/**
 * Proxy for transactions
 * @author Davy Duran
 */
public interface LoadService<T> {

	void loadData(String randomString) throws Exception;

	boolean validate(T model);

}