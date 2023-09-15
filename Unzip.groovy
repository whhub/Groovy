import java.nio.file.*
import java.util.zip.*

//UnZip archive

def zip = new ZipFile(new File('D:/chromedriver.zip'))
zip.entries().each{  
  if (!it.isDirectory()){
    def fullPath = new File("D:/${it.name}")
    def fOut = new File("D:/${fullPath.name}")
    //create output dir if not exists
    //new File(fOut.parent).mkdirs()

    InputStream is = zip.getInputStream(it);
    Files.copy(is, fOut.toPath(), StandardCopyOption.REPLACE_EXISTING);
  }
}
zip.close()

//https://gist.github.com/bitsnaps/00947f2dce66f4bbdabc67d7e7b33681
//https://stackoverflow.com/questions/645847/unzip-archive-with-groovy