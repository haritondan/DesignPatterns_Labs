package interfaces
import models.Recipe

interface RecipeDeleter {
    fun deleteRecipe(recipe: Recipe)
}