
/*
Implement isSorted, which checks whether an Array[A] is sorted according to a given comparison function
*/


def isSorted[A](as: Array[A] , ordered: (A , A) => Boolean): Boolean = {
    // Need to go over the arr and check if each val pair is in asc order

    def loop(n: Int): Boolean = {
        if (n == as.length - 1) {
            true 
        }
        else if (ordered(as(n) , as(n + 1))) {
            loop(n + 1) 
        }
        else {
            false
        }
    }
    loop(0)
}


isSorted(Array[Int](1 , 2 , 2 , 2 , 2 , 2 , 1 , 5 , 6) , (x: Int , y:Int) => x <= y)
