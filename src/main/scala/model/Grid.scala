package HTWG.SE.Muehle.model

case class Grid(cells: Matrix[Cell]) {
    def this(size: Int) = this(new Matrix[Cell](size, Cell(0)))
}