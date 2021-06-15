package com.argus.oth.data.export.configuration;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

/**
 * @author Eric Chin
 */
@Component(
	configurationPid = "com.argus.oth.data.export.configuration.BatchExportConfiguration", immediate = true,
	service = BatchExportConfigurator.class
)
public class BatchExportConfigurator {

	public static final String BATCH_TMP_DIR = "/tmp";

	@Activate
	@Modified
	public void activate(Map<String, Object> properties) {
		_batchExportConfiguration = ConfigurableUtil.createConfigurable(BatchExportConfiguration.class, properties);
	}

	public int batchSize() {
		return _batchExportConfiguration.batchSize();
	}

	public String executionUser() {
		return _batchExportConfiguration.executionUser();
	}

	public String outputDirectory() {
		return _batchExportConfiguration.outputDirectory() + BATCH_TMP_DIR;
	}

	public String outputFileName() {
		return _batchExportConfiguration.outputFileName();
	}

	public String schedule() {
		return _batchExportConfiguration.schedule();
	}

	private BatchExportConfiguration _batchExportConfiguration;

}