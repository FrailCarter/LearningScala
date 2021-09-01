
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
    
    def factorial(n: Int): Int = {
        def go(n: Int , acc: Int): Int = {
            if (n <= 0) {
                acc 
            }
            else {
                go(n - 1 , n * acc)
            }
        }
        go(n , 1)
    }

    private def formatAbs(x: Int): String = {
        // A private method can only be called by other members of MyModule
        // Should always specify return type, even though Scala can usually detect it
        val msg = "The absolute value of %d is %d"
        msg.format(x , abs(x))
    }

    private def formatFactorial (n: Int): Int = {
        val msg = "The factorial of %d is %d"
        msg.format(n , factorial(n))
    }

    def formatResult(name: String , n: Int , f: Int => Int): String = {
        /* Generalizes formatFactorial and formatAbs
        This function takes name, n, and a function "f" as arguments
        */
        val msg = "The %s of %d is %d"
        msg.format(name , n , f(n))
        // "f" takes a type, so f:Int => Int means "f" takes an Integer and returns an Integer
    }

    def main(args: Array[String]): Unit = 
        // Unit serves the same purpose as "void" in Java and C
        // println(formatAbs(-42))
        // println(formatFactorial(7))
        println(formatResult("absolute value" , -42 , abs))
        println(formatResult("factorial" , 7 , factorial))
}