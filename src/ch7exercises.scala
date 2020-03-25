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

fibonacci(0)
fibonacci(4)
fibonacci(10)
fibonacci(20)

/**
 * A function that returns the first N elements of Fibonacci series
 * Using Match statements
 */
// def fibonacciMatch(n: Int): List[Int] = {
//     val output = n match {
//         case n if n < 1 => List(0)
//         case other => {
//             val output = collection.mutable.Buffer(1)
//             for ( i <- 1 to n ) { output += { output.takeRight(2).sum } } }
//             return output.toList
//         }}


// fibonacciMatch(0)
// fibonacciMatch(4)
// fibonacciMatch(10)
// fibonacciMatch(20)


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
val seed3 = List(1, 1)
fibonacciExtender(seed1, 4)
fibonacciExtender(seed2, 8)
fibonacciExtender(seed3, 5)

/**
 * Tail-recursive Fibonacci Extender
 */
@annotation.tailrec
def tailRecursiveFibonacciExtender(start: List[Int], count: Int): List[Int] = {
    if (count < 1) start
    else {
        val k = start :+ start.takeRight(2).sum
        tailRecursiveFibonacciExtender(k, count - 1)
    }
}
tailRecursiveFibonacciExtender(seed1, 4)
tailRecursiveFibonacciExtender(seed2, 8)
tailRecursiveFibonacciExtender(seed3, 5)

/**
 * Fibonacci using Stream
 */
// def fib(a: Int, b: Int): Stream[Int] = a #:: fib(b, a + b)
def fib(a: Long, b: Long): Stream[Long] = Stream.cons(a, fib(b, a + b))
fib(1,1).take(100).toList
// 4 byte integers are insufficient

/**
 * Takes a fibonacci element and returns the next 
 * Need to generate values up to input element
 */
def nextFib(a: Long): Option[Long] = {
    val start = fib(1, 1)
    val preceeding = start.takeWhile(_ <= a).toList
    if (preceeding.last == a) Some(preceeding.takeRight(2).sum)
    else None
}
val x = nextFib(21)
val x = nextFib(22)
