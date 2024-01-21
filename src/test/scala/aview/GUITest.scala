package HTWG.SE.Muehle.test.scala.aview

import HTWG.SE.Muehle.aview.{Gui, GuiField}
import HTWG.SE.Muehle.controller.controllerBaseImpl.Controller
import HTWG.SE.Muehle.controller.controllerInterface
import HTWG.SE.Muehle.util.Event
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class GuiTest extends AnyWordSpec {

 /*  class TestController extends Controller {
    override def add(observer: Observer): Unit = {}
    override def remove(observer: Observer): Unit = {}
    override def notifyObservers(event: Event): Unit = {}
  }

  "Gui" should {
    "initialize properly" in {
      val testController: controllerInterface = new TestController()
      val gui = new Gui(testController)

      gui.title should be("Mill")
      gui.color should be(' ')
      gui.contents.size should be(1)
      gui.contents.headOption shouldBe a[BoxPanel]

      val boxPanel = gui.contents.head.asInstanceOf[BoxPanel]
      boxPanel.contents.size should be(3)

      val label = boxPanel.contents.head.asInstanceOf[Label]
      label.text should be("Wählen Sie eine Farbe")

      val buttonWhite = boxPanel.contents(1).asInstanceOf[Button]
      buttonWhite.text should be("Weiss")

      val buttonBlack = boxPanel.contents(2).asInstanceOf[Button]
      buttonBlack.text should be("Schwarz")
    } */
/* 
    "update properly on Event.mill" in {
      val testController: controllerInterface = new TestController()
      val gui = new Gui(testController)

      gui.update(Event.mill)
      // Add assertions for the expected changes in the GUI
    }

    "update properly on Event.doStep" in {
      val testController: controllerInterface = new TestController()
      val gui = new Gui(testController)

      gui.update(Event.doStep)
      // Add assertions for the expected changes in the GUI
    }

    "update properly on Event.undo" in {
      val testController: controllerInterface = new TestController()
      val gui = new Gui(testController)

      gui.update(Event.undo(0, 0))
      // Add assertions for the expected changes in the GUI
    } */
  }

