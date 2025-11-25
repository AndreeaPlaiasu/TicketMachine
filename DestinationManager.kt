class DestinationManager(initialDestinations: List<Destination>) {

    private val destinations = initialDestinations.toMutableList()

    fun getAllDestinations(): List<Destination> = destinations.toList()

    fun printAllDestinations() {

    }

    fun addDestination(name: String, singlePrice: Double, returnPrice: Double) {

    }

    fun findDestinationById(id: Int): Destination? =
        destinations.find { it.id == id }

    fun updateDestination(
        id: Int,
        newName: String? = null,
        newSinglePrice: Double? = null,
        newReturnPrice: Double? = null
    ): Boolean {

        return false
    }

    fun changeAllPricesByFactor(factor: Double) {

    }
}
