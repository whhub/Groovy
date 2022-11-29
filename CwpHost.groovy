static final cwphostFileName = 'cwphost.txt'
static final cwphost = "eicwpol8-138.med.agfa.be"
def cwphostFile = new File(System.getProperty("java.io.tmpdir"), cwphostFileName)

if(cwphostFile.exists()) {
    println "${cwphostFileName} found"
}else {
    println "${cwphostFileName} not found"
    cwphostFile.createNewFile()
    cwphostFile.text = cwphost
}

println cwphostFile.text
