package HTWG.SE.Muehle.model

case class player() {
    val playerWhite = 9
    val playerBlack = 9
    def reducePlayerStone(playerChar: Char): Int = {
        if(playerChar == 'w') {
        playerWhite - 1
    } else {
        playerBlack - 1
    }
    }
    
}