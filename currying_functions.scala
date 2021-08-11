

/*
Currying functions (or partialling functions)
*/

/*
Lets make a function adds 2 ints
*/

def add(x: Int , y: Int): Int  = {
    x + y
}

/*
Great, however, what if I want to multiply 2 ints?
*/
def mult(x: Int , y: Int): Int = {
    x * y 
}

/*
Wonderful, except that mult and add look almost identical, don't they?
What if we could combine the two?
*/
def appFunc(x: Int , y: Int , f: (Int , Int) => Int): Int = {
    f(x , y)
}


appFunc(5 , 6 , add)
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
appFunc(5 , 6 , add)

// Excellent, now what if add, mult, and makeStr took any number of args?

def add(x: Array[Int]): Int = {
    x.reduce((y, z) => y + z)
}

def mult(x: Array[Int]): Int = {
    x.reduce((y , z) => y * z)
}

add(Array[Int](1 , 2 , 4))
mult(Array[Int](1 , 2 , 4))
// Okay, that's better.

def add(x: Array[Int]): Int = {
    def go(n: Int , total: Int): Int = {
        if (n == x.length) {
            total 
        }
        else {
            go(n + 1 , total + x(n))
        }
    }
    go(0 , 0)
}

def mult(x: Array[Int]): Int = {
    def go(n: Int , total: Int): Int = {
        if (n == x.length) {
            total 
        }
        else {
            go(n + 1 , total * x(n))
        }
    }
    go(0 , 1)
}

add(Array[Int](1 , 2 , 4))
mult(Array[Int](1 , 2 , 4))

// Even better, now these are *really* starting to look similar

def appFunc[A , B](x: Array[A] , f: (Array[A]) => B): B = {
    f(x)
    // Can't be (b: B) => f(b), because we need type A somewhere
    // f retturns B, so it needs to only be a fxn call 
}
appFunc(Array[Int](1 , 2 , 4) , add)
appFunc(Array[Int](1 , 2 , 4) , mult)
// **Even better!**
// However, we can reduce the redundancy of add and mult

def appFunc[A , B](x: Array[A] , f: (Array[A]) => B): B = {
    f(x)
}
appFunc(Array[Int](1 , 2 , 4) ,  (x: Array[Int]) => x.reduce((x , y) => x + y))
appFunc(Array[Int](1 , 2 , 4) ,  (x: Array[Int]) => x.reduce((x , y) => x * y))
// This removes the need for add and mult by allowing a lambda exp to do the same
// Let's see if we can generalize add and mult

def someFunc(x: Int , y: Array[Int] , f: (Int , Int) => Int): Int = {
    def go(n: Int , total: Int): Int = {
        if (n == y.length) {
            total 
        }
        else {
            go(n + 1 , f(total , y(n)))
        }
    }
    go(0 , x)
}

someFunc(0 , Array[Int](1 , 2 , 4) , (x , y) => x + y)
someFunc(1 , Array[Int](1 , 2 , 4) , (x , y) => x * y)

// Woohoo!!!!

