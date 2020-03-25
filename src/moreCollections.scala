// Chapter 7
import collection.mutable._
import concurrent.ExecutionContext.Implicits.global
import concurrent.Future

println("Root type 'iterable' has immutable subtypes List, Set, and Map.")
println("Mutable collections:")
println("Mutable Map:")

val m = Map("APPL" -> 597, "MSFT" -> 40)
val n = m - "APPL" + ("GOOG" -> 521)
println(s"M: $m")
println(s"N: $n")

println("Creating new mutable data structures.")
println("List -> collection.mutable.Buffer")
println("Set -> collection.mutable.Set")
println("Map -> collection.mutable.Map")

val nums = collection.mutable.Buffer(1)
for ( i <- 2 to 20 ) { nums += i }
println(s"Nums: $nums")

val nums3 = collection.mutable.Buffer[Int]()
for ( i <- 1 to 10 ) { nums3 += i*3 }
println(s"Nums3: $nums3")

val list3 = nums3.toList

println("Creating mutable collections from immutable ones.")
println("Lists, Maps, and Sets can all be converted to Buffer with toBuffer method.")
val b = m.toBuffer
b trimStart 1
b += ("GOOG" -> 521)
val n = b.toMap
println("Buffer is a good general-purpose mutable collection.")
println("Builder is a simplified form of Buffer.")
println("Restricted to its assigned collection type; only supports append operations.")
val b = Set.newBuilder[Char]
b += 'h'
b ++= List('e', 'l', 'l', 'o')
val helloSet = b.result
println(s"Result: $helloSet")
println("Builder is best when building a mutable collection iteratively which you plan to convert to an immutable collection.")
println("Buffer is best when iterable operations are needed during building, or do not plan to convert to immutable.")

println("Arrays: fixed-sized, mutable, indexed collections.")
val colors = Array("red", "blue", "green")
colors(0) = "yellow"
colors

val files = new java.io.File("src").listFiles
val scala = files map (_.getName) filter (_ endsWith "scala")
println("Only use arrays when needed for compatibility with JVM code.")

println("Seq is the root of all sequences.")
println("Indexed sequences: Vector, Range")
println("Linear Sequences: Queue/Stack, List, Stream")
println("Vector is a list backed with an array for indexed access")
println("Scala Vector is analogous to Java ArrayList.")
println("Higher level types are rarely useful in themselves.")
println("String is also an immutable collection.")
val hi = "hello" ++ "worldly" take 12 replaceAll ("w", "W")

println("Stream is a LAZY collection, with its own special properties.")
println("Elements are added only when they are accessed for the first time.")
println("Streams can be unbounded, theoretically infinite collections where elements are only realized upon access.")
println("Streams can be terminated with Stream.empty")
def inc(i: Int): Stream[Int] = Stream.cons(i, inc(i + 1))
val s = inc(1)
val l = s.take(5).toList
println(" #:: is a cryptic way of invoking the cons operator of a Stream.")
def inc(head: Int): Stream[Int] = head #:: inc(head+1)
val s = inc(10).take(10).toList
println("A bounded stream:")
/**
 *  Generates a stream of characters with specified bounds
 */
def to(start: Char, end: Char): Stream[Char] = (start > end) match {
    case true => Stream.empty
    case false => start #:: to((start+1).toChar, end)
}

val someChars = to('A', 'F').take(20).toList

println("Monadic Collections: Collection with One element!")
println("Collection 'Option' extends iterable.")
println("Represents presence or absence of a single value")
println("A way of wrapping and advertising a potentially missing or incalculable value.")
println("Option relies on two subtypes for actual implementation: Some and None")

var x: String = "Indeed"
var a = Option(x)
x = null
var b = Option(x)

println(s"a is defined? ${a.isDefined}")
println(s"a is not defined? ${a.isEmpty}")
println(s"b is defined? ${b.isDefined}")
println(s"b is not defined? ${b.isEmpty}")

println("A realistic example: prevent division by 0")
def divide(amt: Double, divisor: Double): Option[Double] = {
    if (divisor == 0) None
    else Option(amt / divisor)
}
val legit = divide(5,2)
val illegit  = divide(3,0)

println("headOption is the head method wrapped in option")
val odds = List(1,3,5)
val firstOdd = odds.headOption
val evens = odds filter (_ % 2 == 0)
val firstEven = evens.headOption
val breaks = evens.head

println("Getting values out of Option: do NOT use .get()!")
println("Use fold or getOrElse")
println("The whole point of Option is to deal with missing values, and .get() fails with that")
def nextOption = if (util.Random.nextInt > 0) Some(1) else None
println("Some safe extractions:")
nextOption.fold(-1)(x => x)
nextOption getOrElse 5
nextOption getOrElse { println("error!"); -1 }
nextOption match { case Some(x) => x; case none => -1}

println("Monadic Collection: Try")
println("Turns error handling into collection management")
println("Scala raises errors by throwing Exceptions")
println("Unhandled exceptions will terminate application")
throw new Exception("Bad message here!")

def loopAndFail(end: Int, failAt: Int): Int = {
    for (i <- 1 to end) {
        println(s"$i")
        if (i == failAt) throw new Exception("Bad bad bad....")
    }
    end
}

loopAndFail(10,3)
println("Catch the exception with a Try collection")
val t1 = util.Try( loopAndFail(2,3))
val t2 = util.Try( loopAndFail(5,3))
println("Invoking with expression block")
val t3 = util.Try( loopAndFail( {val r = 5; r + 2 }, {val p = 2; p + 2} ) )

def nextError = util.Try{ 1 / util.Random.nextInt(2) }
val x = nextError
val y = nextError
val z = nextError

println("Common error handling techniques - p.124")
nextError flatMap {_ => nextError}
nextError foreach( x => println("success!" + x))
nextError getOrElse 0
nextError orElse nextError
nextError.toOption
nextError map (_ * 2)
nextError match {
    case util.Success(x) => x;
    case util.Failure(error) => -1
}
nextError // do nothing!
println("A common use case is validating numbers stored in strings")
val input = " 123 "
val result = util.Try(input.toInt) orElse util.Try(input.trim.toInt)
result foreach { r => println(s"Parsed '$input' to $r!")}
val x = result match {
    case util.Success(x) => Some(x)
    case util.Failure(ex) => {
        println(s"Couldn't parse input '$input'")
        None
    }
}
println("The only wrong way is to simply ignore exceptions!")

println("Future Collections!!!!! Initiates a background task.")
println("concurrent.Future")
println("Unlike Option or Try, a future's value may not be available on initialization")
println("A Future is a monitor of a Java background thread, awaiting a result")
println("You must first specify the context!")
val f = concurrent.Future { println("Hi!")}
f
val f = concurrent.Future {Thread.sleep(5000); println("Hello!")}
f
println("Specify a callback function to receive the eventual result of a Future")

def nextFtr(i: Int = 0) = Future {
  def rand(x: Int) = util.Random.nextInt(x)

  Thread.sleep(rand(500))
  if (rand(3) > 0 ) (i + 1) else throw new Exception
}

nextFtr(1) fallbackTo nextFtr(2)
nextFtr(1) flatMap nextFtr(2)
nextFtr(1) map (_ * 2)
nextFtr(1) onComplete { _ getOrElse 0 }
nextFtr(1) onFailure { case _ => "Error!" }
nextFtr(1) onSuccess { case x => s"Got $x!" }
concurrent.Future sequence List(nextFtr(1), nextFtr(5))

import concurrent.duration._
val maxTime = Duration(10, SECONDS)
val amount = concurrent.Await.result( nextFtr(5), maxTime)








