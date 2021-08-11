

/*
Currying functions (or partialling functions)
*/
def sum(x: Int , y: Int): Int = {
    x + y 
}
sum(1 , 2)
// This is not curried 
// Currying involves taking a fxn with multiple args and turning them into fxn calls with 
// one arg

def curriedSum(x: Int): Int => Int = {
    (y: Int) => x + y
}
curriedSum(1)(2) 
// returns 3! Yay!
