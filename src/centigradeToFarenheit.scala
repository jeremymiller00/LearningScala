val c = 20
val i = c * 9
val t = i / 5
val f = t + 32
val input = 2.7255
println(f"You owe $$${input}%.2f.")
val num = 117 
val c = num.toChar
val s = c.toString
val c2 = s.charAt(0)
val d: Int = c2 

val address = "Frank,123 Main,925-555-1943,95122"
val pattern = """.*([0-9]{3}[-][0-9]{3}[-][0-9]{4}).*""".r
val pattern(phone) = address
val spl = phone.split("-")
val ints = spl.map(_.toInt)
val t = ints match {case Array(a,b,c) => (a,b,c)}

