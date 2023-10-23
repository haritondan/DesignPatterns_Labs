package models
import interfaces.Clone
import interfaces.RecipeCook
import interfaces.RecipeDecoratorInterface
import utils.IRecipePrinter

open class Recipe (
    open var title: String,
    open val description: String,
    open val ingredients: MutableList<AbstractIngredient>,
    open val steps: MutableList<String>,
    open val type: String = "No Type Specified"
    ):Clone, RecipeCook, RecipeDecoratorInterface {

    override fun clone(): Recipe {
        return Recipe(title,description, ingredients, steps, type)
    }

    override fun cook() {
        println("Cooking")
    }

    override fun displayRecipe(recipePrinter: IRecipePrinter) {
        recipePrinter.printRecipe(this)
    }

}
