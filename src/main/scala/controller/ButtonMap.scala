package HTWG.SE.Muehle.controller

import scala.swing._
import HTWG.SE.Muehle.controller.controllerBaseImpl._
import HTWG.SE.Muehle.controller._

class ButtonMap(controller: controllerInterface, color: Char){
    val gray = new Color(150,150,150)
    var color2 = color
    val buttonMap = createButtonMap

      def createButtonMap: Map[(Int, Int), Button] = {
        val rows = 3
        val columns = 8
        val buttons = for {
          row <- 0 until rows
          col <- 0 until columns
        } yield {
          val button = new Button {
            background = gray
            val posToRemove = row * 10 + col
            reactions += {
              case event.ButtonClicked(_) =>
                  if(!controller.muehleBool && !controller.setStoneGui(row, col, color)){
                    background = controller.getColor(row, col)
                  }else if(background == new Color(0,0,0) && !controller.placeabel && !controller.muehleBool){
                    color2 = 'b'
                    controller.doStepMove(row, col, 'b')
                    controller.millList.MillListRemove(posToRemove)
                    updateButtonMap
                    controller.setPlaceableTrue
                  }else if(background == new Color(255,255,255) && !controller.placeabel && !controller.muehleBool){
                    color2 = 'w'
                    controller.doStepMove(row, col, 'w')
                    controller.millList.MillListRemove(posToRemove)
                    updateButtonMap
                    controller.setPlaceableTrue
                  }else if(background == new Color(150,150,150) && controller.placeabel && !controller.muehleBool){
                    controller.controllerMove(row, col,  color2)
                    updateButtonMap
                    controller.setPlaceableFalse
                  }else if(controller.muehleBool){
                    controller.doStep(row, col, 'o')
                    controller.setMuehleFalse
                    updateButtonMap
                  }
            }
          }
          (row, col) -> button
        }
        buttons.toMap
      }

      def updateButtonMap ={
        for(i <- 0 to 2){
                for(x <- 0 to 7){
                    val button = buttonMap((i,x))
                    button.background = controller.getColor(i,x)
                }
            }

      }
}