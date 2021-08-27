
// Right folds and simple uses

def foldRight[A , B](as: List[A] , z: B)(f: (A , B) => B): B = as match {
    // we place f in its own arg group after as and z lets type inference determine the input types to f 
    case Nil => z
    case Cons(x , xs) => f(x , foldRight(xs ,z)(f))
}

def sum2(ns: List[Int]) = {
    foldRight(ns , 0)((x , y) => x + y)
}

def product2(ns: List[Double]) = {
    foldRight(ns , 1)(_ * _)
    // _ * _ is more concise notation for (x , y) => x * y
}