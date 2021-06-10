package com.argus.oth.data.export;

import com.argus.oth.common.report.ReportRetrievalParameters;

import com.liferay.portal.kernel.util.ObjectValuePair;

import java.io.File;

import java.util.List;
import java.util.function.Function;

/**
 * @author Jaclyn Ong
 */
public interface BatchEngineExportTaskExecutor {

	File execute(
            List<String> columnHeadings, Function<Object, List<ObjectValuePair<Object, String>>> processingFunction,
            Function<ReportRetrievalParameters, List<?>> retrievalFunction, int total,
            ReportRetrievalParameters reportRetrievalParameters);

}