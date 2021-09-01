// Implement a fxn init that returns a list of everything but the last element



def init[A](l: List[A]): List[A] = l match {
    case Nil => Nil
    case Cons(x , Nil) => Nil 
    case Cons(x , y) => Cons(x , init(y))
}

// val x: List[Int] = List(1,2,3,4,5)
// val y: Boolean = List.init(x) == List(1,2,3,4)

