package com.argus.oth.bulk.load.background.task.service;

/**
 * Proxy for transactions
 * @author Davy Duran
 */
public interface LoadService<T> {

	public void loadData(String randomString) throws Exception;

	public boolean validate(T model);

}