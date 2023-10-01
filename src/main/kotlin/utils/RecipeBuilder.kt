package utils

import models.AbstractIngredient
import models.Ingredient
import models.Recipe

class RecipeBuilder {
    var title: String = ""
    var description: String = ""
    var ingredients: MutableList<AbstractIngredient> = mutableListOf()
    var steps: MutableList<String> = mutableListOf()
    var type: String = "No Type Specified"

    fun title(title: String) = apply { this.title = title }
    fun description(description: String) = apply { this.description = description }
    fun ingredients(ingredients: MutableList<AbstractIngredient>) = apply { this.ingredients = ingredients }
    fun steps(steps: MutableList<String>) = apply { this.steps = steps }
    fun type(type: String) = apply { this.type = type }

    fun addIngredient(ingredient: Ingredient) = apply { this.ingredients.add(ingredient) }
    fun addStep(step: String) = apply { this.steps.add(step) }

    fun build(): Recipe {
        return Recipe(title, description, ingredients, steps, type)
    }
}