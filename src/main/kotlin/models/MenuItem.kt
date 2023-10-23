package models

import interfaces.MenuComponent

class MenuItem(private val name: String, private val number: Int) : MenuComponent {
    override fun display() = "$number. $name"
}