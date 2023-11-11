package HTWG.SE.Muehle.model
import scala.io.StdIn.readChar
import scala.io.StdIn.readInt
def firstStone() = {

  
  println("Geben Sie eine Spielsteinfarbe ein (Schwarz(b) oder Weiß(w)):")
  val playerOne = readChar()
  val playerTwo = if(playerOne == 'w'){
      'b'
  }else{
      'w'
  }

  println(nameOne + " positonieren Sie ihren ersten Stein:" + field1.eol + field1.mesh)
  println("Kreis: ")
  val ind1 = readInt()
  println(" ")
  println("Position: ")
  val ind2 = readInt()
  println(" ")

  //val newMesh = setStone(field1.mesh, ind1, ind2, playerOne)
  array.placeStone(ind1, ind2, playerOne)
  val field2: Field = new Field(6,array.fieldArray, 2)
  //println(field2.mesh)
  var mesh = field2.mesh
  setStone(nameOne, nameTwo, playerOne, playerTwo, mesh)

}