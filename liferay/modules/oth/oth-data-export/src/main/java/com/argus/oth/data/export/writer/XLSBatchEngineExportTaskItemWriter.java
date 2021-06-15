package com.argus.oth.data.export.writer;

import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.portal.kernel.util.Validator;

import java.io.IOException;
import java.io.OutputStream;

import java.util.Date;
import java.util.List;
import java.util.function.Function;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

/**
 * @author Jaclyn Ong
 */
public class XLSBatchEngineExportTaskItemWriter implements BatchEngineExportTaskItemWriter {

	public XLSBatchEngineExportTaskItemWriter(
		OutputStream outputStream, Function<Object, List<ObjectValuePair<Object, String>>> processingFunction,
		List<String> columnNames) {

		_workbook = new SXSSFWorkbook();

		_outputStream = outputStream;
		_processingFunction = processingFunction;
		_rowNum = 0;
		_sheet = _workbook.createSheet();

		_setColumnNames(columnNames);
	}

	@Override
	public void close() throws IOException {
		if (_workbook != null) {
			_workbook.close();
		}

		if (_outputStream != null) {
			_outputStream.close();
		}
	}

	@Override
	public void write() throws Exception {
		_workbook.write(_outputStream);

		close();
	}

	@Override
	public void writeBatch(List<?> items) throws Exception {
		if (_processingFunction == null) {
			throw new Exception("Missing function");
		}

		for (Object item : items) {
			_write(_processingFunction.apply(item));
		}
	}

	private void _setColumnNames(List<String> columnNames) {
		Row row = _sheet.createRow(_rowNum++);

		for (int i = 0; i < columnNames.size(); i++) {
			String columnName = columnNames.get(i);

			Cell cell = row.createCell(i);

			cell.setCellValue(columnName);
		}
	}

	private void _write(List<ObjectValuePair<Object, String>> values) {
		Row row = _sheet.createRow(_rowNum++);

		int column = 0;

		for (ObjectValuePair<Object, String> pair : values) {
			Cell cell = row.createCell(column++);

			Object value = pair.getKey();

			if (value instanceof Boolean) {
				cell.setCellValue((Boolean)value);
			}
			else if (value instanceof Date) {
				cell.setCellValue((Date)value);
			}
			else if (value instanceof Long) {
				cell.setCellValue((Long)value);
			}
			else if (value instanceof Double) {
				cell.setCellValue((Double)value);
			}
			else {
				cell.setCellValue((String)value);
			}

			String cellDataFormat = pair.getValue();

			if (!Validator.isBlank(cellDataFormat)) {
				CellStyle cellStyle = _workbook.createCellStyle();

				CreationHelper creationHelper = _workbook.getCreationHelper();

				DataFormat dataFormat = creationHelper.createDataFormat();

				cellStyle.setDataFormat(dataFormat.getFormat(cellDataFormat));

				cell.setCellStyle(cellStyle);
			}
		}
	}

	private final OutputStream _outputStream;
	private final Function<Object, List<ObjectValuePair<Object, String>>> _processingFunction;
	private int _rowNum;
	private final Sheet _sheet;
	private final Workbook _workbook;

}