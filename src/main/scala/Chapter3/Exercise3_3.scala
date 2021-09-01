
// Implement setHead, which replaces the first value of a List with a different value


def setHead[A](a: A , as: List[A]): List[A] = as match {
    case Nil => Cons(a , Nil)
    case Cons(x , xs) => Cons(a , xs)
}
