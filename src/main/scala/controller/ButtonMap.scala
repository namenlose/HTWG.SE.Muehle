package HTWG.SE.Muehle.model

import scala.swing._
import HTWG.SE.Muehle.controller.controllerBaseImpl._
import HTWG.SE.Muehle.controller._

class ButtonMap(controller: controllerInterface, color: Char){
    val gray = new Color(150,150,150)

  def createButtonMap: Map[(Int, Int), Button] = {
    val rows = 3
    val columns = 8
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
}