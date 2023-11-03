package HTWG.SE.Muehle
import scala.io.StdIn.readLine

//import HTWG.SE.Muehle.Field

@main def hello: Unit =
  println("Hallo, das ist Muehle")
  println("Geben Sie einen Spieler Name ein:")
  val name = readLine()
  println("Geben Sie eine Spielsteinfarbe ein:")
  val color = readLine()
  println(name + " positonieren Sie ihren ersten Stein:")
  val ring: Int = readLine().toInt
  val zeile: Int = readLine().toInt
  val spalte: Int = readLine().toInt
  val nummer: Int = readLine().toInt
  val position1: Position = new Position(ring, zeile, spalte, nummer)
  val stone1: Stone = new Stone("weis", position1)
  println(stone1.setStone(position1))

  val field1: Field = new Field(6, 2)
  println(field1.mesh)

/*val groeße = 11
val number = 2

val eol = sys.props("line.separator")
def bar(cellWidth: Int = 6, number: Int = 2) = ("o" + "-" * cellWidth) * number + "o" + eol 
def line(cellWidth: Int = 6, number: Int = 2) = ("|" + " " * cellWidth) * number + "|" + eol 
def cells(cellWidth: Int = 4, cellWidth2: Int = 6, number: Int = 2) = "| " + ("o" + "-" * cellWidth) + ("o" + "-" * cellWidth2) * (number - 2) + ("o" + "-" * cellWidth)+ "o" + " |" + eol 
def line2(cellWidth: Int = 4, cellWidth2: Int = 6, number: Int = 2) = "| " + ("|" + " " * cellWidth) + ("|" + " " * cellWidth2)* (number - 2) + ("|" + " " * cellWidth) + "| |" + eol
def cells3(cellWidth:Int = 2, cellWidth2: Int = 6, number: Int = 2) = "| | " + ("o" + "-" * cellWidth) + ("o" + "-" * cellWidth2) * (number - 2) + ("o" + "-" * cellWidth)+ "o" + " | |"+ eol
def cells4(cellNumber:Int = 2, cellWidth:Int = 5) = ("o-o-o" + " " * cellWidth)* cellNumber + eol
val mesh = (bar(groeße, number) + line(groeße, number) + cells(groeße - 2, groeße, number) + line2(groeße - 2, groeße, number) + cells3(groeße - 4, groeße, number) + cells4(2, 2 *(groeße - 4) + ((number - 2) * groeße + (number - 1)))) + (cells3(groeße -4, groeße, number) + line2(groeße - 2, groeße, number) + cells(groeße - 2, groeße, number) + line(groeße, number) + bar(groeße, number))
*/
