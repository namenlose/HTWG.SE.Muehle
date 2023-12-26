package HTWG.SE.Muehle.model.logicComponent

trait MillInterface {
    def millGetPos: Array[Int]
}

trait MillListInterface {
    var millList: List[Mill]
    def MillListAdd(muehle: Mill): List[Mill]
    def MillListRemove(pos: Int): List[Mill]
    def isInMillList(muehle: Mill): Boolean
}
