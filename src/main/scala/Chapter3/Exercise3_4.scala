
// Generalize tail to the function drop, which removes the first n elements from a list


def drop[A](l: List[A] , n: Int): List[A] = l match {
    case Nil => Nil 
    case Cons(x , xs) => if (n == 0) {Cons(x , xs)} else {drop(xs , n - 1)}
}


// val x: List[Int] = List(1 , 2 , 3 , 4)
// val y: Boolean = List.drop(x , 3) == Cons(4 , Nil)
// val a: List[Int] = List()
// val b: Boolean = List.drop(a , 3) == Nil
// val c: List[Int] = List(1 , 2 , 3 , 4)
// val d: Boolean = List.drop(c , 10) == Nil
// val e: Boolean = List.drop(x , 0) == x

