package HTWG.SE.Muehle.model

enum Stone(symbol: String):
    override def toString(): String = symbol
    case w extends Stone("w")
    case b extends Stone("b")
    case Empty extends Stone("-")