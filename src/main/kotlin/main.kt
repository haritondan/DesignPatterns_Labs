import actions.AddRecipe
import actions.DeleteRecipe
import actions.EditRecipe
import actions.ViewAllRecipes
import app.App
import app.AppFacade
import decorators.RatedRecipe
import managers.*
import models.Ingredient
import models.RecipeRepo
import user.UserInputHandler
import utils.ItalianRecipeFactory
import utils.MexicanRecipeFactory
import utils.RecipeBuilder
import utils.RecipePrinter

fun main() {
    val recipeRepository = RecipeRepo
    val recipeAdder = RecipeAddImpl(recipeRepository)
    val recipeViewer = RecipeViewImpl(recipeRepository)
    val recipeEditor = RecipeEditImpl(recipeRepository)
    val recipeDeleter = RecipeDelImpl(recipeRepository)
    val userInput = UserInputHandler()

    val spaghettiRecipe = RecipeBuilder()
        .title("Spaghetti Carbonara")
        .description("A classic Italian pasta dish with eggs, cheese, and pancetta.")
        .ingredients(mutableListOf(
            Ingredient("Spaghetti", "200g"),
            Ingredient("Eggs", "2"),
            Ingredient("Pancetta", "100g"),
            Ingredient("Parmesan Cheese", "50g")
        ))
        .steps(mutableListOf(
            "Boil spaghetti until al dente.",
            "In a separate pan, cook pancetta until crispy.",
            "Whisk eggs and grated Parmesan cheese together.",
            "Mix cooked spaghetti with pancetta and egg mixture.",
            "Serve immediately with extra Parmesan cheese."
        ))
        .build()


    val chickenCurryRecipe = RecipeBuilder()
        .title("Chicken Curry")
        .description("A flavorful Indian chicken curry with spices and tomatoes.")
        .ingredients(mutableListOf(
            Ingredient("Chicken Thighs", "500g"),
            Ingredient("Onion", "1"),
            Ingredient("Tomatoes", "2"),
            Ingredient("Spices (e.g., cumin, coriander, chili powder)", "to taste")
        ))
        .steps(mutableListOf(
            "In a pan, sauté chopped onions until golden brown.",
            "Add spices and chopped tomatoes; cook until tomatoes soften.",
            "Add chicken and simmer until fully cooked.",
            "Serve with rice or naan."
        ))
        .build()

    val chocoCake = RecipeBuilder()
        .title("Chocolate Cake")
        .type("Dessert")
        .build()

    recipeAdder.addRecipe(spaghettiRecipe)
    recipeAdder.addRecipe(chickenCurryRecipe)
    recipeAdder.addRecipe(chocoCake)

//Prototype
    val spaghettiRecipeTwo = spaghettiRecipe.clone()
    spaghettiRecipeTwo.title = "Spaghetti 2"
    recipeAdder.addRecipe(spaghettiRecipeTwo)

//Abstract Factory
    val italianFactory = ItalianRecipeFactory()
    val italianBuilder = RecipeBuilder()
    italianBuilder.title("Italian Pizza")
        .description("Delicious Italian Pizza")
        .addIngredient(Ingredient("Dough","2"))
        .addIngredient(Ingredient("Tomato","2"))
        .addIngredient(Ingredient("Cheese","2"))
        .type("Italian")
    val italianPizza = italianFactory.createRecipe(italianBuilder)
    italianPizza.cook() // Output: Cooking Italian Pizza

    val mexicanFactory = MexicanRecipeFactory()
    val mexicanBuilder = RecipeBuilder()
    mexicanBuilder.title("Mexican Taco")
        .description("Spicy Mexican Taco")
        .addIngredient(Ingredient("Tortilla","2"))
        .addIngredient(Ingredient("Beef","2"))
        .addIngredient(Ingredient("Cheese","2"))
        .type("Mexican")
    val mexicanTaco = mexicanFactory.createRecipe(mexicanBuilder)
    mexicanTaco.cook() // Output: Cooking Mexican Taco
    println("\n")


//Decorator Pattern
    println("Decorator Pattern")
    val ratedRecipe = RatedRecipe(chocoCake, 5)
    ratedRecipe.displayRecipe(RecipePrinter()) // This will display the recipe and its rating
    println("\n")


    val actions = listOf(
        AddRecipe(recipeAdder, userInput),
        EditRecipe(recipeEditor, recipeViewer, userInput),
        DeleteRecipe(recipeDeleter, recipeViewer, userInput),
        ViewAllRecipes(recipeViewer, userInput)
    )

    val menuManager = MenuManagerAdapter(MenuManager())
    val app = App(actions, menuManager, userInput)

    //Facade Pattern
    val appFacade = AppFacade(app)

    appFacade.start()
}