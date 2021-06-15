package com.argus.oth.bulk.load.background.task.service;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * @author Eric Chin
 */
public class LoadServiceFactory {

	public static <T> LoadService<T> getLoadServiceByModelClass(String className) {
		Bundle bundle = FrameworkUtil.getBundle(LoadServiceFactory.class);

		ServiceTracker<LoadService<T>, LoadService<T>> serviceTracker = ServiceTrackerFactory.open(
			bundle.getBundleContext(), "(model.name=" + className + ")");

		return serviceTracker.getService();
	}

	public static <T> LoadService<T> getLoadServiceByStagingModel(String className) {
		Bundle bundle = FrameworkUtil.getBundle(LoadServiceFactory.class);

		ServiceTracker<LoadService<T>, LoadService<T>> serviceTracker = ServiceTrackerFactory.open(
			bundle.getBundleContext(), "(staging.model.name=" + className + ")");

		return serviceTracker.getService();
	}

}