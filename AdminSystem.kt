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

    private fun viewAllDestinations() {
        println("\n=== All Destinations ===")
        println("-".repeat(80))
        println("%-5s %-20s %-15s %-15s %-10s".format("No.", "Station Name", "Single Price", "Return Price", "Sales"))
        println("-".repeat(80))

        DestinationData.destinations.forEachIndexed { index, dest ->
            println("%-5d %-20s £%-14.2f £%-14.2f %-10d".format(
                index + 1,
                dest.name,
                dest.singlePrice,
                dest.returnPrice,
                dest.sales
            ))
        }
        println("-".repeat(80))
    }
