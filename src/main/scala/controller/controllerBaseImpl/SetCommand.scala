package HTWG.SE.Muehle.controller.controllerBaseImpl

import HTWG.SE.Muehle.util.{Command, Observable}
import HTWG.SE.Muehle.controller.controllerBaseImpl.Controller
import HTWG.SE.Muehle.model.FieldComponent.{FieldArray}
import scala.util.Try
import scala.util.Failure
import java.{util => ju}
//import java.util.Observable
//import java.util.Observable

class SetCommand(ind1:Int, ind2: Int, player1: Char, player2: Char, i: Int, mesh: String, controller: Controller) extends Command{

override def doStep: Unit = {
    controller.controllerPlaceStones(ind1, ind2, player1, player2, i, mesh)}
override def undoStep: String ={
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