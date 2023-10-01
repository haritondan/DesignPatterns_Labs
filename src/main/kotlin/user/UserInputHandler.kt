package user

import models.Ingredient
import models.Recipe
import utils.RecipeBuilder
import interfaces.*

class UserInputHandler {
    fun promptForRecipeDetails(defaultRecipe: RecipeBuilder? = null): Recipe {
        println("Enter recipe details:")

        print("Title: ")
        val title = readLine().takeIf { it?.isNotEmpty() == true } ?: defaultRecipe?.title ?: ""

        print("Description: ")
        val description = readLine().takeIf { it?.isNotEmpty() == true } ?: defaultRecipe?.description ?: ""

        val recipeBuilder = RecipeBuilder()
        recipeBuilder.title(title)
        recipeBuilder.description(description)

        var ingredientName = ""
        while (ingredientName != "done") {
            print("Enter the name of an ingredient (or 'done' if there are no more ingredients): ")
            ingredientName = readLine() ?: ""
            if (ingredientName != "done") {
                print("Enter the quantity of the ingredient: ")
                val ingredientQuantity = readLine() ?: ""
                recipeBuilder.addIngredient(Ingredient(ingredientName, ingredientQuantity))
            }
        }

        var step = ""
        while (step != "done") {
            print("Enter a preparation step (or 'done' if there are no more steps): ")
            step = readLine() ?: ""
            if (step != "done") {
                recipeBuilder.addStep(step)
            }
        }

        return recipeBuilder.build()
    }

    fun promptForRecipeIndex(): Int? {
        println("Enter the number of the recipe:")
        return readLine()?.toIntOrNull()
    }

    fun promptForChoice(): Int {
        return readLine()?.toIntOrNull() ?: 0
    }
}

