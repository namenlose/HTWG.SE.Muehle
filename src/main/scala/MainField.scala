@main def hello: Unit =
  println("Muehle")
  println(mesh)

val eol = sys.props("line.separator")
def bar(cellWidth: Int = 6) = "o" + "-" * cellWidth + "o" + "-" * cellWidth + "o" + eol
def cells(cellWidth: Int = 4) = "| o" + "-" * cellWidth + "o" + "-" * cellWidth + "o" + " |" + eol /*"|-o---o---o-|"*/
//def cells2(cellWidth:Int = 4) = "| |" + "-" * cellWidth + "o" + "-" * cellWidth + "| |" + eol /*"| |---o---| |"*/
def cells3(cellWidth:Int = 2) = "| | " + "o" + "-" * cellWidth + "o" + "-" * cellWidth + "o" + " | |" + eol   /*"| | o-o-o | |"*/
def cells4(cellNumber:Int = 2, cellWidth:Int = 5) = ("o-o-o" + " " * cellWidth)* cellNumber + eol
val mesh = (bar() + cells() + cells3() + cells4()) + (cells3() + cells() + bar())
