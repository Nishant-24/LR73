package com.argus.oth.bulk.load;

import com.argus.oth.bulk.load.background.task.configuration.BulkLoadConfiguration;
import com.argus.oth.bulk.load.background.task.service.BulkLoadService;
import com.argus.oth.email.EmailService;

import com.liferay.portal.configuration.metatype.bnd.util.ConfigurableUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.scheduler.SchedulerEngineHelper;
import com.liferay.portal.kernel.scheduler.SchedulerEntry;
import com.liferay.portal.kernel.scheduler.SchedulerEntryImpl;
import com.liferay.portal.kernel.scheduler.Trigger;
import com.liferay.portal.kernel.scheduler.TriggerFactory;

import java.util.Date;
import java.util.Map;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

@Component(
	configurationPid = "com.argus.oth.bulk.load.background.task.configuration.BulkLoadConfiguration", immediate = true
)
public class BulkLoadScheduler implements MessageListener {

	@Override
	public void receive(Message message) throws MessageListenerException {
		_log.info("Initializing bulk load tasks");

		try {
			_bulkLoadService.startBulkLoadPipeLine();
		}
		catch (PortalException pe) {
			_log.error("Unable to run bulk load", pe);

			_sendFailureEmail(pe.getMessage());
		}
	}

	@Activate
	@Modified
	protected void activate(Map<String, Object> properties) {
		BulkLoadConfiguration bulkLoadConfiguration = ConfigurableUtil.createConfigurable(
			BulkLoadConfiguration.class, properties);

		// create a new trigger definition for the job.

		_log.info("Activating bulk load scheduler ");

		String listenerClass = getClass().getName();

		Trigger jobTrigger = _triggerFactory.createTrigger(
			listenerClass, listenerClass, new Date(), null, bulkLoadConfiguration.schedule());

		SchedulerEntry schedulerEntry = new SchedulerEntryImpl(getClass().getName(), jobTrigger);

		// register the scheduled task

		_schedulerEngineHelper.register(this, schedulerEntry, DestinationNames.SCHEDULER_DISPATCH);
	}

	@Deactivate
	protected void deactivate() {
		_log.info("Deactivating bulk load scheduler ");

		_schedulerEngineHelper.unregister(this);
	}

	private void _sendFailureEmail(String message) {
		try {
			_emailService.sendEmail(
				"Bulk Load Failure", String.format("Bulk load failed. Reason: %s. See Liferay logs.", message));
		}
		catch (Exception e) {
			_log.error(e, e);
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(BulkLoadScheduler.class);

	@Reference
	private BulkLoadService _bulkLoadService;

	@Reference
	private EmailService _emailService;

	@Reference
	private SchedulerEngineHelper _schedulerEngineHelper;

	@Reference
	private TriggerFactory _triggerFactory;

}