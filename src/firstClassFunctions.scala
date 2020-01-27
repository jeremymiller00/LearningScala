println("First Class Functions")
println("This means that can be treated like any other data type!")
println("This means a function can be:\n\tcreated in literal form\n\tstored in a container\n\tparameter or return value")
println("Higher Order Functions:\n\taccept other functions as parameters\n\treturn functions")
println("For example: map(), reduce()")
println("Declarative Programming\n\tcalled function specifies WHAT\n\thigher-order function specifies HOW")

println("Function type")

def double(x: Int): Int = x * 2
double(5)
println("The type of double is (Int => Int)")

println("Some Examples")

val myDouble: (Int) => Int = double
myDouble(10)

val myDoubleCopy = myDouble
myDoubleCopy(20)

println("A shortcut using _ ")
val myDouble = double _
myDouble(30)

println("Multiple parameters")
def max(a: Int, b: Int) = if (a > b) a else b
max(6,7)

val maximize: (Int, Int) => Int = max 
maximize(9,8)

println("Higher-order functions: example use case")
println("Calling a function to act on a string, but only if the string is not null")
def safeStringOp(s: String, f: String => String) = {
    if (s != null) f(s) else s
}

def reverser(s: String) = s.reverse

safeStringOp(null, reverser)
safeStringOp("Ready", reverser)

println("Function Literals (anonymous functions); like lambda functions in Python")
val doubler = (x: Int) => x * 2
val doubled = doubler(22)

println("A function literal is really just a parameterized expression")

println("Placeholder Syntax")
safeStringOp("ready", _.reverse)
println("Reduces the amount of extra code when using first-class functions")

println("Partially-applied Functions: use some, but not all, of the parameters of the higher-order fuction")
def factorOf(x: Int, y: Int) = y % x == 0
val multipleOf3 = factorOf(3, _: Int)
multipleOf3(78)

println("Partial Function: like in math, sqrt (input cannot be negative")
val statusHandler: Int => String = {
    case 200 => "Okay"
    case 400 => "Your Error"
    case 500 => "Our error"
}

def square[A](x: A): A = {x * x}
square[Int](3)