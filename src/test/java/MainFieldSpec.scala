import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._

  class MainFieldSpec extends AnyWordSpec {
    "bar" should {
      "generate the expected string" in {
        val result = bar(6, 2) // Call the bar function with appropriate arguments
        val expected = "o------o------o" + sys.props("line.separator")
        assert(result === expected)
      }
    }

  }


