package HTWG.SE.Muehle
import scala.io.StdIn.readLine
import scala.io.StdIn.readInt
import scala.io.StdIn.readChar

case class TUI(){
  
val array: FieldArray = new FieldArray()
val field1: Field = new Field(6, array.fieldArray, 2)

def firstStone() = {

  println("staertArray:" + array.get(0,0))
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
  println("Kreis: ")
  val ind1 = readInt()
  println(" ")
  println("Position: ")
  val ind2 = readInt()
  println(" ")

  //val newMesh = setStone(field1.mesh, ind1, ind2, playerOne)
  array.placeStone(ind1, ind2, playerOne)
  val field2: Field = new Field(6,array.fieldArray, 2)
  println("array.get(0, 0):"  + array.get(0, 0))
  println("array.get(0, 1):"  + array.get(0, 1))
  println("array.get(0, 2):"  + array.get(0, 2))
  //println(field2.mesh)
  var mesh = field2.mesh
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
            //val updatedMesh = setStone(mesh2, ind1, ind2, playerOne)
            array.placeStone(ind1, ind2, playerOne)
            //println(updatedMesh)
            val i: Field = new Field(6,array.fieldArray, 2)
            //mesh2 = updatedMesh
            mesh2 = i.mesh
        }else{
            //val updatedMesh = setStone(mesh2, ind1, ind2, playerTwo)
            array.placeStone(ind1, ind2, playerTwo)
            val i: Field = new Field(6,array.fieldArray, 2)
            //println(updatedMesh)
           // mesh2 = updatedMesh
            mesh2 = i.mesh
        }
        i += 1
    
    }
}
}


    


