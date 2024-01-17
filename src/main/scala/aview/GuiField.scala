package HTWG.SE.Muehle.aview

import scala.swing.FlowPanel.Alignment
import scala.swing._
import javax.swing.table._
import HTWG.SE.Muehle.controller._
import HTWG.SE.Muehle.controller.controllerBaseImpl._
import HTWG.SE.Muehle.util._
import HTWG.SE.Muehle.controller.ButtonMap
import javax.swing.ImageIcon
import javax.print.attribute.standard.OrientationRequested
 
 
 class GuiField(controller: controllerInterface)extends Observer{
    controller.add(this)
    val gray = new Color(150,150,150)
    var buttonMapClass = new ButtonMap(controller, 'w')

    var muehle = new Label("Keine Muehle")
    var alleSteineGesetzt = new Label(" ")

    def muehleLabel = {
        muehle.text = "Muehle"
    }

    def alleSteineGesetztLabel = {
        alleSteineGesetzt.text = "Es wurden alle Steine platziert, jetzt könnt ihr Steine verschieben"
    }

  def keinMuehleLable = {
    muehle.text = "keine Mühle"
  }

    def updateField ={
        /*for(i <- 0 to 2){
            for(x <- 0 to 7){
                val button = buttonMap((i,x))
                button.background = controller.getColor(i,x)
            }
        }*/
        buttonMapClass.updateButtonMap
    }

  def playPanel(color: Char) = new FlowPanel {
    def createLine: Label = new Label {
      text = "-"
    }

    def createVerticalLine: Label = new Label {
      text = "|"
    }

    def createSpace: Label = new Label {
      text = " "
    }

    buttonMapClass = new ButtonMap(controller, color)

    def createButtonPanel(row: Int, colRange: Range): GridPanel = new GridPanel(1, 13) {
      colRange.foreach(col => {
        val button = buttonMapClass.buttonMap((row, col))
        contents += button
        if (col < 2) {
          contents ++= Seq.fill(5)(createLine)
        }
      })
    }

    def secondLine: GridPanel = new GridPanel(1, 13) {
      contents += createVerticalLine
      (1 to 5).foreach(_ => contents += createSpace)
      contents += createVerticalLine
      (1 to 5).foreach(_ => contents += createSpace)
      contents += createVerticalLine
    }

    val button3 = buttonMapClass.buttonMap((1, 0))
    val button4 = buttonMapClass.buttonMap((1, 1))
    val button5 = buttonMapClass.buttonMap((1, 2))

    val thirdLine: GridPanel = new GridPanel(1, 13) {
      contents += createVerticalLine
      contents += createSpace
      Seq(button3, button4, button5).zipWithIndex.foreach { case (button, index) =>
        contents += button
        if (index < 2) {
          (1 to 3).foreach(_ => contents += createLine)
        }
      }
      contents += createSpace
      contents += createVerticalLine
    }

    def forthLLine: GridPanel = new GridPanel(1, 13) {
      contents ++= Seq(createVerticalLine, createSpace, createVerticalLine)
      (1 to 3).foreach(_ => contents += createSpace)
      contents += createVerticalLine
      (1 to 3).foreach(_ => contents += createSpace)
      contents ++= Seq(createVerticalLine, createSpace, createVerticalLine)
    }

    val button6 = buttonMapClass.buttonMap((2, 0))
    val button7 = buttonMapClass.buttonMap((2, 1))
    val button8 = buttonMapClass.buttonMap((2, 2))

    def fifthLine: GridPanel = new GridPanel(1, 13) {
      Seq(
        createVerticalLine, createSpace, createVerticalLine,
        createSpace, button6, createLine,
        button7, createLine,
        button8, createSpace,
        createVerticalLine, createSpace, createVerticalLine
      ).foreach(contents += _)
    }

    def sixthLine: GridPanel = new GridPanel(1, 13) {
      Seq(
        createVerticalLine, createSpace, createVerticalLine,
        createSpace, createVerticalLine, createSpace,
        createSpace, createSpace, createSpace,
        createVerticalLine, createSpace, createVerticalLine
      ).foreach(contents += _)
    }

    val button9 = buttonMapClass.buttonMap((0, 7))
    val button10 = buttonMapClass.buttonMap((1, 7))
    val button11 = buttonMapClass.buttonMap((2, 7))
    val button12 = buttonMapClass.buttonMap((2, 3))
    val button13 = buttonMapClass.buttonMap((1, 3))
    val button14 = buttonMapClass.buttonMap((0, 3))

    val seventhLine = new GridPanel(1, 13) {
        Seq(
            button9, createLine,
            button10, createLine,
            button11, createSpace, createSpace, createSpace,
            button12, createLine,
            button13, createLine,
            button14
        ).foreach(contents += _)

    }

    val button15 = buttonMapClass.buttonMap((2, 6))
    val button16 = buttonMapClass.buttonMap((2, 5))
    val button17 = buttonMapClass.buttonMap((2, 4))

    val eighthLine = new GridPanel(1, 13) {
Seq(
  createVerticalLine, createSpace,
  createVerticalLine, createSpace,
  button15, createLine,
  button16, createLine,
  button17, createSpace,
  createVerticalLine, createSpace,
  createVerticalLine
).foreach(contents += _)

    }

    val button18 = buttonMapClass.buttonMap((1, 6))
    val button19 = buttonMapClass.buttonMap((1, 5))
    val button20 = buttonMapClass.buttonMap((1, 4))

    val ninthLine = new GridPanel(1, 13) {
        Seq(
            createVerticalLine, createSpace,
            button18, createLine,
            createLine, createLine,
            button19, createLine,
            createLine, createLine,
            button20, createSpace,
            createVerticalLine
        ).foreach(contents += _)

    }

    val button21 = buttonMapClass.buttonMap((0, 6))
    val button22 = buttonMapClass.buttonMap((0, 5))
    val button23 = buttonMapClass.buttonMap((0, 4))

    val tenthLine = new GridPanel(1, 13) {
Seq(
  button21, createLine,
  createLine, createLine, createLine, createLine,
  button22, createLine,
  createLine, createLine, createLine, createLine,
  button23
).foreach(contents += _)

    }

        def spielfeld: GridPanel = new GridPanel(13, 1){
        contents += createButtonPanel(0, 0 to 2)
        contents += secondLine
        contents += thirdLine
        contents += forthLLine
        contents += fifthLine
        contents += sixthLine
        contents += seventhLine
        contents += sixthLine
        contents += eighthLine
        contents += forthLLine
        contents += ninthLine
        contents += secondLine
        contents += tenthLine
        }

        contents += spielfeld
        contents += muehle
        contents += alleSteineGesetzt
        
        //pack()
        //centerOnScreen()
        //open()
    }
    override def update(e: Event): Unit = {
    e match {
            //case Event.doStep => GuiField(controller)
            case Event.StonePlaced(pos1, pos2, color) => controller.setStoneGui(pos1, pos2, color)
            case Event.doStep => println(" ")
            case Event.undo(row, col) => 
                val button: Button = buttonMapClass.buttonMap(row, col)
                //button.background = controller.getColor(row, col)
                updateField
            case Event.redoStep(row, col) => 
                val button: Button = buttonMapClass.buttonMap(row, col)
                button.background = controller.getColor(row, col)
            case Event.mill => " "
            case Event.noMill => " "
            case Event.allStonesPlaced => " "
            //repaint()
        }
    }
}
 