class Ingredient(
    val name: String,
    val quantity: String,
) {
    // Additional properties and methods can be added here

    override fun toString(): String {
        return "$quantity $name"
    }


}