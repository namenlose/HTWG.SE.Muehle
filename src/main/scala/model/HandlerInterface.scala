package HTWG.SE.Muehle.model

trait HandlerInterface() {
    def checkRequirement(array: Array[Array[Char]]): Boolean = {false}
    def checkRequirementRecursiv(array1: Array[Char]): Boolean = {false}
    def nextHandler(): Boolean = {false}
}

class Handler1(array: Array[Array[Char]]) extends HandlerInterface {
    val handler2: Handler2 = new Handler2(array: Array[Array[Char]])
    var muehle: Boolean = false
    var y = 0

    override def checkRequirement(array: Array[Array[Char]]): Boolean = {
        var array1: Array[Char] = Array(array(0)(0), array(0)(1), array(0)(2))
        var bool = checkRequirementRecursiv(array1)
        bool
    }

    override def checkRequirementRecursiv(array1: Array[Char]): Boolean = {

        array1(0) match {
            case 'b' => muehle = if (array1(1) == 'b' && array1(2) =='b'){
                                        true
                                }else{false}

            case 'w' => muehle = if (array1(1) == 'w' && array1(2) =='w'){
                                        true
                                }else{false}
            case 'o' => muehle = false
        }

        if(y == 4 && muehle == false){
            muehle = nextHandler()
        }else if(muehle == true){
            return true
        }else{


                y = y + 2
                array1(0) = array(0)(y)
                array1(1) = array(0)(y + 1)
                array1(2) = array(0)(y + 2)

                checkRequirementRecursiv(array1)
            }
        muehle
    }

    override def nextHandler(): Boolean = {
        handler2.checkRequirement(array)
    }
}

class Handler2(array: Array[Array[Char]]) extends HandlerInterface {
    val handler3: Handler3 = new Handler3(array: Array[Array[Char]])
    var muehle: Boolean = false
    var y = 0

    override def checkRequirement(array: Array[Array[Char]]): Boolean = {
        var array1: Array[Char] = Array(array(1)(0), array(1)(1), array(1)(2))
        var bool = checkRequirementRecursiv(array1)
        bool
    }

    override def checkRequirementRecursiv(array1: Array[Char]): Boolean = {

        array1(0) match {
            case 'b' => muehle = if (array1(1) == 'b' && array1(2) =='b'){
                true
            }else{false}

            case 'w' => muehle = if (array1(1) == 'w' && array1(2) =='w'){
                true
            }else{false}
            case 'o' => muehle = false
        }

        if(y == 4 && muehle == false){
            muehle = nextHandler()
        }else if(muehle == true){
            return true
        }else {

            y = y + 2
            array1(0) = array(1)(y)
            array1(1) = array(1)(y + 1)
            array1(2) = array(1)(y + 2)

            checkRequirementRecursiv(array1)
        }
        muehle
    }

    override def nextHandler(): Boolean = {
        handler3.checkRequirement(array)
    }
}

class Handler3(array: Array[Array[Char]]) extends HandlerInterface {
    val handler4: Handler4 = new Handler4(array: Array[Array[Char]])
    var muehle: Boolean = false
    var y = 0

    override def checkRequirement(array: Array[Array[Char]]): Boolean = {
        var array1: Array[Char] = Array(array(2)(0), array(2)(1), array(2)(2))
        var bool = checkRequirementRecursiv(array1)
        bool
    }

    override def checkRequirementRecursiv(array1: Array[Char]): Boolean = {

        array1(0) match {
            case 'b' => muehle = if (array1(1) == 'b' && array1(2) =='b'){
                true
            }else{false}

            case 'w' => muehle = if (array1(1) == 'w' && array1(2) =='w'){
                true
            }else{false}
            case 'o' => muehle = false
        }

        if(y == 4 && muehle == false){
            println("handler3 if")
            muehle = nextHandler()
        }else if(muehle == true) {
            return true
        }else{
                y = y + 2
                array1(0) = array(2)(y)
                array1(1) = array(2)(y + 1)
                array1(2) = array(2)(y + 2)

                checkRequirementRecursiv(array1)
            }
        muehle
    }

    override def nextHandler(): Boolean = {
        handler4.checkRequirement(array)
    }
}

class Handler4(array: Array[Array[Char]]) extends HandlerInterface {

    override def checkRequirement(array: Array[Array[Char]]): Boolean = {false}

}
