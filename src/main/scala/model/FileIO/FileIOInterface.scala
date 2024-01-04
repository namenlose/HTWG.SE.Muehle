package HTWG.SE.Muehle.model.FileIO

import HTWG.SE.Muehle.model.FieldComponent.FieldArrayInterface
import scala.xml.{ NodeSeq, PrettyPrinter }

trait FileIOInterface{

    def save(array: FieldArrayInterface): Unit
    def fieldArrayToXML(array: FieldArrayInterface): xml.Node
    def load: FieldArrayInterface
}

