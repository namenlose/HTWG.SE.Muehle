package HTWG.SE.Muehle
import scala.io.StdIn.readLine
import scala.io.StdIn.readInt
import scala.io.StdIn.readChar

case class TUI(controller: Controller) extends Observable{
  
def firstStone() = {

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

}

def setStones(nameOne: String, nameTwo: String, playerOne: Char, playerTwo: Char, mesh: String): Unit = {
    var i = 1;
    
    while(i <=  17) {

        if(i % 2 == 0) {
            println(nameOne + " positonieren Sie einen Stein:" + controller.field1.eol)
        }else{
            println(nameTwo + " positonieren Sie einen Stein:" + controller.field1.eol)
        }
        println("Kreis: ")
        val ind1 = readInt()
        println(" ")
        println("Position: ")
        val ind2 = readInt()
        println(" ")

        controller.controllerPlaceStones(ind1, ind2, playerOne, playerTwo, i, mesh)

        i += 1   
    }
}
}


    


