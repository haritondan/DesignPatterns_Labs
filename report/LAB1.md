# Topic: *SOLID Principles*

Author: *Dan Hariton*
-----
## Objectives:
1. Study SOLID Principles
2. Choose a domain, define its main classes/models/entities and choose the appropriate instantiation mechanisms.
3. Create a sample project that respects SOLID Principles.

## Theory:
SOLID is a set of five object-oriented design principles intended to make software designs more maintainable, flexible, and easy to understand. The acronym stands for Single Responsibility Principle, Open-Closed Principle, Liskov Substitution Principle, Interface Segregation Principle, and Dependency Inversion Principle. Each principle addresses a specific aspect of software design, such as the organization of responsibilities, the handling of dependencies, and the design of interfaces. By following these principles, software developers can create more modular, testable, and reusable code that is easier to modify and extend over time. These principles are widely accepted and adopted in the software development community and can be applied to any object-oriented programming language.

## Main tasks:
&ensp; &ensp; __1. Choose an OO programming language and a suitable IDE or Editor (No frameworks/libs/engines allowed).__

&ensp; &ensp; __2. Select a domain area for the sample project.__

&ensp; &ensp; __3. Define the main involved classes and think about what instantiation mechanisms are needed.__

&ensp; &ensp; __4. Respect SOLID Principles in your project.__

# Implementation description:
## Project domain
- an recipe organiser

## SOLID Principles
- S - all classes have a single responsibility
- O - new methods can be added, without changing the models
- L - class Book is the parent of ChildBook, and it can substitute the parent class without problems
- I - class depends on the interface, which presumably includes the methods it needs and no others.
- D - class does not depend on any lower-level modules or concrete implementations
#### More detailed information in each file

## Code logic
main.kt
```kotlin
fun main() {
    val recipeOrganizer = RecipeOrganizer()
    val userInput = UserInputHandler()

    val actions = listOf(
        AddRecipe(recipeOrganizer, userInput),
        EditRecipe(recipeOrganizer, userInput),
        DeleteRecipe(recipeOrganizer, userInput),
        ViewAllRecipes(recipeOrganizer, userInput)
    )

    val menuManager = MenuManager()
    val app = App(actions, menuManager, userInput)
    app.start()
}
```
App.kt
```kotlin
class App(private val actions: List<interfaces.Action>, private val menuManager: MenuManager, private val userInput: UserInputHandler)
```
class App uses actions from the action package, the menu manager class and the user input class

RecipeOrganizer.kt
- These are the methods used in recipe organiser class and all the interfaces that implement specific functions
```kotlin
class RecipeOrganizer : RecipeAdder, RecipeEditor, RecipeDeleter, RecipeViewer 
```

UserInputHandler.kt takes care of the user's input

AddRecipe.kt
```kotlin
Interface interfaces.Action { fun execute() }
class AddRecipe(private val recipeOrganizer: RecipeOrganizer, private val userInput: UserInputHandler) : interfaces.Action {...}
}
```
Every action that a user can take is specified in a separate class, with makes it easily extendable for the Recipe Organizer



The model for the recipe class
```kotlin
open class Recipe (
    open val title: String,
    open val description: String,
    open val ingredients: MutableList<Ingredient>,
    open val steps: MutableList<String>,
    open val type: String = "No Type Specified"
)

```
# Results:
```
Welcome to the RecipexColl
1. Add Recipe
2. Edit Recipe
3. Delete modelsRecipe
4. View All Recipes
5. Exit
Enter your choice: 4
1. Spaghetti Carbonara
2. Chicken Curry
Would you like to view a specific recipe? (yes/no): yes
Enter the number of the recipe you want to view: 1
Title: Spaghetti Carbonara
Description: A classic Italian pasta dish with eggs, cheese, and pancetta.
Ingredients List: 
200g Spaghetti
2 Eggs
100g Pancetta
50g Parmesan Cheese
Preparation Steps: 
Boil spaghetti until al dente.
In a separate pan, cook pancetta until crispy.
Whisk eggs and grated Parmesan cheese together.
Mix cooked spaghetti with pancetta and egg mixture.
Serve immediately with extra Parmesan cheese.
Type: No Type Specified
```