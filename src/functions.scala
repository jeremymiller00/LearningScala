println("Functions")

println("A pure function:\n\tHas input parameters\n\tPerforms Calculations using only the input parameters\n\tReturns a value\n\tAlways returns the same value for the same input\n\tDoes not use or effect any data outside the function\n\tIs not affected by any data outside the function.")

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

def power(x: Int, n: Int): Long ={
  if (n >= 1) x * power(x, n-1)
  else 1
}

power(2,8)
power(2,0)