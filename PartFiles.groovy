def specDir = new File("D:/dev/ei-monorepo/ei-angular/apps/ei-web-e2e/src/spec/solution")
def files = specDir.listFiles()
println files[]
def parts =  '5'.isInteger() ? '5' as Integer : 1
def fileCount = files.length
def partSize = fileCount.intdiv(parts)
println partSize

for(int part=1; part<=parts; part++) {
	println part
	def start = (part-1) * partSize
	def end = part == parts ? -1 : part * partSize - 1
	files[start..end].each{file-> println file.name}

	def specOptions = []
	files[start..end].each {specOptions << "--specs=${it.getAbsolutePath()}" }
	println specOptions.join(' ')
}