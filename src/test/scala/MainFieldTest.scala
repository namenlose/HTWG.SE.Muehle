package HTWG.SE.Muehle
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._


class MainFieldTest extends AnyWordSpec {
  //@main def hello: Unit =
 "Muehle" should {
   "have a bar as String of form 'o------o------o'" in {
     bar() should be("o------o------o" + eol)
   }
   "have a scalable bar" in {
     bar(4, 2) should be("o----o----o" + eol)
     bar(6, 3) should be("o------o------o------o" + eol)
     bar(6, 4) should be("o------o------o------o------o" + eol)
   }
   "have a line of form |      |      |" in {
     line() should be("|      |      |" + eol)
   }
   "have a scalable line" in {
     line(4, 2) should be("|    |    |" + eol)
     line(6, 3) should be("|      |      |      |" + eol)
     line(6, 4) should be("|      |      |      |      |" + eol)
   }
   "have cells as String of form '| o----o----o |'" in {
     cells() should be("| o----o----o |" + eol)
   }
   "have scalable cells" in {
     cells(2, 4, 2) should be("| o--o--o |" + eol)
     cells(4, 6, 3) should be("| o----o------o----o |" + eol)
     cells(4, 6, 4) should be("| o----o------o------o----o |" + eol)
   }
   "have a line2 as String of form | |    |    | |'" in {
     line2() should be("| |    |    | |" + eol)
   }
   "have a scalable line2" in {
     line2(2, 4, 2) should be("| |  |  | |" + eol)
     line2(4, 6, 3) should be("| |    |      |    | |" + eol)
     line2(4, 6, 4) should be("| |    |      |      |    | |" + eol)
   }
    "have cells3 as String of form '| | o--o--o | |'" in {
     cells3() should be("| | o--o--o | |" + eol)
   }
   "have scalable cells3" in {
     cells3(0, 4, 2) should be("| | ooo | |" + eol)
     cells3(2, 6, 3) should be("| | o--o------o--o | |" + eol)
     cells3(2, 6, 4) should be("| | o--o------o------o--o | |" + eol)
   }
    "have cells4 as String of form 'o-o-o     o-o-o'" in {
     cells4() should be("o-o-o     o-o-o     " + eol)
   }
   "have scalable cells4" in {
     cells4(2, 1) should be("o-o-o o-o-o " + eol)
     cells4(2, 12) should be("o-o-o            o-o-o            " + eol)
     cells4(2, 19) should be("o-o-o                   o-o-o                   " + eol)
   }
}
}