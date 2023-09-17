class RecipeOrganizer {
    private val recipes: MutableList<Recipe> = mutableListOf()
    private val categories: MutableList<Category> = mutableListOf()

    // Methods for managing recipes
    fun addRecipe(recipe: Recipe) {
        recipes.add(recipe)
    }

    fun editRecipe(oldRecipe: Recipe, newRecipe: Recipe) {
        val index = recipes.indexOf(oldRecipe)
        if (index != -1) {
            recipes[index] = newRecipe
        }
    }

    fun deleteRecipe(recipe: Recipe) {
        recipes.remove(recipe)
    }

    fun getAllRecipes(): List<Recipe> {
        return recipes.toList()
    }
    fun addCategory(category: Category) {
        categories.add(category)
    }
/*
    // Methods for managing categories
    fun addCategory(category: Category) {
        categories.add(category)
    }

    fun getRecipesByCategory(category: Category): List<Recipe> {
        return recipes.filter { it.category == category.name }
    }

    fun getAllRecipes(): List<Recipe> {
        return recipes.toList()
    }*/

    // Additional methods can be added for searching, sorting, etc.

}
