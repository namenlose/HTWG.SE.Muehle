package HTWG.SE.Muehle.aview
import HTWG.SE.Muehle.model.FieldComponent.FieldBaseComponent.{FieldArray, Field}
import HTWG.SE.Muehle.controller._
import HTWG.SE.Muehle.controller.controllerBaseImpl.{Controller}
import HTWG.SE.Muehle.util.{Observer, Event}
import scala.io.StdIn.readLine
import scala.io.StdIn.readInt
import scala.io.StdIn.readChar
import scala.annotation.meta.field

case class TUI(controller: controllerInterface) extends Observer{

    controller.add(this)

    def firstStone(): String = {
    println("Hallo, das ist Muehle")
    println("Geben Sie zwei Spieler Namen ein:")
    val nameOne = readLine()
    val nameTwo = readLine()
     println("Geben Sie eine Spielsteinfarbe ein (Schwarz(b) oder Weiß(w)):")
    val playerOne = readChar()
    val playerTwo = if(playerOne == 'w'){
      'b'
    }else{
      'w'
    }


    println(nameOne + " positonieren Sie ihren ersten Stein:" + controller.field1.eol + controller.field1.mesh)
    println("Kreis: ")
    val ind1 = readInt()
    println(" ")
    println("Position: ")
    val ind2 = readInt()
    println(" ")

    var mesh = controller.controllerPlaceFirstStone(ind1, ind2, playerOne)
    setStones(nameOne, nameTwo, playerTwo)
    moveStone(nameOne, nameTwo, playerOne, playerTwo, mesh)
    mesh

}

    def setStones(nameOne: String, nameTwo: String, playerOne: Char): Unit = {
    val key = new Controller()
    var i = 1;
    var undo = false
    var redo = false
    var take1 = 0;
    var take2 = 0;
    while(i <=  4) {

        if(i % 2 == 0) {
            println(nameOne + " positonieren Sie einen Stein:" + controller.field1.eol)
            controller.turn()
            println(controller.handle())
        }else{
            println(nameTwo + " positonieren Sie einen Stein:" + controller.field1.eol)
            controller.turn()
            controller.handle()
            println(controller.handle())
        }
        println("Kreis: ")
        val ind1 = readInt()
        if(ind1 == 3){
            undo = true
        }
        if(ind1 == 4){
            redo = true
        }
        println(" ")
        println("Position: ")
        val ind2 = readInt()
        println(" ")

        if(undo == false && redo == false){
            controller.setStoneGui(ind1, ind2, playerOne)
        }else if(undo == true){
            controller.undoStep
            undo = false
        }else if(redo == true){
            controller.redoStep
            redo = false
        }

        i += 1  
    }
}
    def moveStone(nameOne: String, nameTwo: String, playerOne: Char, playerTwo: Char, mesh: String): Unit = {
        var i = 0
        var take1 = 0
        var take2 = 0
        if(i % 2 == 0) {
            println("Welchen Stein wollen Sie bewegen?")
            println("Kreis: ")
            val take1 = readInt()
            println(" ")
            println("Position: ")
            val take2 = readInt()
            println(" ")
            val zero = 'o'
            controller.doStep(take1, take2, zero)
            println(nameOne + " Bewegen Sie einen Stein " + controller.field1.eol)
            controller.turn()
            println(controller.handle())
            i += 1
        }else{
            println("Welchen Stein wollen Sie bewegen?")
            println("Kreis: ")
            val take1 = readInt()
            println(" ")
            println("Position: ")
            val take2 = readInt()
            println(" ")
            val zero = 'o'
            controller.doStep(take1, take2, zero)
            println(nameTwo + " Bewegen Sie einen Stein " + controller.field1.eol)
            controller.turn()
            controller.handle()
            println(controller.handle())
            i += 1
        }

        println("Kreis: ")
        val ind1 = readInt()
        println(" ")
        println("Position: ")
        val ind2 = readInt()
        println(" ")
        controller.doStep(ind1, ind2, playerOne)

    }
    def update(e: Event): Unit = {
        e match {
            case Event.StonePlaced(pos1, pos2, color) => println(controller.controllerPlaceFirstStone(pos1, pos2, color))
            case Event.doStep => println(controller.getFieldString())
            case Event.undo(row, col) => println(controller.getFieldString())
            case Event.redoStep(row, col) => println(controller.getFieldString())
            case Event.mill => println("Muehle!!")
            case Event.noMill => " "
            case Event.allStonesPlaced => " "
            case Event.ende(winner) => println(winner)
    }
}


}


    

