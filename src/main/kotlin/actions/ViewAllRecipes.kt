package actions


import utils.RecipePrinter
import user.UserInputHandler
import interfaces.Action
import interfaces.RecipeViewer

class ViewAllRecipes(private val recipeViewer: RecipeViewer, private val userInput: UserInputHandler) : Action {


    override fun execute() {
        val allRecipes = recipeViewer.getAllRecipes()
        allRecipes.forEachIndexed { index, recipe ->
            println("${index + 1}. ${recipe.title}")
        }

        print("Would you like to view a specific recipe? (yes/no): ")
        val userResponse = readLine() ?: ""

        if (userResponse.toLowerCase() == "yes") {
            print("Enter the number of the recipe you want to view: ")
            val recipeNumber = readLine()?.toIntOrNull()
            if (recipeNumber != null && recipeNumber in 1..allRecipes.size) {
                val selectedRecipe = recipeViewer.getRecipe(recipeNumber - 1)
                val recipePrinter = RecipePrinter()
                if (selectedRecipe != null) {
                    recipePrinter.printRecipe(selectedRecipe)
                }
            } else {
                println("Invalid recipe number.")
            }
        }
    }
}