# Topic: *Structural Design Patterns*

Author: *Dan Hariton*
------
## Objectives:
1. Study and understand the Structural Design Patterns.
2. As a continuation of the previous laboratory work, think about the functionalities that your system will need to provide to the user.
3. Implement some additional functionalities, or create a new project using structural design patterns.

## Theoretical background:
Structural design patterns are a category of design patterns that focus on the composition of classes and objects to form larger structures and systems. They provide a way to organize objects and classes in a way that is both flexible and efficient, while allowing for the reuse and modification of existing code. Structural design patterns address common problems encountered in the composition of classes and objects, such as how to create new objects that inherit functionality from existing objects, how to create objects that share functionality without duplicating code, or how to define relationships between objects in a flexible and extensible way.


## Main tasks:
&ensp; &ensp; __1. Choose an OO programming language and a suitable IDE or Editor (No frameworks/libs/engines allowed).__

&ensp; &ensp; __2. Select a domain area for the sample project.__

&ensp; &ensp; __3. Define the main involved classes and think about what instantiation mechanisms are needed.__

&ensp; &ensp; __4. Based on the previous point, implement at least 2 structural design patterns in your project.__

# Implementation description:
## Project domain
- an recipe organiser

## Design Patterns
- Adapter Pattern: This pattern acts as a bridge between two incompatible interfaces. It's useful when you want to use an existing class, but its interface doesn't match the one you need.

- Facade Pattern: This pattern provides a simplified interface to a complex subsystem. It's useful when a system is complex or difficult to understand because it has a lot of dependencies.

- Decorator Pattern: This pattern allows behavior to be added to an individual object, either statically or dynamically, without affecting the behavior of other objects from the same class. It's useful when you want to add responsibilities to objects without extending their classes.

- Composite Pattern: This pattern composes objects into tree structures to represent part-whole hierarchies. It's useful when you want to treat individual objects and compositions of objects uniformly.


## Code logic
### Adapter Pattern
In our recipe app, we created a MenuManagerAdapter to adapt the MenuManager class to the MenuDisplay interface. This allowed MenuManager to be used wherever a MenuDisplay was expected, without modifying the MenuManager class.
- MenuManagerAdapter.kt
```kotlin
class MenuManagerAdapter(private val menuManager: MenuManager) : MenuDisplay {
  override fun display() {
    menuManager.displayMenu()
  }
}
```
### Facade Pattern
In our recipe app, we used the AppFacade to simplify the interaction with the App class. This hid the complexity of the underlying system (the list of actions, the menu manager, and the user input handler) and provided a simpler interface to start the application.
- AppFacade.kt
```kotlin
class AppFacade(private val app: App) {
    fun start() {
        app.start()
    }
}
```

### Decorator Pattern
In our recipe app, we use this pattern to add additional features to your recipes, like rating (or maybe more in the future, like categories), without modifying the Recipe class.
- RatedRecipe.kt
```kotlin
class RatedRecipe(decoratedRecipe: RecipeDecoratorInterface, private val rating: Int) : RecipeDecorator(decoratedRecipe) {
  override fun displayRecipe(recipePrinter: IRecipePrinter) {
    super.displayRecipe(recipePrinter)
    println("Rating: $rating")
  }
}
```

### Composite Pattern
In our recipe app, we used this pattern to rebuild the menu. The Menu class, which is a composite of MenuItem objects, can be treated uniformly as a MenuComponent, allowing us to build menus of varying complexity.
- Menu.kt
```kotlin
class Menu(private val name: String, private val menuComponents: MutableList<MenuComponent> = mutableListOf()) : MenuComponent {
  fun add(component: MenuComponent) {
    menuComponents.add(component)
  }

  fun remove(component: MenuComponent) {
    menuComponents.remove(component)
  }

  override fun display(): String {
    return menuComponents.joinToString("\n") { it.display() }
  }
}
```


# Conclusion:
In conclusion, the use of the Adapter, Facade, Decorator, and Composite design patterns in our recipe app has significantly improved its architecture and maintainability.

The Adapter pattern enabled our MenuManager to work seamlessly with the MenuDisplay interface, enhancing the flexibility of our code. This means our app can now work with any class that implements the MenuDisplay interface, not just MenuManager.

The Facade pattern simplified the interaction with the App class, making it easier to understand and use. This reduced the complexity of our app and made it more user-friendly.

The Decorator pattern adds additional features to our recipes without modifying the Recipe class. This would allow for greater flexibility and extensibility in managing recipes.

The Composite pattern allowed us to build complex menu structures with ease. This made our MenuManager more powerful and flexible, as it can now handle menus of varying complexity.

Overall, these design patterns have made our recipe app more robust, flexible, and maintainable. They've allowed me to write code that's easier to understand, modify, and extend, which is a key aspect of good software design.