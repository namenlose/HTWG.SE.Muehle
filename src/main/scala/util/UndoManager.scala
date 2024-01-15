package HTWG.SE.Muehle.util
import HTWG.SE.Muehle.controller.controllerBaseImpl.Controller
//import HTWG.SE.Muehle.model.logicComponent.{Mill, MillList}
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
        var position = command.getPositon
        var list = List(string, position)
        println("counter: " + controller.counter)

        if(controller.counter >= 17){
            println("im if")
            doStep(undoStack.head)
            println("nach do step")
            position = undoStack.head.getPositon
            list = List(string, position)
            println("list: " + list)
            undoStack = undoStack.drop(1)
        }
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