package managers

import interfaces.RecipeDeleter
import models.Recipe
import models.RecipeRepo


class RecipeDelImpl(private val recipeRepository: RecipeRepo): RecipeDeleter {
    override fun deleteRecipe(recipe: Recipe) {
        recipeRepository.recipes.remove(recipe)
    }
}