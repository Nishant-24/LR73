package com.argus.oth.data.generator;

/**
 * @author Ricky Pan
 */
public interface DataGenerator {

	void addSampleData() throws Exception;

	void deleteAllData(long companyId) throws Exception;

}