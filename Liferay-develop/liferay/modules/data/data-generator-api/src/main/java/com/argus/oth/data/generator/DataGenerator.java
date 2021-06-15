package com.argus.oth.data.generator;

/**
 * @author Ricky Pan
 */
public interface DataGenerator {

	public void addSampleData() throws Exception;

	public void deleteAllData(long companyId) throws Exception;

}