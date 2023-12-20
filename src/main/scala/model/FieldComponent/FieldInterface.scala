package HTWG.SE.Muehle.model.FieldComponent

trait FieldInterface {
    def bar(cellWidth: Int, pos1: Char, pos2: Char, pos3: Char):String
    def line(cellWidth: Int = 6): String
    def cells(cellWidth: Int, pos1: Char, pos2: Char, pos3: Char): String
    def line2(cellWidth: Int = 4): String
    def cells3(cellWidth: Int, pos1: Char, pos2: Char, pos3: Char): String
    def cells4(cellWidth: Int, pos1: Char, pos2: Char, pos3: Char, pos4: Char, pos5: Char, pos6: Char): String
    def cells5(cellWidth: Int, pos1: Char, pos2: Char, pos3: Char): String
    def cells6(cellWidth: Int, pos1: Char, pos2: Char, pos3: Char): String
    def bar2(cellWidth: Int, pos1: Char, pos2: Char, pos3: Char): String
}

trait FieldArrayInterface {
    def placeStone(circle: Int, position: Int, player: Char): String
    def get(circle: Int, position: Int): Char
    def takeStone(circle: Int, position: Int): String
}