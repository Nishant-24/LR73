package com.argus.oth.bulk.load.background.task.configuration;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;

import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;

/**
 * @author Davy Duran
 */
@Component(
	configurationPid = "com.argus.oth.bulk.load.background.task.configuration.BulkLoadConfiguration", immediate = true,
	service = BulkLoadConfigurator.class
)
public class BulkLoadConfigurator {

	@Activate
	@Modified
	public void activate(Map<String, Object> properties) {
		_bulkLoadConfiguration = ConfigurableUtil.createConfigurable(BulkLoadConfiguration.class, properties);
	}

	public String amAnalyticsClaimFileName() {
		return _bulkLoadConfiguration.amAnalyticsClaimFileName();
	}

	public String amAnalyticsDbFileName() {
		return _bulkLoadConfiguration.amAnalyticsDbFileName();
	}

	public String amAnalyticsTelephonyFileName() {
		return _bulkLoadConfiguration.amAnalyticsTelephonyFileName();
	}

	public String authorizationsFileName() {
		return _bulkLoadConfiguration.authorizationsFileName();
	}

	public String authProceduresFileName() {
		return _bulkLoadConfiguration.authProceduresFileName();
	}

	public Integer batchSize() {
		return _bulkLoadConfiguration.batchSize();
	}

	public String casesFileName() {
		return _bulkLoadConfiguration.casesFileName();
	}

	public String claimAnalyticsFileName() {
		return _bulkLoadConfiguration.claimAnalyticsFileName();
	}

	public String claimDetailFileName() {
		return _bulkLoadConfiguration.claimDetailFileName();
	}

	public String claimFileName() {
		return _bulkLoadConfiguration.claimFileName();
	}

	public String clientGroupFileName() {
		return _bulkLoadConfiguration.clientGroupFileName();
	}

	public String clientsFileName() {
		return _bulkLoadConfiguration.clientsFileName();
	}

	public String executionUser() {
		return _bulkLoadConfiguration.executionUser();
	}

	public String ftpUser() {
		return _bulkLoadConfiguration.ftpUser();
	}

	public String localPath() {
		return _bulkLoadConfiguration.localPath();
	}

	public String memberFileName() {
		return _bulkLoadConfiguration.memberFileName();
	}

	public String notesFileName() {
		return _bulkLoadConfiguration.notesFileName();
	}

	public String password() {
		return _bulkLoadConfiguration.password();
	}

	public Integer portNumber() {
		return _bulkLoadConfiguration.portNumber();
	}

	public String referenceTypeCodeFileName() {
		return _bulkLoadConfiguration.referenceTypeCodeFileName();
	}

	public String remoteFile() {
		return _bulkLoadConfiguration.remoteFile();
	}

	public String remoteFileFolderName() {
		return _bulkLoadConfiguration.remoteFileFolderName();
	}

	public String remoteFileUnzipPath() {
		return _bulkLoadConfiguration.remoteFileUnzipPath();
	}

	public String schedule() {
		return _bulkLoadConfiguration.schedule();
	}

	public String targetUrl() {
		return _bulkLoadConfiguration.targetUrl();
	}

	public String tasksFileName() {
		return _bulkLoadConfiguration.tasksFileName();
	}

	public Boolean validateLines() {
		return _bulkLoadConfiguration.validateLines();
	}

	private BulkLoadConfiguration _bulkLoadConfiguration;

}