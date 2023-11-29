package HTWG.SE.Muehle.model

case class MillChecker(fieldArray: Array[Array[Char]]) {
    def hasMill(player: Char): Boolean = {
        for (row <- fieldArray) {
      if (row.count(_ == player) == 3) return true
    }

    // Überprüfen Sie vertikal
        for (col <- 0 until fieldArray.head.length) {
        if (fieldArray.map(_(col)).count(_ == player) == 3) return true
    }

    // Überprüfen Sie diagonal (einfache Implementierung, es gibt 2 diagonale Richtungen)
        if (fieldArray(0)(0) == player && fieldArray(1)(1) == player && fieldArray(2)(2) == player) return true
        if (fieldArray(0)(2) == player && fieldArray(1)(1) == player && fieldArray(2)(0) == player) return true

        false
  }
}
