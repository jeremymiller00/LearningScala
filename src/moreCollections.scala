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




