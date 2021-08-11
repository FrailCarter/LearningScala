

/* This is an example of currying, which converts a function f of 
2 args into a functtion of one arg that partially applies f
*/

def curry[A , B , C](f: (A , B) => C): A => B => C = 
    // This function ret a function that takes an arg of A and returns B, then takes B and returns C
    // So we need to start with A, since f takes A and B as params to return C
    (a: A) => (b: B) => f(a , b)
    // Start with A, then move to B, then send those to f(a ,b)
    


