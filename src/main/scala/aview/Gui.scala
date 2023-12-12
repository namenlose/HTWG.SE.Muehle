package HTWG.SE.Muehle.aview

import scala.swing.FlowPanel.Alignment
import scala.swing._
import scala.swing.Table._
import scala.swing.event._
import HTWG.SE.Muehle.controller._
import HTWG.SE.Muehle.util._
import javax.swing.ImageIcon
import javax.print.attribute.standard.OrientationRequested
//import java.awt.MenuBar

class Gui(controller: Controller) extends MainFrame with Observer {
    controller.add(this)
    private var color1: Char = ' '
val black = new Color(0,0,0)
val white = new Color(250, 250, 250)
  val firstFrame = new MainFrame {
  title = "Mill"
  contents = new BoxPanel(Orientation.Vertical) {
    val label = new Label("Wählen Sie eine Farbe")
    contents += label
    /* val player1 = new TextField() {
        columns = 20
    } */
    val test = new Button(" ") {
        background = black
        reactions += {
            case event.ButtonClicked(_) =>
            background = white
        }
    }
    contents += test
    contents += new Button("Weiss") {
        
        reactions += {
            case event.ButtonClicked(_) =>
                color1 = 'w'
    }
}
    contents += new Button("Schwarz") {
         reactions += {
            case event.ButtonClicked(_) =>
                color1 = 'b'
    }
    }
contents += new Label("Wählen Sie die Position aus")
    val circle = new TextField() {
        columns = 10
    }
    val column = new TextField() {
        columns = 10
    }
    //contents += player1
    contents += circle
    contents += column

    //val icon= new ImageIcon()
    contents += new Button("Enter") {
      reactions += {
        case event.ButtonClicked(_) =>
            //val playerOneName = player1.text
            val ind1 = circle.text.toInt
            val ind2 = column.text.toInt
            controller.controllerPlaceFirstStone(ind1, ind2, color1) //Danach muss sich ein neues Fenster öffnen
            val newFrame = new Frame {
                title = "Muehle"
                contents = new FlowPanel {
                    contents += circle
                    contents += column
                    contents += new Button("Enter") {
                        reactions += {
                            case event.ButtonClicked(_) =>
                                val ind1 = circle.text.toInt
                                val ind2 = column.text.toInt
                                var color2 = ' '
                                if(color1 == 'w') {
                                    color2 = 'b'
                                } else {
                                    color2 = 'w'
                                }
                                var i = 1
                                //while(i < 17) {
                                    if(i % 2 == 0) {
                                        controller.controllerPlaceFirstStone(ind1, ind2, color1)
                                        i += 1
                                    } else {
                                        controller.controllerPlaceFirstStone(ind1, ind2, color2)
                                        i += 1
                                    }
                                    
                                //}
                        }
                    }
                }
            }
            newFrame.visible = true
            close()
            //firstFrame.visible = false
      }
    }
    //contents += ImageIcon()
    /*reactions += {
        case event: stoneChanged => 
    }*/
  }
  
  pack()
  centerOnScreen()
  open()
}

    override def update: Unit = {
        
    }
}