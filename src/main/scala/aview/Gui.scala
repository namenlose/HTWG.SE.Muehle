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
                val window = newWindow(color)
                window.visible = true
                window.pack()
                window.centerOnScreen()
                window.open()
    }
}
    val buttonBlack: Button = new Button("Schwarz") {
         reactions += {
            case event.ButtonClicked(_) =>
                color = 'b'
                val window = newWindow(color)
                window.visible = true
                window.pack()
                window.centerOnScreen()
                window.open()
    }
    }

    val undo = new Button("Undo"){
        reactions += {
            case event.ButtonClicked(_) =>
                controller.undoStep
        }
    }

    val redo = new Button("Redo"){
        reactions += {
            case event.ButtonClicked(_) =>
                controller.redoStep
        }
    }

    def newWindow(color: Char): MainFrame = {
        new MainFrame{
            contents = new FlowPanel{
            contents += spielfeld.playPanel(color)
            contents += undo
            contents += redo
            }
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
    //case Event.undo => 
    //e match {
        //case Event.doStep => GuiField(controller)
        //case Event.StonePlaced2(pos1, pos2, color) => println("he")
        //repaint()
    //}
}
}