package managers

import interfaces.RecipeEditor
import models.Recipe
import models.RecipeRepo

class RecipeEditImpl(private val recipeRepository: RecipeRepo): RecipeEditor {

    override fun editRecipe(oldRecipe: Recipe, newRecipe: Recipe) {
        val index = recipeRepository.recipes.indexOf(oldRecipe)
        if (index != -1) {
            recipeRepository.recipes[index] = newRecipe
        }
    }
}