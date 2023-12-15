 package HTWG.SE.Muehle.aview

import scala.swing.FlowPanel.Alignment
import scala.swing._
import javax.swing.table._
//import scala.swing.event._
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

    def createButton(ind1: Int, ind2: Int): Button = new Button{
            background = gray
            reactions += {
                case event.ButtonClicked(_) =>
                    controller.setStoneGui(ind1,ind2,color)
                    background = controller.getColor(ind1,ind2)
        }
    }

    val testButton = createButton(0,0)

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

    contents += new Button{
        background = gray
            reactions += {
                case event.ButtonClicked(_) =>
                    controller.setStoneGui(0,1, color)
                    background = controller.getColor(0,1)
            }
    }
    contents += createLine
    contents += createLine
    contents += createLine
    contents += createLine
    contents += createLine

    contents += new Button{
            background = gray
             reactions += {
                case event.ButtonClicked(_) =>
                    controller.setStoneGui(0,2, color)
                    background = controller.getColor(0,2)
            }
    }
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

    val thirdLine = new GridPanel(1, 13){
        contents += createVerticalLine
        contents += createSpace
        contents +=  new Button{
            background = gray
             reactions += {
                case event.ButtonClicked(_) =>
                    controller.setStoneGui(1,0, color)
                    background = controller.getColor(1,0)
            }
        }
        contents += createLine
        contents += createLine
        contents += createLine
        contents +=  new Button{
            background = gray
             reactions += {
                case event.ButtonClicked(_) =>
                    controller.setStoneGui(1,1, color)
                    background = controller.getColor(1,1)
            }
        }
        contents += createLine
        contents += createLine
        contents += createLine
        contents +=  new Button{
            background = gray
             reactions += {
                case event.ButtonClicked(_) =>
                    controller.setStoneGui(1,2, color)
                    background = controller.getColor(1,2)
            }
        }
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

    def fifthLine: GridPanel = new GridPanel(1, 13){
        contents += createVerticalLine
        contents += createSpace
        contents += createVerticalLine
        contents += createSpace
        contents +=  new Button{
            background = gray
             reactions += {
                case event.ButtonClicked(_) =>
                    controller.setStoneGui(2,0, color)
                    background = controller.getColor(2,0)
            }
        }
        contents += createLine
        contents +=  new Button{
            background = gray
             reactions += {
                case event.ButtonClicked(_) =>
                    controller.setStoneGui(2,1, color)
                    background = controller.getColor(2,1)
            }
        }
        contents += createLine
        contents +=  new Button{
            background = gray
             reactions += {
                case event.ButtonClicked(_) =>
                    controller.setStoneGui(2,2, color)
                    background = controller.getColor(2,2)
            }
        }
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

    val seventhLine = new GridPanel(1, 13){
        contents +=  new Button{
            background = gray
             reactions += {
                case event.ButtonClicked(_) =>
                    controller.setStoneGui(0,7, color)
                    background = controller.getColor(0,7)
            }
        }
        contents += createLine
         contents +=  new Button{
            background = gray
             reactions += {
                case event.ButtonClicked(_) =>
                    controller.setStoneGui(1,7, color)
                    background = controller.getColor(1,7)
            }
        }
        contents += createLine
         contents +=  new Button{
            background = gray
             reactions += {
                case event.ButtonClicked(_) =>
                   controller.setStoneGui(2,7, color)
                   background = controller.getColor(2,7)
            }
        }
        contents += createSpace
        contents += createSpace
        contents += createSpace
        contents +=  new Button{
            background = gray
             reactions += {
                case event.ButtonClicked(_) =>
                    controller.setStoneGui(2,3, color)
                    background = controller.getColor(2,3)
            }
        }
        contents += createLine
         contents +=  new Button{
            background = gray
             reactions += {
                case event.ButtonClicked(_) =>
                    controller.setStoneGui(1,3, color)
                    background = controller.getColor(1,3)
            }
        }
        contents += createLine
         contents +=  new Button{
            background = gray
             reactions += {
                case event.ButtonClicked(_) =>
                    controller.setStoneGui(0,3, color)
                    background = controller.getColor(0,3)
            }
        }
    }

    val eighthLine = new GridPanel(1, 13){
        contents += createVerticalLine
        contents += createSpace
        contents += createVerticalLine
        contents += createSpace
        contents +=  new Button{
            background = gray
             reactions += {
                case event.ButtonClicked(_) =>
                   controller.setStoneGui(2,6, color)
                   background = controller.getColor(2,6)
            }
        }
        contents += createLine
        contents +=  new Button{
            background = gray
             reactions += {
                case event.ButtonClicked(_) =>
                    controller.setStoneGui(2,5, color)
                    background = controller.getColor(2,5)
            }
        }
        contents += createLine
        contents +=  new Button{
            background = gray
             reactions += {
                case event.ButtonClicked(_) =>
                   controller.setStoneGui(2,4, color)
                   background = controller.getColor(2,4)
            }
        }
        contents += createSpace
        contents += createVerticalLine
        contents += createSpace
        contents += createVerticalLine
    }

    val ninthLine = new GridPanel(1, 13){
        contents += createVerticalLine
        contents += createSpace
        contents +=  new Button{
            background = gray
             reactions += {
                case event.ButtonClicked(_) =>
                    controller.setStoneGui(1,6,color)
                   controller.setStoneGui(1,6, color)
                   background = controller.getColor(1,6)
            }
        }
        contents += createLine
        contents += createLine
        contents += createLine
        contents +=  new Button{
            background = gray
             reactions += {
                case event.ButtonClicked(_) =>
                    controller.setStoneGui(1,5, color)
                    background = controller.getColor(1,5)
            }
        }
        contents += createLine
        contents += createLine
        contents += createLine
        contents +=  new Button{
            background = gray
             reactions += {
                case event.ButtonClicked(_) =>
                    controller.setStoneGui(1,4, color)
                    background = controller.getColor(1,4)
            }
        }
        contents += createSpace
        contents += createVerticalLine
    }

    val tenthLine = new GridPanel(1, 13){
        contents += new Button{
            background = gray
            reactions += {
                case event.ButtonClicked(_) =>
                    controller.setStoneGui(0,6,color)
                    background = controller.getColor(0,6)
        }
    }
    contents += createLine
    contents += createLine
    contents += createLine
    contents += createLine
    contents += createLine

    contents += new Button{
        background = gray
            reactions += {
                case event.ButtonClicked(_) =>
                    controller.setStoneGui(0,5, color)
                    background = controller.getColor(0,5)
            }
    }
    contents += createLine
    contents += createLine
    contents += createLine
    contents += createLine
    contents += createLine

    contents += new Button{
            background = gray
             reactions += {
                case event.ButtonClicked(_) =>
                   controller.setStoneGui(0,4, color)
                   background = controller.getColor(0,4)
            }
    }
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
    
      //pack()
     // centerOnScreen()
      //open()
  }

  override def update(e: Event): Unit = {
    //case Event.undo =>
  }

}