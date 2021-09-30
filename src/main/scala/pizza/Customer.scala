package pizza

class Customer (
    var name: String,
    var phone: String,
    var address: Address){
  override def toString: String =
    s"""
       |Name: $name
       |Phone: $phone
       |Address: $address""".stripMargin
}



