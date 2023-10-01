package actions


import user.UserInputHandler
import interfaces.Action
import interfaces.RecipeDeleter
import interfaces.RecipeViewer

class DeleteRecipe(private val recipeDeleter: RecipeDeleter, private val recipeViewer: RecipeViewer, private val userInput: UserInputHandler) : Action {


    override fun execute() {
        println("You have chosen to delete a recipe. Here are all the recipes:")

        val allRecipes = recipeViewer.getAllRecipes()
        allRecipes.forEachIndexed { index, recipe ->
            println("${index + 1}. ${recipe.title}")
        }

        val recipeIndex = userInput.promptForRecipeIndex()
        if (recipeIndex != null && recipeIndex in 1..allRecipes.size) {
            val recipe = allRecipes[recipeIndex - 1]
            recipeDeleter.deleteRecipe(recipe)
            println("The recipe has been successfully deleted.")
        } else {
            println("Invalid recipe number. Please try again.")
        }
    }
}