package HTWG.SE.Muehle.controller
import HTWG.SE.Muehle.model.{Field, FieldArray, GridCreator, setStone}
import HTWG.SE.Muehle.util.Observable

    class Controller(var field1:Field) extends Observable {
        def createEmptyGrid(size: Int): Unit = {
            val array: FieldArray = new FieldArray()
            val field1: Field = new Field(6, array.fieldArray, 2)
            notifyObservers
        }
    }