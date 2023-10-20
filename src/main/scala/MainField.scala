@main def hello: Unit =
  println("Hallo, das ist Muehle")
  println(mesh)

val groeße = 8

val eol = sys.props("line.separator")
def bar(cellWidth: Int = 6) = "o" + "-" * cellWidth + "o" + "-" * cellWidth + "o" + eol
def line(cellWidth: Int = 6) = "|" + " " * cellWidth + "|" + " " * cellWidth + "|" + eol
def cells(cellWidth: Int = 4) = "| o" + "-" * cellWidth + "o" + "-" * cellWidth + "o" + " |" + eol /*"|-o---o---o-|"*/
def line2(cellWidth: Int = 4) = "| |" + " " * cellWidth + "|" + " " * cellWidth + "| |" + eol
//def cells2(cellWidth:Int = 4) = "| |" + "-" * cellWidth + "o" + "-" * cellWidth + "| |" + eol /*"| |---o---| |"*/
def cells3(cellWidth:Int = 2) = "| | " + "o" + "-" * cellWidth + "o" + "-" * cellWidth + "o" + " | |" + eol   /*"| | o-o-o | |"*/
def cells4(cellNumber:Int = 2, cellWidth:Int = 5) = ("o-o-o" + " " * cellWidth)* cellNumber + eol
val mesh = (bar(groeße) + line(groeße) + cells(groeße - 2) + line2(groeße - 2 * (groeße  -4 ) * 1) + cells3(groeße - 4) + cells4(2, groeße - 2)) + (cells3(groeße -4) + line2(groeße - 2) + cells(groeße - 2) + line(groeße) + bar(groeße))