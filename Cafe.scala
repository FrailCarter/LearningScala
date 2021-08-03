
// Goal is to handle purchases at a coffee shop


class Cafe {

    def buyCoffee(cc: CreditCard): (Coffee , Charge) = {
        val cup = new Coffee()
        (cup , Charge(cc , cup.price())
        // returns a tuple of the cup and a Charge object
        // So now the payments system is not involved here
    }

    def buyCoffees(cc: CreditCard , n: Int): (List[Coffee] , Charge) = {
        val purchases: List[(Coffee , Charge)] = List.fill(n)(buyCoffee(cc))
        // List.fill(n)(x) creates a List with n copies of x 
        val (coffees , charges) = purchases.unzip
        // unzip splits a listt of pairs into a pair of lists
        (coffees , charges.reduce((c1 , c2) => c1.combine(c2)))
        // charges.reduce reduces the entire list of charges to a single charge object, using combine to combine charges 2 at a time
    }
}

// This is much better. Now we don't care about the implementation of payments 
// because that will be taken care of outside of our implementation
// Additionally, we can reuse and test buyCoffee and buyCoffees quite trivially.

// Since Charge is first-class, we can do something like combining all charges made by a user on the same day into one charge, like a tab!
// How nice. We'll do that next

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