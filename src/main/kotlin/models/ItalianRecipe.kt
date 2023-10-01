package models

import interfaces.RecipeCook

class ItalianRecipe(
    override var title: String,
    override val description: String,
    override val ingredients: MutableList<AbstractIngredient>,
    override val steps: MutableList<String>,
    override val type: String = "Italian"): Recipe(title, description, ingredients, steps), RecipeCook
{
    override fun cook() {
        println("Cooking Italian Pizza")
    }
}