package HTWG.SE.Muehle.controller
import HTWG.SE.Muehle.model.{FieldArray, Field, Handler1}
import HTWG.SE.Muehle.util.{Observable, UndoManager}
import HTWG.SE.Muehle.controller.GameState
import HTWG.SE.Muehle.controller.StoneFactory
//import HTWG.SE.Muehle.controller.Events

import scala.swing.Publisher

class Controller() extends Observable{
    //var stone = new blackS()
    val undoManager = new UndoManager(this)
    /*trait Stone {
    def placeStone(): StoneFactory
    def place(): Char = {
        val stone = placeStone()
        stone.color()
        }
    }
    val c = new blackStone
    val b = new whiteStone

    class whiteStone extends Stone {
    override def placeStone(): StoneFactory = new whiteS

    }

    class blackStone extends Stone {
    override def placeStone(): StoneFactory = new blackS
    }*/

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
    val handler1: Handler1 = new Handler1(array.fieldArray)
    var fieldString = ""

    def controllerPlaceFirstStone(ind1: Int, ind2: Int, player: Char): String = {
        
        state = if(player == 'w'){
            new whiteState
        }else{
            new blackState
        }
        //publish(new posChanged)
        fieldString = array.placeStone(ind1, ind2, player)
        notifyObservers
        fieldString
    }

    def controllerPlaceStones(ind1: Int, ind2: Int, player1: Char, player2: Char, i: Int, mesh: String): String = {

        if(i % 2 == 0){
            fieldString = array.placeStone(ind1, ind2, player1)
            if(handler1.checkRequirement(array.fieldArray) == true){
                println("MÜHLE!!")
            }
        }else{
            fieldString = array.placeStone(ind1, ind2, player2)
             if(handler1.checkRequirement(array.fieldArray) == true){
                println("MÜHLE!!")
            }
        }
        fieldString
        
    }
    def getFieldString() = fieldString

    def doStep(ind1:Int, ind2: Int,  player1: Char, player2: Char, i: Int, mesh: String) = {
        undoManager.doStep(new SetCommand(ind1, ind2, player1, player2, i, mesh, this))
        notifyObservers
    }

    def undoStep: String ={
        fieldString = undoManager.undoStep
        notifyObservers
        fieldString
    } 
    def redoStep: Unit ={
        undoManager.redoStep
        notifyObservers
    }
}