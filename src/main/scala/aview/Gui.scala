package HTWG.SE.Muehle.aview

import scala.swing.FlowPanel.Alignment
import scala.swing._
import HTWG.SE.Muehle.controller._
import HTWG.SE.Muehle.util._
import javax.swing.ImageIcon
//import java.awt.MenuBar

class Gui(controller: Controller) extends MainFrame with Observer {
    controller.add(this)
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
    contents += player1
    val icon= new ImageIcon()
    contents += new Button("Enter") {
      reactions += {
        case event.ButtonClicked(_) =>
            val playerOneName = player1.text
            //controller.getPlayerOne(playerOneName)
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