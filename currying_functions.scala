

/*
Currying functions (or partialling functions)
*/

/*
Lets make a function sums 2 ints
*/

def sum(x: Int , y: Int): Int  = {
    x + y
}

/*
Great, however, what if I want to multiply 2 ints?
*/
def mult(x: Int , y: Int): Int = {
    x * y 
}

/*
Wonderful, except that mult and sum look almost identical, don't they?
What if we could combine the two?
*/
def appFunc(x: Int , y: Int , f: (Int , Int) => Int): Int = {
    f(x , y)
}


appFunc(5 , 6 , sum)
appFunc(5 , 6 , mult)
// Great, this works
// What if I want to do string things with numbers?

def makeStr(x: Int , y: Int): String = {
    val msg = "The combination of %d and %d is %s"
    val a = x.toString
    val b = y.toString
    msg.format(x , y , x + y)
}
makeStr(5 , 6)

// This is still kind of the same deal as appFunc
// What if appFunc could take a generic type?
def appFunc[A , B](a: A , b: A , f: (A , A) => B): B = {
    f(a , b)
}

appFunc(5 , 6 , makeStr)
appFunc(5 , 6 , mult)
appFunc(5 , 6 , sum)