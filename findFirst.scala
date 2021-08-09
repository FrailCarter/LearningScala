

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
        else if (p(as(n)) == key) {
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

/* 
Hmmm, this code will look almost identical if we're searching for a String in an 
Array[String], and Int in an Array[Int], or an A in an Array[A] for any given type A

We can make this more general for any type A by accepting a function for testing a particular
A value
*/