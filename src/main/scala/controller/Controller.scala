package HTWG.SE.Muehle.controller
import HTWG.SE.Muehle.model.{FieldArray, Field}
import HTWG.SE.Muehle.util.Observable
import HTWG.SE.Muehle.controller.GameState
import HTWG.SE.Muehle.controller.StoneFactory

class Controller() extends Observable{
    //var stone = new blackS()
    trait Stone {
    def placeStone(): StoneFactory
    def place(): Char = {
        val stone = placeStone()
        stone.color()
        }
    }
    val c = new whiteStone
    val b = new blackStone
class whiteStone extends Stone {
    override def placeStone(): StoneFactory = new whiteS

}
class blackStone extends Stone {
    override def placeStone(): StoneFactory = new blackS
}

    var state: GameState = new blackState()
    def handle(): String = {
        state.handle()
    }
    def turn(): Unit = state match {
        case white: whiteState => state = new blackState
        case black: blackState => state = new whiteState
    }

    val array: FieldArray = new FieldArray()
    val field1: Field = new Field(6, array.fieldArray)
    var fieldString = ""

    def controllerPlaceFirstStone(ind1: Int, ind2: Int, player: Char): String = {
        
        fieldString = array.placeStone(ind1, ind2, player)
        //val field2: Field = new Field(6, array.fieldArray)
        notifyObservers
        fieldString
    }

    def controllerPlaceStones(ind1: Int, ind2: Int, player1: Char, player2: Char, i: Int, mesh: String): String = {
        //var mesh2 = mesh
        if(i % 2 == 0){
            fieldString = array.placeStone(ind1, ind2, player1)
            //val i: Field = new Field(6, array.fieldArray)
           // mesh2 = i.mesh
        }else{
            fieldString = array.placeStone(ind1, ind2, player2)
            //val i: Field = new Field(6, array.fieldArray)
            //mesh2 = i.mesh
        }
        notifyObservers
        fieldString
        
    }
    def getFieldString() = fieldString
    //def message() = state

}