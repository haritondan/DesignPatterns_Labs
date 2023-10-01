package models

abstract class AbstractIngredient(
    open val name: String,
    open val quantity: String,
)
data class Ingredient(
    override var name: String,
    override var quantity: String,
): AbstractIngredient(name,quantity)