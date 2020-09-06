fil = new File("d://Users//apzbk//Downloads//ei-angular//target//ei-web//e2e-result")
println fil.path
println fil.name
println fil.path - fil.name
rename(fil)

def rename(file) {
    if(file.directory) {
        file.eachFile {
            rename(it)
        }
    }
    final srcName = file.name
    final dstName = srcName.replace(' ', '_')
    println "rename $srcName to $dstName"
    file.renameTo(new File(file.name.replace(' ', '_')))
}