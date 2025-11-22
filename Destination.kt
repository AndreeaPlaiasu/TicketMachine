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

data class User(
    val username: String,
    val password: String
)
