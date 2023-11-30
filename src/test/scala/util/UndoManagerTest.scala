package HTWG.SE.Muehle.test.scala.aview
import HTWG.SE.Muehle.aview.TUI
import HTWG.SE.Muehle.controller.{Controller, SetCommand}
import HTWG.SE.Muehle.model.{FieldArray, Field}
import HTWG.SE.Muehle.util.{Command, UndoManager}
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class undoManagerTest extends AnyWordSpec {

    val controller = new Controller
    val fieldarray = new FieldArray
    val undoManager = new UndoManager(controller)
    val mesh = fieldarray.placeStone(0, 0, 'o')
    //val setCommand = new SetCommand
    undoManager.doStep(new SetCommand(0, 1, 'w', 'b', 1, mesh, controller))
    //controller.doStep(2, 3, 'w', 'b', 2, mesh)

    "UndoManager" should{
        "do a step" in{
            undoManager.doStep(new SetCommand(1, 2, 'w','b', 0, mesh, controller))
            controller.fieldString should be(controller.controllerPlaceStones(1, 2, 'w','b', 0, mesh))
        }

        "undo a Step" in{
            undoManager.undoStep
            undoManager.undoStep should be(fieldarray.placeStone(0, 1, 'o'))
        }
    }


}