package decorators

import interfaces.RecipeDecoratorInterface
import utils.IRecipePrinter

open class RecipeDecorator(private val decoratedRecipe: RecipeDecoratorInterface) : RecipeDecoratorInterface {
    override fun displayRecipe(recipePrinter: IRecipePrinter) {
        decoratedRecipe.displayRecipe(recipePrinter)
    }
}