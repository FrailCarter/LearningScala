
// Right folds and simple uses

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

    def append[A](a1: List[A] , a2: List[A]): List[A] = a1 match {
        case Nil => a2 
        case Cons(h,t) => Cons(h , append(t , a2))
    }

    def init[A](l: List[A]): List[A] = l match {
        case Nil => Nil
        case Cons(x , Nil) => Nil 
        case Cons(x , y) => Cons(x , init(y))
    }

    def foldRight[A , B](as: List[A] , z: B)(f: (A , B) => B): B = as match {
        // we place f in its own arg group after as and z lets type inference determine the input types to f 
        case Nil => z
        case Cons(x , xs) => f(x , foldRight(xs ,z)(f))
    }

    def sum2(ns: List[Int]) = {
        foldRight(ns , 0)((x , y) => x + y)
    }

    def product2(ns: List[Double]) = {
        foldRight(ns , 1.0)(_ * _)
        // _ * _ is more concise notation for (x , y) => x * y
    }
}
