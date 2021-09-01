
// Implement the function tail


def tail[A](as: List[A]): List[A] = as match {
    case Nil => Nil
    case Cons(x , xs) => xs
}
