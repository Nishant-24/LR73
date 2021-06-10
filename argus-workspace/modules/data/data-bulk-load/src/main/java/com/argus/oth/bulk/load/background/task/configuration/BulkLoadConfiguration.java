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
    String targetUrl();

	@Meta.AD(deflt = "42222", required = false, type = Meta.Type.String)
    Integer portNumber();

	@Meta.AD(required = false, type = Meta.Type.String)
    String ftpUser();

	@Meta.AD(deflt = "test", required = false, type = Meta.Type.Password)
    String password();

	@Meta.AD(deflt = "0 0 0 ? * * *", required = false, type = Meta.Type.String)
    String schedule();

	@Meta.AD(deflt = "admin-liferay@argus.bm", required = false, type = Meta.Type.String)
    String executionUser();

	@Meta.AD(deflt = "OTH_Data.zip", required = false, type = Meta.Type.String)
    String remoteFile();

	@Meta.AD(deflt = "bulk-load-files", required = false, type = Meta.Type.String)
    String remoteFileFolderName();

	@Meta.AD(deflt = "./TEST/", required = false, type = Meta.Type.String)
    String remoteFileUnzipPath();

	@Meta.AD(deflt = "/TEST/", required = false, type = Meta.Type.String)
    String localPath();

	@Meta.AD(deflt = "AMAAnalyticsClaim.txt", required = false, type = Meta.Type.String)
    String amAnalyticsClaimFileName();

	@Meta.AD(deflt = "AMAAnalyticsDB.txt", required = false, type = Meta.Type.String)
    String amAnalyticsDbFileName();

	@Meta.AD(deflt = "AMAAnalyticsTelephony.txt", required = false, type = Meta.Type.String)
    String amAnalyticsTelephonyFileName();

	@Meta.AD(deflt = "AuthProc.txt", required = false, type = Meta.Type.String)
    String authProceduresFileName();

	@Meta.AD(deflt = "MemberAuthorization.txt", required = false, type = Meta.Type.String)
    String authorizationsFileName();

	@Meta.AD(deflt = "Case.txt", required = false, type = Meta.Type.String)
    String casesFileName();

	@Meta.AD(deflt = "ClientGroup.txt", required = false, type = Meta.Type.String)
    String clientGroupFileName();

	@Meta.AD(deflt = "Client.txt", required = false, type = Meta.Type.String)
    String clientsFileName();

	@Meta.AD(deflt = "CaseNote.txt", required = false, type = Meta.Type.String)
    String notesFileName();

	@Meta.AD(deflt = "CaseTask.txt", required = false, type = Meta.Type.String)
    String tasksFileName();

	@Meta.AD(deflt = "Member.txt", required = false, type = Meta.Type.String)
    String memberFileName();

	@Meta.AD(deflt = "ReferenceTypeCode.txt", required = false, type = Meta.Type.String)
    String referenceTypeCodeFileName();

	@Meta.AD(deflt = "ClaimHeader.txt", required = false, type = Meta.Type.String)
    String claimFileName();

	@Meta.AD(deflt = "ClaimDetail.txt", required = false, type = Meta.Type.String)
    String claimDetailFileName();

	@Meta.AD(deflt = "ClaimAnalytics.txt", required = false, type = Meta.Type.String)
    String claimAnalyticsFileName();

	@Meta.AD(deflt = "False", required = false, type = Meta.Type.Boolean)
    Boolean validateLines();

	@Meta.AD(deflt = "1000", required = false, type = Meta.Type.Integer)
    Integer batchSize();

}