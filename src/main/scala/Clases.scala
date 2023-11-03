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