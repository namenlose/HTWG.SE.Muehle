package HTWG.SE.Muehle.test.scala.aview
import HTWG.SE.Muehle.aview.TUI
import HTWG.SE.Muehle.controller.controllerBaseImpl.{Controller, SetCommand}
import HTWG.SE.Muehle.model.FieldComponent.FieldBaseComponent.{FieldArray, Field}
import HTWG.SE.Muehle.util.{Command, UndoManager}
import HTWG.SE.Muehle.model.logicComponent.{Mill, MillList}
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class undoManagerTest extends AnyWordSpec {

    val controller = new Controller
    val fieldarray = new FieldArray
    val undoManager = new UndoManager(controller)
    val mesh = fieldarray.placeStone(0, 0, 'o')
    val millList = new MillList
    //val setCommand = new SetCommand
    undoManager.doStep(new SetCommand(0, 1, 'w',  controller, millList))
    //controller.doStep(2, 3, 'w', 'b', 2, mesh)

    "UndoManager" should{
        "do a step" in{
            undoManager.doStep(new SetCommand(1, 2, 'w', controller, millList))
            controller.fieldString should be(controller.controllerPlaceStones(1, 2, 'w'))
        }

        "undo a Step" in{
            undoManager.undoStep
            val list = undoManager.undoStep
            val string = list(0).toString()
            string should be(fieldarray.placeStone(0, 1, 'o'))
        }

        "do a step after all stones are placed" in{
            undoManager.doStepMove(new SetCommand(1, 3, 'o', controller, millList), new SetCommand(1, 3, 'w', controller, millList))
            controller.fieldString should be(controller.controllerPlaceStones(1, 3, 'o'))
        }

        "redo a Step" in{
            undoManager.redoStep
            controller.fieldString should be(controller.controllerPlaceStones(0, 1, 'w'))
        }
    }


}