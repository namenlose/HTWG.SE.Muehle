package HTWG.SE.Muehle.controller
import HTWG.SE.Muehle.model.{FieldArray, Field, Handler1}
import HTWG.SE.Muehle.util.Observable


class Controller() extends Observable{

    val array: FieldArray = new FieldArray()
    val field1: Field = new Field(6, array.fieldArray)
    val handler1: Handler1 = new Handler1(array.fieldArray)
    var fieldString = ""
    
    def controllerPlaceFirstStone(ind1: Int, ind2: Int, player: Char): String = {
        
        fieldString = array.placeStone(ind1, ind2, player)
        notifyObservers
        fieldString
    }

    def controllerPlaceStones(ind1: Int, ind2: Int, player1: Char, player2: Char, i: Int, mesh: String): String = {

        if(i % 2 == 0){
            fieldString = array.placeStone(ind1, ind2, player1)
            if(handler1.checkRequirement(array.fieldArray) == true){
                println("MÜHLE!!")
            }
        }else{
            fieldString = array.placeStone(ind1, ind2, player2)
             if(handler1.checkRequirement(array.fieldArray) == true){
                println("MÜHLE!!")
            }
        }
        notifyObservers
        fieldString
        
    }
    def getFieldString() = fieldString

}