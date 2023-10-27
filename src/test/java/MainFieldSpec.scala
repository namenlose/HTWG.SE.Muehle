import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

  class MainFieldSpec extends AnyWordSpec {
    "bar" should {
      "generate the expected string" in {
        val result = bar(6, 2)
        val expected = "o------o------o" + eol
        assert(result === expected)
      }
    }
    bar(10, 3) should be("o----------o----------o----------o" + eol)

    "line" should {
      "generate the expected string" in {
        line(6, 2) should be("|      |      |" + eol)
        line(4, 4) should be("|    |    |    |    |" + eol)
      }
    }
    "cells" should {
      "generate the expected string" in {
        cells(3, 2, 2) should be("| o---o---o |" + eol)
        cells(6, 2, 3) should be("| o------o--o------o |" + eol)
      }
    }
  }




