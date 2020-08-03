final eiangualrPath = "d:/dev/ei-angular"
final diskDriverPath = eiangualrPath[0..1]
final nodeModulesPath = eiangualrPath + '/node_modules/.bin'
println nodeModulesPath
//new Command("jayson -s 127.0.0.1:14200 -m stopServer -p []").workingDirectory(nodeModulesPath).start()
final stopWebTestsDataServerCommand = "cmd /c ${diskDriverPath} && cd ${nodeModulesPath} && jayson -s 127.0.0.1:14200 -m stopServer -p []"
println stopWebTestsDataServerCommand
stopWebTestsDataServerCommand.execute()