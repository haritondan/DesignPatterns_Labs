package managers

import interfaces.RecipeDeleter
import models.Recipe


class RecipeDelImpl(private val recipeRepository: RecipeRepo): RecipeDeleter {
    override fun deleteRecipe(recipe: Recipe) {
        recipeRepository.recipes.remove(recipe)
    }
}