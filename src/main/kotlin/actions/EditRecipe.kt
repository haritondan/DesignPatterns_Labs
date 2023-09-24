package actions

import managers.RecipeOrganizer
import user.UserInputHandler

class EditRecipe(private val recipeOrganizer: RecipeOrganizer, private val userInput: UserInputHandler) : Action {


    override fun execute() {
        println("You have chosen to edit an existing recipe. Please follow the steps below:")

        println("Step 1: Enter the number of the recipe you want to edit.")
        println("Step 2: Enter the new title of the recipe (or press Enter to keep the current title).")
        println("Step 3: Enter the new description of the recipe (or press Enter to keep the current description).")
        println("Step 4: Enter the new ingredients. For each ingredient, you will be asked to enter its name and quantity. When you are done adding ingredients, type 'done'.")
        println("Step 5: Enter the new preparation steps. For each step, you will be asked to enter the step description. When you are done adding steps, type 'done'.")

        val recipeIndex = userInput.promptForRecipeIndex()
        if (recipeIndex != null) {
            val oldRecipe = recipeOrganizer.getAllRecipes()[recipeIndex - 1]
            val newRecipe = userInput.promptForRecipeDetails(oldRecipe)
            recipeOrganizer.editRecipe(oldRecipe, newRecipe)

            println("The recipe has been successfully edited.")
        } else {
            println("Invalid recipe number. Please try again.")
        }
    }
}