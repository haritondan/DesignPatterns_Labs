package app

import interfaces.Action
import interfaces.MenuDisplay
import user.UserInputHandler

class App(private val actions: List<Action>, private val menuDisplay: MenuDisplay, private val userInput: UserInputHandler) {
    fun start() {
        var running = true
        while (running) {
            menuDisplay.display()
            val choice = userInput.promptForChoice() - 1
            if (choice in actions.indices) {
                actions[choice].execute()
            } else if (choice == actions.size) {
                running = false
            } else {
                println("Invalid choice. Please try again.")
            }
        }
    }
}




