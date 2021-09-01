// Can product, implemented using foldRight, immediately halt the recursion if it encounters a 0?
// Why or why not?


def foldRight[A , B](as: List[A] , z: B)(f: (A , B) => B): B = as match {
    // we place f in its own arg group after as and z lets type inference determine the input types to f 
    case Nil => z
    case Cons(x , xs) => f(x , foldRight(xs ,z)(f))
}

def sum(ns: List[Int]) = {
    foldRight(ns , 0)((x , y) => x + y)
}

def product(ns: List[Double]) = {
    foldRight(ns , 1.0)(_ * _)
    // _ * _ is more concise notation for (x , y) => x * y
    // This will not halt when it hits a 0 because there is not a case for it in foldRight.
}
