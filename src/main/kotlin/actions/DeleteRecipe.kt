package actions

import managers.RecipeOrganizer
import user.UserInputHandler

class DeleteRecipe(private val recipeOrganizer: RecipeOrganizer, private val userInput: UserInputHandler) : Action {


    override fun execute() {
        println("You have chosen to delete a recipe. Here are all the recipes:")

        val allRecipes = recipeOrganizer.getAllRecipes()
        allRecipes.forEachIndexed { index, recipe ->
            println("${index + 1}. ${recipe.title}")
        }

        val recipeIndex = userInput.promptForRecipeIndex()
        if (recipeIndex != null && recipeIndex in 1..allRecipes.size) {
            val recipe = allRecipes[recipeIndex - 1]
            recipeOrganizer.deleteRecipe(recipe)
            println("The recipe has been successfully deleted.")
        } else {
            println("Invalid recipe number. Please try again.")
        }
    }
}