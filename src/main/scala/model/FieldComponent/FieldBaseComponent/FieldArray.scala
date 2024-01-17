package HTWG.SE.Muehle.model.FieldComponent.FieldBaseComponent

import HTWG.SE.Muehle.model.FieldComponent.FieldArrayInterface

case class FieldArray() extends FieldArrayInterface {
    
    var black = 9
    var white = 9

    val fieldArray= Array(Array('o', 'o', 'o', 'o', 'o', 'o' ,'o', 'o'), Array('o', 'o', 'o', 'o', 'o', 'o' ,'o', 'o'), Array('o', 'o', 'o', 'o', 'o', 'o' ,'o', 'o'))
    def placeStone(circle: Int, position: Int, player: Char): String = {
        if(fieldArray(circle)(position) == 'o' || player == 'o'){
            fieldArray(circle)(position) = player
        }else{
            fieldArray(circle)(position) = fieldArray(circle)(position)
            //println("Fehler: Die Position ist bereits belegt")
        }

        val field = new Field(6, fieldArray)
        field.mesh
    }
    
    def get(circle: Int, position: Int):Char = fieldArray(circle)(position)

    def takeStone(circle: Int, position: Int): String = {
        if(fieldArray(circle)(position) != 'o') {
            fieldArray(circle)(position) = 'o'
        }
        val field = new Field(6, fieldArray)
        field.mesh
    }

    def takeStone2(circle: Int, position: Int): String = {
        if(fieldArray(circle)(position) != 'o') {
            fieldArray(circle)(position) = 'o'
        }
        val field = new Field(6, fieldArray)
        field.mesh
    }

    def move(circle: Int, position: Int, player: Char): String = {
        fieldArray(circle)(position) = player
        val field = new Field(6, fieldArray)
        field.mesh
    }

    def counter(color: Char): String = {
    var winner = " "
        if(color == 'b') {
            black = black -1
        } else {
            white = white -1
        }
        if(black == 2) {
            winner = "Weiß hat gewonnen"
        } else if(white == 2) {
            winner = "Schwarz hat gewonnen"
        }
        winner
    }
}

