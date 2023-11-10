package HTWG.SE.Muehle

case class Field(groeße: Int, array: Array[Array[Char]], number: Int/*, pos1: Char, pos2: Char, pos3: Char, pos4: Char, pos5: Char, pos6: Char, pos7: Char, pos8: Char, circle*/){


    val eol = sys.props("line.separator")
    //def bar(cellWidth: Int = 6, number: Int = 2) = ("o" + "-" * cellWidth) * number + "o" + eol 
    def bar(cellWidth: Int, pos1: Char, pos2: Char, pos3: Char) = pos1 + "-" * cellWidth + pos2 + "-" * cellWidth + pos3 + eol
    def line(cellWidth: Int = 6, number: Int = 2) = ("|" + " " * cellWidth) * number + "|" + eol 
    //def cells(cellWidth: Int = 4, cellWidth2: Int = 6, number: Int = 2) = "| " + ("o" + "-" * cellWidth) + ("o" + "-" * cellWidth2) * (number - 2) + ("o" + "-" * cellWidth)+ "o" + " |" + eol 
    def cells(cellWidth: Int, pos1: Char, pos2: Char, pos3: Char) = "| " + pos1 +"-" * cellWidth + pos2 + "-" *cellWidth + pos3 + " |" + eol
    def line2(cellWidth: Int = 4, cellWidth2: Int = 6, number: Int = 2) = "| " + ("|" + " " * cellWidth) + ("|" + " " * cellWidth2)* (number - 2) + ("|" + " " * cellWidth) + "| |" + eol
    //def cells3(cellWidth:Int = 2, cellWidth2: Int = 6, number: Int = 2) = "| | " + ("o" + "-" * cellWidth) + ("o" + "-" * cellWidth2) * (number - 2) + ("o" + "-" * cellWidth)+ "o" + " | |"+ eol
    def cells3(cellWidth: Int, pos1: Char, pos2: Char, pos3: Char) = "| | " + pos1 +"-" * cellWidth + pos2 + "-" *cellWidth + pos3 + " | |" + eol
    //def cells4(cellNumber:Int = 2, cellWidth:Int = 5) = ("o-o-o" + " " * cellWidth)* cellNumber + eol
    def cells4(cellWidth: Int, pos1: Char, pos2: Char, pos3: Char, pos4: Char, pos5: Char, pos6: Char) = pos1 + "-" + pos2 + "-" + pos3 + " " * cellWidth + pos4 + "-" + pos5 + "-" + pos6 + eol
    def cells5(cellWidth: Int, pos1: Char, pos2: Char, pos3: Char) = "| | " + pos1 +"-" * cellWidth + pos2 + "-" *cellWidth + pos3 + " | |" + eol
    def cells6(cellWidth: Int, pos1: Char, pos2: Char, pos3: Char) = "| " + pos1 +"-" * cellWidth + pos2 + "-" *cellWidth + pos3 + " |" + eol
    def bar2(cellWidth: Int, pos1: Char, pos2: Char, pos3: Char) = pos1 + "-" * cellWidth + pos2 + "-" * cellWidth + pos3 + eol
    /*val mesh = (bar(groeße, array(0)(0), array(0)(1) , array(0)(2)) + line(groeße, number) + cells(groeße - 2, groeße, number) + 
    line2(groeße - 2, groeße, number) + cells3(groeße - 4, groeße, number) + cells4(2, 2 *(groeße - 4) + ((number - 2) * groeße + (number - 1)))) + 
    (cells3(groeße -4, groeße, number) + line2(groeße - 2, groeße, number) + cells(groeße - 2, groeße, number) + line(groeße, number) + bar(groeße, array(0)(0), array(0)(1) , array(0)(2)))*/
    val mesh = (bar(groeße, array(0)(0), array(0)(1) , array(0)(2)) + line(groeße, number) + cells(groeße - 2, array(1)(0), array(1)(1), array(1)(2)) + 
    line2(groeße - 2, groeße, number) + cells3(groeße - 4, array(2)(0), array(2)(1), array(2)(2)) + cells4(2 *(groeße - 4) + 1, array(0)(7), array(1)(7), array(2)(7), array(2)(3), array(1)(3), array(0)(3)) + 
    cells5(groeße - 4, array(2)(6), array(2)(5), array(2)(4)) + line2(groeße - 2, groeße, number) + cells6(groeße - 2, array(1)(6), array(1)(5), array(1)(4)) + line(groeße, number) + bar2(groeße, array(0)(6), array(0)(5) , array(0)(4)))


}