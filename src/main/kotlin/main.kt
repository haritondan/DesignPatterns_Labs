import actions.AddRecipe
import actions.DeleteRecipe
import actions.EditRecipe
import actions.ViewAllRecipes
import managers.*
import models.Desert
import models.Ingredient
import models.Recipe
import user.UserInputHandler

fun main() {
    val recipeRepository = RecipeRepo()
    val recipeAdder = RecipeAddImpl(recipeRepository)
    val recipeViewer = RecipeViewImpl(recipeRepository)
    val recipeEditor = RecipeEditImpl(recipeRepository)
    val recipeDeleter = RecipeDelImpl(recipeRepository)
    val userInput = UserInputHandler()

    val spaghettiRecipe = Recipe(
        "Spaghetti Carbonara",
        "A classic Italian pasta dish with eggs, cheese, and pancetta.",
        mutableListOf(
            Ingredient("Spaghetti", "200g"),
            Ingredient("Eggs", "2"),
            Ingredient("Pancetta", "100g"),
            Ingredient("Parmesan Cheese", "50g")
        ),
        mutableListOf(
            "Boil spaghetti until al dente.",
            "In a separate pan, cook pancetta until crispy.",
            "Whisk eggs and grated Parmesan cheese together.",
            "Mix cooked spaghetti with pancetta and egg mixture.",
            "Serve immediately with extra Parmesan cheese."
        )
    )

    val chickenCurryRecipe = Recipe(
        "Chicken Curry",
        "A flavorful Indian chicken curry with spices and tomatoes.",
        mutableListOf(
            Ingredient("Chicken Thighs", "500g"),
            Ingredient("Onion", "1"),
            Ingredient("Tomatoes", "2"),
            Ingredient("Spices (e.g., cumin, coriander, chili powder)", "to taste")
        ),
        mutableListOf(
            "In a pan, sauté chopped onions until golden brown.",
            "Add spices and chopped tomatoes; cook until tomatoes soften.",
            "Add chicken and simmer until fully cooked.",
            "Serve with rice or naan."
        )

    )
    val pinacolad = Desert(
        "Pina colada",
        "A classic cold Dessert",
        mutableListOf(
            Ingredient("Sweet Things", "a lot"),
        ),
        mutableListOf(
            "Just do it"
        )
    )

    recipeAdder.addRecipe(spaghettiRecipe)
    recipeAdder.addRecipe(chickenCurryRecipe)
    recipeAdder.addRecipe(pinacolad)

    val actions = listOf(
        AddRecipe(recipeAdder, userInput),
        EditRecipe(recipeEditor, recipeViewer, userInput),
        DeleteRecipe(recipeDeleter, recipeViewer, userInput),
        ViewAllRecipes(recipeViewer, userInput)
    )

    val menuManager = MenuManager()
    val app = App(actions, menuManager, userInput)

    app.start()
}