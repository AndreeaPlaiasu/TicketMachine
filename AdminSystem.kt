class AdminSystem {
    fun displayMenu() {
        while (true) {
            println("\n=== Admin Panel ===")
            println("1. View All Destinations")
            println("2. Add New Destination")
            println("3. Edit Existing Destination")
            println("4. Change All Ticket Prices")
            println("5. Back to Main Menu")
            print("Enter choice: ")

            when (readLine()?.toIntOrNull()) {
                1 -> viewAllDestinations()
                2 -> addDestination()
                3 -> editDestination()
                4 -> changeAllPrices()
                5 -> return
                else -> println("Invalid choice. Please try again.")
            }
        }
    }