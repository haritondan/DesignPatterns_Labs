package models

import interfaces.RecipeCook

class MexicanRecipe(
    override var title: String,
    override val description: String,
    override val ingredients: MutableList<AbstractIngredient>,
    override val steps: MutableList<String>,
    override val type: String = "Dessert"): Recipe(title, description, ingredients, steps),RecipeCook
{
    override fun cook() {
        println("Cooking Mexican Taco")
    }
}