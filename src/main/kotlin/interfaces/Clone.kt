package interfaces

import models.Recipe

interface Clone {
    fun clone() : Recipe
}