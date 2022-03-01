def timestamp = System.currentTimeMillis()
new File("F:/Downloads").eachFileRecurse {
        println "+++${it.path}+++"
        it.lastModified = timestamp }