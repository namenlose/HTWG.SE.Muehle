/*package HTWG.SE.Muehle.test.scala.aview
import HTWG.SE.Muehle.aview.TUI
import HTWG.SE.Muehle.controller.Controller
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class TUITest extends AnyWordSpec {

    "The TUI" should {

        val controller = new Controller()
        val tui = new TUI(controller)
        
        "Create a field and set a first Stone(whith player one = black an position 0,0)" in{
            tui.firstStone() should be(controller.controllerPlaceFirstStone(0, 0, 'b'))
        }

        "Create a field and set a first Stone(whith player one = white an position 0,1)" in{
            tui.firstStone() should be(controller.controllerPlaceFirstStone(0, 1, 'w'))
        }

        
    }
}*/

