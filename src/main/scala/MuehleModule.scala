package HTWG.SE.Muehle

  import com.google.inject.AbstractModule
  import com.google.inject.name.Names
  import net.codingwell.scalaguice.ScalaModule
  import HTWG.SE.Muehle.controller._
  import HTWG.SE.Muehle.controller.controllerBaseImpl._
  import HTWG.SE.Muehle.model.FieldComponent.FieldBaseComponent.{FieldArray, Field}
  import HTWG.SE.Muehle.model.FieldComponent._
  import HTWG.SE.Muehle.model.logicComponent.Handler1


  class MuehleModule extends AbstractModule with ScalaModule {

    val fieldArray = new FieldArray
    val array = fieldArray.fieldArray

    override def configure(): Unit = {
      //bindConstant().annotatedWith(Names.named("DefaultSize")).to(defaultSize)
      bind[controllerInterface].to[Controller]
      //bind[ControllerInterface].to[controllerBaseImpl.Controller]
      bind[FieldArrayInterface].toInstance(new FieldArray)
      bind[FieldInterface].toInstance(new Field(6, array))
      //bind[GridInterface].annotatedWithName("small").toInstance(new Grid(4))
      //bind[GridInterface].annotatedWithName("normal").toInstance(new Grid(9))
    }

}