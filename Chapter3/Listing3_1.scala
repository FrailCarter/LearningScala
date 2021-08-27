
package fpinscala.datastructures

sealed trait List[+A]
// List data type, parameterized on a type, A 
case object Nil extends List[Nothing] 
// A list data constructor representing the empty list 
case class Cons[+A](head: A , tail: List[A]) extends List[A] 
// Another data constructor, representing nonempty lists 
// Note that tail is another List[A], which may be Nil or another Cons 

object List {
// List companion object
// Contains functions for creating and working with lists
    def sum(ints: List[Int]): Int = ints match {
    // a function that uses pattern matching to add up a list of integers
        case Nil => 0
        // The sum of the empty list is 0
        case Cons(x , xs) => x + sum(xs)
        // The sum of a list starting with x is x plus the sum of the rest of the list
    }

    def product(ds: List[Double]): Double = ds match {
        case Nil => 1.0 
        case Cons(0.0 , _) => 0.0 
        case Cons(x , xs) => x * product(xs)
    }

    def apply[A](as: A*): List[A] = {
    // Variadic function syntax
    // A variadic function takes 0 or more args of type A (think of it like *args)
    // by calling apply and placing it in the companion obj, we can construct instances of the dtype like
    // List(1,2,3,4) <-- this is called literal syntax.
        if (as.isEmpty) {
            Nil 
        }
        else {
            Cons(as.head , apply(as.tail: _*))
        }
    }
}

/*
We introduce a data type with the trait keyword.
A trait is an abstract interface that may optionally contain implementations of some methods.
Here, we are declaring a trait, called List, with no methods on it.
Adding sealed in front means that all implementations of the trrait must be declared in this file.

There are 2 such implementations, or data constructors, of List (each introduced with the kwd case).
A list can be empty, or a list can be nonempty.
*/

// val ex1: List[Double] = Nil
// val ex2: List[Int] = Cons(1 , Nil)
// val ex3: List[String] = Cons("a" , Cons("b" , Nil))
