package managers

import models.Ingredient
import models.Recipe

interface RecipeAdder {
    fun addRecipe(recipe: Recipe)
}

interface RecipeEditor {
    fun editRecipe(oldRecipe: Recipe, newRecipe: Recipe)
}

interface RecipeDeleter {
    fun deleteRecipe(recipe: Recipe)
}

interface RecipeViewer {
    fun getAllRecipes(): List<Recipe>
    fun getRecipe(index: Int) : Recipe?
}

class RecipeOrganizer : RecipeAdder, RecipeEditor, RecipeDeleter, RecipeViewer {
    private val recipes: MutableList<Recipe> = mutableListOf()
    init {
        addPredefinedRecipes()
    }

    private fun addPredefinedRecipes() {
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

        addRecipe(spaghettiRecipe)
        addRecipe(chickenCurryRecipe)
    }

    override fun addRecipe(recipe: Recipe) {
        recipes.add(recipe)
    }

    override fun editRecipe(oldRecipe: Recipe, newRecipe: Recipe) {
        val index = recipes.indexOf(oldRecipe)
        if (index != -1) {
            recipes[index] = newRecipe
        }
    }

    override fun deleteRecipe(recipe: Recipe) {
        recipes.remove(recipe)
    }

    override fun getAllRecipes(): List<Recipe> {
        return recipes.toList()
    }
    override fun getRecipe(index: Int): Recipe? {
        return if (index in 0..<recipes.size) {
            recipes[index]
        } else {
            null
        }
    }
}
