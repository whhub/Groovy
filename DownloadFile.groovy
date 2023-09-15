final url = "https://edgedl.me.gvt1.com/edgedl/chrome/chrome-for-testing/116.0.5845.96/win32/chromedriver-win32.zip"
final seleniumPath = 'C:/jenkins/eici/ei/ei-angular/node_modules/webdriver-manager/selenium'
new File(seleniumPath).mkdirs()
new File("${seleniumPath}/chromedriver_116.0.5845.96.zip").withOutputStream { out ->
	new URL(url).withInputStream { from ->  out << from; }
  }
//https://stackoverflow.com/questions/4674995/groovy-download-image-from-url