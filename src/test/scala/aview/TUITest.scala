/* package HTWG.SE.Muehle.test.scala.aview

import HTWG.SE.Muehle.aview.TUI
import HTWG.SE.Muehle.controller.controllerBaseImpl.Controller
import HTWG.SE.Muehle.model.FieldComponent.FieldBaseComponent.FieldArray
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class TUITest extends AnyWordSpec {

  val controller = new Controller()
  val fieldArray = new FieldArray()
  val tui = TUI(controller)

  "TUI" should {

    "handle placing the first stone" in {
      tui.firstStone() should be(fieldArray.placeStone(0, 0, 'b'))
    }

    "handle placing more stones (odd)" in {
      val expected = fieldArray.placeStone(0, 1, 'w')
      tui.setStones("Player1", "Player2", 'b', 'w', expected)
      tui.moveStone("Player1", "Player2", 'b', 'w', expected)
      tui.firstStone() should be(expected)
    }

    "handle placing more stones (even)" in {
      val expected = fieldArray.placeStone(0, 1, 'w')
      tui.setStones("Player1", "Player2", 'b', 'w', expected)
      tui.moveStone("Player1", "Player2", 'b', 'w', expected)
      tui.firstStone() should be(expected)
    }

    "return a string of the field" in {
      tui.update(null) // Simulating an update event
      tui.firstStone() should be(controller.getFieldString())
    }
  }
}


 */