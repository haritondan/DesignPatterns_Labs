fun main() {
    val recipeOrganizer = RecipeOrganizer()
    val italianCategory = Category("Italian")
    val indianCategory = Category("Indian")

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
        ),
        italianCategory
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
        ),
        indianCategory
    )

    recipeOrganizer.addRecipe(spaghettiRecipe)
    recipeOrganizer.addRecipe(chickenCurryRecipe)
    recipeOrganizer.addCategory(italianCategory)
    recipeOrganizer.addCategory(indianCategory)

    when (readLine()?.toIntOrNull()) {
        1 -> {
            // Create User
            print("Enter username: ")
            val username = readLine() ?: ""
            print("Enter password: ")
            val password = readLine() ?: ""

            if (recipeOrganizer.createUser(username, password)) {
                println("User created and logged in.")
                while (true) {
                    println("1. Add Recipe")
                    println("2. Edit Recipe")
                    println("3. Delete Recipe")
                    println("4. View All Recipes")
                    println("5. Exit")
                    print("Enter your choice: ")

                    when (readlnOrNull()?.toIntOrNull()) {
                        1 -> {
                            recipeOrganizer.addRecipe(
                                Recipe(
                                    readln(),
                                    readln(),
                                    mutableListOf(),
                                    mutableListOf(readln(), readln()),
                                    when(readln().toIntOrNull()) {
                                        1 -> {italianCategory}
                                        else -> {indianCategory}
                                    }
                                )
                            )

                        }
                        2 -> {
                            // Edit a recipe

                            // Display a list of recipes for the user to choose from
                            println("Recipes:")
                            val allRecipes = recipeOrganizer.getAllRecipes()
                            allRecipes.forEachIndexed { index, recipe ->
                                println("${index + 1}. ${recipe.title}")
                            }

                            print("Enter the number of the recipe you want to edit: ")
                            val recipeIndexToEdit = readLine()?.toIntOrNull()

                            if (recipeIndexToEdit != null && recipeIndexToEdit >= 1 && recipeIndexToEdit <= allRecipes.size) {
                                val recipeToEdit = allRecipes[recipeIndexToEdit - 1]

                                // Prompt the user for new details
                                print("Enter new title (or press Enter to keep it as '${recipeToEdit.title}'): ")
                                val newTitle = readLine() ?: recipeToEdit.title

                                print("Enter new description (or press Enter to keep it as '${recipeToEdit.description}'): ")
                                val newDescription = readLine() ?: recipeToEdit.description

                                // You can similarly prompt for new details for ingredients, steps, and category
                                print("Enter new ingredients (or press Enter to keep it as '${recipeToEdit.ingredients}'): ")
                                val newIngredients = mutableListOf() ?: recipeToEdit.ingredients


                                // Create a new Recipe with the updated details
                                val editedRecipe = Recipe(
                                    newTitle,
                                    newDescription,
                                    /* new ingredients, steps, and category */
                                    newIngredients,
                                    mutableListOf(readln(), readln()),
                                    when(readln().toIntOrNull()) {
                                        1 -> {italianCategory}
                                        else -> {indianCategory}
                                    }
                                )

                                // Update the recipe in the organizer
                                recipeOrganizer.editRecipe(recipeToEdit, editedRecipe)
                                println("Recipe edited successfully!")
                            } else {
                                println("Invalid recipe number. Please try again.")
                            }

                        }
                        3 -> {
                            // Delete a recipe
                            // Prompt the user for the recipe to delete and use recipeOrganizer.deleteRecipe()
                        }
                        4 -> {
                            // View recipes
                            // Display recipes based on user preferences (e.g., by category)
                            println("Recipes:")
                            val allRecipes = recipeOrganizer.getAllRecipes()
                            allRecipes.forEachIndexed { index, recipe ->
                                println("${index + 1}. ${recipe.title}")
                            }
                            print("Enter the number of the recipe you want to view: ")
                            val recipeIndexToView = readLine()?.toIntOrNull()

                            if (recipeIndexToView != null && recipeIndexToView >= 1 && recipeIndexToView <= allRecipes.size) {
                                val recipeToView = allRecipes[recipeIndexToView - 1]

                                println(recipeToView.title + "\n" + recipeToView.description)
                                println("\nIngredients: ")
                                recipeToView.printIngreients()
                                println("\nPreparation Steps: ")
                                recipeToView.printSteps()


                            } else {
                                println("Invalid recipe number. Please try again.")
                            }
                        }
                        5 -> {
                            // Exit the program
                            return
                        }
                        else -> println("Invalid choice. Please try again.")
                    }
                }
            } else {
                println("Username already exists. Try a different one.")
            }
        }
        2 -> {
            // Log In
            print("Enter username: ")
            val username = readLine() ?: ""
            print("Enter password: ")
            val password = readLine() ?: ""

            if (recipeOrganizer.login(username, password)) {
                println("Logged in as $username.")
                while (true) {
                    println("1. Add Recipe")
                    println("2. Edit Recipe")
                    println("3. Delete Recipe")
                    println("4. View All Recipes")
                    println("5. Exit")
                    print("Enter your choice: ")

                    when (readlnOrNull()?.toIntOrNull()) {
                        1 -> {
                            recipeOrganizer.addRecipe(
                                Recipe(
                                    readln(),
                                    readln(),
                                    mutableListOf(),
                                    mutableListOf(readln(), readln()),
                                    when(readln().toIntOrNull()) {
                                        1 -> {italianCategory}
                                        else -> {indianCategory}
                                    }
                                )
                            )

                        }
                        2 -> {
                            // Edit a recipe

                            // Display a list of recipes for the user to choose from
                            println("Recipes:")
                            val allRecipes = recipeOrganizer.getAllRecipes()
                            allRecipes.forEachIndexed { index, recipe ->
                                println("${index + 1}. ${recipe.title}")
                            }

                            print("Enter the number of the recipe you want to edit: ")
                            val recipeIndexToEdit = readLine()?.toIntOrNull()

                            if (recipeIndexToEdit != null && recipeIndexToEdit >= 1 && recipeIndexToEdit <= allRecipes.size) {
                                val recipeToEdit = allRecipes[recipeIndexToEdit - 1]

                                // Prompt the user for new details
                                print("Enter new title (or press Enter to keep it as '${recipeToEdit.title}'): ")
                                val newTitle = readLine() ?: recipeToEdit.title

                                print("Enter new description (or press Enter to keep it as '${recipeToEdit.description}'): ")
                                val newDescription = readLine() ?: recipeToEdit.description

                                // You can similarly prompt for new details for ingredients, steps, and category
                                print("Enter new ingredients (or press Enter to keep it as '${recipeToEdit.ingredients}'): ")
                                val newIngredients = mutableListOf() ?: recipeToEdit.ingredients


                                // Create a new Recipe with the updated details
                                val editedRecipe = Recipe(
                                    newTitle,
                                    newDescription,
                                    /* new ingredients, steps, and category */
                                    newIngredients,
                                    mutableListOf(readln(), readln()),
                                    when(readln().toIntOrNull()) {
                                        1 -> {italianCategory}
                                        else -> {indianCategory}
                                    }
                                )

                                // Update the recipe in the organizer
                                recipeOrganizer.editRecipe(recipeToEdit, editedRecipe)
                                println("Recipe edited successfully!")
                            } else {
                                println("Invalid recipe number. Please try again.")
                            }

                        }
                        3 -> {
                            // Delete a recipe
                            // Prompt the user for the recipe to delete and use recipeOrganizer.deleteRecipe()
                        }
                        4 -> {
                            // View recipes
                            // Display recipes based on user preferences (e.g., by category)
                            println("Recipes:")
                            val allRecipes = recipeOrganizer.getAllRecipes()
                            allRecipes.forEachIndexed { index, recipe ->
                                println("${index + 1}. ${recipe.title}")
                            }
                            print("Enter the number of the recipe you want to view: ")
                            val recipeIndexToView = readLine()?.toIntOrNull()

                            if (recipeIndexToView != null && recipeIndexToView >= 1 && recipeIndexToView <= allRecipes.size) {
                                val recipeToView = allRecipes[recipeIndexToView - 1]

                                println(recipeToView.title + "\n" + recipeToView.ingredients.toString() + "\n" + recipeToView.description + "\n" + recipeToView.steps.toString() + "\n" + recipeToView.category)

                            } else {
                                println("Invalid recipe number. Please try again.")
                            }
                        }
                        5 -> {
                            // Exit the program
                            return
                        }
                        else -> println("Invalid choice. Please try again.")
                    }
                }
            } else {
                println("Invalid username or password.")
            }
        }
        3 -> {
            // Log Out
            recipeOrganizer.logout()
            println("Logged out.")
        }
        // ... (other menu options)
    }


}