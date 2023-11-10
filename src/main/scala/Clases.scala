package HTWG.SE.Muehle

case class FieldArray(){


    val fieldArray= Array(Array('o', 'o', 'o', 'o', 'o', 'o' ,'o', 'o'), Array('o', 'o', 'o', 'o', 'o', 'o' ,'o', 'o'), Array('o', 'o', 'o', 'o', 'o', 'o' ,'o', 'o'))
    def placeStone(circle: Int, position: Int, player: Char) = {

        if(fieldArray(circle)(position) == 'o'){
            fieldArray(circle)(position) = player
        }else{
            fieldArray(circle)(position) = fieldArray(circle)(position)
            println("Fehler: Die Position ist bereits belegt")
        }

        println("FieldArray:" + fieldArray(circle)(position))
        val field = new Field(6, fieldArray)
        println(field.mesh)

    }
    def get(circle: Int, position: Int) = fieldArray(circle)(position)
}

