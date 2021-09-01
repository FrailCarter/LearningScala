

/*
Lets make a monomorphic functiion that fiinds the first index in an array where the key occurs, or -1 if
it's not found
*/

def findFirst[A](as: Array[A] , p: A => Boolean): Int = {
    // Instead of hardcoding String, take a type A as a parameter
    // Instead of hardcoding an equality check for a given key, 
    // take a function with which to test each element of the array
    @annotation.tailrec 
    def loop(n: Int): Int = {
        if (n >= as.length) {
            -1
        }
        else if (p(as(n))) {
            // If the fxn p matches the current element, we've found a match and 
            // return its index in the array
            n 
        }
        else {
            loop(n + 1)
        }
    }
    loop(0)
}

findFirst[Int](Array[Int](1 , 2 , 3) , (x: Int) => x == 3)
// The function call for "p" is a lambda function
// Lambda functions look like (variable: Type) => Transformation Expression