package pizza

class Address (
    var street1: String,
    var street2: String,
    var city: String,
    var state: String,
    var zipCode: String
){
  override def toString: String =
    s"""
       |Street1: $street1
       |Street2: $street2
       |City: $city
       |State: $state
       |Zipcode: $zipCode
       |""".stripMargin
}

