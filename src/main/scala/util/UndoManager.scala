package HTWG.SE.Muehle.util
import HTWG.SE.Muehle.controller.Controller

class UndoManager(controller: Controller) {
    var undoStack: List[Command] = List()
    var redoStack: List[Command] = List()
    var empty: Option[List[Command]] = None

    def doStep(command: Command) ={
        undoStack = command +: undoStack
        empty = Some(undoStack)
        command.doStep
        undoStack
    }

    def undoStep: String = {
        var string = ""
        if(empty == Some(undoStack)){
            val command = undoStack.head
            redoStack = command +: redoStack
            undoStack = undoStack.drop(1)
            string = command.undoStep
        }else{
            println("lehre liste")
        }
        string
    }

    def redoStep: Unit = {
        val command = redoStack.head
        redoStack = redoStack.drop(1)
        command.doStep
    }
}
