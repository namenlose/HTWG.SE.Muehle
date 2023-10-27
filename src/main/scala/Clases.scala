package HTWG.SE.Muehle

case class Stone (color: String, position: Int){
    def changePosition(position: Int, move: Int) = position + 1
}

case class Player (name: String)