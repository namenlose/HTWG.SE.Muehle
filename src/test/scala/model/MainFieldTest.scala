package HTWG.SE.Muehle.test.scala.model
import HTWG.SE.Muehle.aview.TUI
import HTWG.SE.Muehle.model.FieldComponent.FieldBaseComponent.{FieldArray, Field}
import HTWG.SE.Muehle.controller.controllerBaseImpl.Controller
import org.scalatest.wordspec.AnyWordSpec
import org.scalatest.matchers.should.Matchers._


class MainFieldTest extends AnyWordSpec {

 "Muehle" should {
  
  val array = new FieldArray()
  val field = new Field(6, array.fieldArray)

   "have a bar as String of form 'o------o------o'" in {
     field.bar(field.groeße, field.array(0)(0), field.array(0)(1) ,field.array(0)(2)) should be("o------o------o" + field.eol)
   }
   "have a line of form |      |      |" in {
     field.line() should be("|      |      |" + field.eol)
   }
   "have cells as String of form '| o----o----o |'" in {
     field.cells(field.groeße - 2, field.array(1)(0), field.array(1)(1), field.array(1)(2)) should be("| o----o----o |" + field.eol)
   }
   "have a line2 as String of form | |    |    | |'" in {
     field.line2() should be("| |    |    | |" + field.eol)
   }
    "have cells3 as String of form '| | o--o--o | |'" in {
     field.cells3(field.groeße - 4, field.array(2)(0), field.array(2)(1), field.array(2)(2)) should be("| | o--o--o | |" + field.eol)
   }
    "have cells4 as String of form 'o-o-o     o-o-o'" in {
     field.cells4(2 *(field.groeße - 4) + 1, field.array(0)(7), field.array(1)(7), field.array(2)(7), field.array(2)(3), field.array(1)(3), field.array(0)(3)) should be("o-o-o     o-o-o" + field.eol)
   }

   "have cells5 as String of form '| | o--o--o | |'" in{
    field.cells5(field.groeße - 4, field.array(2)(6), field.array(2)(5), field.array(2)(4)) should be("| | o--o--o | |" + field.eol)
   }

   "have cells6 as String of form '| o----o----o |'" in{
    field.cells6(field.groeße - 2, field.array(1)(6), field.array(1)(5), field.array(1)(4)) should be("| o----o----o |" + field.eol)
   }

   "have a bar2 as String of form 'o------o------o'" in {
     field.bar2(field.groeße, field.array(0)(6), field.array(0)(5) , field.array(0)(4)) should be("o------o------o" + field.eol)
}
}
}