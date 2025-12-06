import ticketmachine.CatalogRepository
import ticketmachine.PricingService
import ticketmachine.Station
import ticketmachine.TicketMachine
import ticketmachine.TicketType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TicketMachineTest {

    private lateinit var catalog: CatalogRepository
    private lateinit var pricing: PricingService
    private lateinit var ticketMachine: TicketMachine
    private lateinit var origin: Station

    @BeforeEach
    fun setUp() {
        catalog = CatalogRepository()
        pricing = PricingService()
        origin = catalog.stations[0] // London
        ticketMachine = TicketMachine(catalog, pricing, origin)
    }

    @Test
    fun testInsertMoney() {
        ticketMachine.insertMoney(1000)
        assertEquals(1000, ticketMachine.currentBalance)
    }

    @Test
    fun testPurchaseSingleTicket() {
        ticketMachine.insertMoney(1500)
        ticketMachine.purchaseTicket(2, TicketType.SINGLE) // Southampton
        assertEquals(0, ticketMachine.currentBalance)
        // Additional assertions can be added to verify ticket details
    }

    @Test
    fun testPurchaseReturnTicket() {
        ticketMachine.insertMoney(2700)
        ticketMachine.purchaseTicket(2, TicketType.RETURN) // Southampton
        assertEquals(0, ticketMachine.currentBalance)
        // Additional assertions can be added to verify ticket details
    }

    @Test
    fun testInsufficientFunds() {
        ticketMachine.insertMoney(1000)
        ticketMachine.purchaseTicket(2, TicketType.RETURN) // Southampton
        assertEquals(1000, ticketMachine.currentBalance) // Should not change balance
    }
}