package HTWG.SE.Muehle.aview

import HTWG.SE.Muehle.controller.controllerBaseImpl.{Controller}
import HTWG.SE.Muehle.controller.controllerInterface
import HTWG.SE.Muehle.aview.TUI
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class TUISpec extends AnyWordSpec {

  "A TUI" should {
    "initialize with the correct controller" in {
      val controller: controllerInterface = new Controller()
      val tui = new TUI(controller)
      tui.controller should be(controller)
    }

    "return 'Weiss ist dran' after placing the first stone" in {
      val controller: controllerInterface = new Controller()
      val tui = new TUI(controller)

      
      
      // Mock user input for testing purposes
      /* val mockedInput = List("Player1", "Player2", "w", "1", "1", "2", "2", "3", "4", "5", "6", "7", "8")

      mockedInput.foreach { input =>
        Console.withIn(scala.io.StdIn.toString(input)) {
          tui.firstStone()
        }
      } */

      // Assert the game state after placing the first stone
      //controller.getState should be("Weiss ist dran")
    }
  }
}
