        def releaseVersion = "8.1.5.100"
        def setPeterAsClinician = "setUserGroup('PETER', 'Clinician');"
        def userConfiguration = releaseVersion.compareToIgnoreCase("8.1.5.100") >= 0 ? "" : setPeterAsClinician
        def query  = """
DECLARE PROCEDURE setUserGroup(userLoginName varchar2, externalRoleName varchar2) IS
userId number;
roleId number;
BEGIN
SELECT id INTO userId FROM sec_user_domain WHERE EXTERNAL_LOGIN_NAME = userLoginName;
SELECT id INTO roleId FROM SEC_EXTERNAL_ROLE WHERE NAME = externalRoleName;
insert into SEC_USER_DOMAIN_MAPPING (SEC_USER_DOMAIN, SEC_EXTERNAL_ROLE) VALUES (userId, roleId);
END;

PROCEDURE insertQueryList(sQueryCode VARCHAR2, sQueryLabel VARCHAR2, nListType INTEGER, sQueryDefinitionName VARCHAR2) IS
    nQueryDefinitionId NUMBER;
    nQueryInstanceId NUMBER;
    nQueryListId NUMBER;
    nNameId NUMBER;

  BEGIN
    
    select LOCALISABLE_PKS.nextval INTO nNameId from dual;
    insert into LOCALISABLE (ID,NAME,NAME_SOUNDEX,STRING_ID) 
			values (nNameId,sQueryLabel, upper(replace(sQueryLabel, ' ', '')), 'QUERY_LIST'||'.'||upper(sQueryCode));
      
    select ID INTO nQueryDefinitionId from QUERY_DEFINITION where XML_FILE_NAME = sQueryDefinitionName;
    select QUERY_INSTANCE_PKS.nextval INTO nQueryInstanceId from dual;
    insert into QUERY_INSTANCE (ID, QUERY_DEFINITION)
      values (nQueryInstanceId, nQueryDefinitionId);
      
    select QUERY_LIST_PKS.nextval INTO nQueryListId from dual;
    insert into QUERY_LIST (ID, CODE, LABEL, LIST_TYPE, QUERY_INSTANCE, ACTIVE, IS_AUTO_REFRESH_ENABLED, AUTO_REFRESH_INTERVAL, IS_NOTIFICATION_ENABLED,SET_ON_LEVEL)
      values(nQueryListId, sQueryCode, nNameId, nListType, nQueryInstanceId, 1, 0, 1, 1,0);
  END;

PROCEDURE linkQueryList(sWorkschemaCode VARCHAR2, sCategoryLabel VARCHAR2, sQueryCode VARCHAR2, nSequenceNumber INTEGER, bIncludeInCompositeList NUMBER) IS
    nWorkschemaId NUMBER;
    nCategoryId NUMBER;
    nQueryListId NUMBER;
    TYPE my_cursor IS REF CURSOR;
    id_select my_cursor;
BEGIN
    SELECT ID INTO nQueryListId from QUERY_LIST where CODE = sQueryCode;
    SELECT id INTO nWorkschemaId FROM WORKSCHEMA WHERE CODE = sWorkschemaCode;
		OPEN id_select FOR 'select wc.ID from WORKSCHEMA_CATEGORY wc,LOCALISABLE l
							where l.id = wc.label
							and wc.WORKSCHEMA = :nWorkschemaId
							and l.NAME = :sCategoryLabel' USING nWorkschemaId,sCategoryLabel;
		FETCH id_select INTO nCategoryId;
		CLOSE id_select;
    insert into WORKSCHEMA_CATEGORY_LIST (ID, WORKSCHEMA_CATEGORY, QUERY_LIST, SEQUENCE, INCLUDE_IN_COMPOSITE_LIST)
		values (WORKSCHEMA_CATEGORY_LIST_PKS.nextval, nCategoryId, nQueryListId, nSequenceNumber, bIncludeInCompositeList);
END;

PROCEDURE insertQueryFilterBinding(sQueryCode VARCHAR2, nFilterGroupSequenceNr NUMBER, nFilterSequenceNr NUMBER, sFilterParam VARCHAR2, nType INTEGER, sStringValue VARCHAR2,nNumberValue NUMBER, sOperator VARCHAR2) IS
    nQueryInstanceId NUMBER;
    nGroupId NUMBER;
	nNumberValue2 NUMBER;
	sStringValue2 VARCHAR2(512);
    TYPE my_cursor IS REF CURSOR;
    id_select my_cursor;
  BEGIN
    SELECT QUERY_INSTANCE INTO nQueryInstanceId from QUERY_LIST where CODE = sQueryCode;
    SELECT QUERY_FILTERBINDINGGROUP_PKS.nextval INTO nGroupId FROM dual;
    insert into QUERY_FILTERBINDINGGROUP(ID,QUERY_INSTANCE, SEQUENCE)
				values (nGroupId,nQueryInstanceId, nFilterGroupSequenceNr);
  
    IF sFilterParam = 'labelId' THEN
      OPEN id_select FOR 'select l.ID from lOCALISABLE ll, label l where ll.string_id = ''LABEL.''||upper(:sQueryCode) and ll.id = l.name' USING sQueryCode;
      FETCH id_select INTO nNumberValue2;
      CLOSE id_select;
      sStringValue2 := sStringValue;
    ELSIF sFilterParam in ('srStudyDatePeriod', 'srTaskPerformedPeriod','scheduledProcedureDatePeriod','srDateRequestedPeriod', 'recentlyViewedStudiesDatePeriod') THEN
      OPEN id_select FOR 'Select ID from Period where code = :sStringValue' USING sStringValue;
      FETCH id_select INTO nNumberValue2;
      CLOSE id_select;
      sStringValue2 := null;
    ELSE
      sStringValue2 := sStringValue;
      nNumberValue2 := nNumberValue;
    END IF;      
                
    INSERT INTO QUERY_FILTERBINDING(ID,QUERY_FILTERBINDINGGROUP, FILTERPARAM, SEQUENCE, QUERY_MV_FILTERBINDING, MV_SEQUENCE, DATA_TYPE, STRING_VALUE, NUMBER_VALUE,TIMESTAMP_VALUE, OPERATOR)
			VALUES (QUERY_FILTERBINDING_PKS.nextval, nGroupId, sFilterParam, nFilterSequenceNr, null, null, nType, sStringValue2, nNumberValue2, NULL, sOperator);

END;

PROCEDURE insertRecentlyList IS
    nQueryListCount NUMBER;
    sQueryCode VARCHAR2(512);
  BEGIN
    sQueryCode := 'qlRecentlyViewedStudiesToday';
    SELECT COUNT(ID) INTO nQueryListCount FROM QUERY_LIST WHERE CODE = sQueryCode;
    IF nQueryListCount = 0 THEN
        insertQueryList(sQueryCode,'My recently viewed studies',1,'searchRequestedProceduresAndTasks');
        insertQueryFilterBinding(sQueryCode,0,0,'recentlyViewedStudiesDatePeriod',1,'TODAY',null,'IS');
        LinkQueryList('wsActivityOverview','Follow-up',sQueryCode,3,0);
        LinkQueryList('wsModalityOverview','Follow-up',sQueryCode,3,0);
    END IF;
  END;

BEGIN
${userConfiguration}
insertRecentlyList();
END;

        """

println query