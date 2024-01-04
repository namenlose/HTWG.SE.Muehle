package HTWG.SE.Muehle

  import com.google.inject.AbstractModule
  import com.google.inject.name.Names
  import net.codingwell.scalaguice.ScalaModule
  import HTWG.SE.Muehle.controller._
  import HTWG.SE.Muehle.controller.controllerBaseImpl._
  import HTWG.SE.Muehle.model.FieldComponent.FieldBaseComponent.{FieldArray, Field}
  import HTWG.SE.Muehle.model.FieldComponent._
  import HTWG.SE.Muehle.model.FileIO.FileIOInterface
  import HTWG.SE.Muehle.model.logicComponent.Handler1
  import HTWG.SE.Muehle.model.logicComponent.{MillList, MillListInterface}
  import HTWG.SE.Muehle.model.FileIO.FielIOXml.FileIO


  class MuehleModule extends AbstractModule with ScalaModule {

    val fieldArray = new FieldArray
    val array = fieldArray.fieldArray

    override def configure(): Unit = {
      bind[controllerInterface].to[Controller]
      bind[FieldArrayInterface].toInstance(new FieldArray)
      bind[FieldInterface].toInstance(new Field(6, array))
      bind[MillListInterface].toInstance(new MillList)
      bind[FileIOInterface].toInstance(new FileIO)
    }

}