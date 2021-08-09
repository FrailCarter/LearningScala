
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