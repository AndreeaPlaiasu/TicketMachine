package ticketmachine

class TicketMachine(
    private val catalog: CatalogRepository,
    private val pricing: PricingService,
    private val origin: Station
) {
    var currentBalance: Int = 0

    fun showDestinations() {
        println("Available Destinations:")
        catalog.stations.forEach { station ->
            println("${station.name} - Single: ${station.singlePricePence / 100}£, Return: ${station.returnPricePence / 100}£")
        }
    }

    fun insertMoney(amountPence: Int) {
        currentBalance += amountPence
        println("Inserted: ${amountPence / 100}£. Current balance: ${currentBalance / 100}£")
    }

    fun purchaseTicket(destinationId: Int, type: TicketType) {
        val destination = catalog.stations.find { it.id == destinationId }
        if (destination == null) {
            println("Invalid destination ID.")
            return
        }

        val price = pricing.calculatePrice(destination, type)
        if (currentBalance < price) {
            println("Insufficient balance. Please insert more money.")
            return
        }

        currentBalance -= price
        catalog.recordSale(origin.id, price)
        val ticket = Ticket(origin, destination, type, price)
        printTicket(ticket)
    }

    private fun printTicket(ticket: Ticket) {
        println("Ticket purchased:")
        println("From: ${ticket.origin.name} To: ${ticket.destination.name}")
        println("Type: ${ticket.type}, Price: ${ticket.pricePence / 100}£")
    }
}