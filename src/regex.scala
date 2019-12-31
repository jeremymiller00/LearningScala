println("Regular expressions in scala.\n")
println("String dataype supports Regex.\n")
"milk, tea, muck" replaceAll ("m[^ ] +k", "coffee")

println("Use triple quotes for the regex to avoid having to double escape.")
val input = "Enjoying this apple 3.14159 times today"
println("The capture group is the series of digits and a period between apple and times.")
val pattern = """.*apple ([\d.]+) times .*""".r
println("Applying the regex is a bit odd.\nval pattern(output) = input")
val pattern(amountText) = input
val amount = amountText.toDouble

