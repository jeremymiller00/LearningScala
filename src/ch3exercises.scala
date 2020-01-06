val a = "Test"
val b = ""
val c = "tester"

val inny = a

val output = inny match {
  case "" => println("n/a")
  case _ => println(s"$inny")
}

val n1: Double = 5.4
val n2: Double = 0.0
val n3: Double = -3.2
val num = n3

val comparedToZero = num match {
  case x if x > 0.0 => "greater"
  case x if x == 0.0 => "same"
  case x if x < 0.0 => "less"
}

if (num > 0.0) {"greater"}
if (num == 0.0) {"same"}
if (num < 0.0) {"less"}

val color = "blah"

val hex = color match {
  case "cyan" => "00ffff"
  case "magenta" => "#ff00ff"
  case "yellow" => "ffff00"
  case other => println(s"Color not found: $other")
}

for (i <- 1 to 100) {
  print(i + " ")
  if (i % 5 == 0) {
    print("\n")
  }
}


//for (i <- 1 to 100) {
//  if (i % 15 == 0) {println("typesafe")} 
//  if (i % 5 == 0 & i % 15 != 0) {println("safe")} 
//  if (i % 3 == 0 & i % 15 != 0) {println("type")} 
//  else {println(s"$i")}
//}

for (i <- 1 to 100) {
  if (i % 15 == 0) {println("typesafe")} 
  else if (i % 5 == 0) {println("safe")} 
  else if (i % 3 == 0) {println("type")} 
  else {println(s"$i")}
}





