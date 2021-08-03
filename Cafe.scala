
// Goal is to handle purchases at a coffee shop


class Cafe {

    def buyCoffee(cc: CreditCard , p: Payments): Coffee = {
        val cup = new Coffee()
        p.charge(cc , cup.price)
        // Payments can be an interface now, so we can write a mock interface for testing
        cup 
        // returns cup of coffee
    }
}

// If we are returning a cup of coffee, then why charge the credit card (let's say it also is contacting the outside world)
// this introduces things that are hard to test.

// If we want to test that buyCoffee  creates a charge equal to the price of a cup of coffee, this becomes overkill. 
// Additionally, we can't reuse this easily. If I want to buy 12 coffees, that's 12 separate charges.