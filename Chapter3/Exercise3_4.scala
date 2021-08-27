
// Generalize tail to the function drop, which removes the first n elements from a list

sealed trait List[+A]
case object Nil extends List[Nothing] 
case class Cons[+A](head: A , tail: List[A]) extends List[A] 

object List {
    def sum(ints: List[Int]): Int = ints match {
        case Nil => 0
        case Cons(x , xs) => x + sum(xs)
    }

    def product(ds: List[Double]): Double = ds match {
        case Nil => 1.0 
        case Cons(0.0 , _) => 0.0 
        case Cons(x , xs) => x * product(xs)
    }

    def apply[A](as: A*): List[A] = {
        if (as.isEmpty) {
            Nil 
        }
        else {
            Cons(as.head , apply(as.tail: _*))
        }
    }

    def tail[A](as: List[A]): List[A] = as match {
        case Nil => Nil
        case Cons(x , xs) => xs
    }

    def setHead[A](a: A , as: List[A]): List[A] = as match {
        case Nil => Cons(a , Nil)
        case Cons(x , xs) => Cons(a , xs)
    }

    def drop[A](l: List[A] , n: Int): List[A] = l match {
        case Nil => Nil 
        case Cons(x , xs) => if (n == 0) {Cons(x , xs)} else {drop(xs , n - 1)}
    }
}

val x: List[Int] = List(1 , 2 , 3 , 4)
val y: Boolean = List.drop(x , 3) == Cons(4 , Nil)
val a: List[Int] = List()
val b: Boolean = List.drop(a , 3) == Nil
val c: List[Int] = List(1 , 2 , 3 , 4)
val d: Boolean = List.drop(c , 10) == Nil
val e: Boolean = List.drop(x , 0) == x

