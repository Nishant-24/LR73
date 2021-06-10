package com.argus.oth.data.export;

import com.argus.oth.common.report.ReportRetrievalParameters;
import com.argus.oth.data.export.configuration.BatchExportConfigurator;
import com.argus.oth.data.export.writer.BatchEngineExportTaskItemWriter;
import com.argus.oth.data.export.writer.XLSBatchEngineExportTaskItemWriter;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ObjectValuePair;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import java.util.List;
import java.util.function.Function;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Jaclyn Ong
 */
@Component(service = BatchEngineExportTaskExecutor.class)
public class BatchEngineExportTaskExecutorImpl implements BatchEngineExportTaskExecutor {

	@Override
	public File execute(
		List<String> columnHeadings, Function<Object, List<ObjectValuePair<Object, String>>> processingFunction,
		Function<ReportRetrievalParameters, List<?>> retrievalFunction, int total,
		ReportRetrievalParameters reportRetrievalParameters) {

		try {
			return _execute(columnHeadings, processingFunction, retrievalFunction, total, reportRetrievalParameters);
		}
		catch (Exception e) {
			_log.error("Unable to update batch engine export task ", e);

			return null;
		}
	}

	@SuppressWarnings("ResultOfMethodCallIgnored")
	private File _createFile() throws IOException {
		String folderName = _batchExportConfigurator.outputDirectory();

		File folder = new File(folderName);

		folder.mkdirs();

		String timestamp = folderName + StringPool.FORWARD_SLASH + System.currentTimeMillis();

		File file = new File(timestamp);

		if (!file.createNewFile()) {
			_log.warn("File with name " + timestamp + " already exists");
		}

		return file;
	}

	private File _execute(
			List<String> columnHeadings, Function<Object, List<ObjectValuePair<Object, String>>> processingFunction,
			Function<ReportRetrievalParameters, List<?>> retrievalFunction, int total,
			ReportRetrievalParameters reportRetrievalParameters)
		throws Exception {

		int batchSize = _batchExportConfigurator.batchSize();

		File file = _createFile();

		FileOutputStream fileOutputStream = new FileOutputStream(file);

		try (BatchEngineExportTaskItemWriter taskItemWriter = new XLSBatchEngineExportTaskItemWriter(
				fileOutputStream, processingFunction, columnHeadings)) {

			int pages = Math.floorDiv(total, batchSize);

			if ((total % batchSize) > 0) {
				pages++;
			}

			for (int i = 1; i <= pages; i++) {
				Pagination pagination = Pagination.of(i, batchSize);

				reportRetrievalParameters.setStart(pagination.getStartPosition());
				reportRetrievalParameters.setEnd(pagination.getEndPosition());

				List<?> items = retrievalFunction.apply(reportRetrievalParameters);

				taskItemWriter.writeBatch(items);
			}

			taskItemWriter.write();

			return file;
		}
		catch (Exception e) {
			_log.error(e.getMessage(), e);

			return null;
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(BatchEngineExportTaskExecutorImpl.class);

	@Reference
	private BatchExportConfigurator _batchExportConfigurator;

}