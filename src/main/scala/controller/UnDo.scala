package HTWG.SE.Muehle.controller

import HTWG.SE.Muehle.model.{FieldArray}

/*trait Command {
 def doStep:Unit
 def undoStep:Unit
 def redoStep:Unit
}

class SetCommand(controller: Controller) extends Command {

 //val undoManager = new UndoManager()

 override def doStep(ind1:Int, ind2: Int, player1: Char, player2: Char, i: Int, mesh: String): Unit = {
    //undoManager.doStep
    controller.controllerPlaceStones(ind1, ind2, player1, player2, i, mesh)}
 override def undoStep: Unit ={
    //val ind1 = undoManager.undoStep
    //val ind2 = undoManager.undoStep
    controller.array.placeStone(ind1, ind2, 'o')
    //fieldarray.placeStone(ind1, ind2, 'o')
 }
 override def redoStep: Unit ={controller.controllerPlaceStones(ind1, ind2, player1, player2, i, mesh)}
}*/

class UndoManager(controller: Controller) {
    //val setCommand = new SetCommand(controller)
    var undoStack: List[Int] = List()
    var redoStack: List[Int] = List()

    def doStep(ind1: Int, ind2: Int, player1: Char, player2: Char, i: Int, mesh: String): List[Int] ={
        undoStack = ind2 +: undoStack
        undoStack = ind1 +: undoStack
        controller.controllerPlaceStones(ind1, ind2, player1, player2, i, mesh)
        println(undoStack)
        undoStack
    }

    def undoStep: String = {
        println(undoStack)
        val ind1 = undoStack.head
        undoStack = undoStack.drop(1)
        val ind2 = undoStack.head
        undoStack = undoStack.drop(1)
        println(undoStack)
        controller.array.placeStone(ind1, ind2, 'o')
    }
}

