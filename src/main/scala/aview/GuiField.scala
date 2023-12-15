 package HTWG.SE.Muehle.aview

import scala.swing.FlowPanel.Alignment
import scala.swing._
import javax.swing.table._
import HTWG.SE.Muehle.controller._
import HTWG.SE.Muehle.util._
import javax.swing.ImageIcon
import javax.print.attribute.standard.OrientationRequested
import javax.swing.SwingUtilities
 
 
 class GuiField(controller: Controller) extends Observer{
    private var clickButtonAlreadyTriggered = false
    val gray = new Color(150,150,150)
    var color = 'w'
    val buttonMap: Map[(Int, Int), Button] = {
        val rows = 3
        val columns = 8
        val buttons = for {
            row <- 0 until rows
            col <- 0 until columns
    } yield {
        val button = new Button {
        background = gray
        reactions += {
            case event.ButtonClicked(_) =>
            background = controller.setStoneGui(row, col, color)
            background = controller.getColor(row, col)
            clickButtonAlreadyTriggered = true
      }
    }
    (row, col) -> button
  }
  buttons.toMap
}

def clickButton(pos1: Int, pos2: Int): Unit = {
  SwingUtilities.invokeLater(new Runnable {
    def run(): Unit = {
      if (!clickButtonAlreadyTriggered & pos1 != 8 & pos2 != 8) {
      buttonMap.get((pos1, pos2)) match {
        case Some(button) =>
          button.doClick()
          println("Button found")
        case None =>
          println(s"Button at position ($pos1, $pos2) not found.")
      }
    }
}
  })
}

    def playFrame(pos1: Int, pos2: Int, color: Char) = new MainFrame{

    def createLine: Label = new Label{
        text = "-"
    }

    def createVerticalLine: Label = new Label{
        text = "|"
    }

    def createSpace: Label = new Label {
        text = " "
    }

    val button0 = buttonMap((0, 0))
    val firstLine: GridPanel = new GridPanel(1, 13){
    contents += button0
    contents += createLine
    contents += createLine
    contents += createLine
    contents += createLine
    contents += createLine

    val button1 = buttonMap((0, 1)) 
    contents += button1
    contents += createLine
    contents += createLine
    contents += createLine
    contents += createLine
    contents += createLine

    val button2 = buttonMap((0, 2))
    contents += button2
    /*contents += new Button{
            background = gray
             reactions += {
                case event.ButtonClicked(_) =>
                    background = controller.setStoneGui(0,2, color)
            }
    } */
    }

    def secondLine:GridPanel = new GridPanel(1, 13){
    contents += createVerticalLine
    contents += createSpace
    contents += createSpace
    contents += createSpace
    contents += createSpace
    contents += createSpace
    contents += createVerticalLine
    contents += createSpace
    contents += createSpace
    contents += createSpace
    contents += createSpace
    contents += createSpace
    contents += createVerticalLine
    }

    val button3 = buttonMap((1, 0))
    val button4 = buttonMap((1, 1)) 
    val button5 = buttonMap((1, 2))  
    val thirdLine = new GridPanel(1, 13){
        contents += createVerticalLine
        contents += createSpace
        contents +=  button3
        contents += createLine
        contents += createLine
        contents += createLine
        contents +=  button4
        contents += createLine
        contents += createLine
        contents += createLine
        contents +=  button5
        contents += createSpace
        contents += createVerticalLine
    }

    def forthLLine: GridPanel = new GridPanel(1, 13){
        contents += createVerticalLine
        contents += createSpace
        contents += createVerticalLine
        contents += createSpace
        contents += createSpace
        contents += createSpace
        contents += createVerticalLine
        contents += createSpace
        contents += createSpace
        contents += createSpace
        contents += createVerticalLine
        contents += createSpace
        contents += createVerticalLine
    }
    
    val button6 = buttonMap((2, 0))
    val button7 = buttonMap((2, 1))
    val button8 = buttonMap((2, 2)) 
    def fifthLine: GridPanel = new GridPanel(1, 13){
        contents += createVerticalLine
        contents += createSpace
        contents += createVerticalLine
        contents += createSpace
        contents +=  button6
        contents += createLine
        contents +=  button7
        contents += createLine
        contents +=  button8
        contents += createSpace
        contents += createVerticalLine
        contents += createSpace
        contents += createVerticalLine
    }

    def sixthLine: GridPanel = new GridPanel(1, 13){
        contents += createVerticalLine
        contents += createSpace
        contents += createVerticalLine
        contents += createSpace
        contents += createVerticalLine
        contents += createSpace
        contents += createSpace
        contents += createSpace
        contents += createVerticalLine
        contents += createSpace
        contents += createVerticalLine
        contents += createSpace
        contents += createVerticalLine
    }

    val button9 = buttonMap((0, 7))
    val button10 = buttonMap((1, 7))
    val button11 = buttonMap((2, 7))
    val button12 = buttonMap((2, 3))
    val button13 = buttonMap((1, 3))
    val button14 = buttonMap((0, 3))  
    val seventhLine = new GridPanel(1, 13){
        contents +=  button9
        contents += createLine
        contents +=  button10
        contents += createLine
        contents +=  button11
        contents += createSpace
        contents += createSpace
        contents += createSpace
        contents +=  button12
        contents += createLine
        contents +=  button13
        contents += createLine
        contents +=  button14
    }

    val button15 = buttonMap((2, 6)) 
    val button16 = buttonMap((2, 5))
    val button17 = buttonMap((2, 4)) 
    val eighthLine = new GridPanel(1, 13){
        contents += createVerticalLine
        contents += createSpace
        contents += createVerticalLine
        contents += createSpace
        contents += button15
        contents += createLine
        contents += button16
        contents += createLine
        contents += button17
        contents += createSpace
        contents += createVerticalLine
        contents += createSpace
        contents += createVerticalLine
    }

    val button18 = buttonMap((1, 6))
    val button19 = buttonMap((1, 5))
    val button20 = buttonMap((1, 4)) 
    val ninthLine = new GridPanel(1, 13){
        contents += createVerticalLine
        contents += createSpace
        contents += button18
        contents += createLine
        contents += createLine
        contents += createLine
        contents += button19
        contents += createLine
        contents += createLine
        contents += createLine
        contents += button20
        contents += createSpace
        contents += createVerticalLine
    }

    val button21 = buttonMap((0, 6))
    val button22 = buttonMap((0, 5))
    val button23 = buttonMap((0, 4)) 
    val tenthLine = new GridPanel(1, 13){
    contents += button21
    contents += createLine
    contents += createLine
    contents += createLine
    contents += createLine
    contents += createLine

    contents += button22
    contents += createLine
    contents += createLine
    contents += createLine
    contents += createLine
    contents += createLine

    contents += button23
    }

    def spielfeld: GridPanel = new GridPanel(13, 1){
       contents += firstLine
       contents += secondLine
       contents += thirdLine
       contents += forthLLine
       contents += fifthLine
       contents += sixthLine
       contents += seventhLine
       contents += sixthLine
       contents += eighthLine
       contents += forthLLine
       contents += ninthLine
       contents += secondLine
       contents += tenthLine
    }

    contents = spielfeld

    //if()
    clickButton(pos1, pos2)
    
      pack()
      centerOnScreen()
      open()
  }
  
  override def update(e: Event): Unit = {
    //Swing.onEDT {
    e match {
        //case Event.doStep => GuiField(controller)
        case Event.StonePlaced2(pos1, pos2, color) => clickButtonAlreadyTriggered = true
        //repaint()
    }
}
}

