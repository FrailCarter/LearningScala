

/*
Lets make a monomorphic functiion that fiinds the first index in an array where the key occurs, or -1 if
it's not found
*/

def findFirst(ss: Array[String] , key: String): Int = {
    @annotation.tailrec 
    def loop(n: Int): Int = {
        if (n >= ss.length) {
            // If n is past the end of the array, return -1
            -1
        }
        else if (ss(n) == key) {
            // ss(n) extracts the nth element of the array ss 
            // If the element at n is equal to the key, return n
            n 
        }
        else {
            loop(n + 1)
            // continue
        }
    }
    loop(0)
    // Start the loop
}