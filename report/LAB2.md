# Topic: *Creational Design Patterns*

Author: *Dan Hariton*
-----
## Objectives:
1. Study and understand the Creational Design Patterns.
2. Choose a domain, define its main classes/models/entities and choose the appropriate instantiation mechanisms.
3.  Use some creational design patterns for object instantiation in a sample project.

## Theory:
Creational design patterns are a category of design patterns that focus on the process of object 
creation. They provide a way to create objects in a flexible and controlled manner, while decoupling 
the client code from the specifics of object creation. Creational design patterns address common 
problems encountered in object creation, such as how to create objects with different initialization
parameters, how to create objects based on certain conditions, or how to ensure that only a single 
instance of an object is created. There are several creational design patterns that have their own 
strengths and weaknesses. Each of it is best suited for solving specific problems related to object
creation. By using creational design patterns, developers can improve the flexibility, 
maintainability, and scalability of their code.
## Main tasks:
&ensp; &ensp; __1. Choose an OO programming language and a suitable IDE or Editor (No frameworks/libs/engines allowed).__

&ensp; &ensp; __2. Select a domain area for the sample project.__

&ensp; &ensp; __3. Define the main involved classes and think about what instantiation mechanisms are needed.__

&ensp; &ensp; __4. Based on the previous point, implement at least 2 creational design patterns in your project..__

# Implementation description:
## Project domain
- an recipe organiser

## SOLID Principles
- Builder Pattern: This pattern is used when there is a need to construct a complex object step by step. It separates the construction of an object from its representation, providing the same construction process for different types of objects. For instance, if you're creating a complex game character with various attributes, the Builder pattern would be ideal.

- Singleton Pattern: This pattern ensures that a class has only one instance and provides a global point of access to it. It's useful when exactly one object is needed to coordinate actions across the system. For example, if you're managing access to a shared resource, like a printer or a file, the Singleton pattern would be beneficial.

- Prototype Pattern: This pattern is used when the type of objects to create is determined by a prototypical instance, which is cloned to produce new objects. If your project involves creating multiple objects with similar state or identical to an existing instance, the Prototype pattern can be effective.

- Abstract Factory Pattern: This pattern provides an interface for creating families of related or dependent objects without specifying their concrete classes. If your project requires creating a suite of products or requires a system to be independent from how its products are created, composed, and represented, the Abstract Factory pattern would be suitable.


## Code logic
### Builder Pattern
This is the Builder Pattern, helps us create the recipe without imposing us to use every parameter, and 
it helps us when we have so many parameters like in the class Recipe.kt
- RecipeBuilder.kt
```kotlin
class RecipeBuilder {
    var title: String = ""
    var description: String = ""
    var ingredients: MutableList<AbstractIngredient> = mutableListOf()
    var steps: MutableList<String> = mutableListOf()
    var type: String = "No Type Specified"

    fun title(title: String) = apply { this.title = title }
    fun description(description: String) = apply { this.description = description }
    fun ingredients(ingredients: MutableList<AbstractIngredient>) = apply { this.ingredients = ingredients }
    fun steps(steps: MutableList<String>) = apply { this.steps = steps }
    fun type(type: String) = apply { this.type = type }

    fun addIngredient(ingredient: Ingredient) = apply { this.ingredients.add(ingredient) }
    fun addStep(step: String) = apply { this.steps.add(step) }

    fun build(): Recipe {
        return Recipe(title, description, ingredients, steps, type)
    }
}
```

### Singleton Pattern
This is the Singleton pattern. We have just only one list of recipes, globally accessible therefore the singleton
provides us with only on instantiation of this class.
- RecipeRepo.kt
```kotlin
object RecipeRepo {
    val recipes: MutableList<Recipe> = mutableListOf()
}
```
### Prototype Pattern
This is the Prototype pattern, we use this to clone our recipes. In case a user want to change just the title, a certain step
then he can just clone the recipe, without adding a new whole one.
- Recipe.kt
```kotlin
override fun clone(): Recipe {
    return Recipe(title,description, ingredients, steps, type) 
}   
```
### Abstract Factory Pattern
This is the Abstract Factory pattern, using the RecipeFactory interface we can create multiple factories 
for different kinds of food
- AbstractFactory.kt
```kotlin
interface RecipeFactory {
    fun createRecipe(builder: RecipeBuilder): Recipe
}
class ItalianRecipeFactory : RecipeFactory {
    override fun createRecipe(builder: RecipeBuilder): ItalianRecipe {
        val recipe = builder.build()
        return ItalianRecipe(
            recipe.title,
            recipe.description,
            recipe.ingredients,
            recipe.steps,
            recipe.type
        )
    }
}
```


# Conclusion:

Implementing the Builder, Singleton, Prototype, and Abstract Factory design patterns has been an enlightening journey. Each pattern has offered unique advantages, but also posed its own challenges.

The Builder pattern has allowed for the creation of complex objects in a step-by-step, controlled manner, enhancing the readability and maintainability of the code. However, it required careful planning and design to ensure that all components fit together seamlessly.

The Singleton pattern has been beneficial in managing global access to a single instance, ensuring consistency across the system. Yet, it's been critical to be mindful of potential issues with multithreading and to ensure that the single instance doesn't become a bottleneck.

The Prototype pattern has facilitated the creation of new objects by cloning existing ones, saving resources and time. The challenge has been in managing deep versus shallow copies and understanding the implications of each.

Lastly, the Abstract Factory pattern has been invaluable in creating families of related objects, providing a high level of abstraction. The trade-off has been the increased complexity in the system's structure, which required diligent management.

Overall, these patterns have significantly improved the structure and efficiency of the code, promoting reusability and modularity. The key has been to understand the trade-offs involved and to apply each pattern where it adds the most value.
