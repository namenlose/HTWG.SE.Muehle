package HTWG.SE.Muehle.model
case class FieldArray(){


    val fieldArray= Array(Array('o', 'o', 'o', 'o', 'o', 'o' ,'o', 'o'), Array('o', 'o', 'o', 'o', 'o', 'o' ,'o', 'o'), Array('o', 'o', 'o', 'o', 'o', 'o' ,'o', 'o'))
    def placeStone(circle: Int, position: Int, player: Char) = {

        fieldArray(circle)(position) = if(fieldArray(circle)(position) == 'o'){player
        }else{
            fieldArray(circle)(position)
        }
        println("FieldArray:" + fieldArray(circle)(position))
        val field = new Field(6, fieldArray, 2)
        println(field.mesh)

    }
    def get(circle: Int, position: Int) = fieldArray(circle)(position)
}
