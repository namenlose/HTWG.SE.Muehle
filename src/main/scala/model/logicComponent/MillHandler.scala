package HTWG.SE.Muehle.model.logicComponent

trait HandlerInterface() {
    def checkRequirement(array: Array[Array[Char]]): Boolean = {false}
    def checkRequirementRecursiv(array1: Array[Char]): Boolean = {false}
    def nextHandler(): Boolean = {false}
    var millList: MillListInterface
}

class Handler1(array: Array[Array[Char]], millList1: MillListInterface) extends HandlerInterface {
    var millList: MillListInterface = millList1
    val handler2: Handler2 = new Handler2(array: Array[Array[Char]], millList)
    var muehle: Boolean = false
    var y = 0

    override def checkRequirement(array: Array[Array[Char]]): Boolean = {
        var array1: Array[Char] = Array(array(0)(0), array(0)(1), array(0)(2))
        var bool = checkRequirementRecursiv(array1)
        bool
    }

    override def checkRequirementRecursiv(array1: Array[Char]): Boolean = {
        array1(0) match {
            case 'b' => muehle = if (array1(1) == 'b' && array1(2) =='b' && !millList.isInMillList(new Mill(y, y + 1, y + 2))){
                                        millList.MillListAdd(new Mill(y, y + 1, y + 2))
                                        true
                                }else{false}

            case 'w' => muehle = if (array1(1) == 'w' && array1(2) =='w' && !millList.isInMillList(new Mill(y, y + 1, y + 2))){
                                        millList.MillListAdd(new Mill(y, y + 1, y + 2))
                                        true
                                }else{false}
            case 'o' => muehle = false
        }

        if(y == 6 && muehle == false){
            muehle = nextHandler()
            y = 0
        }else if(muehle == true){
            y = 0
            return true
        }else if(y < 4){
                y = y + 2
                array1(0) = array(0)(y)
                array1(1) = array(0)(y + 1)
                array1(2) = array(0)(y + 2)

                checkRequirementRecursiv(array1)
        }else{
            y = y + 2
                array1(0) = array(0)(6)
                array1(1) = array(0)(7)
                array1(2) = array(0)(0)
                checkRequirementRecursiv(array1)
        }
        muehle
    }

    override def nextHandler(): Boolean = {
        handler2.checkRequirement(array)
    }
}

class Handler2(array: Array[Array[Char]], millList1: MillListInterface) extends HandlerInterface {
    var millList: MillListInterface = millList1
    val handler3: Handler3 = new Handler3(array: Array[Array[Char]], millList)
    var muehle: Boolean = false
    var y = 0

    override def checkRequirement(array: Array[Array[Char]]): Boolean = {
        var array1: Array[Char] = Array(array(1)(0), array(1)(1), array(1)(2))
        var bool = checkRequirementRecursiv(array1)
        bool
    }

    override def checkRequirementRecursiv(array1: Array[Char]): Boolean = {

        array1(0) match {
            case 'b' => muehle = if (array1(1) == 'b' && array1(2) =='b' && !millList.isInMillList(new Mill(10 + y, 10 + y + 1, 10 + y + 2))){
                millList.MillListAdd(new Mill(10 + y, 10 + y + 1, 10 + y + 2))
                true
            }else{false}

            case 'w' => muehle = if (array1(1) == 'w' && array1(2) =='w' && !millList.isInMillList(new Mill(10 + y, 10 + y + 1, 10 + y + 2))){
                millList.MillListAdd(new Mill(10 + y, 10 + y + 1, 10 + y + 2))
                true
            }else{false}
            case 'o' => muehle = false
        }

        if(y == 6 && muehle == false){
            muehle = nextHandler()
            y = 0
        }else if(muehle == true){
            y = 0
            return true
        }else if(y < 4){
                y = y + 2
                array1(0) = array(1)(y)
                array1(1) = array(1)(y + 1)
                array1(2) = array(1)(y + 2)

                checkRequirementRecursiv(array1)
        }else{
            y = y + 2
                array1(0) = array(1)(6)
                array1(1) = array(1)(7)
                array1(2) = array(1)(0)
                checkRequirementRecursiv(array1)
        }
        
        muehle
    }

