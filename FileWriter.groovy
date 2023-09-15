        def xeroWorkflowTheme = new File('D:/','xeroWorkflow.properties')
        xeroWorkflowTheme.withWriter('utf-8') {
            writer -> L: {
                writer.writeLine  "theme.inherit=_DEFAULTXeroWorkflow,siteTheme"
                writer.writeLine  "workflowLogLevel=off"
                writer.writeLine  "name=xeroWorkflow"
                writer.writeLine  "workflowProperty_1=workflowAE"
                writer.writeLine  "workflowProperty_2=workflowLogLevel"
                writer.writeLine  "workflowProperty_3=theme"
                writer.writeLine  "workflowProperty_4=workflowKey"
                writer.writeLine  "studyTabTextAttachments=ACTIONITEMS,ACTIONHISTORY"
                writer.writeLine  "workflowProperty_5=studyTabTextAttachments"
                writer.writeLine  "id=XTHEME1201"
            }
        }
        println xeroWorkflowTheme

	xeroWorkflowTheme = new File('D:/','xeroWorkflow.properties')
	xeroWorkflowTheme.withWriter('utf-8') {
            writer -> L: {
                writer.writeLine  "integration_1={'name':'testbutton', 'integrationId':'testbuttonid', 'url':'https://cn.bing.com?studyUID={studyUID}&patientIdentifier={patientIdentifier}&assignAuthority={assignAuthority}', 'authType':'none', 'anchor':{'anchorPositions':['LIST_AREA_TOOLBAR', 'LIST_AREA_CONTEXT_MENU', 'TEXT_AREA_ACTION_MENU', 'PATIENT_HISTORY_AREA_TOOLBAR'], 'representationMode':'DIALOG', 'label':'open test button', 'isMultiple':'true', 'suffixParamsUrl':'&studyUID={studyUID}&taskId={taskId}&accessionNumber={accessionNumber}&patientIdentifier={patientIdentifier}&assignAuthority={assignAuthority}'}}"
            }
        }
        println xeroWorkflowTheme

