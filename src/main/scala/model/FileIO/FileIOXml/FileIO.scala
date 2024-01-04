package HTWG.SE.Muehle.model.FileIO.FielIOXml

import com.google.inject.Guice
import com.google.inject.name.Names
import net.codingwell.scalaguice.InjectorExtensions._
import scala.xml.{ NodeSeq, PrettyPrinter }
import HTWG.SE.Muehle.model.FieldComponent.{FieldArrayInterface, FieldInterface}
import HTWG.SE.Muehle.model.FileIO.FileIOInterface


class FileIO extends FileIOInterface {

  def save(array: FieldArrayInterface): Unit ={
    import java.io._
    val pw = new PrintWriter(new File("C:\\Users\\Sbirk\\Documents\\HTWG\\Software Engeneering\\field.xml"))
    val prettyPrinter = new PrettyPrinter(120, 4)
    val xml = prettyPrinter.format(fieldArrayToXML(array))
    pw.write(xml)
    pw.close  
  }

  def fieldArrayToXML(array: FieldArrayInterface) = {
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
    </array2></field>
  }

}