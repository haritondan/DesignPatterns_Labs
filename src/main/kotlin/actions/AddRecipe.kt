package actions

import managers.RecipeOrganizer
import user.UserInputHandler

interface Action {
    fun execute()
}

class AddRecipe(private val recipeOrganizer: RecipeOrganizer, private val userInput: UserInputHandler) : Action {
    override fun execute() {
        println("You have chosen to add a new recipe. Please follow the steps below:")

        println("Step 1: Enter the title of the recipe.")
        println("Step 2: Enter the description of the recipe.")
        println("Step 3: Enter the ingredients. For each ingredient, you will be asked to enter its name and quantity. When you are done adding ingredients, type 'done'.")
        println("Step 4: Enter the preparation steps. For each step, you will be asked to enter the step description. When you are done adding steps, type 'done'.")

        val recipe = userInput.promptForRecipeDetails()
        recipeOrganizer.addRecipe(recipe)

        println("The recipe has been successfully added.")
    }
}