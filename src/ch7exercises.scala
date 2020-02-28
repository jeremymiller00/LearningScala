// A set of exercises based on the Fibonacci Series
// 1, 1, 2, 3, 5, 8, 13, 21, 34, ...

import collection.mutable.Buffer

/**
 * A function that returns the first N elements of Fibonacci series
 */
def fibonacci(n: Int): List[Int] = {
    if (n < 1) return List(0)
    val output = collection.mutable.Buffer(1)
    for ( i <- 1 to n ) { output += { output.takeRight(2).sum } }
    return output.toList
    }

/**
 * A function that returns the first N elements of Fibonacci series
 * Use Match statements
 */
// def fibonacci(n: Int): List[Int] = {
//     val output = n match {
//     case n if n < 1 => List(0)
//     case other => {
//         collection.mutable.Buffer(1)
//         for ( i <- 1 to n ) { output += { output.takeRight(2).sum } }
//     return output.toList
//         }
//     }}

fibonacci(0)
fibonacci(4)
fibonacci(10)
fibonacci(20)

/**
 * Input: a list numbers
 * Output: an extended list with N more fibonacci numbers
 */
def fibonacciExtender(start: List[Int], n: Int): List[Int] = {
    if (start.length < 1) return List()
    val output = start.toBuffer
    for ( i <- 1 to n ) { output += { output.takeRight(2).sum } }
    return output.toList
    }

val seed1 = List(1,1,2,3,5,8)
val seed2 = List(1)
val seed3 = List()
fibonacciExtender(seed1, 4)
fibonacciExtender(seed2, 8)
fibonacciExtender(seed3, 5)

/**
 * Fibonacci using Stream
 */
def fibonacciStream(n: Int): Stream[Int] = (n > 0) match {
    case true => Stream.empty
    case false => {
        Stream.cons(1, 1 + n)
    }
}


def to(start: Char, end: Char): Stream[Char] = (start > end) match {
    case true => Stream.empty
    case false => start #:: to((start+1).toChar, end)
}