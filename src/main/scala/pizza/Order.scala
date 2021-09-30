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

    def getBasePrice(): ArrayBuffer[Int] = {
        var kekes = ArrayBuffer[Int]()
        val kek1 = for (i <- pizzas) yield i.crustSize match {
            case SmallCrustSize => 150
            case MediumCrustSize => 250
            case LargeCrustSize => 250
            case _ => 0
        }
        val kek2 = for (i <- pizzas) yield i.crustType match {
            case RegularCrustType => 50
            case ThinCrustType => 60
            case ThickCrustType => 70
            case _ => 0
        }

        for (i <- kek1.indices) yield kekes += (kek1(i) + kek2(i))
        kekes
    }

    def printOrder(): Unit = {
        var i = 0
            for (p <- pizzas) {
                print(customer)
                val keks = getBasePrice().zipWithIndex.apply(i)._1
                print(s"Price: $keks rub")
                i+=1
                print(p +"\n")
            }
        }
}
