package HTWG.SE.Muehle
import scala.io.StdIn.readLine
import scala.io.StdIn.readInt
import scala.io.StdIn.readChar

case class TUI(){
  
val field1: Field = new Field(6, 2)

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

  println(nameOne + " positonieren Sie ihren ersten Stein:" + field1.eol + field1.mesh)
  val ind1 = readInt()
  println(" ")
  println("Spalte: ")
  val ind2 = readInt()
  println(" ")
  val newMesh = setStone(field1.mesh, ind1, ind2, playerOne)
  println(newMesh)
  var mesh = newMesh
  setStones(nameOne, nameTwo, playerOne, playerTwo, mesh)

}

def setStones(nameOne: String, nameTwo: String, playerOne: Char, playerTwo: Char, mesh: String): Unit = {
    var mesh2 = mesh
    var i = 1;
    
    while(i <=  17) {

        if(i % 2 == 0) {
            println(nameOne + " positonieren Sie einen Stein:" + field1.eol)
        }else{
            println(nameTwo + " positonieren Sie einen Stein:" + field1.eol)
        }
        println("Zeile: ")
        val ind1 = readInt()
        println(" ")
        println("Spalte: ")
        val ind2 = readInt()
        println(" ")

        if(i % 2 == 0){
            val updatedMesh = setStone(mesh2, ind1, ind2, playerOne)
            println(updatedMesh)
            mesh2 = updatedMesh
        }else{
            val updatedMesh = setStone(mesh2, ind1, ind2, playerTwo)
            println(updatedMesh)
            mesh2 = updatedMesh
        }
        i += 1
    
    }
}
}


    


