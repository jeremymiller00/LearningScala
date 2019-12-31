// String data types

val s1: String = "With regards,\nYour Friend."
println(s1)
println()

println("Multiline strings use triple quotes and do not recognize \ ")
val greeting = """She suggested that we reformat the file by doing lots of fancy stuff to it before executing (\t) it \t there you \n go."""

println()

println("String Interpolation")
val approx = 355/113f
println(s"Pi, using 355/133, is about $approx.")
println()

println("With nonword characters, calculations, or text, you will need braces")
val a = "apple "
println(s"How do you like them ${a}s?")
println(s"How do you like them ${a * 3}s?")
println()

println("Printf notation is also very useful.")
val item = "apple"
f"I wrote a new $item%.3s today"
f"Enjoying this $item ${355/113.0}%.5f times today"
println()
println("A string is just a collection of characters.")
println("To indicate a single character use single quotes: val c = \'a\'")
val c = 'a'
println()
println("Int version of char is its ascii number")
val i: Int = c
val t: Char = 116


