package interfaces

import utils.IRecipePrinter

interface RecipeDecoratorInterface {
    fun displayRecipe(recipePrinter: IRecipePrinter)
}