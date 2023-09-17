import Category
import Ingredient

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
        println(steps)
    }




}