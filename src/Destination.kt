data class Destination(
    val name: String,
    var singlePrice: Double,
    var returnPrice: Double,
    var sales: Int = 0
)

    val singlePrice: Double,
    val returnPrice: Double,
    var salesCount: Int = 0
) {
    fun increaseSales() {
        salesCount++
    }
}

data class User(
    val username: String,
    val password: String
)

data class SpecialOffer(
    val id: Int,
    val station: String,
    val discount: Double,
    val start: String,
    val end: String
)
data class Destination(
    val name: String,
    val singlePrice: Double,
    val returnPrice: Double,
    var salesCount: Int = 0
) {
    fun increaseSales() {
        salesCount++
    }
}
