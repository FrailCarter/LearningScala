

def partiall[A , B , C](a: A , f: (A,B) => C): B => C 
// Function takes 3 type parameters: A, B, C
// Takes 2 args: a of type A, and f which is a function that takes 2 params
// of types A and B, respectively, and returns a value of type C.
// The value returned by partiall will also be a function of type B => C

// So how the hell do we implement it??