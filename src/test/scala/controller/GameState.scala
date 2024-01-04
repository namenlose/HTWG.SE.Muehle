package HTWG.SE.Muehle.test.scala.controller

import HTWG.SE.Muehle.controller.{blackState, whiteState}
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class GameStateSpec extends AnyWordSpec {

  var currentState = ""

  "A whiteState" should {
    "handle the state transition to 'Weiss ist dran'" in {
      val whiteState = new whiteState()
      currentState = whiteState.handle()
      currentState should be("Weiss ist dran")
    }
  }

  "A blackState" should {
    "handle the state transition to 'Schwarz ist dran'" in {
      val blackState = new blackState()
      currentState = blackState.handle()
      currentState should be("Schwarz ist dran")
    }
  }

  "The game state" should {
    "change to 'Weiss ist dran' when transitioning from blackState to whiteState" in {
      var currentState = new blackState().handle()
      currentState should be("Schwarz ist dran")

      currentState = new whiteState().handle()
      currentState should be("Weiss ist dran")
    }

    "change to 'Schwarz ist dran' when transitioning from whiteState to blackState" in {
      var currentState = new whiteState().handle()
      currentState should be("Weiss ist dran")

      currentState = new blackState().handle()
      currentState should be("Schwarz ist dran")
    }
  }
}
