create table OTH_AuthProcedure (
	authProcedureId LONG not null primary key,
	createDate DATE null,
	modifiedDate DATE null,
	externalAuthorizationId LONG,
	authNumber VARCHAR(75) null,
	medicalCodeId VARCHAR(75) null,
	description VARCHAR(2000) null,
	externalModifiedDate DATE null,
	externalCreatedDate DATE null
);

create table OTH_Authorization (
	uuid_ VARCHAR(75) null,
	authorizationId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	modifiedUserId LONG,
	caseId LONG,
	externalAuthorizationId LONG,
	memberId LONG,
	description STRING null,
	rtcAuthorizationStatus VARCHAR(75) null,
	authStatus VARCHAR(75) null,
	statusChangeDate DATE null,
	receivedDate DATE null,
	authNumber VARCHAR(75) null,
	category VARCHAR(1000) null,
	rtcAuthorizationType VARCHAR(75) null,
	facility VARCHAR(1000) null,
	procedureCode STRING null,
	comments STRING null,
	externalModifiedDate DATE null,
	effectiveFrom DATE null,
	effectiveThru DATE null,
	processStatus VARCHAR(75) null,
	failureDescription VARCHAR(2000) null,
	rowProcessed VARCHAR(75) null
);

create table OTH_Cases (
	uuid_ VARCHAR(75) null,
	caseId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	externalCaseId LONG,
	clientId LONG,
	clientName VARCHAR(75) null,
	clientGroupId LONG,
	caseNumber VARCHAR(75) null,
	caseStartDate DATE null,
	caseEndDate DATE null,
	memberId LONG,
	primaryDiagCode VARCHAR(1000) null,
	primaryCode VARCHAR(1000) null,
	status VARCHAR(75) null,
	estimateEntryDate DATE null,
	caseManager VARCHAR(75) null,
	consentReceivedDate DATE null,
	medicalPlan VARCHAR(1000) null,
	costEstimate VARCHAR(75) null,
	lastUpdated DATE null,
	externalCreatedDate DATE null,
	chargedAmount DOUBLE,
	paidAmount DOUBLE,
	repricedAmount DOUBLE,
	savingsAmount DOUBLE,
	savingsPercent DOUBLE,
	treatingPhysician VARCHAR(1000) null,
	primaryFacility VARCHAR(1000) null,
	rowProcessed VARCHAR(75) null
);

create table OTH_CasesGroupItem (
	casesGroupItemId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	userId LONG,
	externalCaseId LONG,
	type_ VARCHAR(75) null
);

create table OTH_Claim (
	claimId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	externalClaimId LONG,
	claimRef VARCHAR(75) null,
	authorizationNumber VARCHAR(75) null,
	serviceFrom DATE null,
	serviceThru DATE null,
	provider VARCHAR(75) null,
	prioritizedBill VARCHAR(75) null,
	diagCodesCombined STRING null,
	providerState VARCHAR(75) null,
	tpmReceivedDate DATE null,
	claimTurnaround LONG,
	billType STRING null,
	providerNetwork VARCHAR(1000) null,
	repricedNetwork VARCHAR(1000) null,
	statusSortOrder LONG,
	paidDate DATE null,
	paidAmount DOUBLE,
	claimStatus VARCHAR(75) null,
	rowProcessed VARCHAR(75) null
);

create table OTH_ClaimDetail (
	claimDetailId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	lineId LONG,
	externalClaimId LONG,
	serviceFrom DATE null,
	serviceThru DATE null,
	resultCodes STRING null,
	procedureCode VARCHAR(1000) null,
	chargedAmount DOUBLE,
	repricedAmount DOUBLE,
	claimAmount DOUBLE,
	paidDate DATE null,
	paidAmount DOUBLE,
	savingsAmount DOUBLE,
	units INTEGER,
	coverage VARCHAR(75) null,
	lineStatus VARCHAR(75) null,
	revCode VARCHAR(1000) null,
	rowProcessed VARCHAR(75) null
);

create table OTH_Client (
	clientId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	externalClientPk LONG,
	externalClientId LONG,
	clientName VARCHAR(1000) null,
	telephonyNumber VARCHAR(1000) null,
	externalModifiedDate DATE null,
	externalCreatedDate DATE null,
	rowProcessed VARCHAR(75) null
);

create table OTH_ClientGroup (
	clientGroupId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	externalClientGroupId LONG,
	clientId LONG,
	clientGroup VARCHAR(75) null,
	clientGroupName VARCHAR(1000) null,
	rowProcessed VARCHAR(75) null
);

create table OTH_DataRequest (
	dataRequestId LONG not null primary key,
	clientId LONG,
	caseId LONG,
	externalCaseId LONG,
	type_ VARCHAR(75) null,
	lastUpdatedDate DATE null
);

