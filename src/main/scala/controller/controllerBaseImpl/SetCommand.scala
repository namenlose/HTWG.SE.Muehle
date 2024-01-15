package HTWG.SE.Muehle.controller.controllerBaseImpl

import HTWG.SE.Muehle.util.{Command, Observable}
import HTWG.SE.Muehle.controller.controllerBaseImpl.Controller
import HTWG.SE.Muehle.model.FieldComponent.FieldBaseComponent.{FieldArray}
import HTWG.SE.Muehle.model.logicComponent.{Mill, MillList, MillListInterface}
import scala.util.Try
import scala.util.Failure
import java.{util => ju}

class SetCommand(ind1:Int, ind2: Int, player1: Char,/*, player2: Char, i: Int, mesh: String,*/ controller: Controller, millList: MillListInterface) extends Command{

override def doStep: Unit = {
    controller.controllerPlaceStones(ind1, ind2, player1/* player2, i, mesh*/)}
override def undoStep: String ={
  val posToRemove = ind1 * 10 + ind2
  millList.MillListRemove(posToRemove)
  //println("remove: " + posToRemove)
   controller.array.placeStone(ind1, ind2, 'o')
 }
def undoStep1: Try[String] = {
  Failure(new NoSuchElementException(""))
}

def getPositon: Array[Int] ={
    val array = Array(ind1, ind2)
    array
}
 /*override def redoStep: Unit ={
   controller.controllerPlaceStones(ind1, ind2, player1, player2, i, mesh)}*/
}