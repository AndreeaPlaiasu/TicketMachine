import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    while (true) {
        println("\n=== MEMBER B – ADMIN MENU ===")
        println("1. View all destinations")
        println("2. Add destination")
        println("3. Edit destination")
        println("4. Change ALL ticket prices by factor")
        println("5. Exit")
        print("Choose option: ")

        when (scanner.nextLine().trim()) {

            "1" -> DestinationService.listDestinations()

            "2" -> {
                print("Station name: ")
                val name = scanner.nextLine()

                print("Single price: ")
                val single = scanner.nextLine().toDoubleOrNull()
                if (single == null) { println("Invalid price."); continue }

                print("Return price: ")
                val ret = scanner.nextLine().toDoubleOrNull()
                if (ret == null) { println("Invalid price."); continue }

                DestinationService.addDestination(name, single, ret)
            }

            "3" -> {
                print("Enter station to edit: ")
                val old = scanner.nextLine()

                print("New name (leave blank to keep): ")
                val newName = scanner.nextLine().ifBlank { null }

                print("New single price (leave blank to keep): ")
                val s = scanner.nextLine()
                val newSingle = if (s.isBlank()) null else s.toDoubleOrNull()

                print("New return price (leave blank to keep): ")
                val r = scanner.nextLine()
                val newReturn = if (r.isBlank()) null else r.toDoubleOrNull()

                if (DestinationService.editDestination(old, newName, newSingle, newReturn))
                    println("Destination updated.")
                else
                    println("Destination not found.")
            }

            "4" -> {
                print("Enter factor (e.g., 1.1 or 0.8): ")
                val factor = scanner.nextLine().toDoubleOrNull()
                if (factor == null) {
                    println("Invalid factor.")
                    continue
                }
                DestinationService.updatePricesByFactor(factor)
            }

            "5" -> {
                println("Exiting Member B module.")
                return
            }

            else -> println("Invalid choice.")
        }
    }
}
