static final cwphostFileName = 'cwphost.txt'
static final cwphost = "eicwpol8-138.med.agfa.be"
//def cwphostFile = new File(System.getProperty("java.io.tmpdir"), cwphostFileName)
//def cwphostFile = new File(System.getProperty("user.home"), cwphostFileName)
def cwphostFile = new File(System.getProperty("user.dir"), cwphostFileName)

if(cwphostFile.exists()) {
    println "${cwphostFile.path} found"
}else {
    println "${cwphostFile.path} not found"
    cwphostFile.text = cwphost
}

println cwphostFile.text
