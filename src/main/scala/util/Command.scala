package HTWG.SE.Muehle.util

trait Command {
 def doStep:Unit
 def undoStep:String
 def getPositon:Array[Int]
 /*def redoStep:Unit*/
}