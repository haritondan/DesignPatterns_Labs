package interfaces

import models.Recipe
import utils.RecipeBuilder

interface RecipeFactory {
    fun createRecipe(builder: RecipeBuilder): Recipe
}