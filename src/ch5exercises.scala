import scala.math
import util.Random.nextInt

println("Chapter 5 Exercises")

/**
 * Function literal takes two integers and returns the higher
 */
val higher = (x: Int, y: Int) => if (y > x) y else x
val lower = (x: Int, y: Int) => if (y < x) y else x
val first = (x: Int, y: Int) => x
higher(3,4)
higher(5,1)

/**
 * Higher order function which take 3-tuple and uses 'higher' to find biggest
 */
def highest(a: Tuple3[Int, Int, Int], f: (Int, Int) => Int): Int = {
    val initial = f( a._1, a._2)
    f(initial, a._3)
}

highest( (9,8,3), higher)

/**
 * Get two random integers and return a comparison
 * The comparison is determined by the comparison function
 */
def randomCompare(f: (Int, Int) => Int): Int = {
    val a = util.Random.nextInt
    val b = util.Random.nextInt
    println(s"A: $a\nB: $b")
    f(a,b)
}

randomCompare(higher)
randomCompare(lower)
randomCompare(first)

/**
 * A higher order function to invoke consistent multiplication
 */
def ho(a: Int) = {
    // def multiply(x: Int): Int = {a * x}
    (x:Int) => a * x
}

val doubler = ho(2)
doubler(50)
val triple = ho(3)
triple(8)

/**
 * What does this function do?
 */
def fzero[A](x: A)(f: A => Unit): A = { f(x); x}

def square(m: Double) = m * m
val sq = square _

/*
 *
 */
def conditional[A](x: A)(p: A => Boolean)(f: A => A): A = {
    if ( p(x) == true) f(x) else x
}

def isEven(q: Int) = { q % 2 == 0 }
def quintuple(w: Int) = { w * 5 }

conditional[Int](4)(isEven)(quintuple)
conditional[Int](3)(isEven)(quintuple)




