package HTWG.SE.Muehle.test.scala.model

import HTWG.SE.Muehle.model.FieldComponent.FieldBaseComponent.{FieldArray, Field}
import HTWG.SE.Muehle.model.FieldComponent.{FieldInterface, FieldArrayInterface}
import HTWG.SE.Muehle.controller.{blackState, whiteState}
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class FieldArraySpec extends AnyWordSpec {

  "A FieldArray" should {
    "allow placing a stone" in {
      val fieldArray = new FieldArray()
      val result = fieldArray.placeStone(0, 0, 'o')
      result should not include "Fehler"
    }

    "allow getting the stone at a position" in {
      val fieldArray = new FieldArray()
      val stone = fieldArray.get(0, 0)
      stone should be('o')
    }

    "allow taking a stone" in {
      val fieldArray = new FieldArray()
      val result = fieldArray.takeStone(0, 0)
      result should not include "Fehler"
    }

    "allow moving a stone" in {
      val fieldArray = new FieldArray()
      val result = fieldArray.move(0, 0, 'o')
      result should not include "Fehler"
    }
  }
}
