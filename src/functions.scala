println("Functions")

println("A pure function:\n\tHas input parameters\n\tPerforms Calculations using only the input parameters\n\tReturns a value\n\tAlways returns the same value for the same input\n\tDoes not use or effect any data outside the function\n\tIs not affected by any data outside the function.")
println("Functions can have the same name, as long as they take different sets of parameters, like Java.")
println("In Scala, functions are first class citizens\nThey can be treated as data.")
def multiply(x: Int, y:Int): Int = { x * y}

multiply(3,4)

def safeTrim(s: String): String = {
  if (s == null) return null
  s.trim()
  }

safeTrim("what   ")
safeTrim(null)

println("A procedure is a function that doesn't have a return value")

println("Function invocation with Expression Blocks")

def formatEuro(amt: Double) = f"EUR$amt%.2f"
formatEuro(3.41234)
formatEuro {val rate = 1.32; 0.234+0.7123+rate*5.32}

println("Recursive functions")
@annotation.tailrec
def power(x: Int, n: Int): Long ={
  if (n >= 1) x * power(x, n-1)
  else 1
}
println("For tail recursion, the recursive function must be the LAST operation of the function")
@annotation.tailrec
def power(x: Int, n: Int, t:Int = 1): Int ={
  if (n < 1) t
  else power(x, n-1, x*t) // here the recursive function call is the LAST operation
}

power(x=2,n=8)
power(x=2,n=3)

println("Vargarg Parameters")
/**
* This is the docstring for the function
* Accepts a variable number of ints
* Returns the sum of the ints
*/
def sum(items: Int*): Int = {
  var total = 0
  for (i <- items) total += i
  total
}

sum(1,2,3,4)
sum(123,456)

println("Parameter Groups: will be useful with higher-order functions")
def max(x: Int)(y: Int) = if (x > y) x else y

println("Type Parameters: user can specify output type")
def identity[A](a: A): A = a 
identity[String]("Hello")
identity[Double](2.34)
identity[String](2.34) // will error

println("Built in methods")
val d = 65.234
d.round
d.floor
d.compare(18.0)
d.+(2.32)

println("Methods which take at least one parameter can be used with infix operator notation.")
d compare 18.0
d + 2.721

