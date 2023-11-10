package HTWG.SE.Muehle.controller
import HTWG.SE.Muehle.model.{FieldArray, Field}
import HTWG.SE.Muehle.util.Observable

class Controller() extends Observable{

    val array: FieldArray = new FieldArray()
    val field1: Field = new Field(6, array.fieldArray)

        def controllerPlaceFirstStone(ind1: Int, ind2: Int, player: Char): String = {
        
        array.placeStone(ind1, ind2, player)
        val field2: Field = new Field(6, array.fieldArray)
        notifyObservers
        field2.mesh
    }

        def controllerPlaceStones(ind1: Int, ind2: Int, player1: Char, player2: Char, i: Int, mesh: String) = {
        var mesh2 = mesh
        if(i % 2 == 0){
            array.placeStone(ind1, ind2, player1)
            val i: Field = new Field(6, array.fieldArray)
            mesh2 = i.mesh
        }else{
            array.placeStone(ind1, ind2, player2)
            val i: Field = new Field(6, array.fieldArray)
            mesh2 = i.mesh
        }
        notifyObservers
    }

}