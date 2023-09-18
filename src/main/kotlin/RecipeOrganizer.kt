import User
class RecipeOrganizer {
    private val recipes: MutableList<Recipe> = mutableListOf()
    private val categories: MutableList<Category> = mutableListOf()
    private val users: MutableSet<User> = mutableSetOf()
    private var currentUser: User? = null

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

    // Methods for managing users
    fun createUser(username: String, password: String): Boolean {
        val user = User(username, password)
        if (users.add(user)) {
            currentUser = user
            return true
        }
        return false
    }

    fun login(username: String, password: String): Boolean {
        val user = users.find { it.username == username && it.password == password }
        if (user != null) {
            currentUser = user
            return true
        }
        return false
    }

    fun logout() {
        currentUser = null
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
