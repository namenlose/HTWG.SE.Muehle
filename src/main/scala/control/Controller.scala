package HTWG.SE.Muehle.controller
import HTWG.SE.Muehle.model.{Grid, Solver, GridCreator}
import HTWG.SE.Muehle.util.Observable

    class Controller(var grid:Grid) extends Observable {
        def createEmptyGrid(size: Int): Unit = {
            grid = new Grid(size)
            notifyObservers
        }
    }