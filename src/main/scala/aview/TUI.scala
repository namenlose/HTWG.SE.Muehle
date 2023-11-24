package HTWG.SE.Muehle.aview
import HTWG.SE.Muehle.model.{FieldArray, Field}
import HTWG.SE.Muehle.controller.{Controller, GameState, StoneFactory}
import HTWG.SE.Muehle.util.Observer
import scala.io.StdIn.readLine
import scala.io.StdIn.readInt
import scala.io.StdIn.readChar
import scala.annotation.meta.field

case class TUI(controller: Controller) extends Observer{

    controller.add(this)
    var player = controller.c.place()
    var player1 = controller.b.place()
    def firstStone(): String = {

    println("Hallo, das ist Muehle")
    println("Geben Sie zwei Spieler Namen ein:")
    val nameOne = readLine()
    val nameTwo = readLine()

    /* println("Geben Sie eine Spielsteinfarbe ein (Schwarz(b) oder Weiß(w)):")
    val playerOne = readChar()
    val playerTwo = if(playerOne == 'w'){
      'b'
    }else{
      'w'
    } */

    println(nameOne + " positonieren Sie ihren ersten Stein:" + controller.field1.eol + controller.field1.mesh)
    println("Kreis: ")
    val ind1 = readInt()
    println(" ")
    println("Position: ")
    val ind2 = readInt()
    println(" ")

    var mesh = controller.controllerPlaceFirstStone(ind1, ind2, player)
    setStones(nameOne, nameTwo, player, player, mesh)
    mesh

}

    def setStones(nameOne: String, nameTwo: String, playerOne: Char, playerTwo: Char, mesh: String): Unit = {
    //val context = new Context(new whiteState)
    val key = new Controller()
    var i = 1;
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
        println(" ")
        println("Position: ")
        val ind2 = readInt()
        println(" ")

        controller.controllerPlaceStones(ind1, ind2, player, player1, i, mesh)
        //controller.state
        i += 1  
    }
}
    override def update: Unit =  {println(controller.getFieldString())
}
}

    


