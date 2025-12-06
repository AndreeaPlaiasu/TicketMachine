class TicketMachine {

    private val origin = "Southampton Central"

    private val destinations = mutableListOf(
        Destination("London Waterloo", 35.50, 60.00),
        Destination("Bournemouth", 12.20, 20.00),
        Destination("Winchester", 8.00, 14.50)
    )

    var totalTakings = 0.0

    fun listDestinations() {
        println("Available destinations:")
        for (d in destinations) {
            println("- ${d.name}: Single £${d.singlePrice}, Return £${d.returnPrice}")
        }
    }

    fun searchDestination(name: String): Destination? {
        return destinations.find { it.name.equals(name, ignoreCase = true) }
    }

    fun calculatePrice(destination: Destination, type: String): Double {
        return if (type.equals("return", ignoreCase = true)) destination.returnPrice else destination.singlePrice
    }

    fun sellTicket(destination: Destination, type: String, money: Double): Ticket? {
        val price = calculatePrice(destination, type)
        return if (money >= price) {
            val change = money - price
            destination.increaseSales()
            totalTakings += price
            println("Ticket purchased successfully!")
            println("Change returned: £${"%.2f".format(change)}")
            Ticket(origin, destination.name, price, type)
        } else {
            println("Not enough money! You need £${"%.2f".format(price - money)} more.")
            null
        }
    }

}

val offers = mutableListOf<SpecialOffer>()
var offerId = 1

fun checkLogin(user: String, pass: String): Boolean {
    return user == "admin" && pass == "admin123"
}

fun addOffer(station: String, discount: Double, start: String, end: String) {
    offers.add(SpecialOffer(offerId++, station, discount, start, end))
    println("Offer added!")
}

fun viewOffers() {
    if (offers.isEmpty()) println("No offers.")
    for (o in offers) println("${o.id}. ${o.station} - ${o.discount}% off (${o.start} to ${o.end})")
}

fun searchOffers(station: String) {
    for (o in offers) {
        if (o.station.contains(station, true)) {
            println("${o.id}. ${o.station} - ${o.discount}% off")
        }
    }
}

fun deleteOffer(id: Int) {
    offers.removeIf { it.id == id }
    println("Deleted.")
}

class TicketMachine {

    private val origin = "Southampton Central"

    private val destinations = mutableListOf(
        Destination("London Waterloo", 35.50, 60.00),
        Destination("Bournemouth", 12.20, 20.00),
        Destination("Winchester", 8.00, 14.50)
    )

    var totalTakings = 0.0

    fun listDestinations() {
        println("Available destinations:")
        for (d in destinations) {
            println("- ${d.name}: Single £${d.singlePrice}, Return £${d.returnPrice}")
        }
    }

    fun searchDestination(name: String): Destination? {
        return destinations.find { it.name.equals(name, ignoreCase = true) }
    }

    fun calculatePrice(destination: Destination, type: String): Double {
        return if (type.equals("return", ignoreCase = true)) destination.returnPrice else destination.singlePrice
    }

    fun sellTicket(destination: Destination, type: String, money: Double): Ticket? {
        val price = calculatePrice(destination, type)
        return if (money >= price) {
            destination.increaseSales()
            totalTakings += price
            Ticket(origin, destination.name, price, type)
        } else {
            println("Not enough money! You need £${"%.2f".format(price - money)} more.")
            null
        }
    }
}
