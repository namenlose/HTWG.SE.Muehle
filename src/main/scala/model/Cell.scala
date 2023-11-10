package HTWG.SE.Muehle.model

case class Cell(filled: Boolean, symbol: Stone) {
    def isSet: Boolean = filled
}