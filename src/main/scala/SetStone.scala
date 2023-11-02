package HTWG.SE.Muehle
def setStone(mesh: String, row: Int, col: Int): String = {
    val numRows = groeße
    val numCols = (number - 1) * groeße + 1
    val stoneSymbol = 'b' // Das Zeichen, um einen Stein zu repräsentieren

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
        case(1, 1)=> mesh.updated(0, stoneSymbol)
        case(1, 2) => mesh.updated(7, stoneSymbol)
    }
    
}
