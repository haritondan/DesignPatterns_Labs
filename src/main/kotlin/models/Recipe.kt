package models

open class Recipe (
    open val title: String,
    open val description: String,
    open val ingredients: MutableList<Ingredient>,
    open val steps: MutableList<String>,
    open val type: String = "No Type Specified"
    )
