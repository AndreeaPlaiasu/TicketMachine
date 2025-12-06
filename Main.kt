package ticketmachine

fun main() {
    println("=== Ticket Machine ===")
    
    val catalog = CatalogRepository()
    val pricing = PricingService()
    val origin = catalog.stations[0] // Assuming the first station is the starting point
    val ticketMachine = TicketMachine(catalog, pricing, origin)

    ticketMachine.showDestinations()
}