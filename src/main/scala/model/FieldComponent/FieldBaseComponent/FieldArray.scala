package HTWG.SE.Muehle.model.FieldComponent.FieldBaseComponent

import HTWG.SE.Muehle.model.FieldComponent.FieldArrayInterface

case class FieldArray() extends FieldArrayInterface {


    val fieldArray= Array(Array('o', 'o', 'o', 'o', 'o', 'o' ,'o', 'o'), Array('o', 'o', 'o', 'o', 'o', 'o' ,'o', 'o'), Array('o', 'o', 'o', 'o', 'o', 'o' ,'o', 'o'))
    var amountb = 0
    var amountw = 0
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
            if(fieldArray(circle)(position) == 'w') {
                amountb += 1
            } else {
                amountw += 1
            }
            fieldArray(circle)(position) = 'o'
        } else {
            fieldArray(circle)(position) = fieldArray(circle)(position)
        }
        val field = new Field(6, fieldArray)
        field.mesh
    }
}

