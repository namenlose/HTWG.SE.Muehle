package HTWG.SE.Muehle
import HTWG.SE.Muehle.aview.TUI
import HTWG.SE.Muehle.model.{FieldArray, Field}
import HTWG.SE.Muehle.controller.Controller
import scala.io.StdIn.readLine
import scala.io.StdIn.readInt
import scala.io.StdIn.readChar


@main def MainMuehle: Unit =

  val controller: Controller = new Controller()
  val TUI: TUI = new TUI(controller)
  //val array: FieldArray = new FieldArray()

  //val test = array.placeStone(1, 1)
  //val mesh = TUI.firstStone()
  TUI.firstStone()
 
