package interfaces
import models.Recipe

interface RecipeViewer {
    fun getAllRecipes(): List<Recipe>
    fun getRecipe(index: Int) : Recipe?
}