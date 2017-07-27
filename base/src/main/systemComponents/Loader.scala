package systemComponents
import java.io.File
import java.nio.file.{Path, Paths}

import util.FileType
import util.FileType.FileType

/**
  * Created by jwang on 7/17/2017.
  */
trait Loader extends Logging {
  var input: String
  var inputFileType: FileType
  var output: (Any,List[Any])

  def init(): Unit = {
    init(input)
  }

  def init(path : String): Unit = {
    input = path
    validateInputDir()
    determineFileType()
  }

  def validateInputDir(): String = {
    val path = Paths.get(input)
    val f = path.toFile
    if (!f.exists){
      logCheckPrint("Input file " + input + " does not exist.")
      throw new Exception("Input file " + input + " does not exist.")
    }
    if (f.isDirectory){
      logCheckPrint("Input file " + input + " is a directory.")
      throw new Exception("Input file " + input + " is a directory.")
    }
    if (!f.canRead){
      logCheckPrint("Cannot read from input file " + input)
      throw new Exception("Cannot read from input file " + input)
    }

    input
  }

  def process(): Unit

  def determineFileType():Unit = {
    inputFileType = FileType.getFileType(input)
  }

  def getFileName(path: String): String = {
    val p = Paths.get(path)
    p.toFile.getName
  }

  def getFileName(): String = {
    val p = Paths.get(input)
    p.toFile.getName
  }

  def getProcessingResult(): (Any,List[Any])= {
    if(output == null || output._2.isEmpty) {
      logCheckPrint("Processing result for " + input + " is empty.")
    }
    output
  }

//  def validateField()
//
//  def resolveConflicts()

}
