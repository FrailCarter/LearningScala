
// A comment!
/* Another comment! */
/** A documentation comment! */

/**
    For a function, "def abs(n: Int): Int" means that the abs function takes one arg of type Int 
    and returns an Integer
*/


object MyModule {
    // This declares a singleton object which simultaneously declares a class and its only instance
    // Objects are also called "Modules"
    def abs(n: Int): Int = 
        // abs takes an integer and returns an integer
        if (n < 0) {
            // returns the negation of n if n is less than 0
            -n 
        }
        else {
            n 
        }
    private def formatAbs(x: Int): String = {
        // A private method can only be called by other members of MyModule
        // Should always specify return type, even though Scala can usually detect it
        val msg = "The absolute value of %d is %d"
        msg.format(x , abs(x))
    }

    def main(args: Array[String]): Unit = 
        // Unit serves the same purpose as "void" in Java and C
        println(formatAbs(-42))
}