//}


package HTWG.SE.Muehle.aview

import scala.swing.FlowPanel.Alignment
import scala.swing._
import javax.swing.table._
//import scala.swing.event._
import HTWG.SE.Muehle.controller._
import HTWG.SE.Muehle.util._
import javax.swing.ImageIcon
import javax.print.attribute.standard.OrientationRequested
//import java.awt.MenuBar

class Gui(controller: Controller) extends MainFrame with Observer {
    controller.add(this)
    var color: Char = ' '
    val spielfeld = new GuiField(controller)
    var pos1 = 8
    var pos2 = 8
    
   /*  menuBar = new MenuBar {
        contents += new Menu("File") {
            contents += new MenuItem(Action("Exit") {
                sys.exit(0)
            })
        }
    }
     */
  val firstFrame = new MainFrame {
  title = "Mill"
  contents = new BoxPanel(Orientation.Vertical) {
    val label = new Label("Wählen Sie eine Farbe")
    contents += label

    val buttonWhite: Button = new Button("Weiss") {
        reactions += {
            case event.ButtonClicked(_) =>
                color = 'w'
                spielfeld.playFrame(pos1, pos2, color)
                close()

    }
}
    val buttonBlack: Button = new Button("Schwarz") {
         reactions += {
            case event.ButtonClicked(_) =>
                color = 'b'
                spielfeld.playFrame(pos1, pos2, color)
                close()

    }
}

    contents += buttonWhite
    contents += buttonBlack

   /* val icon= new ImageIcon()
    contents += new Button("Enter") {
      reactions += {
        case event.ButtonClicked(_) =>
            //val playerOneName = player1.text
            val ind1 = circle.text.toInt
            val ind2 = column.text.toInt
            controller.controllerPlaceFirstStone(ind1, ind2, color) //Danach muss sich ein neues Fenster öffnen
            val newFrame = new Frame {
                title = "Muehle"
                contents = new FlowPanel {
                    contents += circle
                    contents += column
                }
            }
            newFrame.visible = true
            close()
            //firstFrame.visible = false
      }
    }*/
    //contents += ImageIcon()
  }

  pack()
  centerOnScreen()
  open()
    
  }


override def update(e: Event): Unit = {
    e match {
        //case Event.doStep => GuiField(controller)
        //case Event.StonePlaced2(pos1, pos2, color) => println("he")
        case Event.StonePlaced2(pos1, pos2, color) => spielfeld.playFrame(pos1, pos2, color)
        case Event.StonePlaced(pos1, pos2, color) => " "
        case Event.doStep1(pos1, pos2, color) => spielfeld.playFrame(pos1, pos2, color)
        case Event.doStep => " "
        //repaint()
    }
}
}



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
  case StonePlaced2(ind1: Int, ind2: Int, color: Char)
  case StonePlaced1
  case undo
  case redoStep
  case doStep
  case doStep1(ind1: Int, ind2: Int, color: Char)
}


