package com.fighter.pizza.screens.pizza

data class PizzaUiState(
    val breads: List<Int> = emptyList(),
    val ingredients: List<Int> = emptyList(),
    val singleIngredient:List<Int> = emptyList()
)