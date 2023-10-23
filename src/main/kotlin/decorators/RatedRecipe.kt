package decorators

import interfaces.RecipeDecoratorInterface
import utils.IRecipePrinter

class RatedRecipe(decoratedRecipe: RecipeDecoratorInterface, private val rating: Int) : RecipeDecorator(decoratedRecipe) {
    override fun displayRecipe(recipePrinter: IRecipePrinter) {
        super.displayRecipe(recipePrinter)
        println("Rating: $rating")
    }

}