package HTWG.SE.Muehle.aview
import HTWG.SE.Muehle.model.{FieldArray, Field}
import HTWG.SE.Muehle.controller.{Controller, GameState, StoneFactory}
import HTWG.SE.Muehle.util.{Observer, Event}
import scala.io.StdIn.readLine
import scala.io.StdIn.readInt
import scala.io.StdIn.readChar
import scala.annotation.meta.field

case class TUI(controller: Controller) extends Observer{

    controller.add(this)

    /*var player = controller.c.place()
    var player1 = controller.b.place()*/


    
    def firstStone(): String = {
    println("Hallo, das ist Muehle")
    println("Geben Sie zwei Spieler Namen ein:")
    val nameOne = readLine()
    val nameTwo = readLine()
     println("Geben Sie eine Spielsteinfarbe ein (Schwarz(b) oder Weiß(w)):")
    val playerOne = readChar()
    val playerTwo = if(playerOne == 'w'){
      'b'
    }else{
      'w'
    }


    println(nameOne + " positonieren Sie ihren ersten Stein:" + controller.field1.eol + controller.field1.mesh)
    println("Kreis: ")
    val ind1 = readInt()
    println(" ")
    println("Position: ")
    val ind2 = readInt()
    println(" ")

    var mesh = controller.controllerPlaceFirstStone(ind1, ind2, playerOne)
    setStones(nameOne, nameTwo, playerOne, playerTwo, mesh)
    mesh

}

    def setStones(nameOne: String, nameTwo: String, playerOne: Char, playerTwo: Char, mesh: String): Unit = {
    //val context = new Context(new whiteState)
    //val undoManager = new UndoManager(controller)
    val key = new Controller()
    var i = 1;
    var undo = false
    var redo = false
    while(i <=  17) {

        if(i % 2 == 0) {
            println(nameOne + " positonieren Sie einen Stein:" + controller.field1.eol)
            //controller.state
            controller.turn()
            println(controller.handle())
            //controller.turn()
        }else{
            println(nameTwo + " positonieren Sie einen Stein:" + controller.field1.eol)
            controller.turn()
            controller.handle()
            println(controller.handle())
            //controller.turn()
        }
        println("Kreis: ")
        val ind1 = readInt()
        if(ind1 == 3){
            undo = true
        }
        if(ind1 == 4){
            redo = true
        }
        println(" ")
        println("Position: ")
        val ind2 = readInt()
        println(" ")

        if(undo == false && redo == false){
            controller.doStep(ind1, ind2, playerOne, playerTwo, i, mesh)
        }else if(undo == true){
            controller.undoStep
            undo = false
        }else if(redo == true){
            controller.redoStep
            redo = false
        }

        i += 1  
    }
}
def update(e: Event): Unit = {
    e match {
        //case Event.StonePlaced(pos1, pos2, color) => //println(controller.controllerPlaceFirstStone(pos1, pos2, color)) println(controller.getFieldString())
        //case Event.StonePlaced => println(controller.getFieldString())
        case Event.StonePlaced(pos1, pos2, color) => println(controller.controllerPlaceFirstStone(pos1, pos2, color))
        //case Event.StonePlaced(pos1, pos2, color) => println(controller.controllerPlaceFirstStone(pos1, pos2, color))
        case Event.doStep => println(controller.getFieldString())
        case Event.StonePlaced1 => println(controller.getFieldString())
        case Event.StonePlaced2(pos1, pos2, color) => " "
        case Event.doStep1(pos1, pos2, color) => " "
        
    }
}
    //override def update: Unit =  {println(controller.getFieldString())

}
//}

    


