println("Boolean values and the relationships to ints, etc.")
val isTrue = !true
val isFalse = !true
val unequal = (5 != 6)
val isLess = (5 < 6)
val unequalAndLess = unequal & isLess
val definitelyFalse = false && unequal

println("Scala does NOT support automatic conversion of other types to boolean.")
println("A non-null string cannot be evaluated as true.")
println("The number zero does NOT equal false.")
println("You must use an explicit comparison.")

val zero = 0
val isValid = zero > 0
println("Unit type is like void in Java.")
println("It is indicated: val nada = ()")
val nada = ()

