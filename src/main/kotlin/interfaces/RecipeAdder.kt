package interfaces
import models.Recipe

interface RecipeAdder {
    fun addRecipe(recipe: Recipe)
}