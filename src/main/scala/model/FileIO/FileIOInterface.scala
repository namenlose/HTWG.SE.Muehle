package HTWG.SE.Muehle.model.FileIO

import HTWG.SE.Muehle.model.FieldComponent.FieldArrayInterface
import scala.xml.{ NodeSeq, PrettyPrinter }

trait FileIOInterface{

    var counter: Int
    def save(array: FieldArrayInterface, counter: Int): Unit
    //def save(array: FieldArrayInterface): Unit
    //def fieldArrayToXML(array: FieldArrayInterface, counter: Int): xml.Node
    def load: FieldArrayInterface
}

