String filePath = 'D:/Users/apzbk/Desktop/Run.bat/auto.log'
def file = new File(filePath)
println file.parent
def copyFilePath = file.parent + '/copy/' + file.name
println copyFilePath