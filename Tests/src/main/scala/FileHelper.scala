package main.scala

import java.io._

object FileHelper {
  def readTextFromFile(filename: String): String = {
    val file: File = new File(filename)
    val contents: StringBuffer = new StringBuffer
    var reader: BufferedReader = null
    try {
      reader = new BufferedReader(new FileReader(file))
      var text: String = null
      while ((({
        text = reader.readLine; text
      })) != null) {
        contents.append(text).append(System.getProperty("line.separator"))
      }
    }
    catch {
      case e: FileNotFoundException => {
        e.printStackTrace
      }
      case e: IOException => {
        e.printStackTrace
      }
    }
    finally {
      try {
        if (reader != null) {
          reader.close
        }
      }
      catch {
        case e: IOException => {
          e.printStackTrace
        }
      }
    }
    return contents.toString
  }
}