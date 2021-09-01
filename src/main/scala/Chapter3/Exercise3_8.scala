// Let's see what happens when we pass Nil and Cons themselves to foldRight
// What happens?

// val x: List[Int] = List.foldRight(List(1,2,3,4,5,6) , Nil: List[Int])(Cons(_ , _))


// Returns x: List[Int] = Cons(1,Cons(2,Cons(3,Cons(4,Cons(5,Cons(6,Nil))))))

/*
foldRight takes 2 params: as of type List[A] and z of type B
The type of A determines the type of A in the second param list, and the type of B determines the type of B 
in the second param list
So when using the constructor for a list as f, then the return type has to be Cons (or List[A])
So foldRight can be used to construct a list, I suppose
*/

