package HTWG.SE.Muehle.model
import scala.collection.Map

case class Matrix[T](rows: Vector[Vector[T]]) {
  def this(size: Int, filling: T) = this(Vector.tabulate(size, size) { (row, col) => filling })

  val allowed =
      List((0,0), (0,3), (0,6),
        (1,1), (1,3), (1,5),
        (2,2), (2,3), (2,4),
        (3,0), (3,1), (3,2), (3,4), (3,5), (3,6),
        (4,2), (4,3), (4,4),
        (5,2), (5,3), (5,5),
        (6,0), (6,3), (6,6))

  val size: Int = rows.size

  def cell(row: Int, col: Int): T = rows(row)(col)

  def fill(filling: T): Matrix[T] = copy(Vector.tabulate(size, size) { (row, col) => filling })

  def replaceCell(row: Int, col: Int, cell: T): Matrix[T] = copy(rows.updated(row, rows(row).updated(col, cell)))
}
/*   val matrix = Array.ofDim[String](rows, cols);
  val notAllowed =
    List((0,1), (0,2), (0,4), (0,5),
      (1,0), (1,2), (1,4), (1,6),
      (2,0), (2,1), (2,5), (2,6),
      (3,3),
      (4,0), (4,1), (4,5), (4,6),
      (5,0), (5,2), (5,4), (5,6),
      (6,1), (6,2), (6,4), (6,5))

      val allowed =
      List((0,0), (0,3), (0,6),
        (1,1), (1,3), (1,5),
        (2,2), (2,3), (2,4),
        (3,0), (3,1), (3,2), (3,4), (3,5), (3,6),
        (4,2), (4,3), (4,4),
        (5,2), (5,3), (5,5),
        (6,0), (6,3), (6,6))
 */
 /*    notAllowed.foreach {
    case (r, c) => matrix(r)(c) = " "
    } 
  
  allowed.foreach {
    case(row, col) => matrix(row)(col) = "o"
  }
 */
  //for(notAllowed.get()
/*  val c =
    List (
      List((1,1), (1,2), (1,3), (4,1), (4,6), (7,1), (7, 2), (7,3)),
      List((2, 1), (2,2), (2,3), (4,2), (4,5), (6,1), (6,2), (6,3)),
      List((3,1), (3,2), (3,3), (4,3), (4,4), (6,1), (6,2), (6,3))
    )*/


