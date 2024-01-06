package HTWG.SE.Muehle.model

import HTWG.SE.Muehle.model.FieldComponent.FieldArrayInterface
import play.api.libs.json.JsObject

trait FileIOInterface {

  def save(field: FieldArrayInterface): Unit
  def fieldArrayToJson(array: FieldArrayInterface): JsObject

}