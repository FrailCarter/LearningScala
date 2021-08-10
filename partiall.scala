

def partiall[A , B , C](a: A , f: (A,B) => C): B => C 
    (b: B) => f(a , b)
    // partiall has to return a function that takes an arg of type B, so we start there
    // We know that the type C has to come from the function, f. So to get C, we need to pass 
    // A and B to f


// Function takes 3 type parameters: A, B, C
// Takes 2 args: a of type A, and f which is a function that takes 2 params
// of types A and B, respectively, and returns a value of type C.
// The value returned by partiall will also be a function of type B => C

// So how the hell do we implement it??