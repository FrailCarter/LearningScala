
// Returns nth Fibonacci number
def fib(n: Int): Int = {

    def go(n: Int , i: Int , j: Int): Int = {
        if (n <= 0) {
            i
        }
        else {
            go(n - 1 , j , i + j)
        }
    }
    go(n , 0 , 1)

}