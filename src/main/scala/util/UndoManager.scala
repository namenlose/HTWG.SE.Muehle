package HTWG.SE.Muehle.util
import HTWG.SE.Muehle.controller.Controller

class UndoManager(controller: Controller) {
    var undoStack: List[Command] = List()
    var redoStack: List[Int] = List()

    def doStep(command: Command) ={
        undoStack = command +: undoStack
        command.doStep
        undoStack
    }

    def undoStep: String = {
        val command = undoStack.head
        undoStack = undoStack.drop(1)
        command.undoStep
    }
}
