package utils

import interfaces.RecipeFactory
import models.ItalianRecipe
import models.MexicanRecipe
import models.Recipe


class ItalianRecipeFactory : RecipeFactory {
    override fun createRecipe(builder: RecipeBuilder): ItalianRecipe {
        val recipe = builder.build()
        return ItalianRecipe(
            recipe.title,
            recipe.description,
            recipe.ingredients,
            recipe.steps,
            recipe.type
        )
    }
}

class MexicanRecipeFactory : RecipeFactory {
    override fun createRecipe(builder: RecipeBuilder): MexicanRecipe {
        val recipe = builder.build()
        return MexicanRecipe(
            recipe.title,
            recipe.description,
            recipe.ingredients,
            recipe.steps,
            recipe.type
        )
    }
}

