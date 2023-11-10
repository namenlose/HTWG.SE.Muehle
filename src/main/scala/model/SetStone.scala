package HTWG.SE.Muehle.model
def setStone(mesh: String, row: Int, col: Int, color: Char): String = {
   /*  val index = row * 3 + col
    val board = new Array[Char](24)
    if (index >= 0 && index < 24) {
       (row, col) match {
        case(1,1) => board(0).+(stoneSymbol)
       }
    }  */

    
    //val numRows = groeße
    //val numCols = (number - 1) * groeße + 1



    //val stoneSymbol = 'b'
   
     // Das Zeichen, um einen Stein zu repräsentieren

    // // Überprüfen, ob die Zeilen- und Spaltenindizes innerhalb des gültigen Bereichs liegen
    // if (row >= 0 && row < numRows && col >= 0 && col < numCols) {
    //     val index = row * (numCols ) // Index der Position im "mesh"
    //     val updatedMesh = mesh.updated(index, stoneSymbol)
    //     updatedMesh
    // } else { 
    //     mesh // Wenn die Indizes ungültig sind, wird das "mesh" unverändert zurückgegeben
    // }
    // if(row == 1 && col == 1) {
    //     mesh.updated(0, stoneSymbol)
    // } else {
    //     mesh.updated(2, stoneSymbol)
    // }
    (row,col) match {
        case(1, 1)=> mesh.updated(0, color)
        case(1, 2) => mesh.updated(7, color)
        case(1, 3) => mesh.updated(14, color)
        case(2, 1)=> mesh.updated(36, color)
        case(2, 2) => mesh.updated(41, color)
        case(2, 3) => mesh.updated(46, color)
        case(3, 1)=> mesh.updated(72, color)
        case(3, 2) => mesh.updated(75, color)
        case(3, 3) => mesh.updated(78, color)
        case(4, 1)=> mesh.updated(85, color)
        case(4, 2) => mesh.updated(87, color)
        case(4, 3) => mesh.updated(89, color)
        case(4, 4)=> mesh.updated(95, color)
        case(4, 5) => mesh.updated(97, color)
        case(4, 6) => mesh.updated(99, color)
        case(5, 1)=> mesh.updated(111, color)
        case(5, 2) => mesh.updated(114, color)
        case(5, 3) => mesh.updated(117, color)
        case(6, 1)=> mesh.updated(143, color)
        case(6, 2) => mesh.updated(148, color)
        case(6, 3) => mesh.updated(153, color)
        case(7, 1)=> mesh.updated(175, color)
        case(7, 2) => mesh.updated(182, color)
        case(7, 3) => mesh.updated(189, color)

    }
    
}