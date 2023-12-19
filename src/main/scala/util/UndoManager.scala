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

    /*def undoStep1: Try[String] = {
        //var string = "" //das streichen failure zurückgeben
        if(empty == Some(undoStack)){
            Success((undoStep))
            
        }else{
            Failure(new NoSuchElementException("Nicht möglich!"))
        }
        //string //das auch succes zurückgeben
    }*/
    def undoStep: List[Any] = {
    var string = ""   
    val command = undoStack.head
    redoStack = command +: redoStack
    undoStack = undoStack.drop(1)
    string = command.undoStep
    val position = command.getPositon
    val list = List(string, position)
    list
    }
    
    def redoStep: Array[Int] = {
        val command = redoStack.head
        redoStack = redoStack.drop(1)
        command.doStep
        val position = command.getPositon
        position
    }
}