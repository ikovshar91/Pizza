package pizza

import scala.collection.mutable.ArrayBuffer

class Order (
    val pizzas: ArrayBuffer[Pizza],
    var customer: Customer
) {
    def addPizza(p: Pizza): Unit = {
        pizzas += p
    }

    def removePizza(p: Pizza): Unit = {
        pizzas -= p
    }

    private def getCrustCoast(crustSize: CrustSize): Int = {
        crustSize match {
            case SmallCrustSize => 150
            case MediumCrustSize => 250
            case LargeCrustSize => 250
            case _ => 0
        }
    }

    private def getCrustTypeCoast(crustType: CrustType): Int = {
        crustType match {
            case RegularCrustType => 50
            case ThinCrustType => 60
            case ThickCrustType => 70
            case _ => 0
        }
    }

    private def getToppingCoast(topping: Topping): Int ={
        topping match {
            case Cheese => 30
            case Pepperoni => 50
            case Sausage => 60
            case Mushrooms => 60
            case Onions => 5
        }
    }

    def getBasePrice(): ArrayBuffer[Double] = {
        pizzas.map{ pizzas =>
          val crustSize = getCrustCoast(pizzas.crustSize)
          val crustType = getCrustTypeCoast(pizzas.crustType)
          val topping = pizzas.toppings.map{topping => getToppingCoast(topping)}.sum
          crustSize + crustType + topping
        }
    }

    def getPlatiNOLOG():ArrayBuffer[Double] = {
        getBasePrice().map(nolog => (nolog.toDouble/100)*20)
    }

    def SumPrice(): ArrayBuffer[Double] = {




        var sumPrice = ArrayBuffer[Double]()
        for(p <- pizzas.indices) {
            val basePrice = getBasePrice().zipWithIndex.apply(p)._1
            val Nolog = getPlatiNOLOG().zipWithIndex.apply(p)._1
            sumPrice ++= ArrayBuffer(basePrice+Nolog)
        }
     sumPrice
    }

    def printOrder(): Unit = {
        var i = 0
            for (p <- pizzas) {
                print(customer)
                println(s"BasePrice: ${getBasePrice().zipWithIndex.apply(i)._1}")
                println(s"NOLOG: ${getPlatiNOLOG().zipWithIndex.apply(i)._1}")
                print(s"Price: ${SumPrice().zipWithIndex.apply(i)._1}")
                i+=1
                print(p +"\n")
            }
        }
}
