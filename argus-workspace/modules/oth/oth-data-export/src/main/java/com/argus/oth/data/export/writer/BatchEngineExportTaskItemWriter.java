package com.argus.oth.data.export.writer;

import java.io.Closeable;

import java.util.List;

/**
 * @author Jaclyn Ong
 */
public interface BatchEngineExportTaskItemWriter extends Closeable {

	void write() throws Exception;

	void writeBatch(List<?> items) throws Exception;

}