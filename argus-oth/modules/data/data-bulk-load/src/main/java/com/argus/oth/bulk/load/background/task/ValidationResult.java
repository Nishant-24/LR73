package com.argus.oth.bulk.load.background.task;

import java.util.List;

public class ValidationResult<T, R> {

	public List<R> getModels() {
		return _models;
	}

	public List<T> getStagingModels() {
		return _stagingModels;
	}

	public boolean getValid() {
		return _valid;
	}

	public void setModels(List<R> models) {
		_models = models;
	}

	public void setStagingModels(List<T> stagingModels) {
		_stagingModels = stagingModels;
	}

	public void setValid(boolean valid) {
		_valid = valid;
	}

	private List<R> _models;
	private List<T> _stagingModels;
	private boolean _valid;

}