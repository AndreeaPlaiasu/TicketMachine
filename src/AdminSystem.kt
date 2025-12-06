class AdminSystem {

    fun displayMenu() {
        while (true) {
            println("\n=== Admin Panel ===")
            println("Origin station: ${DestinationData.ORIGIN_STATION}")
            println("1. View All Destinations")
            println("2. Add New Destination")
            println("3. Edit Existing Destination")
            println("4. Change All Ticket Prices (by factor)")
            println("5. Exit")
            print("Enter choice: ")

            when (readLine()?.toIntOrNull()) {
                1 -> viewAllDestinations()
                2 -> addDestination()
                3 -> editDestination()
                4 -> changeAllPrices()
                5 -> {
                    println("Exiting Admin Panel...")
                    return
                }
                else -> println("Invalid choice. Please try again.")
            }
        }
    }

    // d) view all destinations
    private fun viewAllDestinations() {
        println("\n=== All Destinations ===")
        println("-".repeat(80))
        println(
            "%-5s %-20s %-15s %-15s %-10s".format(
                "No.",
                "Station Name",
                "Single Price",
                "Return Price",
                "Sales"
            )
        )
        println("-".repeat(80))

        if (DestinationData.destinations.isEmpty()) {
            println("No destinations found.")
        } else {
            DestinationData.destinations.forEachIndexed { index, dest ->
                println(
                    "%-5d %-20s £%-14.2f £%-14.2f %-10d".format(
                        index + 1,
                        dest.name,
                        dest.singlePrice,
                        dest.returnPrice,
                        dest.sales
                    )
                )
            }
        }

        println("-".repeat(80))
    }

    // e) add a destination
    private fun addDestination() {
        println("\n=== Add New Destination ===")
        print("Enter destination name: ")
        val name = readLine()?.trim().orEmpty()
        if (name.isBlank()) {
            println("Name cannot be empty.")
            return
        }

        print("Enter single ticket price: ")
        val singlePrice = readLine()?.toDoubleOrNull()
        if (singlePrice == null || singlePrice <= 0) {
            println("Invalid single price.")
            return
        }

        print("Enter return ticket price: ")
        val returnPrice = readLine()?.toDoubleOrNull()
        if (returnPrice == null || returnPrice <= 0) {
            println("Invalid return price.")
            return
        }

        DestinationData.destinations.add(
            Destination(name, singlePrice, returnPrice)
        )
        println("Destination '$name' added successfully.")
    }

    // e) edit an existing destination
    private fun editDestination() {
        println("\n=== Edit Existing Destination ===")
        viewAllDestinations()

        if (DestinationData.destinations.isEmpty()) return

        print("Enter destination number to edit: ")
        val choice = readLine()?.toIntOrNull()

        if (choice == null || choice !in 1..DestinationData.destinations.size) {
            println("Invalid destination number.")
            return
        }

        val dest = DestinationData.destinations[choice - 1]
        println("Editing destination: ${dest.name}")

        print("Enter new single price (current: ${dest.singlePrice}, blank to keep): ")
        val newSingleInput = readLine()
        if (!newSingleInput.isNullOrBlank()) {
            val newSingle = newSingleInput.toDoubleOrNull()
            if (newSingle == null || newSingle <= 0) {
                println("Invalid single price. Change cancelled.")
                return
            }
            dest.singlePrice = newSingle
        }

        print("Enter new return price (current: ${dest.returnPrice}, blank to keep): ")
        val newReturnInput = readLine()
        if (!newReturnInput.isNullOrBlank()) {
            val newReturn = newReturnInput.toDoubleOrNull()
            if (newReturn == null || newReturn <= 0) {
                println("Invalid return price. Change cancelled.")
                return
            }
            dest.returnPrice = newReturn
        }

        println("Destination updated successfully.")
    }

    // f) change all prices by a factor (e.g. 1.1 or 0.9)
    private fun changeAllPrices() {
        println("\n=== Change All Ticket Prices ===")
        print("Enter factor to multiply prices by (e.g. 1.1 for +10%, 0.9 for -10%): ")
        val factor = readLine()?.toDoubleOrNull()

        if (factor == null || factor <= 0) {
            println("Invalid factor.")
            return
        }

        DestinationData.destinations.forEach { dest ->
            dest.singlePrice *= factor
            dest.returnPrice *= factor
        }

        println("All prices have been multiplied by $factor.")
    }
}
