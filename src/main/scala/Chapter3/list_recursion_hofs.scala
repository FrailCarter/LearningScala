// Recursion over lists and generalizing to higher-order functions
/*
Recall our definitions of sum and product:
*/

def sum(ints: List[Int]): Int = ints match {
    case Nil => 0
    case Cons(x , xs) => x + sum(xs)
}

def product(ds: List[Double]): Double = ds match {
    case Nil => 1.0 
    // case Cons(0.0 , _) => 0.0 
    // ^^ unnecessary
    case Cons(x , xs) => x * product(xs)
}

// Gee, these are very similar. They're operating on different types, but that's about it.
/*
Any time you encounter duplication like this, you can generalize it away by pulling subexpressions out into 
function args.
*/