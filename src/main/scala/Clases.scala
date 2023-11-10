package HTWG.SE.Muehle

case class Stone (color: String, position: Position){
    val stoneArray = Array('o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o', 'o')
    def setStone(position: Position) = {
        stoneArray(position.nummer) = 'w'
    }

    def changePosition(position: Position, newPosition: Position) = {
          //if(position.sum - newPosition.sum == 1 || newPosition.sum -position.sum == 1){

         // }
    }
}

case class Player (name: String)

case class Position (ring: Int, zeile: Int, spalte: Int, nummer: Int){
    def sum(ring: Int, zeile: Int, spalte: Int) = ring + zeile + spalte
    def nummer(nummer: Int) = nummer
}

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

