final filePath = 'd:/1.txt'
final file = new File(filePath)
while(!file.exists()){
    println "waiting for ${filePath}"
    sleep(10000)
}
println "${filePath} can be read?: ${file.canRead()}" 