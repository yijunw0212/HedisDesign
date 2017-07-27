package util

import org.apache.commons.io.FilenameUtils

import scala.reflect.io.Path

/**
  * Created by jwang on 7/18/2017.
  */
object FileType extends Enumeration {
  type FileType = Value
  val XML, JSON, STDOUT, HTML, HADOOPFILE, CSV = Value

  def checkFileType(path: String): String = {
    FilenameUtils.getExtension(path)
  }

  def checkFileType(path: Path): String = {
    FilenameUtils.getExtension(path.toString())
  }

  def getFileType(path: String): FileType = {
    checkFileType(path).toUpperCase() match {
      case "CSV" => CSV
      case "XML" => XML
      case "JSON" => JSON
      case "STDOUT" => STDOUT
      case "HTML" => HTML
      case "FILE" => HADOOPFILE
    }
  }

  def getFileType(path: Path): FileType = {
    getFileType(path.toString())
  }

  //todo add more file types if necessary
}

