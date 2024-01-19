package HTWG.SE.Muehle.controller.controllerBaseImpl

import HTWG.SE.Muehle.model.FieldComponent.FieldBaseComponent.{FieldArray, Field}
import HTWG.SE.Muehle.model.FieldComponent.{FieldInterface, FieldArrayInterface}
import HTWG.SE.Muehle.model.logicComponent.{Handler1, Mill, MillList, MillListInterface}
import HTWG.SE.Muehle.util.{Observable, UndoManager, Event}
import HTWG.SE.Muehle.controller._
import HTWG.SE.Muehle.MuehleModule
import scala.io.StdIn.readInt
import scala.swing.FlowPanel.Alignment
import scala.swing._
import javax.swing.table._
import scala.swing.event._
import com.google.inject.name.Names
import com.google.inject.{Guice, Inject, Injector}
import net.codingwell.scalaguice.InjectorExtensions._
import scala.xml.{NodeSeq, PrettyPrinter}   
import HTWG.SE.Muehle.model.FileIO._

class Controller @Inject() extends Observable with controllerInterface {
    val injector: Injector = Guice.createInjector(new MuehleModule)
    val fieldArray = new FieldArray
    val undoManager = new UndoManager(this)
    var millList = injector.getInstance(classOf[MillListInterface])
    val fileIo = injector.getInstance(classOf[FileIOInterface])
    var state: GameState = new blackState()
    def field1 = injector.getInstance(classOf[FieldInterface])
    val array = injector.getInstance(classOf[FieldArrayInterface])
    val handler1: Handler1 = new Handler1(array.fieldArray, millList)
    var fieldString = ""
    var counter = 0
    var placeabel = false
    var muehleBool: Boolean = false
    var color2 = ' '

    def setPlaceableTrue = {
        placeabel = true
        placeabel
    }

    def setPlaceableFalse = {
        placeabel = false
        placeabel
    }

    def setMuehleFalse ={
        muehleBool = false
        muehleBool
    }

    def handle(): String = {
        state.handle()
    }
    def turn(): Unit = state match {
        case white: whiteState => state = new blackState
        case black: blackState => state = new whiteState
    }

    def controllerPlaceFirstStone(ind1: Int, ind2: Int, player: Char): String = {
        
        state = if(player == 'w'){
            new whiteState
        }else{
            new blackState
        }
        fieldString = array.placeStone(ind1, ind2, player)
        fieldString
    }

    def controllerPlaceStones(ind1: Int, ind2: Int, player1: Char): String = {

        fieldString = array.placeStone(ind1, ind2, player1)

        if(!array.placed){
            counter -= 1
        }
            muehle(array)

        fieldString
        
    }
    
    def controllerMove(ind1: Int, ind2: Int, player: Char): Unit = {

        var player2 = ' '
            if(player == 'w') {
                player2 = 'b'
            } else {
                player2 = 'w'
            }
        doStep(ind1, ind2, player)
    }

    def muehle(array: FieldArrayInterface): Boolean ={
        var winner = " "
        if(handler1.checkRequirement(array.fieldArray) == true){
                muehleBool = true
                notifyObservers(Event.mill)

                if(counter % 2 == 0 && color2 == 'b'){
                    winner = array.counter('b')
                }else if(counter % 2 == 0 && color2 == 'w'){
                    winner = array.counter('w')
                }else if (counter % 2 != 0 && color2 == 'b'){
                    winner = array.counter('w')
                }else if (counter % 2 != 0 && color2 == 'w'){
                    winner = array.counter('b')
                }

                if(winner != " "){
                    notifyObservers(Event.ende(winner))
                }
            }else{
                notifyObservers(Event.noMill)
            }
        muehleBool
    }
    
    def getFieldString():String = fieldString

    def setStoneGui(pos1: Int, pos2: Int, color: Char):Boolean = {

        var startFinished: Boolean = false
        var mesh = " "

            if(color == 'w') {
                color2 = 'b'
            } else {
                color2 = 'w'
            }

            if(counter < 18 && counter % 2 == 0) {
                doStep(pos1, pos2, color)
                counter += 1
            }else if (counter < 18 && counter % 2 != 0){
                doStep(pos1, pos2, color2)
                counter += 1
            }else{
                startFinished = true
                counter +=1
                notifyObservers(Event.allStonesPlaced)
            }

        startFinished
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

    def doStep(ind1:Int, ind2: Int,  player1: Char): Unit = {
        undoManager.doStep(new SetCommand(ind1, ind2, player1, this, millList))
        notifyObservers(Event.doStep)
    } 

    def doStepMove(ind1:Int, ind2: Int,  color: Char) = { 
        counter += 1
        undoManager.doStepMove(new SetCommand(ind1, ind2, 'o', this, millList), new SetCommand(ind1, ind2, color, this, millList))
    }

    def undoStep: Unit ={
        counter = counter - 1
        val list = undoManager.undoStep
        val arrayPos: Array[Int] = list(1).asInstanceOf[Array[Int]]
        val row: Int = arrayPos(0)
        val col: Int = arrayPos(1)
        fieldString = list(0).toString()
        notifyObservers(Event.undo(row, col))
        fieldString
    } 

    def redoStep: Unit ={
        counter += 1
        val arrayPos: Array[Int] = undoManager.redoStep
        val row: Int = arrayPos(0)
        val col: Int = arrayPos(1)
        notifyObservers(Event.redoStep(row, col))
    }

    def save: Unit = {
        fileIo.save(array, counter)
    }

    def load: Array[Array[Char]] = {
        val arrayLoad: Array[Array[Char]] = fileIo.load.fieldArray
        for (i <- 0 to 2){
            for (x <- 0 to 7){
            array.fieldArray(i)(x) = arrayLoad(i)(x)
            }
        }
        counter = fileIo.counter
        arrayLoad
    }
}