create table OTH_Member (
	memberId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	externalMemberId LONG,
	clientId LONG,
	clientGroupId LONG,
	memberNumber VARCHAR(1000) null,
	memberFirstName VARCHAR(1000) null,
	memberLastName VARCHAR(1000) null,
	memberDOB DATE null,
	certificationNumber VARCHAR(1000) null,
	rxNumber VARCHAR(1000) null,
	externalModifiedDate DATE null,
	externalCreatedDate DATE null,
	rowProcessed VARCHAR(75) null
);

create table OTH_Note (
	uuid_ VARCHAR(75) null,
	noteId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	caseId LONG,
	externalNoteId LONG,
	type_ VARCHAR(75) null,
	noteType VARCHAR(75) null,
	text_ STRING null,
	noteCreateDate DATE null,
	caller VARCHAR(1000) null,
	callee VARCHAR(1000) null,
	direction VARCHAR(1000) null,
	code_ VARCHAR(75) null,
	processStatus VARCHAR(75) null,
	failureDescription VARCHAR(75) null,
	userId LONG,
	noteAuthor VARCHAR(1000) null,
	rowProcessed VARCHAR(75) null
);

create table OTH_ReferenceTypeCode (
	referenceTypeCodeId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	externalReferenceTypeCodeId LONG,
	type_ VARCHAR(1000) null,
	key_ VARCHAR(1000) null,
	description STRING null,
	rowProcessed VARCHAR(75) null
);

create table OTH_StagingAuthProcedure (
	stagingAuthProcedureId LONG not null primary key,
	createDate DATE null,
	modifiedDate DATE null,
	externalAuthorizationId LONG,
	authNumber VARCHAR(75) null,
	medicalCodeId VARCHAR(75) null,
	description VARCHAR(2000) null,
	externalModifiedDate VARCHAR(75) null,
	externalCreatedDate VARCHAR(75) null
);

create table OTH_StagingAuthorization (
	stagingAuthorizationId LONG not null primary key,
	createDate DATE null,
	externalCaseId LONG,
	externalAuthorizationId LONG,
	externalMemberId LONG,
	description STRING null,
	rtcAuthorizationStatus VARCHAR(75) null,
	authStatus VARCHAR(75) null,
	statusChangeDate VARCHAR(75) null,
	receivedDate VARCHAR(75) null,
	authNumber VARCHAR(75) null,
	category VARCHAR(1000) null,
	rtcAuthorizationType VARCHAR(75) null,
	facility VARCHAR(1000) null,
	procedureCode STRING null,
	comments STRING null,
	effectiveFrom VARCHAR(75) null,
	effectiveThru VARCHAR(75) null,
	externalCreateDate VARCHAR(75) null,
	externalModifiedDate VARCHAR(75) null
);

create table OTH_StagingCases (
	stagingCaseId LONG not null primary key,
	createDate DATE null,
	externalCaseId VARCHAR(75) null,
	externalClientPk VARCHAR(75) null,
	clientGroupId VARCHAR(75) null,
	caseNumber VARCHAR(75) null,
	caseStartDate VARCHAR(75) null,
	caseEndDate VARCHAR(75) null,
	memberId VARCHAR(75) null,
	primaryDiagCode VARCHAR(1000) null,
	primaryCode VARCHAR(1000) null,
	status VARCHAR(75) null,
	estimateEntryDate VARCHAR(75) null,
	caseManager VARCHAR(75) null,
	consentReceivedDate VARCHAR(75) null,
	medicalPlan VARCHAR(1000) null,
	costEstimate VARCHAR(75) null,
	lastUpdated VARCHAR(75) null,
	externalCreatedDate VARCHAR(75) null,
	chargedAmount VARCHAR(75) null,
	paidAmount VARCHAR(75) null,
	repricedAmount VARCHAR(75) null,
	savingsAmount VARCHAR(75) null,
	savingsPercent VARCHAR(75) null,
	treatingPhysician VARCHAR(1000) null,
	primaryFacility VARCHAR(1000) null,
	rowProcessed BOOLEAN
);

create table OTH_StagingClaim (
	stagingClaimId LONG not null primary key,
	createDate DATE null,
	modifiedDate DATE null,
	externalClaimId LONG,
	claimRef VARCHAR(75) null,
	authorizationNumber VARCHAR(75) null,
	serviceFrom VARCHAR(75) null,
	serviceThru VARCHAR(75) null,
	provider VARCHAR(75) null,
	prioritizedBill VARCHAR(75) null,
	diagCodesCombined STRING null,
	providerState VARCHAR(75) null,
	tpmReceivedDate VARCHAR(75) null,
	claimTurnaround LONG,
	billType STRING null,
	providerNetwork VARCHAR(1000) null,
	repricedNetwork VARCHAR(1000) null,
	statusSortOrder LONG,
	paidDate VARCHAR(75) null,
	paidAmount DOUBLE,
	claimStatus VARCHAR(75) null,
	externalModifiedDate VARCHAR(75) null,
	externalCreatedDate VARCHAR(75) null
);

