package HTWG.SE.Muehle.controller.controllerBaseImpl

import HTWG.SE.Muehle.model.FieldComponent.FieldBaseComponent.{FieldArray, Field}
import HTWG.SE.Muehle.model.FieldComponent.{FieldInterface, FieldArrayInterface}
import HTWG.SE.Muehle.model.logicComponent.Handler1
import HTWG.SE.Muehle.util.{Observable, UndoManager, Event}
import HTWG.SE.Muehle.controller._
import HTWG.SE.Muehle.MuehleModule
import scala.swing.FlowPanel.Alignment
import scala.swing._
import javax.swing.table._
import scala.swing.event._
import com.google.inject.name.Names
import com.google.inject.{Guice, Inject, Injector}
import net.codingwell.scalaguice.InjectorExtensions._


class Controller @Inject() extends Observable with controllerInterface {
    //var stone = new blackS()
    val undoManager = new UndoManager(this)
    val fieldArray = new FieldArray

    val injector: Injector = Guice.createInjector(new MuehleModule)
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

    //val wurde zur Methode
    //def field1: Field = new Field(6, array.fieldArray)
    def field1 = injector.getInstance(classOf[FieldInterface])
    
    //val array: FieldArray = new FieldArray()
    val array = injector.getInstance(classOf[FieldArrayInterface])
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
        //notifyObservers(Event.StonePlaced)
        //notifyObservers(Event.StonePlaced1)
        //notifyObservers(Event.StonePlaced2(ind1, ind2, player))
        fieldString
    }

    def controllerPlaceStones(ind1: Int, ind2: Int, player1: Char, player2: Char, i: Int, mesh: String): String = {

        if(i % 2 == 0){
            fieldString = array.placeStone(ind1, ind2, player1)
            muehle(array)
            /*if(handler1.checkRequirement(array.fieldArray) == true){
                println("MÜHLE!!")
                //notifyObservers(Event.StonePlaced(ind1, ind2, player1))
            }*/
        }else{
            fieldString = array.placeStone(ind1, ind2, player2)
            muehle(array)
             /*if(handler1.checkRequirement(array.fieldArray) == true){
                println("MÜHLE!!")
                //notifyObservers(Event.StonePlaced(ind1, ind2, player2))
            }*/
            //notifyObservers(Event.StonePlaced)
        }
        fieldString
        
    }

    def muehle(array: FieldArrayInterface): Boolean ={
        var muehle: Boolean = false
        if(handler1.checkRequirement(array.fieldArray) == true){
                println("MÜHLE!!")
                muehle = true
            }
        muehle
    }
    
    def getFieldString():String = fieldString

    def setStoneGui(pos1: Int, pos2: Int, color: Char):Unit = {
        var mesh = " "
        var color2 = ' '
            if(color == 'w') {
                color2 = 'b'
            } else {
                color2 = 'w'
            }

           /* if(counter == 0){
                //mesh = controllerPlaceFirstStone(pos1, pos2, color)
                //background = colorButton
                counter += 1
            }else */
            if(/*counter % 2 == 0 && */counter < 18) {
                doStep(pos1, pos2, color, color2, counter, mesh)
                counter += 1
            } /*else {
                doStep(pos1, pos2, color, color2, counter, mesh)
                counter += 1
            }*/
    }

    def getColor(ind1: Int, ind2: Int): Color ={
        val color = array.get(ind1, ind2)
        var background = new Color(150, 150, 150)

        if(color == 'b'){
            background = new Color(0,0, 0)
        }else if(color == 'w'){
            background = new Color(255, 255, 255)
        }
        background
    }

    def doStep(ind1:Int, ind2: Int,  player1: Char, player2: Char, i: Int, mesh: String): Unit = {
        undoManager.doStep(new SetCommand(ind1, ind2, player1, player2, i, mesh, this))
        notifyObservers(Event.doStep)
    } 

    def undoStep: Unit ={
        val list = undoManager.undoStep
        val array: Array[Int] = list(1).asInstanceOf[Array[Int]]
        val row: Int = array(0)
        val col: Int = array(1)
        fieldString = list(0).toString()
        notifyObservers(Event.undo(row, col))
        fieldString
    } 

    def redoStep: Unit ={
        val array: Array[Int] = undoManager.redoStep
        val row: Int = array(0)
        val col: Int = array(1)
        notifyObservers(Event.redoStep(row, col))
    }
}