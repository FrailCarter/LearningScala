
// Goal is to handle purchases at a coffee shop


class Cafe {

    def buyCoffee(cc: CreditCard): (Coffee , Charge) = {
        val cup = new Coffee()
        (cup , Charge(cc , cup.price())
        // returns a tuple of the cup and a Charge object
        // So now the payments system is not involved here
    }
}

// We have separated the concern of creating a charge from that of processing a charge, which is 
// easier to test.
// Let's go ahead and make our Charge class 

case class Charge(cc: CreditCard , amount: Double) {
    // A case class has one primary constructor whose arg list comes after the class name 
    // The params in this list become public, immutable fields of the class and can be accessed using the usual OO dot notation
    
    def combine(other: Charge): Charge = 
        if (cc == other.cc)
            Charge(cc , amount + other.amount)
            // A case class can be created w/o the "new" keyword
        else 
            throw new Exception("Can't combine charges to different cards!")
}