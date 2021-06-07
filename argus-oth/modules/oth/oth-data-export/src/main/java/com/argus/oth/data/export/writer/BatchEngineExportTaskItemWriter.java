package com.argus.oth.data.export.writer;

import java.io.Closeable;

import java.util.List;

/**
 * @author Jaclyn Ong
 */
public interface BatchEngineExportTaskItemWriter extends Closeable {

	public void write() throws Exception;

	public void writeBatch(List<?> items) throws Exception;

}