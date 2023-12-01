package HTWG.SE.Muehle.util
import HTWG.SE.Muehle.controller.Controller

class UndoManager(controller: Controller) {
    var undoStack: List[Command] = List()
    var redoStack: List[Int] = List()
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
            undoStack = undoStack.drop(1)
            string = command.undoStep
        }else{
            println("lehre liste")
        }
        string
    }
}
