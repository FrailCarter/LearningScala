
/*
Time to write loops functionally
*/

def factorial(n: Int): Int = {
    def go(n: Int , acc: Int): Int = {
        // Args of the function are the state of the loop
        if (n <= 0) {
            acc 
        }
        else {
            go(n - 1 , n * acc) 
        }
    }
}

// The way to write loops functionally w/o a loop variable is via recursion 
// "go" in this cas is a recursive helper function

/*
Tail calls:
    A call is in tail position if the caller does nothing other than return the value
    of the recursive call.

    If all recursive calls made by a function are in tail position, Scala automatilcally compiles
    the recusion to iterative loops that don't consume call sack frames for
    each iteration. 
    
    By default, Scala does not tell us if tail call elimination was successful, but if we 
    are expecting this to occur, we can tell the compiler about this assumption by using
    tailrec annotation, which will throw a compilation error if it's unable to eliminate the tail
    calls.
*/