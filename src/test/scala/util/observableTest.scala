/*package HTWG.SE.Muehle.test.scala.util

import HTWG.SE.Muehle.aview.TUI
import HTWG.SE.Muehle.controller.Controller
import HTWG.SE.Muehle.model.{FieldArray, Field}
import HTWG.SE.Muehle.util.*
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class ObservableSpec extends AnyWordSpec  {
  "An Observable" should {
    val observable = new Observable
    val observer = new Observer {
      var updated: Boolean = false
      def isUpdated: Boolean = updated
      override def update: Boolean = {updated = true; updated}
    }
    "add an Observer" in {
      observable.add(observer)
      observable.subscribers should contain (observer)
    }
   /* "notify an Observer" in {
      observer.isUpdated should be(false)
      observable.notifyObservers
      observer.isUpdated should be(true)
    }*/
    "remove an Observer" in {
      observable.remove(observer)
      observable.subscribers should not contain (observer)
    }

  }

}*/