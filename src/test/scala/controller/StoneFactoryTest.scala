package HTWG.SE.Muehle.test.scala.controller

import HTWG.SE.Muehle.controller.{StoneFactory, whiteS, blackS}
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class StoneFactoryTest extends AnyWordSpec {

  "whiteS" should {
    "return 'w' as the color" in {
      val whiteStone: StoneFactory = new whiteS()
      whiteStone.color() should be('w')
    }
  }

  "blackS" should {
    "return 'b' as the color" in {
      val blackStone: StoneFactory = new blackS()
      blackStone.color() should be('b')
    }
  }
}
