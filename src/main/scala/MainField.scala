@main def hello: Unit =
  println("Hallo, das ist Muehle")
  println(mesh)


val eol = sys.props("line.separator")
def bar(cellWidth: Int = 6) = "o" + "-" * cellWidth + "o" + "-" * cellWidth + "o" + eol
def line(cellWidth: Int = 6) = "|" + " " * cellWidth + "|" + " " * cellWidth + "|" + eol 
def cells(cellWidth: Int = 4) = "| o" + "-" * cellWidth + "o" + "-" * cellWidth + "o" + " |" + eol /*"|-o---o---o-|"*/
def line2(cellWidth: Int = 4) = "| |" + " " * cellWidth + "|" + " " * cellWidth + "| |" + eol
//def cells2(cellWidth:Int = 4) = "| |" + "-" * cellWidth + "o" + "-" * cellWidth + "| |" + eol /*"| |---o---| |"*/
def cells3(cellWidth:Int = 2) = "| | " + "o" + "-" * cellWidth + "o" + "-" * cellWidth + "o" + " | |" + eol   /*"| | o-o-o | |"*/
def cells4(cellNumber:Int = 2, cellWidth:Int = 5) = ("o-o-o" + " " * cellWidth)* cellNumber + eol
val mesh = (bar(8) + line(8) + cells(6) + line2(6) + cells3(4) + cells4(2, 9)) + (cells3(4) + line2(6) + cells(6) + line(8) + bar(8))
