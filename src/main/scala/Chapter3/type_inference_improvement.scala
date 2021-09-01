// Let's looks at dropwhile

def dropWhile[A](l: List[A] , f: A => Boolean): List[A] = l match {
    case Nil => Nil 
    case Cons(x , xs) => if (f(x)) {dropWhile(xs , f)} else {Cons(x , dropWhile(xs , f))}
}

// When we call it with an anonymous function for f. we have to specify the type for it's arg

val xs: List[Int] = List(1,2,3,4,5)
val ex1 = dropWhile(xs , (x: Int) => x < 4)
// ex1 returns List(4,5)

/* 
I don't want to specify that x is an Int. The first arg to dropWhile is List[Int], so naturally x would have to be
Int. Scala can infer this if we group dropWhile into 2 arg lists:
*/
def dropWhile[A](as: List[A])(f: A=> Boolean): List[A] = as match {
    case Cons(h , t) if f(h) => dropWhile(t)(f)
    case _ => as 
}

val xs: List[Int] = List(1,2,3,4,5)
val ex1 = dropWhile(xs)(x => x < 4)

/*
When a fxn definition contains multiiple arg goups, type information flows from left wo right across those arg groups.
So the first group fixes the type parameter A of dropWhile to Int, so the annotation on x => x < 4 is not required.
*/