package HTWG.SE.Muehle
import scala.io.StdIn.readLine
import scala.io.StdIn.readInt
import scala.io.StdIn.readChar

@main def tui: Unit =
    //println(updatedMesh)
    
    println("Bitte waehlen Sie eine Farbe: Schwarz(s) oder Weiss(w)")
    val playerOne = readChar()
    val playerTwo = readChar()
    
    if(playerOne != 'b' && playerOne != 'w') {
        println("Bitte wählen Sie entweder Schwarz oder Weiss")
    }

    println("Wohin möchten Sie ihren Stein setzen?" + eol + mesh)
    println("Zeile: ")
    val ind1 = readInt()
    println(" ")
    println("Spalte: ")
    val ind2 = readInt()
    println(" ")
    //val updateMesh = setStone(mesh, ind1, ind2)
    val newMesh = setStone(mesh, ind1, ind2, playerOne)
    println(newMesh)
    var Mesh = newMesh

    
    var i = 1;
    while(i <=  17) {
    println("Wohin möchten Sie ihren Stein setzen?" + eol)
    println("Zeile: ")
    val ind1 = readInt()
    println(" ")
    println("Spalte: ")
    val ind2 = readInt()
    println(" ")
    //val updateMesh = setStone(newMesh, ind1, ind2)
    //val newMesh = setStone(newMesh, ind1, ind2)
     if(i % 2 == 0) {
        val updatedMesh = setStone(Mesh, ind1, ind2, playerOne)
        println(updatedMesh)
        Mesh = updatedMesh
    } else {
        val updatedMesh = setStone(Mesh, ind1, ind2, playerTwo)
        println(updatedMesh)
        Mesh = updatedMesh
    }
    
    i += 1
    
    }

    


    


