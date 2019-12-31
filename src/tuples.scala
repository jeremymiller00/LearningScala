println("Tuples are ordered colletions of values. Not iterable.")
val info = (5, "yes", true)
println("Tuples have 1-based indexing")
info._2
println("A common way of makign 2-tuples, like a key-value pair.")
val red = "red" -> "0xff0000"
val reversed = red._2 -> red._1
