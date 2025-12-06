object DestinationService {

    // (d) Hard-coded destinations (NO DATABASE)
    private val destinations = mutableListOf(
        Destination("London", 35.50, 60.00, 120),
        Destination("Bournemouth", 12.20, 20.00, 80),
        Destination("Winchester", 8.00, 14.50, 55)
    )

    fun listDestinations() {
        println("=== All Destinations ===")
        for (d in destinations) {
            println(
                "• ${d.name} | Single £${"%.2f".format(d.singlePrice)} | " +
                        "Return £${"%.2f".format(d.returnPrice)} | Sales: ${d.salesCount}"
            )
        }
    }

    // (e) Add new destination
    fun addDestination(name: String, single: Double, ret: Double) {
        destinations.add(Destination(name, single, ret))
        println("Destination '$name' added.")
    }

    // (e) Edit destination
    fun editDestination(
        oldName: String,
        newName: String? = null,
        newSingle: Double? = null,
        newReturn: Double? = null
    ): Boolean {
        val dest = destinations.find { it.name.equals(oldName, ignoreCase = true) }
            ?: return false

        newName?.let { dest.name = it }
        newSingle?.let { dest.singlePrice = it }
        newReturn?.let { dest.returnPrice = it }

        return true
    }

    // (f) Change all prices by factor
    fun updatePricesByFactor(factor: Double) {
        for (d in destinations) {
            d.singlePrice *= factor
            d.returnPrice *= factor
        }
        println("All ticket prices updated by factor $factor.")
    }
}
