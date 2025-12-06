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
        scanner.nextLine()

        val ticket = machine.sellTicket(destination, type, money)
        if (ticket != null) {
            ticket.printTicket()
        }
    }

    fun adminMenu() {
        while (true) {
            println("\n--- ADMIN MENU ---")
            println("1. View offers")
            println("2. Add offer")
            println("3. Search offers")
            println("4. Delete offer")
            println("5. Logout")
            print("Choose option: ")

            when (scanner.nextLine().trim()) {
                "1" -> viewOffers()
                "2" -> addOfferMenu()
                "3" -> searchOfferMenu()
                "4" -> deleteOfferMenu()
                "5" -> return
                else -> println("Invalid option.")
            }
        }
    }

    fun addOfferMenu() {
        print("Station: ")
        val station = scanner.nextLine()
        print("Discount (%): ")
        val discount = scanner.nextLine().toDouble()
        print("Start date: ")
        val start = scanner.nextLine()
        print("End date: ")
        val end = scanner.nextLine()

        addOffer(station, discount, start, end)
    }
    fun adminLogin() {
        print("Username: ")
        val user = scanner.nextLine()
        print("Password: ")
        val pass = scanner.nextLine()

        if (checkLogin(user, pass)) {
            println("Login successful!")
            adminMenu()
        } else {
            println("Invalid credentials.")
        }
    }

    fun searchOfferMenu() {
        print("Enter station to search: ")
        val station = scanner.nextLine()
        searchOffers(station)
    }

    fun deleteOfferMenu() {
        print("Enter Offer ID to delete: ")
        val id = scanner.nextLine().toInt()
        deleteOffer(id)
    }

}
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
