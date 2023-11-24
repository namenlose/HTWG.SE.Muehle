package HTWG.SE.Muehle.controller
trait StoneFactory {
        def color(): Char
    }
    class whiteS() extends StoneFactory {
        override def color(): Char = 'w'
    }
    class blackS() extends StoneFactory {
        override def color(): Char = 'b'
    }