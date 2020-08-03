final jar_path = 'd:/dev/monorepo/ei-monorepo/asb/tests/webtests-data-server/build/libs/webtests-data-server.jar'
final cmd = "java -jar $jar_path"
println cmd
//cmd.execute()
//def process 
//process = cmd.execute()
final thread = Thread.start {
    cmd.execute
}
if(thread?.isAlive()){
    thread?.stop()
}
//process?.destroy()
