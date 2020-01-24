import scala.math

println("Functions Exercises")

/**
 * A function to compute the area of a circle given its radius
 * Area = pi * r^2
 * input: Double
 * returns: Double
 */
def area(radius: Double): Double = {
  math.Pi * math.pow(radius, 2)
}

area(3.2)


def areaString(radius: String): Double = {
  math.Pi * math.pow(radius.toDouble, 2)
}

areaString("3.2")
// areaString("") // will error

/**
 * A recursive function for printing values by 5
 */
@annotation.tailrec
def byFive(start: Int = 5): Any = {
  println(start)
  if (start == 50) println("Done")
  else byFive(start + 5)
}

byFive()

/**
 *
 */
def milliToDays(milliseconds: Int): Any = {
  val days = (milliseconds / (24 * 60 * 60 * 1000)).toInt
  println(days)
  val leftAfterDays = (milliseconds % (24 * 60 * 60 * 1000))
  println(leftAfterDays)
  val hours = (leftAfterDays / (60 * 60 * 1000)).toInt
  println(hours)
  val leftAfterHours = (leftAfterDays % (60 * 60 * 1000))
  println(leftAfterHours)
  val minutes = (leftAfterHours / (60 * 1000)).toInt
  println(minutes)
  val leftAfterMinutes = (leftAfterHours % (60 * 1000))
  println(leftAfterMinutes)
  val seconds = leftAfterMinutes/1000.toInt
  println(s"That equals $days days, $hours hours, $minutes minutes, and $seconds seconds.")
}

milliToDays(1234567890)

/**
 * Power Function
 */
def power(base: Long, exp: Long): Long = {
  var output = base
  for(i <- 2 to exp.toInt) {
    output *= base
  }
  output
}

power(7,10 )

/**
Calculate the euclidean distance between two points on a cartesian plane
 */
def euclideanDistance(a: Tuple2[Double, Double], b: Tuple2[Double, Double]): Double = {
  math.sqrt( math.pow(math.abs(a._1 - b._1), 2) + math.pow(math.abs(a._2 - b._2), 2) )
}

euclideanDistance((5.6, 7.7), (99, 0.3))

/**
Move int to the front
 */
def moveItIf(a: Tuple2[Any, Any]): Tuple2[Any, Any] = {
  if (a._1.isInstanceOf[Int]) {
    return a
  }
  else if (a._2.isInstanceOf[Int]) {
    return (a._2, a._1)
  }
  else {
    return a
  }
}

moveItIf(3.4, 7)

/**
Three to six
 */
def threeToSix(x: Tuple3[Any, Any, Any]): Tuple6[Any, String, Any, String, Any, String] = {
  (x._1, x._1.toString, x._2, x._2.toString, x._3, x._3.toString)
}
threeToSix(5, true, "yes")

