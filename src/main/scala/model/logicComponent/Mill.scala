package HTWG.SE.Muehle.model.logicComponent

class Mill(pos1: Int, pos2: Int, pos3: Int){
    def millGetPos: Array[Int] ={
        val positions: Array[Int] = Array(pos1, pos2, pos3)
        positions
    }
}

class MillList extends MillListInterface{

    var millList: List[Mill] = List()

    def MillListAdd(muehle: Mill): List[Mill] = {
        millList = muehle +: millList
        millList
    }

    def MillListRemove(pos: Int): List[Mill] = {
        for(m <- millList){
            val arrayM = m.millGetPos
            if(arrayM(0) == pos || arrayM(1) == pos || arrayM(2) == pos){
                 millList = millList.filter(_ != m)
            }
        }
        millList
    }

    def isInMillList(muehle: Mill): Boolean = {
        var bool = false
        for(m <- millList){
            val arrayM = m.millGetPos
            val arrayMuehle = muehle.millGetPos
            if(arrayM(0) == arrayMuehle(0) && arrayM(1) == arrayMuehle(1) && arrayM(2) == arrayMuehle(2)){
                bool = true
            }
        }
        bool
    }
}
