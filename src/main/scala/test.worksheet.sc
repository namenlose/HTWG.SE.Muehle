case class player(Name:String)
case class Stone(Colour:String, Owner:player, position:Int)
case class field(places: List[Option[Stone]])

val field1 = field(List.fill(24)(None))

val mapcolor = Map("black" -> "PlayerOne",
                      "weiß" -> "PlayerTwo")

