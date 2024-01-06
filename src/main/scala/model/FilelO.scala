package HTWG.SE.Muehle.model

import com.google.inject.Guice
import com.google.inject.name.Names
import net.codingwell.scalaguice.InjectorExtensions._
import HTWG.SE.Muehle.MuehleModule
import HTWG.SE.Muehle.model.FieldComponent.{FieldInterface, FieldArrayInterface}
import play.api.libs.json._
import HTWG.SE.Muehle.model.FileIOInterface
import java.io._

import scala.io.Source

class FilelO extends FileIOInterface {
    def save(field: FieldArrayInterface): Unit = {
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
}
