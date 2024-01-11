package HTWG.SE.Muehle.model.FileIO.FielIOXml

import com.google.inject.Guice
import com.google.inject.name.Names
import net.codingwell.scalaguice.InjectorExtensions._
import scala.xml.{ NodeSeq, PrettyPrinter }
import HTWG.SE.Muehle.model.FieldComponent.{FieldArrayInterface, FieldInterface}
import HTWG.SE.Muehle.model.FileIO.FileIOInterface
import HTWG.SE.Muehle.model.FieldComponent.FieldBaseComponent.FieldArray


class FileIOXml extends FileIOInterface {

  var counter: Int = 0
  def save(array: FieldArrayInterface, counter: Int): Unit ={
    import java.io._
    val pw = new PrintWriter(new File("field.xml"))
    val prettyPrinter = new PrettyPrinter(120, 4)
    val xml = prettyPrinter.format(fieldArrayToXML(array, counter))
    pw.write(xml)
    pw.close  
  }

  def fieldArrayToXML(array: FieldArrayInterface, counter: Int) = {
    <field><array0>{
      for {
        x <- array.fieldArray(0)
       } yield x
    }
    </array0><array1>{
      for {
        x <- array.fieldArray(1)
       } yield x
    }
    </array1><array2>{
      for {
        x <- array.fieldArray(2)
       } yield x
    }
    </array2><counter>{
      counter
    }</counter></field>
  }

  def load: FieldArrayInterface = {
    var array: FieldArray = new FieldArray
    val file = scala.xml.XML.loadFile("field.xml")
    val string0: String = (file \\ "field" \ "array0").text
    val string1: String = (file \\ "field" \ "array1").text
    val string2: String = (file \\ "field" \ "array2").text
    counter = (file \\ "field" \ "counter").text.toInt
    val arrayEingelesen: Array[Array[Char]] = Array(string0.toArray, string1.toArray, string2.toArray)

    for (i <- 0 to 2){
      for (x <- 0 to 7){
        array.fieldArray(i)(x) = arrayEingelesen(i)(x)
      }
  }
    array
  }

  def save(array: FieldArrayInterface): Unit = {" "}
}