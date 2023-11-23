package HTWG.SE.Muehle.controller

trait GameState {
    def handle(context: Context): Unit
}

case class whiteState() extends GameState {
    def handle(context: Context): Unit ={
        println("Weiss ist dran")
        context.state = new whiteState
    }
}
case class blackState() extends GameState {
    def handle(context: Context): Unit = {
        println("Schwarz ist dran")
        context.state = new blackState 
    }
}
class Context(var state: GameState) {
    def request(): Unit = state.handle(this)
}
object StateClient extends App {
    val context = new Context(new whiteState)
    context.request()
    context.request()
}
