package managers

import models.Menu
import models.MenuItem

class MenuManager {
    private val menu = Menu("Welcome to the RecipexColl").apply {
        add(MenuItem("Add Recipe", 1))
        add(MenuItem("Edit Recipe", 2))
        add(MenuItem("Delete Recipe", 3))
        add(MenuItem("View All Recipes", 4))
        add(MenuItem("Exit", 5))
    }

    fun displayMenu() {
        println(menu.display())
        print("Enter your choice: ")
    }
}