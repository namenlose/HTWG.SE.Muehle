package HTWG.SE.Muehle.model.FileIO.FileIOJSON

import com.google.inject.Guice
import com.google.inject.name.Names
import net.codingwell.scalaguice.InjectorExtensions._
import HTWG.SE.Muehle.MuehleModule
import HTWG.SE.Muehle.model.FieldComponent.{FieldInterface, FieldArrayInterface}
import play.api.libs.json._
import HTWG.SE.Muehle.model.FileIO.FileIOInterface
import java.io._
import HTWG.SE.Muehle.model.FieldComponent.FieldBaseComponent.FieldArray

import scala.io.Source

class FileIOJason extends FileIOInterface {
    def save(field: FieldArrayInterface, counter: Int): Unit = {
        val pw = new PrintWriter(new File("field.json"))
        val json = fieldArrayToJson(field)  // Corrected method name
        val jsonString = Json.prettyPrint(json)

        pw.write(jsonString)
        pw.close
    }
    def fieldArrayToJson(array: FieldArrayInterface): JsObject = {
        Json.obj (
            "field" -> Json.obj(
                "array0" -> Json.toJson(array.fieldArray(0).mkString),
                "array1" -> Json.toJson(array.fieldArray(1).mkString),
                "array2" -> Json.toJson(array.fieldArray(2).mkString)
            )
        )
    }

  def load: FieldArrayInterface = {
    val fileContent = Source.fromFile("field.json").mkString
    val json = Json.parse(fileContent)

    val array0 = (json \ "field" \ "array0").as[String].toArray
    val array1 = (json \ "field" \ "array1").as[String].toArray
    val array2 = (json \ "field" \ "array2").as[String].toArray

    val arrayEingelesen: Array[Array[Char]] = Array(array0, array1, array2)

    val array: FieldArrayInterface = new FieldArray
    for (i <- 0 to 2) {
      for (x <- 0 to 7) {
        array.fieldArray(i)(x) = arrayEingelesen(i)(x)
      }
    }
    array
  }

  var counter: Int = 0

}

