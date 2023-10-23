package managers

import interfaces.RecipeViewer
import models.Recipe
import models.RecipeRepo

class RecipeViewImpl(private val recipeRepository: RecipeRepo) : RecipeViewer {
    override fun getAllRecipes(): List<Recipe> {
        return recipeRepository.recipes.toList()
    }
    override fun getRecipe(index: Int): Recipe? {
        return if (index in 0..<recipeRepository.recipes.size) {
            recipeRepository.recipes[index]
        } else {
            null
        }
    }
}