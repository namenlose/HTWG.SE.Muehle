package HTWG.SE.Muehle.controller

trait GameState {
    def handle(): String
}

var currentState = ""
class whiteState() extends GameState {
    
    override def handle(): String ={
        currentState = "Weiss ist dran"
        //context.state = new blackState
        //println("weiss")
        currentState
    }
}
case class blackState() extends GameState {
    override def handle(): String = {
        currentState = "Schwarz ist dran"
        //context.state = new whiteState
        //println("schwarz")
        currentState
    }
}

/* class Context(var state: GameState) {
    def request(): Unit = state.handle(this)
    //def message() = currentState
}


object StateClient extends App {
    val context = new Context(new whiteState)
    
    context.request()
    context.request()
}  */
