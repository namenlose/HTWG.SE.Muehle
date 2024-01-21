package HTWG.SE.Muehle.test.scala.controller

import HTWG.SE.Muehle.model.logicComponent.{Mill, MillList, MillListInterface}
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class MillListTest extends AnyWordSpec {

  "A MillList" should {
    val mill1 = new Mill(0, 1, 2)
    val mill2 = new Mill(3, 4, 5)
    val mill3 = new Mill(6, 7, 8)

    "add a Mill to the list" in {
      val millList: MillListInterface = new MillList()
      millList.MillListAdd(mill1)
      millList.MillListAdd(mill2)

      millList.millList.size should be(2)
      millList.millList should contain(mill1)
      millList.millList should contain(mill2)
    }

    "remove a Mill from the list based on position" in {
      val millList: MillListInterface = new MillList()
      millList.MillListAdd(mill1)
      millList.MillListAdd(mill2)
      millList.MillListAdd(mill3)

      millList.MillListRemove(4)

      millList.millList.size should be(2)
      millList.millList should contain(mill1)
      millList.millList should not contain mill2
      millList.millList should contain(mill3)
    }

    "check if a Mill is in the list" in {
      val millList: MillListInterface = new MillList()
      millList.MillListAdd(mill1)
      millList.MillListAdd(mill2)

      millList.isInMillList(mill1) should be(true)
      millList.isInMillList(mill2) should be(true)
      millList.isInMillList(mill3) should be(false)
    }
  }
}
