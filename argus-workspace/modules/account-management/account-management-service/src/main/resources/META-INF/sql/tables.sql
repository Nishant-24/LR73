create table OTH_AMAnalyticsClaim (
	amAnalyticsClaimId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	clientId LONG,
	amAnalyticsClaimDate DATE null,
	avgClaimTurnAround INTEGER,
	minClaimTurnAround INTEGER,
	maxClaimTurnAround INTEGER,
	claimTurnAroundGoal INTEGER,
	overallAvgClaimTurnAround DOUBLE
);

create table OTH_AMAnalyticsDB (
	amAnalyticsDbId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	clientId LONG,
	savingsPercent DOUBLE,
	chargedAmount DOUBLE,
	repricedAmount DOUBLE,
	avgDownTime DOUBLE,
	avgSpeedOfAnswer DOUBLE,
	abandonmentRate DOUBLE,
	claimsTurnaround LONG,
	downTimeGoal DOUBLE,
	speedOfAnswerGoal DOUBLE,
	abandonmentRateGoal DOUBLE,
	claimsTurnaroundGoal DOUBLE
);

create table OTH_AMAnalyticsTelephony (
	amAnalyticsTelephonyId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	createDate DATE null,
	modifiedDate DATE null,
	clientId LONG,
	amAnalyticsTelephonyDate DATE null,
	avgDownTime DOUBLE,
	avgSpeedOfAnswer DOUBLE,
	abandonmentRate DOUBLE,
	downTimeGoal DOUBLE,
	speedAnswerGoal DOUBLE,
	abandonmentRateGoal DOUBLE,
	overallAvgDownTime DOUBLE,
	overallAvgSpeedOfAnswer DOUBLE,
	overallAvgAbandonmentRate DOUBLE
);

create table OTH_StagingAMATelephony (
	stagingAMATelephonyId LONG not null primary key,
	createDate DATE null,
	modifiedDate DATE null,
	clientId LONG,
	amAnalyticsTelephonyDate VARCHAR(75) null,
	avgDownTime DOUBLE,
	avgSpeedOfAnswer DOUBLE,
	abandonmentRate DOUBLE,
	downTimeGoal DOUBLE,
	speedAnswerGoal DOUBLE,
	abandonmentRateGoal DOUBLE,
	overallAvgDownTime DOUBLE,
	overallAvgSpeedOfAnswer DOUBLE,
	overallAvgAbandonmentRate DOUBLE
);

create table OTH_StagingAMAnalyticsClaim (
	stagingAMAnalyticsClaimId LONG not null primary key,
	createDate DATE null,
	modifiedDate DATE null,
	clientId LONG,
	amAnalyticsClaimDate VARCHAR(75) null,
	avgClaimTurnAround INTEGER,
	minClaimTurnAround INTEGER,
	maxClaimTurnAround INTEGER,
	claimTurnAroundGoal INTEGER,
	overallAvgClaimTurnAround DOUBLE
);

create table OTH_StagingAMAnalyticsDB (
	stagingAMAnalyticsDbId LONG not null primary key,
	createDate DATE null,
	modifiedDate DATE null,
	clientId LONG,
	savingsPercent DOUBLE,
	chargedAmount DOUBLE,
	repricedAmount DOUBLE,
	avgDownTime DOUBLE,
	avgSpeedOfAnswer DOUBLE,
	abandonmentRate DOUBLE,
	claimsTurnaround LONG,
	downTimeGoal DOUBLE,
	speedOfAnswerGoal DOUBLE,
	abandonmentRateGoal DOUBLE,
	claimsTurnaroundGoal DOUBLE
);