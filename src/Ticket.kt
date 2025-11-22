data class Ticket(
    val origin: String,
    val destination: String,
    val price: Double,
    val type: String
) {
    fun printTicket() {
        println()
        println("***")
        println(origin)
        println("to")
        println(destination)
        println("Price: £${"%.2f".format(price)} [$type]")
        println("***")
        println()
    }
}