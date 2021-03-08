        def xeroWorkflowTheme = new File(System.getProperty("java.io.tmpdir"),'xeroWorkflow.properties')
        xeroWorkflowTheme.withWriter('utf-8') {
            writer -> L: {
                writer.writeLine  "theme.inherit=_DEFAULTXeroWorkflow,siteTheme"
                writer.writeLine  "workflowLogLevel=off"
                writer.writeLine  "name=xeroWorkflow"
                writer.writeLine  "workflowProperty_1=workflowAE"
                writer.writeLine  "workflowProperty_2=workflowLogLevel"
                writer.writeLine  "workflowProperty_3=theme"
                writer.writeLine  "workflowProperty_4=workflowKey"
                writer.writeLine  "studyTabTextAttachments=REASONFORSTUDY,CLINICALINFO,ACTIONITEMS,ACTIONHISTORY,PROCEDURECOMMENT"
                writer.writeLine  "workflowProperty_5=studyTabTextAttachments"
                writer.writeLine  "workflowProperty_14=notForRelease"
                writer.writeLine  "notForRelease=true"
                writer.writeLine  "id=XTHEME1201"
            }
        }