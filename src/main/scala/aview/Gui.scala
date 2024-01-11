package HTWG.SE.Muehle.aview

import scala.swing.FlowPanel.Alignment
import scala.swing._
import javax.swing.table._
import HTWG.SE.Muehle.controller._
import HTWG.SE.Muehle.controller.controllerBaseImpl._
import HTWG.SE.Muehle.controller.controllerInterface
import HTWG.SE.Muehle.util._
import javax.swing.ImageIcon
import javax.print.attribute.standard.OrientationRequested

class Gui(controller: controllerInterface) extends MainFrame with Observer {
    controller.add(this)
    var color: Char = ' '
    val spielfeld = new GuiField(controller)
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

    val save = new Button("Save"){
        reactions +={
            case event.ButtonClicked(_) =>
                controller.save
        }
    }

    val load = new Button("Load"){
        reactions += {
            case event.ButtonClicked(_) =>
                controller.load
                spielfeld.updateField
        }
    }

    val gridPanel = new GridPanel(2, 2){
        contents += undo
        contents += redo
        contents += save
        contents += load
    }


    /*val muehle = new Label
    def getMuehle: Label = muehle*/
    /*var muehle = new Label()

    def muehleLabel = new Label(){
        val bool: Boolean = controller.muehle(controller.array)
        if( bool == true){
            text = "MÜHLE!!"
        }else{
            text = "keine Mühle"
        }
    }*/

    def newWindow(color: Char): MainFrame = {
        new MainFrame{
            contents = new FlowPanel{
            contents += spielfeld.playPanel(color)
            contents += gridPanel
            //contents += muehleLabel
            }
        }
    }

   

    contents += buttonWhite
    contents += buttonBlack
  }

    pack()
    centerOnScreen()
    open()
    
  }


    override def update(e: Event): Unit = {
    e match {
        case Event.mill => spielfeld.muehleLabel
        case Event.noMill => spielfeld.keinMuehleLable
        case Event.doStep => " "
        case Event.undo(row, col) => " "
        case Event.redoStep(row, col) => " "
    }
}
}
