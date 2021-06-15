create index IX_46094D8F on OTH_AuthProcedure (authNumber[$COLUMN_LENGTH:75$], medicalCodeId[$COLUMN_LENGTH:75$]);
create index IX_214C5D04 on OTH_AuthProcedure (externalAuthorizationId);
create index IX_99F6C1F4 on OTH_AuthProcedure (medicalCodeId[$COLUMN_LENGTH:75$]);

create index IX_6D42A168 on OTH_Authorization (authNumber[$COLUMN_LENGTH:75$]);
create index IX_A713DEC2 on OTH_Authorization (caseId);
create index IX_35B489D6 on OTH_Authorization (externalAuthorizationId);
create index IX_173DFD66 on OTH_Authorization (rowProcessed[$COLUMN_LENGTH:75$], processStatus[$COLUMN_LENGTH:75$]);
create index IX_D1BE43D7 on OTH_Authorization (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_B4E3D419 on OTH_Authorization (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_5DA53C67 on OTH_Cases (clientId);
create index IX_15C986F7 on OTH_Cases (externalCaseId);
create index IX_705D8DD7 on OTH_Cases (groupId, clientId);
create index IX_C1EE81B5 on OTH_Cases (rowProcessed[$COLUMN_LENGTH:75$]);
create index IX_C913E9A1 on OTH_Cases (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_981C6463 on OTH_Cases (uuid_[$COLUMN_LENGTH:75$], groupId);

create unique index IX_C26E20E0 on OTH_CasesGroupItem (externalCaseId, userId, type_[$COLUMN_LENGTH:75$]);
create index IX_C42B2782 on OTH_CasesGroupItem (groupId, userId, type_[$COLUMN_LENGTH:75$]);

create index IX_DD99A2EC on OTH_Claim (authorizationNumber[$COLUMN_LENGTH:75$]);
create index IX_3EE99C11 on OTH_Claim (claimRef[$COLUMN_LENGTH:75$]);
create index IX_6E342CAE on OTH_Claim (rowProcessed[$COLUMN_LENGTH:75$]);

create index IX_94352B65 on OTH_ClaimDetail (externalClaimId);
create index IX_3885A8BA on OTH_ClaimDetail (lineId);
create index IX_F7EEC71F on OTH_ClaimDetail (rowProcessed[$COLUMN_LENGTH:75$]);

create index IX_CAAB0952 on OTH_Client (externalClientId);
create index IX_CAAE5232 on OTH_Client (externalClientPk);
create index IX_48B9CF75 on OTH_Client (rowProcessed[$COLUMN_LENGTH:75$]);

create index IX_973167B6 on OTH_ClientGroup (externalClientGroupId);
create index IX_1C4E82E6 on OTH_ClientGroup (rowProcessed[$COLUMN_LENGTH:75$]);

create index IX_56850F0C on OTH_DataRequest (clientId, type_[$COLUMN_LENGTH:75$]);
create index IX_E809ABFC on OTH_DataRequest (externalCaseId, type_[$COLUMN_LENGTH:75$]);

create index IX_EBBBB9F0 on OTH_Member (externalMemberId);
create index IX_DCD7E844 on OTH_Member (rowProcessed[$COLUMN_LENGTH:75$]);

create index IX_26C8561E on OTH_Note (caseId, processStatus[$COLUMN_LENGTH:75$]);
create index IX_FACEEBD1 on OTH_Note (externalNoteId, processStatus[$COLUMN_LENGTH:75$]);
create index IX_446A4795 on OTH_Note (rowProcessed[$COLUMN_LENGTH:75$], processStatus[$COLUMN_LENGTH:75$]);
create index IX_A47A8108 on OTH_Note (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_AF3FA98A on OTH_Note (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_1108D170 on OTH_ReferenceTypeCode (key_[$COLUMN_LENGTH:1000$]);
create index IX_97802F24 on OTH_ReferenceTypeCode (rowProcessed[$COLUMN_LENGTH:75$]);
create index IX_DCF0DB9 on OTH_ReferenceTypeCode (type_[$COLUMN_LENGTH:1000$]);

create index IX_D05FE92A on OTH_StagingAuthorization (externalCaseId);

create index IX_825D4674 on OTH_StagingCases (externalCaseId[$COLUMN_LENGTH:75$]);
create index IX_3275FC72 on OTH_StagingCases (rowProcessed);

create index IX_5C05308A on OTH_StagingClient (clientId[$COLUMN_LENGTH:75$]);
create index IX_E921AC58 on OTH_StagingClient (rowProcessed);

create index IX_34377B59 on OTH_StagingClientGroup (externalClientGroupId);

create index IX_29546D53 on OTH_StagingMember (externalMemberId);

create index IX_C5002BEB on OTH_Task (caseId, processStatus[$COLUMN_LENGTH:75$]);
create index IX_E03A182B on OTH_Task (externalTaskId, processStatus[$COLUMN_LENGTH:75$]);
create index IX_90BCFA2 on OTH_Task (rowProcessed[$COLUMN_LENGTH:75$], processStatus[$COLUMN_LENGTH:75$]);
create index IX_42DD7F1B on OTH_Task (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_1061105D on OTH_Task (uuid_[$COLUMN_LENGTH:75$], groupId);