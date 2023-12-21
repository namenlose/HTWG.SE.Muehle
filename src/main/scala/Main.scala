package HTWG.SE.Muehle
import HTWG.SE.Muehle.aview.{TUI, Gui}
import HTWG.SE.Muehle.controller.controllerInterface
import HTWG.SE.Muehle.model.FieldComponent.FieldBaseComponent.{FieldArray, Field}
import HTWG.SE.Muehle.controller.controllerBaseImpl.Controller
import HTWG.SE.Muehle.MuehleModule
import scala.io.StdIn.readLine
import scala.io.StdIn.readInt
import scala.io.StdIn.readChar
import com.google.inject.Guice


@main def MainMuehle: Unit =

  val injector = Guice.createInjector(new MuehleModule)
  //val controller: controllerInterface = new Controller()
  val controller = injector.getInstance(classOf[controllerInterface])
  val TUI: TUI = new TUI(controller)
  //val array: FieldArray = new FieldArray()

  //val test = array.placeStone(1, 1)
  //val mesh = TUI.firstStone()
  val gui: Gui = new Gui(controller)
  //gui.visible = true
  TUI.firstStone()
 
