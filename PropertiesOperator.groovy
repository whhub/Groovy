// read
props = new Properties()
propsFile = new File("C:\\Xero_Server\\server\\standalone\\configuration\\xero\\themes\\xeroWorkflow.properties")
props.load(propsFile.newDataInputStream())

// write
props.setProperty('workflowProperty_5', 'studyTabTextAttachments')
props.setProperty('studyTabTextAttachments', 'ACTIONITEMS,ACTIONHISTORY')
props.store(propsFile.newWriter(), null)