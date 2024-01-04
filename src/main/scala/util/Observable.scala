package HTWG.SE.Muehle.util

trait Observer {
    def update(e: Event): Unit
}
class Observable {
  var subscribers: Vector[Observer] = Vector()

  def add(s: Observer): Unit = subscribers = subscribers :+ s

  def remove(s: Observer): Unit = subscribers = subscribers.filterNot(o => o == s)

  def notifyObservers(e: Event): Unit = subscribers.foreach(o => o.update(e))
}

enum Event {
  case StonePlaced(ind1: Int, ind2: Int, player: Char)
  //case StonePlaced2(ind1: Int, ind2: Int, player: Char)
  //case StonePlaced1
  case undo(row: Int, col: Int)
  case redoStep(row: Int, col: Int)
  case doStep
  case mill
}