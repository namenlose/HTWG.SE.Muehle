package HTWG.SE.Muehle.controller

trait GameState {
    def handle(): String
}

var currentState = ""
class whiteState() extends GameState {
    
    override def handle(): String ={
        currentState = "Weiss ist dran"
        currentState
    }
}
case class blackState() extends GameState {
    override def handle(): String = {
        currentState = "Schwarz ist dran"
        currentState
    }
}


