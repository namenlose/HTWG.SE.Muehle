package HTWG.SE.Muehle.aview

import scala.swing.FlowPanel.Alignment
import scala.swing._
import HTWG.SE.Muehle.controller._
import HTWG.SE.Muehle.util._
import javax.swing.ImageIcon
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
  new Frame {
  title = "Mill"
  contents = new FlowPanel {
    val label = new Label("Geben Sie ihren Namen ein")
    contents += label
    val player1 = new TextField() {
        columns = 20
    }
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

    val circle = new TextField() {
        columns = 20
    }
    val column = new TextField() {
        columns = 20
    }
    contents += player1
    contents += circle
    contents += column

    val icon= new ImageIcon()
    contents += new Button("Enter") {
      reactions += {
        case event.ButtonClicked(_) =>
            //val playerOneName = player1.text
            val ind1 = circle.text.toInt
            val ind2 = column.text.toInt
            controller.controllerPlaceFirstStone(ind1, ind2, color)
      }
    }
  }
  
  pack()
  centerOnScreen()
  open()
}

    override def update: Unit = {
        
    }
}