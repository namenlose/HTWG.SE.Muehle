package HTWG.SE.Muehle.test.util

import HTWG.SE.Muehle.util.{Event, Observable, Observer}
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

class ObservableTest extends AnyWordSpec {

  class TestObserver extends Observer {
    var updatedEvent: Option[Event] = None

    override def update(e: Event): Unit = updatedEvent = Some(e)
  }

  "Observable" should {
    "add and notify observers" in {
      val observable = new Observable
      val observer1 = new TestObserver
      val observer2 = new TestObserver

      observable.add(observer1)
      observable.add(observer2)

      val testEvent = Event.StonePlaced(1, 2, 'a')
      observable.notifyObservers(testEvent)

      observer1.updatedEvent should be(Some(testEvent))
      observer2.updatedEvent should be(Some(testEvent))
    }

    "remove observer" in {
      val observable = new Observable
      val observer1 = new TestObserver
      val observer2 = new TestObserver

      observable.add(observer1)
      observable.add(observer2)

      observable.remove(observer1)

      val testEvent = Event.StonePlaced(1, 2, 'a')
      observable.notifyObservers(testEvent)

      observer1.updatedEvent should be(None)
      observer2.updatedEvent should be(Some(testEvent))
    }
  }
}
