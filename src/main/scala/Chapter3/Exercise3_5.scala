

// Implement dropWhile, which removes elements from the List prefix so long as they match a predicate 

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

    def dropWhile[A](l: List[A] , f: A => Boolean): List[A] = l match {
        case Nil => Nil 
        case Cons(x , xs) => if (f(x)) {dropWhile(xs , f)} else {Cons(x , dropWhile(xs , f))}
    }
}

val f = (y: Int) => if (y == 6) {true} else {false}
val x: List[Int] = List(1,2,3,4)
val y: Boolean = List.dropWhile(x , (y: Int) => if (y == 2) {true} else {false}) == List(1 , 3 , 4)
val a: Boolean = List.dropWhile(x , f) == x
val b: Boolean = List.dropWhile(List() , f) == Nil
val c: List[Int] = List(1,1,1,1,1,1,1,1,2,3,1,1,1,4,5,1)
val d: Boolean = List.dropWhile(c , (y: Int) => if (y == 1) {true} else {false}) == List(2,3,4,5)