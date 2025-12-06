package ticketmachine

class PricingService {
    fun calculatePrice(station: Station, type: TicketType): Int {
        return when (type) {
            TicketType.SINGLE -> station.singlePricePence
            TicketType.RETURN -> station.returnPricePence
        }
    }
}