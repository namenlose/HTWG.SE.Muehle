/*package HTWG.SE.Muehle.aview

import scala.swing.FlowPanel.Alignment
import scala.swing._
import HTWG.SE.Muehle.controller._
import HTWG.SE.Muehle.util._
import javax.swing.ImageIcon
import javax.print.attribute.standard.OrientationRequested
import java.awt.Dimension
import scala.swing.event._

class GUIField(controller: Controller) extends MainFrame with Observer {
val firstFrame = new MainFrame {
    contents = new BoxPanel(Orientation.Vertical) {
        title = "Muehle"
        private val ImageIcon = new ImageIcon("/src/Fotos/test.png")
        private val imageSize = new Dimension(ImageIcon.getIconWidth, ImageIcon.getIconHeight)

        preferredSize = imageSize
        contents += ImageIcon

reactions += {
    case MouseClicked(_, p, _, _, _) =>
    val x = p.getX.toInt
    val y = p.getY.toInt
    println(s"Mausklick bei x=$x, y=$y")
}
        pack()
        centerOnScreen()
        open()
    }
    
/*private val ImageIcon = new ImageIcon("/src/Fotos/test.png")
private val imageSize = new Dimension(ImageIcon.getIconWidth, ImageIcon.getIconHeight)

preferredSize = imageSize

reactions += {
    case MouseClicked(_, p, _, _, _) =>
    val x = p.getX.toInt
    val y = p.getY.toInt
    println(s"Mausklick bei x=$x, y=$y")
}*/

}

   override def update: Unit = {
        
    }

}*/