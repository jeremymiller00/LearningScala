// Byte
// Short
// Int
// Long
// Float
// Decimal

println("Converting type from lower to higher ranks")
val b: Byte = 10
val s:Short = b
val d:Double = s

println()

println("Converting types from higher to lower rank not allowed!")
val l: Long = 20
val i: Int = l

println()

println("Conversion can be forced manually, but you may lose data!")
val l:Long = 20
val i: Int = l.toInt

println()

println("Types can also be specified with numeric literals")
val id = 100l
val f = 5f
val d = 5d

