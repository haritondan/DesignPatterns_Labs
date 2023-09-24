import actions.AddRecipe
import actions.DeleteRecipe
import actions.EditRecipe
import actions.ViewAllRecipes
import managers.MenuManager
import managers.RecipeOrganizer
import user.UserInputHandler

fun main() {
    val recipeOrganizer = RecipeOrganizer()
    val userInput = UserInputHandler()

    val actions = listOf(
        AddRecipe(recipeOrganizer, userInput),
        EditRecipe(recipeOrganizer, userInput),
        DeleteRecipe(recipeOrganizer, userInput),
        ViewAllRecipes(recipeOrganizer, userInput)
    )

    val menuManager = MenuManager()
    val app = App(actions, menuManager, userInput)

    app.start()
}