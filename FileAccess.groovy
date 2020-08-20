    wait4FileAccess('d:/1.txt', 1)

    private wait4FileAccess(String filePath, float timeOutInMins) {
        println "Checking ${filePath}"
        final file = new File(filePath)
        wait({file.exists()}, timeOutInMins, "failed to access ${filePath}")
        println "${filePath} can be read?: ${file.canRead()}" 
    }

    // private wait4PortOpen(int port, double timeOutInMins) {
    //     int checkingInterval = 6000
    //     double checkingIntervalInMins = (0.0 + checkingInterval) / 1000 / 60
    //     while (!isPortOpen(localHostname, 14200)) {
    //         sleep(checkingInterval)
    //         timeOutInMins -= checkingIntervalInMins
    //         if (timeOutInMins > 0) {
    //             println "waiting ${filePath} for ${timeOutInMins} minutes"
    //         } else {
    //             break
    //         } 
    //     }
    // }

    private wait(Closure until, float timeOutInMins, String failureMsg) {
        float checkingIntervalInMins = 0.1
        int checkingInterval = 0.1 * 60 * 1000
        while (!until()) {
            sleep(checkingInterval)
            timeOutInMins -= checkingIntervalInMins
            if (timeOutInMins > 0) {
                println "waiting for ${timeOutInMins} minutes"
            } else {
                println failureMsg
                break
            } 
        }
    }