    override def nextHandler(): Boolean = {
        handler3.checkRequirement(array)
    }
}


class Handler3(array: Array[Array[Char]], millList1: MillListInterface) extends HandlerInterface {
    var millList: MillListInterface = millList1
    val handler4: Handler4 = new Handler4(array: Array[Array[Char]], millList)
    var muehle: Boolean = false
    var y = 0

    override def checkRequirement(array: Array[Array[Char]]): Boolean = {
        var array1: Array[Char] = Array(array(2)(0), array(2)(1), array(2)(2))
        var bool = checkRequirementRecursiv(array1)
        bool
    }

    override def checkRequirementRecursiv(array1: Array[Char]): Boolean = {

        array1(0) match {
            case 'b' => muehle = if (array1(1) == 'b' && array1(2) =='b' && !millList.isInMillList(new Mill(20 + y, 20 + y + 1, 20 + y + 2))){
                millList.MillListAdd(new Mill(20 + y, 20 + y + 1, 20 + y + 2))
                true
            }else{false}

            case 'w' => muehle = if (array1(1) == 'w' && array1(2) =='w' && !millList.isInMillList(new Mill(20 + y, 20 + y + 1, 20 + y + 2))){
                millList.MillListAdd(new Mill(20 + y, 20 + y + 1, 20 + y + 2))
                true
            }else{false}
            case 'o' => muehle = false
        }

        if(y == 6 && muehle == false){
            y = 0
            muehle = nextHandler()
        }else if(muehle == true) {
            y = 0
            return true
        }else if(y < 4){
                y = y + 2
                array1(0) = array(2)(y)
                array1(1) = array(2)(y + 1)
                array1(2) = array(2)(y + 2)

                checkRequirementRecursiv(array1)
        }else{
            y = y + 2
                array1(0) = array(2)(6)
                array1(1) = array(2)(7)
                array1(2) = array(2)(0)
                checkRequirementRecursiv(array1)
        }
        muehle
    }

    override def nextHandler(): Boolean = {
        handler4.checkRequirement(array)
    }
}

class Handler4(array: Array[Array[Char]], millList1: MillListInterface) extends HandlerInterface {
    var millList: MillListInterface = millList1
    val handler5: Handler5 = new Handler5(array: Array[Array[Char]], millList)
    var muehle: Boolean = false
    var y = 1

    override def checkRequirement(array: Array[Array[Char]]): Boolean = {
        var array1: Array[Char] = Array(array(0)(1), array(1)(1), array(2)(1))
        var bool = checkRequirementRecursiv(array1)
        bool
    }

    override def checkRequirementRecursiv(array1: Array[Char]): Boolean = {

        array1(0) match {
            case 'b' => muehle = if (array1(1) == 'b' && array1(2) =='b' && !millList.isInMillList(new Mill(y, 10 * y + 1, 20 * y + 2))){
                                        millList.MillListAdd(new Mill(y, 10  * y + 1, 20 * y + 2))
                                        true
                                }else{false}

            case 'w' => muehle = if (array1(1) == 'w' && array1(2) =='w' && !millList.isInMillList(new Mill(y, 10 * y + 1, 20 * y + 2))){
                                        millList.MillListAdd(new Mill(y, 10 * y + 1, 20 * y + 2))
                                        true
                                }else{false}
            case 'o' => muehle = false
        }

        if(y == 7 && muehle == false){
            muehle = nextHandler()
            y = 1
        }else if(muehle == true){
            y = 1
            return true
        }else{
            y = y + 2
            array1(0) = array(0)(y)
            array1(1) = array(1)(y)
            array1(2) = array(2)(y)
            checkRequirementRecursiv(array1)
        }
        muehle

    }

    override def nextHandler(): Boolean = {
        handler5.checkRequirement(array)
    }
}

class Handler5(array: Array[Array[Char]], millList1:  MillListInterface) extends HandlerInterface {
    var millList: MillListInterface = millList1

    override def checkRequirement(array: Array[Array[Char]]): Boolean = {false}

}
