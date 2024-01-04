package HTWG.SE.Muehle.test.scala.aview

import scala.swing._
import HTWG.SE.Muehle.controller.controllerBaseImpl._
import HTWG.SE.Muehle.model.ButtonMap
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class ButtonMapTest extends AnyWordSpec {

  val controller = new Controller() // You may need to adjust this based on your actual controller class
  val buttonMap = new ButtonMap(controller, 'b')

  "ButtonMap" should {

    "create a button map with the correct size" in {
      val createdMap = buttonMap.createButtonMap
      createdMap.size should be(24) // Adjust this based on your actual button map size
    }

    "set stone and update button color on button click" in {
      val createdMap = buttonMap.createButtonMap
      val buttonToClick = createdMap((0, 0))

      buttonToClick.doClick()

      controller.getColor(0, 0) should be(buttonToClick.background)
    }

    // Add more test cases as needed

  }
}