create table OTH_StagingClaimDetail (
	stagingClaimDetailId LONG not null primary key,
	createDate DATE null,
	modifiedDate DATE null,
	lineId LONG,
	externalClaimId LONG,
	serviceFrom VARCHAR(75) null,
	serviceThru VARCHAR(75) null,
	resultCodes STRING null,
	procedureCode VARCHAR(1000) null,
	chargedAmount DOUBLE,
	repricedAmount DOUBLE,
	claimAmount DOUBLE,
	paidDate VARCHAR(75) null,
	paidAmount DOUBLE,
	savingsAmount DOUBLE,
	units INTEGER,
	coverage VARCHAR(75) null,
	lineStatus VARCHAR(75) null,
	revCode VARCHAR(1000) null,
	externalModifiedDate VARCHAR(75) null,
	externalCreatedDate VARCHAR(75) null
);

create table OTH_StagingClient (
	stagingClientId LONG not null primary key,
	createDate DATE null,
	modifiedDate DATE null,
	externalClientPk VARCHAR(75) null,
	clientId VARCHAR(75) null,
	clientName VARCHAR(1000) null,
	telephonyNumber VARCHAR(1000) null,
	externalModifiedDate VARCHAR(75) null,
	externalCreatedDate VARCHAR(75) null,
	rowProcessed BOOLEAN
);

create table OTH_StagingClientGroup (
	stagingClientGroupId LONG not null primary key,
	createDate DATE null,
	modifiedDate DATE null,
	externalClientGroupId LONG,
	clientId LONG,
	clientGroup VARCHAR(75) null,
	clientGroupName VARCHAR(1000) null,
	externalModifiedDate VARCHAR(75) null,
	externalCreatedDate VARCHAR(75) null
);

create table OTH_StagingMember (
	stagingMemberId LONG not null primary key,
	createDate DATE null,
	modifiedDate DATE null,
	externalMemberId LONG,
	clientId LONG,
	clientGroupId LONG,
	memberNumber VARCHAR(1000) null,
	memberFirstName VARCHAR(1000) null,
	memberLastName VARCHAR(1000) null,
	memberDOB VARCHAR(75) null,
	certificationNumber VARCHAR(1000) null,
	rxNumber VARCHAR(1000) null,
	externalModifiedDate VARCHAR(75) null,
	externalCreatedDate VARCHAR(75) null
);

create table OTH_StagingNote (
	noteId LONG not null primary key,
	createDate DATE null,
	modifiedDate DATE null,
	externalCaseId LONG,
	caseNoteID LONG,
	type_ VARCHAR(75) null,
	noteType VARCHAR(75) null,
	noteText STRING null,
	noteCreateDate VARCHAR(75) null,
	direction VARCHAR(1000) null,
	code_ VARCHAR(75) null,
	caller VARCHAR(1000) null,
	callee VARCHAR(1000) null,
	externalCreateDate VARCHAR(75) null,
	externalModifiedDate VARCHAR(75) null,
	noteAuthor VARCHAR(1000) null
);

create table OTH_StagingReferenceTypeCode (
	stagingReferenceTypeCodeId LONG not null primary key,
	createDate DATE null,
	modifiedDate DATE null,
	externalReferenceTypeCodeId LONG,
	type_ VARCHAR(1000) null,
	key_ VARCHAR(1000) null,
	description STRING null,
	externalModifiedDate VARCHAR(75) null,
	externalCreatedDate VARCHAR(75) null
);

create table OTH_StagingTask (
	taskId LONG not null primary key,
	createDate DATE null,
	modifiedDate DATE null,
	externalCaseId LONG,
	externalTaskId LONG,
	priority VARCHAR(75) null,
	startDate VARCHAR(75) null,
	endDate VARCHAR(75) null,
	dueDate VARCHAR(75) null,
	taskStatus VARCHAR(75) null,
	description STRING null,
	completedFlag VARCHAR(75) null,
	externalCreateDate VARCHAR(75) null,
	externalModifiedDate VARCHAR(75) null
);

create table OTH_Task (
	uuid_ VARCHAR(75) null,
	taskId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	createDate DATE null,
	createdUserId LONG,
	modifiedDate DATE null,
	caseId LONG,
	externalTaskId LONG,
	priority VARCHAR(75) null,
	startDate DATE null,
	endDate DATE null,
	dueDate DATE null,
	taskStatus VARCHAR(75) null,
	description STRING null,
	processStatus VARCHAR(75) null,
	failureDescription VARCHAR(75) null,
	rowProcessed VARCHAR(75) null
);