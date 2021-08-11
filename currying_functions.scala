

/*
Currying functions (or partialling functions)
*/

/*
Lets make a function sums 2 ints
*/

def sum(x: Int , y: Int): Int  = {
    x + y
}

/*
Great, however, what if I want to multiply 2 ints?
*/
def mult(x: Int , y: Int): Int = {
    x * y 
}

/*
Wonderful, except that mult and sum look almost identical, don't they?
What if we could combine the two?
*/
def app_func(x: Int , y: Int , f: (Int , Int) => Int): Int = {
    f(x , y)
}


app_func(5 , 6 , sum)
app_func(5 , 6 , mult)
// Great, this works
// What if I want to sum or mult more than 2 numbers? Hmmm...
