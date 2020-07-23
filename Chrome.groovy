        // def chromeDirCmd = '''cmd /c dir /B/AD "C:/Program Files (x86)/Google/Chrome/Application/"'''

        // println chromeDirCmd

        // final chromeDirText = chromeDirCmd.execute().text
        final chromeDirText = new File("C:/Program Files (x86)/Google/Chrome/Application/").list()
        def m = chromeDirText =~ /[0-9]+.*\..*[0-9]+/
        def chromeVersion = m.find() ? m.group():null

        println "chrome version: $chromeVersion"