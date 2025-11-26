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


class LoginSystem{
    private val users = listOf(User("admin", "admin123"))
    var isLoggedIn = false

    fun login(username: String, password: String): Boolean {
        for (user in users){
            if (user.username == username && user.password == password){
                isLoggedIn = true
                println("Logged in successfully!")
                return true
            }
        }
        println("Logged in failed!")
        return false
    }
    fun logout() {
        isLoggedIn = false
        println("Logged out!")
    }

}
class SpecialOffers{
    private val offers = mutableListOf<SpecialOffers>()
    private var nextId = 1
}

