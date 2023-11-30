package HTWG.SE.Muehle.controller

import HTWG.SE.Muehle.util.Command
import HTWG.SE.Muehle.controller.Controller
import HTWG.SE.Muehle.model.{FieldArray}

class SetCommand(ind1:Int, ind2: Int, player1: Char, player2: Char, i: Int, mesh: String, controller: Controller) extends Command {

 override def doStep: Unit = {
    controller.controllerPlaceStones(ind1, ind2, player1, player2, i, mesh)}
 override def undoStep: String ={
   controller.array.placeStone(ind1, ind2, 'o')
 }
 /*override def redoStep: Unit ={
   controller.controllerPlaceStones(ind1, ind2, player1, player2, i, mesh)}*/
}