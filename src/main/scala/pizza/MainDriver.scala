package pizza

import scala.collection.mutable.ArrayBuffer

object MainDriver extends App {

    val p1 = new Pizza (
        MediumCrustSize,
        ThinCrustType,
        ArrayBuffer(Cheese)
    )

    val p2 = new Pizza (
        LargeCrustSize,
        ThinCrustType,
        ArrayBuffer(Cheese, Pepperoni, Sausage)
    )

    val address = new Address (
        "123 Main Street",
        "Apt. 1",
        "Talkeetna",
        "Alaska",
        "99676"
    )

    val customer = new Customer (
        "Alvin Alexander",
        "907-555-1212",
        address
    )

    val o = new Order(
        ArrayBuffer(p1, p2),
        customer
    )

    val kek2 = new Pizza(SmallCrustSize,ThickCrustType,ArrayBuffer(Pepperoni))

    val kek = new Order(ArrayBuffer(new Pizza(SmallCrustSize,ThickCrustType,ArrayBuffer(Pepperoni))),
        new Customer("Igor Kovshar","8-983-520-29-04",
        address))

    o.addPizza(
        new Pizza (
            SmallCrustSize,
            RegularCrustType,
            ArrayBuffer(Cheese, Mushrooms)
        )
    )

    o.printOrder()
    kek.printOrder()

}



