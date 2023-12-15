 package HTWG.SE.Muehle.aview

import scala.swing.FlowPanel.Alignment
import scala.swing._
import javax.swing.table._
import HTWG.SE.Muehle.controller._
import HTWG.SE.Muehle.util._
import javax.swing.ImageIcon
import javax.print.attribute.standard.OrientationRequested
 
 
 class GuiField(controller: Controller)extends Observer{
    controller.add(this)
    val gray = new Color(150,150,150)
 

    def playPanel(color: Char) = new FlowPanel{

    def createLine: Label = new Label{
        text = "-"
    }

    def createVerticalLine: Label = new Label{
        text = "|"
    }

    def createSpace: Label = new Label {
        text = " "
    }

    val buttonMap: Map[(Int, Int), Button] = {
  val rows = 3
  val columns = 7
  val buttons = for {
    row <- 0 until rows
    col <- 0 until columns
  } yield {
    val button = new Button {
      background = gray
      reactions += {
        case event.ButtonClicked(_) =>
            controller.setStoneGui(row, col, color)
            background = controller.getColor(row, col)
      }
    }
    (row, col) -> button
  }
  buttons.toMap
}

    val firstLine: GridPanel = new GridPanel(1, 13){
         contents += testButton
            
            /*new Button{
            background = gray
            reactions += {
                case event.ButtonClicked(_) =>
                    controller.setStoneGui(0,0,color)
                    background = controller.getColor(0,0)
        }
    }*/
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
                    controller.setStoneGui(0,2, color)
                    background = controller.getColor(0,2)
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
        contents += button14
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

    contents += spielfeld
    
      pack()
      centerOnScreen()
      open()
  }
  override def update(e: Event): Unit = {
   e match {
        //case Event.doStep => GuiField(controller)
        case Event.StonePlaced(pos1, pos2, color) => controller.setStoneGui(pos1, pos2, color)
        //repaint()
    }
}

}