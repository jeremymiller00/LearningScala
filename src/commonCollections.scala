println("Collection")
println("Scala has java collection plus higher order:\n\tmap\n\treduce\n\tfilter")
println("There are mutable and immutable collectons")

println("List")
val nums = List(1,2,3,4)
val colors = List("red", "blue", "green")
println(s"I have ${colors.size} colors: $colors")
nums.head
colors.tail //not the last element, but all that remains after head

nums(2)
colors(0)

println("Interating over lists with For-loops")
var total = 0; for ( i <- nums ) { total += i }
for (i <- colors){println(s"The color is $i")}

println("Some higher order functions")
colors.foreach( (c: String) => println(c) )
val sizes = colors.map( (c:String) => c.size )
val total = nums.reduce( (a:Int, b: Int) => a+b )

val unique = Set(10, 20, 30, 20, 20, 10)
val setSum = unique.reduce( (a: Int, b: Int) => a+b)
val doubleSet = unique.map( (x: Int) => x * 2)
val colorMap = Map("red" -> 1, "green" -> 2)
val cmap = Map( ("red", 1), ("green", 2) )
val redColor = colorMap("red")
for (pair <- cmap) {println(pair)}
val listy = 1 :: 2 :: 3 :: Nil
val another = 7 :: listy
val yetAnother = another ::: listy
List(1,2) ++ Set(3,4,3)
List(1,2,3,23,2,3,4).distinct
List(1,2,3,4,5) drop 3
List(1,2,3,4,5) filter(_ > 3)
List( List(1,2,3), List(6,7,8) ).flatten
List(1,2,3,4,5,6) partition(_ % 2 == 0)
List(1,2,3).reverse
List(1,2,3,4,5) slice (1,3)
List("there", "you", "go") sortBy (_.size)
List("there", "you", "go").sorted
List(1,2,3,4,5,6) splitAt 3
List(1,2,3,4,5) take 3
List(1,2) zip List("a","b")
println("A predicate function takes an input and returns boolean")
println("The underscore '_' in higher-order function represents every item in the list.")
println("Function that operate on the front of the list do not have performance penalties" )
println("i.e. ::, drop, take")
println("These are right associative operators")
println("Mapping lists:")
List(1,2,3) collect {case 2 => "ok then"}
List("milk,tea") flatMap (_.split(","))
List("milk", "tea") map (_.toUpperCase)

println("Reducing a list: can be an aggregation")
List(44,66,77).max
List(10.4,5, 989).min  
List(5,6,7).product
List(12,3).sum 
List(29, 66).contains(29)
List(29,66, 77) endsWith List(66)
List(1,2,3) endsWith List(2,3)
List(3,4,5,6) forall (_ < 4)
List(2,3,4) startsWith List(2,3)

/**
 * Basic contains logic
 */
def contains(x: Int, l: List[Int]): Boolean = {
    var a: Boolean = false
    for (i <- l) {
        if (!a)
        a = (i == x)
    } 
    a
}

contains(3, List(3,4,5))

/**
 * Separate 'contains' logic in function parameter
 */
def boolReduce(l: List[Int], start: Boolean)(f: (Boolean, Int) => Boolean): Boolean = {
    var a = start
    for (i <- l) a = f(a, i)
    a
}

println("But we can use Scala's built in list folding functions!")

List(4,5,6).fold(0)(_+_) // 0 is the starting value
List(4,5,6).fold(5)(_+_)
List(4,5,6).foldLeft(0)(_+_)
List(4,5,6).foldRight(0)(_+_)
List(4,5,6).reduce(_+_)
List(4,5,6).reduceLeft(_+_)
List(4,5,6).reduceRight (_+_)
List(4,5,6).scan(0)(_+_) // returns a list of accumulated values
List(4,5,6).scanLeft(0)(_+_) 
List(4,5,6).scanRight(0)(_+_) 

println("The LEFT versions require fewer traversals through the list!")

List(1,2,3).mkString(", ")
List(1,2,3).toBuffer
Map("a" -> 1, "b" -> 2).toList
Set(1 -> true, 3 -> true).toMap
List(1,2,3,2).toSet
List(1,2,3).toString

println("Immutable collections cannot be built from empty: List, Map, Set.")
println("It is better to start with an existing collection.")












