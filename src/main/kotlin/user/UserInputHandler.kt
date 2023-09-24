package user

import models.Ingredient
import models.Recipe

class UserInputHandler {
    fun promptForRecipeDetails(defaultRecipe: Recipe? = null): Recipe {
        println("Enter recipe details:")

        print("Title: ")
        val title = readLine().takeIf { it?.isNotEmpty() == true } ?: defaultRecipe?.title ?: ""

        print("Description: ")
        val description = readLine().takeIf { it?.isNotEmpty() == true } ?: defaultRecipe?.description ?: ""

        val ingredients = defaultRecipe?.ingredients?.toMutableList() ?: mutableListOf()
        var ingredientName = ""
        while (ingredientName != "done") {
            print("Enter the name of an ingredient (or 'done' if there are no more ingredients): ")
            ingredientName = readLine() ?: ""
            if (ingredientName != "done") {
                print("Enter the quantity of the ingredient: ")
                val ingredientQuantity = readLine() ?: ""
                ingredients.add(Ingredient(ingredientName, ingredientQuantity))
            }
        }

        val steps = defaultRecipe?.steps?.toMutableList() ?: mutableListOf()
        var step = ""
        while (step != "done") {
            print("Enter a preparation step (or 'done' if there are no more steps): ")
            step = readLine() ?: ""
            if (step != "done") {
                steps.add(step)
            }
        }

        return Recipe(title, description, ingredients, steps)
    }

    fun promptForRecipeIndex(): Int? {
        println("Enter the number of the recipe:")
        return readLine()?.toIntOrNull()
    }

    fun promptForChoice(): Int {
        return readLine()?.toIntOrNull() ?: 0
    }
}

