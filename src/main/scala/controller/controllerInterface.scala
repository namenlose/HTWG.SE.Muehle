package HTWG.SE.Muehle.controller

import scala.swing._
import HTWG.SE.Muehle.util._
import HTWG.SE.Muehle.model.FieldComponent.FieldBaseComponent._
import HTWG.SE.Muehle.model.FieldComponent.{FieldInterface, FieldArrayInterface}

trait controllerInterface extends Observable {
    def handle(): String
    def turn(): Unit
    //def controllerPlaceFirstStoneind1(ind1: Int, ind2: Int, player: Char): String
    def controllerPlaceFirstStone(ind1: Int, ind2: Int, player: Char): String
    def controllerPlaceStones(ind1: Int, ind2: Int, player1: Char, player2: Char, i: Int, mesh: String): String
    def muehle(array: FieldArrayInterface): Boolean
    def getFieldString(): String
    def field1: FieldInterface
    def setStoneGui(pos1: Int, pos2: Int, color: Char): Unit
    def getColor(ind1: Int, ind2: Int): Color
    def doStep(ind1:Int, ind2: Int,  player1: Char, player2: Char, i: Int, mesh: String): Unit
    def undoStep: Unit
    def redoStep: Unit
}