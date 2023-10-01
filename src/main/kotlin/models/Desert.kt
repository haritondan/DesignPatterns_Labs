package models

class Desert(
    override val title: String,
    override val description: String,
    override val ingredients: MutableList<AbstractIngredient>,
    override val steps: MutableList<String>,
    override val type: String = "Dessert"): Recipe(title, description, ingredients, steps) {
    }