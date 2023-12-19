package HTWG.SE.Muehle.model.FieldComponent

case class FieldArray(){


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
    def get(circle: Int, position: Int) = fieldArray(circle)(position)

    def takeStone(circle: Int, position: Int): String = {
        if(fieldArray(circle)(position) != 'o') {
            fieldArray(circle)(position) = 'o'
        } else {
            fieldArray(circle)(position) = fieldArray(circle)(position)
        }
        val field = new Field(6, fieldArray)
        field.mesh
    }
}

