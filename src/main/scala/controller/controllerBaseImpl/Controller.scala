package HTWG.SE.Muehle.controller.controllerBaseImpl

import HTWG.SE.Muehle.model.FieldComponent.FieldBaseComponent.{FieldArray, Field}
import HTWG.SE.Muehle.model.FieldComponent.{FieldInterface, FieldArrayInterface}
import HTWG.SE.Muehle.model.logicComponent.{Handler1, Mill, MillList, MillListInterface}
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
import scala.xml.{ NodeSeq, PrettyPrinter }
import HTWG.SE.Muehle.model.FileIO._

class Controller @Inject() extends Observable with controllerInterface {
    val injector: Injector = Guice.createInjector(new MuehleModule)
    val fieldArray = new FieldArray
    val undoManager = new UndoManager(this)
    var millList = injector.getInstance(classOf[MillListInterface])
    val fileIo = injector.getInstance(classOf[FileIOInterface])

    var state: GameState = new blackState()
    def handle(): String = {
        state.handle()
    }
    def turn(): Unit = state match {
        case white: whiteState => state = new blackState
        case black: blackState => state = new whiteState
    }

    def field1 = injector.getInstance(classOf[FieldInterface])

    val array = injector.getInstance(classOf[FieldArrayInterface])
    val handler1: Handler1 = new Handler1(array.fieldArray, millList)
    var fieldString = ""
    var counter = 0

    def controllerPlaceFirstStone(ind1: Int, ind2: Int, player: Char): String = {
        
        state = if(player == 'w'){
            new whiteState
        }else{
            new blackState
        }
        fieldString = array.placeStone(ind1, ind2, player)
        fieldString
    }

    def controllerPlaceStones(ind1: Int, ind2: Int, player1: Char, player2: Char, i: Int, mesh: String): String = {

        if(i % 2 == 0){
            fieldString = array.placeStone(ind1, ind2, player1)
            muehle(array)
        }else{
            fieldString = array.placeStone(ind1, ind2, player2)
            muehle(array)
        }
        fieldString
        
    }
    
    def controllerMove(ind1: Int, ind2: Int, player: Char): String = {
        
       /*  state = if(player == 'w'){
            new whiteState
        }else{
            new blackState
        } */
        fieldString = array.move(ind1, ind2, player)
        fieldString
    }

    def muehle(array: FieldArrayInterface): Boolean ={
        var muehle: Boolean = false
        if(handler1.checkRequirement(array.fieldArray) == true){
                println("MÜHLE!!")
                muehle = true
                notifyObservers(Event.mill)
            }else{
                notifyObservers(Event.noMill)
            }
        muehle
    }

    def controllerTakeStone(circle: Int, position: Int): String = {
        fieldString = array.takeStone(circle, position)
        fieldString
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

            if(counter < 18) {
                doStep(pos1, pos2, color, color2, counter, mesh)
                counter += 1
            } 
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
        undoManager.doStep(new SetCommand(ind1, ind2, player1, player2, i, mesh, this, millList))
        notifyObservers(Event.doStep)
    } 

    def undoStep: Unit ={
        counter = counter - 1
        val list = undoManager.undoStep
        val array: Array[Int] = list(1).asInstanceOf[Array[Int]]
        val row: Int = array(0)
        val col: Int = array(1)
        fieldString = list(0).toString()
        notifyObservers(Event.undo(row, col))
        fieldString
    } 

    def redoStep: Unit ={
        counter += 1
        val array: Array[Int] = undoManager.redoStep
        val row: Int = array(0)
        val col: Int = array(1)
        notifyObservers(Event.redoStep(row, col))
    }

    def save: Unit = {
        fileIo.save(array)
    }

    def load: Array[Array[Char]] = {
        val arrayLoad: Array[Array[Char]] = fileIo.load.fieldArray
        for (i <- 0 to 2){
            for (x <- 0 to 7){
            array.fieldArray(i)(x) = arrayLoad(i)(x)
            }
        }
        arrayLoad
    }
}