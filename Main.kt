fun main() {
    val customerSystem = CustomerSystem()
    val adminSystem = AdminSystem()
    val loginSystem = LoginSystem()

    println("=== Train Ticket Booking System ===\n")

    while (true) {
        println("\nSelect Mode:")
        println("1. Customer - Buy Ticket")
        println("2. Admin - Manage Destinations (Direct Access)")
        println("3. Admin - Manage Destinations (With Login)")
        println("4. Exit")
        print("Enter choice: ")

        when (readLine()?.toIntOrNull()) {
            1 -> customerSystem.displayMenu()
            2 -> adminSystem.displayMenu()
            3 -> {
                if (loginSystem.login()) {
                    adminSystem.displayMenu()
                }
            }
            4 -> {
                println("Thank you for using the Train Ticket System!")
                return
            }
            else -> println("Invalid choice. Please try again.")
        }
    }
}