final apps = ['contact-users', 'web-uct', 'attgroup']

apps.each {
    def logDir = "build\\${it}\\e2e-result"
    println logDir
}