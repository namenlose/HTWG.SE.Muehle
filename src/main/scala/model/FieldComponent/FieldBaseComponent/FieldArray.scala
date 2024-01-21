package HTWG.SE.Muehle.model.FieldComponent.FieldBaseComponent

import HTWG.SE.Muehle.model.FieldComponent.FieldArrayInterface

case class FieldArray() extends FieldArrayInterface {
    
    var black = 9
    var white = 9
    var placed = true

    val fieldArray= Array(Array('o', 'o', 'o', 'o', 'o', 'o' ,'o', 'o'), Array('o', 'o', 'o', 'o', 'o', 'o' ,'o', 'o'), Array('o', 'o', 'o', 'o', 'o', 'o' ,'o', 'o'))
    def placeStone(circle: Int, position: Int, player: Char): String = {
        if(fieldArray(circle)(position) == 'o' || player == 'o'){
            fieldArray(circle)(position) = player
            placed = true
        }else{
            fieldArray(circle)(position) = fieldArray(circle)(position)
            placed = false
        }

        val field = new Field(6, fieldArray)
        field.mesh
    }
    
    def get(circle: Int, position: Int):Char = fieldArray(circle)(position)


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

