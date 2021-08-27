// Data sharing append

def append[A](a1: List[A] , a2: List[A]): List[A] = a1 match {
    case Nil => a2 
    case Cons(h,t) => Cons(h , append(t , a2))
}