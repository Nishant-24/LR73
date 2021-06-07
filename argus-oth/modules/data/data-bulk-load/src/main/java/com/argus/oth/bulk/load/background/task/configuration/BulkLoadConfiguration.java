package com.argus.oth.bulk.load.background.task.configuration;

import aQute.bnd.annotation.metatype.Meta;

import com.liferay.portal.configuration.metatype.annotations.ExtendedObjectClassDefinition;

/**
 * @author Davy Duran
 */
@ExtendedObjectClassDefinition(category = "oth-portal")
@Meta.OCD(
	id = "com.argus.oth.bulk.load.background.task.configuration.BulkLoadConfiguration",
	localization = "content/Language", name = "BulkLoad"
)
public interface BulkLoadConfiguration {

	@Meta.AD(deflt = "sftp.argus.bm", required = false, type = Meta.Type.String)
	public String targetUrl();

	@Meta.AD(deflt = "42222", required = false, type = Meta.Type.String)
	public Integer portNumber();

	@Meta.AD(required = false, type = Meta.Type.String)
	public String ftpUser();

	@Meta.AD(deflt = "test", required = false, type = Meta.Type.Password)
	public String password();

	@Meta.AD(deflt = "0 0 0 ? * * *", required = false, type = Meta.Type.String)
	public String schedule();

	@Meta.AD(deflt = "admin-liferay@argus.bm", required = false, type = Meta.Type.String)
	public String executionUser();

	@Meta.AD(deflt = "OTH_Data.zip", required = false, type = Meta.Type.String)
	public String remoteFile();

	@Meta.AD(deflt = "bulk-load-files", required = false, type = Meta.Type.String)
	public String remoteFileFolderName();

	@Meta.AD(deflt = "./TEST/", required = false, type = Meta.Type.String)
	public String remoteFileUnzipPath();

	@Meta.AD(deflt = "/TEST/", required = false, type = Meta.Type.String)
	public String localPath();

	@Meta.AD(deflt = "AMAAnalyticsClaim.txt", required = false, type = Meta.Type.String)
	public String amAnalyticsClaimFileName();

	@Meta.AD(deflt = "AMAAnalyticsDB.txt", required = false, type = Meta.Type.String)
	public String amAnalyticsDbFileName();

	@Meta.AD(deflt = "AMAAnalyticsTelephony.txt", required = false, type = Meta.Type.String)
	public String amAnalyticsTelephonyFileName();

	@Meta.AD(deflt = "AuthProc.txt", required = false, type = Meta.Type.String)
	public String authProceduresFileName();

	@Meta.AD(deflt = "MemberAuthorization.txt", required = false, type = Meta.Type.String)
	public String authorizationsFileName();

	@Meta.AD(deflt = "Case.txt", required = false, type = Meta.Type.String)
	public String casesFileName();

	@Meta.AD(deflt = "ClientGroup.txt", required = false, type = Meta.Type.String)
	public String clientGroupFileName();

	@Meta.AD(deflt = "Client.txt", required = false, type = Meta.Type.String)
	public String clientsFileName();

	@Meta.AD(deflt = "CaseNote.txt", required = false, type = Meta.Type.String)
	public String notesFileName();

	@Meta.AD(deflt = "CaseTask.txt", required = false, type = Meta.Type.String)
	public String tasksFileName();

	@Meta.AD(deflt = "Member.txt", required = false, type = Meta.Type.String)
	public String memberFileName();

	@Meta.AD(deflt = "ReferenceTypeCode.txt", required = false, type = Meta.Type.String)
	public String referenceTypeCodeFileName();

	@Meta.AD(deflt = "ClaimHeader.txt", required = false, type = Meta.Type.String)
	public String claimFileName();

	@Meta.AD(deflt = "ClaimDetail.txt", required = false, type = Meta.Type.String)
	public String claimDetailFileName();

	@Meta.AD(deflt = "ClaimAnalytics.txt", required = false, type = Meta.Type.String)
	public String claimAnalyticsFileName();

	@Meta.AD(deflt = "False", required = false, type = Meta.Type.Boolean)
	public Boolean validateLines();

	@Meta.AD(deflt = "1000", required = false, type = Meta.Type.Integer)
	public Integer batchSize();

}