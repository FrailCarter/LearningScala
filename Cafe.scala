
// Goal is to handle purchases at a coffee shop


class Cafe {

    def buyCoffee(cc: CreditCard): Coffee = {
        val cup = new Coffee()
        cc.charge(cup.price)
        // Side efffect is charging card
        cup 
        // returns cup of coffee
    }
}

// If we are returning a cup of coffee, then why charge the credit card (let's say it also is contacting the outside world)
// this introduces things that are hard to test.