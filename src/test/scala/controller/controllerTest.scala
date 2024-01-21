

import HTWG.SE.Muehle.controller.{controllerInterface, blackState, whiteState}
import HTWG.SE.Muehle.model.FieldComponent.FieldBaseComponent.FieldArray
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._
import HTWG.SE.Muehle.controller.controllerBaseImpl.{Controller}
import HTWG.SE.Muehle.controller.controllerInterface
import HTWG.SE.Muehle.model.FieldComponent.FieldArrayInterface

class ControllerSpec extends AnyWordSpec {

    

    "A Controller" should {
      val controller = new Controller()
    /*"initialize with a black state" in {
      val controller = new Controller()
      controller.state should be(a[blackState])
    } */
      "set the Boolean placeable to true" in {
        controller.setPlaceableTrue should be(true)
      }

      "set the Boolean placeable to false" in {
        controller.setPlaceableFalse should be(false)
      }

      "set the Boolean muehleBool to false" in {
        controller.setMuehleFalse should be(false)
      }

      "correctly handle state transition to 'Weiss ist dran'" in {
        controller.turn()
        controller.state should be(a[whiteState])
        controller.handle() should be("Weiss ist dran")
      }

      "correctly handle state transition to 'Schwarz ist dran'" in {
        controller.turn()
        controller.state should be(a[blackState])
        controller.handle() should be("Schwarz ist dran")
      }

      "correctly place the first stone for white" in {
        controller.controllerPlaceFirstStone(0, 0, 'w') should be(a[String])
      }

      "correctly place stones for both players" in {
        controller.controllerPlaceStones(0, 0, 'w') should be(a[String])
      }

      "correctly move a stone" in {
        controller.controllerMove(0, 0, 'w') should be(a[Unit])
      }

      /*"correctly take a stone" in {
        val controller = new Controller()
        controller.controllerTakeStone(0, 0) should be(a[String])
      }*/

      "check if and who got a mill" in {
        val array = new FieldArray
        controller.muehle(array) should be(false)
      }


      "correctly get the field string" in {
        controller.getFieldString() should be(a[String])
      }

      "correctly set a stone in the GUI" in {
        controller.setStoneGui(0, 0, 'w') should be(false)
        // Add more assertions based on the expected behavior of setStoneGui
      }

      /*"correctly get the color of a field" in {
        val controller = new Controller()
        controller.getColor(0, 0) should be(a[Color])
      }*/

      "do a step when all stones are placed" in{
        controller.doStepMove(0,0,'w')
      }

      "correctly undo a step" in {
        controller.undoStep should be(a[Unit])
      }

      "correctly redo a step" in {
        controller.redoStep should be(a[Unit])
      }

      "correctly save the game state" in {
        controller.controllerPlaceFirstStone(0, 0, 'w')
        controller.save should be(a[Unit])
      }

      "correctly load the game state" in {
        controller.load should be(a[Array[Array[Char]]])
      }
    }
  }
