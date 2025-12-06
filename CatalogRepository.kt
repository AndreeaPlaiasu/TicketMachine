package ticketmachine

data class Station(
    val id: Int,
    val name: String,
    var singlePricePence: Int,
    var returnPricePence: Int,
    var salesCount: Int = 0,
    var takingsPence: Int = 0
)

class CatalogRepository {
    val stations = mutableListOf(
        Station(1, "London", 1500, 2700),
        Station(2, "Southampton", 1200, 2100),
        Station(3, "Brighton", 900, 1600),
        Station(4, "Portsmouth", 1000, 1800)
    )

    fun recordSale(stationId: Int, pricePence: Int) {
        val station = stations.find { it.id == stationId }
        station?.let {
            it.salesCount++
            it.takingsPence += pricePence
        }
    }
}