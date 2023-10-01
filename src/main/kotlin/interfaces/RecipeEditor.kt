package interfaces
import models.Recipe

interface RecipeEditor {
    fun editRecipe(oldRecipe: Recipe, newRecipe: Recipe)
}