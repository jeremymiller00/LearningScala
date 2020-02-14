println("Chapter 6 Exercises!")

/**
 * First N odd Long
 */
def firstOdd(n: Int): List[Long] = {
    (1 to (n*2)).toList.map(_.toLong).filter(_ % 2 == 1)
}

firstOdd(100)
firstOdd(10)

/**
 * Return natural number factors
 */
def factors(n: Int): List[Int] = {
    (2 to (n-1)).toList.filter(n % _ == 0)
}

factors(8)
factors(100)

/**
 * Apply factors to a list
 */
def factorsOfList(l: List[Long], f: Int => List[Int]): List[Int] = {
  l.map(_.toInt).map(factors(_)).flatten.distinct.toList.sorted
}

factorsOfList(firstOdd(100), factors)

/**
 * Return the first N elements of a list in a new list
 */
def first[A](items: List[A], count: Int): List[A] = {
  items.take(count)
}
val items = List[Double](2.3, 6.6, 8.6, 5.66)
first[Double](items, 3)

def firstF[A](items: List[A], count: Int): List[A] = {
  items.foldLeft[List[A]](Nil) {
    (a: List[A], i: A) =>
    if (a.size >= count) a else i :: a
  }.reverse
}
val items = List[Double](2.3, 6.6, 8.6, 5.66)
firstF[Double](items, 3)

/**
 * Return longest string in list
 */
def longestString(a: List[String]): String = {
  // a.reduce( {
  //   (a: String, b: String) =>
  //   if (a.size > b.size) a else b } )
  a.fold("")({
    (a: String, b: String) =>
    if (a.size > b.size) a else b })
  }
longestString(List("The", "biggest", "word"))

/**
 * Return longest item in list
 */
def longestItem[A](a: List[A]): A = {
  a.reduce( {
    (a, b) =>
    if (a.toString.size > b.toString.size) a else b } )
  }

longestItem[String](List("The", "biggest", "word"))
longestItem[List[Int]](List(List(1,2), List(1,2,3,4), List(1,2,3) ))


/**
 * Reverse a list
 */
def reverser[A](source: List[A], dest: List[A] = Nil): List[A] = {
  if (source == Nil) dest else reverser(source.tail, source.head::dest)
}

reverser(List(1,2,3,4))

/**
 * Input: a list of strings
 * Output: Tuple of lists -> List of strings of palindromes; List of remaining strings
 */
def stringSplitter(l: List[String]): Tuple2[List[String], List[String]] = {
  l.partition(_.size == 3)
}

stringSplitter(List("cat", "tat", "dad", "data"))