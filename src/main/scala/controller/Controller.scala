package HTWG.SE.Muehle.controller
import HTWG.SE.Muehle.model.{FieldArray, Field, Handler1}
import HTWG.SE.Muehle.util.{Observable, UndoManager, Event}
import HTWG.SE.Muehle.controller.GameState
import HTWG.SE.Muehle.controller.StoneFactory
import scala.swing.FlowPanel.Alignment
import scala.swing._
import javax.swing.table._
import scala.swing.event._


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
    var counter = 0

    def controllerPlaceFirstStone(ind1: Int, ind2: Int, player: Char): String = {
        
        state = if(player == 'w'){
            new whiteState
        }else{
            new blackState
        }

        fieldString = array.placeStone(ind1, ind2, player)
        notifyObservers(Event.StonePlaced(ind1, ind2, player))
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
        notifyObservers(Event.StonePlaced)
        fieldString
        
    }
    def getFieldString() = fieldString

    def setStoneGui(pos1: Int, pos2: Int, color: Char): Color = {
        var color2 = ' '
        var background = new Color(150, 150, 150)
        var colorButton = new Color(150, 150, 150)
        var colorButton2 = new Color(150, 150, 150)
        var mesh = " "
        println("farbe:" + color)
            if(color == 'w') {
                color2 = 'b'
                colorButton = new Color(255, 255, 255)
                colorButton2 = new Color(0,0,0)
            } else {
                color2 = 'w'
                colorButton2 = new Color(255,255,255)
                colorButton = new Color(0, 0, 0)
            }

            if(counter == 0){
                //mesh = controllerPlaceFirstStone(pos1, pos2, color)
                background = colorButton
                counter += 1
            }else if(counter % 2 == 0 && counter < 18) {
                doStep(pos1, pos2, color, color2, counter, mesh)
                background = colorButton
                counter += 1
            } else {
                doStep(pos1, pos2, color, color2, counter, mesh)
                background = colorButton2
                counter += 1
            }
/*
            if(counter % 2 == 0 && counter < 18) {
                controllerPlaceFirstStone(pos1, pos2, color)
                background = colorButton
                counter += 1
            } else {
                controllerPlaceFirstStone(pos1, pos2, color2)
                background = colorButton2
                counter += 1
            }*/
            notifyObservers(Event.StonePlaced)
            background
    }

    def doStep(ind1:Int, ind2: Int,  player1: Char, player2: Char, i: Int, mesh: String) = {
        undoManager.doStep(new SetCommand(ind1, ind2, player1, player2, i, mesh, this))
        notifyObservers(Event.doStep)
    } 

    def undoStep: String ={
        fieldString = undoManager.undoStep
        notifyObservers(Event.undo)
        fieldString
    } 
    def redoStep: Unit ={
        undoManager.redoStep
        notifyObservers(Event.redoStep)
    }
}