package HTWG.SE.Muehle.aview
import HTWG.SE.Muehle.model.{FieldArray, Field}
import HTWG.SE.Muehle.controller.{Controller, GameState, StoneFactory}
import HTWG.SE.Muehle.util.{Observer, Event}
import scala.io.StdIn.readLine
import scala.io.StdIn.readInt
import scala.io.StdIn.readChar
import scala.annotation.meta.field

case class TUI(controller: Controller) extends Observer{

    controller.add(this)

    /*var player = controller.c.place()
    var player1 = controller.b.place()*/


    
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
    setStones(nameOne, nameTwo, playerOne, playerTwo, mesh)
    mesh

}

    def setStones(nameOne: String, nameTwo: String, playerOne: Char, playerTwo: Char, mesh: String): Unit = {
    //val context = new Context(new whiteState)
    //val undoManager = new UndoManager(controller)
    val key = new Controller()
    var i = 1;
    var undo = false
    var redo = false
    while(i <=  17) {

        if(i % 2 == 0) {
            println(nameOne + " positonieren Sie einen Stein:" + controller.field1.eol)
            //controller.state
            controller.turn()
            println(controller.handle())
            //controller.turn()
        }else{
            println(nameTwo + " positonieren Sie einen Stein:" + controller.field1.eol)
            controller.turn()
            controller.handle()
            println(controller.handle())
            //controller.turn()
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
            controller.doStep(ind1, ind2, playerOne, playerTwo, i, mesh)
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
def update(e: Event): Unit = {
    e match {
        case Event.StonePlaced() => println(controller.controllerPlaceStones(ind1, ind2, player))//println(controller.getFieldString())
        case Event.doStep => ""
    }
}
    //override def update: Unit =  {println(controller.getFieldString())

}
//}

    


