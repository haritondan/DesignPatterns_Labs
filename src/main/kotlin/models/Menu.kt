package models

import interfaces.MenuComponent

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