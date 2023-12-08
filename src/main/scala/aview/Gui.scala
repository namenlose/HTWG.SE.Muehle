package HTWG.SE.Muehle.aview

import scala.swing.FlowPanel.Alignment
import scala.swing._
import javax.swing.table._
import scala.swing.event._
import HTWG.SE.Muehle.controller._
import HTWG.SE.Muehle.util._
import javax.swing.ImageIcon
import javax.print.attribute.standard.OrientationRequested
//import java.awt.MenuBar

class Gui(controller: Controller) extends MainFrame with Observer {
    controller.add(this)
    private var color: Char = ' '
    val w = new Color(255, 255, 255)
    val gray = new Color(150,150,150)
    val b = new Color(0, 0, 0)
    var i = 0
    
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
                color = 'b'
    }
    }

   /* contents += new Button{
        text = "Farb test"
        background = gray
        reactions += {
            case event.ButtonClicked(_) =>
                background = white      
            }
    }*/

    val firstLine = new GridPanel(1, 13){
         contents += new Button{
            background = gray
            reactions += {
                case event.ButtonClicked(_) =>
                    var color2 = ' '
                    var colorButton = new Color(150, 150, 150)
                    var colorButton2 = new Color(150, 150, 150)
                                if(color == 'w') {
                                    color2 = 'b'
                                    colorButton = new Color(255, 255, 255)
                                    colorButton2 = new Color(0,0,0)
                                } else {
                                    color2 = 'w'
                                    colorButton2 = new Color(255,255,255)
                                    colorButton = new Color(0, 0, 0)
                                }
                                
                                    if(i % 2 == 0) {
                                        controller.controllerPlaceFirstStone(0, 0, color)
                                        background = colorButton
                                        i += 1
                                    } else {
                                        controller.controllerPlaceFirstStone(0, 0, color2)
                                        background = colorButton2
                                        i += 1
                                    }
                                
            }
        }

         contents += new Label{
        text = "-"
    }
     contents += new Label{
        text = "-"
    }
     contents += new Label{
        text = "-"
    }

     contents += new Label{
        text = "-"
    }
     contents += new Label{
        text = "-"
    }
    contents += new Button{
        background = gray
            reactions += {
                case event.ButtonClicked(_) =>
                    var color2 = ' '
                    var colorButton = new Color(150, 150, 150)
                    var colorButton2 = new Color(150, 150, 150)
                                if(color == 'w') {
                                    color2 = 'b'
                                    colorButton = new Color(255, 255, 255)
                                    colorButton2 = new Color(0,0,0)
                                } else {
                                    color2 = 'w'
                                    colorButton2 = new Color(255,255,255)
                                    colorButton = new Color(0, 0, 0)
                                }
                                
                                    if(i % 2 == 0) {
                                        controller.controllerPlaceFirstStone(0, 1, color)
                                        background = colorButton
                                        i += 1
                                    } else {
                                        controller.controllerPlaceFirstStone(0, 1, color2)
                                        background = colorButton2
                                        i += 1
                                    }
                                
            }
    }
            contents += new Label{
        text = "-"
    }
     contents += new Label{
        text = "-"
    }
     contents += new Label{
        text = "-"
    }

     contents += new Label{
        text = "-"
    }
     contents += new Label{
        text = "-"
    }
    contents += new Button{
            background = gray
    }
    }

    val secondLine = new GridPanel(1, 13){
        contents += new Label{
        text = "|"
    }
    contents += new Label{
        text = " "
    }
     contents += new Label{
        text = " "
    }
     contents += new Label{
        text = " "
    }
     contents += new Label{
        text = " "
    }
     contents += new Label{
        text = " "
    }
    contents += new Label{
        text = "|"
    }
    contents += new Label{
        text = " "
    }
     contents += new Label{
        text = " "
    }
     contents += new Label{
        text = " "
    }
     contents += new Label{
        text = " "
    }
     contents += new Label{
        text = " "
    }
    contents += new Label{
        text = "|"
    }
    }

    val spielfeld = new GridPanel(11, 1){
       contents += firstLine
       contents += secondLine

   
    }

    val circle = new TextField() {
        columns = 10
    }
    val column = new TextField() {
        columns = 10
    }
    //contents += player1
    contents += circle
    contents += column
    contents += spielfeld

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
