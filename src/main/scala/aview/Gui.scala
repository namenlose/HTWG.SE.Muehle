package HTWG.SE.Muehle.aview

import scala.swing.FlowPanel.Alignment
import scala.swing._
import HTWG.SE.Muehle.controller._
import HTWG.SE.Muehle.util._
import javax.swing.ImageIcon
import javax.print.attribute.standard.OrientationRequested
//import java.awt.MenuBar

class Gui(controller: Controller) extends MainFrame with Observer {
    controller.add(this)
    private var color: Char = ' '
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
    /* val player1 = new TextField() {
        columns = 20
    } */
    contents += new Button("Weiss") {
        reactions += {
            case event.ButtonClicked(_) =>
                color = 'w'
    }
}
    contents += new Button("Schwarz") {
         reactions += {
            case event.ButtonClicked(_) =>
                color = 'w'
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

    val icon= new ImageIcon()
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
    }
    //contents += ImageIcon()
  }
  
  pack()
  centerOnScreen()
  open()
}

    override def update: Unit = {
        
    }
}