package com.argus.oth.data.export.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Eric Chin
 */
@ExtendedObjectClassDefinition(category = "oth-portal")
@Meta.OCD(
	id = "com.argus.oth.data.export.configuration.BatchExportConfiguration", localization = "content/Language",
	name = "batch-export-configuration-name"
)
public interface BatchExportConfiguration {

	@Meta.AD(deflt = "1000", required = false, type = Meta.Type.Integer)
	public int batchSize();

	@Meta.AD(deflt = "admin-liferay@argus.bm", required = false, type = Meta.Type.String)
	public String executionUser();

	@Meta.AD(deflt = "data/document_library/batch", required = false, type = Meta.Type.String)
	public String outputDirectory();

	@Meta.AD(deflt = "report.xlsx", required = false, type = Meta.Type.String)
	public String outputFileName();

	@Meta.AD(deflt = "0 0 0 ? * * *", required = false, type = Meta.Type.String)
	public String schedule();

}