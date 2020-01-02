if (47 % 3 > 0) println("Not a multiple of 3")
val x = 10
val y = 20
val max = if (x > y) x else y

println("Conditional logic in Scala is better expressed in match expressions")
println("Like a switch statement is Java")
println("A single input is evaluated and the first pattern that is matched is executed")
println("There is no fall-through or break statement")

val max = x > y match {
  case true => x
  case false => y
}

println("Another example")
val status = 400
val message  = status match {
  case 200 => "ok"
  case 400 => {
    println("Error - we called the service incorrectly")
  }
  case 500 => {
    println("Error - the service encountered an error")
    "error"
  }
}

println("Or statements can be used")
val day = "MON"
val kind = day match {
  case "MON" | "TUE" | "WED" | "THU" | "FRI" =>
    "weekday"
  case "SAT" | "SUN" =>
    "weekend"
  }

println("Use value binding in case there is no match in the specified cases")
val message = "kk"
val status = message match {
  case "ok" => 200
  case other => {
    println(s"Couldn't parse $other")
    -1
  }
}

println("Use wildcards in case there is no match in the specified cases")
println("Note that the wildcard value cannot be accessed after the => ")
val message = "Unauthorized"
val status = message match {
  case "ok" => 200
  case _ => {
    println(s"Couldn't parse $message")
    -1
  }
}
println("Using if statments in match expressions")
val response: String = null
response match {
  case s if s != null => println(s"Received $s")
  case s => println("Error! Received a null response")
}

println("Pattern matching with type")
val x: Int = 12100
val y: Any = x
y match {
  case x: String => s"'x'"
  case e: Double => f"$x%.2f"
  case x: Float => f"$x%.2f" 
  case x: Long => s"${x}l"
  case x: Int => s"${x}i"
}

println("Range data structures")
println("Loops")
for (x <- 1 to 7) {println(s"Day $x: ")}

println("When using keyword yield, returned values are stored in a collection")
for (x <- 1 to 7) yield {(s"Day $x: ")}

println("Iterator guards:")
val threes = for (i <- 1 to 20 if i % 3 == 0) yield i

val quote = "Faith,Hope,,Charity"
for {
  t <- quote.split(",")
  if t != null
  if t.size > 0
}
{ println(t) }

println("Nested interators")
for { x <- 1 to 2
  y <- 1 to 3}
  { println(s"($x$y) ")}

println("Value binding in a for loop")
val powersOf2 = for (i <- 0 to 8; pow = 1 << i) yield pow

println("While loops are less common in Scala")
var x = 10 
while (x > 0) {
  x -= 1
  println(s"X: $x")
}
println("Do/while loops: statement is executed BEFORE the boolean is checked")
val x = 0
do println(s"Here I am, x = $x") while (x > 0)


