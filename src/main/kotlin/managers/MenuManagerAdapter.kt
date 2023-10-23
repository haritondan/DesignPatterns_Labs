package managers

import interfaces.MenuDisplay

class MenuManagerAdapter(private val menuManager: MenuManager) : MenuDisplay {
    override fun display() {
        menuManager.displayMenu()
    }
}