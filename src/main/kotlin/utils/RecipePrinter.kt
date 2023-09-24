package utils

import models.Recipe

interface IRecipePrinter {
    fun printRecipe(recipe: Recipe)
}

class RecipePrinter : IRecipePrinter {
    override fun printRecipe(recipe: Recipe) {
        println("Title: ${recipe.title}")
        println("Description: ${recipe.description}")
        println("Ingredients List: ")
        for(item in recipe.ingredients){
            println("${item.quantity} ${item.name}")
        }
        println("Preparation Steps: ")
        for(item in recipe.steps){
            println(item)
        }
        println("Type: ${recipe.type}")
    }
}