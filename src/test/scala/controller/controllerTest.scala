package HTWG.SE.Muehle.test.scala.aview
import HTWG.SE.Muehle.aview.TUI
import HTWG.SE.Muehle.controller.Controller
import HTWG.SE.Muehle.model.{FieldArray, Field}
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class ControllerTest extends AnyWordSpec {

    val controller = new Controller()
    val fieldArray = new FieldArray()
     
    "Controller" should{
        "place a first stone" in{
            controller.controllerPlaceFirstStone(0,0,'b')
            controller.fieldString should be(fieldArray.placeStone(0, 0,'b'))
        }

        "place more stones" in{
            controller.controllerPlaceStones(0, 1, 'b','w', 1, fieldArray.placeStone(0, 0,'b'))
            controller.fieldString should be(fieldArray.placeStone(0, 1,'w'))
        }
    }
}
