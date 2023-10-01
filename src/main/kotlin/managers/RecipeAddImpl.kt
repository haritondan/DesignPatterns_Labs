package managers

import interfaces.RecipeAdder
import models.Recipe

class RecipeAddImpl(private val recipeRepository: RecipeRepo) : RecipeAdder {

    override fun addRecipe(recipe: Recipe) {
        recipeRepository.recipes.add(recipe)
    }
}