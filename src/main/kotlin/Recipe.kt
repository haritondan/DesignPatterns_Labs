class Recipe(
    val title: String,
    val description: String,
    val ingredients: MutableList<Ingredient>,
    val steps: MutableList<String>,
    val category: Category
) {

    override fun toString(): String {
        return "$title - $category"
    }

    fun printSteps() {
        for (step in steps) {
            println(step)
        }
    }

    fun printIngreients() {
        for (item in ingredients) {
            println(item)
        }
    }



}