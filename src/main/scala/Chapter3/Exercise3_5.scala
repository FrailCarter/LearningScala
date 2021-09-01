

// Implement dropWhile, which removes elements from the List prefix so long as they match a predicate 



def dropWhile[A](l: List[A] , f: A => Boolean): List[A] = l match {
    case Nil => Nil 
    case Cons(x , xs) => if (f(x)) {dropWhile(xs , f)} else {Cons(x , dropWhile(xs , f))}
}


// val f = (y: Int) => if (y == 6) {true} else {false}
// val x: List[Int] = List(1,2,3,4)
// val y: Boolean = List.dropWhile(x , (y: Int) => if (y == 2) {true} else {false}) == List(1 , 3 , 4)
// val a: Boolean = List.dropWhile(x , f) == x
// val b: Boolean = List.dropWhile(List() , f) == Nil
// val c: List[Int] = List(1,1,1,1,1,1,1,1,2,3,1,1,1,4,5,1)
// val d: Boolean = List.dropWhile(c , (y: Int) => if (y == 1) {true} else {false}) == List(2,3,4,5)