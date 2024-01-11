

import HTWG.SE.Muehle.controller.{controllerInterface, blackState, whiteState}
import HTWG.SE.Muehle.model.FieldComponent.FieldBaseComponent.FieldArray
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._
import HTWG.SE.Muehle.controller.controllerBaseImpl.{Controller}
import HTWG.SE.Muehle.controller.controllerInterface

class ControllerSpec extends AnyWordSpec {

 /*  "A Controller" should {
    "initialize with a black state" in {
      val controller = new Controller()
      controller.state should be(a[blackState])
    } */

    "correctly handle state transition to 'Weiss ist dran'" in {
      val controller = new Controller()
      controller.turn()
      controller.state should be(a[whiteState])
      controller.handle() should be("Weiss ist dran")
    }

    "correctly handle state transition to 'Schwarz ist dran'" in {
      val controller = new Controller()
      controller.turn()
      controller.turn()
      controller.state should be(a[blackState])
      controller.handle() should be("Schwarz ist dran")
    }

    "correctly place the first stone for white" in {
      val controller = new Controller()
      controller.controllerPlaceFirstStone(0, 0, 'w') should be(a[String])
    }

    "correctly place stones for both players" in {
      val controller = new Controller()
      controller.controllerPlaceStones(0, 0, 'w', 'b', 0, "") should be(a[String])
    }

    "correctly move a stone" in {
      val controller = new Controller()
      controller.controllerMove(0, 0, 'w') should be(a[String])
    }

    "correctly take a stone" in {
      val controller = new Controller()
      controller.controllerTakeStone(0, 0) should be(a[String])
    }

    "correctly get the field string" in {
      val controller = new Controller()
      controller.getFieldString() should be(a[String])
    }

    "correctly set a stone in the GUI" in {
      val controller = new Controller()
      controller.setStoneGui(0, 0, 'w')
      // Add more assertions based on the expected behavior of setStoneGui
    }

    /* "correctly get the color of a field" in {
      val controller = new Controller()
      controller.getColor(0, 0) should be(a[Color])
    } */

   /*  "correctly undo a step" in {
      val controller = new Controller()
      controller.undoStep should be(a[Unit])
    }

    "correctly redo a step" in {
      val controller = new Controller()
      controller.redoStep should be(a[Unit])
    }  */

    "correctly save the game state" in {
      val controller = new Controller()
      controller.controllerPlaceFirstStone(0, 0, 'w')
      controller.save should be(a[Unit])
    }

    "correctly load the game state" in {
      val controller = new Controller()
      
      controller.load should be(a[Array[Array[Char]]])
    }
  }
//}
