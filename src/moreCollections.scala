// Chapter 7
import collection.mutable._

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

