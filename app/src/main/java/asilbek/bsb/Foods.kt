package asilbek.bsb

data class Foods(
    val img: Int,
    val name: String,
    val weight: Int,
    val calories: Int,
    val location: String,
    val direction: Double,
    val price: Int
): java.io.Serializable