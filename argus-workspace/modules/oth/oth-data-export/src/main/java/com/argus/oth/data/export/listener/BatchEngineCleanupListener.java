package com.argus.oth.data.export.listener;

import com.argus.oth.data.export.background.task.DataExportCleanupBackgroundTask;
import com.argus.oth.data.export.configuration.BatchExportConfiguration;
import com.argus.oth.data.export.configuration.BatchExportConfigurator;

import com.liferay.petra.string.StringPool;
import com.liferay.portal.background.task.service.BackgroundTaskLocalService;
import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
import com.liferay.portal.kernel.scheduler.SchedulerEntry;
import com.liferay.portal.kernel.scheduler.SchedulerEntryImpl;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerFactory;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalService;
import com.liferay.portal.kernel.util.HashMapBuilder;
import com.liferay.portal.kernel.util.Portal;

import java.io.Serializable;

import java.util.Date;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Eric Chin
 */
@Component(configurationPid = "com.argus.oth.data.export.configuration.BatchExportConfiguration", immediate = true)
public class BatchEngineCleanupListener implements MessageListener {

	@Override
	public void receive(Message message) {
		_log.info("Initializing batch cleanup tasks");

		User user = _userLocalService.fetchUserByEmailAddress(
			_portal.getDefaultCompanyId(), _batchExportConfiguration.executionUser());

		String outputDirectory = _batchExportConfiguration.outputDirectory() + BatchExportConfigurator.BATCH_TMP_DIR;

		Map<String, Serializable> taskContextMap = HashMapBuilder.<String, Serializable>put(
			DataExportCleanupBackgroundTask.EXPORT_OUTPUT_TMP_DIR, outputDirectory
		).build();

		try {
			_backgroundTaskLocalService.addBackgroundTask(
				user.getUserId(), user.getGroupId(), StringPool.BLANK, DataExportCleanupBackgroundTask.class.getName(),
				taskContextMap, new ServiceContext());
		}
		catch (PortalException pe) {
			_log.error(pe, pe);
		}
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		_log.info("Batch cleanup scheduler");

		_batchExportConfiguration = ConfigurableUtil.createConfigurable(BatchExportConfiguration.class, properties);

		String listenerClass = getClass().getName();

		Trigger jobTrigger = _triggerFactory.createTrigger(
			listenerClass, listenerClass, new Date(), null, _batchExportConfiguration.schedule());

		SchedulerEntry schedulerEntry = new SchedulerEntryImpl(getClass().getName(), jobTrigger);

		_schedulerEngineHelper.register(this, schedulerEntry, DestinationNames.SCHEDULER_DISPATCH);
	}

	@Deactivate
	protected void deactivate() {
		_log.info("Deactivating batch cleanup scheduler");

		_batchExportConfiguration = null;

		_schedulerEngineHelper.unregister(this);
	}

	private static final Log _log = LogFactoryUtil.getLog(BatchEngineCleanupListener.class);

	@Reference
	private BackgroundTaskLocalService _backgroundTaskLocalService;

	private BatchExportConfiguration _batchExportConfiguration;

	@Reference
	private Portal _portal;

	@Reference
	private SchedulerEngineHelper _schedulerEngineHelper;

	@Reference
	private TriggerFactory _triggerFactory;

	@Reference
	private UserLocalService _userLocalService;

}