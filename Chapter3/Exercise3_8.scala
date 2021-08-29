// Let's see what happens when we pass Nil and Cons themselves to foldRight
// What happens?

sealed trait List[+A]
case object Nil extends List[Nothing] 
case class Cons[+A](head: A , tail: List[A]) extends List[A] 

object List {

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

    def sum(ns: List[Int]) = {
        foldRight(ns , 0)((x , y) => x + y)
    }

    def product(ns: List[Double]) = {
        foldRight(ns , 1.0)((x , y) => x * y)
        // _ * _ is more concise notation for (x , y) => x * y
        // This will not halt when it hits a 0 because there is not a case for it in foldRight.
    }
}



val x: List[Int] = List.foldRight(List(1,2,3,4,5,6) , Nil: List[Int])(Cons(_ , _))
// Returns x: List[Int] = Cons(1,Cons(2,Cons(3,Cons(4,Cons(5,Cons(6,Nil))))))

/*
foldRight takes 2 params: as of type List[A] and z of type B
The type of A determines the type of A in the second param list, and the type of B determines the type of B 
in the second param list
So when using the constructor for a list as f, then the return type has to be Cons (or List[A])
So foldRight can be used to construct a list, I suppose
*/

