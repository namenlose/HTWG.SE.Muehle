 package HTWG.SE.Muehle.test.scala.aview

import scala.swing._
import HTWG.SE.Muehle.controller.controllerBaseImpl._
import HTWG.SE.Muehle.controller.ButtonMap
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class ButtonMapTest extends AnyWordSpec {

  val controller = new Controller() // You may need to adjust this based on your actual controller class
  val buttonMap = new ButtonMap(controller, 'b')
  val createdMap = buttonMap.createButtonMap

  "ButtonMap" should {

    "create a button map with the correct size" in {
      createdMap.size should be(24) // Adjust this based on your actual button map size
    }

    "set stone and update button color on button click" in {
      val buttonToClick = createdMap((0, 0))
      buttonToClick.doClick()
      controller.getColor(0, 0) should be(buttonToClick.background)
    }

    "update all buttons" in{
      buttonMap.updateButtonMap
      for(i <- 0 to 2){
                for(x <- 0 to 7){
                  val button = createdMap((i,x))
                  controller.getColor(i, x) should be(button.background)
                }
      }
    }

  }
}
 