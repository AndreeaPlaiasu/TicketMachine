import java.util.Scanner

class UserInterface(private val machine: TicketMachine) {
    private val scanner = Scanner(System.`in`)

    fun start() {
        println("Welcome to the Ticket Machine!\n")
        machine.listDestinations()

        print("\nEnter destination: ")
        val destName = scanner.nextLine()
        val destination = machine.searchDestination(destName)

        if (destination == null) {
            println("Destination not found.")
            return
        }

        print("Single or Return? ")
        val type = scanner.nextLine()

        val price = machine.calculatePrice(destination, type)
        println("Ticket price: £${"%.2f".format(price)}")

        print("Insert money: £")
        val money = scanner.nextDouble()

        val ticket = machine.sellTicket(destination, type, money)
        if (ticket != null) {
            ticket.printTicket()
        }
    }
}
