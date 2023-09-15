//import groovy.json.JsonSlurper

final chromeDriverVersionUrl = new URL("https://googlechromelabs.github.io/chrome-for-testing/latest-versions-per-milestone.json")
def jsonSlurper = new groovy.json.JsonSlurper()
def object = jsonSlurper.parseText(chromeDriverVersionUrl.text)
println object instanceof Map 
println object.milestones['113']['version'].class