package HTWG.SE.Muehle.aview

import scala.swing.FlowPanel.Alignment
import scala.swing._
import javax.swing.table._
import HTWG.SE.Muehle.controller._
import HTWG.SE.Muehle.controller.controllerBaseImpl._
import HTWG.SE.Muehle.util._
import HTWG.SE.Muehle.model.ButtonMap
import javax.swing.ImageIcon
import javax.print.attribute.standard.OrientationRequested
 
 
 class GuiField(controller: controllerInterface)extends Observer{
    controller.add(this)
    val gray = new Color(150,150,150)
    var buttonMap = new ButtonMap(controller, 'w').createButtonMap

    var muehle = new Label("Keine Muehle")

    def muehleLabel = {
        muehle.text = "Muehle"
    }

    def keinMuehleLable = {
        muehle.text = "keine Mühle"
    }

    def updateField ={
        for(i <- 0 to 2){
            for(x <- 0 to 7){
                val button = buttonMap((i,x))
                button.background = controller.getColor(i,x)
            }
        }
    }

    def playPanel(color: Char) = new FlowPanel{

        def createLine: Label = new Label{
            text = "-"
        }

        def createVerticalLine: Label = new Label{
            text = "|"
        }

        def createSpace: Label = new Label {
            text = " "
        }
    
        buttonMap = new ButtonMap(controller, color).createButtonMap

        def createButtonPanel(row: Int, colRange: Range): GridPanel = new GridPanel(1, 13) {
            colRange.foreach(col => {
                val button = buttonMap((row, col))
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

        val button3 = buttonMap((1, 0))
        val button4 = buttonMap((1, 1)) 
        val button5 = buttonMap((1, 2))

        val thirdLine: GridPanel = new GridPanel(1, 13) {
            contents += createVerticalLine
            contents += createSpace
            // Füge die Buttons und Linien entsprechend hinzu
            Seq(button3, button4, button5).zipWithIndex.foreach { case (button, index) =>
            //contents += createSpace
            contents += button

            // Füge drei Linien nach jedem Button hinzu
            if (index < 2) {
                (1 to 3).foreach(_ => contents += createLine)
            }
        }

            contents += createSpace
            contents += createVerticalLine
}


        def forthLLine: GridPanel = new GridPanel(1, 13){
            contents += createVerticalLine
            contents += createSpace
            contents += createVerticalLine
            contents += createSpace
            contents += createSpace
            contents += createSpace
            contents += createVerticalLine
            contents += createSpace
            contents += createSpace
            contents += createSpace
            contents += createVerticalLine
            contents += createSpace
            contents += createVerticalLine
        }
    
        val button6 = buttonMap((2, 0))
        val button7 = buttonMap((2, 1))
        val button8 = buttonMap((2, 2)) 
        def fifthLine: GridPanel = new GridPanel(1, 13){
            contents += createVerticalLine
            contents += createSpace
            contents += createVerticalLine
            contents += createSpace
            contents +=  button6
            contents += createLine
            contents +=  button7
            contents += createLine
            contents +=  button8
            contents += createSpace
            contents += createVerticalLine
            contents += createSpace
            contents += createVerticalLine
        }

        def sixthLine: GridPanel = new GridPanel(1, 13){
            contents += createVerticalLine
            contents += createSpace
            contents += createVerticalLine
            contents += createSpace
            contents += createVerticalLine
            contents += createSpace
            contents += createSpace
            contents += createSpace
            contents += createVerticalLine
            contents += createSpace
            contents += createVerticalLine
            contents += createSpace
            contents += createVerticalLine
        }

        val button9 = buttonMap((0, 7))
        val button10 = buttonMap((1, 7))
        val button11 = buttonMap((2, 7))
        val button12 = buttonMap((2, 3))
        val button13 = buttonMap((1, 3))
        val button14 = buttonMap((0, 3))  
        val seventhLine = new GridPanel(1, 13){
            contents +=  button9
            contents += createLine
            contents +=  button10
            contents += createLine
            contents +=  button11
            contents += createSpace
            contents += createSpace
            contents += createSpace
            contents +=  button12
            contents += createLine
            contents +=  button13
            contents += createLine
            contents +=  button14
        }

        val button15 = buttonMap((2, 6)) 
        val button16 = buttonMap((2, 5))
        val button17 = buttonMap((2, 4)) 
        val eighthLine = new GridPanel(1, 13){
            contents += createVerticalLine
            contents += createSpace
            contents += createVerticalLine
            contents += createSpace
            contents += button15
            contents += createLine
            contents += button16
            contents += createLine
            contents += button17
            contents += createSpace
            contents += createVerticalLine
            contents += createSpace
            contents += createVerticalLine
        }

        val button18 = buttonMap((1, 6))
        val button19 = buttonMap((1, 5))
        val button20 = buttonMap((1, 4)) 
        val ninthLine = new GridPanel(1, 13){
            contents += createVerticalLine
            contents += createSpace
            contents += button18
            contents += createLine
            contents += createLine
            contents += createLine
            contents += button19
            contents += createLine
            contents += createLine
            contents += createLine
            contents += button20
            contents += createSpace
            contents += createVerticalLine
        }

        val button21 = buttonMap((0, 6))
        val button22 = buttonMap((0, 5))
        val button23 = buttonMap((0, 4)) 
        val tenthLine = new GridPanel(1, 13){
        contents += button21
        contents += createLine
        contents += createLine
        contents += createLine
        contents += createLine
        contents += createLine

        contents += button22
        contents += createLine
        contents += createLine
        contents += createLine
        contents += createLine
        contents += createLine

        contents += button23
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
        //muehleLabel
        contents += muehle
        
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
                val button: Button = buttonMap(row, col)
                button.background = controller.getColor(row, col)
            case Event.redoStep(row, col) => 
                val button: Button = buttonMap(row, col)
                button.background = controller.getColor(row, col)
            case Event.mill => " "
            case Event.noMill => " "
            //repaint()
        }
    }

}
 