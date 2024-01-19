package HTWG.SE.Muehle.util
import HTWG.SE.Muehle.controller.controllerBaseImpl.Controller
import scala.util.Failure
import scala.util.Success
import scala.util.Try

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

    def doStepMove(command: Command, commandFarbe: Command) = {
        undoStack = commandFarbe +: undoStack
        empty = Some(undoStack)
        command.doStep
        undoStack
    }
    
    def undoStep: List[Any] = {
        var string = ""   
        val command = undoStack.head
        redoStack = command +: redoStack
        undoStack = undoStack.drop(1)
        string = command.undoStep
        var position = command.getPositon
        var list = List(string, position)

        if(controller.counter >= 18){
            redoStack = undoStack.head +: redoStack
            doStep(undoStack.head)
            position = undoStack.head.getPositon
            list = List(string, position)
            undoStack = undoStack.drop(1)
        }
        list
    }
    
    def redoStep: Array[Int] = {
        val command = redoStack.head
        redoStack = redoStack.drop(1)
        command.doStep
        var position = command.getPositon

        if(controller.counter >= 18){
            val command2 = redoStack.head
            command2.doStep
            position = command2.getPositon

        }
        position
    }
}